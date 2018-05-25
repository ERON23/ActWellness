package com.example.eronmac.actwellness;

/**
 * Created by zaira on 4/19/2017.
 */

public class Excercises {
    private int id;
    private String name;
    private String reps;
    private String sets;

    public Excercises(int id, String name, String reps, String sets) {
        this.id = id;
        this.name = name;
        this.reps = reps;
        this.sets = sets;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReps() {
        return reps;
    }

    public void setReps(String reps) {
        this.reps = reps;
    }

    public String getSets() {
        return sets;
    }

    public void setSets(String sets) {
        this.sets = sets;
    }
}
