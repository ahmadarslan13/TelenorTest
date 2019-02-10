/*
 * *
 *  * Created by Arslan on 2/10/19 9:47 PM
 *  * Copyright (c) 2019 . All rights reserved.
 *  * Last modified 2/10/19 9:47 PM
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

import com.example.telenorassignmentapp.R;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.hamcrest.core.IsInstanceOf;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class FilmListActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void filmListActivityTest() {
        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction recyclerView = onView(
                allOf(withId(R.id.recycler_view),
                        childAtPosition(
                                withClassName(is("android.widget.RelativeLayout")),
                                1)));
        recyclerView.perform(actionOnItemAtPosition(0, click()));

        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction frameLayout = onView(
                allOf(withId(R.id.toolbar_layout), withContentDescription("Film Names"),
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
                allOf(withId(R.id.title), withText("Title: Princess Mononoke"),
                        childAtPosition(
                                allOf(withId(R.id.rl_people_list),
                                        childAtPosition(
                                                withId(R.id.recycler_view),
                                                0)),
                                0),
                        isDisplayed()));
        textView.check(matches(withText("Title: Princess Mononoke")));

        ViewInteraction textView2 = onView(
                allOf(withId(R.id.release_date), withText("Release Date: 1997"),
                        childAtPosition(
                                allOf(withId(R.id.rl_people_list),
                                        childAtPosition(
                                                withId(R.id.recycler_view),
                                                0)),
                                1),
                        isDisplayed()));
        textView2.check(matches(withText("Release Date: 1997")));

        ViewInteraction textView3 = onView(
                allOf(withId(R.id.description), withText("Description: Ashitaka, a prince of the disappearing Ainu tribe, is cursed by a demonized boar god and must journey to the west to find a cure. Along the way, he encounters San, a young human woman fighting to protect the forest, and Lady Eboshi, who is trying to destroy it. Ashitaka must find a way to bring balance to this conflict."),
                        childAtPosition(
                                allOf(withId(R.id.rl_people_list),
                                        childAtPosition(
                                                withId(R.id.recycler_view),
                                                0)),
                                2),
                        isDisplayed()));
        textView3.check(matches(withText("Description: Ashitaka, a prince of the disappearing Ainu tribe, is cursed by a demonized boar god and must journey to the west to find a cure. Along the way, he encounters San, a young human woman fighting to protect the forest, and Lady Eboshi, who is trying to destroy it. Ashitaka must find a way to bring balance to this conflict.")));

        ViewInteraction textView4 = onView(
                allOf(withId(R.id.director), withText("Director: Hayao Miyazaki"),
                        childAtPosition(
                                allOf(withId(R.id.rl_people_list),
                                        childAtPosition(
                                                withId(R.id.recycler_view),
                                                0)),
                                3),
                        isDisplayed()));
        textView4.check(matches(withText("Director: Hayao Miyazaki")));

        ViewInteraction textView5 = onView(
                allOf(withId(R.id.producer), withText("Producer: Toshio Suzuki"),
                        childAtPosition(
                                allOf(withId(R.id.rl_people_list),
                                        childAtPosition(
                                                withId(R.id.recycler_view),
                                                0)),
                                4),
                        isDisplayed()));
        textView5.check(matches(withText("Producer: Toshio Suzuki")));

        ViewInteraction textView6 = onView(
                allOf(withId(R.id.score), withText("Score: 92"),
                        childAtPosition(
                                allOf(withId(R.id.rl_people_list),
                                        childAtPosition(
                                                withId(R.id.recycler_view),
                                                0)),
                                5),
                        isDisplayed()));
        textView6.check(matches(withText("Score: 92")));

        ViewInteraction view = onView(
                allOf(childAtPosition(
                        allOf(withId(R.id.rl_people_list),
                                childAtPosition(
                                        withId(R.id.recycler_view),
                                        0)),
                        6),
                        isDisplayed()));
        view.check(matches(isDisplayed()));
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
