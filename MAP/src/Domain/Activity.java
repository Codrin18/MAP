package Domain;

public class Activity {

    private String name;
    private String activityType;

    public Activity(String name, String activityType) {
        this.name = name;
        this.activityType = activityType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getActivityType() {
        return activityType;
    }

    public void setActivityType(String activityType) {
        this.activityType = activityType;
    }

    @Override
    public String toString() {
        return "Activity{" +
                "name='" + name + '\'' +
                ", activityType='" + activityType + '\'' +
                '}';
    }
}
