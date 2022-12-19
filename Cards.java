import java.util.Scanner;
public class Cards {
    public Cards(){
    }

    String[] listOfCards = {"Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
    int randCard;
    int cardValue;

    Scanner sc = new Scanner(System.in);



    public void cardsValue(int value){
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


    public String getCard(){
        return listOfCards[randCard];
    }

    public int getCardsValue(){
        return cardValue;
    }






}
