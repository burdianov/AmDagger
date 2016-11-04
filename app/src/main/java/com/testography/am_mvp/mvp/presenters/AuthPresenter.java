package com.testography.am_mvp.mvp.presenters;

import android.content.Context;
import android.os.Handler;
import android.util.Log;

import com.testography.am_mvp.R;
import com.testography.am_mvp.data.managers.DataManager;
import com.testography.am_mvp.di.components.AuthPresenterComponent;
import com.testography.am_mvp.di.components.DaggerAuthPresenterComponent;
import com.testography.am_mvp.di.modules.AuthPresenterModule;
import com.testography.am_mvp.mvp.models.AuthModel;
import com.testography.am_mvp.mvp.views.IAuthView;
import com.testography.am_mvp.ui.custom_views.AuthPanel;
import com.testography.am_mvp.utils.CredentialsValidator;

import javax.inject.Inject;

public class AuthPresenter extends AbstractPresenter<IAuthView> implements
        IAuthPresenter {
    private static Context sAppContext = DataManager.getInstance().getAppContext();

    public static final String TAG = "AuthPresenter";

    @Inject
    AuthModel mAuthModel;

    public AuthPresenter() {
        mAuthModel = new AuthModel();
        AuthPresenterComponent component = createDaggerComponent();
        component.inject(this);
        Log.e(TAG, "AuthPresenter: inject complete");
    }

    @Override
    public void initView() {
        if (checkUserAuth()) {
            getView().showCatalogScreen();
        }
        if (getView() != null) {
            if (checkUserAuth()) {
                getView().hideLoginBtn();
            } else {
                getView().showLoginBtn();
            }
            getView().animateSocialButtons();
            getView().addChangeTextListeners();
            getView().setTypeface();
        }
    }

    @Override
    public void clickOnLogin() {
        if (getView() != null && getView().getAuthPanel() != null) {
            if (getView().getAuthPanel().isIdle()) {
                getView().getAuthPanel().setCustomState(AuthPanel.LOGIN_STATE);
            } else {
                String email = getView().getAuthPanel().getUserEmail();
                String password = getView().getAuthPanel().getUserPassword();

                if (!CredentialsValidator.isValidEmail(email)) {
                    getView().requestEmailFocus();
                    getView().showMessage(sAppContext.getString(R.string.err_msg_email));
                    return;
                }
                if (!CredentialsValidator.isValidPassword(password)) {
                    getView().requestPasswordFocus();
                    getView().showMessage(sAppContext.getString(R.string.err_msg_password));
                    return;
                }
                mAuthModel.loginUser(email, password);
                getView().showLoad();
                getView().showMessage("request for user auth");

                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    public void run() {
                        getView().hideLoad();
                    }
                }, 3000);
            }
        }
    }

    @Override
    public void clickOnFb() {
        if (getView() != null) {
            getView().showMessage("clickOnFb");
        }
    }

    @Override
    public void clickOnVk() {
        if (getView() != null) {
            getView().showMessage("clickOnVk");
        }
    }

    @Override
    public void clickOnTwitter() {
        if (getView() != null) {
            getView().showMessage("clickOnTwitter");
        }
    }

    @Override
    public void clickOnShowCatalog() {
        if (getView() != null) {
            // TODO: 28-Oct-16 start catalog screen if data updating is complete
            getView().showCatalogScreen();
        }
    }

    @Override
    public boolean checkUserAuth() {
        return mAuthModel.isAuthUser();
    }

    private AuthPresenterComponent createDaggerComponent() {
        return DaggerAuthPresenterComponent.builder()
                .authPresenterModule(new AuthPresenterModule())
                .build();
    }
}
