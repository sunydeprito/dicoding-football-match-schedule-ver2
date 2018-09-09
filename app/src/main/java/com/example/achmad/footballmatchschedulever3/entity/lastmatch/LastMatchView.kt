package com.example.achmad.footballmatchschedulever3.entity.lastmatch

import com.example.achmad.footballmatchschedulever3.model.matchevent.MatchEvent


interface LastMatchView {
    interface View{
        fun hideLoading()
        fun showLoading()
        fun displayFootballMatch(matchList:List<MatchEvent>)

    }

    interface Presenter{
        fun getFootballData()

    }
}