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
        createMarker1()
        createMarker2()
        createMarker3()
        createMarker4()
        createMarker5()
        createMarker6()
        createMarker7()
        createMarker8()
        createMarker9()
        createMarker10()
        createMarker11()
        createMarker12()
        createMarker13()
        createMarker14()
        createMarker15()
        createMarker16()
        createMarker17()
        createMarker18()
        createMarker19()
        createMarker20()
        createMarker21()
        createMarker22()
        createMarker23()
        createNewMarker(9.864693, -83.920226,"Subway")

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
        createNewMarker(9.862748, -83.915477,"Grupo Barsol")
        createNewMarker(9.862313, -83.915518,"Grupo Decobaño")
        createNewMarker(9.861462, -83.915646,"Clínica Dental OdontoIntegral")
        createNewMarker(9.860622, -83.915719,"GVI")
        createNewMarker(9.860622, -83.915719,"Plaza la soledad")






















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

    private fun createMarker1() {
        val coordinates = LatLng(9.864918, -83.921971)
        val markerIcon = BitmapDescriptorFactory.fromBitmap(resizeBitmap("marcador", 25, 25))
        val marker = MarkerOptions().position(coordinates).title("Banco ATM").icon(markerIcon)
        map.addMarker(marker)
        map.animateCamera(
            CameraUpdateFactory.newLatLngZoom(coordinates, 18f),
            4000,
            null
        )
    }

    private fun createMarker2() {
        val coordinates = LatLng(9.864078, -83.922054)
        val markerIcon = BitmapDescriptorFactory.fromBitmap(resizeBitmap("marcador", 25, 25))
        val marker = MarkerOptions().position(coordinates).title("Clinica Dental").icon(markerIcon)
        map.addMarker(marker)
        map.animateCamera(
            CameraUpdateFactory.newLatLngZoom(coordinates, 18f),
            4000,
            null
        )
    }

    private fun createMarker3() {
        val coordinates = LatLng(9.863229, -83.922160)
        val markerIcon = BitmapDescriptorFactory.fromBitmap(resizeBitmap("marcador", 25, 25))
        val marker = MarkerOptions().position(coordinates).title("Taco Bell").icon(markerIcon)
        map.addMarker(marker)
        map.animateCamera(
            CameraUpdateFactory.newLatLngZoom(coordinates, 18f),
            4000,
            null
        )
    }

    private fun createMarker4() {
        val coordinates = LatLng(9.862382, -83.922259)
        val markerIcon = BitmapDescriptorFactory.fromBitmap(resizeBitmap("marcador", 25, 25))
        val marker = MarkerOptions().position(coordinates).title("MonkeyScrubs").icon(markerIcon)
        map.addMarker(marker)
        map.animateCamera(
            CameraUpdateFactory.newLatLngZoom(coordinates, 18f),
            4000,
            null
        )
    }

    private fun createMarker5() {
        val coordinates = LatLng(9.861526, -83.922366)
        val markerIcon = BitmapDescriptorFactory.fromBitmap(resizeBitmap("marcador", 25, 25))
        val marker =
            MarkerOptions().position(coordinates).title("Funeraria San Jorge").icon(markerIcon)
        map.addMarker(marker)
        map.animateCamera(
            CameraUpdateFactory.newLatLngZoom(coordinates, 18f),
            4000,
            null
        )
    }

    private fun createMarker6() {
        val coordinates = LatLng(9.860691, -83.9224854)
        val markerIcon = BitmapDescriptorFactory.fromBitmap(resizeBitmap("marcador", 25, 25))
        val marker = MarkerOptions().position(coordinates).title("Calle 4").icon(markerIcon)
        map.addMarker(marker)
        map.animateCamera(
            CameraUpdateFactory.newLatLngZoom(coordinates, 18f),
            4000,
            null
        )
    }

    private fun createMarker7() {
        val coordinates = LatLng(9.864825, -83.921121)
        val markerIcon = BitmapDescriptorFactory.fromBitmap(resizeBitmap("marcador", 25, 25))
        val marker = MarkerOptions().position(coordinates).title("Burger King").icon(markerIcon)
        map.addMarker(marker)
        map.animateCamera(
            CameraUpdateFactory.newLatLngZoom(coordinates, 18f),
            4000,
            null
        )
    }

    private fun createMarker8() {
        val coordinates = LatLng(9.863936, -83.921206)
        val markerIcon = BitmapDescriptorFactory.fromBitmap(resizeBitmap("marcador", 25, 25))
        val marker = MarkerOptions().position(coordinates).title("Calle 2").icon(markerIcon)
        map.addMarker(marker)
        map.animateCamera(
            CameraUpdateFactory.newLatLngZoom(coordinates, 18f),
            4000,
            null
        )
    }

    private fun createMarker9() {
        val coordinates = LatLng(9.863116, -83.921318)
        val markerIcon = BitmapDescriptorFactory.fromBitmap(resizeBitmap("marcador", 25, 25))
        val marker =
            MarkerOptions().position(coordinates).title("Instituto Jimenez").icon(markerIcon)
        map.addMarker(marker)
        map.animateCamera(
            CameraUpdateFactory.newLatLngZoom(coordinates, 18f),
            4000,
            null
        )
    }

    private fun createMarker10() {
        val coordinates = LatLng(9.862263, -83.921426)
        val markerIcon = BitmapDescriptorFactory.fromBitmap(resizeBitmap("marcador", 25, 25))
        val marker = MarkerOptions().position(coordinates).title("Farmacia CCSS").icon(markerIcon)
        map.addMarker(marker)
        map.animateCamera(
            CameraUpdateFactory.newLatLngZoom(coordinates, 18f),
            4000,
            null
        )
    }

    private fun createMarker11() {
        val coordinates = LatLng(9.861405, -83.921538)
        val markerIcon = BitmapDescriptorFactory.fromBitmap(resizeBitmap("marcador", 25, 25))
        val marker = MarkerOptions().position(coordinates).title("Ópticas Visión").icon(markerIcon)
        map.addMarker(marker)
        map.animateCamera(
            CameraUpdateFactory.newLatLngZoom(coordinates, 18f),
            4000,
            null
        )
    }

    private fun createMarker12() {
        val coordinates = LatLng(9.860573, -83.921649)
        val markerIcon = BitmapDescriptorFactory.fromBitmap(resizeBitmap("marcador", 25, 25))
        val marker = MarkerOptions().position(coordinates).title("Plaza Asís").icon(markerIcon)
        map.addMarker(marker)
        map.animateCamera(
            CameraUpdateFactory.newLatLngZoom(coordinates, 18f),
            4000,
            null
        )
    }

    private fun createMarker13() {
        val coordinates = LatLng(9.864565, -83.919397)
        val markerIcon = BitmapDescriptorFactory.fromBitmap(resizeBitmap("marcador", 25, 25))
        val marker = MarkerOptions().position(coordinates).title("Cartago Centro").icon(markerIcon)
        map.addMarker(marker)
        map.animateCamera(
            CameraUpdateFactory.newLatLngZoom(coordinates, 18f),
            4000,
            null
        )
    }

    private fun createMarker14() {
        val coordinates = LatLng(9.863815, -83.920370)
        val markerIcon = BitmapDescriptorFactory.fromBitmap(resizeBitmap("marcador", 25, 25))
        val marker = MarkerOptions().position(coordinates).title("Ruinas").icon(markerIcon)
        map.addMarker(marker)
        map.animateCamera(
            CameraUpdateFactory.newLatLngZoom(coordinates, 18f),
            4000,
            null
        )
    }

    private fun createMarker15() {
        val coordinates = LatLng(9.863009, -83.920478)
        val markerIcon = BitmapDescriptorFactory.fromBitmap(resizeBitmap("marcador", 25, 25))
        val marker = MarkerOptions().position(coordinates).title("Banco BAC").icon(markerIcon)
        map.addMarker(marker)
        map.animateCamera(
            CameraUpdateFactory.newLatLngZoom(coordinates, 18f),
            4000,
            null
        )
    }

    private fun createMarker16() {
        val coordinates = LatLng(9.862152, -83.920604)
        val markerIcon = BitmapDescriptorFactory.fromBitmap(resizeBitmap("marcador", 25, 25))
        val marker =
            MarkerOptions().position(coordinates).title("Laboratorio Clínico").icon(markerIcon)
        map.addMarker(marker)
        map.animateCamera(
            CameraUpdateFactory.newLatLngZoom(coordinates, 18f),
            4000,
            null
        )
    }

    private fun createMarker17() {
        val coordinates = LatLng(9.861309, -83.920730)
        val markerIcon = BitmapDescriptorFactory.fromBitmap(resizeBitmap("marcador", 25, 25))
        val marker = MarkerOptions().position(coordinates).title("Calle 0").icon(markerIcon)
        map.addMarker(marker)
        map.animateCamera(
            CameraUpdateFactory.newLatLngZoom(coordinates, 18f),
            4000,
            null
        )
    }

    private fun createMarker18() {
        val coordinates = LatLng(9.863726, -83.919513)
        val markerIcon = BitmapDescriptorFactory.fromBitmap(resizeBitmap("marcador", 25, 25))
        val marker = MarkerOptions().position(coordinates).title("Caja ANDE").icon(markerIcon)
        map.addMarker(marker)
        map.animateCamera(
            CameraUpdateFactory.newLatLngZoom(coordinates, 18f),
            4000,
            null
        )
    }

    private fun createMarker19() {
        val coordinates = LatLng(9.862900, -83.919614)
        val markerIcon = BitmapDescriptorFactory.fromBitmap(resizeBitmap("marcador", 25, 25))
        val marker = MarkerOptions().position(coordinates).title("Pops").icon(markerIcon)
        map.addMarker(marker)
        map.animateCamera(
            CameraUpdateFactory.newLatLngZoom(coordinates, 18f),
            4000,
            null
        )
    }

    private fun createMarker20() {
        val coordinates = LatLng(9.862036, -83.919741)
        val markerIcon = BitmapDescriptorFactory.fromBitmap(resizeBitmap("marcador", 25, 25))
        val marker = MarkerOptions().position(coordinates).title("Avenida 6").icon(markerIcon)
        map.addMarker(marker)
        map.animateCamera(
            CameraUpdateFactory.newLatLngZoom(coordinates, 18f),
            4000,
            null
        )
    }

    private fun createMarker21() {
        val coordinates = LatLng(9.861188, -83.919840)
        val markerIcon = BitmapDescriptorFactory.fromBitmap(resizeBitmap("marcador", 25, 25))
        val marker = MarkerOptions().position(coordinates).title("Barber Shop").icon(markerIcon)
        map.addMarker(marker)
        map.animateCamera(
            CameraUpdateFactory.newLatLngZoom(coordinates, 18f),
            4000,
            null
        )
    }

    private fun createMarker22() {
        val coordinates = LatLng(9.860309, -83.919966)
        val markerIcon = BitmapDescriptorFactory.fromBitmap(resizeBitmap("marcador", 25, 25))
        val marker = MarkerOptions().position(coordinates).title("Coco Catering").icon(markerIcon)
        map.addMarker(marker)
        map.animateCamera(
            CameraUpdateFactory.newLatLngZoom(coordinates, 18f),
            4000,
            null
        )
    }

    private fun createMarker23() {
        val coordinates = LatLng(9.860433, -83.920856)
        val markerIcon = BitmapDescriptorFactory.fromBitmap(resizeBitmap("marcador", 25, 25))
        val marker = MarkerOptions().position(coordinates).title("Avenida 10").icon(markerIcon)
        map.addMarker(marker)
        map.animateCamera(
            CameraUpdateFactory.newLatLngZoom(coordinates, 18f),
            4000,
            null
        )
    }

}