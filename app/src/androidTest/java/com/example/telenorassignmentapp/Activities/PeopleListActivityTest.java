/*
 * *
 *  * Created by Arslan on 2/10/19 9:36 PM
 *  * Copyright (c) 2019 . All rights reserved.
 *  * Last modified 2/10/19 9:36 PM
 *
 */

package com.example.telenorassignmentapp.Activities;


import android.support.test.espresso.ViewInteraction;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import static org.hamcrest.core.StringContains.containsString;

import com.example.telenorassignmentapp.R;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.hamcrest.core.IsInstanceOf;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class PeopleListActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);


    @Test
    public void peopleListActivityTest() {
        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction frameLayout = onView(
                allOf(withId(R.id.toolbar_layout), withContentDescription("Cast Names"),
                        childAtPosition(
                                allOf(withId(R.id.app_bar),
                                        childAtPosition(
                                                withId(R.id.coordinatorLayout),
                                                0)),
                                0),
                        isDisplayed()));
        frameLayout.check(matches(isDisplayed()));

        ViewInteraction relativeLayout = onView(
                allOf(withId(R.id.rl_people_list),
                        childAtPosition(
                                allOf(withId(R.id.recycler_view),
                                        childAtPosition(
                                                IsInstanceOf.<View>instanceOf(android.widget.RelativeLayout.class),
                                                0)),
                                0),
                        isDisplayed()));
        relativeLayout.check(matches(isDisplayed()));

        ViewInteraction textView = onView(
                allOf(withId(R.id.title), withText(containsString("Name: Ashitaka")),
                        childAtPosition(
                                allOf(withId(R.id.rl_people_list),
                                        childAtPosition(
                                                withId(R.id.recycler_view),
                                                0)),
                                0),
                        isDisplayed()));
        textView.check(matches(withText(containsString("Name: Ashitaka"))));


        ViewInteraction textView2 = onView(
                allOf(withId(R.id.age), withText(containsString("Age: late teens")),
                        childAtPosition(
                                allOf(withId(R.id.rl_people_list),
                                        childAtPosition(
                                                withId(R.id.recycler_view),
                                                0)),
                                1),
                        isDisplayed()));
        textView2.check(matches(withText(containsString("Age: late teens"))));

        ViewInteraction textView3 = onView(
                allOf(withId(R.id.gender), withText(containsString("Gender: Male")),
                        childAtPosition(
                                allOf(withId(R.id.rl_people_list),
                                        childAtPosition(
                                                withId(R.id.recycler_view),
                                                0)),
                                2),
                        isDisplayed()));
        textView3.check(matches(withText(containsString("Geder: Male"))));

        ViewInteraction textView4 = onView(
                allOf(withId(R.id.eye_color), withText(containsString("Eye Color: Brown")),
                        childAtPosition(
                                allOf(withId(R.id.rl_people_list),
                                        childAtPosition(
                                                withId(R.id.recycler_view),
                                                0)),
                                3),
                        isDisplayed()));
        textView4.check(matches(withText(containsString("Eye Color: Brown"))));

        ViewInteraction textView5 = onView(
                allOf(withId(R.id.hair_color), withText(containsString("Hair Color: Brown")),
                        childAtPosition(
                                allOf(withId(R.id.rl_people_list),
                                        childAtPosition(
                                                withId(R.id.recycler_view),
                                                0)),
                                5),
                        isDisplayed()));
        textView5.check(matches(withText(containsString("Hair Color: Brown"))));

        ViewInteraction imageView = onView(
                allOf(withId(R.id.imageView),
                        childAtPosition(
                                allOf(withId(R.id.rl_people_list),
                                        childAtPosition(
                                                withId(R.id.recycler_view),
                                                0)),
                                4),
                        isDisplayed()));
        imageView.check(matches(isDisplayed()));
    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}
