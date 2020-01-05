
/**
 * Write a description of class LoyaltyCardArrayClass here.
 *
 * @author Aida Campean w18002348
 * @version 20.12.2018
 */
public class LoyaltyCardArrayClass
{
    private int currentIndex;
    private LoyaltyCard[] loyaltyCards;
    
    public LoyaltyCardArrayClass(int maxNoOfLoyaltyCards)
    {
        loyaltyCards = new LoyaltyCard[maxNoOfLoyaltyCards];
        currentIndex = 0;
    }
    
    /** Adds a loyalty card
     * @param loyaltyCard the loyalty card to add
     */
    public void addLoyaltyCard(LoyaltyCard loyaltyCard)
    {
        if(currentIndex < loyaltyCards.length)
        {
            loyaltyCards[currentIndex] = loyaltyCard;
            currentIndex++;
            System.out.println("Card added.");
        }
        else
        {
            System.out.println("Membership full. Could not add LoyaltyCard!");
        }
    }
    
    /** Return capacity of array
     * 
     */
    public int getCapacity()
    {
        return loyaltyCards.length;
    }
    
    /** Return the number of loyalty cards existing in the array
     * 
     */
    public int getNumberOfLoyaltyCards()
    {
        return currentIndex;
    }
    
    /**
     * Print details of the loyalty card with the given card number
     * @param cardNumber the card number 
     */
    public boolean printLoyaltyCard(String cardNumber)
    {
        for(int i = 0; i < currentIndex; i++)
        {
            if(loyaltyCards[i].getCardNumber().equals(cardNumber))
            {
                loyaltyCards[i].printCustomerDetails();
                return true;
            }
        }
        return false;
    }
    
    /**
     * Print all loyalty cards
     */
    public void printAllLoyaltyCards()
    {
        for(int i = 0; i < currentIndex; i++)
        {
            loyaltyCards[i].printCustomerDetails();
            System.out.println();
        }
    }
    
    /**
     * Remove loyalty card with the given card number if any
     * @param cardNumber the card number
     * @return true if successful otherwise false
     */
    public boolean removeLoyaltyCard(String cardNumber)
    {
        for(int i = 0; i < currentIndex; i++)
        {
            if(loyaltyCards[i].getCardNumber().equals(cardNumber))
            {
                squash(i);
                return true;
            }
        }
        return false;
    }
    
    /**
     * Return the index of the card with the given card number
     * @param cardNumber the card number
     */
    public int search(String cardNumber)
    {
        for(int i = 0; i < currentIndex; i++)
        {
            if(loyaltyCards[i].getCardNumber().equals(cardNumber))
            {
                return i;
            }
        }
        return -1;
    }
    
    /** Private service method therefore no javadoc commenting
     */
    private void squash(int i)
    {
        for(int j = i; j < currentIndex - 1; j++)
        {
            loyaltyCards[j] = loyaltyCards[j+1];
        }
        loyaltyCards[currentIndex - 1] = null;
        currentIndex--;
    }
}
