package com.example.vintilov.ConstructionTender;

import java.util.ArrayList;
import java.util.List;

public class Worker {
    private String fullName;
    private int price;
    private List<Specialty> skills = new ArrayList<>();


    Worker(String fullName, int priceForTheWorkOfAParticularEmployee) {
        this.fullName = fullName;
        this.price = priceForTheWorkOfAParticularEmployee;
    }

    Worker() {
    }

    public int getNumberOfSkills() {
        return skills.size();
    }


    public String getWorkerInformation() {
        return "Я " + fullName + "." + "Я имею " + skills.size() + " специально(стей)сти. " +
                "Я готов работать за такую зарплату: " + price;
    }

    public void addSpesialty(Specialty spec) {
        skills.add(spec);
    }


    public int getPrice() {
        return this.price;
    }

    public List<Specialty> getSkills() {
        List<Specialty> list = new ArrayList<>();
        for (int i = 0; i < skills.size(); i++) {
            list.add(skills.get(i));
        }
        return list;
    }


}
