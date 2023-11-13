package com.example.carpooling

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import org.osmdroid.config.Configuration
import org.osmdroid.tileprovider.tilesource.TileSourceFactory
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.MapView

class MapActivity : AppCompatActivity() {

    private val locationService:LocationService = LocationService()
    private lateinit var mapView: MapView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize the OpenStreetMap library
        Configuration.getInstance().load(this, getSharedPreferences("OpenStreetMap", MODE_PRIVATE))

        setContentView(R.layout.activity_map)

        mapView = findViewById(R.id.mapView)
        mapView.setTileSource(TileSourceFactory.MAPNIK)

        // Request location permission if not granted
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), 1)
        } else {
            showLocation()
        }
    }

    private fun showLocation() {
        lifecycleScope.launch {
            // Get the user's last known location
            val locationManager = getSystemService(LOCATION_SERVICE) as android.location.LocationManager
            val location=locationService.getUserLocation(this@MapActivity)
            if(location!=null){
                // Center the map on the user's location
                if (location != null) {
                    val geoPoint = GeoPoint(location.latitude, location.longitude)
                    mapView.controller.setCenter(geoPoint)
                }
            }
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 1 && grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            showLocation()
        }
    }
}


