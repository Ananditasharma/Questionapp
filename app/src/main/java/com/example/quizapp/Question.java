package com.example.quizapp;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class Question extends Fragment {
    OnLogoutListener logoutListener;
    public  interface OnLogoutListener
    {
        public void logoutPerformed();
    }



    TextView tv1,tv2,tv3;
    CheckBox a,b,c,d;
    Button bt1,bt2,bt3,bt4,bt5,bt6,bt7,bt8,bt9;
    int q,s;
   OnaddListener addListener;


    public interface OnaddListener
    {
        public void add();
    }



    public Question() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_question, container, false);

        tv1 = view.findViewById(R.id.tv_question);
        tv2 = view.findViewById(R.id.response);
        tv3 = view.findViewById(R.id.score);
        bt1 = view.findViewById(R.id.btn_one);
        bt2 = view.findViewById(R.id.btn_two);
        bt3 = view.findViewById(R.id.btn_three);
        bt4 = view.findViewById(R.id.btn_four);
        bt5 = view.findViewById(R.id.btn_five);
        bt6 = view.findViewById(R.id.btn_six);
        bt7 = view.findViewById(R.id.btn_seven);
        bt8 = view.findViewById(R.id.btn_eight);
        bt9 = view.findViewById(R.id.btn_nine);
        a = view.findViewById(R.id.cb1);
        b = view.findViewById(R.id.cb2);
        c = view.findViewById(R.id.cb3);
        d = view.findViewById(R.id.cb4);
        q = 0;
        s = 0;
        bt9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logoutListener.logoutPerformed();

            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addListener.add();

            }
        });

        return view;

    }


    public void onAttach(Context context) {

        super.onAttach(context);
        Activity activity = (Activity) context;

        logoutListener = (Question.OnLogoutListener) activity;
        addListener=(OnaddListener) activity;
    }
}






