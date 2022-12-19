import java.util.Scanner;
public class Cards {
    public Cards(){
    }

    String[] listOfCards = {"Ace", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
    int randCard;
    int cardValue;

    Scanner sc = new Scanner(System.in);



    public void cardsValue(int value){
        randCard = value;
        if (randCard == 0){
            System.out.println("How much do you want the ace to be worth?\n[1]1\n[2]11");
            String ace = sc.nextLine();
            if (ace.equals("1")){
                cardValue = 1;
            }
            else if(ace.equals("2")){
                cardValue = 11;
            }
        }
        else if (randCard == 10 || randCard == 11 || randCard == 12 || randCard == 13){
            cardValue = 10;
        }
        else{
            cardValue = randCard;
        }
    }


    public void dealerCard(int value){
        randCard = value;
        randCard = (int) (Math.random() * listOfCards.length);
        if(randCard == 10 || randCard == 11 || randCard == 12 || randCard == 13){
            cardValue = 10;
        }
        else if(randCard == 0){
            cardValue = 0;
        }
        else{
            cardValue = randCard;
        }
    }


    public String getCard(){
        return listOfCards[randCard];
    }

    public int getCardsValue(){
        return cardValue;
    }






}
