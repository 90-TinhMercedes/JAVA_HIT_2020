package Bai_05;

public class RunMain {
    public static void main(String[] args) {
        Guns FirstPlayer = new Guns("AKM", 30);
        Guns SecondPlayer = new Guns("M416", 45);

        while (FirstPlayer.getAmmoNumber() > 0 && SecondPlayer.getAmmoNumber() > 0) {
            FirstPlayer.Shoot(5);
            FirstPlayer.Load(3);
            SecondPlayer.Shoot(5);
            SecondPlayer.Load(3);
        }
        if (FirstPlayer.getAmmoNumber() == 0) {
            System.out.println("First player lose - Ammo remaining " + FirstPlayer.getAmmoNumber());
            System.out.println("Second player win - Ammo remaining " + SecondPlayer.getAmmoNumber());
        } else {
            System.out.println("First player win - Ammo remaining " + FirstPlayer.getAmmoNumber());
            System.out.println("Second player lose - Ammo remaining " + SecondPlayer.getAmmoNumber());
        }
    }
}
