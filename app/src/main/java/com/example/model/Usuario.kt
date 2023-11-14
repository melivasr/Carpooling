package com.example.model

class Usuario(
    var name: String,
    var correo: String,
    var tipo: String,
    var ubicacion: String,
    var password: String,
    var calificacion: String
) {
    override fun toString(): String {
        return "Usuario(name='$name', correo='$correo', tipo='$tipo',ubicacion='$ubicacion', password='$password', calificacion='$calificacion')"
    }
}
