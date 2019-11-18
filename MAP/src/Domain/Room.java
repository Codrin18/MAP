package Domain;

public class Room {

    private String idRoom;
    private String building;

    public Room(String idRoom, String building) {
        this.idRoom = idRoom;
        this.building = building;
    }

    public String getIdRoom() {
        return idRoom;
    }

    public void setIdRoom(String idRoom) {
        this.idRoom = idRoom;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    @Override
    public String toString() {
        return "Room{" +
                "idRoom='" + idRoom + '\'' +
                ", building='" + building + '\'' +
                '}';
    }
}
