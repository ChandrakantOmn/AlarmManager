package com.test.alarmmanagerdemo

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

/**
 * Created by Chandra Kant on 20/2/20.
 */
class AlarmBroadcastReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        Toast.makeText(
            context,
            "Hii cfesdghfjyhtr3wegrhthtregthjytregthtregthtrghtrhthytrh",
            Toast.LENGTH_SHORT
        ).show()
        val entry = MyEntry()
        entry.time = System.currentTimeMillis()
        DatabaseClient.getInstance(context)?.getAppDatabase()?.taskDao()?.insert(entry)
    }
}