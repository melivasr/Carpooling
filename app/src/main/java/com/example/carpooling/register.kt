package com.example.carpooling
import android.annotation.SuppressLint
import android.content.ContentProvider
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.auth.FirebaseAuth

/**
 * Clase que representa la actividad de registro de usuarios.
 */
class register : AppCompatActivity() {
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

        // Establecer el título de la actividad
        title = "Registro"
        buttonRegister.setOnClickListener {
            val editTextEmail = findViewById<EditText>(R.id.editTextEmail)
            val editTextPassword = findViewById<EditText>(R.id.editTextPassword)

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
}
