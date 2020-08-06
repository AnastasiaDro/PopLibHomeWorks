package com.geekbrains.myapplication;

import androidx.test.rule.ActivityTestRule;

import com.geekbrains.myapplication.espresso.EspessoActivity;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;


import org.junit.Rule;
import org.junit.Test;

public class EspressoActivityTest {

    @Rule
    public ActivityTestRule<EspessoActivity> activityTestRule = new ActivityTestRule<>(EspessoActivity.class);

    @Test
    public void onSetTextBtnClick(){
        onView(withId(R.id.setTextBtn)).perform(click());
        onView(withId(R.id.textView)).check(matches(withText("Засетили текст")));
    }
}
