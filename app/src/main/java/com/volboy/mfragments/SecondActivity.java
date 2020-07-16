package com.volboy.mfragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        if (getResources().getConfiguration().orientation== Configuration.ORIENTATION_LANDSCAPE){
            finish();
            return;
        }
        Intent intent=getIntent();
        int indexButton=intent.getIntExtra("buttonIndex", -1);
        if (indexButton!=-1) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTwo fragmentTwo = (FragmentTwo) fragmentManager.findFragmentById(R.id.fragment2);
            fragmentTwo.setDescription(indexButton);
        }


    }
}
