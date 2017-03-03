package com.helenssc.android.toddlertabletpublic;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * <h1>Toddler Tablet Open Activity</h1>
 * Mimics an adult tablet with various icons your toddler can
 * select that mimic apps on an adult tablet.
 * OpenActivity is the activity that launches on open and displays
 * all the icons for further apps.  Certain apps are not displayed by default but can be
 * toggled on and off through the menu.
 * <br />
 * <b>Note:</b>  This activity was designed for a 2012 Nexus 7 wifi that has been rooted
 * to disable the bottom navigation bar.  The code to disable and re-enable this bar has
 * been removed from the public version but can be reinserted at your own risk
 * in the hideNavigationBar and showNavigationBar functions.
 *
 * @author Christine Stoner
 * @version 1.0
 * @since 2017-02-27
 */

public class OpenActivity extends ActionBarActivity {

    private ImageView plus, minus;
    private ImageView upper_case_quiz, lower_case_quiz, one_to_ten_quiz, eleven_to_twenty_quiz, tens_quiz, filler_one, filler_two;
    public static final String LIST_NAME = "LIST_NAME";
    private int exitCount;
    private boolean showMath, showQuizz, showWords;
    private LinearLayout quiz_layout, sw_layout;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open);

        //assign layouts for apps that do not display by default but toggle on and off
        quiz_layout = (LinearLayout)findViewById(R.id.quiz_layout);
        sw_layout = (LinearLayout)findViewById(R.id.sight_words_layout);
        hideNavigationBar();

        exitCount = 0;
        //set default showing of optional app icons to false
        showMath = false;
        showQuizz =false;
        showWords = false;

        /*The following section creates OnClickListeners to launch each apps associated activity and
        variable name
         */
        ImageView upperCase = (ImageView)findViewById(R.id.upper_case);

        upperCase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startAllCardsActivity("upper_case");

            }
        });

        ImageView upperLower = (ImageView)findViewById(R.id.upper_lower);

        upperLower.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startAllCardsActivity("upper_lower");

            }
        });

        ImageView lowerCase = (ImageView)findViewById(R.id.lower_case);

        lowerCase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startAllCardsActivity("lower_case");

            }
        });

        ImageView oneToTen = (ImageView)findViewById(R.id.one_two_three);

        oneToTen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startAllCardsActivity("one_to_ten");

            }
        });

        ImageView elevenToTwenty = (ImageView)findViewById(R.id.eleven_to_twenty);

        elevenToTwenty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startAllCardsActivity("eleven_to_twenty");

            }
        });

        ImageView tens = (ImageView)findViewById(R.id.tens);

        tens.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startAllCardsActivity("tens");

            }
        });

        plus= (ImageView)findViewById(R.id.plus);

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startMathActivity("add");

            }
        });

        minus= (ImageView)findViewById(R.id.minus);

        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startMathActivity("minus");

            }
        });


        ImageView pictures = (ImageView)findViewById(R.id.pictures);

        pictures.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startAllCardsActivity("pictures");

            }
        });

        ImageView family = (ImageView)findViewById(R.id.family);

        family.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startCustomCardsActivity("family");

            }
        });



        ImageView animals = (ImageView)findViewById(R.id.animals);

        animals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*this is commented out in public version as animal vectors are not public or
                in repository.  See comment in ToddlerList class to add your own images.

                startAllCardsActivity("animals");
                */
            }
        });

        ImageView colors = (ImageView)findViewById(R.id.colors);

        colors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startAllCardsActivity("colors");

            }
        });

        ImageView sightwordsd = (ImageView)findViewById(R.id.sightwordsd);

        sightwordsd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startAllCardsActivity("dolch_sightwords");

            }
        });

        ImageView sightwords = (ImageView)findViewById(R.id.sightwords);

        sightwords.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startCustomCardsActivity("sightwords");

            }
        });

        ImageView browser = (ImageView)findViewById(R.id.browser);

        browser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exitCount = 0;
                Intent i = new Intent(getApplicationContext(), BrowserActivity.class);
                startActivity(i);

            }
        });


        ImageView remote = (ImageView)findViewById(R.id.remote);

        remote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exitCount = 0;
                Intent i = new Intent(getApplicationContext(), RemoteActivity.class);
                startActivity(i);

            }
        });

        ImageView shapes = (ImageView)findViewById(R.id.shapes);

        shapes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startAllCardsActivity("shapes");

            }
        });


        upper_case_quiz = (ImageView)findViewById(R.id.upper_case_quiz);

        upper_case_quiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startQuizActivity("upper_case");

            }
        });

        lower_case_quiz = (ImageView)findViewById(R.id.lower_case_quiz);

        lower_case_quiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startQuizActivity("lower_case");

            }
        });

        one_to_ten_quiz = (ImageView)findViewById(R.id.one_to_ten_quiz);

        one_to_ten_quiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startQuizActivity("one_to_ten");

            }
        });

        eleven_to_twenty_quiz = (ImageView)findViewById(R.id.eleven_to_twenty_quiz);

        eleven_to_twenty_quiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startQuizActivity("eleven_to_twenty");

            }
        });

        tens_quiz = (ImageView)findViewById(R.id.tens_quiz);

        tens_quiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startQuizActivity("tens");

            }
        });

        //blank fillers for when apps are not showing
        filler_one = (ImageView)findViewById(R.id.filler_one);
        filler_two = (ImageView)findViewById(R.id.filler_two);
        /*Assign exit button. Enable button after 11 uninterrupted clicks to allow for exiting
        if the navigation bar is disabled on a rooted device.
         */
        ImageView exitButton = (ImageView)findViewById(R.id.exit_button);

        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exitCount += 1;
                if (exitCount == 11){
                    exitCount = 0;
                    showNavigationBar();
                    //finish();

                }

            }
        });

        hideMathProblems();
        hideQuizzes();
        hideSightWords();






    }

    /**
     * Launches the QuizActivity using listName to determine subject matter.
     * @param currentListName this is a String that identifies what list the quiz activity will use
     * @return Nothing
     */
    private void startQuizActivity(String currentListName) {
        exitCount = 0;
        Intent i = new Intent(getApplicationContext(), QuizActivity.class);
        i.putExtra(LIST_NAME, currentListName);
        startActivity(i);
    }

    /**
     * Launches the CustomCardsActivity which displays lists created by the user.
     * @param currentListName this is a String that identifies which list the activity will use
     * @return Nothing
     */
    private void startCustomCardsActivity(String currentListName) {
        exitCount = 0;
        Intent i = new Intent(getApplicationContext(), CustomCardsActivity.class);
        i.putExtra(LIST_NAME, currentListName);
        startActivity(i);
    }

    /**
     * Launches the MathActivity which quizzes on math problems.
     * @param currentListName this is a String that identifies which list the activity will use
     * @return Nothing
     */
    private void startMathActivity(String currentListName) {
        exitCount = 0;
        Intent i = new Intent(getApplicationContext(), MathActivity.class);
        i.putExtra(LIST_NAME, currentListName);
        startActivity(i);
    }

    /**
     * Launches the AlCardsActivity which is the main flash card activity of the application.
     * @param currentListName this is a String that identifies which list the activity will use
     * @return Nothing
     */
    private void startAllCardsActivity(String currentListName) {
        exitCount = 0;
        Intent i = new Intent(getApplicationContext(), AllCardsActivity.class);
        i.putExtra(LIST_NAME, currentListName);
        startActivity(i);
    }

    /**
     * Hides the navigation bar on a rooted device, disabled in public version.  The interior code has been removed in the public version.
     * @return Nothing
     */
    private void hideNavigationBar(){
        /*this method is used to hide the navigaton bar on a rooted device and is removed
        in the public version. If you desire this functionality add the code you need here to hide
        the navigation bar at your own risk and below to show it.
         */
    }

    /**
     * Shows the navigation bar on a rooted device, disabled in public version.  The interior code has been removed in the public version.
     * @return Nothing
     */
    private void showNavigationBar() {
      /*this method is used to show the navigaton bar if hidden using hideNavigationBar() above
        on a rooted device and is removed in the public version. If you desire this functionality
         add the code you need here to show the navigation bar at your own risk.
         */
    }

    /**
     * Hides the math problem icons.
     * @return Nothing
     */
    private void hideMathProblems(){

        plus.setVisibility(View.GONE);
        minus.setVisibility(View.GONE);
        filler_one.setVisibility(View.INVISIBLE);
        filler_two.setVisibility(View.INVISIBLE);

    }

    /**
     * Shows the math problem icons.
     * @return Nothing
     */
    private void showMathProblems(){

        plus.setVisibility(View.VISIBLE);
        minus.setVisibility(View.VISIBLE);
        filler_one.setVisibility(View.GONE);
        filler_two.setVisibility(View.GONE);
    }

    /**
     * Hides the quiz icons.
     * @return Nothing
     */
    private void hideQuizzes(){

        quiz_layout.setVisibility(View.GONE);
        upper_case_quiz.setVisibility(View.GONE);
        lower_case_quiz.setVisibility(View.GONE);
        one_to_ten_quiz.setVisibility(View.GONE);
        eleven_to_twenty_quiz.setVisibility(View.GONE);
        tens_quiz.setVisibility(View.GONE);
    }

    /**
     * Shows the math problem icons.
     * @return Nothing
     */
    private void showQuizzes(){

        quiz_layout.setVisibility(View.VISIBLE);
        upper_case_quiz.setVisibility(View.VISIBLE);
        lower_case_quiz.setVisibility(View.VISIBLE);
        one_to_ten_quiz.setVisibility(View.VISIBLE);
        eleven_to_twenty_quiz.setVisibility(View.VISIBLE);
        tens_quiz.setVisibility(View.VISIBLE);
    }

    /**
     * Hides the sight word icons.
     * @return Nothing
     */
    private void hideSightWords() {
        sw_layout.setVisibility(View.GONE);
    }

    /**
     * Shows the sight word icons.
     * @return Nothing
     */
    private void showSightWords(){
        sw_layout.setVisibility(View.VISIBLE);
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    /**
     * Handles the menu with icon toggle, create sightword, and custom family list functionality
     * Main menu functionality is to show and hide the quiz, math,
     * and sightword icons, as well as to launch the activities to create custom sightword lists and custom family lists.
     * @param item parameter is the MenuItem selected.
     * @return Nothing
     */

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.menu_item_math_problems) {
            if (showMath){
                hideMathProblems();
                showMath = false;
            } else {
                showMathProblems();
                showMath = true;
            }
            return true;
        }
        if (id == R.id.menu_item_quizzes) {
            if (showQuizz){
                hideQuizzes();
                showQuizz = false;
            } else {
                showQuizzes();
                showQuizz = true;
            }
            return true;
        }
        if (id == R.id.menu_item_swds) {
            if (showWords){
                hideSightWords();
                showWords = false;
            } else {
                showSightWords();
                showWords = true;
            }
            return true;
        }
        //launches activity to add family member list
        if (id == R.id.family_list) {
            Intent i = new Intent(getApplicationContext(), FamilyActivity.class);
            startActivity(i);
            return true;
        }
        //launches activity to add custom sight word list
        if (id == R.id.sight_word_list) {
            Intent i = new Intent(getApplicationContext(), SightWordActivity.class);
            startActivity(i);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }













}
