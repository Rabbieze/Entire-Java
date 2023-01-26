import java.util.Random;
import java.util.Scanner;

public class ECommerceApp {
    public static void main(String[]args)
    {
        double price = 0;
        double tax = 0;
        double total = 0;

        bannerPrinter();
        String productCatalog = productsBuilder();
        if(getOrder(productCatalog))
        {
            price = getPrice();
            tax = getTax(price);
            total = getTotal(price, tax);
            System.out.println("\nPrice: $" + String.format("%.2f", price));
            System.out.println("Tax: $" + String.format("%.2f", tax));
            printTotal(total);
        }
        else
            System.out.println("No match found!");
    }
    private static void bannerPrinter()
    {
        System.out.println(
                "**************\n" +
                        "====== Welcome to my eCommerce app! ======\n" +
                        "**************"
        );
    }
    private static String productsBuilder()
    {
        String productCatalog = "Desk\nTable\nPen";
        return productCatalog;
    }
    private static boolean getOrder(String productCatalog)
    {
        boolean found = true;
        Scanner sc = new Scanner(System.in);
        System.out.println(productCatalog);
        System.out.print("\nEnter a product name: ");
        String productName = sc.nextLine();
        String[] data = productCatalog.split("[\\r\\n]+");
        if(productName.equals(data[0]) || productName.equals(data[1]) || productName.equals(data[2]))
            found = true;
        else
            found = false;
        return found;
    }

    private static double getPrice()
    {
        Random rand = new Random();
        return (rand.nextDouble() * 100 + 1);
    }

    private static double getTax(double price)
    {
        return(price * 0.1);
    }

    private static double getTotal(double price, double tax)
    {
        return(price + tax);
    }

    private static void printTotal(double total)
    {
        System.out.println("Your sale total is: $" + String.format("%.2f", total) + "\n");
    }
}

