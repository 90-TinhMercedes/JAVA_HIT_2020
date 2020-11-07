package Exercise_01;

public class RunMain {
    public static void main(String[] args) {
        Person person_01 = new Employee("Chí Tình", "Hà Nam", 100000000);
        Person person_02 = new Customer("Love Veigar", "Hà Nam", 4500000);
        person_01.display();
        System.out.println();
        person_02.display();


    }
}
