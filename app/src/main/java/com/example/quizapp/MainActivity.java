package com.example.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


public class MainActivity extends AppCompatActivity  implements loginfragment.OnLoginFormActivityListener,optionsfragment.OnadddocListener,Question.OnLogoutListener,Question.OnaddListener {

    public static PrefConfig prefConfig;
    public static ApiInterface apiInterface;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        prefConfig = new PrefConfig(this);
        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);

        if(findViewById(R.id.fragment_container)!=null)
        {
            if(savedInstanceState!=null)
            {
                return;
            }

            if(prefConfig.readLoginStatus())
            {
                getSupportFragmentManager().beginTransaction().add(R.id.fragment_container,new optionsfragment()).commit();


            }
            else
            {

                getSupportFragmentManager().beginTransaction().add(R.id.fragment_container,new loginfragment()).commit();
            }
        }
    }

    @Override
    public void performRegister() {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                new Registrationfragment()).addToBackStack(null).commit();
    }

    @Override
    public void performLogin() {
        //prefConfig.writeName(name);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new optionsfragment()).commit();

    }

    @Override
    public void adddoc() {

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new Question()).addToBackStack(null).commit();


    }

    @Override
    public void add() {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new NextQuestion()).addToBackStack(null).commit();



    }

    @Override
    public void logoutPerformed() {
        prefConfig.writeLoginStatus(false);
        prefConfig.writeName("User");
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new loginfragment()).commit();
    }

}





