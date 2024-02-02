package com.example.shoppingapp.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "user")
data class User(

    @PrimaryKey(autoGenerate = true)
    var id: Long=0,
    @ColumnInfo(name = "first_name")
    var firstName: String,

    @ColumnInfo(name = "last_name")
    var lastName: String,

    @ColumnInfo(name = "email")
    var email: String,

    @ColumnInfo(name = "address")
    var address: String,

    @ColumnInfo(name = "password")
    var password: String,

    @ColumnInfo(name = "dob")
    var dob: String


    )
