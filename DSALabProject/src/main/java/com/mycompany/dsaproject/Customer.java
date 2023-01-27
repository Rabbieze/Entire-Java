
package com.mycompany.dsaproject;


public class Customer {
    private String name;
    private int age;
    private char gender;
    private int order_no;

    public void set_Order_no(int i){
        this.order_no=i;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGender(char gender) throws Exception{
        if(gender=='m' || gender=='M' || gender=='f'|| gender=='F')
        {
            this.gender = gender;
        }
        else
        {
            throw new Exception("\nWRONG INPUT|\n");
        }
    }

    public int getOrder_no() {
        return this.order_no;
    }

    public String getName() {
        this.name=this.name.toLowerCase();
        this.name=this.name.substring(0,1).toUpperCase()+this.name.substring(1);
        return this.name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        if(this.gender=='m'|| this.gender=='M') {
            return "Male";
        }
        else if(this.gender=='f'|| this.gender=='F')
        {
            return "Female";
        }
        return null;
    }

    public String toString(){
       return ("Name: ")+(this.getName())+("\n")+("Age: ")+(this.getAge())+("\n")+("Gender: ")+(this.getGender())+("\n")+("Order Number: ")+(this.getOrder_no())+("\n");
    }
}
