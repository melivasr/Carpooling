package com.example.model

class GeographicData {
    var id: Int = 0
    var name: String = ""
    var latitude: Double = 0.0
    var longitude: Double = 0.0

    override fun toString(): String {
        return "GeographicData(id='$id', name='$name',longitude='$longitude', latitude='$latitude')"
    }
}