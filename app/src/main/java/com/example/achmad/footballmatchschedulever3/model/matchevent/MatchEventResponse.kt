package com.example.achmad.footballmatchschedulever3.model.matchevent

import com.google.gson.annotations.SerializedName

data class MatchEventResponse (
        @SerializedName("events") var events: List<MatchEvent>)
