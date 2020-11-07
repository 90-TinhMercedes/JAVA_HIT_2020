package Lesson_02;

public class RunMain {
    public static void main(String[] args) {
        ComplexNumber cn1 = new ComplexNumber(1, 5);
        ComplexNumber cn2 = new ComplexNumber(4, 7);

//        System.out.println("Enter complex number 01: ");
//        cn1.inputNumber();
//        System.out.println("Enter complex number 02: ");
//        cn2.inputNumber();

        ComplexNumber temp = cn1.plush(cn2);
        System.out.print("CN1 + CN2 = ");
        temp.showNumber();

        temp = cn1.subtraction(cn2);
        System.out.print("CN1 + CN2 = ");
        temp.showNumber();
    }
}
