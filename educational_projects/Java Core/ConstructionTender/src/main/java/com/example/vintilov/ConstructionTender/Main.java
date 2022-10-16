package com.example.vintilov.ConstructionTender;

public class Main {
    public static void main(String[] args) {

        Worker workerZero = new Worker("Вольдемар Вольфрамович", 3000);
        workerZero.addSpesialty(Specialty.ПРОРАБ);
        workerZero.addSpesialty(Specialty.СВАРЩИК);

        Worker workerOne = new Worker("Василий Пуговкин", 1000);
        workerOne.addSpesialty(Specialty.КАМЕНЩИК);
        workerOne.addSpesialty(Specialty.ОБЛИЦОВЩИК);

        Worker workerTwo = new Worker("Геннадий Шапочкин", 1300);
        workerTwo.addSpesialty(Specialty.ПЛИТОЧНИК);
        workerTwo.addSpesialty(Specialty.ВЫСОТНИК);

        Worker workerThree = new Worker("Эдуард носочкин", 800);
        workerThree.addSpesialty(Specialty.ЭЛЕКТРИК);

        Worker workerFour = new Worker("Федул Башмачников",950);
        workerFour.addSpesialty(Specialty.САНТЕХНИК);
        workerFour.addSpesialty(Specialty.УБОРЩИК);

        Worker workerFive = new Worker("Карабас Барабас",5000);
        workerFive.addSpesialty(Specialty.ДЕПУТАТ);
        workerFive.addSpesialty(Specialty.ПРОРАБ);

        Worker workerSix = new Worker("Мирон Евсеевич",2500);
        workerFive.addSpesialty(Specialty.ВЫСОТНИК);
        workerFive.addSpesialty(Specialty.ПРОРАБ);
        workerFive.addSpesialty(Specialty.СВАРЩИК);



        Team teamThree = new Team("MogilevOblStroi");
        teamThree.addWorker(workerZero);
        teamThree.addWorker(workerOne);
        teamThree.addWorker(workerTwo);
        teamThree.addWorker(workerThree);

        Team teamTwo = new Team("MinskPromStroi");
        teamTwo.addWorker(workerZero);
        teamTwo.addWorker(workerOne);
        teamTwo.addWorker(workerTwo);
        teamTwo.addWorker(workerThree);
        teamTwo.addWorker(workerFour);
        teamTwo.addWorker(workerOne);
        teamTwo.addWorker(workerTwo);
        teamTwo.addWorker(workerSix);


        Team teamOne = new Team("BelPromStroi");
        teamOne.addWorker(workerZero);
        teamOne.addWorker(workerFive);
        teamOne.addWorker(workerThree);
        teamOne.addWorker(workerFour);
        teamOne.addWorker(workerOne);
        teamOne.addWorker(workerTwo);
        teamOne.addWorker(workerSix);



        Tender tenderOne = new Tender("Библиотека", 8000);
        tenderOne.addRequiredSpecialists(Specialty.КАМЕНЩИК);
        tenderOne.addRequiredSpecialists(Specialty.ОБЛИЦОВЩИК);
        tenderOne.addRequiredSpecialists(Specialty.САНТЕХНИК);
        tenderOne.addRequiredSpecialists(Specialty.ПЛИТОЧНИК);
        tenderOne.addRequiredSpecialists(Specialty.СВАРЩИК);
        tenderOne.addRequiredSpecialists(Specialty.ЭЛЕКТРИК);
        tenderOne.addRequiredSpecialists(Specialty.ПРОРАБ);


        ReviewCommission commissionForBibliotekaOne = new ReviewCommission(tenderOne, teamOne);
        commissionForBibliotekaOne.complianceCheck(commissionForBibliotekaOne.getSkillsTeam());


        ReviewCommission commissionForBibliotekaTwo = new ReviewCommission(tenderOne, teamTwo);
        commissionForBibliotekaTwo.complianceCheck(commissionForBibliotekaTwo.getSkillsTeam());


        ReviewCommission commissionForBibliotekaThree = new ReviewCommission(tenderOne, teamThree);
        commissionForBibliotekaThree.complianceCheck(commissionForBibliotekaThree.getSkillsTeam());



    }


}
