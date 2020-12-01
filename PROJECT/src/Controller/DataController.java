package Controller;

import Manage.CyberGame;
import Manage.Gamer;
import Manage.PersonalComputer;

import java.io.*;
//import java.io.BufferedWriter;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class DataController {
    private FileWriter fileWriter;
    private BufferedWriter bufferedWriter;
    private PrintWriter printWriter;
    private Scanner scanner;

    public void OpenFileToWrite(String fileName) {
        try {
            fileWriter = new FileWriter(fileName, true);
            bufferedWriter = new BufferedWriter(fileWriter);
            printWriter = new PrintWriter(bufferedWriter);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void CloseFileAfterWrite() {
        try {
            printWriter.close();
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void OpenFileToRead(String fileName) {
        try {
            File file = new File(fileName);
            if (!file.exists()) {
                file.createNewFile();
            }
            scanner = new Scanner(Paths.get(fileName), "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void CloseFileAfterRead() {
        scanner.close();
    }

    public void WritePCToFile(String fileName, PersonalComputer personalComputer) {
        OpenFileToWrite(fileName);
        printWriter.println(personalComputer.getIdPC() + "|" + personalComputer.getMainboard() + "|" + personalComputer.getCpu() + "|" +
                personalComputer.getRam() + "|" + personalComputer.getVga() + "|" + personalComputer.getScreenSize() + "|" +
                personalComputer.getKeyboard() + "|" + personalComputer.getMouse() + "|" + personalComputer.getHeadphone() + "|" +
                personalComputer.getStatus());
        CloseFileAfterWrite();
    }

    public void WriteGamerToFile(String fileName, Gamer gamer) {
        OpenFileToWrite(fileName);
        printWriter.println(gamer.getIdGamer() + "|" + gamer.getFullName() + "|" + gamer.getAddress() + "|" + gamer.getPhoneNumber() + "|" +
                gamer.getIdPCUse() + "|" + gamer.getAvailableHours() + "|" + gamer.getTimeUsed());
        CloseFileAfterWrite();
    }

    public void WriteCyberGameToFile(String fileName, CyberGame cyberGame) {
        OpenFileToWrite(fileName);
        printWriter.println(cyberGame.getPersonalComputer().getIdPC() + "|" + cyberGame.getGamer().getIdGamer() + "|" +
                cyberGame.getAddressCyber() + "|" + cyberGame.getManager());
        CloseFileAfterWrite();
    }

    public ArrayList<PersonalComputer> ReadPCFromFile(String fileName) {
        OpenFileToRead(fileName);
        ArrayList<PersonalComputer> personalComputers = new ArrayList<>();
        while (scanner.hasNext()) {
            String data = scanner.nextLine();
            PersonalComputer personalComputer = CreatePCFromData(data);
            personalComputers.add(personalComputer);
        }
        CloseFileAfterRead();
        return personalComputers;
    }

    private PersonalComputer CreatePCFromData(String data) {
        String datas[] = data.split("\\|");
        PersonalComputer personalComputer = new PersonalComputer(Integer.parseInt(datas[0]), datas[1], datas[2], Integer.parseInt(datas[3]), datas[4],
                Integer.parseInt(datas[5]), datas[6], datas[7], datas[8], datas[9]);
        return personalComputer;
    }

    public ArrayList<Gamer> ReadGamerFromFile(String fileName) {
        OpenFileToRead(fileName);
        ArrayList<Gamer> gamers = new ArrayList<>();
        while (scanner.hasNext()) {
            String data = scanner.nextLine();
            Gamer gamer = CreateGamerFromData(data);
            gamers.add(gamer);
        }
        CloseFileAfterRead();
        return gamers;
    }

    public Gamer CreateGamerFromData(String data) {
        String datas[] = data.split("\\|");
        Gamer gamer = new Gamer(Integer.parseInt(datas[0]), datas[1], datas[2], Integer.parseInt(datas[3]),
                Integer.parseInt(datas[4]), Integer.parseInt(datas[5]), Integer.parseInt(datas[6]));
        return gamer;
    }

    public ArrayList<CyberGame> ReadCyberGameFromFile(String fileName) {
        ArrayList<PersonalComputer> personalComputers = ReadPCFromFile("PCGAMING.DAT");
        ArrayList<Gamer> gamers = ReadGamerFromFile("GAMER.DAT");
        OpenFileToRead(fileName);
        ArrayList<CyberGame> cyberGames = new ArrayList<>();
        while (scanner.hasNext()) {
            String data = scanner.nextLine();
            CyberGame cyberGame = CreateCyberGameFromData(data, personalComputers, gamers);
            cyberGames.add(cyberGame);
        }
        CloseFileAfterRead();
        return cyberGames;
    }

    public CyberGame CreateCyberGameFromData(String data, ArrayList<PersonalComputer> personalComputers, ArrayList<Gamer> gamers) {
        String datas[] = data.split("\\|");
        PersonalComputer personalComputer = getPC(personalComputers, Integer.parseInt(datas[0]));
        Gamer gamer = getGamer(gamers, Integer.parseInt(datas[1]));
        CyberGame cyberGame = new CyberGame(personalComputer, gamer, datas[2], datas[3]);
        return cyberGame;
    }

    private static PersonalComputer getPC(ArrayList<PersonalComputer> personalComputers, int pcID) {
        for (int i = 0; i < personalComputers.size(); i++) {
            if (personalComputers.get(i).getIdPC() == pcID) {
                return personalComputers.get(i);
            }
        }
        return null;
    }

    private static Gamer getGamer(ArrayList<Gamer> gamers, int gamerID) {
        for (int i = 0; i < gamers.size(); i++) {
            if (gamers.get(i).getIdGamer() == gamerID) {
                return gamers.get(i);
            }
        }
        return null;
    }

    public void UpdatePCFile(ArrayList<PersonalComputer> personalComputers, String fileName) {
        File file = new File(fileName);
        if (file.exists()) {
            file.delete();
        }
        OpenFileToWrite(fileName);
        for (PersonalComputer personalComputer : personalComputers) {
            printWriter.println(personalComputer.getIdPC() + "|" + personalComputer.getMainboard() + "|" + personalComputer.getCpu() + "|" +
                    personalComputer.getRam() + "|" + personalComputer.getVga() + "|" + personalComputer.getScreenSize() + "|" +
                    personalComputer.getKeyboard() + "|" + personalComputer.getMouse() + "|" + personalComputer.getHeadphone() + "|" +
                    personalComputer.getStatus());
        }
        CloseFileAfterWrite();
    }

    public void UpdateGamerFile(ArrayList<Gamer> gamers, String fileName) {
        File file = new File(fileName);
        if (file.exists()) {
            file.delete();
        }
        OpenFileToWrite(fileName);
        for (Gamer gamer : gamers) {
            printWriter.println(gamer.getIdGamer() + "|" + gamer.getFullName() + "|" + gamer.getAddress() + "|" + gamer.getPhoneNumber() + "|" +
                    gamer.getIdPCUse() + "|" + gamer.getAvailableHours() + "|" + gamer.getTimeUsed());
        }
        CloseFileAfterWrite();
    }

    public void UpdateCyberGameFile(ArrayList<CyberGame> cyberGames, String fileName) {
        File file = new File(fileName);
        if (file.exists()) {
            file.delete();
        }
        OpenFileToWrite(fileName);
        for (CyberGame cyberGame : cyberGames) {
            printWriter.println(cyberGame.getPersonalComputer().getIdPC() + "|" + cyberGame.getGamer().getIdGamer() + "|" +
                    cyberGame.getAddressCyber() + "|" + cyberGame.getManager());
        }
        CloseFileAfterWrite();
    }
}
