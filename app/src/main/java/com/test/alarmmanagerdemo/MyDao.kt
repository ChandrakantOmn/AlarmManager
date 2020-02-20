package com.test.alarmmanagerdemo

import androidx.room.*


@Dao
interface MyDao {
    @Query("SELECT * FROM myentry")
    fun getAll(): List<MyEntry?>?

    @Insert
    fun insert(task: MyEntry?)

    @Delete
    fun delete(task: MyEntry?)

    @Update
    fun update(task: MyEntry?)
}
