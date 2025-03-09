import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleSwingApp {
    public static void main(String[] args) {
        // Create a frame (window)
        JFrame frame = new JFrame("Simple Swing Application");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a button
        JButton button = new JButton("Click Me!");
        // Create a label
        JLabel label = new JLabel("Hello, welcome to Swing!", SwingConstants.CENTER);

        // Set layout for the frame
        frame.setLayout(new java.awt.BorderLayout());

        // Add button and label to the frame
        frame.add(button, java.awt.BorderLayout.SOUTH);
        frame.add(label, java.awt.BorderLayout.CENTER);

        // Add action listener to the button
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setText("Button clicked!");
            }
        });

        // Set frame to be visible
        frame.setVisible(true);
    }
}
