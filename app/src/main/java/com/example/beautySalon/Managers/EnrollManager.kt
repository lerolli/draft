package com.example.beautySalon.Managers

import kotlin.reflect.KProperty

class Master(name: String, freeTime: List<String>) {

    val name = name
    val freeTime = freeTime
}

class EnrollManager {
    val service: Service? = null
    val masters = mutableListOf<Master>()

    var selectedMaster: Master? = null
    fun getMasters() {
        getMockMasters()
    }

    private fun getMockMasters() {

        masters.add(Master("Людмила", listOf("1 октября")))
        masters.add(Master("Светлана", listOf("2 октября")))
        masters.add(Master("Наталья", listOf("3 октября")))
    }
}