package com.thechiefpotatopeeler.textadventure.handlers;

import java.util.ArrayList;
import java.util.Scanner;
import com.thechiefpotatopeeler.textadventure.Main;

public class InputHandler /*extends Thread*/{

    public InputHandler() {

    }
    /*@Override
    public void run() {

    }*/
    // This is an enum that holds the different types of input
    public enum InputType {
        MOVE,
        INVENTORY,
        LOOK
    }
    // This is a class that holds the input type and the arguments
    public class InputResult {
        public InputType type;
        public ArrayList<String> args;
    }
    // This method is used to request input from the user
    public InputResult requestInput(){
        System.out.println("Please enter a command: ");
        String[] input = Main.inputStream.nextLine().split(" ");
        InputResult result = new InputResult();
        result.type = InputType.valueOf(input[0].toUpperCase());
        result.args = new ArrayList<String>();
        for (int i = 1; i < input.length-1; i++){
            result.args.add(input[i]);
        }
        return result;
    }
}
