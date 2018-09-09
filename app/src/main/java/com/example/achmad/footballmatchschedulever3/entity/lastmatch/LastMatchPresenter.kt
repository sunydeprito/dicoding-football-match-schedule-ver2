package com.example.achmad.footballmatchschedulever3.entity.lastmatch

import com.example.achmad.footballmatchschedulever3.model.matchevent.MatchEventPresenter
import com.example.achmad.footballmatchschedulever3.utils.AppSchedulerProvider
import com.example.achmad.footballmatchschedulever3.utils.SchedulerProviderView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers


class LastMatchPresenter(private val mView : LastMatchView.View, private val matchEventPresenter: MatchEventPresenter,
                         private val appSchedulerProvider: SchedulerProviderView) : LastMatchView.Presenter {

    private val compositeDisposable = CompositeDisposable()

    override fun getFootballData() {
        mView.showLoading()
        compositeDisposable.add(matchEventPresenter.getFootballMatch("4332")
                .observeOn(appSchedulerProvider.ui())
                .subscribeOn(appSchedulerProvider.io())
                .subscribe {
                    mView.displayFootballMatch(it.events)
                    mView.hideLoading()

                })
    }
}