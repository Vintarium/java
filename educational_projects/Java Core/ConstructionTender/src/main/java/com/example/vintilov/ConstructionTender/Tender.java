package com.example.vintilov.ConstructionTender;

import java.util.ArrayList;
import java.util.List;

public class Tender {
    private String nameTender;
    private int totalAmountOfTheOrder;
    private List<Specialty> specialties = new ArrayList<>();


    public Tender(String nameTender, int totalAmountOfTheOrder) {
        this.nameTender = nameTender;
        this.totalAmountOfTheOrder = totalAmountOfTheOrder;
    }

    public void addRequiredSpecialists(Specialty specialty) {
        specialties.add(specialty);
    }


    public List<Specialty> getRequiredSpecialties() {
        ArrayList<Specialty> list = new ArrayList<>();
        for (int i = 0; i < specialties.size(); i++) {
            list.add(specialties.get(i));
        }
        return list;

    }

    public int getMoneyForWork() {
        return totalAmountOfTheOrder;
    }

}
