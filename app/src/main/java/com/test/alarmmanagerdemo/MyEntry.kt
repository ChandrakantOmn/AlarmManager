package com.test.alarmmanagerdemo

import androidx.room.Entity
import androidx.room.PrimaryKey




@Entity
class MyEntry {
    @PrimaryKey(autoGenerate = true)
     var id = 0
     var time: Long?=0L
}
