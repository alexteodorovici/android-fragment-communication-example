package com.ideeastudios.example.fragment.communication;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

public class FragmentTop extends Fragment {

    //the main activity of type ContractInterface
    private ContractInterface mainActivity;
    public Button incrementButton;
    //initialize the counter at 0.
    private int count = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_top, container, false);
        incrementButton = (Button) v.findViewById(R.id.incrementButton);

        //increment the counter when button is clicked.
        incrementButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                count++;
                //mainActivity is instantiated in onAttach function.
                //it implements the ContractInterface therefore we can call the incrementCounter
                //function on it.
                mainActivity.incrementCounter(count);
            }
        });
        return v;
    }

    //the onAttach function is called as soon as this fragment is associated with an activity.
    @Override
    public void onAttach(Context activity) {
        super.onAttach(activity);
        //we have access to the activity this fragment is associated to.
        //because the main activity implements ContractInterface, we can reference to it as ContractInterface
        mainActivity = (ContractInterface) activity;
    }
}
