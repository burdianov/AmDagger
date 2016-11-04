package com.testography.am_mvp.data.managers;

import android.content.SharedPreferences;

import com.testography.am_mvp.App;
import com.testography.am_mvp.utils.ConstantsManager;

public class PreferencesManager {
    private SharedPreferences mSharedPreferences;

    public PreferencesManager() {
        mSharedPreferences = App.getSharedPreferences();
    }

    public void saveAuthToken(String authToken) {
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString(ConstantsManager.AUTH_TOKEN_KEY, authToken);
        editor.apply();
    }

    public String getAuthToken() {
        return mSharedPreferences.getString(ConstantsManager.AUTH_TOKEN_KEY,
                ConstantsManager.INVALID_TOKEN);
    }

    public void clearAllData() {
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.clear();
        editor.apply();
    }
}
