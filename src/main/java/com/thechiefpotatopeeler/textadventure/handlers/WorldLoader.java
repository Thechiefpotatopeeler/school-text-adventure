package com.thechiefpotatopeeler.textadventure.handlers;

//The project imports
import com.thechiefpotatopeeler.textadventure.Ref;
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
import java.lang.ClassCastException;

public class WorldLoader {

    private ArrayList<Room> rooms; //The rooms in the game world
    private int[][] roomMappings; //The connections between the rooms in the game world
    private int defaultRoom; //The default room that the player starts in
    private String levelName;
    private String levelDescription;
    /**
    * @param worldFile string with the name of the world file to load
    * */
    public WorldLoader(String worldFile) {
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
         *
         * */
        try{
            JSONParser parser = new JSONParser();
            Reader reader = new FileReader(worldFile);
            JSONObject worldJSON = (JSONObject) parser.parse(reader);
            JSONArray roomList = (JSONArray) worldJSON.get("rooms");
            rooms = new ArrayList<Room>();
            roomMappings = new int[6][roomList.size()];
            defaultRoom = (Integer) worldJSON.get("start_room");
            levelName = (String) worldJSON.get("level_name");
            levelDescription = (String) worldJSON.get("level_description");
                for(int i = 0; i < roomList.size(); i++){
                    //The rooms
                    JSONObject currentRoom = (JSONObject) roomList.get(i);
                    rooms.add(new Room((Integer) currentRoom.get("id"),(String) currentRoom.get("name"),(String) currentRoom.get("description")));
                    //The room Mappings
                    roomMappings [0][i] = (Integer) currentRoom.get(Ref.DIRECTION_NAMES[0]);
                    roomMappings [1][i] = (Integer) currentRoom.get(Ref.DIRECTION_NAMES[1]);
                    roomMappings [2][i] = (Integer) currentRoom.get(Ref.DIRECTION_NAMES[2]);
                    roomMappings [3][i] = (Integer) currentRoom.get(Ref.DIRECTION_NAMES[3]);
                    roomMappings [4][i] = (Integer) currentRoom.get(Ref.DIRECTION_NAMES[4]);
                    roomMappings [5][i] = (Integer) currentRoom.get(Ref.DIRECTION_NAMES[5]);

            }
        } catch (IOException e){
            System.out.println("Error loading world file");
        } catch (ParseException e){
            System.out.println("Error parsing world file");
        } catch (ClassCastException e){
            System.out.println("World file is not formatted correctly");
        }


    }
    /**
     * @return the rooms
     */
    public ArrayList<Room> getRooms(){
        return rooms;
    }
    /**
     * @return  the roomMappings
     * where [0][] is north, [1][] is east, [2][] is south, [3][] is west, [4][] is up, [5][] is down,
     * and [][i] is the room ID to go to when going in a given direction from room i.
     */
    public int[][] getRoomMappings(){
        return roomMappings;
    }

    public int getDefaultRoom(){
        return defaultRoom;
    }
    public String getLevelDescription(){
        return levelDescription;
    }
}
