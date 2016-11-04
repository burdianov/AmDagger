package com.testography.am_mvp.di.components;

import com.testography.am_mvp.di.modules.AuthViewModel;
import com.testography.am_mvp.ui.activities.SplashActivity;

import javax.inject.Singleton;

import dagger.Component;

@Component(modules = AuthViewModel.class)
@Singleton
public interface AuthViewComponent {
    void inject(SplashActivity activity);
}
