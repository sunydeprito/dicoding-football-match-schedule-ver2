package com.example.achmad.footballmatchschedulever3.entity.detail

import com.example.achmad.footballmatchschedulever3.db.FavoriteMatch
import com.example.achmad.footballmatchschedulever3.model.teams.Teams

interface DetailView {

    interface View{
        fun displayTeamBadgeHome(team: Teams)
        fun setFavoriteState(favList:List<FavoriteMatch>)
        fun displayTeamBadgeAway(team: Teams)
    }

    interface Presenter{
        fun getTeamsBadgeAway(id:String)
        fun getTeamsBadgeHome(id:String)
        fun deleteMatch(id:String)
        fun insertMatch(eventId: String, homeId: String, awayId: String)
        fun checkMatch(id:String)

    }
}