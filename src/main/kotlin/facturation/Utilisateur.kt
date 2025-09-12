package org.example.facturation

sealed class Utilisateur {
    data class Artisan(val id: String) : Utilisateur()
    data class Administrateur(val id: String) : Utilisateur()
}


