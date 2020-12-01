package ManageInformation;

import Controller.DataController;
import Controller.DataUtility;
import Manage.Gamer;
import Manage.PersonalComputer;

import java.util.ArrayList;
import java.util.Scanner;

public class RunMain {
    public static void main(String[] args) {
        String pcFileName = "PCGAMING.DAT";
        String gamerFilename = "GAMER.DAT";

        DataController dataController = new DataController();
        DataUtility dataUtility = new DataUtility();

        ArrayList<PersonalComputer> personalComputers;
        ArrayList<Gamer> gamers;

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

            switch (selection){
                case 13:
                    break;
                case 1:
                    personalComputers = dataController.ReadPCFromFile(pcFileName);
                    String mainBoard, cpu, vga, keyboard, mouse, headphone, status;
                    String regexPCID = "^\\d{3,}$";
                    int idPCAdd, ram, screenSize, checkExistsPC;


            }
        } while (true);



    }
}
