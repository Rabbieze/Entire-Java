package com.mycompany.dsaproject;

public class Meals implements Food {
    private final double c_burger, b_burger, pasta, chipotle, b_chilli, c_chilli;

    private Meals()
    {
        c_burger=200;
        b_burger=250;
        pasta=230;
        chipotle=300;
        b_chilli=800;
        c_chilli=700;
    }
    private static Meals m =new Meals();

    public static Meals getobj(){
        return m;
    }


    public double one() {
        return c_burger;
    }

    public double two() {
        return b_burger;
    }

    public double three() {
        return pasta;
    }

    public double four() {
        return chipotle;
    }

    public double five() {
        return b_chilli;
    }

    public double six() {
        return c_chilli;
    }
}
