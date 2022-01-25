package com.example.simpleparadox.listycity;
import android.app.Activity;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.rule.ActivityTestRule;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.robotium.solo.Solo;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class showActivityTest {

    private Solo solo;
    @Rule
    public ActivityTestRule<MainActivity> rule =
            new ActivityTestRule<>(MainActivity.class, true, true);
    /**
     * Runs before all tests and creates solo instance.
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception{
        solo = new Solo(InstrumentationRegistry.getInstrumentation(),rule.getActivity());
    }
    /**
     * Gets the Activity
     * @throws Exception
     */
    @Test
    public void checkActivitySwitch(){
        ListView ListView=(ListView)solo.getView(R.id.city_list);
        View view=ListView.getChildAt(0);
        solo.clickOnView(view);
        solo.assertCurrentActivity("activity didnt switch",ShowActivity.class);
    }
    @Test
    public void checkNameConsistency(){
        ListView ListView=(ListView)solo.getView(R.id.city_list);
        View view=ListView.getChildAt(0);
        solo.clickOnView(view);
        TextView textView= (TextView)solo.getView(R.id.textView);
        String name=textView.getText().toString();
        assertEquals("Edmonton",name);
    }

    @Test
    public void checkBackButton(){
        ListView ListView=(ListView)solo.getView(R.id.city_list);
        View view=ListView.getChildAt(0);
        solo.clickOnView(view);
        solo.waitForActivity(ShowActivity.class);
        Button button=(Button)solo.getView(R.id.button);
        solo.clickOnView(button);
        solo.assertCurrentActivity("activity didnt switch",MainActivity.class);

    }


    @After
    public void tearDown() throws Exception{
        solo.finishOpenedActivities();
    }
}



