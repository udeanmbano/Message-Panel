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
// MessagePanel.java: Display a message on a JPanel
package mgi;

import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

public class MessagePanel extends JPanel
{
  /**The message to be displayed*/
  private String message = "Welcome to Java";

  /**The x coordinate where the message is displayed*/
  private int xCoordinate = 20;

  /**The y coordinate where the message is displayed*/
  private int yCoordinate = 20;

  /**Indicate whether the message is displayed in the center*/
  private boolean centered;

  /**Default constructor*/
  public MessagePanel()
  {
  }

  /**Constructor with a message parameter*/
  public MessagePanel(String message)
  {
    this.message = message;
  }

  /**Return message*/
  public String getMessage()
  {
    return message;
  }

  /**Set a new message*/
  public void setMessage(String message)
  {
    this.message = message;
  }

  /**Return xCoordinator*/
  public int getXCoordinate()
  {
    return xCoordinate;
  }

  /**Set a new xCoordinator*/
  public void setXCoordinate(int x)
  {
    this.xCoordinate = x;
  }

  /**Return yCoordinator*/
  public int getYCoordinate()
  {
    return yCoordinate;
  }

  /**Set a new yCoordinator*/
  public void setYCoordinate(int y)
  {
    this.yCoordinate = y;
  }

  /**Return centered*/
  public boolean isCentered()
  {
    return centered;
  }

  /**Set a new centered*/
  public void setCentered(boolean centered)
  {
    this.centered = centered;
  }

  /**Paint the message*/
  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);

    if (centered)
    {
      // Get font metrics for the current font
      FontMetrics fm = g.getFontMetrics();

      // Find the center location to display
      int w = fm.stringWidth(message);  // Get the string width
      // Get the string height, from top to the baseline
      int h = fm.getAscent();
      xCoordinate = getWidth()/2-w/2;
      yCoordinate = getHeight()/2+h/2;
    }

    g.drawString(message, xCoordinate, yCoordinate);
  }

  /**Override get method for preferredSize*/
  public Dimension getPreferredSize()
  {
    return new Dimension(200, 100);
  }

  /**Override get method for minimumSize*/
  public Dimension getMinimumSize()
  {
    return new Dimension(200, 100);
  }
}