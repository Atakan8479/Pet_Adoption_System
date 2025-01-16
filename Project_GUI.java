package Project_Java;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Project_GUI {

    public static void main(String[] args) {
        
    	
    		
        JFrame frame = new JFrame("Pet Adoption System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        
        // Logo image
        ImageIcon image = new ImageIcon("Logo.png"); 
        Image scaledImage = image.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon scaledIcon = new ImageIcon(scaledImage); 
        
        JLabel displayField = new JLabel(scaledIcon);
        displayField.setBounds(15, 25, 175, 300);
        frame.add(displayField);
        
        // Creating the buttons
        JButton displayAllButton = new JButton("Display All");
        displayAllButton.setBounds(200, 25, 600, 40); 
        displayAllButton.setBackground(Color.BLUE);     
        displayAllButton.setForeground(Color.BLACK);
        
        JButton displayAverageAgeButton = new JButton("Display Average Age");
        displayAverageAgeButton.setBounds(200, 70, 600, 40); 
        displayAverageAgeButton.setBackground(Color.BLUE);     
        displayAverageAgeButton.setForeground(Color.BLACK);
        
        JButton displayAverageWeight = new JButton("Display Average Weight");
        displayAverageWeight.setBounds(200, 115, 600, 40); 
        displayAverageWeight.setBackground(Color.BLUE);     
        displayAverageWeight.setForeground(Color.BLACK);
        
        JButton displayAverageDaysSpendInShelter = new JButton("Display Average Days Spend in Shelter");
        displayAverageDaysSpendInShelter.setBounds(200, 160, 600, 40); 
        displayAverageDaysSpendInShelter.setBackground(Color.BLUE);     
        displayAverageDaysSpendInShelter.setForeground(Color.BLACK);
        
        JButton displayAdoptionFee = new JButton("Display Average Fee");
        displayAdoptionFee.setBounds(200, 205, 600, 40); 
        displayAdoptionFee.setBackground(Color.BLUE);     
        displayAdoptionFee.setForeground(Color.BLACK);
        
        JButton displayMostWeightedPets = new JButton("Display Most Number of Pets");
        displayMostWeightedPets.setBounds(200, 250, 600, 40); 
        displayMostWeightedPets.setBackground(Color.BLUE);     
        displayMostWeightedPets.setForeground(Color.BLACK);
        
        JButton displayIntervalWeightedPets = new JButton("Display Oldest and Youngest Pets");
        displayIntervalWeightedPets.setBounds(200, 295, 600, 40); 
        displayIntervalWeightedPets.setBackground(Color.BLUE);     
        displayIntervalWeightedPets.setForeground(Color.BLACK);
        
        // Text Area inside a JScrollPane for displaying output
        JTextArea outputArea = new JTextArea();
        outputArea.setEditable(false);
        JScrollPane scroll = new JScrollPane(outputArea);
        scroll.setBounds(15, 350, 800, 300);
        scroll.setBackground(Color.LIGHT_GRAY);
        frame.add(scroll);
        
        // Action listeners for button clicks
        displayAllButton.addActionListener(new ActionListener() {
        	@Override
			public void actionPerformed(ActionEvent e) {
        		String pets = PetData.displayPets();
        		outputArea.setText(pets);
			}
        	
        });
        
        displayAverageAgeButton.addActionListener(new ActionListener() {
        	@Override
			public void actionPerformed(ActionEvent e) {
        		String averageAge = null;
				try {
					averageAge = (String) Get_Average.displayAverageAge();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
        		outputArea.setText(averageAge);
			}
        	
        });
        
        displayAverageWeight.addActionListener(new ActionListener() {
        	@Override
			public void actionPerformed(ActionEvent e) {
        		String averageWeight = null;
				try {
					averageWeight = (String) Get_Average.displayAverageWeight();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
        		outputArea.setText(averageWeight);
			}
        	
        });
        
        displayAverageDaysSpendInShelter.addActionListener(new ActionListener() {
        	@Override
			public void actionPerformed(ActionEvent e) {
        		String averageDays = null;
				try {
					averageDays = (String) Get_Average.displayAverageDaysSpendInShelter();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
        		outputArea.setText(averageDays);
			}
        	
        });
        
        displayAdoptionFee.addActionListener(new ActionListener() {
        	@Override
			public void actionPerformed(ActionEvent e) {
        		String averageFee = null;
				try {
					averageFee = (String) Get_Average.displayAdoptionFee();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
        		outputArea.setText(averageFee);
			}
        	
        });
        
        displayMostWeightedPets.addActionListener(new ActionListener() {
        	@Override
			public void actionPerformed(ActionEvent e) {
        		String mostWeighted = null;
        		String inputText = JOptionPane.showInputDialog(frame, "Enter the number of heaviest pets:");
				try {
					mostWeighted = (String) Get_Average.displayMostWeightedPets(inputText);
					outputArea.setText(mostWeighted);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
        	
        });
        
        displayIntervalWeightedPets.addActionListener(new ActionListener() {
        	@Override
			public void actionPerformed(ActionEvent e) {
        		String mostIntervalWeighted = null;
        		String inputText1 = JOptionPane.showInputDialog(frame, "Enter the number of oldest pets:");
        		String inputText2 = JOptionPane.showInputDialog(frame, "Enter the number of youngest pets:");
				try {
					mostIntervalWeighted = (String) Get_Average.displayIntervalWeightedPets(inputText1, inputText2);
					outputArea.setText(mostIntervalWeighted);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
        	
        });
        
        // Adding buttons to the frame
        frame.add(displayAllButton); 
        frame.add(displayAverageAgeButton);
        frame.add(displayAverageWeight);
        frame.add(displayAverageDaysSpendInShelter);
        frame.add(displayAdoptionFee);
        frame.add(displayMostWeightedPets);
        frame.add(displayIntervalWeightedPets);
        
        frame.setSize(850, 700);
        frame.setVisible(true);
        
    	
    }
}
