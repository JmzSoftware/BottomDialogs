package com.github.javiersantos.bottomdialogs.demo;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;

import com.github.javiersantos.bottomdialogs.BottomDialog;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

    }

    public void sample(View view) {
        new BottomDialog.Builder(this)
                .setTitle("Awesome!")
                .setContent("Glad to see you like BottomDialogs! If you're up for it, we would really appreciate you reviewing us.")
                .setPositiveText("Google Play")
                .setNegativeText("Close")
                .show();
    }

    public void sampleCustomView(View view) {
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View customView = inflater.inflate(R.layout.bottomdialog_layout, null);

        new BottomDialog.Builder(this)
                .setTitle("Awesome!")
                .setContent("Glad to see you like BottomDialogs! If you're up for it, we would really appreciate you reviewing us.")
                .setCustomView(customView)
                .setPositiveText("Google Play")
                .setNegativeText("Close")
                .show();
    }

    public void toGithub(View view) {
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/javiersantos/BottomDialogs")));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);


        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_about) {
            startActivity(new Intent(this, AboutActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
