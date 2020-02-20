package com.test.alarmmanagerdemo;


import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.util.Log;
import android.widget.Toast;

import androidx.core.app.NotificationCompat;


public class AccueWeatherBroadcastReciever extends BroadcastReceiver {
    Context context;
    String latitude;
    String longitude;
    String name;

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,"Hiiiiiiiiiiiiiiiiiiiiiii", Toast.LENGTH_SHORT).show();
    }

/*
    private void callAccueWeatherApi(String latitude, String longitude) {
        RestAdapter rest_adapter = new RestAdapter.Builder().setEndpoint("http://dataservice.accuweather.com").setLogLevel(RestAdapter.LogLevel.FULL).build();
        final ApiInterface apiInterface = rest_adapter.create(ApiInterface.class);
        try {
            apiInterface.getAccueLocationDetails("XmYWQCaMRYuVCT2MsmQH4JG7B3JYtvLc", latitude + "," + longitude, true, true, new Callback<JsonObject>() {
                @Override
                public void success(JsonObject jsonObject, Response response) {
                    if (jsonObject != null && jsonObject.has("Key") && jsonObject.get("Key") != null) {
                        Log.v("ACCUE_LOC", jsonObject.toString());
                        callAccueForecastWeatherApi(jsonObject.get("Key").getAsInt());
                    }
                }

                @Override
                public void failure(RetrofitError error) {
                    Log.v("ACCUE", error.toString());
                }
            });
        } catch (Exception e) {
            Log.v("ACCUE", e.toString());
        }
    }
*/

/*
    private void callAccueForecastWeatherApi(int key) {
        RestAdapter rest_adapter = new RestAdapter.Builder().setEndpoint("http://dataservice.accuweather.com").setLogLevel(RestAdapter.LogLevel.FULL).build();
        final ApiInterface apiInterface = rest_adapter.create(ApiInterface.class);
        try {
            apiInterface.getAccueForcastDetails(key, "XmYWQCaMRYuVCT2MsmQH4JG7B3JYtvLc", true, true, new Callback<JsonObject>() {
                @Override
                public void success(JsonObject jsonObject, Response response) {
                    Log.v("ACCUE_FOR", jsonObject.toString());
                    if (jsonObject.has("Headline") && jsonObject.get("Headline") != null) {
                        String notificationText = "";
                        if (jsonObject.has("Headline") && jsonObject.get("Headline") != null) {
                            notificationText ="Here is the weather & air quality update for you today."+"\n"+ jsonObject.get("Headline").getAsJsonObject().get("Text").toString().replaceAll("^\"+|\"+$", "") +
                                    "\n" + "Air Quality Today: "+jsonObject.get("DailyForecasts").getAsJsonArray().get(0).getAsJsonObject().get("AirAndPollen").getAsJsonArray().get(0).getAsJsonObject().get("Value").toString() + "("+ jsonObject.get("DailyForecasts").getAsJsonArray().get(0).getAsJsonObject().get("AirAndPollen").getAsJsonArray().get(0).getAsJsonObject().get("Type").toString().replaceAll("^\"+|\"+$", "")+")"
                                    + "\n" + "Temperature: " +"High: "+ jsonObject.get("DailyForecasts").getAsJsonArray().get(0).getAsJsonObject().get("Temperature").getAsJsonObject().get("Maximum").getAsJsonObject().get("Value").toString() + "\u2103" +","+" Low: "+jsonObject.get("DailyForecasts").getAsJsonArray().get(0).getAsJsonObject().get("Temperature").getAsJsonObject().get("Minimum").getAsJsonObject().get("Value").toString() + "\u2103"
                                    +"\n"+"Rain Probability: "+jsonObject.get("DailyForecasts").getAsJsonArray().get(0).getAsJsonObject().get("Day").getAsJsonObject().get("RainProbability").toString();
                        }
                        showNotification(notificationText);
                    }
                }

                @Override
                public void failure(RetrofitError error) {
                    Log.v("ACCUEForecast", error.toString());
                }
            });
        } catch (Exception e) {
            Log.v("ACCUEForecast", e.toString());

        }
    }
*/

/*
    private void showNotification(String notificationText) {
        Uri defaultSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        Intent intent = new Intent(context, SplashScreenActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        String NOTIFICATION_CHANNEL_ID = "101";
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            @SuppressLint("WrongConstant")
            NotificationChannel notificationChannel = new NotificationChannel(NOTIFICATION_CHANNEL_ID, "Notification", NotificationManager.IMPORTANCE_MAX);
            //Configure Notification Channel
            notificationChannel.setDescription(notificationText);
            notificationChannel.enableLights(true);
            notificationChannel.setVibrationPattern(new long[]{200});
            notificationChannel.enableVibration(false);
            notificationManager.createNotificationChannel(notificationChannel);
        }
        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(context, NOTIFICATION_CHANNEL_ID)
                .setSmallIcon(R.drawable.app_icon)
                .setContentTitle("Hello "+name)
                .setStyle(new NotificationCompat.BigTextStyle()
                        .bigText(notificationText))
                .setAutoCancel(true)
                .setSound(defaultSound)
                .setContentIntent(pendingIntent)
                .setWhen(System.currentTimeMillis())
                .setPriority(Notification.PRIORITY_MAX);
        notificationManager.notify(1, notificationBuilder.build());
        GlobalPreferences.setDefaultsBoolean(VO.ACCUEWEATHER_CHECKED, true, context);
    }
*/

}