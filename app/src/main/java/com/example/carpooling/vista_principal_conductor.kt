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
import com.example.carpooling.Amigos.AnadirAmigosConductor
import com.example.carpooling.calificaciones.calificaciones
import com.example.carpooling.mi_perfil.Mi_perfil_conductor
import com.example.carpooling.viajeEmpleados.ViajeEmpleadosConductor
import com.example.carpooling.viajeAmigos.ViajeAmigosConductor
import com.example.carpooling.viajeEmpleados.MostrarRutayETA
import com.google.android.material.navigation.NavigationView
/**
 * Actividad principal para el rol de conductor con funcionalidades de navegación.
 */
class vista_principal_conductor : AppCompatActivity(),NavigationView.OnNavigationItemSelectedListener {
    private lateinit var drawer:DrawerLayout
    private lateinit var toggle:ActionBarDrawerToggle
    /**
     * Método llamado cuando la actividad se crea.
     *
     * @param savedInstanceState Datos que pueden ser utilizados para restablecer el estado de la actividad.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vista_principal_conductor)

        // Configuración inicial
        val bundle:Bundle? = intent.extras
        val email: String? = bundle?.getString("email")
        val provider: String? = bundle?.getString("provider")
        setup(email?:"",provider?:"")

        // Configurar el nuevo botón para abrir las ventanas "ViajeEmpleadosConductor" y "ViajeAmigosConductor"
        val botonShow: Button = findViewById(R.id.botonShow)
        botonShow.setOnClickListener {
            val ubicacion = intent.getStringExtra("ubicacion")
            val intent = Intent(this@vista_principal_conductor, ViajeEmpleadosConductor::class.java)
            intent.putExtra("ubicacion", ubicacion)
            val intent2 = Intent(this@vista_principal_conductor, ViajeAmigosConductor::class.java)
            intent2.putExtra("ubicacion", ubicacion)
            startActivity(intent)
            startActivity(intent2)
        }
        // Configurar el nuevo botón para abrir la ventana "MostrarRutayETA"
        val botonRutayETA: Button = findViewById(R.id.botonRutayEta)
        botonRutayETA.setOnClickListener {

            val ubicacion = intent.getStringExtra("ubicacion")
            val intentUsuario = Intent(this@vista_principal_conductor, MostrarRutayETA::class.java)
            intent.putExtra("ubicacion", ubicacion)
            startActivity(intentUsuario)
        }


        // Configurar la barra de herramientas y la navegación lateral
        val toolbar: Toolbar = findViewById(R.id.toolbar_main)
        setSupportActionBar(toolbar)

        drawer = findViewById(R.id.drawer_layoud)

        toggle = ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)

        drawer.addDrawerListener(toggle)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)


        val navigationView: NavigationView = findViewById(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener(this)

    }
    /**
     * Configuración inicial de la actividad.
     */
    private fun setup(s: String, s1: String) {
        // Puedes agregar lógica de configuración adicional aquí según sea necesario

    }
    /**
     * Método llamado cuando se selecciona un elemento en el menú de navegación.
     *
     * @param item Elemento seleccionado.
     * @return `true` si el evento fue manejado con éxito.
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
    /**
     * Abre la ventana de agregar amigos.
     */
    private fun abrirVentanaAnadirAmigos() {
        val intent = Intent(this, AnadirAmigosConductor::class.java)
        startActivity(intent)
    }
    /**
     * Abre la ventana de perfil.
     */
    private fun abrirVentanaPerfil() {

        val nombre = intent.getStringExtra("nombre")
        val correo = intent.getStringExtra("email")
        val calificacion = intent.getStringExtra("calificacion")
        val ubicacion = intent.getStringExtra("ubicacion")

        val intent = Intent(this@vista_principal_conductor, Mi_perfil_conductor::class.java)

        intent.putExtra("email", correo)
        intent.putExtra("nombre",  nombre)
        intent.putExtra("calificacion", calificacion)
        intent.putExtra("ubicacion", ubicacion)

        startActivity(intent)

        /**
         * Abre la ventana de amigos.
         */
    }private fun abrirVentanaAmigos() {
        // Crear un Intent para abrir la actividad de Amigos
        val intent = Intent(this@vista_principal_conductor, Amigos::class.java)
        startActivity(intent)
    }
    /**
     * Abre la ventana de calificaciones.
     */
    private fun abrirVentanacalificaciones() {
        val nombre = intent.getStringExtra("nombre")
        val correo = intent.getStringExtra("email")
        val calificacion = intent.getStringExtra("calificacion")
        val ubicacion = intent.getStringExtra("ubicacion")

        val intent = Intent(this@vista_principal_conductor, calificaciones::class.java)

        intent.putExtra("email", correo)
        intent.putExtra("nombre", nombre)
        intent.putExtra("calificacion", calificacion)
        intent.putExtra("ubicacion", ubicacion)
        startActivity(intent)}

    /**
     * Método llamado después de que la actividad se ha creado, para sincronizar el estado del botón del cajón de navegación.
     *
     * @param savedInstanceState Datos que pueden ser utilizados para restablecer el estado de la actividad.
     */
    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        toggle.syncState()
    }
    /**
     * Método llamado cuando se produce un cambio en la configuración.
     *
     * @param newConfig Nueva configuración después del cambio.
     */
    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        toggle.onConfigurationChanged(newConfig)
    }
    /**
     * Método llamado cuando se selecciona un elemento del menú de opciones.
     *
     * @param item Elemento seleccionado.
     * @return `true` si el evento fue manejado con éxito.
     */
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)

    }


}