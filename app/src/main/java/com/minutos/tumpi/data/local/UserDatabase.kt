package com.minutos.tumpi.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.minutos.tumpi.domain.model.User

@Database(
    entities = [User::class],
    version = 1,
    exportSchema = false
)

abstract class UserDatabase: RoomDatabase() {
    abstract val userDao: UserDao
}