package com.thechiefpotatopeeler.textadventure;

import com.thechiefpotatopeeler.textadventure.handlers.WorldLoader;

import java.util.Scanner;

public class Main {

    public static Scanner inputStream = new Scanner(System.in);

    public static void main(String[] args){
        System.out.println("Game started");
        System.out.println("Starting world loader");
        WorldLoader loader = new WorldLoader("test_world.json");
    }

}
