package Comparable;

public class Person implements Comparable<Person>{
    private int ID;
    private String name;

    @Override
    public String toString() {
        return "Person{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(Person o) {
        int result = 0;
        if (this.ID > o.getID()) {
            result = 1;
        } else if (this.ID < o.getID()) {
            result = -1;
        }

        return result;
    }

    public Person(int ID, String name) {
        this.ID = ID;
        this.name = name;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
