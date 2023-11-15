package com.example.carpooling
import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.carpooling.mi_perfil.Mi_perfil_conductor
import com.example.carpooling.mi_perfil.Mi_perfil_empleado
import com.example.model.Usuario
import com.example.retrofit.RetrofitService
import com.example.retrofit.UsuarioApi
import com.google.android.play.integrity.internal.t
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.auth.FirebaseAuth
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.logging.Level
import java.util.logging.Logger

/**
 * Clase que representa la actividad de inicio de sesión.
 */

class log_in : AppCompatActivity() {
    /**
     * Método llamado cuando se crea la actividad.
     *
     * @param savedInstanceState Objeto que contiene datos que pueden ser útiles para
     *                           reconstruir el estado de la actividad en caso de recreación.
     */
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)

        // Inicializar Firebase Analytics
        val analytics: FirebaseAnalytics = FirebaseAnalytics.getInstance(this)
        val bundle = Bundle()
        bundle.putString("message", "Integración de Firebase completa")
        analytics.logEvent("InitScreen", bundle)

        // Configurar la interfaz de usuario
        setup()
    }

    /**
     * Método utilizado para configurar la interfaz de usuario y manejar eventos.
     */
    /**
     * Configura la interfaz de usuario y la lógica de la actividad de inicio de sesión.
     *
     * Este método establece el título de la actividad y configura un listener para el botón de inicio
     * de sesión, donde se maneja la lógica de autenticación del usuario.
     */
    private fun setup() {
        // Obtener referencia al botón de inicio de sesión
        val buttonRegister = findViewById<Button>(R.id.buttonlog_in)

        // Establecer el título de la actividad
        title = "log_in"

        // Configurar el listener para el botón de inicio de sesión
        buttonRegister.setOnClickListener {

            // Obtener referencias a los campos de correo electrónico y contraseña
            val editTextEmail = findViewById<EditText>(R.id.editTextEmail)
            val editTextPassword = findViewById<EditText>(R.id.editTextPassword)

            // Crear instancia de RetrofitService y UsuarioApi
            val retrofitService = RetrofitService()
            val usuarioApi = retrofitService.getRetrofit().create(UsuarioApi::class.java)

            // Configurar el listener para el clic del botón de inicio de sesión
            buttonRegister.setOnClickListener { view ->

                // Obtener el correo electrónico y la contraseña ingresados por el usuario
                var correo = editTextEmail.text.toString()
                var password = editTextPassword.text.toString()

                // Enviar la solicitud de inicio de sesión al servidor
                usuarioApi.getUsuario(correo, password).enqueue(object : Callback<Usuario> {
                    override fun onResponse(call: Call<Usuario>, response: Response<Usuario>) {

                        // Manejar la respuesta exitosa del servidor
                        val usuario = response.body()
                        if (usuario != null) {

                            // Mostrar mensaje de inicio de sesión exitoso
                            Toast.makeText(this@log_in, "Login successful!", Toast.LENGTH_SHORT).show()

                            // Determinar el tipo de usuario y mostrar la pantalla correspondiente
                            if (usuario.tipo == "empleado") {
                                val intent = Intent(this@log_in, vista_principal::class.java)
                                intent.putExtra("email", usuario.correo)
                                intent.putExtra("nombre", usuario.name)
                                intent.putExtra("calificacion", usuario.calificacion)
                                startActivity(intent)
                            } else if (usuario.tipo == "conductor") {
                                val intent = Intent(this@log_in, vista_principal_conductor::class.java)
                                intent.putExtra("email", usuario.correo)
                                intent.putExtra("nombre", usuario.name)
                                intent.putExtra("calificacion", usuario.calificacion)
                                startActivity(intent)
                            } else {
                                val intent = Intent(this@log_in, vista_principal::class.java)
                                intent.putExtra("email", usuario.correo)
                                intent.putExtra("nombre", usuario.name)
                                intent.putExtra("calificacion", usuario.calificacion)
                                startActivity(intent)
                            }
                        }
                    }

                    override fun onFailure(call: Call<Usuario>, t: Throwable) {
                        // Manejar el fallo en la autenticación
                        Toast.makeText(
                            this@log_in,
                            "Correo o contraseña incorrectos",
                            Toast.LENGTH_SHORT
                        ).show()

                        // Registrar el error en el sistema de registro
                        Logger.getLogger(log_in::class.java.name)
                            .log(Level.SEVERE, "Error occurred", t)
                    }
                })
            }
        }
    }

    /**
     * Método utilizado para mostrar un cuadro de diálogo de alerta en caso de fallo en el inicio de sesión.
     */
    private fun showAlert() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setMessage("Se ha producido un error autenticando al usuario")
        builder.setPositiveButton("Aceptar", null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }


}
