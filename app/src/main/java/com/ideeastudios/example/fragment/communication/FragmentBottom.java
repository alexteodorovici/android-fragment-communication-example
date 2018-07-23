package com.ideeastudios.example.fragment.communication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class FragmentBottom extends Fragment {
    //reference to the bottom text view
    private TextView bottomTextView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_bottom, container, false);
        bottomTextView = (TextView) v.findViewById(R.id.bottomTextView);
        return v;
    }

    //this function is called from the MainActivity (via the ContractInterface from FragmentTop button).
    //it displayes the current count in the text view.
    public void incrementCounter(int count) {
        bottomTextView.setText("Count: " + count);
    }
}
