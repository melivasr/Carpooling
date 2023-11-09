package com.example.carpooling
import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class log_in : AppCompatActivity() {
    var user: EditText? = null
    var pass: EditText? = null
    var buttonlogin: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)

        user = findViewById(R.id.editTextEmail)
        pass = findViewById(R.id.editTextPassword)
        buttonlogin = findViewById(R.id.buttonlog_in)

        buttonlogin?.setOnClickListener {
            // Obtener el usuario y contraseña ingresados
            val userEmail = user?.text.toString()
            val userPassword = pass?.text.toString()

            // Realizar la verificación del usuario (aquí debes implementar tu lógica)
            if (verificarUsuario(userEmail, userPassword)) {
                // Abrir la actividad VentanaPrincipal
                val intent = Intent(this, vista_principal::class.java)
                startActivity(intent)
            } else {
                // Mostrar mensaje de error si no se encontró el usuario
                Toast.makeText(this, "Usuario no encontrado", Toast.LENGTH_SHORT).show()
            }
        }
    }

    // Esta función simula la verificación del usuario (debes implementar la lógica real)
    private fun verificarUsuario(email: String, password: String): Boolean {
        // Aquí debes realizar la búsqueda en tu base de datos o en tus registros de usuarios
        // para verificar si el usuario y contraseña coinciden.
        // Devuelve true si el usuario existe y la contraseña es correcta, de lo contrario, devuelve false.
        return false // Cambia esto con tu lógica de verificación real
    }
}
