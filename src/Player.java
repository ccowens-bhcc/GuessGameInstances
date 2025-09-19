public class Player {
    // Keep track of the range over which I'm guessing
    int lowerBound; // I know the secret is greater than this
    int upperBound; // I know the secret is less than this
    int guess; // remember my last guess
    String name;
    // Each player will guess randomly for the first guess, 
    // and then guess optimally, by splitting the range
    boolean firstGuess = true;
    
    // This could be done in a constructor, but we aren't there yet.
    public void setup(int lower, int upper, String name) {
        lowerBound = lower;
        upperBound = upper;
        this.name = name;
}
    public  int makeGuess() {
        if (firstGuess) {
            int range = (upperBound - lowerBound) - 1; // there are 99 numbers between 0 and 100
            guess = (int) (Math.random() * range + 1);
            firstGuess = false;   
        } else {
        guess = (lowerBound + upperBound) / 2; // truncates to int
         
        }
        System.out.println(name + " guesses: " + guess);
        return guess;  
    }

    public  void handleResult(int result) {
        if (result < 0) { // Guess was too low
            lowerBound = guess;
            System.out.println(name + " will guess higher next time...");
        } else if (result > 0) { // Guess was too high
            upperBound = guess;
            System.out.println(name + " will guess lower next time...");
        } else {
            System.out.println(name + "Yay! I'm a winner!");
        }
    }
}
