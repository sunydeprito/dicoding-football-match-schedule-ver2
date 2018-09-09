package com.example.achmad.footballmatchschedulever3.entity.favorite

import com.example.achmad.footballmatchschedulever3.model.matchevent.MatchEvent

interface FavoriteMatchView {
    interface View {
        fun hideLoading()
        fun showLoading()
        fun displayFootballMatch(matchList: List<MatchEvent>)
        fun hideSwipeRefresh()

    }

    interface Presenter {
        fun getFootballMatchData()

    }
}