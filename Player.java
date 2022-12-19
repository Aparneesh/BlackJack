public class Player {
    Cards card = new Cards();
    int rand;
    int playerCardValue;
    int aceCounter;
    String playerCards;
    public Player(){
    }


    // same as dealer class
    public void firstCard(){
        rand = (int) (Math.random()*13);
        card.cardsValue(rand);
        if (card.getCardsValue() == 0){
            playerCardValue = 11;
            aceCounter++;
        }
        else{
            playerCardValue = card.getCardsValue();
        }
        playerCards = card.getCard();
    }
    

    public void secondCard(){
        rand = (int) (Math.random()*13);
        card.cardsValue(rand);
        if (card.getCardsValue() == 0){
            playerCardValue = 11;
            aceCounter++;
        }
        else{
            playerCardValue = card.getCardsValue();
        }
        playerCards = card.getCard();
    }

    public String getPlayerCard(){
        return playerCards;
    }

    public int getPlayerValue(){
        return playerCardValue;
    }






}
