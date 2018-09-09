package com.example.achmad.footballmatchschedulever3.entity.nextmatch

import com.example.achmad.footballmatchschedulever3.model.matchevent.MatchEventPresenter
import com.example.achmad.footballmatchschedulever3.utils.SchedulerProviderView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers


class NextMatchPresenter(private val mView: NextMatchView.View, private val matchEventPresenter: MatchEventPresenter, private val schedulers: SchedulerProviderView) : NextMatchView.Presenter {

    private val compositeDisposable = CompositeDisposable()

    override fun getFootballUpcomingData() {
        mView.showLoading()
        compositeDisposable.add(matchEventPresenter.getUpcomingMatch("4332")
                .observeOn(schedulers.ui())
                .subscribeOn(schedulers.io())
                .subscribe {
                    mView.displayFootballMatch(it.events)
                    mView.hideLoading()

                })
    }
}