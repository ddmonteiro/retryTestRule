package com.app.android.tests;

import android.support.test.filters.SdkSuppress;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.UiObjectNotFoundException;

import com.app.android.shared.BaseTest;

import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import static com.app.android.shared.Constants.NUMBER_ATTEMPTS;


@RunWith(AndroidJUnit4.class)
@SdkSuppress(minSdkVersion = 18)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class sampleTest extends BaseTest {

    @Rule
    public Retry retry = new Retry(NUMBER_ATTEMPTS);
    

    /**
     * @throws UiObjectNotFoundException
     */
    @Test
    public void test01_sample() throws UiObjectNotFoundException {
        /**
         * YOUR TEST HERE
         */
    }
    
}
