package com.fcg.mahmoudfaragallah.my_fcg.util;

import com.fcg.mahmoudfaragallah.my_fcg.BuildConfig;

/**
 * Created by Mahmoud
 */
public interface ApplicationConstants {

    String PROJECT_TAG = "fcg_profiles_app";

    boolean DEVELOPMENT_MODE = BuildConfig.DEBUG;

    // API Cache size
    int CACHE_SIZE = 10 * 1024 * 1024; // 10 MB
}
