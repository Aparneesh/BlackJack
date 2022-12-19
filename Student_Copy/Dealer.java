import Key_Code.Cards;

public class Dealer {
    Cards card = new Cards();
    int rand; 
    int value;
    int value2;
    String dealerCards;
    int aceCounter;

    public Dealer(){
    }

    //gets first card
    public void firstCard(){
        rand = // TO DO: Get random number from one to 12
        card.dealerCard(rand);
        //if there is an ace, it adds it to the counter and now ace is worth 11
        if (/*TO DO: check for ace*/){
            value = 11;
            aceCounter++;
        }
        else{
            value = card.getCardsValue();
        }
        dealerCards = card.getCard();
    }

    //gets second card (everything else is the same)
    public void secondCard(){
        rand = // TO DO: Get random number from one to 12
        card.dealerCard(rand);
        if (/*TO DO: check for ace*/){
            value2 = 11;
            aceCounter++;
        }
        else{
            value2 = card.getCardsValue();
        }
        dealerCards = card.getCard();

    }



    //gets dealer's Card
    public String getdealerCard(){
        return dealerCards;
    }

    //gets dealer's card value 
    public int getdealerValue(){
        return value;
    }

    public int getValueTwo(){
        return value2;
    }
    






   
    


}
