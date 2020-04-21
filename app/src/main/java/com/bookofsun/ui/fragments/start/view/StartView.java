package com.bookofsun.ui.fragments.start.view;


import com.bookofsun.routers.main.MainActivityRouter;
import com.bookofsun.ui.base.BaseView;

public interface StartView extends BaseView {

    void showGame(MainActivityRouter mainActivityRouter);

    void showWeb(MainActivityRouter mainActivityRouter);
}
