package Exercise_01;

public class Employee extends Person {
    private int salary;

    public Employee() {

    }

    @Override
    public void display() {
        System.out.println("Employee name: " + this.getName());
        System.out.println("Employee address: " + this.getAddress());
        System.out.println("Employee salary: " + this.getSalary());
    }

    public Employee(int salary) {
        this.salary = salary;
    }

    public Employee(String name, String address, int salary) {
        super(name, address);
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
