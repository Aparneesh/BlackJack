public class Dealer {
    Cards card = new Cards();
    int rand; 
    int value;
    String dealerCards;

    public Dealer(){
    }

    public void firstCard(){
        rand = (int) (Math.random() * 14);
        card.dealerCard(rand);
        if (card.getCardsValue() == 0){
            value = 11;
        }
        else{
           value = card.getCardsValue();
        }
        dealerCards = card.getCard();
    }

    public void secondCard(){
        rand = (int) (Math.random() * 14);
        card.dealerCard(rand);
        if (card.getCardsValue() == 0){
            if(card.getCardsValue() + value > 21){
                value = card.getCardsValue() + 1;
            }
            else{
                value = card.getCardsValue() + 11;
            }
        }
        else{
            value = card.getCardsValue();
        }
        dealerCards = card.getCard();
    }


    public String getdealerCard(){
        return dealerCards;
    }

    public int getdealerValue(){
        return value;
    }
    






   
    


}
