package com.example.achmad.footballmatchschedulever3.model.matchevent

import com.example.achmad.footballmatchschedulever3.model.teams.TeamsResponse
import io.reactivex.Flowable

interface MatchEventView {

    fun getFootballMatch(id : String) : Flowable<MatchEventResponse>

    fun getTeams(id : String = "0") : Flowable<TeamsResponse>

    fun getUpcomingMatch(id : String) : Flowable<MatchEventResponse>


}