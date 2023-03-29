package com.thechiefpotatopeeler.textadventure.level;

import com.thechiefpotatopeeler.textadventure.handlers.WorldLoader;

import java.util.ArrayList;

public class World {

    public ArrayList<Room> rooms;
    public int[][] roomMappings;
    public World(WorldLoader worldLoader){
        //The world's info is loaded from the worldLoader
        this.rooms = worldLoader.getRooms();
        this.roomMappings = worldLoader.getRoomMappings();
    }
}
