import java.util.Scanner;
/**
 * Write a description of class Driver here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Driver
{
    public static void main(String[] args){

        Ledger ledger = new Ledger();

        // ledger.buy(10,20); 
        // ledger.buy(20,20); 
        // ledger.buy(30,40);
        // ledger.buy(40,50); 

        // ledger.sell(20,30);
        // ledger.displayGains();

        // ledger.sell(30,5); 
        // ledger.displayGains();

        boolean runLedger = true; 
        while(runLedger){
            System.out.println("What would you like to do?");
            System.out.println("Press 1 if you would like to buy new stock.");
            System.out.println("Press 2 if you would like to sell your old stock.");
            System.out.println("Press 3 if you would like to display total gains.");
            System.out.println("Press 4 if you would like to exit.");
            Scanner s = new Scanner(System.in);
            int option = s.nextInt();

            if(option == 1){
                System.out.println("Please enter the amount of stock that you would like to purchase,followed by the price that you would like to buy it for.");
                int num = s.nextInt();
                int price = s.nextInt();
                ledger.buy(num,price); 
            }

            if(option == 2){
                System.out.println("Please enter the amount of stock that you would like to sell,followed by the price that you would like to sell it for.");
                int num = s.nextInt();
                int price = s.nextInt();
                ledger.sell(num,price); 
            }

            if(option == 3){
                ledger.displayGains(); 
            }

            if(option == 4){
                ledger.quit(); 
            }

        }
    }
}
