package com.example.instagramclone;

import android.app.Application;

import com.parse.Parse;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("e4kXZ9c6triF24OIEaRz8CXOvbCGlSSihUtyYzoE")
                // if defined
                .clientKey("MgslyJC7fxVThmdxB91vnDPZf6s1uxNeZZimgc7c")
                .server("https://parseapi.back4app.com/")
                .build()
        );
    }
}
