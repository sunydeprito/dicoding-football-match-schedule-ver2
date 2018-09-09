package com.example.achmad.footballmatchschedulever3.entity.nextmatch

import com.example.achmad.footballmatchschedulever3.model.matchevent.MatchEvent


interface NextMatchView {
    interface View{
        fun hideLoading()
        fun showLoading()
        fun displayFootballMatch(matchList:List<MatchEvent>)

    }

    interface Presenter{
        fun getFootballUpcomingData()

    }
}