public class Player {
    Cards card = new Cards();
    int rand;
    int playerCardValue;
    String playerCards;
    public Player(){
    }


    public void firstCard(){
        rand = (int) (Math.random() * 14);
        card.cardsValue(rand);
        playerCardValue = card.getCardsValue();
        playerCards = card.getCard();
    }

    public void secondCard(){
        rand = (int) (Math.random() * 14);
        card.cardsValue(rand);
        playerCardValue = card.getCardsValue();
        playerCards = card.getCard();
    }

    public String getPlayerCard(){
        return playerCards;
    }

    public int getPlayerValue(){
        return playerCardValue;
    }






}
