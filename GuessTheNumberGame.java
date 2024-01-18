import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class GuessTheNumberGame extends JFrame {
    private int secretNumber;
    private JTextField guessTextField;
    private JLabel resultLabel;

    public GuessTheNumberGame() {
        // Set up the JFrame
        super("Guess the Number Game");
        setSize(400, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Generate a random number between 1 and 100
        Random random = new Random();
        secretNumber = random.nextInt(100) + 1;

        // Set up the UI components
        guessTextField = new JTextField(10);
        JButton guessButton = new JButton("Guess");
        guessButton.addActionListener(new GuessButtonListener());

        resultLabel = new JLabel("Guess a number between 1 and 100");

        // Add components to the JFrame
        setLayout(new FlowLayout());
        add(guessTextField);
        add(guessButton);
        add(resultLabel);
    }

    private class GuessButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                int userGuess = Integer.parseInt(guessTextField.getText());

                if (userGuess == secretNumber) {
                    resultLabel.setText("Congratulations! You guessed the correct number.");
                    guessTextField.setEditable(false);
                } else if (userGuess < secretNumber) {
                    resultLabel.setText("Try again. The number is higher.");
                } else {
                    resultLabel.setText("Try again. The number is lower.");
                }
            } catch (NumberFormatException ex) {
                resultLabel.setText("Invalid input. Please enter a number.");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GuessTheNumberGame game = new GuessTheNumberGame();
            game.setVisible(true);
        });
    }
}

