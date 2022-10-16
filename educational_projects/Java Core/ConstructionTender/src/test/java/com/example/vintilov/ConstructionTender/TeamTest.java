package com.example.vintilov.ConstructionTender;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TeamTest {

    @Test
    public void getTeamSize() {
        /*Given*/
        Team team = new Team("popularTeam");
        Worker worker = new Worker();
        team.addWorker(worker);
        int expected = 1;
        /*When*/
        int actual = team.getTeamSize();
        /*Then*/
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getWorker() {
        /*Given*/
        Team teamOne = new Team("Team");
        Worker one = new Worker();
        Worker two = new Worker();
        teamOne.addWorker(one);
        teamOne.addWorker(two);
        String expected = two.getWorkerInformation();
        /*When*/
        String actual = teamOne.getWorker(1).getWorkerInformation();
        /*Then*/
       Assert.assertEquals(expected,actual);
    }

    @Test
    public void getTeamName() {
        /*Given*/
        Team teamOne = new Team("PerfectTeam");
        String expected = "PerfectTeam";
        /*When*/
        String actual = teamOne.getTeamName();
        /*Then*/
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getSumOfTeamForWork() {
        /*Given*/
        Team teamOne = new Team("PerfectTeam");
        Worker one = new Worker("Vasiliu",1000);
        Worker two = new Worker("Oleg",2000);
        Worker three = new Worker("Sasha",3000);
        teamOne.addWorker(one);
        teamOne.addWorker(two);
        teamOne.addWorker(three);
        int expected = 6000;
        /*When*/
        int actual = teamOne.getSumOfTeamForWork();
        /*Then*/
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getSkillsOfWorkers() {
        /*Given*/
        Team teamOne = new Team("PerfectTeam");
        Worker one = new Worker();
        one.addSpesialty(Specialty.ВЫСОТНИК);
        Worker two = new Worker();
        two.addSpesialty(Specialty.ПЛИТОЧНИК);
        Worker three = new Worker();
        three.addSpesialty(Specialty.СВАРЩИК);
        teamOne.addWorker(one);
        teamOne.addWorker(two);
        teamOne.addWorker(three);

        List<List<Specialty>> expected = new ArrayList<>();
        expected.add(Collections.singletonList(one.getSkills().get(0)));
        expected.add(Collections.singletonList(two.getSkills().get(0)));
        expected.add(Collections.singletonList(three.getSkills().get(0)));
        /*When*/
        List<Specialty> actual = teamOne.getSkillsOfWorkers();
        /*Then*/
        Assert.assertEquals(expected,actual);
    }
}