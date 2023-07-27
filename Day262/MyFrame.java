package Day262;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class MyFrame extends JFrame {

    JButton myButton = new JButton("MY BUTTON");
    JButton myButton2 = new JButton("MY BUTTON2");

    MyFrame() {

        myButton.setBounds(100, 100, 200, 100);
        myButton.addActionListener((e) -> System.out.println("You clicked MY BUTTON!"));
        myButton2.setBounds(100, 200, 200, 100);
        myButton2.addActionListener((e) -> System.out.println("You clicked MY BUTTON2!"));

        this.add(myButton);
        this.add(myButton2);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(420, 420);
        this.setLayout(null);
        this.setVisible(true);
    }

}
