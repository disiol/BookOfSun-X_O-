package com.bookofsun.di.modules;

import android.content.Context;


import com.bookofsun.manedger.PreferencesManager;
import com.bookofsun.manedger.PreferencesManagerImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ManagersModule {

    @Provides
    @Singleton
    PreferencesManager providePreferencesManager(Context context){
        return new PreferencesManagerImpl(context);
    }


}
