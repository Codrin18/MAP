package Domain;

import java.io.Serializable;

public class Discipline implements Serializable {

    private String name;

    public Discipline(String name) {
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
        return "Discipline{" +
                "name='" + name + '\'' +
                '}';
    }
}
