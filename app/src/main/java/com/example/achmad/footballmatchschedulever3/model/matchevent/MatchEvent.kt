package com.example.achmad.footballmatchschedulever3.model.matchevent

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MatchEvent(
        @SerializedName("dateEvent") var dateEvent: String?  = null,
        @SerializedName("idAwayTeam") var idAwayTeam: String,
        @SerializedName("idEvent") var idEvent: String?  ,
        @SerializedName("idHomeTeam") var idHomeTeam: String,
        @SerializedName("idLeague") var idLeague: String?  = null,
        @SerializedName("idSoccerXML") var idSoccerXML: String? = null,
        @SerializedName("intAwayScore") var intAwayScore: String? = null,
        @SerializedName("intHomeScore") var intHomeScore: String? = null,
        @SerializedName("intRound") var intRound: String? = null,
        @SerializedName("strAwayFormation") var strAwayFormation: String? = null,
        @SerializedName("strAwayGoalDetails") var strAwayGoalDetails: String? = null,
        @SerializedName("strAwayLineupDefense") var strAwayLineupDefense: String? = null,
        @SerializedName("strAwayLineupForward") var strAwayLineupForward: String? = null,
        @SerializedName("strAwayLineupGoalkeeper") var strAwayLineupGoalkeeper: String?,
        @SerializedName("strAwayLineupMidfield") var strAwayLineupMidfield: String?,
        @SerializedName("strAwayLineupSubstitutes") var strAwayLineupSubstitutes: String? = null,
        @SerializedName("strAwayRedCards") var strAwayRedCards: String? = null,
        @SerializedName("strAwayTeam") var strAwayTeam: String? = null,
        @SerializedName("strAwayYellowCards") var strAwayYellowCards: String? = null,
        @SerializedName("strDate") var strDate: String? = null,
        @SerializedName("strEvent") var strEvent: String? = null,
        @SerializedName("strFilename") var strFilename: String?,
        @SerializedName("strHomeFormation") var strHomeFormation: String? = null,
        @SerializedName("strHomeGoalDetails") var strHomeGoalDetails: String? = null,
        @SerializedName("strHomeLineupDefense") var strHomeLineupDefense: String? = null,
        @SerializedName("strHomeLineupForward") var strHomeLineupForward: String? = null,
        @SerializedName("strHomeLineupGoalkeeper") var strHomeLineupGoalkeeper: String? = null,
        @SerializedName("strHomeLineupMidfield") var strHomeLineupMidfield: String? = null,
        @SerializedName("strHomeLineupSubstitutes") var strHomeLineupSubstitutes: String? = null,
        @SerializedName("strHomeRedCards") var strHomeRedCards: String? = null,
        @SerializedName("strHomeTeam") var strHomeTeam: String? = null,
        @SerializedName("strHomeYellowCards") var strHomeYellowCards: String? = null,
        @SerializedName("strLeague") var strLeague: String? = null,
        @SerializedName("strLocked") var strLocked: String? = null,
        @SerializedName("strSeason") var strSeason: String? = null,
        @SerializedName("strSport") var strSport: String? = null,
        @SerializedName("strTime") var strTime: String? = null
) : Parcelable