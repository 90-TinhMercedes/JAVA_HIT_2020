package Bai_05;

public class Guns {
    private String weaponName;
    private int ammoNumber;

    public Guns() {

    }

    public Guns(String weaponName, int ammoNumber) {
        this.weaponName = weaponName;
        this.ammoNumber = ammoNumber;
    }

    public String getWeaponName() {
        return weaponName;
    }

    public void setWeaponName(String weaponName) {
        this.weaponName = weaponName;
    }

    public int getAmmoNumber() {
        return ammoNumber;
    }

    public void setAmmoNumber(int ammoNumber) {
        this.ammoNumber = ammoNumber;
    }

    public void Load(int x){
        this.ammoNumber += x;
    }
    public void Shoot(int x){
        if(x >= 0)
            this.ammoNumber -= x;
        if(this.ammoNumber == 0)
            System.out.printf("Hết đạn!!");
    }
}
