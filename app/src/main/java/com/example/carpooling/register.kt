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
            val ubicacionesMap = mapOf(
                "Banco ATM" to "0",
                "Clinica Dental" to "1",
                "Taco Bell" to "2",
                "MonkeyScrubs" to "3",
                "Funeraria San Jorge" to "4",
                "Calle 4" to "5",
                "Burger King" to "6",
                "Calle 2" to "7",
                "Instituto Jimenez" to "8",
                "Farmacia CCSS" to "9",
                "Ópticas Visión" to "10",
                "Plaza Asís" to "11",
                "Subway" to "12",
                "Ruinas" to "13",
                "Banco BAC" to "14",
                "Laboratorio Clínico" to "15",
                "Calle 0" to "16",
                "Avenida 10" to "17",
                "Cartago Centro" to "18",
                "Caja ANDE" to "19",
                "Pops" to "20",
                "Avenida 6" to "21",
                "Barber Shop" to "22",
                "Coco Catering" to "23",
                "Rosti" to "24",
                "Soda Il Fratello" to "25",
                "Psico&Yoga Centro de Salud Integral" to "26",
                "Bufete Cohghi Sanabria" to "27",
                "Panadería Bruma" to "28",
                "CoopeAnde" to "29",
                "Café T'Ando" to "30",
                "La canela" to "31",
                "CredeCoop R.L." to "32",
                "OFICSEVI" to "33",
                "Pizzeria Villa Italia" to "34",
                "Bakery Esau" to "35",
                "Hodgson's" to "36",
                "Transtusa" to "37",
                "Sara Studio" to "38",
                "Pollos Bro's" to "39",
                "Bar La Nave" to "40",
                "Boutique Café" to "41",
                "Antiguo Matadero" to "42",
                "Panadería Su" to "43",
                "CoopeMep" to "44",
                "CAFLIFE" to "45",
                "Grupo Decobaño" to "46",
                "Clínica Dental OdontoIntegral" to "47",
                "GVI" to "48",
                "Plaza la soledad" to "49"
            )

            buttonRegister.setOnClickListener { view ->
                var name = editTextUser.text.toString()
                var correo = editTextEmail.text.toString()
                var tipo = when (radioGroupTipo.checkedRadioButtonId) {
                    R.id.empleadoButton -> "empleado"
                    R.id.conductorButton -> "conductor"
                    else -> ""
                }
                var password = editTextPassword.text.toString()

                var ubicacionNombre = spinner.getItemAtPosition(spinner.selectedItemPosition).toString()
                var ubicacionId = ubicacionesMap[ubicacionNombre].toString()

                var calificacion = "5"

                val usuario = Usuario(name, correo, tipo,  ubicacionId, password, calificacion)




                usuarioApi.save(usuario).enqueue(object : Callback<Usuario> {
                    override fun onResponse(call: Call<Usuario>, response: Response<Usuario>) {
                        val usuario = response.body()
                        if (usuario != null) {
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

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        val selectedItem = parent?.getItemAtPosition(position).toString()
        // Haz algo con el elemento seleccionado
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        // Haz algo cuando no se selecciona ningún elemento
    }

}





