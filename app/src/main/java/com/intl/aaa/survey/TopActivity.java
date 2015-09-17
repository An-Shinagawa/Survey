package com.intl.aaa.survey;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;

import static android.graphics.Color.*;


public class TopActivity extends ActionBarActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_top, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void actToStats(View view){
        switch (view.getId()){
            case R.id.btnToStats:
                Intent intent = new Intent(this, StatsActivity.class);
                startActivity(intent);
                break;
        }
    }


    public void actToSurvey(View view){
        switch (view.getId()){
            case R.id.btnToSurvey:
                Intent intent = new Intent(this, QuestionActivity.class);
                startActivity(intent);
                break;
        }
    }

    public void actToImport(View view){
        switch (view.getId()){
            case R.id.btnImportFile:
/*                Intent intent = new Intent(this, QuestionActivity.class);
                startActivity(intent);*/
                Toast iftoast = Toast.makeText(this, "Clicked IMPORT FILE", Toast.LENGTH_LONG);
                iftoast.show();
                break;
        }
    }
}
