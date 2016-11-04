package com.testography.am_mvp.di.components;

import com.testography.am_mvp.di.modules.AuthViewModule;
import com.testography.am_mvp.ui.activities.SplashActivity;

import javax.inject.Singleton;

import dagger.Component;

@Component(modules = AuthViewModule.class)
@Singleton
public interface AuthViewComponent {
    void inject(SplashActivity activity);
}
