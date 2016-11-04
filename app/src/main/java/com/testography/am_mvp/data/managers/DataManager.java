package com.testography.am_mvp.data.managers;

import android.content.Context;

import com.testography.am_mvp.App;
import com.testography.am_mvp.R;
import com.testography.am_mvp.data.storage.dto.ProductDto;
import com.testography.am_mvp.utils.ConstantsManager;

import java.util.ArrayList;
import java.util.List;

public class DataManager {
    private static DataManager ourInstance;
    private List<ProductDto> mMockProductList;

    private PreferencesManager mPreferencesManager;
    private Context mAppContext;

    private DataManager() {
        mPreferencesManager = new PreferencesManager();
        mAppContext = App.getAppContext();

        generateMockData();
    }

    public static DataManager getInstance() {
        if (ourInstance == null) {
            ourInstance = new DataManager();
        }
        return ourInstance;
    }

    public PreferencesManager getPreferencesManager() {
        return mPreferencesManager;
    }

    public Context getAppContext() {
        return mAppContext;
    }

    public boolean isAuthUser() {
        return !mPreferencesManager.getAuthToken().equals(ConstantsManager
                .INVALID_TOKEN);
    }

    public void loginUser(String email, String password) {
        // TODO: 23-Oct-16 implement user authentication
    }

    public ProductDto getProductById(int productId) {
        // TODO: 28-Oct-16 gets product from mock (to be converted to DB)
        return mMockProductList.get(productId - 1);
    }

    public List<ProductDto> getProductList() {
        // TODO: 28-Oct-16 get product list
        return mMockProductList;
    }

    public void updateProduct(ProductDto product) {
        // TODO: 28-Oct-16 update product count or other property and save to DB
    }

    private String getResVal(int resourceId) {
        return getAppContext().getString(resourceId);
    }

    private void generateMockData() {
        mMockProductList = new ArrayList<>();
        mMockProductList.add(new ProductDto(1,
                getResVal(R.string.product_name_1),
                getResVal(R.string.product_url_1),
                getResVal(R.string.lorem_ipsum), 100, 1));
        mMockProductList.add(new ProductDto(2,
                getResVal(R.string.product_name_2),
                getResVal(R.string.product_url_2),
                getResVal(R.string.lorem_ipsum), 100, 1));
        mMockProductList.add(new ProductDto(3,
                getResVal(R.string.product_name_3),
                getResVal(R.string.product_url_3),
                getResVal(R.string.lorem_ipsum), 100, 1));
        mMockProductList.add(new ProductDto(4,
                getResVal(R.string.product_name_4),
                getResVal(R.string.product_url_4),
                getResVal(R.string.lorem_ipsum), 100, 1));
        mMockProductList.add(new ProductDto(5,
                getResVal(R.string.product_name_5),
                getResVal(R.string.product_url_5),
                getResVal(R.string.lorem_ipsum), 100, 1));
        mMockProductList.add(new ProductDto(6,
                getResVal(R.string.product_name_6),
                getResVal(R.string.product_url_6),
                getResVal(R.string.lorem_ipsum), 100, 1));
        mMockProductList.add(new ProductDto(7,
                getResVal(R.string.product_name_7),
                getResVal(R.string.product_url_7),
                getResVal(R.string.lorem_ipsum), 100, 1));
        mMockProductList.add(new ProductDto(8,
                getResVal(R.string.product_name_8),
                getResVal(R.string.product_url_8),
                getResVal(R.string.lorem_ipsum), 100, 1));
        mMockProductList.add(new ProductDto(9,
                getResVal(R.string.product_name_9),
                getResVal(R.string.product_url_9),
                getResVal(R.string.lorem_ipsum), 100, 1));
        mMockProductList.add(new ProductDto(10,
                getResVal(R.string.product_name_10),
                getResVal(R.string.product_url_10),
                getResVal(R.string.lorem_ipsum), 100, 1));
    }
}
