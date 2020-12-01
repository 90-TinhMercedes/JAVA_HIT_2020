package Manage;

public class CyberGame {
    private PersonalComputer personalComputer;
    private Gamer gamer;
    private String addressCyber;
    private String manager;

    public CyberGame(PersonalComputer personalComputer, Gamer gamer, String addressCyber, String manager) {
        this.personalComputer = personalComputer;
        this.gamer = gamer;
        this.addressCyber = addressCyber;
        this.manager = manager;
    }

    public PersonalComputer getPersonalComputer() {
        return personalComputer;
    }

    public void setPersonalComputer(PersonalComputer personalComputer) {
        this.personalComputer = personalComputer;
    }

    public Gamer getGamer() {
        return gamer;
    }

    public void setGamer(Gamer gamer) {
        this.gamer = gamer;
    }

    public String getAddressCyber() {
        return addressCyber;
    }

    public void setAddressCyber(String addressCyber) {
        this.addressCyber = addressCyber;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    @Override
    public String toString() {
        return "CyberGame{" +
                "personalComputer=" + personalComputer +
                ", gamer=" + gamer +
                ", addressCyber='" + addressCyber + '\'' +
                ", manager='" + manager + '\'' +
                '}';
    }
}
