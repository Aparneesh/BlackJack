import java.util.Scanner;

import Key_Code.Cards;
import Key_Code.Dealer;
import Key_Code.Player;

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
    //cringe is used to check invalid input for gamble variable
    boolean cringe;
    boolean game;
    Scanner sc = new Scanner(System.in);
    
    public Game(){
    }

    public void playGame(){
        score = 100;
        //the loop runs unless score is 0 or more than or equal to 1000
        while (/*TO DO: score isn't 0 or more and than or equal to 1000*/){
            game = true;
            System.out.println("Your current money is $" + score);
            //the loop runs until you won, tie or lost
            while (/*TO DO: figure out based on boolean above*/){
                System.out.print("How much are you going to bet? ");
                //user inputed number
                int gamble = sc.nextInt();

                
                if (gamble > score + 1 || gamble == 0){
                    cringe = false;
                }
                else{
                    cringe = true;
                }
                
                //checks for valid inputs
                //TO DO: make a while loop for invalid amount for gamble

                

                play.firstCard();
                fancyText("\033[H\033[2JYou draw your first card");
                fancyText("It's a " + play.getPlayerCard() + "!");
                totalPlayerValue = play.getPlayerValue();

                play.secondCard();
                fancyText("You draw your second card");
                fancyText("It's a " + play.getPlayerCard() + "!");
                totalPlayerValue = totalPlayerValue + play.getPlayerValue();

                //checks how many aces there are so far and adds that many items to the list
                while(play.aceCounter > 0){
                    acePlayer.add(1);
                    play.aceCounter--;
                }
        
                //determines whether ace should be worth 11 or 1
                for(int x : acePlayer){
                    while(x >= 0){
                        //decides that ace should be worth 1
                        if(totalPlayerValue > 21){
                            totalPlayerValue = totalPlayerValue - 10;
                            x--;
                            acePlayer.remove(0);
                        }
                        //decides that ace should be worth 11
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

                
                if (/*TO DO: if user input is 1 */)){
                    //user folds and game resets
                    score = score - (gamble/2);
                    /*TO DO: game resets */
                }
                else if(/*TO DO: if user input is 2 */){
                    //user hits and game goes to hit method
                    hit(totalPlayerValue, totalDealerValue, gamble);
                    /*TO DO: game resets */
                }
                else if(/*TO DO: if user input is 3 */)){
                    //user stands and game goes to stand method
                    stand(totalPlayerValue, totalDealerValue, gamble);
                    /*TO DO: game resets */
                }

            }
            
        }
        if(/*TO DO: player has no money*/){
            fancyText("\033[H\033[2JHAHAHA. LOOK WHO HAS NO MONEY!!!! I guess we both are similar in some way.... :_(");
        }
        else{
            fancyText("\033[H\033[2JYou won! If you wouldn't mind, care to donate me some. (I work for free. PLEASE DONATE)");
        }

    }


//code for when player wants to hit
public void hit(int value, int dealerValue, int gamble){
    boolean hit = true;

    //player hits
    play.firstCard();
    fancyText("\033[H\033[2JYou hit and get a " + play.getPlayerCard());
    value = value + play.getPlayerValue();
    
    //notice how this is here again
    //it doesn't matter if there are repeated aces in the list since if the value isn't greater than 21, it will just break out of the loop
    while(play.aceCounter > 0){
        acePlayer.add(1);
        play.aceCounter--;
    }
    for(int x : acePlayer){
        while(x >= 0){
            if(value > 21){
                value = value - 10;
                x--;
                acePlayer.remove(0);
            }
            else{
                break;
            }
        }
        break;
    }

    fancyText("Your card value is: " + value);

    //skips asking "do you want to hit again" if value is greater than or equal to 21
    if(/*TO DO: player card is more than or equal to 21*/){
       hit = false;
    }
    else{
        hit = true;
    }

    //if player wants to hit again it runs in this loop until they equal or go over 21
    while(/*TO DO: make this loop run using boolean from above*/){
        fancyText("Do you want to hit again?\n[1]Yes\n[2]No");
        String choice = sc.next();

        //player wants to hit
        if(/*TO DO: user input is 1*/){
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
                        acePlayer.remove(0);
                    }
                    else{
                        break;
                    }
                }
                break;
            }
            fancyText("Your card value is: " + value);
            if(/*TO DO: player card value is more than or equal to 21 */){
                break;
            }
            hit = true;

        }
        //player doesn't want to hit
        else if(/*TO DO: user input is two*/){
            hit = false;
        }
        
    }
    

    //loop runs if player is less than or equal to 21
    while(/*TO DO: player card is less or equal to 21*/){
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
                    ace.remove(0);
                }
                else{
                    break;
                }
            }
            break;
        }
        fancyText("Dealer's card value is: " + dealerValue);
        

        //if dealer's card don't add up to 17 or more then it runs till it does
        while (/*TO DO: dealer card less than 17*/){
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
                        ace.remove(0);
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
    if(/*TO DO: player hits blackjack and dealer value doesn't equal player value */){
        score = score + (gamble * (3/2));
        fancyText("You win!!");
    }
    else if(/*TO DO: player card is over 21 */){
        score = score - gamble;
        fancyText("You bust!!!");
    }
    else if(/*TO DO: dealer card is over 21 */){
        score = score + gamble;
        fancyText("The dealer busts. You win!!!");
    }
    else if(/*TO DO: player card is more than dealer card */){
        score = score + gamble;
        fancyText("You win!!!");
    }
    else if(/*TO DO: player card is the same as dealer card*/){
        fancyText("YOU TIE!!!");
    }
    else{
        score = score - gamble;
        fancyText("You lose");
    }
}

//method for standing
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
                ace.remove(0);
            }
            else{
                break;
            }
        }
        break;
    }

    fancyText("Dealer's card value is: " + dealerValue);

    while (/*TO DO: dealer card is less than 17 */){
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
                    ace.remove(0);
                }
                else{
                    break;
                }
            }
            break;
        }
        fancyText("Dealer's card value is: " + dealerValue);
    }

   //conditions of winning or losing
    if(/*TO DO: player hits blackjack and dealer value doesn't equal player value */){
        score = score + (gamble * (3/2));
        fancyText("You win!!");
    }
    else if(/*TO DO: player card is over 21 */){
        score = score - gamble;
        fancyText("You bust!!!");
    }
    else if(/*TO DO: dealer card is over 21 */){
        score = score + gamble;
        fancyText("The dealer busts. You win!!!");
    }
    else if(/*TO DO: player card is more than dealer card */){
        score = score + gamble;
        fancyText("You win!!!");
    }
    else if(/*TO DO: player card is the same as dealer card*/){
        fancyText("YOU TIE!!!");
    }
    else{
        score = score - gamble;
        fancyText("You lose");
    }

}

// for making space between letters
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
