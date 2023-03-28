package com.textadventure.handlers;

import com.textadventure.level.Room;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.io.FileReader;
import java.io.Reader;

public class WorldLoader {

    private ArrayList<Room> rooms = new ArrayList<Room>();
    public WorldLoader(String worldFile) throws IOException, ParseException, FileNotFoundException {
        JSONParser parser = new JSONParser();
        Reader reader = new FileReader(worldFile);
        JSONObject worldJSON = (JSONObject) parser.parse(reader);
        JSONArray roomList = (JSONArray) worldJSON.get("rooms");
        for(int i = 0; i < roomList.size(); i++){
            JSONObject currentRoom = (JSONObject) roomList.get(i);
            rooms.add(new Room((Integer) currentRoom.get("id"),(String) currentRoom.get("name"),(String) currentRoom.get("description")));
        }
    }
    public ArrayList<Room> getRooms(){
        return rooms;
    }
}
