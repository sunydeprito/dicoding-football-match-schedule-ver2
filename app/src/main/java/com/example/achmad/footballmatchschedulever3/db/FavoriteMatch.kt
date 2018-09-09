package com.example.achmad.footballmatchschedulever3.db

data class FavoriteMatch(val id: Long?,
                         val idEvent: String,
                         val idHomeTeam: String,
                         val idAwayTeam: String) {

    companion object {
        const val TABLE_FAVORITE: String = "TABLE_FAVORITE"
        const val ID: String = "ID_"
        const val EVENT_ID: String = "EVENT_ID"
        const val HOME_TEAM_ID: String = "HOME_TEAM"
        const val AWAY_TEAM_ID: String = "AWAY_TEAM"

    }
}