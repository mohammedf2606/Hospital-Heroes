package com.hummer.hospital_heroes;


import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.test.espresso.ViewInteraction;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class CreamMainMenuTestRecording {

    @Rule
    public ActivityTestRule<MainMenu> mActivityTestRule = new ActivityTestRule<>(MainMenu.class);

    @Test
    public void creamMainMenuTestRecording() {
        ViewInteraction imageButton = onView(
                allOf(withId(R.id.injection_menu), withContentDescription("Nurse"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                        2),
                                0),
                        isDisplayed()));
        imageButton.perform(click());

        ViewInteraction button = onView(
                allOf(withId(R.id.tap_screen_start),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                3),
                        isDisplayed()));
        button.perform(click());

        ViewInteraction button2 = onView(
                allOf(withId(R.id.receptionist),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                        1),
                                2),
                        isDisplayed()));
        button2.perform(click());

        ViewInteraction button3 = onView(
                allOf(withId(R.id.boy1),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                        1),
                                1),
                        isDisplayed()));
        button3.perform(click());

        ViewInteraction imageButton2 = onView(
                allOf(withId(R.id.chair), withContentDescription("Chair"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                        3),
                                0),
                        isDisplayed()));
        imageButton2.perform(click());

        ViewInteraction imageButton3 = onView(
                allOf(withId(R.id.cream), withContentDescription("cream"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                        3),
                                1),
                        isDisplayed()));
        imageButton3.perform(click());

        ViewInteraction textView = onView(
                allOf(withId(R.id.textView2), withText("Apply the cream!"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                1),
                        isDisplayed()));
        textView.check(matches(withText("Apply the cream!")));

        ViewInteraction imageButton4 = onView(
                allOf(withId(R.id.playButton), withContentDescription("Play"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                2),
                        isDisplayed()));
        imageButton4.check(matches(isDisplayed()));

        ViewInteraction imageView = onView(
                allOf(withId(R.id.imageView), withContentDescription("Background"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                0),
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
