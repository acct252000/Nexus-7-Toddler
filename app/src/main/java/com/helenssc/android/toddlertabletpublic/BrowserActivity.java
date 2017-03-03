package com.helenssc.android.toddlertabletpublic;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;

/**
 * <h1>Toddler Tablet BrowserActivity</h1>
 * Mimics an autofeeding/scrolling website.   Activity is exited through the
 * menu in case the navigation bar has been disabled.
 * <br />
 * <b>Note:</b>  This activity was designed for a 2012 Nexus 7 wifi that has been rooted
 * to disable the bottom navigation bar.
 *
 * @author Christine Stoner
 * @version 1.0
 * @since 2017-02-27
 */

public class BrowserActivity extends ActionBarActivity {
    private WebView mWebView;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browser);
        /*assign webview and settings for website
        webpage is designed and implemented in webfiles referenced
         */
        mWebView = (WebView)findViewById(R.id.browser_webview);
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.getSettings().setDomStorageEnabled(true);
        mWebView.loadUrl("file:///android_asset/testweb.html");

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


}
