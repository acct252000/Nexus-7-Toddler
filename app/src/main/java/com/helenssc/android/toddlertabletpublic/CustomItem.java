package com.helenssc.android.toddlertabletpublic;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * <h1>Toddler Tablet CustomItem</h1>
 * Creates an object to hold custom items, such as flashcards or family member or picture
 * flashcards created by the user.
 *
 * @author Christine Stoner
 * @version 1.0
 * @since 2017-02-27
 */
public class CustomItem {

    private String cardTitle;
    private String soundFile;
    private int imageID;
    private String imageFile;
    private static final String JSON_TITLE="title";
    private static final String JSON_IMAGEID="imageID";
    private static final String JSON_SOUNDFILE="soundFile";
    private static final String JSON_IMAGEFILE="imageFile";


    /**
     * Creates a CustomItem with only a title.
     * @param title String title of the CustomItem.
     */
    public CustomItem(String title){
        cardTitle = title;
    }

    /**
     * Creates a CustomItem with a title and soundfile reference.
     * @param title String title of the CustomItem.
     * @param newSoundFile String name of soundfile
     */
    public CustomItem(String title, String newSoundFile){
        cardTitle = title;
        soundFile = newSoundFile;
    }

    /**
     * Creates a CustomItem with a title, soundfile,and picturefile reference.
     * @param title String title of the CustomItem.
     * @param soundFileName String name of soundfile
     * @param picImageFile String name of picture file
     */
    public CustomItem(String title, String soundFileName, String picImageFile){
        cardTitle = "";
        soundFile = soundFileName;
        imageFile = picImageFile;
    }

    /**
     * Creates a CustomItem from a JSONObject.
     * @param json JSONObject holding Custom Item information
     * @throws JSONException
     */
    public CustomItem(JSONObject json) throws JSONException {
        //Id= UUID.fromString(json.getString(JSON_ID));
        if(json.has(JSON_TITLE)){
            cardTitle = json.getString(JSON_TITLE);
        }
        if(json.has(JSON_IMAGEID)){
            imageID = json.getInt(JSON_IMAGEID);
        }
        if(json.has(JSON_SOUNDFILE)){
            soundFile = json.getString(JSON_SOUNDFILE);
        }
        if(json.has(JSON_IMAGEFILE)){
            imageFile = json.getString(JSON_IMAGEFILE);
        }

    }

    /**
     * Converts this CustomItem into a JSONObject.
     * @return JSONObject of CustomItem
     * @throws JSONException
     */
    public JSONObject toJSON() throws JSONException{
        JSONObject json = new JSONObject();
        //json.put(JSON_ID,Id.toString());
        json.put(JSON_TITLE,cardTitle);
        json.put(JSON_IMAGEID,imageID);
        json.put(JSON_SOUNDFILE,soundFile);
        json.put(JSON_IMAGEFILE,imageFile);
        return json;

    }

    /**
     * Returns card title.
     * @return String card title
     */
    public String getCardTitle() {
        return cardTitle;
    }

    /**
     * Returns int ImageId.
     * @return int image id
     */
    public int getImageID(){
        return imageID;
    }

    /**
     * Returns String image file name
     * @return String image file name
     */
    public String getImageFile() { return imageFile;}

    /**
     * Sets item title
     * @param signTitle String item title
     * @return nothing
     */
    public void setCardTitle(String signTitle) {
        this.cardTitle = signTitle;
    }

    /**
     * Returns String sound file name
     * @return String sound file name
     */
    public String getSoundFile() {return soundFile;}

    /**
     * Sets sound file name
     * @param soundFileName String soundFileName
     * @return nothing
     */
    public void setSoundFile(String soundFileName){
        soundFile = soundFileName;
    }

    /**
     * Sets image file name
     * @param imageFileName String imageFileName
     * @return nothing
     */
    public void setImageFile(String imageFileName) {imageFile = imageFileName;}

    /**
     * Sets image ID
     * @param imageID int image id
     * @return nothing
     */
    public void setImageID(int imageID){
        this.imageID = imageID;
    }



}

