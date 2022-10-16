package com.example.vintilov.ConstructionTender;

import java.util.ArrayList;
import java.util.List;

public class ReviewCommission {
    private Team team;
    private Tender tender;

    ReviewCommission(Tender tender, Team team) {
        this.team = team;
        this.tender = tender;
    }

    public List<Specialty> getSkillsTeam() {
        ArrayList<Specialty> allTeamSkills = new ArrayList<>();

        for (int i = 0; i < team.getTeamSize(); i++) {
            for (int j = 0; j < team.getWorker(i).getNumberOfSkills(); j++) {
                allTeamSkills.add(team.getWorker(i).getSkills().get(j));
            }
        }
        return allTeamSkills;
    }


    public boolean complianceCheck(List<Specialty> list) {

        List<Specialty> requestTenderSpecialty = tender.getRequiredSpecialties(); // массив запроса

        List allSkillsInOneList = new ArrayList<Specialty>();
        boolean nextStepComission = false;
        int count = 1;
        for (int i = 0; i < requestTenderSpecialty.size() - 1; i++) {
            allSkillsInOneList.add(i, list.get(i));

            for (int j = 0; j < requestTenderSpecialty.size() - 1; j++) {
                if (allSkillsInOneList.get(i) == list.get(j)) {
                    count++;
                    list.set(j, null);
                }
            }
        }
        if (count == requestTenderSpecialty.size()) {
            nextStepComission = true;
        } else {

            System.out.println(team.getTeamName() + " - в команде не хвататет работников.Следующую команду давайте!\n");
            nextStepComission = false;
        }
        if (nextStepComission) {
            if (tender.getMoneyForWork() >= team.getSumOfTeamForWork()) {
                System.out.println("Исполнитель найден!Это - " + team.getTeamName() + ". Тендер окончен!Ура!\n");
            } else {
                System.out.println("Недосаточно средств для начала работ c этой командой: " + team.getTeamName() +
                        ". Исполнитель не найден.\n");
                nextStepComission = false;
            }
        }
        return nextStepComission;
    }
}







