package com.example.model

class TravelRequestData(idUser: Usuario?, listOf: List<Int>) {
    var idUser: Int = 0
    var usersToPickUp: List<Int> = emptyList()

override fun toString(): String {
    return "TravelRequestData(idUser=$idUser, usersToPickUp=$usersToPickUp)"
}

}