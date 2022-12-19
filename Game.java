import java.util.Scanner;
import java.util.ArrayList;
public class Game {
    ArrayList<Integer> ace = new ArrayList<Integer>();
    ArrayList<Integer> acePlayer = new ArrayList<Integer>();

    Dealer deal = new Dealer();
    Player play = new Player();
    Cards card = new Cards();
    int totalPlayerValue;
    int totalDealerValue;
    double score;
    boolean cringe;
    boolean game;
    Scanner sc = new Scanner(System.in);
    
    public Game(){
    }

    public void playGame(){
        score = 100;
        while (!(score == 0 || score == 1000 || score > 1000)){
            game = true;
            System.out.println("Your current money is $" + score);
            while (game == true){
                System.out.print("How much are you going to bet? ");
                int gamble = sc.nextInt();

                if (gamble > score + 1 || gamble == 0){
                    cringe = false;
                }
                else{
                    cringe = true;
                }

                while (cringe == false){
                    System.out.println("Invalid amount. Try Again");
                    gamble = sc.nextInt();
                    if (gamble > score + 1){
                        cringe = false;
                    }
                    else{
                        cringe = true;
                    }
                }

                play.firstCard();
                fancyText("\033[H\033[2JYou draw your first card");
                fancyText("It's a " + play.getPlayerCard() + "!");
                totalPlayerValue = play.getPlayerValue();

                play.secondCard();
                fancyText("You draw your second card");
                fancyText("It's a " + play.getPlayerCard() + "!");
                totalPlayerValue = totalPlayerValue + play.getPlayerValue();

                while(play.aceCounter > 0){
                    acePlayer.add(1);
                    play.aceCounter--;
                }
        
                for(int x : acePlayer){
                    while(x >= 0){
                        if(totalPlayerValue > 21){
                            totalPlayerValue = totalPlayerValue - 10;
                            x--;
                        }
                        else{
                            break;
                        }
                    }
                    break;
                }

                fancyText("Your card value is: " + totalPlayerValue);
                deal.firstCard();
                totalDealerValue = deal.getdealerValue();
                fancyText("The Dealer draws a " + deal.getdealerCard() + "!");

                fancyText("Dealer's card value is: " + totalDealerValue);
                fancyText("What would you like to do?\n[1]Fold\n[2]Hit\n[3]Stand");
                String choice = sc.next();

                if (choice.equals("1")){
                    score = score - (gamble/2);
                    game = false;
                }
                else if(choice.equals("2")){
                    hit(totalPlayerValue, totalDealerValue, gamble);
                    game = false;
                }
                else if(choice.equals("3")){
                    stand(totalPlayerValue, totalDealerValue, gamble);
                    game = false;
                }

            }
            
        }
        if(score == 0){
            fancyText("\033[H\033[2JHAHAHA. LOOK WHO HAS NO MONEY!!!! I guess we both are similar in some way.... :_(");
        }
        else{
            fancyText("\033[H\033[2JYou won! If you wouldn't mind, care to donate me some. (I work for free. PLEASE DONATE)");
        }

    }


public void hit(int value, int dealerValue, int gamble){
    boolean hit = true;

    //player turn
    play.firstCard();
    fancyText("\033[H\033[2JYou hit and get a " + play.getPlayerCard());
    value = value + play.getPlayerValue();
    
    while(play.aceCounter > 0){
        acePlayer.add(1);
        play.aceCounter--;
    }
    for(int x : acePlayer){
        while(x >= 0){
            if(value > 21){
                value = value - 10;
                x--;
            }
            else{
                break;
            }
        }
        break;
    }

    fancyText("Your card value is: " + value);

    if(value >= 21){
       hit = false;
    }
    else{
        hit = true;
    }

    //if player wants to hit again
    while(hit == true){
        fancyText("Do you want to hit again?\n[1]Yes\n[2]No");
        String choice = sc.next();

        if(choice.equals("1")){
            play.firstCard();
            fancyText("You hit and get a " + play.getPlayerCard());
            value = value + play.getPlayerValue();
            
            while(play.aceCounter > 0){
                acePlayer.add(1);
                play.aceCounter--;
            }
            for(int x : acePlayer){
                while(x >= 0){
                    if(value > 21){
                        value = value - 10;
                        x--;
                    }
                    else{
                        break;
                    }
                }
                break;
            }


            fancyText("Your card value is: " + value);
            if(value >= 21){
                break;
            }
            hit = true;
        
        }
        else if(choice.equals("2")){
            hit = false;
        }
        
    }
    

    //if player value is more than 21 than they automatically lose
    while(!(value > 21)){
        deal.secondCard();
        fancyText("The Dealer's reveals their second card... ");
        fancyText("It's a " + deal.getdealerCard());
        dealerValue = dealerValue + deal.value2;

        while(deal.aceCounter > 0){
            ace.add(1);
            deal.aceCounter--;
        }

        for(int x : ace){
            while(x >= 0){
                if(dealerValue > 21){
                    dealerValue = dealerValue - 10;
                    x--;
                }
                else{
                    break;
                }
            }
            break;
        }
        fancyText("Dealer's card value is: " + dealerValue);
        

        //if dealer's card don't add up to 17 or more
        while (dealerValue < 17){
            deal.secondCard();
            fancyText("The Dealer's next card is " + deal.getdealerCard());
            dealerValue = dealerValue + deal.value2;
            while(deal.aceCounter > 0){
                ace.add(1);
                deal.aceCounter--;
            }
        
            for(int x : ace){
                while(x >= 0){
                    if(dealerValue > 21){
                        dealerValue = dealerValue - 10;
                        x--;
                    }
                    else{
                        break;
                    }
                }
                break;
            }
            fancyText("Dealer's card value is: " + dealerValue);
        } 
        break;
            
    }
    
    //conditions of winning or losing
    if(value == 21){
        score = score + (gamble * (3/2));
        fancyText("You win!!");
    }
    else if(value > 21 && dealerValue > 21){
        fancyText("YOU TIE!!!");
    }
    else if(value > 21){
        score = score - gamble;
        fancyText("You bust!!!");
    }
    else if(dealerValue > 21){
        score = score + gamble;
        fancyText("The dealer busts. You win!!!");
    }
    else if(dealerValue < value){
        score = score + gamble;
        fancyText("You win!!!");
    }
    else if(value == dealerValue){
        fancyText("YOU TIE!!!");
    }
    else{
        score = score - gamble;
        fancyText("You lose");
    }
}

public void stand(int value, int dealerValue, int gamble){
    fancyText("\033[H\033[2JYou stand");
    deal.secondCard();
    fancyText("The Dealer's reveals their second card... ");
    fancyText("It's a " + deal.getdealerCard());
    dealerValue = dealerValue + deal.value2;
    while(deal.aceCounter > 0){
        ace.add(1);
        deal.aceCounter--;
    }

    for(int x : ace){
        while(x >= 0){
            if(dealerValue > 21){
                dealerValue = dealerValue - 10;
                x--;
            }
            else{
                break;
            }
        }
        break;
    }

    fancyText("Dealer's card value is: " + dealerValue);

    while (dealerValue < 17){
        deal.secondCard();
        fancyText("The Dealer's next card is " + deal.getdealerCard());
        dealerValue = dealerValue + deal.value2;
        while(deal.aceCounter > 0){
            ace.add(1);
            deal.aceCounter--;
        }
    
        for(int x : ace){
            while(x >= 0){
                if(dealerValue > 21){
                    dealerValue = dealerValue - 10;
                    x--;
                }
                else{
                    break;
                }
            }
            break;
        }
        fancyText("Dealer's card value is: " + dealerValue);
    }

    if(value == 21){
        score = score + (gamble * (3/2));
        fancyText("You win!!!");
    }
    else if(value > 21 && dealerValue > 21){
        fancyText("YOU TIE!!!");
    }
    else if(value > 21){
        score = score - gamble;
        fancyText("You lose!!!");
    }
    else if(dealerValue > 21){
        score = score + gamble;
        fancyText("You win!!!");
    }
    else if(dealerValue < value){
        score = score + gamble;
        fancyText("You win!!!");
    }
    else if(value == dealerValue){
        fancyText("YOU TIE!!!");
    }
    else{
        score = score - gamble;
        fancyText("You lose!!");
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
