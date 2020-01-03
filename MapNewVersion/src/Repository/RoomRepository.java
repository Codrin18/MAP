package Repository;

import Domain.Room;

import java.sql.*;
import java.util.ArrayList;

public class RoomRepository extends  Database {
    public RoomRepository() {
        super("Rooms","(name STRING PRIMARY KEY)");
    }

    public void addRoom(Room r){
        try{
            Connection conn = DriverManager.getConnection(this.path);
            PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO Rooms VALUES (?)");
            preparedStatement.setString(1,r.getName());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteRoom(Room r){
        try{
            Connection conn = DriverManager.getConnection(this.path);
            PreparedStatement preparedStatement = conn.prepareStatement("DELETE FROM Rooms WHERE name=?");
            preparedStatement.setString(1,r.getName());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Room> getAllRooms(){
        ArrayList<Room> rooms = new ArrayList<>();
        try{
            Connection conn = DriverManager.getConnection(this.path);
            PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM Rooms");
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                Room r = new Room(resultSet.getString("name"));
                rooms.add(r);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rooms;
    }
}
