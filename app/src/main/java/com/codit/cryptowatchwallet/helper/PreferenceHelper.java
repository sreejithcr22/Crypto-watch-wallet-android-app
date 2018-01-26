package com.codit.cryptowatchwallet.helper;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by Sreejith on 28-Nov-17.
 */

public class PreferenceHelper {

    public static final String DEFAULT_CURRENCY="default_currency";
    public static final String REFRESH_INTERVAL="refresh_interval";
    public static final String SESSION_COUNT="session_count";
    public static boolean SESSION_COUNT_UPDATED=false;
    public  static final String UNIQUE_ID ="nitif_id";
    public static final String NOTIFICATION_Q="notif_q";

    SharedPreferences preferenceManager;

    public PreferenceHelper(Context context)
    {
        preferenceManager= PreferenceManager.getDefaultSharedPreferences(context);

    }

    public void setDefaultCurrency(int arrayPos){preferenceManager.edit().putInt(DEFAULT_CURRENCY,arrayPos).apply();}
    public int getDefaultCurrency(){return preferenceManager.getInt(DEFAULT_CURRENCY,0);}
    public void setSessionCount(int sessionCount){preferenceManager.edit().putInt(SESSION_COUNT,sessionCount).apply();}
    public int getSessionCount(){return preferenceManager.getInt(SESSION_COUNT,0);}
    private int getUniqueID() {return preferenceManager.getInt(UNIQUE_ID,1);}
    public String getNotificationQ(){return preferenceManager.getString(NOTIFICATION_Q,null);}

    public int generateUniqueID()
    {
        preferenceManager.edit().putInt(UNIQUE_ID, getUniqueID()+1).commit();
        return getUniqueID();
    }

    public void updateNotificationQ(String jsonString)
    {
        preferenceManager.edit().putString(NOTIFICATION_Q,jsonString).commit();
    }

}
