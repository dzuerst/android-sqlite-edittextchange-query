package com.neonusa.belajarnavigationdrawer.room

import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity(tableName= "tbl_words")
@Parcelize
data class Word (
    @PrimaryKey
    @NonNull
    var id: Int,

    @NonNull
    @ColumnInfo(name = "word")
    var word: String,

    @NonNull
    @ColumnInfo(name = "definition")
    var definition: String,

    @NonNull
    @ColumnInfo(name = "isMarked")
    var isMarked: Int = 0

): Parcelable