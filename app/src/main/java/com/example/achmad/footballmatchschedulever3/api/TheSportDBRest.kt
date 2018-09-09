package com.example.achmad.footballmatchschedulever3.api

import com.example.achmad.footballmatchschedulever3.model.matchevent.MatchEventResponse
import com.example.achmad.footballmatchschedulever3.model.teams.TeamsResponse
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Query

interface TheSportDBRest {

    @GET("eventspastleague.php")
    fun getLastmatch(@Query("id") id:String) : Flowable<MatchEventResponse>

    @GET("eventsnextleague.php")
    fun getUpcomingMatch(@Query("id") id:String) : Flowable<MatchEventResponse>

    @GET("lookupteam.php")
    fun getTeam(@Query("id") id:String) : Flowable<TeamsResponse>


    @GET("lookupevent.php")
    fun getEventById(@Query("id") id:String) : Flowable<MatchEventResponse>
}