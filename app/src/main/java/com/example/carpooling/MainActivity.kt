package com.example.carpooling

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.firebase.analytics.FirebaseAnalytics
/**
 * Actividad principal de la aplicación.
 *
 * Esta actividad muestra un diseño simple con dos botones: uno para iniciar sesión y otro para
 * registrarse. Al hacer clic en los botones, se inician las actividades correspondientes.
 */
class MainActivity : AppCompatActivity() {

    /**
     * Método llamado cuando se crea la actividad.
     *
     * Configura la interfaz de usuario y establece listeners para los botones de inicio de sesión
     * y registro.
     *
     * @param savedInstanceState Estado previamente guardado de la actividad.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Configurar el botón para iniciar sesión
        val btn: Button = findViewById(R.id.button)
        btn.setOnClickListener {
            // Iniciar la actividad de inicio de sesión al hacer clic en el botón
            val intent : Intent = Intent(this , log_in::class.java)
            startActivity(intent)
        }

        // Configurar el botón para registrarse
        val btn2: Button = findViewById(R.id.button2)
        btn2.setOnClickListener {
            // Iniciar la actividad de registro al hacer clic en el botón
            val intent : Intent = Intent(this , register::class.java)
            startActivity(intent)

            // Integración de Firebase Analytics: registrar evento de inicio de pantalla
            val analytics: FirebaseAnalytics = FirebaseAnalytics.getInstance(this)
            val bundle =Bundle()
            bundle.putString("message","Integración de Firabase completa")
            analytics.logEvent("InitScreen",bundle)
        }
    }
}

