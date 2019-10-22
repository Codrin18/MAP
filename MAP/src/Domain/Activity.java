package Domain;

public class Activity {

    private String name;
    //private String teacherName;

    public Activity(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "Activity{" +
                "name='" + name + '\'' +
                ", teacherName='" +  '\'' +
                '}';
    }
}
