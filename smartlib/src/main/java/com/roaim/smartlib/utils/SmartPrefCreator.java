package com.roaim.smartlib.utils;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.Locale;

/**
 * Created by hridoy on 3/27/18.
 */

public class SmartPrefCreator implements SmartPref {
    private static final String KEY_LOCALE = "locale";

    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;

    public static SmartPref createDefault(Context context) {
        return new SmartPrefCreator(context);
    }

    public static SmartPref create(Context context, String name) {
        return new SmartPrefCreator(context, name);
    }

    private SmartPrefCreator(Context context) {
        this(context, "SmartLib");
    }

    private SmartPrefCreator(Context context, String name) {
        preferences = context.getSharedPreferences(name, Context.MODE_PRIVATE);
        editor = preferences.edit();
    }

    @Override
    public String getString(String key) {
        return preferences.getString(key, "");
    }

    @Override
    public boolean getBoolean(String key) {
        return preferences.getBoolean(key, false);
    }

    @Override
    public float getFloat(String key) {
        return preferences.getFloat(key, 0);
    }

    @Override
    public int getInt(String key) {
        return preferences.getInt(key,0);
    }

    @Override
    public long getLong(String key) {
        return preferences.getLong(key, 0);
    }

    @Override
    public Locale getLocale() {
        String language = getString(KEY_LOCALE);
        return language.isEmpty() ? Locale.getDefault() : new Locale(language);
    }

    @Override
    public void setString(String key, String value) {
        editor.putString(key, value);
        editor.apply();
    }

    @Override
    public void setBoolean(String key, boolean value) {
        editor.putBoolean(key, value);
        editor.apply();
    }

    @Override
    public void setFloat(String key, float value) {
        editor.putFloat(key, value);
        editor.apply();
    }

    @Override
    public void setInt(String key, int value) {
        editor.putInt(key, value);
        editor.apply();
    }

    @Override
    public void setLong(String key, long value) {
        editor.putLong(key, value);
        editor.apply();
    }

    @Override
    public void setLocale(String language) {
        editor.putString(KEY_LOCALE, language);
        editor.apply();
    }

    @Override
    public void destroy() {
        preferences = null;
        editor = null;
    }

}
