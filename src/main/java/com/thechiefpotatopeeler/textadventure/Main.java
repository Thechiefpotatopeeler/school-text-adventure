package com.thechiefpotatopeeler.textadventure;

import com.thechiefpotatopeeler.textadventure.handlers.InputHandler;
import com.thechiefpotatopeeler.textadventure.handlers.WorldLoader;

import java.util.Scanner;

public class Main {

    public static Scanner inputStream = new Scanner(System.in);

    public static void main(String[] args){
        System.out.println("Game started");
        //System.out.println("Starting world loader\n");
        //WorldLoader loader = new WorldLoader("src/main/resources/test_world.json");
        InputHandler handler = new InputHandler();
    }

}
