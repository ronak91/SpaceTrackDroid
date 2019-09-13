package com.spacetrack.app.repository.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.spacetrack.app.repository.db.UserDao
import com.spacetrack.app.repository.data.User


@Database(entities = arrayOf(User::class), version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}