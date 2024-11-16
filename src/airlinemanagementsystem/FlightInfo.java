package airlinemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class FlightInfo extends JFrame {

    public FlightInfo() {
        
        // Set background color and layout for a modern look
        getContentPane().setBackground(new Color(245, 245, 245));  // Light gray background for the window
        setLayout(null);

        // Add a custom title label
        JLabel titleLabel = new JLabel("Flight Information");
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 24));
        titleLabel.setForeground(new Color(45, 45, 45));  // Dark gray color for text
        titleLabel.setBounds(300, 20, 300, 40);  // Position the title
        add(titleLabel);

        // Create table for displaying flight data
        JTable table = new JTable();
        
        // Fetch data from the database and set the table model
        try {
            Conn conn = new Conn();  // Assuming Conn is a class for DB connection
            ResultSet rs = conn.s.executeQuery("SELECT * FROM flight");  // Query to fetch flight data
            table.setModel(DbUtils.resultSetToTableModel(rs));  // Convert ResultSet to table model
        } catch(Exception e) {
            e.printStackTrace();  // Print any errors for debugging
        }
        
        // Style the table for modern appearance
        table.setBackground(Color.WHITE);
        table.setForeground(new Color(45, 45, 45));  // Dark gray text color for table rows
        table.setFont(new Font("Segoe UI", Font.PLAIN, 14));  // Modern font for better readability
        table.setRowHeight(30);  // Increase row height for better readability
        table.setSelectionBackground(new Color(0, 123, 255));  // Blue background when selecting rows
        table.setSelectionForeground(Color.WHITE);  // White text color when a row is selected
        
        // Set alternating row colors for better readability
        table.setDefaultRenderer(Object.class, new javax.swing.table.DefaultTableCellRenderer() {
            public java.awt.Component getTableCellRendererComponent(javax.swing.JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                java.awt.Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                if (row % 2 == 0) {
                    cell.setBackground(new Color(240, 240, 240));  // Light gray background for even rows
                } else {
                    cell.setBackground(Color.WHITE);  // White background for odd rows
                }
                return cell;
            }
        });

        // Create a scroll pane to wrap the table and add it to the frame
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(50, 80, 700, 350);  // Position the scroll pane
        add(jsp);

        // Set window properties
        setSize(800, 500);  // Window size
        setLocation(400, 200);  // Position the window
        setVisible(true);  // Make the window visible
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // Close the app when window is closed
        setTitle("Flight Information");  // Set window title
        setResizable(false);  // Make the window non-resizable for a fixed layout
    }

    public static void main(String[] args) {
        new FlightInfo();  // Create and display the FlightInfo window
    }
}
