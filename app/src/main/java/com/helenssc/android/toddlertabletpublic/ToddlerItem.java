package com.helenssc.android.toddlertabletpublic;

/**
 * <h1>Toddler Tablet ToddlerItem</h1>
 * Creates an object to hold flashcards, including a title, picture and sound
 *
 * @author Christine Stoner
 * @version 1.0
 * @since 2017-02-27
 */
public class ToddlerItem {

    private String cardTitle;
    private int imageID;
    private int soundID;
    private int color;

    /**
     * Creates a ToddlerItem with a title and imageNumber reference.
     * @param title String title of the CustomItem.
     * @param imageNumber int id of image
     */
    public ToddlerItem(String title, int imageNumber){
        cardTitle = title;
        imageID = imageNumber;
        color = 0;

    }

    /**
     * Creates a ToddlerItem with a title, imageNumber reference and soundNumber reference.
     * @param title String title of the CustomItem.
     * @param imageNumber int id of image
     * @param soundNumber int id of sound
     */
    public ToddlerItem(String title, int imageNumber, int soundNumber){
        cardTitle = title;
        imageID = imageNumber;
        soundID = soundNumber;

    }

    /**
     * Creates a ToddlerItem with a title, imageNumber reference, soundNumber reference, and colorNumber reference.
     * @param title String title of the CustomItem.
     * @param imageNumber int id of image
     * @param soundNumber int id of sound
     * @param colorNumber int id of color
     */
    public ToddlerItem(String title, int imageNumber, int soundNumber, int colorNumber){
        cardTitle = title;
        imageID = imageNumber;
        soundID = soundNumber;
        color=colorNumber;

    }

    /**
     * Sets item title.
     * @param title String title of item
     * @return nothing
     */
    public void setTitle(String title){
        cardTitle = title;
    }

    /**
     * Returns card title.
     * @return String card title
     */
    public String getLetterTitle() {
        return cardTitle;
    }

    /**
     * Returns items imageID.
     * @return int image ID
     */
    public int getImageID() {
        return imageID;
    }

    /**
     * Returns items soundID.
     * @return int sound ID
     */
    public int getSoundID(){
        return soundID;
    }


    /**
     * Sets item title.
     * @param signTitle String title of item
     * @return nothing
     */
    public void setLetterTitle(String signTitle) {
        this.cardTitle = signTitle;
    }

    /**
     * Sets image ID.
     * @param imageID int reference to image
     * @return nothing
     */
    public void setImageID(int imageID) {
        this.imageID = imageID;
    }

    /**
     * Sets sound ID.
     * @param soundID int reference to sound
     * @return nothing
     */
    public void setSoundID(int soundID){
        this.soundID = soundID;
    }

    /**
     * Returns items colorID.
     * @return int color ID
     */
    public int getColor(){ return color;}

    /**
     * Sets color ID.
     * @param colorID int reference to color
     * @return nothing
     */
    public void setColor(int colorID){ this.color = colorID;}



}

