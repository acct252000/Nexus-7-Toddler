package com.helenssc.android.toddlertabletpublic;

import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.io.IOException;

/**
 * <h1>Toddler Tablet RemoteActivity</h1>
 * Mimics a tv remote.   Touching the numbers says the numbers, while
 * other buttons beep randomly.
 * <br />
 *
 * @author Christine Stoner
 * @version 1.0
 * @since 2017-02-27
 */
public class RemoteActivity extends ActionBarActivity {


    private MediaPlayer letterPlayer;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remote);

        //create MediaPlayer with default sound
        letterPlayer = MediaPlayer.create(this, R.raw.beep);

        try {
            letterPlayer.prepare();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
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
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.exit_quizactivity) {
            onBackPressed();
        }



        return super.onOptionsItemSelected(item);
    }

    /**
     * Plays a random beep when called from onclick function.
     * @param view relevant View for onclick
     * @return Nothing
     */
    public void beep(View view){
        int soundId = chooseRandomBeep();
        playSound(soundId);

    }

    /**
     * Plays the sound of the number calling this onclick function.
     * @param view relevant View for onclick
     * @return Nothing
     */
    public void repeatNumber(View view){

        int soundId = R.raw.one;
        switch(view.getId()) {
            case R.id.one_button:
                soundId = R.raw.one;
                break;
            case R.id.two_button:
                soundId = R.raw.two;
                break;
            case R.id.three_button:
                soundId = R.raw.three;
                break;
            case R.id.four_button:
                soundId = R.raw.four;
                break;
            case R.id.five_button:
                soundId = R.raw.five;
                break;
            case R.id.six_button:
                soundId = R.raw.six;
                break;
            case R.id.seven_button:
                soundId = R.raw.seven;
                break;
            case R.id.eight_button:
                soundId = R.raw.eight;
                break;
            case R.id.nine_button:
                soundId = R.raw.nine;
                break;
            case R.id.zero_button:
                soundId = R.raw.zero;
                break;
            default:
                soundId = R.raw.beep;
                break;


        }
        playSound(soundId);

    }

    /**
     * Chooses a random beep to play.
     * @return Nothing
     */
    public int chooseRandomBeep() {

        int sound = 1 + (int) (Math.random() * ((4 - 1) + 1));
        int soundId = R.raw.beep;
        switch(sound){
            case 1:
                soundId =  R.raw.beep;
                break;
            case 2:
                soundId = R.raw.boop;
                break;
            case 3:
                soundId = R.raw.bip;
                break;
            default:
                soundId = R.raw.bop;
                break;

        }
        return soundId;
    }

    /**
     * Plays the sound passed as an argument.
     * @param soundId the int id of the sound to play
     * @return Nothing
     */
public void playSound(int soundId){

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




}
