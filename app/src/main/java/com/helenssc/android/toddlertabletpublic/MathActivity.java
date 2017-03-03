package com.helenssc.android.toddlertabletpublic;

import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.io.IOException;

/**
 * <h1>Toddler Tablet MathActivity</h1>
 * Quizzes on simple addition or subtraction problems.  Numbers and potential answers
 * are randomly generated.  Activity is also exited through the
 * menu in case the navigation bar has been disabled.
 * <br />
 * <b>Note:</b>  This activity was designed for a 2012 Nexus 7 wifi that has been rooted
 * to disable the bottom navigation bar.
 *
 * @author Christine Stoner
 * @version 1.0
 * @since 2017-02-27
 */
public class MathActivity extends ActionBarActivity {

    private View decorView;
    private TextView number_one, operator, number_two, equals_picture, guess_one, guess_two, guess_three, guess_four;
    private MediaPlayer letterPlayer;
    private String listName;
    private Integer correct_guess;
    private ToddlerItem  firstToddlerItem, secondToddlerItem, guessOneToddlerItem, guessTwoToddlerItem, guessThreeToddlerItem, guessFourToddlerItem;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        decorView = getWindow().getDecorView();
        setContentView(R.layout.activity_math);
        //list name determines addition or subtraction
        Intent intent = getIntent();
        listName = intent.getStringExtra(OpenActivity.LIST_NAME);
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
        number_one = (TextView) findViewById(R.id.first_number);
        operator = (TextView) findViewById(R.id.operator);
        number_two = (TextView) findViewById(R.id.second_number);
        equals_picture = (TextView) findViewById(R.id.equals_picture);
        guess_one = (TextView) findViewById(R.id.guess_one);
        guess_two = (TextView) findViewById(R.id.guess_two);
        guess_three = (TextView) findViewById(R.id.guess_three);
        guess_four = (TextView) findViewById(R.id.guess_four);

        //change text to - if minus passed by Intent
        if (listName.equals("minus")){
            operator.setText("-");
        }

        //sets onClickListener for first number
        number_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(firstToddlerItem.getSoundID());

            }
        });
        //sets onClickListener for operator
        operator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listName.equals("add")) {
                    playSound(R.raw.plus);
                } else {
                    playSound(R.raw.minus);
                }

            }
        });
        //sets onClickListener for second number
        number_two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(secondToddlerItem.getSoundID());
            }
        });

        //sets onClickListener for equals
        equals_picture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(R.raw.equals);
            }
        });


        //sets onClickListener for first guess
        guess_one.setOnClickListener(new View.OnClickListener() {
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

        //sets onClickListener for second guess
        guess_two.setOnClickListener(new View.OnClickListener() {
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

        //sets onClickListener for third guess
        guess_three.setOnClickListener(new View.OnClickListener() {
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

        //sets onClickListener for fourth guess
        guess_four.setOnClickListener(new View.OnClickListener() {
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
     * Sets the math equation question and assigns one correct and three incorrect answers.
     * @return Nothing
     */

    private void setEquation(){
        Integer first_number, second_number, answer;
        //assign first and second number randomly
        if (listName.equals("add")) {
            first_number = 1 + (int) (Math.random() * ((10 - 1) + 1));
            second_number = 1 + (int) (Math.random() * ((10 - 1) + 1));
            //calculate answer
            answer = first_number + second_number;
        } else {
            first_number = 2 + (int) (Math.random() * ((10 - 2) + 2));
            do {
                second_number = 1 + (int) (Math.random() * ((10 - 1) + 1));
            } while (second_number >= first_number);
            //calculate answer
            answer = first_number - second_number;
        }
        //determine which guess from 1 to 4 will be correct
        correct_guess = 1 + (int)(Math.random() * ((4-1)+1));
        //assign correct guess and random numbers to wrong guesses
        Integer firstGuess, secondGuess, thirdGuess;
        do {
           firstGuess = 1 + (int) (Math.random() * ((19 - 1) + 1));
        } while (firstGuess == answer);
        do {
           secondGuess =  1 + (int) (Math.random() * ((19 - 1) + 1));
        } while (secondGuess == firstGuess || secondGuess == answer);
        do {
            thirdGuess =  1 + (int) (Math.random() * ((19 - 1) + 1));
        } while (thirdGuess == secondGuess || thirdGuess == firstGuess || thirdGuess == answer);
        switch (correct_guess){
            case 1:
                guessOneToddlerItem = setToddlerItem(answer);
                guessTwoToddlerItem = setToddlerItem(firstGuess);
                guessThreeToddlerItem = setToddlerItem(secondGuess);
                guessFourToddlerItem = setToddlerItem(thirdGuess);
                break;
            case 2:
                guessOneToddlerItem = setToddlerItem(firstGuess);
                guessTwoToddlerItem = setToddlerItem(answer);
                guessThreeToddlerItem = setToddlerItem(secondGuess);
                guessFourToddlerItem = setToddlerItem(thirdGuess);
                break;
            case 3:
                guessOneToddlerItem = setToddlerItem(firstGuess);
                guessTwoToddlerItem = setToddlerItem(secondGuess);
                guessThreeToddlerItem = setToddlerItem(answer);
                guessFourToddlerItem = setToddlerItem(thirdGuess);
                break;
            default:
                guessOneToddlerItem = setToddlerItem(firstGuess);
                guessTwoToddlerItem = setToddlerItem(secondGuess);
                guessThreeToddlerItem = setToddlerItem(thirdGuess);
                guessFourToddlerItem = setToddlerItem(answer);
                break;
        }



        //set ToddlerItem for numbers
        firstToddlerItem = setToddlerItem(first_number);
        secondToddlerItem = setToddlerItem(second_number);
        //set text for guesses and numbers
        number_one.setText(firstToddlerItem.getLetterTitle());
        number_two.setText(secondToddlerItem.getLetterTitle());
        guess_one.setText(guessOneToddlerItem.getLetterTitle());
        guess_two.setText(guessTwoToddlerItem.getLetterTitle());
        guess_three.setText(guessThreeToddlerItem.getLetterTitle());
        guess_four.setText(guessFourToddlerItem.getLetterTitle());

        setColors();
    }

    /**
     * Sets random text colors for the textviews displayed.
     * @return Nothing
     */
    private void setColors(){
        number_one.setTextColor(getRandomColor());
        operator.setTextColor(getRandomColor());
        number_two.setTextColor(getRandomColor());
        equals_picture.setTextColor(getRandomColor());
        guess_one.setTextColor(getRandomColor());
        guess_two.setTextColor(getRandomColor());
        guess_three.setTextColor(getRandomColor());
        guess_four.setTextColor(getRandomColor());


    }

    /**
     * Picks a random color from blue, green, red or yellow.
     * @return int color id
     */

    private int getRandomColor() {
        int randomColor = 1 + (int) (Math.random() * ((4 - 1) + 1));
        int colorPick = Color.BLUE;
        switch (randomColor) {
            case 1:
                colorPick = Color.BLUE;
                break;
            case 2:
                colorPick = Color.GREEN;
                break;
            case 3:
                colorPick = Color.RED;
                break;
            default:
                colorPick = Color.YELLOW;
                break;
        }
        return colorPick;

    }


    /**
     * Sets the ToddlerItem matching the number passed as an argument.
     * @param itemNumber int of of number for which matching ToddlerItem desired
     * @return ToddlerItem matching number of parameter.
     */
    private ToddlerItem setToddlerItem(Integer itemNumber){
        switch(itemNumber) {
            case 1:
                return new ToddlerItem("1", R.drawable.one, R.raw.one);
            case 2:
                return new ToddlerItem("2", R.drawable.two, R.raw.two);
            case 3:
                return new ToddlerItem("3", R.drawable.three, R.raw.three);
            case 4:
                return new ToddlerItem("4", R.drawable.four, R.raw.four);
            case 5:
                return new ToddlerItem("5", R.drawable.five, R.raw.five);
            case 6:
                return new ToddlerItem("6", R.drawable.six, R.raw.six);
            case 7:
                return new ToddlerItem("7", R.drawable.seven, R.raw.seven);
            case 8:
                return new ToddlerItem("8", R.drawable.eight, R.raw.eight);
            case 9:
                return new ToddlerItem("9", R.drawable.nine, R.raw.nine);
            case 10:
                return new ToddlerItem("10", R.drawable.ten, R.raw.ten);
            case 11:
                return new ToddlerItem("11", R.drawable.eleven, R.raw.eleven);
            case 12:
                return new ToddlerItem("12", R.drawable.twelve, R.raw.twelve);
            case 13:
                return new ToddlerItem("13", R.drawable.thirteen, R.raw.thirteen);
            case 14:
                return new ToddlerItem("14", R.drawable.fourteen, R.raw.fourteen);
            case 15:
                return new ToddlerItem("15", R.drawable.fifteen, R.raw.fifteen);
            case 16:
                return new ToddlerItem("16", R.drawable.sixteen, R.raw.sixteen);
            case 17:
                return new ToddlerItem("17", R.drawable.seventeen, R.raw.seventeen);
            case 18:
                return new ToddlerItem("18", R.drawable.eighteen, R.raw.eighteen);
            case 19:
                return new ToddlerItem("19", R.drawable.nineteen, R.raw.nineteen);
            case 20:
                return new ToddlerItem("20", R.drawable.twenty, R.raw.twenty);
        }

        return new ToddlerItem("one", R.drawable.one, R.raw.one);

    }

}
