package com.bookofsun.ui.fragments.web.presenter;

import com.bookofsun.ui.base.BasePresenter;
import com.bookofsun.ui.fragments.web.view.WebView;

import javax.inject.Inject;

public class WebPresenter extends BasePresenter<WebView> {

    @Inject
    WebPresenter(){
    }

    public void showSite() {
        getView().showSite();
    }
}
