package Controller;

import Manage.Gamer;
import Manage.PersonalComputer;

import java.util.ArrayList;

public class DataUtility {

    //sort list PC by ID (ascending)
    public void SortListPCByIDAscending(ArrayList<PersonalComputer> personalComputers) {
        for (int i = 0; i < personalComputers.size() - 1; i++) {
            for (int j = i + 1; j < personalComputers.size(); j++) {
                if (personalComputers.get(i).getIdPC() > personalComputers.get(j).getIdPC()) {
                    PersonalComputer temp = personalComputers.get(i);
                    personalComputers.set(i, personalComputers.get(j));
                    personalComputers.set(j, temp);
                }
            }
        }
        System.out.println("Sort list PC by ID (ascending) successful!");
    }

    //sort list PC by ID (descending)
    public void SortListPCByIDDescending(ArrayList<PersonalComputer> personalComputers) {
        for (int i = 0; i < personalComputers.size() - 1; i++) {
            for (int j = i + 1; j < personalComputers.size(); j++) {
                if (personalComputers.get(i).getIdPC() < personalComputers.get(j).getIdPC()) {
                    PersonalComputer temp = personalComputers.get(i);
                    personalComputers.set(i, personalComputers.get(j));
                    personalComputers.set(j, temp);
                }
            }
        }
        System.out.println("Sort list PC by ID (descending) successful!");
    }

    //sort list PC by RAM capacity (ascending)
    public void SortListPCByRAMCapacityAscending(ArrayList<PersonalComputer> personalComputers) {
        for (int i = 0; i < personalComputers.size() - 1; i++) {
            for (int j = i + 1; j < personalComputers.size(); j++) {
                if (personalComputers.get(i).getRam() > personalComputers.get(j).getRam()) {
                    PersonalComputer temp = personalComputers.get(i);
                    personalComputers.set(i, personalComputers.get(j));
                    personalComputers.set(j, temp);
                }
            }
        }
        System.out.println("Sort list PC by RAM capacity (ascending) successful!");
    }

    //sort list PC by RAM capacity (descending)
    public void SortListPCByRAMCapacityDescending(ArrayList<PersonalComputer> personalComputers) {
        for (int i = 0; i < personalComputers.size() - 1; i++) {
            for (int j = i + 1; j < personalComputers.size(); j++) {
                if (personalComputers.get(i).getRam() < personalComputers.get(j).getRam()) {
                    PersonalComputer temp = personalComputers.get(i);
                    personalComputers.set(i, personalComputers.get(j));
                    personalComputers.set(j, temp);
                }
            }
        }
        System.out.println("Sort list PC by RAM capacity (descending) successful!");
    }

    //sort list PC by Screen size (ascending)
    public void SortListPCByScreenSizeAscending(ArrayList<PersonalComputer> personalComputers) {
        for (int i = 0; i < personalComputers.size() - 1; i++) {
            for (int j = i + 1; j < personalComputers.size(); j++) {
                if (personalComputers.get(i).getScreenSize() > personalComputers.get(j).getScreenSize()) {
                    PersonalComputer temp = personalComputers.get(i);
                    personalComputers.set(i, personalComputers.get(j));
                    personalComputers.set(j, temp);
                }
            }
        }
        System.out.println("Sort list PC by Screen size (ascending) successful!");
    }

    //sort list PC by Screen size (descending)
    public void SortListPCByScreenSizeDescending(ArrayList<PersonalComputer> personalComputers) {
        for (int i = 0; i < personalComputers.size() - 1; i++) {
            for (int j = i + 1; j < personalComputers.size(); j++) {
                if (personalComputers.get(i).getScreenSize() < personalComputers.get(j).getScreenSize()) {
                    PersonalComputer temp = personalComputers.get(i);
                    personalComputers.set(i, personalComputers.get(j));
                    personalComputers.set(j, temp);
                }
            }
        }
        System.out.println("Sort list PC by Screen size (descending) successful!");
    }

    //sort list Gamer by ID gamer (ascending)
    public void SortListGamerByIDAscending(ArrayList<Gamer> gamers) {
        for (int i = 0; i < gamers.size() - 1; i++) {
            for (int j = i + 1; j < gamers.size(); j++) {
                if (gamers.get(i).getIdGamer() > gamers.get(j).getIdGamer()) {
                    Gamer temp = gamers.get(i);
                    gamers.set(i, gamers.get(j));
                    gamers.set(j, temp);
                }
            }
        }
        System.out.println("Sort list Gamer by ID (ascending) successful!");
    }

    //sort list Gamer by ID gamer (descending)
    public void SortListGamerByIDDescending(ArrayList<Gamer> gamers) {
        for (int i = 0; i < gamers.size() - 1; i++) {
            for (int j = i + 1; j < gamers.size(); j++) {
                if (gamers.get(i).getIdGamer() < gamers.get(j).getIdGamer()) {
                    Gamer temp = gamers.get(i);
                    gamers.set(i, gamers.get(j));
                    gamers.set(j, temp);
                }
            }
        }
        System.out.println("Sort list Gamer by ID (descending) successful!");
    }

    //sort list Gamer by available hours (ascending)
    public void SortListGamerByAvailableHoursAscending(ArrayList<Gamer> gamers) {
        for (int i = 0; i < gamers.size() - 1; i++) {
            for (int j = i + 1; j < gamers.size(); j++) {
                if (gamers.get(i).getAvailableHours() > gamers.get(j).getAvailableHours()) {
                    Gamer temp = gamers.get(i);
                    gamers.set(i, gamers.get(j));
                    gamers.set(j, temp);
                }
            }
        }
        System.out.println("Sort list Gamer by available hours (ascending) successful!");
    }

    //sort list Gamer by available hours (descending)
    public void SortListGamerByAvailableHoursDescending(ArrayList<Gamer> gamers) {
        for (int i = 0; i < gamers.size() - 1; i++) {
            for (int j = i + 1; j < gamers.size(); j++) {
                if (gamers.get(i).getAvailableHours() < gamers.get(j).getAvailableHours()) {
                    Gamer temp = gamers.get(i);
                    gamers.set(i, gamers.get(j));
                    gamers.set(j, temp);
                }
            }
        }
        System.out.println("Sort list Gamer by available hours (descending) successful!");
    }

    //sort list Gamer by time used (ascending)
    public void SortListGamerByTimeUsedAscending(ArrayList<Gamer> gamers) {
        for (int i = 0; i < gamers.size() - 1; i++) {
            for (int j = i + 1; j < gamers.size(); j++) {
                if (gamers.get(i).getTimeUsed() > gamers.get(j).getTimeUsed()) {
                    Gamer temp = gamers.get(i);
                    gamers.set(i, gamers.get(j));
                    gamers.set(j, temp);
                }
            }
        }
        System.out.println("Sort list Gamer by time used (ascending) successful!");
    }

    //sort list Gamer by time used (descending)
    public void SortListGamerByTimeUseddescending(ArrayList<Gamer> gamers) {
        for (int i = 0; i < gamers.size() - 1; i++) {
            for (int j = i + 1; j < gamers.size(); j++) {
                if (gamers.get(i).getTimeUsed() < gamers.get(j).getTimeUsed()) {
                    Gamer temp = gamers.get(i);
                    gamers.set(i, gamers.get(j));
                    gamers.set(j, temp);
                }
            }
        }
        System.out.println("Sort list Gamer by time used (descending) successful!");
    }
}
