package com.example.myapplication;
//
import android.app.Application;
import android.util.Log;

//import com.facebook.flipper.android.AndroidFlipperClient;
//import com.facebook.flipper.android.utils.FlipperUtils;
//import com.facebook.flipper.core.FlipperClient;
//import com.facebook.flipper.plugins.inspector.DescriptorMapping;
//import com.facebook.flipper.plugins.inspector.InspectorFlipperPlugin;
//import com.facebook.flipper.plugins.network.FlipperOkhttpInterceptor;
//import com.facebook.flipper.plugins.network.NetworkFlipperPlugin;
//import com.facebook.soloader.SoLoader;
//
//import okhttp3.OkHttpClient;
//
public class MainApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

//        A-> B-> Des A-> List
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread paramThread, Throwable paramThrowable) {
//                List
            }
        });
//        SoLoader.init(this, false);
//
//        if (BuildConfig.DEBUG && FlipperUtils.shouldEnableFlipper(this)) {
//            final FlipperClient client = AndroidFlipperClient.getInstance(this);
//            client.addPlugin(new InspectorFlipperPlugin(this, DescriptorMapping.withDefaults()));
//
//            NetworkFlipperPlugin networkFlipperPlugin = new NetworkFlipperPlugin();
//            client.addPlugin(networkFlipperPlugin);
//            client.start();
//        }
    }
}
