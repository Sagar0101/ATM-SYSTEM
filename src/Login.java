

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    JLabel l1,l2,l3;
    JTextField tf1;
    JPasswordField pf2;
    JButton b1,b2,b3,b4;
static String pass;
   static String cardN;

	Login(){
         
setTitle("                                                                                   AUTOMATED TELLER MACHINE");
        
       
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        
        l1 = new JLabel("WELCOME TO ATM");
        l1.setFont(new Font("Osward", Font.BOLD, 38));
        
        l2 = new JLabel("Card No:");
        l2.setFont(new Font("Raleway", Font.BOLD, 28));
        
        l3 = new JLabel("PIN:");
        l3.setFont(new Font("Raleway", Font.BOLD, 28));
        
        tf1 = new JTextField(15);
        pf2 = new JPasswordField(15);
        
        b1 = new JButton("SIGN IN");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        
        b2 = new JButton("CLEAR");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        
        b3 = new JButton("SIGN UP");
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        
        b4 = new JButton("FORGET PIN");
        b4.setBackground(Color.BLACK);
        b4.setForeground(Color.WHITE);
        
        
        
        setLayout(null);
        
        l1.setBounds(175,50,450,200);
        add(l1);
        
        l2.setBounds(125,150,375,200);
        add(l2);
        
        l3.setBounds(125,225,375,200);
        add(l3);
        
        tf1.setFont(new Font("Arial", Font.BOLD, 14));
        tf1.setBounds(300,235,230,30);
        add(tf1);
        
        pf2.setFont(new Font("Arial", Font.BOLD, 14));
        pf2.setBounds(300,310,230,30);
        add(pf2);
        
        b1.setFont(new Font("Arial", Font.BOLD, 14));
        b1.setBounds(300,400,100,30);
        add(b1);
        
        b2.setFont(new Font("Arial", Font.BOLD, 14));
        b2.setBounds(430,400,100,30);
        add(b2);
        
        b3.setFont(new Font("Arial", Font.BOLD, 14));
        b3.setBounds(300,500,230,30);
        add(b3);
        
        
        b4.setFont(new Font("Arial", Font.BOLD, 14));
        b4.setBounds(300,450,230,30);
        add(b4);
        
         
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
           
        setSize(750,720);
        setLocation(10,10);
        
        
        setVisible(true);
        getContentPane().setBackground(Color.WHITE);
        

        
    }
  
    public void actionPerformed(ActionEvent ae){
       
        try{   
        	
        	
        	
        	   conn c1 = new conn();
               cardN = tf1.getText();
             pass  = pf2.getText();
               String q  = " select * from signup where cardN = '"+cardN+"' and pin = '"+pass+"'";
               ResultSet rs = c1.s.executeQuery(q);
               
        	
        	
        	
        	
        	
        	
        	
        	
        	if((ae.getSource()==b1)&&(tf1.getText().equals(""))){
      		  
                JOptionPane.showMessageDialog(null, "Please enter the card number");
            
        	}
        	else	if((ae.getSource()==b1)&&(pf2.getText().equals(""))){
        		  
                JOptionPane.showMessageDialog(null, "Please enter the pin");
            
        	}
        	
        	
        	
        	
         
            else if(ae.getSource()==b1){
                if(rs.next()){
                    new Transcations
                    ();
                    setVisible(false);
                
                }
                else {
                	  
                    JOptionPane.showMessageDialog(null, "card number or Pin is incorrect");
                    tf1.setText("");
                    pf2.setText("");
                }
            }
            
            
            
            
            
            
            else if(ae.getSource()==b2){
                tf1.setText("");
                pf2.setText("");
            }else if(ae.getSource()==b3){
                new Signup().setVisible(true);
                setVisible(false);
            }
        else if(ae.getSource()==b4){
            new forget();
            setVisible(false);
        }
        }catch(Exception e){
                   
                    System.out.println("error: "+e);
        }
            
    }
    
    
    public static void main(String[] args){
       Login l =new Login();
    }

    
}
