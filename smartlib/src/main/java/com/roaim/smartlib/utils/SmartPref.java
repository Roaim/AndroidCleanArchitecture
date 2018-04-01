package com.roaim.smartlib.utils;
import java.util.Locale;

/**
 * Created by hridoy on 3/27/18.
 */

public interface SmartPref {
    String getString(String key);
    boolean getBoolean(String key);
    float getFloat(String key);
    int getInt(String key);
    long getLong(String key);
    Locale getLocale();

    void setString(String key, String value);
    void setBoolean(String key, boolean value);
    void setFloat(String key, float value);
    void setInt(String key, int value);
    void setLong(String key, long value);
    void setLocale(String locale);

    void destroy();
}
