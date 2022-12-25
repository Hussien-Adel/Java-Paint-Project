/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg1;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;

import pkg2.MyPanel;


/**
 *
 * @author hussi
 */
public class MyFrame extends JFrame{
    
          public static void main(String[] args) {
        
        JFrame f = new JFrame();
        
        f.setTitle("Java Paint Program");
        f.setSize(1000, 1000);
        MyPanel mp= new MyPanel();
        f.setContentPane(mp);
        mp.setLayout(null);
         mp.setBounds(10,10,500,500);
        f.setLayout(null);
        f.setVisible(true);
      
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        
    }
}
