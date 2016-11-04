package com.testography.am_mvp.di.modules;

import com.testography.am_mvp.mvp.presenters.AuthPresenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AuthViewModel {
    @Provides
    @Singleton
    AuthPresenter provideAuthPresenter() {
        return new AuthPresenter();
    }
}
