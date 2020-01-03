package Domain;

import java.io.Serializable;

public class Formation implements Serializable {

    private String name;

    public Formation(String name) {
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
        return "Formation{" +
                "name='" + name + '\'' +
                '}';
    }
}
