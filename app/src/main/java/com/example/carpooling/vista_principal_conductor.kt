package com.example.carpooling

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.example.carpooling.Amigos.Amigos
import com.example.carpooling.calificaciones.calificaciones
import com.example.carpooling.mi_perfil.Mi_perfil_conductor
import com.example.carpooling.mi_perfil.Mi_perfil_empleado
import com.example.carpooling.viajeEmpleados.ViajeEmpleadosConductor
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.navigation.NavigationView

class vista_principal_conductor : AppCompatActivity(),NavigationView.OnNavigationItemSelectedListener {
    private lateinit var drawer:DrawerLayout
    private lateinit var toggle:ActionBarDrawerToggle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vista_principal_conductor)

        //setup
        val bundle:Bundle? = intent.extras
        val email: String? = bundle?.getString("email")
        val provider: String? = bundle?.getString("provider")
        setup(email?:"",provider?:"")


        val botonShow: Button = findViewById(R.id.botonShow)
        botonShow.setOnClickListener {
            val ubicacion = intent.getStringExtra("ubicacion")
            val intent = Intent(this, ViajeEmpleadosConductor::class.java)
            intent.putExtra("ubicacion", ubicacion)
            startActivity(intent)
        }


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

    private fun setup(s: String, s1: String) {

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_item_one -> {
                Toast.makeText(this, "perfil", Toast.LENGTH_SHORT).show()
                abrirVentanaPerfil()
            }
            R.id.nav_item_two -> {
                Toast.makeText(this, "Historial", Toast.LENGTH_SHORT).show()
                // Puedes agregar lógica adicional para abrir otra actividad o realizar otras acciones aquí
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
        }
        drawer.closeDrawer(GravityCompat.START)
        return true
    }

    private fun abrirVentanaPerfil() {

        val nombre = intent.getStringExtra("nombre")
        val correo = intent.getStringExtra("email")
        val calificacion = intent.getStringExtra("calificacion")
        val ubicacion = intent.getStringExtra("ubicacion")

        val intent = Intent(this, Mi_perfil_conductor::class.java)

        intent.putExtra("email", correo)
        intent.putExtra("nombre",  nombre)
        intent.putExtra("calificacion", calificacion)
        intent.putExtra("ubicacion", ubicacion)

        startActivity(intent)


    }private fun abrirVentanaAmigos() {
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


    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        toggle.syncState()
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        toggle.onConfigurationChanged(newConfig)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)

    }


}