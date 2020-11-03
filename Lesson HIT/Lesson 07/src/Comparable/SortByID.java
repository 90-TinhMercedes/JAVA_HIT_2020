package Comparable;

import java.util.Comparator;

public class SortByID implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        int result = 0;
        if (this.ID > o.getID()) {
            result = 1;
        } else if (this.ID < o.getID()) {
            result = -1;
        }

        return result;
    }
}
