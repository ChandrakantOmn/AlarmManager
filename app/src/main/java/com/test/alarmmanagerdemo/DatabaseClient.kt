package com.test.alarmmanagerdemo

import android.content.Context
import androidx.room.Room




/**
 * Created by Chandra Kant on 20/2/20.
 */

class DatabaseClient  constructor(mCtx: Context) {
    private val appDatabase: AppDatabase =
        Room.databaseBuilder<AppDatabase>(mCtx, AppDatabase::class.java, "MyToDos").allowMainThreadQueries().build()
    fun getAppDatabase(): AppDatabase {
        return appDatabase
    }

    companion object {
        private var mInstance: DatabaseClient? = null
        @Synchronized
        fun getInstance(mCtx: Context): DatabaseClient? {
            if (mInstance == null) {
                mInstance = DatabaseClient(mCtx)
            }
            return mInstance
        }
    }

    init {
        //creating the app database with Room database builder
//MyToDos is the name of the database
    }
}