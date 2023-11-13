package com.example.model

class Usuario(
    var name: String,
    var correo: String,
    var tipo: String,
    var password: String
) {
    override fun toString(): String {
        return "Usuario(name='$name', correo='$correo', tipo='$tipo', password='$password')"
    }
}
