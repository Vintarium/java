package com.example.vintilov.ConstructionTender;

import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class TenderTest {


    @Test
    public void getRequiredSpecialties() {
        /*Given*/
        Tender tender = new Tender("one",1000);
        tender.addRequiredSpecialists(Specialty.КАМЕНЩИК);
        List<Specialty> exected = Collections.singletonList(Specialty.КАМЕНЩИК);
        /*When*/
        List<Specialty> actual = tender.getRequiredSpecialties();
        /*Then*/
        Assert.assertEquals(exected,actual);
    }

    @Test
    public void getMoneyForWork() {
        /*Given*/
        Tender tender = new Tender("tenderOne",1000);
        int expected = 1000;
        /*When*/
        int actual = tender.getMoneyForWork();
        /*Then*/
        Assert.assertEquals(expected,actual);
    }
}