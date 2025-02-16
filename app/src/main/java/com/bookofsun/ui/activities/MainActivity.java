package com.bookofsun.ui.activities;


import android.os.Bundle;
import android.util.Base64;
import android.util.Log;


import com.android.installreferrer.BuildConfig;
import com.bookofsun.R;
import com.bookofsun.manedger.PreferencesManager;
import com.bookofsun.routers.main.MainActivityRouter;
import com.bookofsun.ui.base.BaseActivity;
import com.facebook.applinks.AppLinkData;

import java.nio.charset.StandardCharsets;

import javax.inject.Inject;

import static com.bookofsun.constants.Constants.DEPLINK;
import static com.bookofsun.constants.Constants.URI_STRING;


public class MainActivity extends BaseActivity {

    @Inject
    MainActivityRouter mainActivityRouter;
    @Inject
    PreferencesManager preferencesManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//
//        Map<String, Object> eventValue = new HashMap<String, Object>();
//        AppsFlyerLib.getInstance().trackEvent(getApplicationContext() , "af_registration" , eventValue);
//        AppsFlyerLib.getInstance().trackEvent(getApplicationContext() , "af_purchase" , eventValue);

        if (preferencesManager.getMyFirstTime()) {
             GetGAIDTask();
        }

        mainActivityRouter.showLogoFragment();

    }

    public static String convertArrayToStringMethod(String[] strArray) {

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < strArray.length; i++) {

            stringBuilder.append(strArray[i]);

        }

        return stringBuilder.toString();

    }

    private void GetGAIDTask() {


            AppLinkData.fetchDeferredAppLinkData(getApplicationContext(), appLinkData -> {
                AppLinkData appLinkData1 = appLinkData;
                if (appLinkData1 == null || appLinkData1.getTargetUri() == null) {
                    Log.e("MyLog", "deeplink = null");
                    String token =decodeBase64(URI_STRING);

                    preferencesManager.setURL(token);
                    Log.e("MyLog", "token = " + token);


                } else {

                    String url = appLinkData1.getTargetUri().toString();
                    if (BuildConfig.DEBUG) {
                        Log.d("MyLog", "deeplink = ");
                        Log.d("MyLog", "deeplink = " + url);

                        Log.d("my Log", "App Link appLinkData: " + url);
                    }
                    String string = convertArrayToStringMethod(url.split(DEPLINK));

                    if (BuildConfig.DEBUG) {
                        Log.d("MyLog", "App Link appLinkData url: " + url);

                        Log.d("MyLog", "App Link appLinkData string: " + string);
                    }
                    String token = decodeBase64(URI_STRING) + string;

                    if (BuildConfig.DEBUG) {
                        Log.d("MyLog", "App Link appLinkData token: " + token);
                    }
                    Log.e("MyLog", "token = " + token);

                    preferencesManager.setURL(token);
                }
            });

        }


    private String decodeBase64(String coded) {
        byte[] valueDecoded = new byte[0];
        valueDecoded = Base64.decode(coded.getBytes(StandardCharsets.UTF_8), Base64.DEFAULT);
        return new String(valueDecoded);
    }

}
