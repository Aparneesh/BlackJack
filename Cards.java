import java.util.Scanner;
public class Cards {
    public Cards(){
    }


    //card list
    String[] listOfCards = {"Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
    int randCard;
    int cardValue;

    Scanner sc = new Scanner(System.in);


    //gets random card and based on it's position, get's a value equal to it (except for ace. That is done in another file)
    public void cardsValue(int value){
        randCard = value;
        if(randCard == 9 || randCard == 10 || randCard == 11 || randCard == 12){
            cardValue = 10;
        }
        //aces equal zero because they are used later in player and dealer classes
        else if(randCard == 0){
            cardValue = 0;
        }
        else{
            cardValue = randCard + 1;
        }
    }

    //same as cardsValue except for dealer (it might be kinda redundant)
    public void dealerCard(int value){
        randCard = value;
        if(randCard == 9 || randCard == 10 || randCard == 11 || randCard == 12){
            cardValue = 10;
        }
        else if(randCard == 0){
            cardValue = 0;
        }
        else{
            cardValue = randCard + 1;
        }
    }


    //returns card
    public String getCard(){
        return listOfCards[randCard];
    }

    //returns card's value
    public int getCardsValue(){
        return cardValue;
    }






}
