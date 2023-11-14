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
        createMarker2()
        createMarker3()


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


    private fun createMarker2(){
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

    private fun createMarker3() {
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

    private fun createMarker4() {
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

    private fun createMarker5() {
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

    private fun createMarker6() {
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

    private fun createMarker7() {
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
    private fun createMarker8() {
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
    private fun createMarker9() {
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
    private fun createMarker10() {
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
    private fun createMarker11() {
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
    private fun createMarker12() {
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
    private fun createMarker13() {
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
    private fun createMarker14() {
        val coordinates = LatLng(9.855202539981171, -83.90903677311904)
        val markerIcon = BitmapDescriptorFactory.fromBitmap(resizeBitmap("marcador", 25, 25))
        val marker = MarkerOptions().position(coordinates).title("Empresa").icon(markerIcon)
        map.addMarker(marker)
        map.animateCamera(
            CameraUpdateFactory.newLatLngZoom(coordinates,18f),
            4000,
            null
        )
    }    private fun createMarker15() {
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
    private fun createMarker16() {
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
    private fun createMarker17() {
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
    private fun createMarker18() {
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
    private fun createMarker19() {
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
    private fun createMarker20() {
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
    private fun createMarker21() {
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
    private fun createMarker22() {
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
    private fun createMarker23() {
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