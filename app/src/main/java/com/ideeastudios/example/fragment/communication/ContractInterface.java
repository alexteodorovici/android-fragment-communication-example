package com.ideeastudios.example.fragment.communication;

//this interface defines a contract for the class that implements it (MainActivity).
//the MainActivity is therefore obligated to implement the function incrementCounter.
public interface ContractInterface {

    //this function will be implemented in MainActivity and called by the onClick function
    //from the FragmentTop.
    //it receives the next count and it passes it to the FragmentBottom to be displayed
    public void incrementCounter(int count);
}
