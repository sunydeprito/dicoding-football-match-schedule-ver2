package com.example.achmad.footballmatchschedulever3.model.repo

import com.example.achmad.footballmatchschedulever3.db.FavoriteMatch

interface Repository {

    fun getMatchFromDb() : List<FavoriteMatch>

    fun insertData(eventId: String, homeId: String, awayId: String)

    fun deleteData(eventId: String)

    fun checkFavorite(eventId: String) : List<FavoriteMatch>
}