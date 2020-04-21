package com.bookofsun.routers.main;

import com.bookofsun.R;
import com.bookofsun.routers.base.BaseRouter;
import com.bookofsun.ui.activities.MainActivity;
import com.bookofsun.ui.fragments.start.view.StartFragment;
import com.bookofsun.ui.fragments.web.view.WebFragment;

import javax.inject.Inject;


public class MainActivityRouterImpl extends BaseRouter<MainActivity> implements MainActivityRouter {


    @Inject
    MainActivityRouterImpl(MainActivity activity) {
        super(activity);
    }



    @Override
    public void showLogoFragment() {
        if (!isCurrentFragment(R.id.fragment_container, StartFragment.class)) {
            replaceFragment(R.id.fragment_container, new StartFragment());
        }
    }
    @Override
    public void showWebFragment() {
        if(!isCurrentFragment(R.id.fragment_container, WebFragment.class)) {
            replaceFragment(R.id.fragment_container, new WebFragment());
        }
    }




}
