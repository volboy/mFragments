package com.volboy.mfragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentOne extends Fragment implements View.OnClickListener {
    Button btnNext, btnLast;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View rootView=inflater.inflate(R.layout.fragment1, container, false);
        btnNext=rootView.findViewById(R.id.btnNext);
        btnLast=rootView.findViewById(R.id.btnLast);
        btnNext.setOnClickListener(this);
        btnLast.setOnClickListener(this);
        return rootView;
    }


    @Override
    public void onClick(View v) {
        //Toast.makeText(getActivity(), getIndex(v).toString(), Toast.LENGTH_LONG).show();
        onSelectedButtonListener onSelectedButtonListener=(FragmentOne.onSelectedButtonListener)getActivity(); //получаем экземпляр интерфейса от активити
        onSelectedButtonListener.onSelectedButton(getIndex(v)); //вызваем метод интерфейса и передаем ему индекс нажатой кнопки

    }

    private Integer getIndex(View v){

        switch (v.getId()){
            case R.id.btnNext:
               return 1;
            case R.id.btnLast:
                return 2;
            default:
                return 0;
        }

    }

    public interface onSelectedButtonListener{
        void onSelectedButton(int buttonIndex);

    }
}
