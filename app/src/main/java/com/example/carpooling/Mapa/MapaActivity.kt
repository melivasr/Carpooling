package com.example.carpooling.Mapa

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.location.Location
import android.location.LocationManager
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.lifecycleScope
import com.example.carpooling.Mapa.MapaActivity.Companion.REQUEST_CODE_LOCATION
import com.example.carpooling.R
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.maps.model.Polyline
import com.google.android.gms.maps.model.PolylineOptions
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import kotlinx.coroutines.suspendCancellableCoroutine
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


/**
* Actividad que muestra un mapa y permite la selección de rutas entre dos puntos.
*
* Esta actividad utiliza la API de Google Maps y la API de OpenRouteService para mostrar el mapa y
* trazar rutas entre dos ubicaciones seleccionadas por el usuario.
*
* @property REQUEST_CODE_LOCATION Código de solicitud para los permisos de ubicación.
* @property botonRuta Botón utilizado para iniciar la selección de rutas en el mapa.
* @property start Coordenadas de inicio de la ruta.
* @property end Coordenadas de fin de la ruta.
* @property poly Polilínea que representa la ruta trazada en el mapa.
*/
@OptIn(ExperimentalCoroutinesApi::class)
class MapaActivity : AppCompatActivity(), OnMapReadyCallback {
    private lateinit var map: GoogleMap

    companion object {
        const val REQUEST_CODE_LOCATION = 0
    }

    private lateinit var botonRuta: Button

    private var start: String = ""
    private var end: String = ""

    var poly: Polyline? = null

    /**
     * Método llamado cuando la actividad se crea.
     *
     * Inicializa la interfaz de usuario y establece un [OnClickListener] para el botón de ruta.
     *
     * @param savedInstanceState Estado previamente guardado de la actividad.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.app_bar_main)

        botonRuta = findViewById(R.id.botonRuta)
        botonRuta.setOnClickListener {
            start = ""
            end = ""
            poly?.remove()
            poly = null
            Toast.makeText(this, "Doble tap para marcar una ruta en el mapa", Toast.LENGTH_SHORT).show()
            lifecycleScope.launch {
                val result = getUserLocation(this@MapaActivity)
                if (::map.isInitialized) {
                    map.setOnMapClickListener {
                        if (start.isEmpty()) {
                            if (result != null) {
                                start = "${result.longitude},${result.latitude}"
                            }
                        } else if (end.isEmpty()) {
                            end = "${it.longitude},${it.latitude}"
                            createRoute()
                        }
                    }
                }
            }
        }
        createFragment()
    }

    private fun createFragment() {
        val mapFragment: SupportMapFragment =
            supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }
    //Rutas
    private fun createRoute() {
        CoroutineScope(Dispatchers.IO).launch {
            val call = getRetrofit().create(ApiService::class.java)
                .getRoute("5b3ce3597851110001cf624882cd428d13bb4d62b0573b5c721c5249", start, end)
            if (call.isSuccessful) {
                drawRoute(call.body())
            } else {
                Log.i("keko", "KO")
            }
        }
    }
    /**
     * Dibuja una ruta en el mapa utilizando las coordenadas proporcionadas por [routeResponse].
     *
     * @param routeResponse Objeto que contiene las coordenadas de la ruta.
     */
    private fun drawRoute(routeResponse: RouteResponse?) {
        val polyLineOptions = PolylineOptions()
        routeResponse?.features?.first()?.geometry?.coordinates?.forEach {
            polyLineOptions.add(LatLng(it[1], it[0]))
        }
        runOnUiThread {
            poly = map.addPolyline(polyLineOptions)
        }
    }
    /**
     * Dibuja una ruta en el mapa utilizando las coordenadas proporcionadas por la lista que da el servidor.
     */
    private fun createPolylines(){
        val polylineOptions = PolylineOptions()
            //Estas coordenadas son de ejemplo las cambias por la de la lista
            .add(LatLng(9.857428133919552, -83.91250656268834))
            .add(LatLng(9.857671849215071, -83.91113158262938))
            .add(LatLng(9.857391856878795, -83.9103737481273))
            .add(LatLng(9.8562005251962, -83.91054349689202))
            .add(LatLng(9.855056608257728, -83.91017987086795))
            .add(LatLng(9.854717203570459, -83.90906347521076))
        val polyline = map.addPolyline(polylineOptions)
    }

    /**
     * Obtiene una instancia de [Retrofit] configurada para la API de OpenRouteService.
     *
     * @return Instancia de [Retrofit].
     */
    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.openrouteservice.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    /**
     * Método llamado cuando el mapa está listo para su uso.
     *
     * @param googleMap Instancia de [GoogleMap] que representa el mapa.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        val coordinates = LatLng(9.855236366809901, -83.90900562894333)
        map = googleMap
        enableMyLocation()
        map.animateCamera(
            CameraUpdateFactory.newLatLngZoom(coordinates, 18f),
            4000,
            null
        )
        createPolylines()
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
        createNewMarker(9.863009, -83.920478, "Banco BAC")
        createNewMarker(9.862152, -83.920604, "Laboratorio Clínico")
        createNewMarker(9.861309, -83.920730, "Calle 0")
        createNewMarker(9.860433, -83.920856, "Avenida 10")

        createNewMarker(9.864565, -83.919397, "Cartago Centro")
        createNewMarker(9.863726, -83.919513, "Caja ANDE")
        createNewMarker(9.862900, -83.919614, "Pops")
        createNewMarker(9.862036, -83.919741, "Avenida 6")
        createNewMarker(9.861188, -83.919840, "Barber Shop")
        createNewMarker(9.860309, -83.919966, "Coco Catering")

        createNewMarker(9.864456, -83.918536, "Rosti")
        createNewMarker(9.863592, -83.918644, "Soda Il Fratello")
        createNewMarker(9.862782, -83.918744, "Psico&Yoga Centro de Salud Integral")
        createNewMarker(9.861924, -83.918865, "Bufete Cohghi Sanabria")
        createNewMarker(9.861069, -83.918989, "Panadería Bruma")

        createNewMarker(9.864321, -83.917638, "CoopeAnde")
        createNewMarker(9.863467, -83.917733, "Café T'Ando")
        createNewMarker(9.862657, -83.917827, "La canela")
        createNewMarker(9.861787, -83.917926, "CredeCoop R.L.")
        createNewMarker(9.860924, -83.918031, "OFICSEVI")
        createNewMarker(9.860024, -83.918126, "Pizzeria Villa Italia")

        createNewMarker(9.864167, -83.916575, "Bakery Esau")
        createNewMarker(9.863346, -83.916683, "Hodgson's")
        createNewMarker(9.862493, -83.916824, "Transtusa")
        createNewMarker(9.861650, -83.916913, "Sara Studio")
        createNewMarker(9.860803, -83.917055, "Pollos Bro's")
        createNewMarker(9.859879, -83.917185, "Bar La Nave")

        createNewMarker(9.861511, -83.916011, "Boutique Café")
        createNewMarker(9.860663, -83.916156, "Antiguo Matadero")
        createNewMarker(9.859744, -83.916319, "Panadería Su")

        createNewMarker(9.864031, -83.915290, "CoopeMep")
        createNewMarker(9.863127, -83.915428, "CAFLIFE")
        createNewMarker(9.862313, -83.915518, "Grupo Decobaño")
        createNewMarker(9.861462, -83.915646, "Clínica Dental OdontoIntegral")
        createNewMarker(9.860622, -83.915719, "GVI")
        createNewMarker(9.859676, -83.915746, "Plaza la soledad")

    }
    /**
    * Redimensiona una imagen de mapa de bits a las dimensiones proporcionadas.
    *
    * @param drawableName Nombre del recurso drawable.
    * @param width Ancho deseado de la imagen.
    * @param height Altura deseada de la imagen.
    * @return Imagen de mapa de bits redimensionada.
    */

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
    /**
     * Obtiene la ubicación del usuario en tiempo real utilizando la API de ubicación de Google.
     *
     * @param context Contexto de la aplicación.
     * @return Objeto [Location] que representa la ubicación del usuario.
     */

    //Ubicacion en tiempo real
    @SuppressLint("MissingPermission")
    private suspend fun getUserLocation(context: Context):Location? {
        val fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(context)
        val locationManager = context.getSystemService(Context.LOCATION_SERVICE) as LocationManager
        val isGPSEnabled = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)
                || locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)
        if(!isGPSEnabled || !isPermissionsGranted()){
            return null
        }
        return suspendCancellableCoroutine { cont->
            fusedLocationProviderClient.lastLocation.apply {
                if(isComplete){
                    if(isSuccessful){
                        cont.resume(result){}
                    }else{
                        cont.resume(null){}
                    }
                    return@suspendCancellableCoroutine
                }
                addOnSuccessListener {
                    cont.resume(it){}
                }
                addOnFailureListener{
                    cont.resume(null){}
                }
                addOnCanceledListener{
                    cont.resume(null){}
                }
            }
        }

    }
    /**
     * Verifica si se han otorgado los permisos de ubicación.
     *
     * @return `true` si los permisos de ubicación están otorgados, `false` en caso contrario.
     */

    private fun isPermissionsGranted() = ContextCompat.checkSelfPermission(
        this, Manifest.permission.ACCESS_FINE_LOCATION
    ) == PackageManager.PERMISSION_GRANTED
    /**
     * Habilita la capa de ubicación del mapa si los permisos están otorgados; de lo contrario, solicita
     * permisos al usuario.
     */
    private fun enableMyLocation() {
        if (!::map.isInitialized) return
        if (isPermissionsGranted()) {
            map.isMyLocationEnabled = true
        } else {
            requestLocationPermission()
        }
    }

    /**
     * Solicita permisos de ubicación al usuario. Si los permisos ya se han solicitado
     * anteriormente y fueron denegados, se muestra un mensaje explicativo.
     */
    private fun requestLocationPermission() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            )
        ) {
            Toast.makeText(this, "Ve a ajustes y acepta los permisos", Toast.LENGTH_SHORT).show()
        } else {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                REQUEST_CODE_LOCATION
            )
        }
    }
    /**
     * Método llamado cuando se obtiene una respuesta a la solicitud de permisos.
     *
     * @param requestCode Código de solicitud.
     * @param permissions Arreglo de permisos solicitados.
     * @param grantResults Resultados de la solicitud de permisos.
     */
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        when (requestCode) {
            REQUEST_CODE_LOCATION -> if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                map.isMyLocationEnabled = true
            } else {
                Toast.makeText(
                    this,
                    "Para activar la localización ve a ajustes y acepta los permisos",
                    Toast.LENGTH_SHORT
                ).show()
            }

            else -> {}
        }
    }
    /**
     * Método llamado cuando se reanudan los fragmentos de la actividad.
     *
     * Verifica si la ubicación está habilitada y muestra un mensaje si los permisos no están otorgados.
     */

    override fun onResumeFragments() {
        super.onResumeFragments()
        if (!::map.isInitialized) return
        if (!isPermissionsGranted()) {
            map.isMyLocationEnabled = false
            Toast.makeText(
                this,
                "Para activar la localización ve a ajustes y acepta los permisos",
                Toast.LENGTH_SHORT
            ).show()
        }
    }


}
