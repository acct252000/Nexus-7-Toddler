package com.helenssc.android.toddlertabletpublic;

import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import java.io.IOException;
import java.util.ArrayList;

/**
 * <h1>Toddler Tablet QuizActivity</h1>
 * The main flashcard quiz activity of the application, displays a question mark
 * that when pressed plays the associated sound.  Four possible answers are given below the
 * quesiton mark.
 * <br/>
 * <b>Note:</b>  This activity was designed for a 2012 Nexus 7 wifi that has been rooted
 * to disable the bottom navigation bar.
 *
 * @author Christine Stoner
 * @version 1.0
 * @since 2017-02-27
 */
public class QuizActivity extends ActionBarActivity {

    private View decorView;
    private ImageView question_mark,  quiz_guess_one, quiz_guess_two, quiz_guess_three, quiz_guess_four;
    private MediaPlayer letterPlayer;
    private String listName;
    private Integer correct_guess, lastIndex;
    private ToddlerItem  firstToddlerItem, secondToddlerItem, guessOneToddlerItem, guessTwoToddlerItem, guessThreeToddlerItem, guessFourToddlerItem;
    private ToddlerList currentToddlerList;
    private ArrayList<ToddlerItem> currentArrayList;
    private Boolean textList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        Intent intent = getIntent();
        listName = intent.getStringExtra(OpenActivity.LIST_NAME);
        decorView = getWindow().getDecorView();
        currentToddlerList = new ToddlerList(listName);
        currentArrayList = currentToddlerList.getItemList();
        lastIndex = currentToddlerList.getLastIndex();
        textList = currentToddlerList.isTextList();
        //create MediaPlayer with default sound
        letterPlayer = MediaPlayer.create(this, R.raw.equals);

        try {
            letterPlayer.prepare();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //assign view items
        question_mark = (ImageView) findViewById(R.id.question_mark);
        quiz_guess_one = (ImageView) findViewById(R.id.quiz_guess_one);
        quiz_guess_two = (ImageView) findViewById(R.id.quiz_guess_two);
        quiz_guess_three = (ImageView) findViewById(R.id.quiz_guess_three);
        quiz_guess_four = (ImageView) findViewById(R.id.quiz_guess_four);


        //set onClickListener for question mark
        question_mark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(firstToddlerItem.getSoundID());

            }
        });

        //set onClickListener for first guess
        quiz_guess_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (correct_guess == 1){
                    playSound(R.raw.yeah);
                    setEquation();
                } else {
                    playSound(R.raw.wawawa);
                }
            }
        });

        //set onClickListener for second guess
        quiz_guess_two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (correct_guess == 2){
                    playSound(R.raw.yeah);
                    setEquation();
                } else {
                    playSound(R.raw.wawawa);
                }
            }
        });

        //set onClickListener for third guess
        quiz_guess_three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (correct_guess == 3){
                    playSound(R.raw.yeah);
                    setEquation();
                } else {
                    playSound(R.raw.wawawa);
                }
            }
        });

        //set onClickListener for third guess
        quiz_guess_four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (correct_guess == 4){
                    playSound(R.raw.yeah);
                    setEquation();
                } else {
                    playSound(R.raw.wawawa);
                }
            }
        });



        setEquation();

    }


    /**
     * Plays the sound passed as an argument.
     * @param soundId the int id of the sound to play
     * @return Nothing
     */
    private void playSound(Integer soundId) {
        if(letterPlayer.isPlaying()){
            letterPlayer.stop();
        }
        letterPlayer.reset();


        try {
            AssetFileDescriptor afd = getResources().openRawResourceFd(soundId);
            if (afd == null) return;
            letterPlayer.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
            afd.close();
        } catch (IOException excep){
            excep.printStackTrace();;
        } catch (IllegalStateException excep){
            excep.printStackTrace();
        }

        try{
            letterPlayer.prepare();
        } catch(IllegalStateException e){
            e.printStackTrace();
        } catch(IOException e){
            e.printStackTrace();
        }

        letterPlayer.start();



    }





    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_quiz, menu);
        return true;
    }

    /**
     * Handles the menu, which exits the activity.
     * Main menu functionality is
     * to exit the activity in case the navigation bar is disabled.
     * @param item parameter is the MenuItem selected.
     * @return Nothing
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.exit_quizactivity) {
            onBackPressed();
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * Randomly selects a flashcard and sets one correct and three incorrect answers.
     * @return Nothing
     */

    private void setEquation(){
        Integer question_item;
        //select flashcard
        question_item = (int) (Math.random() * (lastIndex));

        //determine which place 1-4 the correct guess will be
        correct_guess = 1 + (int)(Math.random() * ((4-1)+1));
        //randomly assign other flash cards to incorrect guess
        Integer firstGuess, secondGuess, thirdGuess;
        do {
            firstGuess = (int) (Math.random() * (lastIndex));
        } while (firstGuess == question_item);
        do {
            secondGuess =  (int) (Math.random() * (lastIndex));
        } while (secondGuess == firstGuess || secondGuess == question_item);
        do {
            thirdGuess =  (int) (Math.random() * (lastIndex));
        } while (thirdGuess == secondGuess || thirdGuess == firstGuess || thirdGuess == question_item);
        switch (correct_guess){
            case 1:
                guessOneToddlerItem = currentArrayList.get(question_item);
                guessTwoToddlerItem = currentArrayList.get(firstGuess);
                guessThreeToddlerItem = currentArrayList.get(secondGuess);
                guessFourToddlerItem = currentArrayList.get(thirdGuess);
                break;
            case 2:
                guessOneToddlerItem = currentArrayList.get(firstGuess);
                guessTwoToddlerItem = currentArrayList.get(question_item);
                guessThreeToddlerItem = currentArrayList.get(secondGuess);
                guessFourToddlerItem = currentArrayList.get(thirdGuess);
                break;
            case 3:
                guessOneToddlerItem = currentArrayList.get(firstGuess);
                guessTwoToddlerItem = currentArrayList.get(secondGuess);
                guessThreeToddlerItem = currentArrayList.get(question_item);
                guessFourToddlerItem = currentArrayList.get(thirdGuess);
                break;
            default:
                guessOneToddlerItem = currentArrayList.get(firstGuess);;
                guessTwoToddlerItem = currentArrayList.get(secondGuess);
                guessThreeToddlerItem = currentArrayList.get(thirdGuess);
                guessFourToddlerItem = currentArrayList.get(question_item);
                break;
        }

        //set item called by onClickListener to question_item randomly selected
        firstToddlerItem = currentArrayList.get(question_item);
        //set pictures of guesses
        quiz_guess_one.setImageResource(guessOneToddlerItem.getImageID());
        quiz_guess_two.setImageResource(guessTwoToddlerItem.getImageID());
        quiz_guess_three.setImageResource(guessThreeToddlerItem.getImageID());
        quiz_guess_four.setImageResource(guessFourToddlerItem.getImageID());
    }
}
