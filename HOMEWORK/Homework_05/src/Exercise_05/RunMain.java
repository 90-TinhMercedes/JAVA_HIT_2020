package Lesson_05;

public class RunMain {
    public static void main(String[] args) {
        Classroom classroom = new Classroom();
        classroom.inputClassroom();
        System.out.println("-------------------------------------------------------------------------------------------------------------------");
        System.out.printf("Student K14: " + classroom.countK14() + "\n");
        classroom.sortByLevel();
        classroom.showClassroom();
    }
}
