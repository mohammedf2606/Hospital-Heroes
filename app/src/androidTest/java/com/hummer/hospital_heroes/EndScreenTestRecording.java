package com.hummer.hospital_heroes;


import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.hamcrest.core.IsInstanceOf;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.test.espresso.ViewInteraction;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.doesNotExist;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

/**
 * Record test for the end screen
 *
 * @author Fareed Faisal
 * @version 1.0
 */
@LargeTest
@RunWith(AndroidJUnit4.class)
public class EndScreenTestRecording {

    @Rule
    public ActivityTestRule<MainMenu> mActivityTestRule = new ActivityTestRule<>(MainMenu.class);

    @Test
    public void endScreenTestRecording() {
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

        ViewInteraction imageButton4 = onView(
                allOf(withId(R.id.playButton), withContentDescription("Play"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                2),
                        isDisplayed()));
        imageButton4.perform(click());

        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction imageButton5 = onView(
                allOf(withId(R.id.playButton), withContentDescription("Play"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                2),
                        isDisplayed()));

        ViewInteraction button4 = onView(
                allOf(withId(R.id.scan_door),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                        0),
                                1),
                        isDisplayed()));

        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction imageButton6 = onView(
                allOf(withId(R.id.scanner), withContentDescription("scanner"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                        4),
                                0),
                        isDisplayed()));

        ViewInteraction imageButton7 = onView(
                allOf(withId(R.id.strapping), withContentDescription("straps"),
                        childAtPosition(
                                allOf(withId(R.id.strapbackground),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                0),
                        isDisplayed()));

        ViewInteraction imageButton8 = onView(
                allOf(withId(R.id.strapping), withContentDescription("straps"),
                        childAtPosition(
                                allOf(withId(R.id.strapbackground),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                0),
                        isDisplayed()));

        ViewInteraction imageButton9 = onView(
                allOf(withId(R.id.strapping), withContentDescription("straps"),
                        childAtPosition(
                                allOf(withId(R.id.strapbackground),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                0),
                        isDisplayed()));

        ViewInteraction imageButton10 = onView(
                allOf(withId(R.id.strapping), withContentDescription("straps"),
                        childAtPosition(
                                allOf(withId(R.id.strapbackground),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                0),
                        isDisplayed()));

        ViewInteraction imageButton11 = onView(
                allOf(withId(R.id.strapping), withContentDescription("straps"),
                        childAtPosition(
                                allOf(withId(R.id.strapbackground),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                0),
                        isDisplayed()));

        ViewInteraction imageButton12 = onView(
                allOf(withId(R.id.strapping), withContentDescription("straps"),
                        childAtPosition(
                                allOf(withId(R.id.strapbackground),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                0),
                        isDisplayed()));

        ViewInteraction imageButton13 = onView(
                allOf(withId(R.id.playButton), withContentDescription("Play"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                2),
                        isDisplayed()));

        ViewInteraction imageView = onView(
                allOf(withId(R.id.nurse), withContentDescription("Nurse"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                1),
                        isDisplayed()));
        imageView.check(doesNotExist());

        ViewInteraction imageView2 = onView(
                allOf(withId(R.id.parent2), withContentDescription("Reception"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                2),
                        isDisplayed()));
        imageView2.check(doesNotExist());

        ViewInteraction imageView3 = onView(
                allOf(withId(R.id.character), withContentDescription("character"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                4),
                        isDisplayed()));
        imageView3.check(doesNotExist());

        ViewInteraction imageView4 = onView(
                allOf(withId(R.id.parent), withContentDescription("parent"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                5),
                        isDisplayed()));
        imageView4.check(doesNotExist());

        ViewInteraction imageView5 = onView(
                allOf(withId(R.id.receptionist), withContentDescription("Reception"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                6),
                        isDisplayed()));
        imageView5.check(doesNotExist());

        ViewInteraction textView = onView(
                allOf(withText("WELL DONE!"),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.view.View.class),
                                        3),
                                4),
                        isDisplayed()));
        textView.check(doesNotExist());

        ViewInteraction textView2 = onView(
                allOf(withText("Restart"),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.view.View.class),
                                        3),
                                3),
                        isDisplayed()));
        textView2.check(doesNotExist());

        ViewInteraction textView3 = onView(
                allOf(withText("Quit"),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.view.View.class),
                                        3),
                                2),
                        isDisplayed()));
        textView3.check(doesNotExist());

        ViewInteraction imageView6 = onView(
                allOf(withContentDescription("thumbs up"),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.view.View.class),
                                        3),
                                5),
                        isDisplayed()));
        imageView6.check(doesNotExist());

        ViewInteraction imageButton14 = onView(
                allOf(withId(R.id.restart), withContentDescription("Restart"),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.view.View.class),
                                        3),
                                1),
                        isDisplayed()));
        imageButton14.check(doesNotExist());

        ViewInteraction imageButton15 = onView(
                allOf(withId(R.id.quit), withContentDescription("Quit"),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.view.View.class),
                                        3),
                                0),
                        isDisplayed()));
        imageButton15.check(doesNotExist());

        ViewInteraction relativeLayout = onView(
                allOf(childAtPosition(
                        childAtPosition(
                                withId(android.R.id.content),
                                0),
                        3),
                        isDisplayed()));
        relativeLayout.check(doesNotExist());

        ViewInteraction imageView7 = onView(
                allOf(withContentDescription("Hospital front"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                0),
                        isDisplayed()));
        imageView7.check(doesNotExist());
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
