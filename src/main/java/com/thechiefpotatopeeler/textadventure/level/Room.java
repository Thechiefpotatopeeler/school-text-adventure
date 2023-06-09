package com.thechiefpotatopeeler.textadventure.level;

public class Room {

    private final int id;//The numerical ID of the room
    private final String name;//The name of the room displayed to players
    private final String description;//The description of the room displayed to players
    public Room(int id, String name, String description) {//The constructor
        this.id = id;
        this.name = name;
        this.description = description;
    }
    public int getId() {//Returns the ID of the room
        return id;
    }
    public String getName() {//Returns the name of the room
        return name;
    }
    public String getDescription() {//Returns the description of the room
        return description;
    }
}
