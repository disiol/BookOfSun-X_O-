package com.bookofsun.di.modules;

import com.bookofsun.di.scopes.ActivityScope;
import com.bookofsun.di.scopes.FragmentScope;
import com.bookofsun.routers.main.MainActivityRouter;
import com.bookofsun.routers.main.MainActivityRouterImpl;
import com.bookofsun.ui.fragments.start.view.StartFragment;
import com.bookofsun.ui.fragments.web.view.WebFragment;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public interface MainActivityModule {
    @ActivityScope
    @Binds
    MainActivityRouter mainActivityRouter(MainActivityRouterImpl mainRouter);

    @FragmentScope
    @ContributesAndroidInjector
    WebFragment webFragment();

    @FragmentScope
    @ContributesAndroidInjector
    StartFragment logoFragment();


}
