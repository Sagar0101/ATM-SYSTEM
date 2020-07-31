

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;

public class Signup3 extends JFrame implements ActionListener{
    
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11;
    JRadioButton r1,r3,r4,r5;
    ButtonGroup bG = new ButtonGroup();  
    ButtonGroup bG1 = new ButtonGroup();
    
    
    JButton b1,b2;
    
    JCheckBox c1,c2,c6,c7;
	JComboBox c5;
	JComboBox c4;
	JComboBox c3;
    JTextField t1;
    
 int  amount=0;
  static  long first8;
  static long first4;
    
    Signup3(){
     
    	
    	
    	
    	  
        Random ran = new Random();
        long first7 = (ran.nextLong() % 90000000L) + 5040936000000000L;
     
        
        first8 = Math.abs(first7);
        
        long first3 = (ran.nextLong() % 9000L) + 1000L;
        first4 = Math.abs(first3);
    	
    	
    	
    	
    	
        setTitle("NEW ACCOUNT APPLICATION FORM");
    
        
        l1 = new JLabel("Additonal Details");
        l1.setFont(new Font("Raleway", Font.BOLD, 22));
        
        l2 = new JLabel("Account Type:");
        l2.setFont(new Font("Raleway", Font.BOLD, 18));
        
        l4 = new JLabel("Income:");
        l4.setFont(new Font("Raleway", Font.BOLD, 18));
        
  
        l5 = new JLabel("Educational");
        l5.setFont(new Font("Raleway", Font.BOLD, 18));
        
        
        l6 = new JLabel("Occupation:");
        l6.setFont(new Font("Raleway", Font.BOLD, 18));
        
        
        l9 = new JLabel("Senior Citizen:");
        l9.setFont(new Font("Raleway", Font.BOLD, 18));
        
        b1 = new JButton("Submit");
        b1.setFont(new Font("Raleway", Font.BOLD, 14));
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        
        b2 = new JButton("Cancel");
        b2.setFont(new Font("Raleway", Font.BOLD, 14));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        
        r1 = new JRadioButton("Saving Account");
        r3 = new JRadioButton("Current Account");
       
       
       
       
       
       
       bG.add(r1);
       bG.add(r3);
       
     
     
     
       
      
        
       r4 = new JRadioButton("Yes");
       r5 = new JRadioButton("No");
      
      
      
      
      
      
      bG1.add(r4);
      bG1.add(r5);
      
    
        
        String income[] = {"Null","<1,50,000","<2,50,000","<5,00,000","Upto 10,00,000","Above 10,00,000"};
        c3 = new JComboBox(income);
        c3.setBackground(Color.WHITE);
        c3.setFont(new Font("Raleway", Font.BOLD, 14));
        
        
        String education[] = {"Non-Graduate","Graduate","Post-Graduate","Doctrate","Others"};
        c4 = new JComboBox(education);
        c4.setBackground(Color.WHITE);
        c4.setFont(new Font("Raleway", Font.BOLD, 14));
        
        String occupation[] = {"Salaried","Self-Employmed","Business","Student","Retired","Others"};
        c5 = new JComboBox(occupation);
        c5.setBackground(Color.WHITE);
        c5.setFont(new Font("Raleway", Font.BOLD, 14));
       
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        
      
        
        
        l1.setBounds(280,50,400,40);
        add(l1); 
        
        l2.setBounds(100,140,200,30);
        add(l2);
        l4.setBounds(100,230,100,30);
        add(l4);
        
        
       
        l5.setBounds(100,300,150,30);
        add(l5);
        
        
        r1.setBounds(100,180,150,30);
        add(r1);
        
        l9.setBounds(100,490,150,30);
        add(l9);
        
        r3.setBounds(300,180,250,30);
        add(r3);
        
        c3.setBounds(310,240,320,30);
        add(c3);
    
        c4.setBounds(310,300,320,30);
        add(c4);
        
        
        l6.setBounds(100,360,150,30);
        add(l6);
        
        
        c5.setBounds(310,360,320,30);
        add(c5);
        
        
        r4.setBounds(350,490,100,30);
        add(r4);
        
        r5.setBounds(460,490,100,30);
        add(r5);
       
        
        b1.setBounds(300,550,100,30);
        add(b1);
        
        b2.setBounds(420,550,100,30);
        add(b2);
        
        
          
        
        setSize(850,760);
        setLocation(4,5);
        
        setVisible(true);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        
    }
    
    public void actionPerformed(ActionEvent ae){
    	  
    	
    	
    	
    	
    	
    	
    	
    	
    	String c = (String)c3.getSelectedItem();
    	   String d = (String)c4.getSelectedItem();
           String e = (String)c5.getSelectedItem();
           
        String a = "";
        if(r1.isSelected()){ 
            a = "Saving Account";
        }
       
        else if(r3.isSelected()){ 
            a = "Current Account";
        }
        
        
        String h="";
        if(r4.isSelected()){ 
            h = "Yes";
        }
        else if(r5.isSelected()){ 
            h = "No";
        }
        
      
        
        
        if(ae.getSource()==b2){
            System.exit(0);
        }
        else if  (ae.getSource()==b1&&a.equals("")) {
        	JOptionPane.showMessageDialog(null, "Please select account type");
            
        }
        else if  (ae.getSource()==b1&&c.equals("Null")) {
        	JOptionPane.showMessageDialog(null, "Please select your income");
            
        }
        else if  (ae.getSource()==b1&&h.equals("")) {
        	JOptionPane.showMessageDialog(null, "Please select senior citizen yes or no");
            
        }
        
  
    
    
    else  if(ae.getSource()==b1){
               
    	  try{     
                    conn c1 = new conn();
                    String q2 = "insert into signup values("+Signup.q1+"'"+a+"','"+c+"','"+d+"','"+e+"','"+h+"','"+first8+"','"+first4+"', '"+amount+"'  ) ";  
                   
                    
                    c1.s.executeUpdate(q2);
                   
                    JOptionPane.showMessageDialog(null, "Your account is successfully created. \nCard Number: " + first8 + "\n Pin:"+ first4);
                    setVisible(false);
    	    new IDeposit();
    	    }
            
    catch(Exception ex){
                ex.printStackTrace();}
         
    } 
        
        }

    
    
    public static void main(String[] args){
        new Signup3().setVisible(true);
    }
    
}