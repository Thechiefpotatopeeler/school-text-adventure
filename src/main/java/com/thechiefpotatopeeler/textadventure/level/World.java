package com.thechiefpotatopeeler.textadventure.level;

import com.thechiefpotatopeeler.textadventure.handlers.WorldLoader;

import java.util.ArrayList;

public class World {

    public static ArrayList<Room> rooms;
    public static int[][] roomMappings;
    public static int roomIn;
    public static String levelName;
    public static String levelDescription;
    public World(){
    }

    public static void acceptWorlds(WorldLoader worldLoader){
        rooms = worldLoader.getRooms();
        roomMappings = worldLoader.getRoomMappings();
        roomIn = worldLoader.getDefaultRoom();
    }

    public static void onRoomChange(Room room){
        System.out.println(String.format("You have entered the %s",room.getName()));
    }

}
