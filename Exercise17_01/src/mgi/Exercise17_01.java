/*
Author-Udean Mbano
MGI2012-3244
Author-Mathew Bate
MGI2012-0983
Date-07/04/2014
Version 14.2
/Purpose: A simple GUI program that can use buttons to move the message left and right and use radio buttons to change the background
color for the message displayed on the panel
 */

package mgi;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;
import mgi.MessagePanel;

public class Exercise17_01 extends JFrame {
   
    private JLabel jlbMessage=new JLabel("Select Message Panel Background",JLabel.LEFT);
   //private JTextField  jlbMessage2=new JTextField("Welcome To Java");
     // Create a panel for displaying message
   private MessagePanel jlbMessage2;
    //five radio buttons to message colors
    private JRadioButton jrbRed = new JRadioButton("Red");
    private JRadioButton jrbYellow = new JRadioButton("Yellow");
    private JRadioButton jrbWhite = new JRadioButton("White");
    private JRadioButton jrbGray = new JRadioButton("Gray");
    private JRadioButton jrbGreen = new JRadioButton("Green");
    //to buttons to move the message
    private JButton jbLeft=new  JButton("<=");
    private JButton jbRight=new  JButton("=>");

    public static void main(String[] args)
    {
        Exercise17_01 frame = new Exercise17_01();
        frame.pack();
        frame.setTitle("Exercise17_01");
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setVisible(true);
       
    }
    public Exercise17_01()
    {
      jlbMessage2 = new MessagePanel("Welcome to Java");
   jlbMessage2.setBackground(Color.yellow);
         jbLeft.setToolTipText("Move message to left");

    jbRight.setToolTipText("Move message to right");
        // add panel to radio buttons
        JPanel jpR = new JPanel();
     jpR.setLayout(new FlowLayout());
        jpR.add(jlbMessage);
        jpR.add(jrbRed);
        jpR.add(jrbYellow);
        jpR.add(jrbWhite);
        jpR.add(jrbGray);
        jpR.add(jrbGreen);
        
        // create a radio button group
        ButtonGroup group=new ButtonGroup();
        
        group.add(jrbRed);
        group.add(jrbYellow);
        group.add(jrbWhite);
        group.add(jrbGray);
        group.add(jrbGreen);
     
        // intial message color
        jrbWhite.setSelected(true);
        jlbMessage2.setBackground(Color.white);
        
        //Create a panel to hold navigation buttons and label
       JPanel jpR2 = new JPanel();
    jpR2.setLayout(new FlowLayout());
       jpR2.add(jlbMessage2);
       JPanel jpR3 = new JPanel();
       jpR3.add(jbLeft);
       jpR3.add(jbRight);
      
       
       //set mnemonics for the radio buttons and navigation buttons
        
     jrbRed.setMnemonic('R');
   jrbYellow.setMnemonic('Y'); 
    jrbWhite.setMnemonic('W');
  jrbGray.setMnemonic('g');
    jrbGreen.setMnemonic('f');
    //to buttons to move the message
    jbLeft.setMnemonic('L');
    jbRight.setMnemonic('R');
        add(jpR,BorderLayout.NORTH);
        add(jpR2);
        add(jpR3,BorderLayout.SOUTH);   
        //register listeners for radio buttons
        // Register listeners with the buttons
 
    jrbRed.addActionListener(new ActionListener(){
    @Override
    public void actionPerformed(ActionEvent e){
         jlbMessage2.setBackground(Color.RED);
    }
    });
    jrbYellow.addActionListener(new ActionListener(){
    @Override
    public void actionPerformed(ActionEvent e){
         jlbMessage2.setBackground(Color.yellow);
    }
    });
    jrbWhite.addActionListener(new ActionListener(){
    @Override
    public void actionPerformed(ActionEvent e){
         jlbMessage2.setBackground(Color.WHITE);
    }
    });
    jrbGray.addActionListener(new ActionListener(){
    @Override
    public void actionPerformed(ActionEvent e){
         jlbMessage2.setBackground(Color.GRAY);
    }
    });
    
     jbLeft.addActionListener(new ActionListener(){
    @Override
    public void actionPerformed(ActionEvent e){
         left();
    }
    });
  
  jbRight.addActionListener(new ActionListener(){
    @Override
    public void actionPerformed(ActionEvent e){
         right();
    }
    });
  
   
    }
  /**Handle button events*/
 
  /**Move the message in the panel left*/
  private void left()
  {
    int x =jlbMessage2.getXCoordinate();
    if (x > 10)
    {
      // Shift the message to the left
     jlbMessage2.setXCoordinate(x-10);
     jlbMessage2.repaint();
    }
  }

  /**Move the message in the panel right*/
  private void right()
  {
    int x =jlbMessage2.getXCoordinate();
    if (x < getSize().width - 20)
    {
      // Shift the message to the right
     jlbMessage2.setXCoordinate(x+10);
     jlbMessage2.repaint();
    }
  }
}