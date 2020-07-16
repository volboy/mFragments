package com.volboy.mfragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class FragmentTwo extends Fragment {
    TextView txtNote;
    ArrayList<String> myButtons=new ArrayList<String>();
    public final static String BUTTON_INDEX="button_index";
    private final static int BUTTON_INDEX_DEFAULT=-1;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View rootView=inflater.inflate(R.layout.fragment2, container, false);
        txtNote=rootView.findViewById(R.id.txtNote);
        myButtons.add("Вперед");
        myButtons.add("Назад");
        Bundle args=getArguments(); //получаем аргументы
        //если агрументы не равны нули получаем индекс по ключу
        //иначе присваем значение BUTTON_INDEX_DEFAULT
        int buttonIndex=args!=null?args.getInt(BUTTON_INDEX, BUTTON_INDEX_DEFAULT):BUTTON_INDEX_DEFAULT;
        //если индекс отличен от значения по умолчанию, то используем его
        if (buttonIndex!=BUTTON_INDEX_DEFAULT){
            setDescription(buttonIndex);
        }

        return rootView;
    }

    public void setDescription(int index){
        switch (index){
            case 0:
                txtNote.setText("Никая кнопка не нажата");
                break;
            case 1:
                txtNote.setText("Нажата кнопка " + myButtons.get(0) + " - данная кнопка направит к следующей записи");
                break;
            case 2:
                txtNote.setText("Нажата кнопка " + myButtons.get(1) + " - данная кнопка направит к предыдущей записи");
                break;
        }
    }
}
