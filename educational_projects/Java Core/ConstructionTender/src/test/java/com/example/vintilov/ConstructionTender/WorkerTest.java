package com.example.vintilov.ConstructionTender;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class WorkerTest {

    @org.junit.Test
    public void getNumberOfSkills() {
        /*Given*/
        Worker worker = new Worker();
        worker.addSpesialty(Specialty.СВАРЩИК);
        worker.addSpesialty(Specialty.ВЫСОТНИК);
        worker.addSpesialty(Specialty.ПЛИТОЧНИК);
        int expected = 3;
        /*When*/
        int actual = worker.getNumberOfSkills();
        /*Then*/
        Assert.assertEquals(expected,actual);

    }

    @org.junit.Test
    public void getWorkerInformation() {
        /*Given*/
        Worker workerOne = new Worker("Vasiliu",1000);
        workerOne.addSpesialty(Specialty.СВАРЩИК);
        workerOne.addSpesialty(Specialty.ВЫСОТНИК);

        String expected = "Я Vasiliu.Я имею 2 специально(стей)сти. " +
                "Я готов работать за такую зарплату: 1000";
        /*When*/
        String actual = workerOne.getWorkerInformation();
        /*Then*/
        Assert.assertEquals(expected,actual);
    }


    @org.junit.Test
    public void getPrice() {
        /*Given*/
        Worker workerThree = new Worker("Vasiliu",1000);
        int expected = 1000;
        /*When*/
        int actual = workerThree.getPrice();
        /*Then*/
        Assert.assertEquals(expected,actual);
    }

    @org.junit.Test
    public void getSkills() {
        /*Given*/
        Worker workerFour = new Worker("Vasiliu",1000);
        workerFour.addSpesialty(Specialty.ПЛИТОЧНИК);
        workerFour.addSpesialty(Specialty.ВЫСОТНИК);

        List expected = new ArrayList<>();
        expected.add(Specialty.ПЛИТОЧНИК);
        expected.add(Specialty.ВЫСОТНИК);
        /*When*/
        List actual = workerFour.getSkills();
        /*Then*/
        Assert.assertEquals(expected,actual);
    }
}