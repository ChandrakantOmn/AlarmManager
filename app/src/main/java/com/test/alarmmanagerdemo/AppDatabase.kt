package com.test.alarmmanagerdemo

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = [MyEntry::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun taskDao(): MyDao?
}