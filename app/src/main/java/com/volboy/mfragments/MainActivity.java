package com.volboy.mfragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements FragmentOne.onSelectedButtonListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onSelectedButton(int buttonIndex) {
        FragmentManager fragmentManager=getSupportFragmentManager(); //получаем менеджер фрагментов
        FragmentTwo fragmentTwo= (FragmentTwo)fragmentManager.findFragmentById(R.id.fragment2); //получаем FragmentTwo через менеджера
        if (fragmentTwo!=null) {
            fragmentTwo.setDescription(buttonIndex); //передаем в метод fragmentTwo индекс от fragmentOne через активити
        }

    }
}
