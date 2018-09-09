package com.example.achmad.footballmatchschedulever3.model.teams

import com.google.gson.annotations.SerializedName

data class TeamsResponse(
        @SerializedName("teams")
        var teams: List<Teams>)