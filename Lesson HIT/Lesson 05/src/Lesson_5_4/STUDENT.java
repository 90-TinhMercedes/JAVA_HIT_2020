package Lesson_5_4;

public class STUDENT extends PERSON{
    @Override // ghi đè phương thức của class PERSON
    public void hienThi(){
        System.out.println("GFE Love Veigar");
        super.hienThi();
    }
}
