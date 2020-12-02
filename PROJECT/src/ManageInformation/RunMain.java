package ManageInformation;

import Controller.DataController;
import Controller.DataUtility;
import Manage.CyberGame;
import Manage.Gamer;
import Manage.PersonalComputer;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Scanner;

public class RunMain {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        String pcFileName = "PCGAMING.DAT";
        String gamerFilename = "GAMER.DAT";

        DataController dataController = new DataController();
        DataUtility dataUtility = new DataUtility();

        ArrayList<PersonalComputer> personalComputers = new ArrayList<>();
        ArrayList<Gamer> gamers = new ArrayList<>();
        CyberGame cyberGame = new CyberGame();

        Scanner scanner = new Scanner(System.in);
        int selection;
        do {
            System.out.println("------------------------------------------------------------------------------");
            System.out.println("MENU");
            System.out.println("1. Add PC Gaming.");
            System.out.println("2. Add Gamer.");
            System.out.println("3. Show information list PC Gaming");
            System.out.println("4. Show information available PC");
            System.out.println("5. Show information of PC is already in use");
            System.out.println("6. Show information list Gamer");
            System.out.println("7. Show VIP Gamer");
            System.out.println("8. Show revenue of Cyber");
            System.out.println("9. Update information PC Gaming by ID");
            System.out.println("10. Update information Gamer by ID");
            System.out.println("11. Sort list PC Gaming");
            System.out.println("12. Sort list Gamer");
            System.out.println("13. Exit");

            System.out.print("Your selection: ");
            selection = scanner.nextInt();

            switch (selection) {
                case 1:
                    personalComputers = dataController.ReadPCFromFile(pcFileName);
                    String mainBoard, cpu, vga, keyboard, mouse, headphone, status;
                    String regexPCID = "^\\d{3,}$";
                    int idPCAdd, ram, screenSize, checkExistsPC;
                    System.out.println("Enter information of PC: ");
                    do {
                        System.out.print("\tID PC Gaming: ");
                        idPCAdd = scanner.nextInt();

                        checkExistsPC = GetIndexPC(personalComputers, idPCAdd);
                        if (String.valueOf(idPCAdd).matches(regexPCID)) {
                            if (checkExistsPC != -1) {
                                System.out.println("ID PC exists");
                            } else {
                                break;
                            }
                        } else {
                            System.out.println("ID PC must have 3 numeric characters!");
                        }
                    } while (true);
                    scanner.nextLine();
                    System.out.print("\tMainboard: ");
                    mainBoard = scanner.nextLine();
                    System.out.print("\tCPU: ");
                    cpu = scanner.nextLine();
                    System.out.print("\tRAM capacity: ");
                    ram = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("\tVGA: ");
                    vga = scanner.nextLine();
                    System.out.print("\tScreen size: ");
                    screenSize = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("\tKeyboard: ");
                    keyboard = scanner.nextLine();
                    System.out.print("\tMouse: ");
                    mouse = scanner.nextLine();
                    System.out.print("\tHeadphone: ");
                    headphone = scanner.nextLine();
                    System.out.print("\tStatus: ");
                    status = scanner.nextLine();
                    PersonalComputer personalComputer = new PersonalComputer(idPCAdd, mainBoard, cpu, ram, vga, screenSize, keyboard, mouse, headphone, status);
                    dataController.WritePCToFile(pcFileName, personalComputer);
                    break;
                case 2:
                    personalComputers = dataController.ReadPCFromFile(pcFileName);
                    gamers = dataController.ReadGamerFromFile(gamerFilename);
                    if (AmountPC(personalComputers) == 0) {
                        System.out.println("Cyber doesn't have a computer. You need add PC Gaming!");
                    } else {
                        if (!CheckAmountPC(personalComputers, gamers.size())) {
                            System.out.println("Cyber hasn't available PC. See you again!");
                        } else {
                            System.out.println("Enter information of Gamer: ");
//                            gamers = dataController.ReadGamerFromFile(gamerFilename);
                            String fullName, address;
                            String regexGamerID = "^\\d{3,}$";
                            int idGamerAdd, phoneNumber, idPCUse, availableHours, timeUsed, checkExistGamer;
                            do {
                                System.out.print("\tID Gamer: ");
                                idGamerAdd = scanner.nextInt();

                                checkExistGamer = GetIndexGamer(gamers, idGamerAdd);
                                if (String.valueOf(idGamerAdd).matches(regexGamerID)) {
                                    if (checkExistGamer != -1) {
                                        System.out.println("ID Gamer exist!");
                                    } else {
                                        break;
                                    }
                                } else {
                                    System.out.println("ID Gamer must have 3 numeric characters!");
                                }
                            } while (true);
                            scanner.nextLine();
                            System.out.print("\tFull name: ");
                            fullName = scanner.nextLine();
                            System.out.print("\tAddress: ");
                            address = scanner.nextLine();
                            System.out.print("\tPhone Number: ");
                            phoneNumber = scanner.nextInt();
                            System.out.print("\tID PC gamer use: ");
                            idPCUse = scanner.nextInt();
                            System.out.print("\tAvailable hours: ");
                            availableHours = scanner.nextInt();
                            System.out.print("\tTime used: ");
                            timeUsed = scanner.nextInt();
                            Gamer gamer = new Gamer(idGamerAdd, fullName, address, phoneNumber, idPCUse, availableHours, timeUsed);
                            dataController.WriteGamerToFile(gamerFilename, gamer);
                        }
                    }
                    break;
                case 3:
                    ShowListPC(dataController, pcFileName);
                    break;
                case 4:
                    ShowListPCAvailable(dataController, personalComputers, pcFileName, gamers, gamerFilename);
                    break;
                case 5:
                    ShowListPCUsing(dataController, personalComputers, pcFileName, gamers, gamerFilename);
                    break;
                case 6:
                    ShowListGamer(dataController, gamerFilename);
                    break;
                case 7:
                    ShowListVIPGamer(dataController, gamerFilename);
                    break;
                case 8:
                    RevenueOfCyber(dataController, gamerFilename);
                    break;
                case 11:
                    SortListPCGaming(dataController, pcFileName, dataUtility);
                    break;
                case 12:
                    SortListGamers(dataController, gamerFilename, dataUtility);
                    break;
                case 13:
                    break;

            }
        } while (true);
    }

    public static void SortListGamers(DataController dataController, String fileName, DataUtility dataUtility){
        ArrayList<Gamer> gamers = dataController.ReadGamerFromFile(fileName);
        int selection, selectionAdvanced;
        do {
            System.out.println("MENU SORT LIST GAMERS");
            System.out.println("1. Sort by ID Gamer.");
            System.out.println("2. Sort by available hours.");
            System.out.println("3. Sort by time used.");

            System.out.print("Your selection: ");
            selection = scanner.nextInt();

            switch (selection){
                case 1:
                    System.out.println("ADVANCED SORT");
                    System.out.println("1. Sort by ID Gamer (ascending).");
                    System.out.println("2. Sort by ID Gamer (descending).");
                    System.out.print("Your advanced selection: ");
                    selectionAdvanced = scanner.nextInt();
                    switch (selectionAdvanced){
                        case 1:
                            dataUtility.SortListGamerByIDAscending(gamers);
                            break;
                        case 2:
                            dataUtility.SortListGamerByIDDescending(gamers);
                            break;
                    }
                    dataController.UpdateGamerFile(gamers, fileName);
                    break;
                case 2:
                    System.out.println("ADVANCED SORT");
                    System.out.println("1. Sort by available hours (ascending).");
                    System.out.println("2. Sort by available hours (descending).");
                    System.out.print("Your advanced selection: ");
                    selectionAdvanced = scanner.nextInt();
                    switch (selectionAdvanced){
                        case 1:
                            dataUtility.SortListGamerByAvailableHoursAscending(gamers);
                            break;
                        case 2:
                            dataUtility.SortListGamerByAvailableHoursDescending(gamers);
                            break;
                    }
                    dataController.UpdateGamerFile(gamers, fileName);
                    break;
                case 3:
                    System.out.println("ADVANCED SORT");
                    System.out.println("1. Sort by time used (ascending).");
                    System.out.println("2. Sort by time used (descending).");
                    System.out.print("Your advanced selection: ");
                    selectionAdvanced = scanner.nextInt();
                    switch (selectionAdvanced){
                        case 1:
                            dataUtility.SortListGamerByTimeUsedAscending(gamers);
                            break;
                        case 2:
                            dataUtility.SortListGamerByTimeUsedDescending(gamers);
                            break;
                    }
                    dataController.UpdateGamerFile(gamers, fileName);
                    break;
            }

        } while (selection <= 0 || selection >=4);
    }

    public static void SortListPCGaming(DataController dataController, String fileName, DataUtility dataUtility){
        ArrayList<PersonalComputer> personalComputers = dataController.ReadPCFromFile(fileName);
        int selection, selectionAdvanced;
        do {
            System.out.println("MENU SORT LIST PC GAMING");
            System.out.println("1. Sort by ID PC.");
            System.out.println("2. Sort by RAM capacity.");
            System.out.println("3. Sort by Screen size.");

            System.out.print("Your selection: ");
            selection = scanner.nextInt();

            switch (selection){
                case 1:
                    System.out.println("ADVANCED SORT");
                    System.out.println("1. Sort by ID PC (ascending).");
                    System.out.println("2. Sort by ID PC (descending).");
                    System.out.print("Your advanced selection: ");
                    selectionAdvanced = scanner.nextInt();
                    switch (selectionAdvanced){
                        case 1:
                            dataUtility.SortListPCByIDAscending(personalComputers);
                            break;
                        case 2:
                            dataUtility.SortListPCByIDDescending(personalComputers);
                            break;
                    }
                    dataController.UpdatePCFile(personalComputers, fileName);
                    break;
                case 2:
                    System.out.println("ADVANCED SORT");
                    System.out.println("1. Sort by RAM capacity (ascending).");
                    System.out.println("2. Sort by RAM capacity (descending).");
                    System.out.print("Your advanced selection: ");
                    selectionAdvanced = scanner.nextInt();
                    switch (selectionAdvanced){
                        case 1:
                            dataUtility.SortListPCByRAMCapacityAscending(personalComputers);
                            break;
                        case 2:
                            dataUtility.SortListPCByRAMCapacityDescending(personalComputers);
                            break;
                    }
                    dataController.UpdatePCFile(personalComputers, fileName);
                    break;
                case 3:
                    System.out.println("ADVANCED SORT");
                    System.out.println("1. Sort by Screen size (ascending).");
                    System.out.println("2. Sort by Screen size (descending).");
                    System.out.print("Your advanced selection: ");
                    selectionAdvanced = scanner.nextInt();
                    switch (selectionAdvanced){
                        case 1:
                            dataUtility.SortListPCByScreenSizeAscending(personalComputers);
                            break;
                        case 2:
                            dataUtility.SortListPCByScreenSizeDescending(personalComputers);
                            break;
                    }
                    dataController.UpdatePCFile(personalComputers, fileName);
                    break;
            }

        } while (selection <= 0 || selection >=4);
    }


    public static void RevenueOfCyber(DataController dataController, String fileName) {
        int revenue = 0;
        int hours = 0;
        ArrayList<Gamer> gamers = dataController.ReadGamerFromFile(fileName);
        for (int i = 0; i < gamers.size(); i++) {
            hours += gamers.get(i).getTimeUsed() + gamers.get(i).getAvailableHours();
        }
        revenue = 8000 * hours;
        System.out.println("Revenue of Cyber: " + revenue + " VND with " + hours + " hours have been paid.");
    }

    public static void ShowListVIPGamer(DataController dataController, String fileName) {
        int count = 0;
        ArrayList<Gamer> gamers = dataController.ReadGamerFromFile(fileName);
        for (int i = 0; i < gamers.size(); i++) {
            if (gamers.get(i).getTimeUsed() > 100) {
                count++;
            }
        }
        System.out.println("Cyber has " + count + " Gamer(s) are (is) VIP member.");
        for (int i = 0; i < gamers.size(); i++) {
            if (gamers.get(i).getTimeUsed() > 100) {
                System.out.println(gamers.get(i));
            }
        }

    }

    public static void ShowListGamer(DataController dataController, String fileName) {
        ArrayList<Gamer> gamers = dataController.ReadGamerFromFile(fileName);
        System.out.println("Cyber has " + gamers.size() + " Gamer(s)");
        for (Gamer gamer : gamers) {
            System.out.println(gamer);
        }
    }

    public static void ShowListPCUsing(DataController dataController, ArrayList<PersonalComputer> personalComputers,
                                       String pcFileName, ArrayList<Gamer> gamers, String gamerFileName) {
        personalComputers = dataController.ReadPCFromFile(pcFileName);
        gamers = dataController.ReadGamerFromFile(gamerFileName);
        for (int i = 0; i < personalComputers.size(); i++) {
            for (int j = 0; j < gamers.size(); j++) {
                if (personalComputers.get(i).getIdPC() == gamers.get(j).getIdPCUse()) {
                    System.out.println(personalComputers.get(i));
                    break;
                }
            }
        }
    }


    public static void ShowListPCAvailable(DataController dataController, ArrayList<PersonalComputer> personalComputers,
                                           String pcFileName, ArrayList<Gamer> gamers, String gamerFileName) {
        personalComputers = dataController.ReadPCFromFile(pcFileName);
        gamers = dataController.ReadGamerFromFile(gamerFileName);
        for (int i = 0; i < personalComputers.size(); i++) {
            for (int j = 0; j < gamers.size(); j++) {
                if (personalComputers.get(i).getIdPC() == gamers.get(j).getIdPCUse()) {
                    break;
                }
                System.out.println(personalComputers.get(i));
            }
        }
    }

    public static void ShowListPC(DataController dataController, String fileName) {
        ArrayList<PersonalComputer> personalComputers = dataController.ReadPCFromFile(fileName);
        for (PersonalComputer personalComputer : personalComputers) {
            System.out.println(personalComputer);
        }
    }

    private static int AmountPC(ArrayList<PersonalComputer> personalComputers) {
        return personalComputers.size();
    }

    private static boolean CheckAmountPC(ArrayList<PersonalComputer> personalComputers, int amountGamer) {
        if (amountGamer >= personalComputers.size()) {
            return false;
        }
        return true;
    }

    private static int GetIndexPC(ArrayList<PersonalComputer> personalComputers, int pcID) {
        for (int i = 0; i < personalComputers.size(); i++) {
            if (personalComputers.get(i).getIdPC() == pcID) {
                return i;
            }
        }
        return -1;
    }

    private static int GetIndexGamer(ArrayList<Gamer> gamers, int gamerID) {
        for (int i = 0; i < gamers.size(); i++) {
            if (gamers.get(i).getIdGamer() == gamerID) {
                return i;
            }
        }
        return -1;
    }

}
