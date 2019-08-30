package com.example.quizapp;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class optionsfragment extends Fragment {

Button b1,b2,b3,b4,b5;
    OnadddocListener adddocListener;


    public interface OnadddocListener
    {
        public void adddoc();
    }

    public optionsfragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_options, container, false);

        b1=view.findViewById(R.id.btn_1);
        b2=view.findViewById(R.id.btn_2);
        b3=view.findViewById(R.id.btn_3);
        b4 = view.findViewById(R.id.btn_4);
        b5=view.findViewById(R.id.btn_5);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               adddocListener.adddoc();

            }
        });

        return view;
    }
    public void onAttach(Context context) {

        super.onAttach(context);
        Activity activity = (Activity) context;

        adddocListener =(OnadddocListener) activity;
    }

}
