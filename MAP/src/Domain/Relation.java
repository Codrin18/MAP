package Domain;

public class Relation<Type> {
    private Type key1;
    private Type key2;

    public Relation(Type key1, Type key2) {
        this.key1 = key1;
        this.key2 = key2;
    }

    public Type getKey1() {
        return key1;
    }

    public void setKey1(Type key1) {
        this.key1 = key1;
    }

    public Type getKey2() {
        return key2;
    }

    public void setKey2(Type key2) {
        this.key2 = key2;
    }

    @Override
    public String toString() {
        return "Relation{" +
                "key1=" + key1 +
                ", key2=" + key2 +
                '}';
    }
}
