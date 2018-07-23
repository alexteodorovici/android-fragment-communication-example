package com.ideeastudios.example.fragment.communication;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

//the main activity implements the ContractInterface therefore the function incrementCounter
public class MainActivity extends AppCompatActivity implements ContractInterface {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //get a reference to the fragment manager
        FragmentManager fm = getSupportFragmentManager();

        //initialize the top fragment
        Fragment top = new FragmentTop();

        //initialize the bottom fragment
        Fragment bot = new FragmentBottom();

        //add the top fragment content into the topFrameLayout from activity_main.xml
        fm.beginTransaction().add(R.id.topFrameLayout, top).commit();

        //add the bottom fragment content into the bottomFrameLayout from activity_main.xml
        fm.beginTransaction().add(R.id.bottomFrameLayout, bot).commit();
    }

    //by implementing the ContractInterface the main activity signs a contract by which it is
    //obligated to implement the function incrementCounter
    @Override
    public void incrementCounter(int count) {
        //get a reference to the fragment manager
        FragmentManager fm = getSupportFragmentManager();

        //in onCreate function we added the bottom fragment to the manager with the id bottomFrameLayout.
        //we can now access the bottom fragment by its id as it was added before.
        //the function findFragmentById returns a Fragment object but because the bottom fragment
        // extends Fragment we can reference it as FragmentBottom
        FragmentBottom bottomFragment = (FragmentBottom) fm.findFragmentById(R.id.bottomFrameLayout);

        //we call the incrementCounter function from the FragmentBottom passing it the count as we
        //got it from the top fragment.
        if (bottomFragment != null) {
            bottomFragment.incrementCounter(count);
        }
    }
}