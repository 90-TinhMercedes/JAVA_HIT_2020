package Manage;

public class Gamer {
    private int idGamer;
    private String fullName;
    private String address;
    private int phoneNumber;
    private int idPCUse;
    private int availableHours;
    private int timeUsed;

    public Gamer() {

    }

    public Gamer(int idGamer, String fullName, String address, int phoneNumber, int idPCUse, int availableHours, int timeUsed) {
        this.idGamer = idGamer;
        this.fullName = fullName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.idPCUse = idPCUse;
        this.availableHours = availableHours;
        this.timeUsed = timeUsed;
    }

    public int getIdGamer() {
        return idGamer;
    }

    public void setIdGamer(int idGamer) {
        this.idGamer = idGamer;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getIdPCUse() {
        return idPCUse;
    }

    public void setIdPCUse(int idPCUse) {
        this.idPCUse = idPCUse;
    }

    public int getAvailableHours() {
        return availableHours;
    }

    public void setAvailableHours(int availableHours) {
        this.availableHours = availableHours;
    }

    public int getTimeUsed() {
        return timeUsed;
    }

    public void setTimeUsed(int timeUsed) {
        this.timeUsed = timeUsed;
    }

    @Override
    public String toString() {
        return "Gamer{" +
                "idGamer='" + idGamer + '\'' +
                ", fullName='" + fullName + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", idPCUse='" + idPCUse + '\'' +
                ", availableHours='" + availableHours + '\'' +
                ", timeUsed='" + timeUsed + '\'' +
                '}';
    }
}
