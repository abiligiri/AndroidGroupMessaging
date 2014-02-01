package com.example.groupmessaging.app;

import android.content.Context;

import com.example.groupmessaging.restapi.GroupMessagingClient;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.parse.Parse;

public class GroupMessagingApp extends com.activeandroid.app.Application {
	private static Context context;
	
    @Override
    public void onCreate() {
        super.onCreate();
        GroupMessagingApp.context = this;
        Parse.initialize(this, "0Ww7pdfeUtCjOqXfbwWWzfQ77ySJtrJnE1PlMRXI", "9dU5uU9Yaw925hhjgKD0aQrfMVxfFQ76QaZXaUQM");
        // Create global configuration and initialize ImageLoader with this configuration
        DisplayImageOptions defaultOptions = new DisplayImageOptions.Builder().
        		cacheInMemory().cacheOnDisc().build();
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(getApplicationContext())
            .defaultDisplayImageOptions(defaultOptions)
            .build();
        ImageLoader.getInstance().init(config);
    }
    
    public static GroupMessagingClient getRestClient() {
    	return (GroupMessagingClient) GroupMessagingClient.getInstance(GroupMessagingApp.context);
    }

}
