
/**
 * Write a description of class Ledger here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Ledger
{
    double capitolGains = 0;
    int totalShares = 0;
    public Ledger(){ 
    }

    LinkedDeque<StockLot> ledger = new LinkedDeque<StockLot>();
    /**
     * Method buy
     * user will be prompted to enter how many shares they wish to buy and at
     * what price. The information will be used to create a StockLot object instance
     * (class supplied in the ZIP file), and added to the ledger. The program display
     * confirmation of the purchase and then prompt the menu again.
     */
    public void buy(int num, float price){
        StockLot lot = new StockLot(num, price); 
        ledger.addToBack(lot); 
        totalShares += num; 
        System.out.println(num + " of shares at price " + price + " were added to the ledger.");
    }

    /**
     * Method sell
     * user will be prompted to enter how many shares they wish to sell and at
     * what price. The shares should be removed from the ledger (as described
     * above), and the capital gains/loss from the sale should be computed and
     * the total capital gains be updated by this amount. The program should
     * display confirmation of the sale and then prompt the menu again.
     */
    public void sell(int num, double p){
        int sharesToSell = num;
        double sellPrice = p; 
        int count = 1; 
        
        if(sharesToSell > totalShares){
            throw new IllegalArgumentException("We can't sell that many shares, there are not enough in the ledger");
        }
        else{
            while(sharesToSell != 0){
                StockLot selling = ledger.getFront();
                double boughtPrice = selling.getBuyPrice();
                int numShares = selling.getShares(); 
                if(numShares > sharesToSell){
                    int left = numShares - sharesToSell;
                    totalShares -= numShares - left; 
                    StockLot leftover = new StockLot(left, boughtPrice); 
                    capitolGains += (sellPrice - boughtPrice) * (numShares - left);
                    
                    System.out.println((numShares - left) +" shares sold from day " + count + " at $" + sellPrice +  
                                " for a gain of $" + (sellPrice - boughtPrice) * (numShares - left) 
                                + ". There are " + left + " shares leftover from this day.");    
                    sharesToSell -= numShares - left;
                    ledger.removeFront(); 
                    ledger.addToFront(leftover); 
                    count++;
                }
                else{
                    sharesToSell -= numShares; 
                    totalShares -= numShares;
                    
                    System.out.println(numShares + " sold from day " + count + " at $" + sellPrice + " for a gain of: $" 
                                            +(sellPrice - boughtPrice) * (numShares)); 
                    capitolGains += (sellPrice - boughtPrice) * (numShares);
                    ledger.removeFront(); 
                    count++;
                    
                    
                    
                }
                
            }
        }
    }

    /**
     * The total capital gain/loss from all sell
     * transactions thus far will be displayed. Due to how capital gains are taxed, we
     * only care about gains/losses that are realized when stock is sold. The program
     * will prompt the menu again.
     */
    public void displayGains(){
        System.out.println("The total gains up to this point are: $" + capitolGains);
    }

    /**
     * Method quit
     * End the program.
     */
    public void quit(){
        System.exit(0);
    }
}
