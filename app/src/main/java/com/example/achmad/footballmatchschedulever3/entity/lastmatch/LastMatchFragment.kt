package com.example.achmad.footballmatchschedulever3.entity.lastmatch


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.achmad.footballmatchschedulever3.R
import com.example.achmad.footballmatchschedulever3.adapter.TeamsAdapter
import com.example.achmad.footballmatchschedulever3.api.TheSportDBApi
import com.example.achmad.footballmatchschedulever3.api.TheSportDBRest
import com.example.achmad.footballmatchschedulever3.model.matchevent.MatchEvent
import com.example.achmad.footballmatchschedulever3.model.matchevent.MatchEventPresenter
import com.example.achmad.footballmatchschedulever3.utils.AppSchedulerProvider
import com.example.achmad.footballmatchschedulever3.utils.hide
import com.example.achmad.footballmatchschedulever3.utils.show
import kotlinx.android.synthetic.main.fragment_last_match.*



class LastMatchFragment : Fragment(), LastMatchView.View
    {
        private lateinit var mPresenter: LastMatchPresenter

        private var matchLists: MutableList<MatchEvent> = mutableListOf()

        override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                                  savedInstanceState: Bundle?): View? {

            return inflater.inflate(R.layout.fragment_last_match, container, false)
        }

        override fun onActivityCreated(savedInstanceState: Bundle?) {
            super.onActivityCreated(savedInstanceState)
            val service = TheSportDBApi.getClient().create(TheSportDBRest::class.java)
            val request = MatchEventPresenter(service)
            val schedulerProvider = AppSchedulerProvider()
            mPresenter = LastMatchPresenter(this, request, schedulerProvider)
            mPresenter.getFootballData()

        }

        override fun hideLoading() {
        mainProgressBarLast.hide()
            rvFootballLast.visibility = View.VISIBLE
    }

    override fun showLoading() {
        mainProgressBarLast.show()
        rvFootballLast.visibility = View.INVISIBLE
    }

    override fun displayFootballMatch(matchList: List<MatchEvent>) {
        matchLists.clear()
        matchLists.addAll(matchList)
        val layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        rvFootballLast.layoutManager = layoutManager
        rvFootballLast.adapter = TeamsAdapter(matchList, context)
    }

}


