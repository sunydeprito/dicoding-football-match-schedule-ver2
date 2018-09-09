package com.example.achmad.footballmatchschedulever3.entity.favorite

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
import com.example.achmad.footballmatchschedulever3.model.repo.RepositoryPresenter
import com.example.achmad.footballmatchschedulever3.utils.AppSchedulerProvider
import com.example.achmad.footballmatchschedulever3.utils.hide
import com.example.achmad.footballmatchschedulever3.utils.show

import kotlinx.android.synthetic.main.fragment_favorite_match.*
import org.jetbrains.anko.support.v4.onRefresh

class FavoriteMatchFragment : Fragment(), FavoriteMatchView.View {
    override fun hideLoading() {
        mainProgressBarFav.hide()
        rvFootballFav.visibility=View.VISIBLE
    }

    override fun showLoading() {
        mainProgressBarFav.show()
        rvFootballFav.visibility=View.INVISIBLE
    }


    private var matchLists: MutableList<MatchEvent> = mutableListOf()
    private lateinit var mPresenter: FavoriteMatchPresenter


    override fun displayFootballMatch(matchList: List<MatchEvent>) {
        matchLists.clear()
        matchLists.addAll(matchList)
        val layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        rvFootballFav.layoutManager = layoutManager
        rvFootballFav.adapter = TeamsAdapter(matchList, context)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val service = TheSportDBApi.getClient().create(TheSportDBRest::class.java)
        val request = MatchEventPresenter(service)
        val repository = RepositoryPresenter(context!!)
        val appSchedulerProvider= AppSchedulerProvider()
        mPresenter = FavoriteMatchPresenter(this, request, repository, appSchedulerProvider)
        mPresenter.getFootballMatchData()
        swipe_refresh_layout_fav.onRefresh {
            mPresenter.getFootballMatchData()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_favorite_match, container, false)
    }

    override fun hideSwipeRefresh() {
        swipe_refresh_layout_fav.isRefreshing = false
        mainProgressBarFav.hide()
        rvFootballFav.visibility = View.VISIBLE
    }
}