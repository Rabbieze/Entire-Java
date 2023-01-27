package com.mycompany.dsaproject;

public class Drinks implements Food {
    private final double tea, coffee, sev_up, pepsi, coke, cocktail;

    private Drinks()
    {
        tea=30;
        coffee=40;
        sev_up=35;
        pepsi=35;
        coke=35;
        cocktail=130;
    }

    private static Drinks d;

    public static Drinks getobj(){
        if(d==null)
            d=new Drinks();
        return d;
    }

    public double one() {
        return tea;
    }

    public double two() {
        return coffee;
    }

    public double three() {
        return sev_up;
    }

    public double four() {
        return pepsi;
    }

    public double five() {
        return coke;
    }

    public double six() {
        return cocktail;
    }
}
