package com.example.unlimit.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "jokes")
data class Joke(
    @SerializedName("joke") val joke: String,
    @SerializedName("id") @PrimaryKey(autoGenerate = true) val id: Long
)
