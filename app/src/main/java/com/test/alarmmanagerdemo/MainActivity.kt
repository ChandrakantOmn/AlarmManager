package com.test.alarmmanagerdemo

import android.annotation.SuppressLint
import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        startAlarmBroadcastReceiver1(this, 2000)
        // setAccueWeatherFor7AM()
        dataTv.setOnClickListener {
            displayData()
        }
        displayData()
    }

    private fun displayData() {
        val list = DatabaseClient.getInstance(this)?.getAppDatabase()?.taskDao()?.getAll()
        list?.let {
            if (list.isNotEmpty()) {
                var text = "Data::"
                list.iterator().forEach {
                    text = text + "\n" + getTime(it?.time)

                }
                dataTv.text=text
            }
        }
    }

    private fun getTime(time: Long?): String? {
        return try {
            @SuppressLint("SimpleDateFormat") val formatter: DateFormat =
                SimpleDateFormat("MM/dd/yyyy - hh:mm:SS a")
            val calendar = Calendar.getInstance()
            if (time != null) {
                calendar.timeInMillis = time
            }
            formatter.format(calendar.time)
        } catch (e: java.lang.NumberFormatException) {
            e.printStackTrace()
            "-"
        }
    }

    @SuppressLint("ShortAlarm")
    private fun startAlarmBroadcastReceiver1(context: Context, delay: Long) {
        val _intent = Intent(context, AlarmBroadcastReceiver::class.java)
        val pendingIntent = PendingIntent.getBroadcast(context, 0, _intent, 0)
        // Set the alarm to start at approximately 2:00 p.m.
        val calendar: Calendar = Calendar.getInstance().apply {
            timeInMillis = System.currentTimeMillis()
            set(Calendar.HOUR_OF_DAY, 17)
            set(Calendar.MINUTE, 45)
        }
        val alarmManager =
            context.getSystemService(Context.ALARM_SERVICE) as AlarmManager

/*
        alarmManager?.setInexactRepeating(
            AlarmManager.RTC_WAKEUP,
            calendar.timeInMillis,
            AlarmManager.INTERVAL_DAY,
            pendingIntent
        )
*/
        alarmManager?.setRepeating(
            AlarmManager.RTC_WAKEUP,
            calendar.timeInMillis,
            1000 * 2,
            pendingIntent
        )

    }

    private fun startAlarmBroadcastReceiver(context: Context, delay: Long) {
        val _intent = Intent(context, AlarmBroadcastReceiver::class.java)
        val pendingIntent = PendingIntent.getBroadcast(context, 0, _intent, 0)
        val alarmManager =
            context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        // Remove any previous pending intent.
        //  alarmManager.cancel(pendingIntent)
        val calendar: Calendar = Calendar.getInstance()
        //  alarmManager[AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + delay] = pendingIntent
        //  alarmManager[AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + delay] = pendingIntent
        alarmManager.setRepeating(
            AlarmManager.RTC_WAKEUP,
            System.currentTimeMillis() + delay,
            3000,
            pendingIntent
        )

    }

    private fun setAccueWeatherFor7AM() {
        val calendar: Calendar = Calendar.getInstance()
        calendar.set(Calendar.HOUR_OF_DAY, 15)
        calendar.set(Calendar.MINUTE, 0)
        calendar.set(Calendar.SECOND, 0)
        val notifyIntent =
            Intent(applicationContext, AccueWeatherBroadcastReciever::class.java)
        notifyIntent.flags = Intent.FLAG_INCLUDE_STOPPED_PACKAGES
        val pendingIntent = PendingIntent.getBroadcast(
            applicationContext,
            0,
            notifyIntent,
            PendingIntent.FLAG_UPDATE_CURRENT
        )
        val alarmManager =
            getSystemService(Context.ALARM_SERVICE) as AlarmManager
        //        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), 1000 * 3, pendingIntent);
/*
        alarmManager.setRepeating(
            AlarmManager.RTC_WAKEUP,
            calendar.timeInMillis,
            1000 * 60 * 60 * 24.toLong(),
            pendingIntent
        )
*/
        alarmManager.setRepeating(
            AlarmManager.RTC_WAKEUP,
            calendar.timeInMillis,
            5000,
            pendingIntent
        )
    }
}
