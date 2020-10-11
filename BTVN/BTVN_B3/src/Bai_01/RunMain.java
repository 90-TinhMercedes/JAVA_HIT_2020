package Bai_01;

public class RunMain {
    public static void main(String[] args) {
        Person TrungXinhGai = new Person();
        Person DoanBueDe = new Person();

        TrungXinhGai.setName("Bé Trung");
        TrungXinhGai.setDateOfBirth("06/03/2001");
        TrungXinhGai.setGender("Nữ");
        TrungXinhGai.setHobby("Master Yi ^.^");

        DoanBueDe.setName("Bé Doan");
        DoanBueDe.setDateOfBirth("06/03/2001");
        DoanBueDe.setGender("Buê Đuê");
        DoanBueDe.setHobby("Attack Dame Carry");

        System.out.println("------------------------------------");
        System.out.println("Information Trung Master Yi");
        System.out.println("Name: " + TrungXinhGai.getName());
        System.out.println("Date of birth: " + TrungXinhGai.getDateOfBirth());
        System.out.println("Gender: " + TrungXinhGai.getGender());
        System.out.println("Hobby: " + TrungXinhGai.getHobby());

        System.out.println("------------------------------------");
        System.out.println("Information Doan ADC");
        System.out.println("Name: " + DoanBueDe.getName());
        System.out.println("Date of birth: " + DoanBueDe.getDateOfBirth());
        System.out.println("Gender: " + DoanBueDe.getGender());
        System.out.println("Hobby: " + DoanBueDe.getHobby());
        System.out.println("------------------------------------");
    }
}
