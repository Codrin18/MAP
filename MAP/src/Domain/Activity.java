package Domain;

public class Activity {

    private String name;
    private String teacherName;

    public Activity(String name, String teacherName) {
        this.name = name;
        this.teacherName = teacherName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    @Override
    public String toString() {
        return "Activity{" +
                "name='" + name + '\'' +
                ", teacherName='" + teacherName + '\'' +
                '}';
    }
}
