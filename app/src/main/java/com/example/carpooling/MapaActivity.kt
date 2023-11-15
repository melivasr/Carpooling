package com.example.carpooling

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions


class MapaActivity : AppCompatActivity(), OnMapReadyCallback {
    private lateinit var map: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.app_bar_main)
        createFragment()
    }

    private fun createFragment() {
        val mapFragment: SupportMapFragment =
            supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        map = googleMap
        createNewMarker(9.864918, -83.921971, "Banco ATM")
        createNewMarker(9.864078, -83.922054, "Clinica Dental")
        createNewMarker(9.863229, -83.922160, "Taco Bell")
        createNewMarker(9.862382, -83.922259, "MonkeyScrubs")
        createNewMarker(9.861526, -83.922366, "Funeraria San Jorge")
        createNewMarker(9.860691, -83.9224854, "Calle 4")

        createNewMarker(9.864825, -83.921121, "Burger King")
        createNewMarker(9.863936, -83.921206, "Calle 2")
        createNewMarker(9.863116, -83.921318, "Instituto Jimenez")
        createNewMarker(9.862263, -83.921426, "Farmacia CCSS")
        createNewMarker(9.861405, -83.921538, "Ópticas Visión")
        createNewMarker(9.860573, -83.921649, "Plaza Asís")

        createNewMarker(9.864693, -83.920226, "Subway")
        createNewMarker(9.863815, -83.920370, "Ruinas")
        createNewMarker(9.863009, -83.920478,"Banco BAC")
        createNewMarker(9.862152, -83.920604,"Laboratorio Clínico")
        createNewMarker(9.861309, -83.920730,"Calle 0")
        createNewMarker(9.860433, -83.920856,"Avenida 10")

        createNewMarker(9.864565, -83.919397,"Cartago Centro")
        createNewMarker(9.863726, -83.919513,"Caja ANDE")
        createNewMarker(9.862900, -83.919614,"Pops")
        createNewMarker(9.862036, -83.919741,"Avenida 6")
        createNewMarker(9.861188, -83.919840,"Barber Shop")
        createNewMarker(9.860309, -83.919966,"Coco Catering")

        createNewMarker(9.864456, -83.918536,"Rosti")
        createNewMarker(9.863592, -83.918644,"Soda Il Fratello")
        createNewMarker(9.862782, -83.918744,"Psico&Yoga Centro de Salud Integral")
        createNewMarker(9.861924, -83.918865,"Bufete Cohghi Sanabria")
        createNewMarker(9.861069, -83.918989,"Panadería Bruma")

        createNewMarker(9.864321, -83.917638,"CoopeAnde")
        createNewMarker(9.863467, -83.917733,"Café T'Ando")
        createNewMarker(9.862657, -83.917827,"La canela")
        createNewMarker(9.861787, -83.917926,"CredeCoop R.L.")
        createNewMarker(9.860924, -83.918031,"OFICSEVI")
        createNewMarker(9.860024, -83.918126,"Pizzeria Villa Italia")

        createNewMarker(9.864167, -83.916575,"Bakery Esau")
        createNewMarker(9.863346, -83.916683,"Hodgson's")
        createNewMarker(9.862493, -83.916824,"Transtusa")
        createNewMarker(9.861650, -83.916913,"Sara Studio")
        createNewMarker(9.860803, -83.917055,"Pollos Bro's")
        createNewMarker(9.859879, -83.917185,"Bar La Nave")

        createNewMarker(9.861511, -83.916011,"Boutique Café")
        createNewMarker(9.860663, -83.916156,"Antiguo Matadero")
        createNewMarker(9.859744, -83.916319,"Panadería Su")

        createNewMarker(9.864031, -83.915290,"CoopeMep")
        createNewMarker(9.863127, -83.915428,"CAFLIFE")
        createNewMarker(9.862313, -83.915518,"Grupo Decobaño")
        createNewMarker(9.861462, -83.915646,"Clínica Dental OdontoIntegral")
        createNewMarker(9.860622, -83.915719,"GVI")
        createNewMarker(9.859676, -83.915746,"Plaza la soledad")

    }

    fun resizeBitmap(drawableName: String, width: Int, height: Int): Bitmap {
        val imageBitmap = BitmapFactory.decodeResource(
            resources,
            resources.getIdentifier(drawableName, "drawable", packageName)
        )
        return Bitmap.createScaledBitmap(imageBitmap, width, height, false)
    }

    private fun createNewMarker(Lat: Double, Lng: Double, nombre: String) {
        val coordinates = LatLng(Lat, Lng)
        val markerIcon = BitmapDescriptorFactory.fromBitmap(resizeBitmap("marcador", 25, 25))
        map.addMarker(MarkerOptions().position(coordinates).title(nombre).icon(markerIcon))
    }

}