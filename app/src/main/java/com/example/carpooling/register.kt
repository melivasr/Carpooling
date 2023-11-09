package com.example.carpooling
import Usuario
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import base_de_datos.daoUsuario
/**
 * Esta actividad permite a los usuarios registrarse en la aplicación.
 * Los datos de registro se almacenan en una base de datos SQLite.
 */
class register : AppCompatActivity() {
    private var userName: EditText? = null
    private var userApellido: EditText? = null
    private var userEmail: EditText? = null
    private var userPassword: EditText? = null
    private var buttonRegister: Button? = null
    private var daoUsuario: daoUsuario? = null

    /**
     * Se llama cuando se crea la actividad. Aquí se inicializan las vistas y se configuran los eventos.
     *
     * @param savedInstanceState El estado anterior de la actividad, si existe.
     */
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        // Inicialización de vistas
        userName = findViewById(R.id.editTextUser)
        userApellido = findViewById(R.id.editTextApellido)
        userEmail = findViewById(R.id.editTextEmail)
        userPassword = findViewById(R.id.editTextPassword)
        buttonRegister = findViewById(R.id.buttonRegister)

        buttonRegister?.setOnClickListener {
            val userFullName = userName?.text.toString()
            val userApellidos = userApellido?.text.toString()
            val userEmail = userEmail?.text.toString()
            val userPassword = userPassword?.text.toString()

            // Inicializa la instancia de la base de datos justo antes de usarla
            daoUsuario = daoUsuario(this)

            try {
                if (daoUsuario?.buscar(userEmail) == 0) {
                    val newUser = Usuario(
                        usuario = userFullName,
                        apellidos = userApellidos,
                        correoElectronico = userEmail,
                        password = userPassword
                    )

                    // Intenta insertar un nuevo usuario en la base de datos
                    if (daoUsuario?.insertUsuario(newUser) == true) {
                        mostrarMensaje("Registro exitoso")
                        val intent = Intent(this, vista_principal::class.java)
                        startActivity(intent)
                    } else {
                        mostrarMensaje("Error durante el registro")
                    }
                } else {
                    mostrarMensaje("El usuario ya existe")
                }
            } catch (e: Exception) {
                e.printStackTrace()
                mostrarMensaje("Error inesperado")
            }
        }
    }

    /**
     * Muestra un mensaje en forma de Toast.
     *
     * @param mensaje El mensaje que se mostrará.
     */
    private fun mostrarMensaje(mensaje: String) {
        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show()
    }
}
