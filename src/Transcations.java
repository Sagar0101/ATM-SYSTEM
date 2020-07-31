

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Transcations extends JFrame implements ActionListener{

    JLabel l1;
    JButton b1,b2,b3,b4,b5,b6,b7,b8;
    
    Transcations(){
        
        setTitle("TRANSCATIONS");
        l1 = new JLabel("");
     
                
        try {
        	   conn c1 = new conn();
        	   System.out.println("he1");
            ResultSet rs = c1.s.executeQuery(" SELECT* FROM signup  where cardN = '"+Login.cardN+"' and pin = '"+Login.pass+"'");
            System.out.println("he2");
            rs.next();
            String name = rs.getString("name");
            String gender = rs.getString("gender");	
            name=name.toUpperCase();
            if(gender.equals("Male")){
            
          
            
                l1 = new JLabel("WELCOME MR. "+name);
            }
            else {
                l1 = new JLabel("WELCOME MISS. "+name);
            }
              
            
        } catch (Exception e) {
         
          System.out.println(e);
        
        }
        

     
        l1.setFont(new Font("System", Font.BOLD, 38));
        l1.setHorizontalAlignment(JLabel.CENTER);
        b1 = new JButton("DEPOSIT");
        b1.setFont(new Font("System", Font.BOLD, 18));
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
    
        b2 = new JButton("CASH WITHDRAWL");
        b2.setFont(new Font("System", Font.BOLD, 18));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        
        b3 = new JButton("FAST CASH");
        b3.setFont(new Font("System", Font.BOLD, 18));
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        
        b4 = new JButton("MINI STATEMENT");
        b4.setFont(new Font("System", Font.BOLD, 18));
        b4.setBackground(Color.BLACK);
        b4.setForeground(Color.WHITE);
        
        b5 = new JButton("PIN CHANGE");
        b5.setFont(new Font("System", Font.BOLD, 18));
        b5.setBackground(Color.BLACK);
        b5.setForeground(Color.WHITE);
        
        b6 = new JButton("BALANCE ENQUIRY");
        b6.setFont(new Font("System", Font.BOLD, 18));
        b6.setBackground(Color.BLACK);
        b6.setForeground(Color.WHITE);
        
        b7 = new JButton("LOG OUT");
        b7.setFont(new Font("System", Font.BOLD, 18));
        b7.setBackground(Color.BLACK);
        b7.setForeground(Color.WHITE);
        
        
        b8 = new JButton("TRANSFER");
        b8.setFont(new Font("System", Font.BOLD, 18));
        b8.setBackground(Color.BLACK);
        b8.setForeground(Color.WHITE);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        
        l1.setBounds(0,100,700,40);
        l1.setHorizontalAlignment(JLabel.CENTER);
        l1.setBounds(50,100,700,40);
        add(l1);
        
        b1.setBounds(40,250,300,60);
        add(b1);
        
        b2.setBounds(440,250,300,60);
        add(b2);
        
        b3.setBounds(40,360,300,60);
        add(b3);
        
        b4.setBounds(440,360,300,60);
        add(b4);
        
        b5.setBounds(40,470,300,60);
        add(b5);
        
        b6.setBounds(440,470,300,60);
        add(b6);
        
        b7.setBounds(440,580,300,60);
        add(b7);
        
        b8.setBounds(40,580,300,60);
        add(b8);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        b8.addActionListener(this);
        
        
        getContentPane().setBackground(Color.WHITE);
 
        setSize(800,720);
        setLocation(10,10);
        setVisible(true);
        
        
        
    }
    
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource()==b1){ 
            
            new Deposit().setVisible(true);
            setVisible(false);
            
        }
        else if(ae.getSource()==b2){ 
            setVisible(false);
            new Withdrawl();
        
            
        }
        else if(ae.getSource()==b3){ 
            
            new FastCash();
            setVisible(false);
            
        }else if(ae.getSource()==b4){ 
      
           
        try {
			
			  conn c1 = new conn();
		         
		         PreparedStatement pst = c1.c.prepareStatement("select * from transactions where cardN = '"+Login.cardN+"' and pin = '"+Login.pass+"' limit 37");

		        ResultSet rs = pst.executeQuery();
		        if(rs.next()) {
		        	setVisible(false);
		        	new	Mini();
		        }
		        else {
		        	 JOptionPane.showMessageDialog(null,"Record Not Found");
		             
		        }
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
                
        }
else if(ae.getSource()==b5){ 
	 new Pin();
     setVisible(false);
     
}
        
        
        
        
        else if(ae.getSource()==b6){ 
            
           
            conn c1 = new conn();
                    
            try {
                
                ResultSet rs = c1.s.executeQuery(" SELECT amount FROM signup  where cardN = '"+Login.cardN+"' and pin = '"+Login.pass+"'");
                
                if(rs.next()){
                
                String balance = rs.getString("amount");
                
                JOptionPane.showMessageDialog(null,"Your Account Balance is "+balance);
                
                }
                
                  
                
            } catch (Exception e) {
             
                e.printStackTrace();
            
            }
            
  
                    
            
        }else if(ae.getSource()==b7){ 
            
     setVisible(false);
            new Login();
            
        }
        else if(ae.getSource()==b8){ 
        	
            setVisible(false);
            new Transfer();
                   
               }
               
            
        
        
    }
    
    public static void main(String[] args){
        new Transcations().setVisible(true);
    }
}
