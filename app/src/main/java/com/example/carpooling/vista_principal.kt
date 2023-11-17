package com.example.carpooling

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.example.carpooling.Amigos.Amigos
import com.example.carpooling.Amigos.AnadirAmigos
import com.example.carpooling.calificaciones.calificaciones
import com.example.carpooling.mi_perfil.Mi_perfil_empleado
import com.example.carpooling.viajeEmpleados.ViajeEmpleados
import com.example.carpooling.viajeAmigos.ViajeAmigos
import com.google.android.material.navigation.NavigationView

/**
 * Clase que representa la actividad principal de la aplicación después del inicio de sesión.
 *
 * En esta actividad, se muestra una barra de herramientas (toolbar) con un menú deslizante (navigation drawer)
 * que proporciona acceso a diferentes secciones de la aplicación. También se presenta un botón que muestra
 * un cuadro de diálogo inferior al hacer clic.
 */
class vista_principal : AppCompatActivity(),NavigationView.OnNavigationItemSelectedListener {

    // Variables para el manejo del menú deslizante
    private lateinit var drawer:DrawerLayout
    private lateinit var toggle:ActionBarDrawerToggle

    /**
     * Método llamado cuando se crea la actividad.
     *
     * Configura la interfaz de usuario, incluida la barra de herramientas, el menú deslizante y el botón
     * que muestra un cuadro de diálogo inferior. Además, establece un listener para los elementos del menú.
     *
     * @param savedInstanceState Estado previamente guardado de la actividad.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vista_principal)

        // Obtener datos pasados desde la actividad anterior (si los hay)
        val bundle:Bundle? = intent.extras
        val email: String? = bundle?.getString("email")
        val provider: String? = bundle?.getString("provider")

        // Configurar la interfaz de usuario y la lógica
        setup(email?:"",provider?:"")

        // Configurar el botón que muestra un cuadro de diálogo inferior

        val botonShow: Button = findViewById(R.id.botonShow)
        botonShow.setOnClickListener {
            val correo = intent.getStringExtra("email")
            val ubicacion = intent.getStringExtra("ubicacion")

            val intent = Intent(this, ViajeEmpleados::class.java)

            intent.putExtra("email", correo)
            intent.putExtra("ubicacion", ubicacion)

            val intent2 = Intent(this, ViajeAmigos::class.java)

            intent2.putExtra("email", correo)
            intent2.putExtra("ubicacion", ubicacion)

            startActivity(intent)

            startActivity(intent2)
        }


        // Configurar la barra de herramientas y el menú deslizante
        val toolbar: Toolbar = findViewById(R.id.toolbar_main)
        setSupportActionBar(toolbar)

        drawer = findViewById(R.id.drawer_layoud)

        toggle = ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)

        drawer.addDrawerListener(toggle)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)

        // Configurar el listener para los elementos del menú deslizante
        val navigationView: NavigationView = findViewById(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener(this)

    }
    /**
     * Método utilizado para configurar la interfaz de usuario y manejar eventos.
     *
     * @param email Correo electrónico del usuario.
     * @param provider Proveedor de autenticación.
     */
    private fun setup(s: String, s1: String) {
        // Implementa la configuración según sea necesario (puedes añadir código aquí)
    }
    /**
     * Método llamado cuando se selecciona un elemento en el menú deslizante.
     *
     * @param item Elemento seleccionado.
     * @return `true` si se maneja correctamente el evento, `false` de lo contrario.
     */
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_item_one -> {
                Toast.makeText(this, "perfil", Toast.LENGTH_SHORT).show()
                abrirVentanaPerfil()
            }
            R.id.nav_item_three -> {
                Toast.makeText(this, "calificaciones", Toast.LENGTH_SHORT).show()
                abrirVentanacalificaciones()
                // Puedes agregar lógica adicional para abrir otra actividad o realizar otras acciones aquí
            }R.id.nav_item_four -> {
                Toast.makeText(this, "Amigos", Toast.LENGTH_SHORT).show()
                abrirVentanaAmigos()
                // Puedes agregar lógica adicional para abrir otra actividad o realizar otras acciones aquí
            }
            R.id.nav_item_five -> {
                Toast.makeText(this, "Añandir Amigos ", Toast.LENGTH_SHORT).show()
                abrirVentanaAnadirAmigos()
            }

        }
        drawer.closeDrawer(GravityCompat.START)
        return true
    }

    // Métodos para abrir diferentes ventanas (actividades)
    private fun abrirVentanaPerfil() {

        val nombre = intent.getStringExtra("nombre")
        val correo = intent.getStringExtra("email")
        val calificacion = intent.getStringExtra("calificacion")
        val ubicacion = intent.getStringExtra("ubicacion")

        val intent = Intent(this, Mi_perfil_empleado::class.java)

        intent.putExtra("email", correo)
        intent.putExtra("nombre", nombre)
        intent.putExtra("calificacion", calificacion)
        intent.putExtra("ubicacion", ubicacion)
        startActivity(intent)

    }

    private fun abrirVentanaAmigos() {
        // Crear un Intent para abrir la actividad de Amigos
        val intent = Intent(this, Amigos::class.java)
        startActivity(intent)
    }
    private fun abrirVentanacalificaciones() {
        // Crear un Intent para abrir la actividad de Amigos
        val intent = Intent(this, calificaciones::class.java)
        startActivity(intent)
    }private fun abrirVentanacaHistorial() {
        // Crear un Intent para abrir la actividad de Amigos
        val intent = Intent(this, calificaciones::class.java)
        startActivity(intent)
    }
    private fun abrirVentanaAnadirAmigos() {
        // Crear un Intent para abrir la actividad de Amigos
        val intent = Intent(this, AnadirAmigos::class.java)
        startActivity(intent)
    }

    /**
     * Método llamado después de que la actividad ha sido creada.
     * Sincroniza el estado del toggle.
     */
    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        toggle.syncState()
    }
    /**
     * Método llamado cuando cambia la configuración del dispositivo.
     *
     * @param newConfig Nueva configuración.
     */
    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        toggle.onConfigurationChanged(newConfig)
    }
    /**
     * Método llamado cuando se selecciona un elemento del menú de opciones de la barra de herramientas.
     *
     * @param item Elemento seleccionado.
     * @return `true` si se maneja correctamente el evento, `false` de lo contrario.
     */
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Maneja eventos de la barra de herramientas (toggle)
        if(toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)

    }


}