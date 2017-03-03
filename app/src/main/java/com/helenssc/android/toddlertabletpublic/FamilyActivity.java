package com.helenssc.android.toddlertabletpublic;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.UUID;
/**
 * <h1>Toddler Tablet FamilyActivity</h1>
 * Allows users to create custom flashcards with pictures from the gallery.
 * Suggested use is for family members.
 * <br/>
 * <b>Note:</b>  This activity was designed for a 2012 Nexus 7 wifi that has been rooted
 * to disable the bottom navigation bar.
 *
 * @author Christine Stoner
 * @version 1.0
 * @since 2017-02-27
 */

public class FamilyActivity extends ActionBarActivity {


    private ImageView familyPicture;
    private CustomItem ci;
    private LinearLayout layout;
    private Button saveButton, continueButton, getPicture;
    private ImageButton replayButton;
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
        setContentView(R.layout.activity_family);
        //assign view Items
        layout = (LinearLayout) findViewById(R.id.family_record_layout);
        getPicture = (Button) findViewById(R.id.getpicture);
        familyPicture = (ImageView) findViewById(R.id.family_picture);
        familyPicture.setVisibility(View.GONE);
        saveButton = (Button) findViewById(R.id.family_save);
        continueButton = (Button) findViewById(R.id.family_save_continue);
        //create MediaPlayer with default sound
        wordPlayer = MediaPlayer.create(this, R.raw.a);

        try {
            wordPlayer.prepare();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //create default CustomItem
        ci = new CustomItem("family");
        //creates filename for sound file
        createFileName();

        //Record Button is defined below
        mRecordButton = new RecordButton(this);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(331, 85);
        layoutParams.setMargins(25, 25, 25, 25);
        //add Record Button to view
        layout.addView(mRecordButton,
                layoutParams);
        mRecordButton.setTextColor(Color.BLACK);
        mRecordButton.setTextSize(20);
        mRecordButton.setBackgroundResource(R.drawable.buttonshape);
        //create replayButon
        replayButton = new ImageButton(this);
        LinearLayout.LayoutParams blayoutParams = new LinearLayout.LayoutParams(100, 85);
        blayoutParams.setMargins(25, 25, 25, 25);
        replayButton.setBackgroundResource(R.drawable.buttonshape);
        replayButton.setImageResource(R.drawable.play);
        //add replay Button to view
        layout.addView(replayButton,
                blayoutParams);
        //set onClickListener to replay recorded sound
        replayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playWord();
            }
        });
        //set OnClickListener to select picture from gallery
        getPicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, 0);
            }
        });

        //set onClickListener to save custom item with sound and image path
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ci.setSoundFile(mFileName);
                ci.setImageFile(imagePath);
                addCustomItem(ci);
                onBackPressed();

            }
        });

        //saves custom item with sound and image file names and resets variables to enable another creation
        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ci.setSoundFile(mFileName);
                ci.setImageFile(imagePath);
                addCustomItem(ci);
                familyPicture.setImageDrawable(null);
                familyPicture.setVisibility(View.GONE);
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

        FamilyLab.get(this).addCustomItem(ci);
        FamilyLab.get(this).saveCustomItems();


    }

    /**
     * Gets path to image file selected and shows picture in view
     * @param requestCode int request code
     * @param resultCode int result code
     * @param data intent
     * @return Nothing
     */

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            targetUri = data.getData();
            Bitmap bitmap;
            try {
                bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(targetUri));
                familyPicture.setImageBitmap(bitmap);
                familyPicture.setVisibility(View.VISIBLE);
            } catch (FileNotFoundException e) {

                e.printStackTrace();
            }
            imagePath = getRealPathFromURI(this,targetUri);
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

        int id = item.getItemId();
        if (id == R.id.exit_quizactivity) {
            onBackPressed();
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * Returns path from URI
     * @param context application context
     * @param contentUri uri to convert to string path
     * @return String path for saving as file name
     */
    public String getRealPathFromURI(Context context, Uri contentUri) {
        Cursor cursor = null;
        try {
            String[] proj = {MediaStore.Images.Media.DATA};
            cursor = context.getContentResolver().query(contentUri, proj, null, null, null);
            int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            cursor.moveToFirst();
            return cursor.getString(column_index);
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }


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
