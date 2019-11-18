package Domain;

import java.sql.Time;

public class Formation {

    private String format;
    private Room room;
    private Activity activity;
    private Timeslot timeslot;

    public Formation(String format, Room room, Activity activity, Timeslot timeslot) {
        this.format = format;
        this.room = room;
        this.activity = activity;
        this.timeslot = timeslot;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public Timeslot getTimeslot() {
        return timeslot;
    }

    public void setTimeslot(Timeslot timeslot) {
        this.timeslot = timeslot;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    @Override
    public String toString() {
        return "Formation{" +
                "format='" + format + '\'' +
                ", room=" + room +
                ", activity=" + activity +
                ", timeslot=" + timeslot +
                '}';
    }
}
