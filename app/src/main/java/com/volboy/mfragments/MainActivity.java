package com.volboy.mfragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements FragmentOne.onSelectedButtonListener {

    private boolean isDynamic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTwo fragmentTwo= (FragmentTwo)fragmentManager.findFragmentById(R.id.fragment2);
        isDynamic=fragmentTwo==null||!fragmentTwo.isInLayout(); //если фрагемент отсутсвует или не используется в разметке, то isDynamic=true
        Toast.makeText(this, isDynamic+"", Toast.LENGTH_SHORT).show();
        if (isDynamic){
            FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
            FragmentOne fragmentOne=new FragmentOne();
            fragmentTransaction.add(R.id.container, fragmentOne, "fragmentOne");
            fragmentTransaction.commit();
        }
    }

    @Override
    public void onSelectedButton(int buttonIndex) {
        //если мы в портретной ориентации (т.е. фрагемент два не доступен), то переходим на вторую активити
        //иначе вызываем метод второго фрагмента и передаем ему индекс нажатой кнопки
        /*FragmentManager fragmentManager=getSupportFragmentManager(); //получаем менеджер фрагментов
        FragmentTwo fragmentTwo= (FragmentTwo)fragmentManager.findFragmentById(R.id.fragment2); //получаем FragmentTwo через менеджера
        if (fragmentTwo==null || !fragmentTwo.isVisible()) {
            Intent intent=new Intent(this, SecondActivity.class);
            intent.putExtra("buttonIndex", buttonIndex);
            startActivity(intent);
        } else{
            fragmentTwo.setDescription(buttonIndex); //передаем в метод fragmentTwo индекс от fragmentOne через активити
        }*/

        //переделываем предыдущий пример, теперь если фрагмент два недоступен (т.е. isDymanic=true), то
        //используем динамический переход ко второму фрагменту
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTwo fragmentTwo;
        if (isDynamic){
            //динамически заменяем первый фрагмент на второй
            FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
            fragmentTwo=new FragmentTwo();
            Bundle args=new Bundle(); //подготавливаем аргументы
            args.putInt(FragmentTwo.BUTTON_INDEX, buttonIndex);
            fragmentTwo.setArguments(args);
            fragmentTransaction.replace(R.id.container, fragmentTwo);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out);
            fragmentTransaction.commit();
        }else {
            fragmentTwo=(FragmentTwo)fragmentManager.findFragmentById(R.id.fragment2);
            fragmentTwo.setDescription(buttonIndex);
        }


    }
}
