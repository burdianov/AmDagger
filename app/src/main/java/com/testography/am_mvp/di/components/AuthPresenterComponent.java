package com.testography.am_mvp.di.components;

import com.testography.am_mvp.di.modules.AuthPresenterModule;
import com.testography.am_mvp.mvp.presenters.AuthPresenter;

import dagger.Component;

@Component(modules = AuthPresenterModule.class)
public interface AuthPresenterComponent {
    void inject(AuthPresenter presenter);
}
