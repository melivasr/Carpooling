package com.example.carpooling

import com.example.model.Usuario
import android.annotation.SuppressLint
import android.content.ContentProvider
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.retrofit.RetrofitService
import com.example.retrofit.UsuarioApi
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.auth.FirebaseAuth
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.logging.Level
import java.util.logging.Logger

/**
 * Clase que representa la actividad de registro de usuarios.
 *
 * Esta actividad permite a los usuarios registrarse proporcionando información como nombre, correo
 * electrónico, tipo de usuario, contraseña, ubicación y calificación.
 */
class register : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    /**
     * Método llamado cuando se crea la actividad.
     *
     * @param savedInstanceState Objeto que contiene datos que pueden ser útiles para
     *                           reconstruir el estado de la actividad en caso de recreación.
     */
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        // Inicializar Firebase Analytics
        val analytics: FirebaseAnalytics = FirebaseAnalytics.getInstance(this)
        val bundle = Bundle()
        bundle.putString("message", "Integración de Firebase completa")
        analytics.logEvent("InitScreen", bundle)

        // Configuración
        setup()
    }

    /**
     * Método utilizado para configurar la interfaz de usuario y manejar eventos.
     *
     * Se configuran elementos como el botón de registro, el grupo de radio para el tipo de usuario,
     * y un spinner para seleccionar la ubicación. Además, se manejan los eventos del botón de
     * registro para enviar la información del usuario al servidor.
     */

    private fun setup() {
        // Obtener referencias a elementos de la interfaz de usuario

        val buttonRegister = findViewById<Button>(R.id.buttonRegister)
        val radioGroupTipo = findViewById<RadioGroup>(R.id.radioGroupTipo)
        val spinner: Spinner = findViewById(R.id.spinnerUbicaciones)

        // Configurar el adaptador y el contenido del spinner desde un array de recursos
        ArrayAdapter.createFromResource(
            this,
            R.array.ubicaciones_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }
        // Configurar el listener para eventos de selección del spinner
        spinner.onItemSelectedListener = this

        // Establecer el título de la actividad
        title = "Registro"

        // Configurar el listener para el clic del botón de registro
        buttonRegister.setOnClickListener {

            // Obtener referencias a campos de entrada de texto
            val editTextUser = findViewById<EditText>(R.id.editTextUser)
            val editTextEmail = findViewById<EditText>(R.id.editTextEmail)
            val editTextPassword = findViewById<EditText>(R.id.editTextPassword)

            // Crear instancia de RetrofitService y UsuarioApi
            val retrofitService = RetrofitService()
            val usuarioApi = retrofitService.getRetrofit().create(UsuarioApi::class.java)

            // Configurar el listener para el clic del botón de registro
            buttonRegister.setOnClickListener { view ->

                // Obtener valores ingresados por el usuario
                var name = editTextUser.text.toString()
                var correo = editTextEmail.text.toString()

                // Determinar el tipo de usuario seleccionado en el grupo de radio
                var tipo = when (radioGroupTipo.checkedRadioButtonId) {
                    R.id.empleadoButton -> "empleado"
                    R.id.conductorButton -> "conductor"
                    else -> ""
                }
                var password = editTextPassword.text.toString()

                // Obtener la ubicación seleccionada en el spinner
                var ubicacion = spinner.selectedItem.toString()

                // Calificación inicial
                var calificacion = "5"

                // Crear un objeto Usuario con la información ingresada
                val usuario = Usuario(name, correo, tipo, ubicacion, password, calificacion)



                // Enviar la solicitud de registro al servidor
                usuarioApi.save(usuario).enqueue(object : Callback<Usuario> {
                    override fun onResponse(call: Call<Usuario>, response: Response<Usuario>) {

                        // Manejar la respuesta exitosa del servidor
                        val usuario = response.body()
                        if (usuario != null) {

                            // Mostrar mensaje de registro exitoso y navegar a la pantalla principal
                            Toast.makeText(this@register, "Save successful!", Toast.LENGTH_SHORT)
                                .show()
                            if (usuario.tipo == "empleado") {
                                val intent = Intent(this@register, vista_principal::class.java)
                                intent.putExtra("email", usuario.correo)
                                intent.putExtra("nombre", usuario.name)
                                intent.putExtra("calificacion", usuario.calificacion)
                                startActivity(intent)
                            } else if (usuario.tipo == "conductor") {
                                val intent =
                                    Intent(this@register, vista_principal_conductor::class.java)
                                intent.putExtra("email", usuario.correo)
                                intent.putExtra("nombre", usuario.name)
                                intent.putExtra("calificacion", usuario.calificacion)
                                startActivity(intent)
                            } else {
                                val intent = Intent(this@register, vista_principal::class.java)
                                intent.putExtra("email", usuario.correo)
                                intent.putExtra("nombre", usuario.name)
                                intent.putExtra("calificacion", usuario.calificacion)
                                startActivity(intent)
                            }
                        }
                    }

                    override fun onFailure(call: Call<Usuario>, t: Throwable) {

                        // Manejar el fallo en el registro y registrar el error
                        Toast.makeText(this@register, "Save failed!!", Toast.LENGTH_SHORT).show()
                        Logger.getLogger(register::class.java.name)
                            .log(Level.SEVERE, "Error occurred", t)
                    }
                })

               }
        }
    }

    /**
     * Método utilizado para mostrar un cuadro de diálogo de alerta en caso de fallo en el registro.
     */
    private fun showAlert() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setMessage("Se ha producido un error autenticando al usuario")
        builder.setPositiveButton("Aceptar", null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }

    /**
     * Método utilizado para mostrar la actividad principal después de un registro exitoso.
     *
     * @param email    Dirección de correo electrónico del usuario registrado.
     * @param provider Tipo de proveedor de autenticación utilizado.
     */
    private fun showHome(email: String, provider: ProviderType) {
        val homeIntent = Intent(this, vista_principal::class.java).apply {
            putExtra("email", email)
            putExtra("provider", provider.name)
        }
        startActivity(homeIntent)
    }

    private fun showHomeConductor(email: String, provider: ProviderType) {
        val homeIntent = Intent(this, vista_principal_conductor::class.java).apply {
            putExtra("email", email)
            putExtra("provider", provider.name)
        }
        startActivity(homeIntent)
    }

    // Implementación del método del listener del spinner para eventos de selección
    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        // Acciones a realizar cuando se selecciona un elemento en el spinner
        val selectedItem = parent?.getItemAtPosition(position).toString()
        // Haz algo con el elemento seleccionado
    }
    // Implementación del método del listener del spinner para eventos de deselección
    override fun onNothingSelected(parent: AdapterView<*>?) {
        // Acciones a realizar cuando no hay elementos seleccionados en el spinner

    }

}





