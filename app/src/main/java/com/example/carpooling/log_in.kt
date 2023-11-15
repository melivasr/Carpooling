package com.example.carpooling
import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
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
    private fun setup() {
        val buttonRegister = findViewById<Button>(R.id.buttonlog_in)

        // Establecer el título de la actividad
        title = "log_in"
        buttonRegister.setOnClickListener {
            val editTextEmail = findViewById<EditText>(R.id.editTextEmail)
            val editTextPassword = findViewById<EditText>(R.id.editTextPassword)

            val retrofitService = RetrofitService()
            val usuarioApi = retrofitService.getRetrofit().create(UsuarioApi::class.java)


            buttonRegister.setOnClickListener { view ->
                var correo = editTextEmail.text.toString()
                var password = editTextPassword.text.toString()


                usuarioApi.getUsuario(correo, password).enqueue(object : Callback<Usuario> {
                    override fun onResponse(call: Call<Usuario>, response: Response<Usuario>) {
                        val usuario = response.body()
                        if (usuario != null) {
                            Toast.makeText(this@log_in, "Login successful!", Toast.LENGTH_SHORT).show()
                            if (usuario.tipo == "empleado") {
                                showHome(correo, ProviderType.BASIC)
                            } else if (usuario.tipo == "conductor") {
                                showHomeConductor(correo, ProviderType.BASIC)
                            }else{
                                showHome(correo, ProviderType.BASIC)
                            }
                        }
                    }

                    override fun onFailure(call: Call<Usuario>, t: Throwable) {
                        Toast.makeText(this@log_in, "Correo o contraseña incorrectos", Toast.LENGTH_SHORT).show()
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

    /**
     * Método utilizado para mostrar la actividad principal después de un inicio de sesión exitoso.
     *
     * @param email    Dirección de correo electrónico del usuario autenticado.
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


}
