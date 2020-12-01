package Manage;

public class PersonalComputer {
    private int idPC;
    private String mainboard;
    private String cpu;
    private int ram;
    private String vga;
    private int screenSize;
    private String keyboard;
    private String mouse;
    private String headphone;
    private String status;

    public PersonalComputer() {

    }

    public PersonalComputer(int idPC, String mainboard, String cpu, int ram, String vga, int screenSize, String keyboard, String mouse, String headphone, String status) {
        this.idPC = idPC;
        this.mainboard = mainboard;
        this.cpu = cpu;
        this.ram = ram;
        this.vga = vga;
        this.screenSize = screenSize;
        this.keyboard = keyboard;
        this.mouse = mouse;
        this.headphone = headphone;
        this.status = status;
    }

    public int getIdPC() {
        return idPC;
    }

    public void setIdPC(int idPC) {
        this.idPC = idPC;
    }

    public String getMainboard() {
        return mainboard;
    }

    public void setMainboard(String mainboard) {
        this.mainboard = mainboard;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public String getVga() {
        return vga;
    }

    public void setVga(String vga) {
        this.vga = vga;
    }

    public int getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(int screenSize) {
        this.screenSize = screenSize;
    }

    public String getKeyboard() {
        return keyboard;
    }

    public void setKeyboard(String keyboard) {
        this.keyboard = keyboard;
    }

    public String getMouse() {
        return mouse;
    }

    public void setMouse(String mouse) {
        this.mouse = mouse;
    }

    public String getHeadphone() {
        return headphone;
    }

    public void setHeadphone(String headphone) {
        this.headphone = headphone;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "PersonalComputer{" +
                "id='" + idPC + '\'' +
                ", mainboard='" + mainboard + '\'' +
                ", cpu='" + cpu + '\'' +
                ", ram='" + ram + '\'' +
                ", vga='" + vga + '\'' +
                ", screenSize='" + screenSize + '\'' +
                ", keyboard='" + keyboard + '\'' +
                ", mouse='" + mouse + '\'' +
                ", headphone='" + headphone + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
