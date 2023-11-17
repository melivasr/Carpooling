package com.example.model

import android.R.attr.text


class TravelRequestData(idUser: Int, listOf: List<Int>) {
    var idUser: Int = idUser
    var usersToPickUp: List<Int> = emptyList()

override fun toString(): String {
    var stringList = "[";
    for (i in 0..usersToPickUp.count()) {
        stringList += usersToPickUp[i]
        if(i != usersToPickUp.count() - 1)
        {
            stringList += ", "
        }
    }
    stringList += "]"
    return "TravelRequestData(idUser=$idUser, usersToPickUp=$stringList)"
}
}