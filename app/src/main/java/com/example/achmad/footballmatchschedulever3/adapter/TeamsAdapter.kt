package com.example.achmad.footballmatchschedulever3.adapter

import android.content.Context
import android.os.Build
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.achmad.footballmatchschedulever3.entity.detail.DetailActivity
import com.example.achmad.footballmatchschedulever3.model.matchevent.MatchEvent
import com.example.achmad.footballmatchschedulever3.R
import kotlinx.android.synthetic.main.match_item.view.*
import org.jetbrains.anko.startActivity

class TeamsAdapter(private val eventList:List<MatchEvent>, val context: Context?): RecyclerView.Adapter<TeamsAdapter.ClubViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClubViewHolder {
        return ClubViewHolder(LayoutInflater.from(context).inflate(R.layout.match_item, parent, false))
    }

    override fun getItemCount(): Int = eventList.size


    override fun onBindViewHolder(holder: ClubViewHolder, position: Int) {
        holder.bind(eventList[position])
    }

    inner class ClubViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(event: MatchEvent){
            if(event.intHomeScore == null) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    if (context != null) {
                        itemView.dateScheduleTv.setTextColor(context.getColor(R.color.colorAccent))
                    }
                }
            }
            itemView.dateScheduleTv.text = event.dateEvent
            itemView.homeNameTv.text = event.strHomeTeam
            itemView.homeScoreTv.text = event.intHomeScore
            itemView.awayNameTv.text = event.strAwayTeam
            itemView.awayScoreTv.text = event.intAwayScore


            itemView.setOnClickListener {
                itemView.context.startActivity<DetailActivity>("match" to event)
            }
        }
    }

}