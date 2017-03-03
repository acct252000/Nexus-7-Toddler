package com.helenssc.android.toddlertabletpublic;

import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;

/**
 * <h1>Toddler Tablet AllCardsActivity</h1>
 * The main flashcard activity of the application, by default it displays the graphic from
 * the list and plays the associated sound when clicked.  Navigation is provided by a forward button
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

public class AllCardsActivity extends ActionBarActivity {
    private int cardCounter;
    private ArrayList<ToddlerItem> allToddlerItems;
    private ToddlerItem currentToddlerItem;
    private ImageButton backButton, forwardButton;
    private ImageView cardView;
    private MediaPlayer letterPlayer;
    private TextView cardTextView, blankTextView;
    private String listName;
    private Integer lastIndex;
    private ToddlerList currentToddlerList;
    private Boolean textList, showBackButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_allcards);
        //Determine which list of flash cards to show.
        Intent intent = getIntent();
        listName = intent.getStringExtra(OpenActivity.LIST_NAME);
        cardCounter = 0;

        populateToddlerList(listName);


        showBackButton = false;
        //assign default ToddlerItem
        currentToddlerItem = new ToddlerItem("default", R.drawable.au, R.raw.a);
        //assign views
        cardView = (ImageView) findViewById(R.id.alphcard);
        cardTextView = (TextView) findViewById(R.id.alphcardtext);
        blankTextView = (TextView)findViewById(R.id.allcards_timerTextView2);
        //create MediaPlayer and catch exceptions
        letterPlayer = MediaPlayer.create(this, currentToddlerItem.getSoundID());

        try {
            letterPlayer.prepare();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        /*activity can handle text or image TodderItems(flashcards).
        this if statement sets the visibility to the text or imageview accordingly.
         */
        if (!textList) {

            cardTextView.setVisibility(View.GONE);
            //set OnClickListener to play associated sound upon pressing the image.
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
            //set OnClickListener to play associated sound upon pressing the text word.
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
        //assign navigation buttons
        backButton = (ImageButton)findViewById(R.id.allcards_backButton);
        backButton.setVisibility(View.GONE);
        forwardButton = (ImageButton)findViewById(R.id.allcards_forwardButton);
        //get currentToddlerItem from list.
        currentToddlerItem = allToddlerItems.get(0);
        setCardView();

        //set backButton to pull up previous ToddlerItem in array
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

        //set forwardButton to pull up next ToddlerItem in array
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

        currentToddlerItem = allToddlerItems.get(cardCounter);
        if (!textList) {
            cardView.setImageResource(currentToddlerItem.getImageID());
        } else {
            cardTextView.setText(currentToddlerItem.getLetterTitle());
        }

        if(letterPlayer.isPlaying()){
            letterPlayer.stop();
        }
        letterPlayer.reset();


        try {
            AssetFileDescriptor afd = getResources().openRawResourceFd(currentToddlerItem.getSoundID());
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

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_sub, menu);
        return true;
    }

    /**
     * Handles the menu, with main functionality to exit activity and toggle back button.
     * Main menu functionality is toggle the back button visibility, and
     * to exit the activity in case the navigation bar is disabled.
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




        return super.onOptionsItemSelected(item);
    }

    /**
     * Loads the appropriate ToddlerList based on String parameter.
     * @param listName String that determines which list of ToddlerItems will be returned
     * @return Nothing
     */

    private void populateToddlerList(String listName){

            currentToddlerList = new ToddlerList(listName);
            allToddlerItems = currentToddlerList.getItemList();
            lastIndex = currentToddlerList.getLastIndex();
            textList = currentToddlerList.isTextList();

    }












}
