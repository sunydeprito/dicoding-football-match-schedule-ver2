package com.example.achmad.footballmatchschedulever3.entity.favorite

import com.example.achmad.footballmatchschedulever3.R
import com.example.achmad.footballmatchschedulever3.R.id.*
import com.example.achmad.footballmatchschedulever3.model.matchevent.MatchEvent
import com.example.achmad.footballmatchschedulever3.model.matchevent.MatchEventPresenter
import com.example.achmad.footballmatchschedulever3.model.repo.RepositoryPresenter
import com.example.achmad.footballmatchschedulever3.utils.AppSchedulerProvider
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class FavoriteMatchPresenter(private val mView: FavoriteMatchView.View,
                             private val matchPresenter: MatchEventPresenter,
                             private val repositoryPresenter: RepositoryPresenter,
                             private val appSchedulerProvider: AppSchedulerProvider) : FavoriteMatchView.Presenter {

    override fun getFootballMatchData() {
        val compositeDisposable = CompositeDisposable()
        mView.showLoading()
        val favoriteList = repositoryPresenter.getMatchFromDb()

        val eventList: MutableList<MatchEvent> = mutableListOf()
        for (fav in favoriteList) {
            compositeDisposable.add(matchPresenter.getEventById(fav.idEvent)
                    .observeOn(appSchedulerProvider.ui())
                    .subscribeOn(appSchedulerProvider.io())
                    .subscribe {
                        eventList.add(it.events[0])
                        mView.displayFootballMatch(eventList)
                        mView.hideLoading()
                        mView.hideSwipeRefresh()
                    })
        }

        if (favoriteList.isEmpty()) {
            mView.hideLoading()
            mView.displayFootballMatch(eventList)
            mView.hideSwipeRefresh()
        }

    }
}