public class App {
    public static void main(String[] args) throws Exception {
        int lower = 0;
        int upper = 100;
        // set up the host
        Host myHost = new Host();
        System.out.println("Setting up the host...");
        myHost.setup(lower, upper);
        // set up the player
        System.out.println("Setting up the player");
        Player myPlayer1 = new Player();
        myPlayer1.setup(lower, upper,"Esme" 
        );
        Player myPlayer2 = new Player();
        myPlayer2.setup(lower, upper, "Mike");
        boolean finished = false;; // needs to be outside body of do loop
      
        do {

            System.out.println("Asking " + myPlayer1.name + " for guess");
            int guess = myPlayer1.makeGuess();
            System.out.println("Checking player's guess with host");
            int result = myHost.handleGuess(guess);
            System.out.println("Letting player know outcome");
            myPlayer1.handleResult( result);
            if (result == 0) {
                finished = true;
            } else {
                System.out.println("Asking " + myPlayer2.name + " for guess");
                 guess = myPlayer2.makeGuess();
                System.out.println("Checking player's guess with host");
                result = myHost.handleGuess(guess);
                System.out.println("Letting player know outcome");
                myPlayer2.handleResult( result);
                if (result == 0) {
                    finished = true;
                }   


            }
        } while (! finished);

    }
}
