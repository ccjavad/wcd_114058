package test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

class MyActionListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Angeklickt");
    }
}

public class TestListener {
    
    public static void main(String[] args) {
        
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100, 100, 200, 150);
        frame.setVisible(true);
        
        JButton button = new JButton("Click me");
        frame.add(button);
        
        button.addActionListener(new MyActionListener());
        
    }

}
