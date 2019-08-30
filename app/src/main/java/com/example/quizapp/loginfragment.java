package com.example.quizapp;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class loginfragment extends Fragment {

        private TextView RegText;
        private EditText UserName , UserPassword ;
        private Button Loginbn;

        OnLoginFormActivityListener loginFormActivityListener;
        public interface OnLoginFormActivityListener
        {
            public void performRegister();
            public void performLogin();
        }

        public loginfragment() {
            // Required empty public constructor
        }



        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            // Inflate the layout for this fragment

            View view = inflater.inflate(R.layout.fragment_login, container, false);
            RegText = view.findViewById(R.id.register_txt);
            UserName = view.findViewById(R.id.user_name);
            UserPassword = view.findViewById(R.id.user_pass);
            Loginbn = view.findViewById(R.id.login_bn);

            Loginbn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // performLogin();
                    if (UserName.getText().length() == 0) {
                        UserName.setError("Please Enter Name");
                    } else if (UserPassword.getText().length() == 0) {
                        UserPassword.setError("Please Enter Password");
                    } else if (UserName.getText().toString().equals("admin") && UserPassword.getText().toString().equals("admin")) {

                             loginFormActivityListener.performLogin();
                    }
                }
            });





            RegText.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    loginFormActivityListener.performRegister();


                }
            });


            return view;
        }

        public void onAttach(Context context) {

            super.onAttach(context);
            Activity activity = (Activity) context;
            loginFormActivityListener =(OnLoginFormActivityListener) activity;
        }


     /*   private void performLogin()
        {
            String username = UserName.getText().toString();
            String password = UserPassword.getText().toString();

            retrofit2.Call <User> call = MainActivity.apiInterface.performUserLogin(username,password);

            call.enqueue(new Callback <User>() {
                @Override
                public void onResponse(retrofit2.Call <User> call, Response <User> response) {

                    if(response.body().getResponse().equals("ok")){
                        MainActivity.prefConfig.writeLoginStatus(true);
                        loginFormActivityListener.performLogin(response.body().getName());
                    }
                    else if(response.body().getResponse().equals("failed")){
                        MainActivity.prefConfig.displayToast("Login failed please try again.....");
                    }


                }

                @Override
                public void onFailure(Call <User> call, Throwable t) {

                }
            });

            UserName.setText("");
            UserPassword.setText("");


        }*/

    }

