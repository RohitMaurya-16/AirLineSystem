package airlinemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Home extends JFrame implements ActionListener{
    
    public Home() {
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/front.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0, 0, 1600, 800);
        add(image);
        
        // Main heading
        
JLabel heading = new JLabel("SKYVOYAGE WELCOMES YOU");
heading.setBounds(350, 40, 1000, 60);  // Adjusted height for better spacing
heading.setForeground(new Color(192, 192, 192));
heading.setFont(new Font("Tahoma", Font.BOLD, 60));  // Larger font for heading
image.add(heading);

// Quote 1: Positioned slightly below the main heading
JLabel quote1 = new JLabel("Experience the sky like never before!");
quote1.setBounds(350, 130, 1000, 60);  // Adjusted position and height
quote1.setForeground(new Color(192, 192, 192));  // Silver color
quote1.setFont(new Font("Tahoma", Font.BOLD, 40));  // Slightly smaller font
image.add(quote1);

// Quote 2: Positioned further down, with some extra space
JLabel quote2 = new JLabel("\"Flying high with Air India!\"");
quote2.setBounds(350, 200, 1000, 60);  // Adjusted position
quote2.setForeground(new Color(192, 192, 192));  // Silver color
quote2.setFont(new Font("Tahoma", Font.ITALIC, 35));  // Italic for variety
image.add(quote2);

        JMenuBar menubar = new JMenuBar();
        setJMenuBar(menubar);
        
        JMenu details = new JMenu("Details");
        menubar.add(details);
        
        JMenuItem flightDetails = new JMenuItem("Flight Details");
        flightDetails.addActionListener(this);
        details.add(flightDetails);
        
        JMenuItem customerDetails = new JMenuItem("Add Customer Details");
        customerDetails.addActionListener(this);
        details.add(customerDetails);
        
        JMenuItem bookFlight = new JMenuItem("Book Flight");
        bookFlight.addActionListener(this);
        details.add(bookFlight);
        
        JMenuItem journeyDetails = new JMenuItem("Journey Details");
        journeyDetails.addActionListener(this);
        details.add(journeyDetails);
        
        JMenuItem ticketCancellation = new JMenuItem("Cancel Ticket");
        ticketCancellation.addActionListener(this);
        details.add(ticketCancellation);
        
        JMenu ticket = new JMenu("Ticket");
        menubar.add(ticket);
        
        JMenuItem boardingPass = new JMenuItem("Boarding Pass");
        ticket.add(boardingPass);
        
        
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        String text = ae.getActionCommand();
        
        if (text.equals("Add Customer Details")) {
            new AddCustomer();
        } else if (text.equals("Flight Details")) {
            new FlightInfo();
        } else if (text.equals("Book Flight")) {
            new BookFlight();
        } else if (text.equals("Journey Details")) {
            new JourneyDetails();
        } else if (text.equals("Cancel Ticket")) {
            new Cancel();
        }
        else if (text.equals("Boarding Pass")){
            new BoardingPass();
        }
    }
    
    public static void main(String[] args) {
        new Home();
    }
}
