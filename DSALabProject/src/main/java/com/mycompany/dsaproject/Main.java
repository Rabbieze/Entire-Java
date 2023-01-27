package com.mycompany.dsaproject;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

//Username: 'counter1'
//Password: 'netbeans'

public class Main {

    
    public static void main(String[] args) {
        System.out.println("\nRestaurant Counter Management System");

        
        int w = 0, x = 1, z, y = 1, i = 0, age;
        int c_b = 0, b_b = 0, pas = 0, chp = 0, b_c = 0, c_c = 0;
        int t = 0, cf = 0, p = 0, cc = 0, up = 0, ct = 0;
        String[] output = new String[30];
        char gender;
        String name=null; 

        Scanner sc = new Scanner(System.in);

        Login login = new Login();
        login.permit();

        OrderQueue orderNo = new OrderQueue();

        Food food;
        Order order = Order.getInstance();

        
        Customer[] c = new Customer[8];
        while (w != 3) {
            System.out.println("\n\n1. Add new order");
            System.out.println("2. Display order next in line");
            System.out.println("3. Exit from program");
            System.out.print("Choice: ");
            try{
            w = sc.nextInt();
            }
            catch(InputMismatchException e){
                
            }
            sc.nextLine();

            if (w == 1) {
                z = 0;
                c[i] = new Customer();

                System.out.print("\nEnter customer's name: ");
                try {
                name = sc.nextLine();
                }catch(Exception e){
                    System.out.println("\nWrong type of input\n");
                }
                c[i].setName(name);
              

                System.out.print("Enter customer's age: ");
                try {
                    age = sc.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("\nWrong type of input\n");
                    age = 0;
                }
                c[i].setAge(age);
                sc.nextLine();

                System.out.print("Enter customer's gender: ");
                gender = sc.next().charAt(0);
                try {
                    c[i].setGender(gender);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }

                while (z != 3) {
                    System.out.println("\n1. Meals");
                    System.out.println("2. Drinks");
                    System.out.println("3. Print Receipt");
                    System.out.print("\nChoose category: ");
                    try{
                    z = sc.nextInt();}
                    catch(InputMismatchException e){
                
            }
                    sc.nextLine();
                    

                    switch (z) {
                        case 1:
                            while (y != 0) {
                                food = Meals.getobj();
                                System.out.println("\n1. Chicken Burger\t\tRs.200");
                                System.out.println("2. Beef Burger\t\t\tRs.250");
                                System.out.println("3. Pasta\t\t\tRs.230");
                                System.out.println("4. Chipotle\t\t\tRs.300");
                                System.out.println("5. Beef Chilli\t\t\tRs.800");
                                System.out.println("6. Chicken Chilli\t\tRs.700");
                                System.out.println("0. Finalize meals");
                                System.out.print("\nChoice: ");
                                try{
                                y = sc.nextInt();}
                                catch(InputMismatchException e){
                                }
                                sc.nextLine();
                                switch (y) {
                                    case 1:
                                        c_b++;
                                        order.calc(food.one());
                                        System.out.println("Chicken Burger added to the order!");
                                        break;
                                    case 2:
                                        b_b++;
                                        order.calc(food.two());
                                        System.out.println("Beef Burger added to the order!");
                                        break;
                                    case 3:
                                        pas++;
                                        order.calc(food.three());
                                        System.out.println("Pasta added to the order!");
                                        break;
                                    case 4:
                                        chp++;
                                        order.calc(food.four());
                                        System.out.println("Chipotle added to the order!");
                                        break;
                                    case 5:
                                        b_c++;
                                        order.calc(food.five());
                                        System.out.println("Beef Chilli added to the order!");
                                        break;
                                    case 6:
                                        c_c++;
                                        order.calc(food.six());
                                        System.out.println("Chicken Chilli added to the order!");
                                        break;
                                    case 0:
                                        break;

                                    default:
                                        System.out.println("\nWRONG INPUT!");
                                }
                            }
                            y = 1;
                            break;
                        case 2:
                            while (x != 0) {
                                food = Drinks.getobj();
                                System.out.println("\n1. Tea\t\t\t\tRs.30");
                                System.out.println("2. Coffee\t\t\tRs.40");
                                System.out.println("3. 7up\t\t\t\tRs.35");
                                System.out.println("4. Pepsi\t\t\tRs.35");
                                System.out.println("5. Coca Cola\t\t\tRs.35");
                                System.out.println("6. Cocktail\t\t\tRs.130");
                                System.out.println("0. Finalize drinks");
                                System.out.print("\nChoice: ");
                                try{
                                x = sc.nextInt();}
                                catch(InputMismatchException e){
                                 }
                                sc.nextLine();
                                switch (x) {
                                    case 1:
                                        t++;
                                        order.calc(food.one());
                                        System.out.println("Tea added to the order!");
                                        break;
                                    case 2:
                                        cf++;
                                        order.calc(food.two());
                                        System.out.println("Coffee added to the order!");
                                        break;
                                    case 3:
                                        up++;
                                        order.calc(food.three());
                                        System.out.println("7up added to the order!");
                                        break;
                                    case 4:
                                        p++;
                                        order.calc(food.four());
                                        System.out.println("Pepsi added to the order!");
                                        break;
                                    case 5:
                                        cc++;
                                        order.calc(food.five());
                                        System.out.println("Coca Cola added to the order!");
                                        break;
                                    case 6:
                                        ct++;
                                        order.calc(food.six());
                                        System.out.println("Cocktail added to the order!");
                                        break;
                                    case 0:
                                        break;

                                    default:
                                        System.out.println("\nWRONG INPUT!");
                                }
                            }
                            x = 1;
                            break;
                        case 3:
                            if (order.getTotal() != 0) {
                                c[i].gen_Order_no(i);
                                orderNo.enqueue(i);
                            }
                            else
                                c[i].gen_Order_no(-1);
                            

                            System.out.println("\n\t\t\t===========RECEIPT===========");
                            
                            System.out.println(c[i].toString());
                           int index =0;
                            output[index++] = "===========RECEIPT===========";
                            output[index++] = c[i].toString();
                            if (c_b > 0 || b_b > 0 || pas > 0 || chp > 0 || b_c > 0 || c_c > 0) {

                                food = Meals.getobj();
                                if (c_b > 0) {
                                    System.out.print("\n"+c_b + " Chicken Burger\t\tRs. " + c_b * food.one());
                                    
                                 output[index++] = "\n"+c_b + " Chicken Burger\t\tRs. " + c_b * food.one();
                                }
                                if (b_b > 0) {
                                    System.out.print("\n"+b_b + " Beef Burger\t\t\tRs. " + b_b * food.two());
                                    output[index++] = "\n"+b_b + " Beef Burger\t\t\tRs. " + b_b * food.two();

                                }
                                if (pas > 0) {
                                    System.out.print("\n"+pas + " Pasta\t\t\t\tRs. " + pas * food.three());

                                    output[index++] = "\n"+pas + " Pasta\t\t\t\tRs. " + pas * food.three();
                                }
                                if (chp > 0) {
                                    System.out.print("\n"+chp + " Chipotle\t\t\tRs. " + chp * food.four());
                                    output[index++] = "\n"+chp + " Chipotle\t\t\tRs. " + chp * food.four();

                                }
                                if (b_c > 0) {
                                    System.out.print("\n"+b_c+ " Beef Chilli\t\t\tRs. " + b_c * food.five());
                                    output[index++] = "\n"+b_c+ " Beef Chilli\t\t\tRs. " + b_c * food.five();

                                }
                                if (c_c > 0) {
                                    System.out.print("\n"+c_c + " Chicken Chilli\t\t\t\tRs. " + c_c * food.six());
                                    output[index++] = "\n"+c_c + " Chicken Chilli\t\t\t\tRs. " + c_c * food.six();

                                }
                            }

                            if (t > 0 || up > 0 || p > 0 || cc > 0 || cf > 0 || ct > 0) {

                                food = Drinks.getobj();
                                if (t > 0) {
                                    System.out.print("\n"+t + " Tea\t\t\t\tRs. " + t * food.one());

                                    output[index++] = "\n"+t + " Tea\t\t\t\tRs. " + t * food.one();
                                }
                                if (cf > 0) {
                                    System.out.print("\n"+cf + " Coffee\t\t\tRs. " + cf * food.two());
                                    output[index++] ="\n"+cf + " Coffee\t\t\tRs. " + cf * food.two();

                                }
                                if (up > 0) {
                                    System.out.print("\n"+up + " 7up\t\t\t\tRs. " + up * food.three());
                                    output[index++] = "\n"+up + " 7up\t\t\t\tRs. " + up * food.three();

                                }
                                if (p > 0) {
                                    System.out.print("\n"+p + " Pepsi\t\t\t\tRs. " + p * food.four());
                                    output[index++] = "\n"+p + " Pepsi\t\t\t\tRs. " + p * food.four();

                                }
                                if (cc > 0) {
                                    System.out.print("\n"+cc + " Coca Cola\t\t\tRs. " + cc * food.five());
                                    output[index++] = "\n"+cc + " Coca Cola\t\t\tRs. " + cc * food.five();

                                }
                                if (ct > 0) {
                                    System.out.print("\n"+ct + " Cocktail\t\t\tRs. " + ct * food.six());
                                    output[index++] = "\n"+ct + " Cocktail\t\t\tRs. " + ct * food.six();

                                }
                            }
                            output[index++] = order.get_discount();
                            output[index++] = order.get_discount(1000);

                            

                            System.out.println("\nTotal\t\t\t\tRs. " + (order.getTotal()));
                            output[index++] = "\nTotal\t\t\t\tRs. " + (order.getTotal());
                            Filing f = new Filing();
                            try {
                            f.WriteToFile(output , "reciept.txt");
                                System.out.println("Reciept Has Been Generated");
                            order.reset();
                            } catch (IOException ex) {
                                System.out.println(ex);
                            }

                            c_b = 0;
                            b_b = 0;
                            pas = 0;
                            chp = 0;
                            b_c = 0;
                            c_c = 0;
                            t = 0;
                            cf = 0;
                            p = 0;
                            cc = 0;
                            up = 0;
                            ct = 0;


                            i++;
                            System.out.println("\nPress ENTER to proceed");
                            sc.nextLine();
                            sc.nextLine();
                            break;

                        default:
                            System.out.println("\nWRONG INPUT!");
                    }
                }
            }
            else if (w == 2) 
                {
                int o = orderNo.dequeue();
                if(o!=-1){
                    String info=c[o].toString();
                    System.out.println("\n================================");
                    System.out.println(info);
                    System.out.print("================================");
                }
            }
            else if(w==3){
                System.exit(0);
            }
            else
                System.out.println("\nWRONG INPUT!");
        }
    }
    
    
}
