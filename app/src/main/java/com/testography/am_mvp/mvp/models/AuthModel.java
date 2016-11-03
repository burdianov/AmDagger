package com.testography.am_mvp.mvp.models;

import com.testography.am_mvp.data.managers.DataManager;

public class AuthModel {

    private DataManager mDataManager;

    public AuthModel() {
        mDataManager = DataManager.getInstance();
    }

    public boolean isAuthUser() {
        return mDataManager.isAuthUser();
    }

    public void loginUser(String email, String password) {
        mDataManager.loginUser(email, password);
    }
}
