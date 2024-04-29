package com.example.beautySalon.Managers

class Profile(login: String, name: String, surname: String, phone: String, site: String) {
    var login = login
    var name = name
    var surname = surname
    var phone = phone
    var site = site
}

class ProfileManager {
    var profile: Profile? = null

    fun getInfoProfile() {
       getMockProfile()
    }

    private fun getMockProfile() {
        profile = Profile(
            "svetik",
            "Светлана",
            "Петрова",
            "88005553535",
            "t.me/svetlana"
        )
    }
}