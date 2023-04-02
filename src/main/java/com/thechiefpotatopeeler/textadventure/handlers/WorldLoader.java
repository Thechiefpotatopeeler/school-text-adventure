package com.thechiefpotatopeeler.textadventure.handlers;

//The project imports
import com.thechiefpotatopeeler.textadventure.level.Room;
//The JSON-simple imports
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
//The Java imports
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.io.FileReader;
import java.io.Reader;

public class WorldLoader {

    private ArrayList<Room> rooms = new ArrayList<Room>(); //The rooms in the game world
    private int[][] roomMappings; //The connections between the rooms in the game world
    public WorldLoader(String worldFile) throws IOException, ParseException, FileNotFoundException {
        /* This class loads the rooms and their connections in the game world.
         * This is taken from the JSON file of the world.
         * The JSON file is parsed and the rooms are loaded into the rooms arrayList.
         * The roomMappings array is also loaded with the connections between the rooms.
         *
         * The rooms are connected by their IDs, the first dimension of the array is the direction, 0 is north, 1 is east, 2 is south, 3 is west,
         * 4 is up, 5 is down, the second dimension is the room's ID, the value is the ID of the room that is connected in that direction. If the
         * value is -1, there is no room connected in that direction.
         *
         * For example, roomMappings[0][4] is the ID of the room that is connected to room 4 in the north direction.
         * */
        JSONParser parser = new JSONParser();
        Reader reader = new FileReader(worldFile);
        JSONObject worldJSON = (JSONObject) parser.parse(reader);
        JSONArray roomList = (JSONArray) worldJSON.get("rooms");
        for(int i = 0; i < roomList.size(); i++){
            //The rooms
            JSONObject currentRoom = (JSONObject) roomList.get(i);
            rooms.add(new Room((Integer) currentRoom.get("id"),(String) currentRoom.get("name"),(String) currentRoom.get("description")));
            //The room Mappings
            roomMappings [0][i] = (Integer) currentRoom.get("north");
            roomMappings [1][i] = (Integer) currentRoom.get("east");
            roomMappings [2][i] = (Integer) currentRoom.get("south");
            roomMappings [3][i] = (Integer) currentRoom.get("west");
            roomMappings [4][i] = (Integer) currentRoom.get("up");
            roomMappings [5][i] = (Integer) currentRoom.get("down");

        }

    }
    /**
     * @return the rooms
     */
    public ArrayList<Room> getRooms(){
        return rooms;
    }
    /**
     * @return the roomMappings
     * where [0][] is north, [1][] is east, [2][] is south, [3][] is west, [4][] is up, [5][] is down,
     * and [][i] is the room ID to go to when going in a given direction from room i.
     */
    public int[][] getRoomMappings(){
        return roomMappings;
    }
}
