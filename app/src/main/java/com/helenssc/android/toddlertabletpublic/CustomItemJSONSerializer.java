package com.helenssc.android.toddlertabletpublic;


import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONTokener;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;

/**
 * Created by christinestoner on 2/21/16.
 */
public class CustomItemJSONSerializer {

    private Context mContext;
    private String mFilename, mCompleteFilename;
    private File mFile;


    /**
     *   Creates an instance of CustomItemJSONSerializer
     * @param c application Context
     * @param f String for filename
     * @param isNFC boolean for NFC functionality
     */

    public CustomItemJSONSerializer(Context c, String f, boolean isNFC){
        mContext = c;
        mFilename = f;
        //create File for saving
        mFile = new File(mContext.getExternalFilesDir(null),mFilename);
        mCompleteFilename = mFile.getAbsolutePath();
    }

    /**
     * Loads previously saved CustomItems from disk
     * @return ArrayList of CustomItems
     * @throws IOException
     * @throws JSONException
     */

    public ArrayList<CustomItem> loadCustomItems() throws IOException, JSONException {
        ArrayList<CustomItem> sightWords = new ArrayList<CustomItem>();
        BufferedReader reader = null;
        try{
            //Open and read the file into a StringBuilder
            FileInputStream fis = new FileInputStream(new File(mCompleteFilename));
            //InputStream in = mContext.openFileInput(mFilename);
            reader = new BufferedReader(new InputStreamReader(fis));
            StringBuilder jsonString = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null){
                //Line breaks are omitted and irrelevant
                jsonString.append(line);
            }
            //Parse the JSON using JSONTokener
            JSONArray array = (JSONArray) new JSONTokener(jsonString.toString()).nextValue();
            //Build the arry of tasks from JSONObjects
            for (int i=0;i<array.length();i++){
                sightWords.add(new CustomItem(array.getJSONObject(i)));
            }
        } catch (FileNotFoundException e){
            //Ignore this one; it happens when starting fresh
        } finally {
            if (reader !=null)
                reader.close();
        }
        return sightWords;
    }

    /**
     * Saves current list of CustomItems to disk in JSON format
     * @pram tasks ArrayList of CustomItems to save
     * @return nothing
     * @throws IOException
     * @throws JSONException
     */
    public void saveCustomItems(ArrayList<CustomItem> tasks) throws JSONException, IOException {
        //Build an array in JSON
        JSONArray array = new JSONArray();
        for(CustomItem c : tasks)
            array.put(c.toJSON());

        //Write the file to disk
        Writer writer = null;
        try{
            FileOutputStream fos = new FileOutputStream(new File(mCompleteFilename));
            //OutputStream out = mContext.openFileOutput(mFilename, Context.MODE_PRIVATE);
            writer = new OutputStreamWriter(fos);
            writer.write(array.toString());
        } finally {
            if (writer != null)
                writer.close();
        }
    }

}


