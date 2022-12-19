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
        rand = // TO DO: Get random number from one to 12
        card.cardsValue(rand);
        //if there is an ace, it adds it to the counter and now ace is worth 11
        if (/*TO DO: checks for ace*/){
            playerCardValue = 11;
            aceCounter++;
        }
        else{
            playerCardValue = card.getCardsValue();
        }
        playerCards = card.getCard();
    }
    

    public void secondCard(){
        rand = // TO DO: Get random number from one to 12
        card.cardsValue(rand);
        //if there is an ace, it adds it to the counter and now ace is worth 11
        if (/*TO DO: checks for ace*/){
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
