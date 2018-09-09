package com.example.achmad.footballmatchschedulever3.model.matchevent


import com.example.achmad.footballmatchschedulever3.api.TheSportDBRest
import com.example.achmad.footballmatchschedulever3.model.teams.TeamsResponse
import io.reactivex.Flowable


class MatchEventPresenter(private val theSportDBRest: TheSportDBRest) : MatchEventView {


    override fun getUpcomingMatch(id: String): Flowable<MatchEventResponse> = theSportDBRest.getUpcomingMatch(id)

    override fun getFootballMatch(id: String): Flowable<MatchEventResponse> = theSportDBRest.getLastmatch(id)

    override fun getTeams(id: String): Flowable<TeamsResponse> = theSportDBRest.getTeam(id)

    fun getEventById(id: String): Flowable<MatchEventResponse> = theSportDBRest.getEventById(id)
}