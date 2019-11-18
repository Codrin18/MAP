package Domain;

public class Timeslot {

    private String dayOfWeek;
    private int startHour;
    private int endHour;

    public Timeslot(String dayOfWeek, int startHour, int endHour) {
        this.dayOfWeek = dayOfWeek;
        this.startHour = startHour;
        this.endHour = endHour;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public int getStartHour() {
        return startHour;
    }

    public void setStartHour(int startHour) {
        this.startHour = startHour;
    }

    public int getEndHour() {
        return endHour;
    }

    public void setEndHour(int endHour) {
        this.endHour = endHour;
    }

    @Override
    public String toString() {
        return "Timeslot{" +
                "dayOfWeek='" + dayOfWeek + '\'' +
                ", startHour=" + startHour +
                ", endHour=" + endHour +
                '}';
    }
}
