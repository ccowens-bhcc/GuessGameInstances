public class Host {
    int upperBound; // secret will be less than this
    int lowerBound; // secret will be greater than this
    int secret;

    // This could be done in a constructor but we aren't there yet...
    // set up the game; pick a secret; announce what you're doing
    public void setup(int lower, int upper) {
        lowerBound = lower;
        upperBound = upper;
        int range = (upper - lower) - 1; // there are 99 numbers between 0 and 100
        secret = (int) (Math.random() * range + 1); 
        System.out.println("Host: I'm thinking of a number greater than " + lower);
        System.out.println("Host: and less than " + upper);
    }
    // For testing, force the secret
    public void forceSecret(int s) {
        secret = s;
        System.out.println("Host: Secret is now forced to " + s);
    }

    // Handle the player's guess. Tell player too low, too high, or got it
    // and return -1 if too low, 0 if got it, or +1 if too high
    public int handleGuess(int guess) {
        System.out.print("Host: You guessed " + guess + "...");
        if (guess < secret) {
            System.out.println(" Too low!");
            return -1;
        } else if (guess > secret) {
            System.out.println(" Too high!");
            return 1;
        } else {
            System.out.println(" You guessed it!");
            return 0;
        }
    }

    
}
