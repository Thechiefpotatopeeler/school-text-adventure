package com.thechiefpotatopeeler.textadventure.level;

import com.thechiefpotatopeeler.textadventure.handlers.WorldLoader;

import java.util.ArrayList;

public class World {

    public static ArrayList<Room> rooms;
    public static int[][] roomMappings;
    public static int roomIn;
    public static String LevelName;
    public static String LevelDescription;
    public World(){
    }

    public static void acceptWorlds(WorldLoader worldLoader){
        rooms = worldLoader.getRooms();
        roomMappings = worldLoader.getRoomMappings();
        roomIn = worldLoader.getDefaultRoom();
    }
}
