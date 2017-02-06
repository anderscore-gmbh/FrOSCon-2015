package com.anderscore.frosconsample;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.startsWith;



/**
 * Created by max on 21.08.2015.
 */
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule testRule = new ActivityTestRule(MainActivity.class);

    @Test
    public void shouldIncrementDaveCountOnButtonPress() {
        onView(withText(startsWith("Dave kommt ")))
                .check(matches(withText(containsString("2"))));

        onView(withText("Add Dave")).perform(click());

        onView(withText(startsWith("Dave kommt ")))
                .check(matches(withText(containsString("3"))));
    }
}