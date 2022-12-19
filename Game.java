import java.util.Scanner;
public class Game {
    Dealer deal = new Dealer();
    Player play = new Player();
    Cards card = new Cards();
    int totalPlayerValue;
    int totalDealerValue;
    int score;
    boolean game;
    Scanner sc = new Scanner(System.in);
    
    public Game(){
    }

    public void playGame(){
        score = 100;
        while (!(score == 0 || score == 1000 || score > 1000)){
            game = true;
            while (game == true){
                System.out.println("Your current money is $" + score);
                System.out.print("How much are you going to bet? ");
                int gamble = sc.nextInt();

                play.firstCard();
                System.out.println("You draw your first card");
                System.out.println("It's a " + play.getPlayerCard() + "!");
                totalPlayerValue = play.getPlayerValue();

                play.secondCard();
                System.out.println("You draw your second card");
                System.out.println("It's a " + play.getPlayerCard() + "!");

                totalPlayerValue = totalPlayerValue + play.getPlayerValue();
                System.out.println(totalPlayerValue);

                if(totalPlayerValue > 21){
                    score = score - gamble;
                    game = false;
                    System.out.println("You lost");
                }
                else if(totalPlayerValue == 21){
                    score = score + gamble;
                    game = false;
                    System.out.println(" You won!");
                }


                deal.firstCard();
                System.out.println("The Dealer draws a " + deal.getdealerCard() + "!");
                System.out.println("What would you like to do?\n[1]Fold\n[2]Hit\n[3]Stand");
                String choice = sc.next();

                if (choice.equals("1")){
                    score = score - gamble;
                    game = false;
                }
                else if(choice.equals("2")){
                    hit(totalPlayerValue, totalDealerValue = deal.getdealerValue(), gamble);
                    game = false;
                }
                else if(choice.equals("3")){
                    stand(totalPlayerValue, totalDealerValue = deal.getdealerValue(), gamble);
                }

            }
            
        }
        System.out.print("GAME OVER");

    }


public void hit(int value, int dealerValue, int gamble){
    deal.secondCard();
    System.out.println("The Dealer's second card is " + deal.getdealerCard());
    dealerValue = dealerValue + deal.getdealerValue();
    System.out.println(dealerValue);
    boolean hit = true;
    boolean turn = true;

    while(turn == true){
        play.firstCard();
        System.out.println("You hit and get a " + play.getPlayerCard());
        value = value + play.getPlayerValue();
        System.out.println(value);

        while (dealerValue < 17){
            deal.secondCard();
            System.out.println("The Dealer's next card is " + deal.getdealerCard());
            dealerValue = dealerValue + deal.getdealerValue();
            System.out.println(dealerValue);
        }

        if ((value >= 21)||(dealerValue >= 21)){
            turn = false;
        }
        else{
            System.out.println("Do you want to hit again?\n[1]Yes\n[2]No");
            String choice = sc.next();

            if(choice.equals("1")){
                hit = true;
            }
            else if(choice.equals("2")){
                hit = false;
            }

            while(hit == false){
                if (dealerValue > value){
                    score = score - gamble;
                    System.out.print("You lose!!!");
                    turn = false;
                    break;
                }
                else if(dealerValue < value){
                    score = score + gamble;
                    System.out.print("You won!!!");
                    turn = false;
                    break;
                }
                else{
                    score = score;
                    System.out.print("A TIE!!!!");
                    turn = false; 
                    break;  
                }

            }
        }   
    }
          
    if(value == 21){
        score = score + gamble;
        System.out.println("You win!!!");
    }
    else if(value > 21 && dealerValue > 21){
        score = score;
        System.out.println("YOU TIE!!!");
    }
    else if(value > 21){
        score = score - gamble;
        System.out.println("You lose!!!");
    }
    else if(dealerValue > 21){
        score = score + gamble;
        System.out.println("You win!!!");
    }
    else if(dealerValue < value){
        score = score + gamble;
        System.out.println("You win!!!");
    }
    else if(value == dealerValue){
        score = score;
        System.out.println("YOU TIE!!!");
    }
    else{
        score = score - gamble;
        System.out.println("You lose");
    }
}

public void stand(int value, int dealerValue, int gamble){
    System.out.println("You stand");
    deal.secondCard();
    System.out.println("Dealer's second card is " + deal.getdealerCard());
    dealerValue = dealerValue + deal.getdealerValue();
    System.out.println(dealerValue);
    System.out.println(value);

    while (dealerValue < 17){
        deal.secondCard();
        System.out.println("The Dealer's next card is " + deal.getdealerCard());
        dealerValue = dealerValue + deal.getdealerValue();
        System.out.println(dealerValue);
    }

    if(value == 21){
        score = score + gamble;
        System.out.println("You win!!!");
    }
    else if(value > 21 && dealerValue > 21){
        score = score;
        System.out.println("YOU TIE!!!");
    }
    else if(value > 21){
        score = score - gamble;
        System.out.println("You lose!!!");
    }
    else if(dealerValue > 21){
        score = score + gamble;
        System.out.println("You win!!!");
    }
    else if(dealerValue < value){
        score = score + gamble;
        System.out.println("You win!!!");
    }
    else if(value == dealerValue){
        score = score;
        System.out.println("YOU TIE!!!");
    }
    else{
        score = score - gamble;
        System.out.println("You lose");
    }




}










private static void fancyText(String text){
    for (char c : text.toCharArray()){
    System.out.print(c);
    try{
        Thread.sleep(75);
    } catch (Exception e){}
    }
    System.out.print("\n");
}







}
