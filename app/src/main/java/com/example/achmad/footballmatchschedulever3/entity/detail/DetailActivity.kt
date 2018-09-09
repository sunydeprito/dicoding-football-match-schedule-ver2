package com.example.achmad.footballmatchschedulever3.entity.detail

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.example.achmad.footballmatchschedulever3.api.TheSportDBApi
import com.example.achmad.footballmatchschedulever3.api.TheSportDBRest
import com.example.achmad.footballmatchschedulever3.model.matchevent.MatchEvent
import com.example.achmad.footballmatchschedulever3.model.matchevent.MatchEventPresenter
import com.example.achmad.footballmatchschedulever3.model.teams.Teams
import com.example.achmad.footballmatchschedulever3.R
import com.example.achmad.footballmatchschedulever3.R.drawable.*
import com.example.achmad.footballmatchschedulever3.R.id.add_to_favorite
import com.example.achmad.footballmatchschedulever3.R.menu.detail_menu
import com.example.achmad.footballmatchschedulever3.db.FavoriteMatch
import com.example.achmad.footballmatchschedulever3.model.repo.RepositoryPresenter
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail.*
import org.jetbrains.anko.toast

@SuppressLint("Registered")
class DetailActivity : AppCompatActivity(), DetailView.View {
    private var menuItem: Menu? = null
    private var isFavorite: Boolean = false

    private lateinit var matchEvent: MatchEvent

    private lateinit var mPresenter: DetailPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val service = TheSportDBApi.getClient().create(TheSportDBRest::class.java)
        val repository = RepositoryPresenter(applicationContext)
        val request = MatchEventPresenter(service)
        mPresenter = DetailPresenter(this, request, repository)

        matchEvent = intent.getParcelableExtra<MatchEvent>("match")
        mPresenter.checkMatch(matchEvent.idEvent.toString())
        mPresenter.getTeamsBadgeAway(matchEvent.idAwayTeam)
        mPresenter.getTeamsBadgeHome(matchEvent.idHomeTeam)
        Data(matchEvent)
        supportActionBar?.title = matchEvent.strEvent
    }

    private fun Data(matchEvent: MatchEvent) {
        if (matchEvent.intHomeScore == null) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                match_date.setTextColor(applicationContext.getColor(R.color.colorAccent))
            }
        }

        match_date.text = matchEvent.dateEvent
        home_score_match.text = matchEvent.intHomeScore
        away_score_match.text = matchEvent.intAwayScore

        home_goalkeeper.text = matchEvent.strHomeLineupGoalkeeper
        away_goalkeeper.text = matchEvent.strAwayLineupGoalkeeper

        home_defense.text = matchEvent.strHomeLineupDefense
        away_defense.text = matchEvent.strAwayLineupDefense

        home_midfield.text = matchEvent.strHomeLineupMidfield
        away_midfield.text = matchEvent.strAwayLineupMidfield

        home_forward.text = matchEvent.strHomeLineupForward
        away_forward.text = matchEvent.strAwayLineupForward

        home_substitutes.text = matchEvent.strHomeLineupSubstitutes
        away_substitutes.text = matchEvent.strAwayLineupSubstitutes

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(detail_menu, menu)
        menuItem = menu
        setFavorite()
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                finish()
                true
            }
            R.id.add_to_favorite -> {
                if (!isFavorite){
                    mPresenter.insertMatch(
                            matchEvent.idEvent.toString(), matchEvent.idHomeTeam, matchEvent.idAwayTeam)
                    toast("added match to favorite")
                    isFavorite = !isFavorite
                }else{
                    mPresenter.deleteMatch(matchEvent.idEvent.toString())
                    toast("Remove match from favorite")
                    isFavorite = !isFavorite
                }
                setFavorite()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
    override fun displayTeamBadgeAway(team: Teams) {
        Picasso.get()
                .load(team.strTeamBadge)
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)
                .into(img_away)
    }

    override fun displayTeamBadgeHome(team: Teams) {

        Picasso.get()
                .load(team.strTeamBadge)
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)
                .into(img_home)
    }
    private fun setFavorite() {
        if (isFavorite)
            menuItem?.getItem(0)?.icon = ContextCompat.getDrawable(this, R.drawable.ic_added_to_favorites)
        else
            menuItem?.getItem(0)?.icon = ContextCompat.getDrawable(this, R.drawable.ic_favorites)
    }
    override fun setFavoriteState(favList: List<FavoriteMatch>) {
        if(!favList.isEmpty()) isFavorite = true
    }
}