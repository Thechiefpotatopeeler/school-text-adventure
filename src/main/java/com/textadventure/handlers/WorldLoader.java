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
    public WorldLoader(String worldFile) throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        Reader reader = new FileReader(worldFile);
        JSONObject worldJSON = (JSONObject) parser.parse(reader);

    }

    public Room loadRoomFromJSON(int roomNumber){
        Room room;

        return null;
    }
}
