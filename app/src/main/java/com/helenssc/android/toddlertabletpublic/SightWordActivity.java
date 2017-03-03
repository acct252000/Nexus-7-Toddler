package com.helenssc.android.toddlertabletpublic;

import android.content.Context;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import java.io.IOException;
import java.util.UUID;
/**
 * <h1>Toddler Tablet SightWordActivity</h1>
 * Allows users to create custom flashcards with words.
 * Suggested use is for sightword learning
 * <br/>
 * <b>Note:</b>  This activity was designed for a 2012 Nexus 7 wifi that has been rooted
 * to disable the bottom navigation bar.
 *
 * @author Christine Stoner
 * @version 1.0
 * @since 2017-02-27
 */

public class SightWordActivity extends ActionBarActivity {


    private EditText newSightWord;
    private CustomItem ci;
    private LinearLayout layout;
    private Button saveButton, continueButton;
    private ImageButton replayButton, keyboardDown;
    private Uri targetUri;
    private String imagePath;
    private static final String LOG_TAG = "FamilyActivity";

    private MediaRecorder mRecorder = null;
    //RecordButton is defined below
    private RecordButton mRecordButton = null;

    private MediaPlayer wordPlayer;

    private static String mFileName = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sightwords);
        layout = (LinearLayout) findViewById(R.id.sw_record_layout);
        newSightWord = (EditText) findViewById(R.id.sw_editText);
        saveButton = (Button) findViewById(R.id.sw_save);
        continueButton = (Button) findViewById(R.id.sw_save_continue);
        keyboardDown = (ImageButton) findViewById(R.id.sw_key_down);
        //create MediaPlayer with default sound
        wordPlayer = MediaPlayer.create(this, R.raw.a);

        try {
            wordPlayer.prepare();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        ci = new CustomItem("sw");
        createFileName();

        //create RecordButton and add to view
        mRecordButton = new RecordButton(this);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(331, 85);
        layoutParams.setMargins(25, 25, 25, 25);
        layout.addView(mRecordButton,
                layoutParams);
        mRecordButton.setTextColor(Color.BLACK);
        mRecordButton.setTextSize(20);
        mRecordButton.setBackgroundResource(R.drawable.buttonshape);

        //create replayButton and add to view
        replayButton = new ImageButton(this);
        LinearLayout.LayoutParams blayoutParams = new LinearLayout.LayoutParams(100, 85);
        blayoutParams.setMargins(25, 25, 25, 25);
        replayButton.setBackgroundResource(R.drawable.buttonshape);
        replayButton.setImageResource(R.drawable.play);
        layout.addView(replayButton,
                blayoutParams);
        //set onClickListener to playWord recorded
        replayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playWord();
            }
        });
        //hide visibility of keyboard Down
        keyboardDown.setVisibility(View.GONE);
        //set onBackPressed functionality to keyboard down key in case navigation bar is hidden
        keyboardDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        //set onClickListener to save custom item
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ci.setSoundFile(mFileName);
                ci.setCardTitle(newSightWord.getText().toString());
                addCustomItem(ci);
                onBackPressed();

            }
        });
        //set onClickListener to save custom item and reset variables to create another
        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ci.setSoundFile(mFileName);
                ci.setCardTitle(newSightWord.getText().toString());
                addCustomItem(ci);
                newSightWord.setText("");
                createFileName();
            }
        });

    }
    /**
     * Creates filename with absolute path and randomUUID to store sound file.
     * @return Nothing
     */
    private void createFileName() {
        //Establish filename for sound file
        mFileName = Environment.getExternalStorageDirectory().getAbsolutePath();
        mFileName += "/";
        mFileName += UUID.randomUUID().toString();
        mFileName += ".3gp";
    }

    /**
     * Starts or stops recording depending on current state
     * @param start current state of recording
     * @return Nothing
     */
    private void onRecord(boolean start) {
        if (start) {
            startRecording();
        } else {
            stopRecording();
        }
    }
    /**
     * Creates and starts MediaRecorder
     * @return Nothing
     */
    private void startRecording() {
        mRecorder = new MediaRecorder();
        mRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        mRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        mRecorder.setOutputFile(mFileName);
        mRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);

        try {
            mRecorder.prepare();
        } catch (IOException e) {
            Log.e(LOG_TAG, "prepare() failed");
        }

        mRecorder.start();
    }

    /**
     * Stops MediaRecorder
     * @return Nothing
     */
    private void stopRecording() {
        mRecorder.stop();
        mRecorder.release();
        mRecorder = null;
    }

    /**
     * Creates button used to control recording functions.
     */
    class RecordButton extends Button {
        boolean mStartRecording = true;

        OnClickListener clicker = new OnClickListener() {
            public void onClick(View v) {
                onRecord(mStartRecording);
                if (mStartRecording) {
                    setText("Stop recording");
                } else {
                    setText("Start recording");
                }
                mStartRecording = !mStartRecording;
            }
        };

        public RecordButton(Context ctx) {
            super(ctx);
            setText("Start recording");
            setOnClickListener(clicker);
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        if (mRecorder != null) {
            mRecorder.release();
            mRecorder = null;
        }

    }
    /**
     * Saves CustomItem through FamilyLab class to JSON
     * @param ci CustomItem to be saved
     * @return Nothing
     */
    public void addCustomItem(CustomItem ci) {

        SightWordLab.get(this).addCustomItem(ci);
        SightWordLab.get(this).saveCustomItems();


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
     * Plays sound for current CustomItem
     * @return Nothing
     */
    public void playWord(){

        setMediaPlayer(mFileName);

        if (wordPlayer.isPlaying()) {
            wordPlayer.stop();
            try {
                wordPlayer.prepare();
            } catch (IllegalStateException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
                ;
            }
        }
        wordPlayer.start();
    }


    /**
     *Sets MediaPlayer to play a string file name
     * @param soundFileName string of soundFilename to be played
     * @return Nothing
     */
    public void setMediaPlayer(String soundFileName){
        if(wordPlayer.isPlaying()){
            wordPlayer.stop();
        }
        wordPlayer.reset();
        Uri soundPath = Uri.parse(soundFileName);
        try{
            wordPlayer.setDataSource(this, soundPath);
        }catch(SecurityException e){
            e.printStackTrace();
        }
        catch(IllegalStateException e){
            e.printStackTrace();
        } catch(IOException e){
            e.printStackTrace();
        }
        try{
            wordPlayer.prepare();
        } catch(IllegalStateException e){
            e.printStackTrace();
        } catch(IOException e){
            e.printStackTrace();
        }


    }
}
