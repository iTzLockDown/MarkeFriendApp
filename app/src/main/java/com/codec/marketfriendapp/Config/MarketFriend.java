package com.codec.marketfriendapp.Config;

import android.app.Application;
import android.content.Context;

public class MarketFriend extends Application {
    private static MarketFriend instance;

    public static MarketFriend getInstance()
    {
        return instance;
    }
    public static Context getContext()
    {
        return instance;
    }

    @Override
    public void onCreate()
    {
        instance=this;
        super.onCreate();
    }
}
