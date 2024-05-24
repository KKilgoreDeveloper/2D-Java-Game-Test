package main;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame window = new JFrame();
        //Lets user exit window by pressing 'x'
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Makes window unable to be resized
        window.setResizable(false);
        //Window title
        window.setTitle("2D Game Test");
        //centers window location to the middle of the screen
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }
}