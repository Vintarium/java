package com.example.vintilov.ConstructionTender;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ReviewCommissionTest {

    @Test
    public void getSkillsTeam() {
        /*Given*/
        Team team = new Team("team");
        Worker workerOne = new Worker();
        workerOne.addSpesialty(Specialty.СВАРЩИК);
        Worker workerTwo = new Worker();
        workerOne.addSpesialty(Specialty.ПЛИТОЧНИК);
        team.addWorker(workerOne);
        team.addWorker(workerTwo);
        Tender tender = new Tender("tender",1000);
        tender.addRequiredSpecialists(Specialty.СВАРЩИК);
        tender.addRequiredSpecialists(Specialty.ПЛИТОЧНИК);
        ReviewCommission reviewCommission = new ReviewCommission(tender,team);
        List<Specialty> expected = new ArrayList<>();
        expected.add(Specialty.СВАРЩИК);
        expected.add(Specialty.ПЛИТОЧНИК);
        /*When*/
        List<Specialty> actual = reviewCommission.getSkillsTeam();
        /*Then*/
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void complianceCheck() {
        /*Given*/
        Team team = new Team("team");
        Worker workerOne = new Worker();
        workerOne.addSpesialty(Specialty.СВАРЩИК);
        Worker workerTwo = new Worker();
        workerOne.addSpesialty(Specialty.ПЛИТОЧНИК);
        team.addWorker(workerOne);
        team.addWorker(workerTwo);
        Tender tender = new Tender("tender",1000);
        tender.addRequiredSpecialists(Specialty.СВАРЩИК);
        tender.addRequiredSpecialists(Specialty.ПЛИТОЧНИК);
        ReviewCommission reviewCommission = new ReviewCommission(tender,team);
        List<Specialty> list = new ArrayList<>();
        list.add(Specialty.СВАРЩИК);
        list.add(Specialty.ПЛИТОЧНИК);
        boolean expected = true;
        /*When*/
        boolean actual = reviewCommission.complianceCheck(reviewCommission.getSkillsTeam());
        /*Then*/
        Assert.assertEquals(expected,actual);
    }
}