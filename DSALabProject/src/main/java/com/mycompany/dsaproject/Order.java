
package com.mycompany.dsaproject;

public class Order {
    //CONSTRUCTOR
    private Order(){}
//static class obj
    private static Order o;

    //static Order method
    public static Order getInstance(){
        if(o==null)
            o=new Order();
        return o;
    }

    private double total=0;

    public void calc(double i){
        this.total=this.total+ i;
    }

    public String get_discount(){
        String s="\n\nNo discount";
        if((this.total)>=2000 && (this.total)<2500)
        {
            this.total=(this.total)-150;
            s= ("\n\nDiscount\t\t\tRs. -150.0");
        }
        else if(this.total>=2500)
        {
            this.total=(this.total)-300;
            s= ("\n\nDiscount\t\t\tRs. -300.0");
        }
        return s;
    }
    public String get_discount(int k){
        String s="\nNo complementary item";
        if((this.getTotal()) >= k)
        {
            s=("\n1 Complementary Cocktail\tRs. 0.0");
        }
        return s;
    }

    public double getTotal() {
        return this.total;
    }

    public void reset(){
        this.total=0;
    }
}
