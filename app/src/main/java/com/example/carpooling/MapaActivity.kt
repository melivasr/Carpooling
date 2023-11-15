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


class MapaActivity: AppCompatActivity(), OnMapReadyCallback {
    private lateinit var map:GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.app_bar_main)
        createFragment()
    }
    private fun createFragment(){
        val mapFragment: SupportMapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        map=googleMap
        createMarker()
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



    }
    fun resizeBitmap(drawableName: String, width: Int, height: Int): Bitmap {
        val imageBitmap = BitmapFactory.decodeResource(resources, resources.getIdentifier(drawableName, "drawable", packageName))
        return Bitmap.createScaledBitmap(imageBitmap, width, height, false)
    }

    private fun createMarker() {
        val coordinates = LatLng(9.8625840, -83.9188036)
        val marker = MarkerOptions().position(coordinates).title("Empresa")
        map.addMarker(marker)
        map.animateCamera(
            CameraUpdateFactory.newLatLngZoom(coordinates,18f),
            4000,
            null
        )
    }

    private fun createMarker1() {
        val coordinates = LatLng(9.864918, -83.921971)
        val markerIcon = BitmapDescriptorFactory.fromBitmap(resizeBitmap("marcador", 25, 25))
        val marker = MarkerOptions().position(coordinates).title("Banco ATM").icon(markerIcon)
        map.addMarker(marker)
        map.animateCamera(
            CameraUpdateFactory.newLatLngZoom(coordinates,18f),
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
            CameraUpdateFactory.newLatLngZoom(coordinates,18f),
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
            CameraUpdateFactory.newLatLngZoom(coordinates,18f),
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
            CameraUpdateFactory.newLatLngZoom(coordinates,18f),
            4000,
            null
        )
    }
    private fun createMarker5() {
        val coordinates = LatLng(9.861526, -83.922366)
        val markerIcon = BitmapDescriptorFactory.fromBitmap(resizeBitmap("marcador", 25, 25))
        val marker = MarkerOptions().position(coordinates).title("Funeraria San Jorge").icon(markerIcon)
        map.addMarker(marker)
        map.animateCamera(
            CameraUpdateFactory.newLatLngZoom(coordinates,18f),
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
            CameraUpdateFactory.newLatLngZoom(coordinates,18f),
            4000,
            null
        )
    }

    private fun createMarker7(){
        val coordinates = LatLng(9.864825, -83.921121)
        val markerIcon = BitmapDescriptorFactory.fromBitmap(resizeBitmap("marcador", 25, 25))
        val marker = MarkerOptions().position(coordinates).title("Burger King").icon(markerIcon)
        map.addMarker(marker)
        map.animateCamera(
            CameraUpdateFactory.newLatLngZoom(coordinates,18f),
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
            CameraUpdateFactory.newLatLngZoom(coordinates,18f),
            4000,
            null
        )
    }

    private fun createMarker9() {
        val coordinates = LatLng(9.863116, -83.921318)
        val markerIcon = BitmapDescriptorFactory.fromBitmap(resizeBitmap("marcador", 25, 25))
        val marker = MarkerOptions().position(coordinates).title("Instituto Jimenez").icon(markerIcon)
        map.addMarker(marker)
        map.animateCamera(
            CameraUpdateFactory.newLatLngZoom(coordinates,18f),
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
            CameraUpdateFactory.newLatLngZoom(coordinates,18f),
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
            CameraUpdateFactory.newLatLngZoom(coordinates,18f),
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
            CameraUpdateFactory.newLatLngZoom(coordinates,18f),
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
            CameraUpdateFactory.newLatLngZoom(coordinates,18f),
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
            CameraUpdateFactory.newLatLngZoom(coordinates,18f),
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
            CameraUpdateFactory.newLatLngZoom(coordinates,18f),
            4000,
            null
        )
    }    private fun createMarker16() {
        val coordinates = LatLng(9.862152, -83.920604)
        val markerIcon = BitmapDescriptorFactory.fromBitmap(resizeBitmap("marcador", 25, 25))
        val marker = MarkerOptions().position(coordinates).title("Laboratorio Clínico").icon(markerIcon)
        map.addMarker(marker)
        map.animateCamera(
            CameraUpdateFactory.newLatLngZoom(coordinates,18f),
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
            CameraUpdateFactory.newLatLngZoom(coordinates,18f),
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
            CameraUpdateFactory.newLatLngZoom(coordinates,18f),
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
            CameraUpdateFactory.newLatLngZoom(coordinates,18f),
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
            CameraUpdateFactory.newLatLngZoom(coordinates,18f),
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
            CameraUpdateFactory.newLatLngZoom(coordinates,18f),
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
            CameraUpdateFactory.newLatLngZoom(coordinates,18f),
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
            CameraUpdateFactory.newLatLngZoom(coordinates,18f),
            4000,
            null
        )
    }

    private fun createMarker24() {
        val coordinates = LatLng(9.855202539981171, -83.90903677311904)
        val markerIcon = BitmapDescriptorFactory.fromBitmap(resizeBitmap("marcador", 25, 25))
        val marker = MarkerOptions().position(coordinates).title("Empresa").icon(markerIcon)
        map.addMarker(marker)
        map.animateCamera(
            CameraUpdateFactory.newLatLngZoom(coordinates,18f),
            4000,
            null
        )
    }
    private fun createMarker25() {
        val coordinates = LatLng(9.855202539981171, -83.90903677311904)
        val markerIcon = BitmapDescriptorFactory.fromBitmap(resizeBitmap("marcador", 25, 25))
        val marker = MarkerOptions().position(coordinates).title("Empresa").icon(markerIcon)
        map.addMarker(marker)
        map.animateCamera(
            CameraUpdateFactory.newLatLngZoom(coordinates,18f),
            4000,
            null
        )
    }
    private fun createMarker26() {
        val coordinates = LatLng(9.855202539981171, -83.90903677311904)
        val markerIcon = BitmapDescriptorFactory.fromBitmap(resizeBitmap("marcador", 25, 25))
        val marker = MarkerOptions().position(coordinates).title("Empresa").icon(markerIcon)
        map.addMarker(marker)
        map.animateCamera(
            CameraUpdateFactory.newLatLngZoom(coordinates,18f),
            4000,
            null
        )
    }
    private fun createMarker27() {
        val coordinates = LatLng(9.855202539981171, -83.90903677311904)
        val markerIcon = BitmapDescriptorFactory.fromBitmap(resizeBitmap("marcador", 25, 25))
        val marker = MarkerOptions().position(coordinates).title("Empresa").icon(markerIcon)
        map.addMarker(marker)
        map.animateCamera(
            CameraUpdateFactory.newLatLngZoom(coordinates,18f),
            4000,
            null
        )
    }
    private fun createMarker28() {
        val coordinates = LatLng(9.855202539981171, -83.90903677311904)
        val markerIcon = BitmapDescriptorFactory.fromBitmap(resizeBitmap("marcador", 25, 25))
        val marker = MarkerOptions().position(coordinates).title("Empresa").icon(markerIcon)
        map.addMarker(marker)
        map.animateCamera(
            CameraUpdateFactory.newLatLngZoom(coordinates,18f),
            4000,
            null
        )
    }
    private fun createMarker29() {
        val coordinates = LatLng(9.855202539981171, -83.90903677311904)
        val markerIcon = BitmapDescriptorFactory.fromBitmap(resizeBitmap("marcador", 25, 25))
        val marker = MarkerOptions().position(coordinates).title("Empresa").icon(markerIcon)
        map.addMarker(marker)
        map.animateCamera(
            CameraUpdateFactory.newLatLngZoom(coordinates,18f),
            4000,
            null
        )
    }
    private fun createMarker30() {
        val coordinates = LatLng(9.855202539981171, -83.90903677311904)
        val markerIcon = BitmapDescriptorFactory.fromBitmap(resizeBitmap("marcador", 25, 25))
        val marker = MarkerOptions().position(coordinates).title("Empresa").icon(markerIcon)
        map.addMarker(marker)
        map.animateCamera(
            CameraUpdateFactory.newLatLngZoom(coordinates,18f),
            4000,
            null
        )
    }
    private fun createMarker31() {
        val coordinates = LatLng(9.855202539981171, -83.90903677311904)
        val markerIcon = BitmapDescriptorFactory.fromBitmap(resizeBitmap("marcador", 25, 25))
        val marker = MarkerOptions().position(coordinates).title("Empresa").icon(markerIcon)
        map.addMarker(marker)
        map.animateCamera(
            CameraUpdateFactory.newLatLngZoom(coordinates,18f),
            4000,
            null
        )
    }
    private fun createMarker32() {
        val coordinates = LatLng(9.855202539981171, -83.90903677311904)
        val markerIcon = BitmapDescriptorFactory.fromBitmap(resizeBitmap("marcador", 25, 25))
        val marker = MarkerOptions().position(coordinates).title("Empresa").icon(markerIcon)
        map.addMarker(marker)
        map.animateCamera(
            CameraUpdateFactory.newLatLngZoom(coordinates,18f),
            4000,
            null
        )
    }
    private fun createMarker33() {
        val coordinates = LatLng(9.855202539981171, -83.90903677311904)
        val markerIcon = BitmapDescriptorFactory.fromBitmap(resizeBitmap("marcador", 25, 25))
        val marker = MarkerOptions().position(coordinates).title("Empresa").icon(markerIcon)
        map.addMarker(marker)
        map.animateCamera(
            CameraUpdateFactory.newLatLngZoom(coordinates,18f),
            4000,
            null
        )
    }
    private fun createMarker34() {
        val coordinates = LatLng(9.855202539981171, -83.90903677311904)
        val markerIcon = BitmapDescriptorFactory.fromBitmap(resizeBitmap("marcador", 25, 25))
        val marker = MarkerOptions().position(coordinates).title("Empresa").icon(markerIcon)
        map.addMarker(marker)
        map.animateCamera(
            CameraUpdateFactory.newLatLngZoom(coordinates,18f),
            4000,
            null
        )
    }
    private fun createMarker35() {
        val coordinates = LatLng(9.855202539981171, -83.90903677311904)
        val markerIcon = BitmapDescriptorFactory.fromBitmap(resizeBitmap("marcador", 25, 25))
        val marker = MarkerOptions().position(coordinates).title("Empresa").icon(markerIcon)
        map.addMarker(marker)
        map.animateCamera(
            CameraUpdateFactory.newLatLngZoom(coordinates,18f),
            4000,
            null
        )
    }
    private fun createMarker36() {
        val coordinates = LatLng(9.855202539981171, -83.90903677311904)
        val markerIcon = BitmapDescriptorFactory.fromBitmap(resizeBitmap("marcador", 25, 25))
        val marker = MarkerOptions().position(coordinates).title("Empresa").icon(markerIcon)
        map.addMarker(marker)
        map.animateCamera(
            CameraUpdateFactory.newLatLngZoom(coordinates,18f),
            4000,
            null
        )
    }
    private fun createMarker37() {
        val coordinates = LatLng(9.855202539981171, -83.90903677311904)
        val markerIcon = BitmapDescriptorFactory.fromBitmap(resizeBitmap("marcador", 25, 25))
        val marker = MarkerOptions().position(coordinates).title("Empresa").icon(markerIcon)
        map.addMarker(marker)
        map.animateCamera(
            CameraUpdateFactory.newLatLngZoom(coordinates,18f),
            4000,
            null
        )
    }
    private fun createMarker38() {
        val coordinates = LatLng(9.855202539981171, -83.90903677311904)
        val markerIcon = BitmapDescriptorFactory.fromBitmap(resizeBitmap("marcador", 25, 25))
        val marker = MarkerOptions().position(coordinates).title("Empresa").icon(markerIcon)
        map.addMarker(marker)
        map.animateCamera(
            CameraUpdateFactory.newLatLngZoom(coordinates,18f),
            4000,
            null
        )
    }
    private fun createMarker39() {
        val coordinates = LatLng(9.855202539981171, -83.90903677311904)
        val markerIcon = BitmapDescriptorFactory.fromBitmap(resizeBitmap("marcador", 25, 25))
        val marker = MarkerOptions().position(coordinates).title("Empresa").icon(markerIcon)
        map.addMarker(marker)
        map.animateCamera(
            CameraUpdateFactory.newLatLngZoom(coordinates,18f),
            4000,
            null
        )
    }
    private fun createMarker40() {
        val coordinates = LatLng(9.855202539981171, -83.90903677311904)
        val markerIcon = BitmapDescriptorFactory.fromBitmap(resizeBitmap("marcador", 25, 25))
        val marker = MarkerOptions().position(coordinates).title("Empresa").icon(markerIcon)
        map.addMarker(marker)
        map.animateCamera(
            CameraUpdateFactory.newLatLngZoom(coordinates,18f),
            4000,
            null
        )
    }
    private fun createMarker41() {
        val coordinates = LatLng(9.855202539981171, -83.90903677311904)
        val markerIcon = BitmapDescriptorFactory.fromBitmap(resizeBitmap("marcador", 25, 25))
        val marker = MarkerOptions().position(coordinates).title("Empresa").icon(markerIcon)
        map.addMarker(marker)
        map.animateCamera(
            CameraUpdateFactory.newLatLngZoom(coordinates,18f),
            4000,
            null
        )
    }
    private fun createMarker42() {
        val coordinates = LatLng(9.855202539981171, -83.90903677311904)
        val markerIcon = BitmapDescriptorFactory.fromBitmap(resizeBitmap("marcador", 25, 25))
        val marker = MarkerOptions().position(coordinates).title("Empresa").icon(markerIcon)
        map.addMarker(marker)
        map.animateCamera(
            CameraUpdateFactory.newLatLngZoom(coordinates,18f),
            4000,
            null
        )
    }
    private fun createMarker43() {
        val coordinates = LatLng(9.855202539981171, -83.90903677311904)
        val markerIcon = BitmapDescriptorFactory.fromBitmap(resizeBitmap("marcador", 25, 25))
        val marker = MarkerOptions().position(coordinates).title("Empresa").icon(markerIcon)
        map.addMarker(marker)
        map.animateCamera(
            CameraUpdateFactory.newLatLngZoom(coordinates,18f),
            4000,
            null
        )
    }

    private fun createMarker44() {
        val coordinates = LatLng(9.855202539981171, -83.90903677311904)
        val markerIcon = BitmapDescriptorFactory.fromBitmap(resizeBitmap("marcador", 25, 25))
        val marker = MarkerOptions().position(coordinates).title("Empresa").icon(markerIcon)
        map.addMarker(marker)
        map.animateCamera(
            CameraUpdateFactory.newLatLngZoom(coordinates,18f),
            4000,
            null
        )
    }
    private fun createMarker45() {
        val coordinates = LatLng(9.855202539981171, -83.90903677311904)
        val markerIcon = BitmapDescriptorFactory.fromBitmap(resizeBitmap("marcador", 25, 25))
        val marker = MarkerOptions().position(coordinates).title("Empresa").icon(markerIcon)
        map.addMarker(marker)
        map.animateCamera(
            CameraUpdateFactory.newLatLngZoom(coordinates,18f),
            4000,
            null
        )
    }


}