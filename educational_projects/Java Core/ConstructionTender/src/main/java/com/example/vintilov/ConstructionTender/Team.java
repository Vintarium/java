package com.example.vintilov.ConstructionTender;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String teamName;
    private List<Worker> briagada = new ArrayList<>();

    Team(String teamName) {
        this.teamName = teamName;
    }

    public int getTeamSize() {
        return briagada.size();
    }


    public void addWorker(Worker worker) {
        briagada.add(worker);
    }

    public Worker getWorker(int number) {
        return briagada.get(number);

    }


    public void getTeam() {
        for (int i = 0; i < briagada.size(); i++) {
            briagada.get(i).getWorkerInformation();
        }

    }

    public String getTeamName(){
        return teamName;
    }

    public int getSumOfTeamForWork() {
        int obshaiaSumma = 0;
        for (int j = 0; j < briagada.size(); j++) {
            int summaZaRabotu = briagada.get(j).getPrice();
            obshaiaSumma = obshaiaSumma + summaZaRabotu;
        }
        return obshaiaSumma;

    }


    public List<Specialty> getSkillsOfWorkers() {
        List uniqueSkillsInATeam = new ArrayList<Specialty>();
        for (int i = 0; i < briagada.size(); i++) {
            uniqueSkillsInATeam.add(briagada.get(i).getSkills());
        }
        return uniqueSkillsInATeam;

    }
}
