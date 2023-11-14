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
     */

    private fun setup() {
        val buttonRegister = findViewById<Button>(R.id.buttonRegister)
        val radioGroupTipo = findViewById<RadioGroup>(R.id.radioGroupTipo)
        val spinner: Spinner = findViewById(R.id.spinnerUbicaciones)

        ArrayAdapter.createFromResource(
            this,
            R.array.ubicaciones_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }

        spinner.onItemSelectedListener = this

        // Establecer el título de la actividad
        title = "Registro"
        buttonRegister.setOnClickListener {
            val editTextUser = findViewById<EditText>(R.id.editTextUser)
            val editTextEmail = findViewById<EditText>(R.id.editTextEmail)
            val editTextPassword = findViewById<EditText>(R.id.editTextPassword)
            val retrofitService = RetrofitService()
            val usuarioApi = retrofitService.getRetrofit().create(UsuarioApi::class.java)


            buttonRegister.setOnClickListener { view ->
                var name = editTextUser.text.toString()
                var correo = editTextEmail.text.toString()
                var tipo = when (radioGroupTipo.checkedRadioButtonId) {
                    R.id.empleadoButton -> "empleado"
                    R.id.conductorButton -> "conductor"
                    else -> ""
                }
                var password = editTextPassword.text.toString()

                var ubicacion = spinner.selectedItem.toString()

                val usuario = Usuario(name, correo, tipo, ubicacion, password)


                usuarioApi.save(usuario).enqueue(object : Callback<Usuario> {
                    override fun onResponse(call: Call<Usuario>, response: Response<Usuario>) {
                        Toast.makeText(this@register, "Save successful!", Toast.LENGTH_SHORT).show()
                        showHome(
                            correo,
                            ProviderType.BASIC
                        )
                    }

                    override fun onFailure(call: Call<Usuario>, t: Throwable) {
                        Toast.makeText(this@register, "Save failed!!", Toast.LENGTH_SHORT).show()
                        Logger.getLogger(register::class.java.name)
                            .log(Level.SEVERE, "Error occurred", t)
                    }
                })


                /*
                if (editTextEmail.text.isNotEmpty() && editTextPassword.text.isNotEmpty()) {

                    // Intentar registrar al usuario con Firebase
                    FirebaseAuth.getInstance()
                        .createUserWithEmailAndPassword(
                            editTextEmail.text.toString(),
                            editTextPassword.text.toString()
                        ).addOnCompleteListener { task ->
                            if (task.isSuccessful) {
                                // Registro exitoso
                                showHome(
                                    task.result?.user?.email ?: "",
                                    ProviderType.BASIC
                                )
                            } else {
                                // Manejar fallos en el registro
                                showAlert()
                            }
                        }
                } else {
                    // Manejar el caso en el que los campos de correo electrónico y contraseña estén vacíos
                    Toast.makeText(
                        this@register,
                        "Por favor, completa todos los campos.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                */
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

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        val selectedItem = parent?.getItemAtPosition(position).toString()
        // Haz algo con el elemento seleccionado
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        // Haz algo cuando no se selecciona ningún elemento
    }

}





