public class Main{
    
    public static void main(String[] args){
       Game game = new Game();
       Dealer deal = new Dealer();

       
       fancyText("▒█░░▒█ █▀▀ █░░ █▀▀ █▀▀█ █▀▄▀█ █▀▀ 　 ▀▀█▀▀ █▀▀█ 　 ▒█▀▀█ █░░ █▀▀█ █▀▀ █░█ ░░░▒█ █▀▀█ █▀▀ █░█ ");
       fancyText("▒█▒█▒█ █▀▀ █░░ █░░ █░░█ █░▀░█ █▀▀ 　 ░▒█░░ █░░█ 　 ▒█▀▀▄ █░░ █▄▄█ █░░ █▀▄ ░▄░▒█ █▄▄█ █░░ █▀▄");
       fancyText("▒█▄▀▄█ ▀▀▀ ▀▀▀ ▀▀▀ ▀▀▀▀ ▀░░░▀ ▀▀▀ 　 ░▒█░░ ▀▀▀▀ 　 ▒█▄▄█ ▀▀▀ ▀░░▀ ▀▀▀ ▀░▀ ▒█▄▄█ ▀░░▀ ▀▀▀ ▀░▀");

       fancyTitle("In this version, you are given $100 to begin with. You can gamble any amount fit but your goal is turn that intial amount to $1000. You can take as many turns as you want, but if you reach $0, you lose. Without a further delay, let's GAMBLE!!!! (18+ only please or else I get in trouble)                                                    \033[H\033[2J");

       game.playGame();
    }




    private static void fancyText(String text){
        for (char c : text.toCharArray()){
        System.out.print(c);
        try{
            Thread.sleep(10);
        } catch (Exception e){}
        }
        System.out.print("\n");
    }




    private static void fancyTitle(String text){
        for (char c : text.toCharArray()){
        System.out.print(c);
        try{
            Thread.sleep(75);
        } catch (Exception e){}
        }
    }

}






