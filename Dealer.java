public class Dealer {
    Cards card = new Cards();
    int rand; 
    int value;
    int value2;
    String dealerCards;
    int aceCounter;

    public Dealer(){
    }

    public void firstCard(){
        rand = (int) (Math.random()*13);
        card.dealerCard(rand);
        if (card.getCardsValue() == 0){
            value = 11;
            aceCounter++;
        }
        else{
            value = card.getCardsValue();
        }
        dealerCards = card.getCard();
    }

    public void secondCard(){
        rand = (int) (Math.random()*13);
        card.dealerCard(rand);
        if (card.getCardsValue() == 0){
            value2 = 11;
            aceCounter++;
        }
        else{
            value2 = card.getCardsValue();
        }
        dealerCards = card.getCard();

    }





    public String getdealerCard(){
        return dealerCards;
    }

    public int getdealerValue(){
        return value;
    }

    public int getValueTwo(){
        return value2;
    }
    






   
    


}
