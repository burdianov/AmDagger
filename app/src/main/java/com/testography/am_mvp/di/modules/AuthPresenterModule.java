package com.testography.am_mvp.di.modules;

import com.testography.am_mvp.mvp.models.AuthModel;

import dagger.Module;
import dagger.Provides;

@Module
public class AuthPresenterModule {

    @Provides
    AuthModel provideAuthModel() {
        return new AuthModel();
    }
}
