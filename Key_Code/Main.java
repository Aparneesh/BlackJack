package Key_Code;
import java.util.Scanner;


public class Main{
    
    public static void main(String[] args){
       Game game = new Game();
       boolean runGame = true;
       Scanner sc = new Scanner(System.in);

       
       fancyText("▒█░░▒█ █▀▀ █░░ █▀▀ █▀▀█ █▀▄▀█ █▀▀ 　 ▀▀█▀▀ █▀▀█ 　 ▒█▀▀█ █░░ █▀▀█ █▀▀ █░█ ░░░▒█ █▀▀█ █▀▀ █░█ ");
       fancyText("▒█▒█▒█ █▀▀ █░░ █░░ █░░█ █░▀░█ █▀▀ 　 ░▒█░░ █░░█ 　 ▒█▀▀▄ █░░ █▄▄█ █░░ █▀▄ ░▄░▒█ █▄▄█ █░░ █▀▄");
       fancyText("▒█▄▀▄█ ▀▀▀ ▀▀▀ ▀▀▀ ▀▀▀▀ ▀░░░▀ ▀▀▀ 　 ░▒█░░ ▀▀▀▀ 　 ▒█▄▄█ ▀▀▀ ▀░░▀ ▀▀▀ ▀░▀ ▒█▄▄█ ▀░░▀ ▀▀▀ ▀░▀");

       fancyTitle("In this version, you are given $100 to begin with. You can gamble any amount fit but your goal is turn that intial amount to $1000. You can take as many turns as you want, but if you reach $0, you lose. Without a further delay, let's GAMBLE!!!! (18+ only please or else I'll get in trouble)                                                    \033[H\033[2J");


       //asks the player if they want to play again
       while(runGame == true){
            game.playGame();
            fancyTitle("Do you want to play again?\n[1]Yes\n[2]No ");
            String play = sc.next();
            if(play.equals("1")){
                runGame = true;
            }
            else if(play.equals("2")){
                fancyTitle("Okay! Have a great day! (Also, please don't report me)");
                runGame = false;
            }
            else{
                fancyTitle("If you want to be such a cringe human being, then I guess you don't deserve to play again.");
                runGame = false;
            }
       }
       


    }




    //makes it so that there is a time of 10 milliseconds between each letter
    //thanks to frank norris
    private static void fancyText(String text){
        for (char c : text.toCharArray()){
        System.out.print(c);
        try{
            Thread.sleep(10);
        } catch (Exception e){}
        }
        System.out.print("\n");
    }



    //makes it so that there is a time of 75 milliseconds between each letter
    //thanks to frank norris
    private static void fancyTitle(String text){
        for (char c : text.toCharArray()){
        System.out.print(c);
        try{
            Thread.sleep(75);
        } catch (Exception e){}
        }
    }

}






