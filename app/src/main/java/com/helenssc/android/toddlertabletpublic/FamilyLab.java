package com.helenssc.android.toddlertabletpublic;

import android.content.Context;
import android.util.Log;

import java.io.File;
import java.util.ArrayList;

/**
 * <h1>Toddler Tablet FamilyLab/h1>
 * Creates an static object to handle load and save requests for custom Family CustomItems
 * created in FamilyActivity.
 * @author Christine Stoner
 * @version 1.0
 * @since 2017-02-27
 */
public class FamilyLab {

    private static final String TAG="FamilyLab";
    //create filename for saving family items
    private static final String FILENAME = "toddlertabletfamily.json";



    private File mFile, uFile;

    private ArrayList<CustomItem> mCustomItems, uCustomItems;
    private CustomItemJSONSerializer mSerializer, uSerializer;

    private static FamilyLab sCustomItemLab;
    private Context mAppContext, uAppContext;

    /**
     *   Creates an instance of FamilyLab
    * @param appContext application Context
    */
    private FamilyLab(Context appContext){
        mAppContext = appContext;
        //create File for saving items in JSON format
        mFile = new File(mAppContext.getExternalFilesDir(null),FILENAME);
        //create new JSONSerializer to save and retrieve files
        mSerializer = new CustomItemJSONSerializer(mAppContext, FILENAME, false);
        //attempt to load Custom Items
        try{
            mCustomItems = mSerializer.loadCustomItems();
        } catch (Exception e){
            mCustomItems = new ArrayList<CustomItem>();
        }


    }

    /**
     * Creates a static FamilyLab instance
     * @param c application Context
     */
    public static FamilyLab get(Context c){
        if(sCustomItemLab == null){
            sCustomItemLab = new FamilyLab(c.getApplicationContext());
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


