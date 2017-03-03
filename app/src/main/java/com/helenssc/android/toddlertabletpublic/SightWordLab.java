package com.helenssc.android.toddlertabletpublic;

import android.content.Context;
import android.util.Log;

import java.io.File;
import java.util.ArrayList;

/**
 * <h1>Toddler Tablet SightWordLab/h1>
 * Creates an static object to handle load and save requests for custom SightWord CustomItems
 * created in SightWordActivity.
 * @author Christine Stoner
 * @version 1.0
 * @since 2017-02-27
 */
public class SightWordLab {

    private static final String TAG="SightWordLab";
    private static final String FILENAME = "toddlertabletsightwords.json";

    private File mFile, uFile;

    private ArrayList<CustomItem> mCustomItems, uCustomItems;
    private CustomItemJSONSerializer mSerializer, uSerializer;

    private static SightWordLab sCustomItemLab;
    private Context mAppContext, uAppContext;

    /**
     *   Creates an instance of SightWordLab
     * @param appContext application Context
     */
    private SightWordLab(Context appContext){
        mAppContext = appContext;
        mFile = new File(mAppContext.getExternalFilesDir(null),FILENAME);
        //create new JSONSerializer for savign and retrieving
        mSerializer = new CustomItemJSONSerializer(mAppContext, FILENAME, false);

        try{
            mCustomItems = mSerializer.loadCustomItems();
            Log.d(TAG, "mCustom size is" + mCustomItems.size());
        } catch (Exception e){
            mCustomItems = new ArrayList<CustomItem>();
            Log.d(TAG, "new arraylist created");

            Log.e(TAG, "Error loading items:", e);
        }


    }

    /**
     * Creates a static SightWordLab instance
     * @param c application Context
     */
    public static SightWordLab get(Context c){
        if(sCustomItemLab == null){
            sCustomItemLab = new SightWordLab(c.getApplicationContext());
        }
        return sCustomItemLab;
    }

    /**
     *  Gets list of CustomItems saved by app
     *  @return ArrayList of CustomItem objects
     */
    public ArrayList<CustomItem> getSightWords(){
        return mCustomItems;
    }

    /**
     *  Adds CustomItem to current ArrayList of CustomItems
     *  @param c CustomItem to add to list
     *  @return nothing
     */
    public void addCustomItem(CustomItem c){
        mCustomItems.add(c);
    }

    /**
     *  Save current CustomItem ArrayList through JSON serializer
     *  @return boolean true if success false if error
     */
    public boolean saveCustomItems(){
        try{
            mSerializer.saveCustomItems(mCustomItems);
            Log.d(TAG, "items saved to file");
            return true;
        } catch (Exception e){
            Log.e(TAG,"Error saving items:",e);
            return false;
        }
    }
}


