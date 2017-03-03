package com.helenssc.android.toddlertabletpublic;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;

/**
 * <h1>Toddler Tablet CustomCardsActivity</h1>
 * Displays the graphic from custom picture or word lists created by the user
 * plays the associated sound when clicked.  Navigation is provided by a forward button
 * as well as an optional back button toggled through the menu.  Activity is also exited through the
 * menu in case the navigation bar has been disabled.
 * <br />
 * <b>Note:</b>  This activity was designed for a 2012 Nexus 7 wifi that has been rooted
 * to disable the bottom navigation bar.
 *
 * @author Christine Stoner
 * @version 1.0
 * @since 2017-02-27
 */

public class CustomCardsActivity extends ActionBarActivity {
    private int categoryType, cardCounter, cardNumber;
    private ArrayList<CustomItem> allCustomItems;
    private CustomItem currentCustomItem;
    private ImageButton backButton, forwardButton;
    private ImageView cardView;
    private MediaPlayer letterPlayer;
    private TextView cardTextView, blankTextView;
    private String listName;
    private Integer lastIndex;
    private Boolean textList, showBackButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_allcards);
        Intent intent = getIntent();
        listName = intent.getStringExtra(OpenActivity.LIST_NAME);
        cardCounter = 0;

        populateCustomList(listName);


        showBackButton = false;
        //set view items
        cardView = (ImageView) findViewById(R.id.alphcard);
        cardTextView = (TextView) findViewById(R.id.alphcardtext);
        blankTextView = (TextView)findViewById(R.id.allcards_timerTextView2);
        //create MediaPlayer with default sound
        letterPlayer = MediaPlayer.create(this, R.raw.a);

        try {
            letterPlayer.prepare();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //determines processing based on if text sight word list or picture list
        if (!textList) {

            cardTextView.setVisibility(View.GONE);

            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (letterPlayer.isPlaying()) {
                        letterPlayer.stop();
                        try {
                            letterPlayer.prepare();
                        } catch (IllegalStateException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                            ;
                        }
                    }
                    letterPlayer.start();

                }
            });
        } else {

            cardView.setVisibility(View.GONE);
            cardTextView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (letterPlayer.isPlaying()) {
                        letterPlayer.stop();
                        try {
                            letterPlayer.prepare();
                        } catch (IllegalStateException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                            ;
                        }
                    }
                    letterPlayer.start();

                }
            });
        }
        //hides backButton unless turned on through menu
        backButton = (ImageButton)findViewById(R.id.allcards_backButton);
        backButton.setVisibility(View.GONE);

        forwardButton = (ImageButton)findViewById(R.id.allcards_forwardButton);
        //get first CustomItem
        currentCustomItem = allCustomItems.get(0);
        setCardView();
        //set onClickListener to move backwards through list of CustomItems
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (cardCounter == 0) {
                    cardCounter = lastIndex;
                } else {
                    cardCounter -= 1;
                }
                setCardView();


            }
        });
        //set onClickListener to move forwards through list of CustomItems
        forwardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (cardCounter == lastIndex) {
                    cardCounter = 0;
                } else {
                    cardCounter += 1;
                }
                setCardView();
            }
        });










    }

    /**
     * Sets the display to the current ToddlerItem(flashcard)
     * @return Nothing
     */

    protected void setCardView(){

        currentCustomItem = allCustomItems.get(cardCounter);
        if (!textList) {
            Bitmap familyBitmap = BitmapFactory.decodeFile(currentCustomItem.getImageFile());
            cardView.setImageBitmap(familyBitmap);
        } else {
            cardTextView.setText(currentCustomItem.getCardTitle());
        }

        if(letterPlayer.isPlaying()){
            letterPlayer.stop();
        }
        letterPlayer.reset();

        if(currentCustomItem.getSoundFile() != null) {
            setMediaPlayer(currentCustomItem.getSoundFile());
        }
        try{
            letterPlayer.prepare();
        } catch(IllegalStateException e){
            e.printStackTrace();
        } catch(IOException e){
            e.printStackTrace();
        }

    }






    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_sub_custom, menu);
        return true;
    }

    /**
     * Handles the menu, with main functionality to exit activity and toggle back button.
     * Main menu functionality is toggle the back button visibility, and
     * to exit the activity in case the navigation bar is disabled.  Also
     * includes functions to increase or decrease text size in case custom
     * sight words are too big or small when created.
     * @param item parameter is the MenuItem selected.
     * @return Nothing
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.exit_subactivity) {
            onBackPressed();
        }

        if (id == R.id.toggle_back) {
            if (showBackButton){
                backButton.setVisibility(View.GONE);
                blankTextView.setVisibility(View.VISIBLE);
                showBackButton = false;
            } else {
                backButton.setVisibility(View.VISIBLE);
                blankTextView.setVisibility(View.GONE);
                showBackButton = true;
            }
        }

        if (id == R.id.reduce_font) {
            float currentSize =convertPixelsToDp(cardTextView.getTextSize(), getApplicationContext());
            cardTextView.setTextSize(TypedValue.COMPLEX_UNIT_PX, currentSize-10);
        }

        if (id == R.id.increase_font) {
            float currentSize =convertPixelsToDp(cardTextView.getTextSize(), getApplicationContext());
            cardTextView.setTextSize(TypedValue.COMPLEX_UNIT_PX, currentSize+100);


        }




        return super.onOptionsItemSelected(item);
    }

    /**
     * Converts pixels to dp to allow for scaling differences in reducing or increasing font size.
     * @param px text sizie in px
     * @param context application context
     * @return Nothing
     */

    public static float convertPixelsToDp(float px, Context context){
        Resources resources = context.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        float dp = px / (metrics.densityDpi / 160f);
        return dp;
    }

    /**
     * Populates the list of CustomItems to display based on listName
     * @param listName string to select which list to display
     * @return Nothing
     */

    private void populateCustomList(String listName){


        if(listName.equals("family")){
            allCustomItems = FamilyLab.get(this).getSightWords();
            if(allCustomItems.size() == 0){
                allCustomItems.add(new CustomItem("None created"));
                textList = true;
                lastIndex = 0;
            } else {
            lastIndex = allCustomItems.size()-1;
            textList = false;
            }
        }
        if(listName.equals("sightwords")){
            allCustomItems = SightWordLab.get(this).getSightWords();
            if(allCustomItems.size() == 0){
                allCustomItems.add(new CustomItem("None created"));
                lastIndex = 0;
            } else {
                lastIndex = allCustomItems.size()-1;
            }
            textList = true;
        }


    }

    /**
     * Sets MediaPlayer based on passed in sound file name.
     * Main menu functionality is toggle the back button visibility, and
     * to exit the activity in case the navigation bar is disabled.
     * @param soundFileName file name of sound passed in
     * @return Nothing
     */

    public void setMediaPlayer(String soundFileName){
        if(letterPlayer.isPlaying()){
            letterPlayer.stop();
        }
        letterPlayer.reset();
        Uri soundPath = Uri.parse(soundFileName);
        try{
            letterPlayer.setDataSource(this, soundPath);
        }catch(SecurityException e){
            e.printStackTrace();
        }
        catch(IllegalStateException e){
            e.printStackTrace();
        } catch(IOException e){
            e.printStackTrace();
        }
        try{
            letterPlayer.prepare();
        } catch(IllegalStateException e){
            e.printStackTrace();
        } catch(IOException e){
            e.printStackTrace();
        }

    }

}
