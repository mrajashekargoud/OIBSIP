import javax.swing.JOptionPane;

public class GuessTheNumber {
    public static void main(String[] args) {
        int minNumber = 1; // minimum number in the range
        int maxNumber = 100; // maximum number in the range
        int maxAttempts = 10; // maximum number of attempts
        int totalRounds = 3; // total number of rounds
        int round = 1; // current round
        int totalScore = 0; // total score
        System.out.println("Welcome to the Guess the Number game!");
        System.out.println("I'm thinking of a number between " + minNumber + " and " + maxNumber + ".");
        while (round <= totalRounds) {
            int randomNumber = (int) (Math.random() * (maxNumber - minNumber + 1) + minNumber); // generate random number
            int attempts = 0; // number of attempts
            int roundScore = 0; // score for the round
            System.out.println("Round " + round + ":");
            while (attempts < maxAttempts) {
                String input = JOptionPane.showInputDialog(null, "Guess the number (or type 'exit' to quit):");
                if (input == null || input.equalsIgnoreCase("exit")) {
                    System.out.println("Thank you for playing the Guess the Number game!");
                    System.out.println("Your final score is " + totalScore + ".");
                    return;
                }
                int guess;
                try {
                    guess = Integer.parseInt(input);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Invalid input. Please enter a number or type 'exit' to quit.");
                    continue;
                }
                attempts++;
                if (guess == randomNumber) {
                    roundScore += (maxAttempts - attempts + 1) * 10; // calculate score for the round
                    totalScore += roundScore; // add round score to total score
                    JOptionPane.showMessageDialog(null, "Congratulations, you guessed the number!\nYou took " + attempts + " attempts to guess the number.\nYour score for this round is " + roundScore + ".\nYour total score so far is " + totalScore + ".");
                    break;
                } else if (guess < randomNumber) {
                    JOptionPane.showMessageDialog(null, "The number is higher than " + guess + ".");
                } else {
                    JOptionPane.showMessageDialog(null, "The number is lower than " + guess + ".");
                }
            }
            if (attempts == maxAttempts) {
                JOptionPane.showMessageDialog(null, "Sorry, you have used all " + maxAttempts + " attempts.\nThe number was " + randomNumber + ".\nYour score for this round is " + roundScore + ".\nYour total score so far is " + totalScore + ".");
            }
            round++;
        }
        JOptionPane.showMessageDialog(null, "Thank you for playing the Guess the Number game!\nYour final score is " + totalScore + ".");
    }
}
