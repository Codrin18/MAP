package Domain;

import java.io.Serializable;

public class Relation implements Serializable {

    private String activity;
    private String discipline;
    private String formation;
    private String room;
    private String teacher;
    private String date;

    public Relation(String activity, String discipline, String formation, String room, String teacher, String date) {
        this.activity = activity;
        this.discipline = discipline;
        this.formation = formation;
        this.room = room;
        this.teacher = teacher;
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public String getDiscipline() {
        return discipline;
    }

    public void setDiscipline(String discipline) {
        this.discipline = discipline;
    }

    public String getFormation() {
        return formation;
    }

    public void setFormation(String formation) {
        this.formation = formation;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return "Relation{" +
                "activity='" + activity + '\'' +
                ", discipline='" + discipline + '\'' +
                ", formation='" + formation + '\'' +
                ", room='" + room + '\'' +
                ", teacher='" + teacher + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
