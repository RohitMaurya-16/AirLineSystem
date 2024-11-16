package airlinemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import net.proteanit.sql.DbUtils;

public class JourneyDetails extends JFrame implements ActionListener {

    JTable table;
    JTextField pnr;
    JButton show;

    public JourneyDetails() {
        // Set a light, pleasant background color for the window
        getContentPane().setBackground(new Color(240, 248, 255));  // Light Alice Blue background
        setLayout(null);

        // Title for PNR Details with improved font styling
        JLabel lblpnr = new JLabel("PNR Details");
        lblpnr.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblpnr.setBounds(50, 50, 150, 25);
        lblpnr.setForeground(new Color(0, 51, 102));  // Dark blue for the label
        add(lblpnr);

        // PNR TextField with a modern look and matching color scheme
        pnr = new JTextField();
        pnr.setBounds(160, 50, 250, 30);
        pnr.setFont(new Font("Arial", Font.PLAIN, 16));  // Larger, clear font
        pnr.setBorder(BorderFactory.createLineBorder(new Color(70, 130, 180)));  // Steel blue border
        pnr.setBackground(new Color(255, 255, 255));  // White background
        add(pnr);

        // Show Details Button with matching color and modern design
        show = new JButton("Show Details");
        show.setBackground(new Color(70, 130, 180));  // Steel blue background
        show.setForeground(Color.WHITE);  // White text for contrast
        show.setBounds(420, 50, 150, 30);  // Positioned beside the PNR text field
        show.setFont(new Font("Arial", Font.BOLD, 16));  // Larger font size for the button
        show.setFocusPainted(false);  // Remove default focus highlight
        show.setBorder(BorderFactory.createLineBorder(new Color(70, 130, 180)));  // Matching border
        show.addActionListener(this);
        add(show);

        // Table setup - JScrollPane with modern styling and border
        table = new JTable();
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(50, 100, 700, 350);  // Adjusted position and size for the table
        jsp.setBackground(new Color(255, 255, 255));  // White background for the table
        jsp.setBorder(BorderFactory.createLineBorder(new Color(70, 130, 180), 2));  // Steel blue border around the table
        add(jsp);

        // Frame setup
        setSize(800, 600);  // Set window size
        setLocation(400, 150);  // Center the window
        setVisible(true);  // Make the window visible
        setTitle("Journey Details");  // Title for the window
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // Close the app when the window is closed
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        try {
            // Fetch data from the database using the entered PNR
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from reservation where PNR = '" + pnr.getText() + "'");

            if (!rs.isBeforeFirst()) {
                JOptionPane.showMessageDialog(null, "No Information Found");
                return;
            }
            // Set the data from the result set into the table
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new JourneyDetails();  // Run the program
    }
}
