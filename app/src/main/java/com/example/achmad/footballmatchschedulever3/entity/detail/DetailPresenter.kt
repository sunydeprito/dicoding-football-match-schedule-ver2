package com.example.achmad.footballmatchschedulever3.entity.detail

import com.example.achmad.footballmatchschedulever3.model.matchevent.MatchEventPresenter
import com.example.achmad.footballmatchschedulever3.model.repo.RepositoryPresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class DetailPresenter(private val mView: DetailView.View, private val matchEventPresenter: MatchEventPresenter, private val repositoryPresenter: RepositoryPresenter) : DetailView.Presenter {
    private val compositeDisposable = CompositeDisposable()
    override fun getTeamsBadgeHome(id: String) {
        compositeDisposable.add(matchEventPresenter.getTeams(id)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe {
                    mView.displayTeamBadgeHome(it.teams[0])
                })
    }

    override fun getTeamsBadgeAway(id: String) {
        compositeDisposable.add(matchEventPresenter.getTeams(id)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe {
                    mView.displayTeamBadgeAway(it.teams[0])
                })
    }

    override fun deleteMatch(id: String) {
        repositoryPresenter.deleteData(id)
    }

    override fun checkMatch(id: String) {
        mView.setFavoriteState(repositoryPresenter.checkFavorite(id))
    }

    override fun insertMatch(eventId: String, homeId: String, awayId: String) {
        repositoryPresenter.insertData(eventId, homeId, awayId)
    }
}