package ManageInformation;

import Controller.DataController;
import Controller.DataUtility;
import Manage.CyberGame;
import Manage.Gamer;
import Manage.PersonalComputer;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RunMain {
    public static Scanner scanner = new Scanner(System.in);
    public static String pcFileName = "PCGAMING.DAT";
    public static String gamerFilename = "GAMER.DAT";

    public static void main(String[] args) {


        DataController dataController = new DataController();
        DataUtility dataUtility = new DataUtility();

        ArrayList<PersonalComputer> personalComputers = new ArrayList<>();
        ArrayList<Gamer> gamers = new ArrayList<>();
        CyberGame cyberGame = new CyberGame();

        Scanner scanner = new Scanner(System.in);
        int selection;
        do {
            System.out.println("------------------------------------------------------------------------------");
            System.out.println("ChiTinh GAMING - 1977, Khuat Duy Tien Street,  Thanh Xuan Trung Ward, Thanh Xuan District, Ha Noi City");
            System.out.println("Manager: GFE Chi Tinh");
            System.out.println("MENU");
            System.out.println("1. Add PC Gaming.");
            System.out.println("2. Add Gamer.");
            System.out.println("3. Show information list PC Gaming.");
            System.out.println("4. Show information available PC.");
            System.out.println("5. Show information of PC is already in use.");
            System.out.println("6. Show information list Gamer.");
            System.out.println("7. Show VIP Gamer.");
            System.out.println("8. Show revenue of Cyber.");
            System.out.println("9. Update information PC Gaming by ID.");
            System.out.println("10. Update information Gamer by ID.");
            System.out.println("11. Sort list PC Gaming.");
            System.out.println("12. Sort list Gamer.");
            System.out.println("13. Exit.");

            System.out.print("Your selection: ");
            selection = scanner.nextInt();

            switch (selection) {
                case 1:
                    AddPersonalComputerGaming(personalComputers, dataController);
                    break;
                case 2:
                    AddGamer(personalComputers, gamers, dataController);
                    break;
                case 3:
                    ShowListPC(dataController, pcFileName);
                    break;
                case 4:
                    ShowListPCAvailable(dataController, personalComputers, pcFileName);
                    break;
                case 5:
                    ShowListPCUsing(dataController, personalComputers, pcFileName);
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
                case 9:
                    UpdateInformationPCGaming(dataController, pcFileName);
                    break;
                case 10:
                    UpdateInformationGamer(dataController, gamerFilename);
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

    public static boolean CheckAvailableIDPCGamerNeedUse(int idPCUse, DataController dataController) {
        ArrayList<PersonalComputer> personalComputers = dataController.ReadPCFromFile(pcFileName);
        ArrayList<Gamer> gamers = dataController.ReadGamerFromFile(gamerFilename);
        for (int i = 0; i < personalComputers.size(); i++) {
            if (idPCUse == personalComputers.get(i).getIdPC() && personalComputers.get(i).getStatus().compareToIgnoreCase("Available") == 0) {
                return true;
            }
        }
        return false;
    }

    public static void AddGamer(ArrayList<PersonalComputer> personalComputers, ArrayList<Gamer> gamers, DataController dataController) {
        personalComputers = dataController.ReadPCFromFile(pcFileName);
        gamers = dataController.ReadGamerFromFile(gamerFilename);
        if (AmountPC(personalComputers) == 0) {
            System.out.println("Cyber doesn't have a computer. You need add PC Gaming!");
        } else {
            if (!CheckAmountPC(personalComputers, gamers.size())) {
                System.out.println("Cyber hasn't available PC. See you again!");
            } else {
                System.out.println("Enter information of Gamer: ");
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
                do {
                    System.out.print("\tID PC gamer use: ");
                    idPCUse = scanner.nextInt();
                    if (CheckAvailableIDPCGamerNeedUse(idPCUse, dataController)) {
                        for (int i = 0; i < personalComputers.size(); i++) {
                            while (idPCUse == personalComputers.get(i).getIdPC()) {
                                personalComputers.get(i).setStatus("Using");
                                dataController.UpdatePCFile(personalComputers, pcFileName);
                                break;
                            }
                        }

                    } else {
                        System.out.println("Cyber hasn't PC with this ID. Please wait for the cyber update to add PC.");
                    }
                } while (CheckAvailableIDPCGamerNeedUse(idPCUse, dataController));
                System.out.print("\tAvailable hours: ");
                availableHours = scanner.nextInt();
                System.out.print("\tTime used: ");
                timeUsed = scanner.nextInt();
                Gamer gamer = new Gamer(idGamerAdd, fullName, address, phoneNumber, idPCUse, availableHours, timeUsed);
                dataController.WriteGamerToFile(gamerFilename, gamer);
            }
        }
    }

    public static void AddPersonalComputerGaming(ArrayList<PersonalComputer> personalComputers, DataController dataController) {
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
    }

    public static void UpdateInformationGamer(DataController dataController, String fileName) {
        ArrayList<Gamer> gamers = dataController.ReadGamerFromFile(fileName);
        ArrayList<PersonalComputer> personalComputers = dataController.ReadPCFromFile(pcFileName);
        int idUpdate, checkExistID;
        String regexIDGamer = "^\\d{3,}$";
        do {
            System.out.print("Enter ID Gamer you need update: ");
            idUpdate = scanner.nextInt();
            checkExistID = GetIndexGamer(gamers, idUpdate);
            if (String.valueOf(idUpdate).matches(regexIDGamer)) {
                if (checkExistID != -1) {
                    System.out.println("ID Gamer exist.");
                    int selection, selectionAdvanced, indexIDGamerUpdate;
                    indexIDGamerUpdate = GetIndexGamer(gamers, idUpdate);
                    System.out.println("1. Update all information of Gamer.");
                    System.out.println("2. Update each information  part of Gamer.");
                    System.out.println("3. Back.");
                    System.out.print("Your selection: ");
                    selection = scanner.nextInt();

                    switch (selection) {
                        case 1:
                            System.out.println("Enter information of Gamer: ");
                            String fullName, address;
                            int phoneNumber, idPCUse, availableHours, timeUsed;
                            scanner.nextLine();
                            System.out.print("\tFull name: ");
                            fullName = scanner.nextLine();
                            System.out.print("\tAddress: ");
                            address = scanner.nextLine();
                            System.out.print("\tPhone Number: ");
                            phoneNumber = scanner.nextInt();
                            System.out.print("\tID PC gamer use: ");
                            idPCUse = scanner.nextInt();
                            do {
                                if (CheckAvailableIDPCGamerNeedUse(idPCUse, dataController)) {
                                    int indexIDOld = 0;
                                    for (int i = 0; i < personalComputers.size(); i++) {
                                        if (gamers.get(indexIDGamerUpdate).getIdPCUse() == personalComputers.get(i).getIdPC()) {
                                            indexIDOld = i;
                                        }
                                    }
                                    personalComputers.get(indexIDOld).setStatus("Available");
                                    for (int i = 0; i < personalComputers.size(); i++) {
                                        while (idPCUse == personalComputers.get(i).getIdPC()) {
                                            personalComputers.get(i).setStatus("Using");
                                            break;
                                        }
                                    }
                                } else {
                                    System.out.println("Cyber hasn't PC with this ID. Please wait for the cyber update to add PC.");
                                }
                            } while (CheckAvailableIDPCGamerNeedUse(idPCUse, dataController));

                            System.out.print("\tAvailable hours: ");
                            availableHours = scanner.nextInt();
                            System.out.print("\tTime used: ");
                            timeUsed = scanner.nextInt();
                            Gamer gamer = new Gamer(idUpdate, fullName, address, phoneNumber, idPCUse, availableHours, timeUsed);
                            gamers.set(indexIDGamerUpdate, gamer);
                            dataController.UpdatePCFile(personalComputers, pcFileName);
                            System.out.println("Update successful!");
                            break;
                        case 2:
                            System.out.println("1. Update Full name.");
                            System.out.println("2. Update Address.");
                            System.out.println("3. Update Phone number.");
                            System.out.println("4. Update ID PC use.");
                            System.out.println("5. Update Available hours.");
                            System.out.println("6. Update Time used.");
                            System.out.print("Your advanced selection: ");
                            selectionAdvanced = scanner.nextInt();
                            System.out.println("Enter information you need update: ");
                            switch (selectionAdvanced) {
                                case 1:
                                    System.out.print("\tFull name: ");
                                    scanner.nextLine();
                                    String fullNameUpdate = scanner.nextLine();
                                    gamers.get(indexIDGamerUpdate).setFullName(fullNameUpdate);
                                    System.out.println("Update successful!");
                                    break;
                                case 2:
                                    System.out.print("\tAddress: ");
                                    scanner.nextLine();
                                    String addressUpdate = scanner.nextLine();
                                    gamers.get(indexIDGamerUpdate).setAddress(addressUpdate);
                                    System.out.println("Update successful!");
                                    break;
                                case 3:
                                    System.out.print("\tPhone number: ");
                                    int phoneNumberUpdate = scanner.nextInt();
                                    gamers.get(indexIDGamerUpdate).setPhoneNumber(phoneNumberUpdate);
                                    System.out.println("Update successful!");
                                    break;
                                case 4:
                                    System.out.print("\tID PC use: ");
                                    int idPCUseUpdate = scanner.nextInt();
                                    do {
                                        if (CheckAvailableIDPCGamerNeedUse(idPCUseUpdate, dataController)) {
                                            int indexIDOld02 = 0;
                                            for (int i = 0; i < personalComputers.size(); i++) {
                                                if (gamers.get(indexIDGamerUpdate).getIdPCUse() == personalComputers.get(i).getIdPC()) {
                                                    indexIDOld02 = i;
                                                }
                                            }
                                            personalComputers.get(indexIDOld02).setStatus("Available");
                                            for (int i = 0; i < personalComputers.size(); i++) {
                                                while (idPCUseUpdate == personalComputers.get(i).getIdPC()) {
                                                    personalComputers.get(i).setStatus("Using");
                                                    dataController.UpdatePCFile(personalComputers, pcFileName);
                                                    break;
                                                }
                                            }
                                        } else {
                                            System.out.println("Cyber hasn't PC with this ID. Please wait for the cyber update to add PC.");
                                        }
                                    } while (CheckAvailableIDPCGamerNeedUse(idPCUseUpdate, dataController));
                                    System.out.println("Update successful!");
                                    break;
                                case 5:
                                    System.out.print("\tAvailable hours: ");
                                    int availableHoursUpdate = scanner.nextInt();
                                    gamers.get(indexIDGamerUpdate).setAvailableHours(availableHoursUpdate);
                                    System.out.println("Update successful!");
                                    break;
                                case 6:
                                    System.out.print("\tTime used: ");
                                    int timeUsedUpdate = scanner.nextInt();
                                    gamers.get(indexIDGamerUpdate).setTimeUsed(timeUsedUpdate);
                                    System.out.println("Update successful!");
                                    break;
                            }
                        case 3:
                            break;
                    }
                    dataController.UpdateGamerFile(gamers, fileName);
                    break;
                } else {
                    System.out.println("ID does not exist.");
                    break;
                }
            } else {
                System.out.println("ID Gamer must have 3 numeric characters!");
            }
        } while (true);
    }

    public static void UpdateInformationPCGaming(DataController dataController, String fileName) {
        ArrayList<PersonalComputer> personalComputers = dataController.ReadPCFromFile(fileName);
        int idUpdate, checkExistID;
        String regexIDPC = "^\\d{3,}$";
        do {
            System.out.print("Enter ID PC you need update: ");
            idUpdate = scanner.nextInt();
            checkExistID = GetIndexPC(personalComputers, idUpdate);
            if (String.valueOf(idUpdate).matches(regexIDPC)) {
                if (checkExistID != -1) {
                    System.out.println("ID PC exist.");
                    int selection, selectionAdvanced, indexIDPCUpdate;
                    indexIDPCUpdate = GetIndexPC(personalComputers, idUpdate);
                    System.out.println("1. Update all information of PC.");
                    System.out.println("2. Update each part of PC.");
                    System.out.println("3. Back.");
                    System.out.print("Your selection: ");
                    selection = scanner.nextInt();

                    switch (selection) {
                        case 1:
                            System.out.println();
                            String mainBoard, cpu, vga, keyboard, mouse, headphone, status;
                            int ram, screenSize;
                            System.out.println("Enter information of PC you need update: ");
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
                            PersonalComputer personalComputer = new PersonalComputer(idUpdate, mainBoard, cpu, ram, vga, screenSize, keyboard, mouse, headphone, status);
                            personalComputers.set(indexIDPCUpdate, personalComputer);
                            System.out.println("Update successful!");
                            break;
                        case 2:
                            System.out.println("1. Update Mainboard.");
                            System.out.println("2. Update CPU.");
                            System.out.println("3. Update RAM capacity.");
                            System.out.println("4. Update VGA.");
                            System.out.println("5. Update Screen size.");
                            System.out.println("6. Update Keyboard.");
                            System.out.println("7. Update Mouse.");
                            System.out.println("8. Update Headphone.");
                            System.out.println("9. Update Status.");
                            System.out.print("Your advanced selection: ");
                            selectionAdvanced = scanner.nextInt();
                            System.out.println("Enter information you need update: ");
                            switch (selectionAdvanced) {
                                case 1:
                                    System.out.print("\tMainboard: ");
                                    scanner.nextLine();
                                    String mainboardUpdate = scanner.nextLine();
                                    personalComputers.get(indexIDPCUpdate).setMainboard(mainboardUpdate);
                                    System.out.println("Update successful!");
                                    break;
                                case 2:
                                    System.out.print("\tCPU: ");
                                    scanner.nextLine();
                                    String cpuUpdate = scanner.nextLine();
                                    personalComputers.get(indexIDPCUpdate).setCpu(cpuUpdate);
                                    System.out.println("Update successful!");
                                    break;
                                case 3:
                                    System.out.print("\tRAM capacity: ");
                                    int ramUpdate = scanner.nextInt();
                                    personalComputers.get(indexIDPCUpdate).setRam(ramUpdate);
                                    System.out.println("Update successful!");
                                    break;
                                case 4:
                                    System.out.print("\tVGA: ");
                                    scanner.nextLine();
                                    String vgaUpdate = scanner.nextLine();
                                    personalComputers.get(indexIDPCUpdate).setVga(vgaUpdate);
                                    System.out.println("Update successful!");
                                    break;
                                case 5:
                                    System.out.print("\tScreen size: ");
                                    int screenSizeUpdate = scanner.nextInt();
                                    personalComputers.get(indexIDPCUpdate).setScreenSize(screenSizeUpdate);
                                    System.out.println("Update successful!");
                                    break;
                                case 6:
                                    System.out.print("\tKeyboard: ");
                                    scanner.nextLine();
                                    String keyboardUpdate = scanner.nextLine();
                                    personalComputers.get(indexIDPCUpdate).setKeyboard(keyboardUpdate);
                                    System.out.println("Update successful!");
                                    break;
                                case 7:
                                    System.out.print("\tMouse: ");
                                    scanner.nextLine();
                                    String mouseUpdate = scanner.nextLine();
                                    personalComputers.get(indexIDPCUpdate).setMouse(mouseUpdate);
                                    System.out.println("Update successful!");
                                    break;
                                case 8:
                                    System.out.print("\tHeadphone: ");
                                    scanner.nextLine();
                                    String headphoneUpdate = scanner.nextLine();
                                    personalComputers.get(indexIDPCUpdate).setHeadphone(headphoneUpdate);
                                    System.out.println("Update successful!");
                                    break;
                                case 9:
                                    System.out.print("\tStatus: ");
                                    scanner.nextLine();
                                    String statusUpdate = scanner.nextLine();
                                    personalComputers.get(indexIDPCUpdate).setStatus(statusUpdate);
                                    System.out.println("Update successful!");
                                    break;
                            }
                        case 3:
                            break;
                    }
                    dataController.UpdatePCFile(personalComputers, fileName);
                    break;
                } else {
                    System.out.println("ID does not exist.");
                    break;
                }
            } else {
                System.out.println("ID PC must have 3 numeric characters!");
            }
        } while (true);
    }

    public static void SortListGamers(DataController dataController, String fileName, DataUtility dataUtility) {
        ArrayList<Gamer> gamers = dataController.ReadGamerFromFile(fileName);
        int selection, selectionAdvanced;
        do {
            System.out.println("MENU SORT LIST GAMERS");
            System.out.println("1. Sort by ID Gamer.");
            System.out.println("2. Sort by available hours.");
            System.out.println("3. Sort by time used.");

            System.out.print("Your selection: ");
            selection = scanner.nextInt();

            switch (selection) {
                case 1:
                    System.out.println("ADVANCED SORT");
                    System.out.println("1. Sort by ID Gamer (ascending).");
                    System.out.println("2. Sort by ID Gamer (descending).");
                    System.out.print("Your advanced selection: ");
                    selectionAdvanced = scanner.nextInt();
                    switch (selectionAdvanced) {
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
                    switch (selectionAdvanced) {
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
                    switch (selectionAdvanced) {
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

        } while (selection <= 0 || selection >= 4);
    }

    public static void SortListPCGaming(DataController dataController, String fileName, DataUtility dataUtility) {
        ArrayList<PersonalComputer> personalComputers = dataController.ReadPCFromFile(fileName);
        int selection, selectionAdvanced;
        do {
            System.out.println("MENU SORT LIST PC GAMING");
            System.out.println("1. Sort by ID PC.");
            System.out.println("2. Sort by RAM capacity.");
            System.out.println("3. Sort by Screen size.");

            System.out.print("Your selection: ");
            selection = scanner.nextInt();

            switch (selection) {
                case 1:
                    System.out.println("ADVANCED SORT");
                    System.out.println("1. Sort by ID PC (ascending).");
                    System.out.println("2. Sort by ID PC (descending).");
                    System.out.print("Your advanced selection: ");
                    selectionAdvanced = scanner.nextInt();
                    switch (selectionAdvanced) {
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
                    switch (selectionAdvanced) {
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
                    switch (selectionAdvanced) {
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

        } while (selection <= 0 || selection >= 4);
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
        System.out.println("Cyber has " + count + " Gamer(s) is (are) VIP member.");
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
                                       String pcFileName) {
        personalComputers = dataController.ReadPCFromFile(pcFileName);
        for (int i = 0; i < personalComputers.size(); i++) {
            if (personalComputers.get(i).getStatus().compareToIgnoreCase("Using") == 0) {
                System.out.println(personalComputers.get(i));
            }
        }
    }


    public static void ShowListPCAvailable(DataController dataController, ArrayList<PersonalComputer> personalComputers, String pcFileName) {
        personalComputers = dataController.ReadPCFromFile(pcFileName);
        for (int i = 0; i < personalComputers.size(); i++) {
            if (personalComputers.get(i).getStatus().compareToIgnoreCase("Using") != 0) {
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
        int count = 0;
        for (int i = 0; i < personalComputers.size(); i++) {
            if (personalComputers.get(i).getStatus().compareToIgnoreCase("Available") == 0) {
                count++;
            }
        }
        if (amountGamer >= personalComputers.size() && count == 0) {
            return false;
        }
        return true;
    }

    private static int GetIndexPCUse(ArrayList<PersonalComputer> personalComputers, int pcIDUse) {
        for (int i = 0; i < personalComputers.size(); i++) {
            if (personalComputers.get(i).getIdPC() == pcIDUse) {
                return i;
            }
        }
        return -1;
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
