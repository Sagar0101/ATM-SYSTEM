

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Deposit extends JFrame implements ActionListener{
    
    JTextField t1,t2;
    JButton b1,b2,b3;
    JLabel l1,l2,l3;
	int am ;
    
    Deposit(){
 
        setTitle("DEPOSIT");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        l1 = new JLabel("ENTER AMOUNT YOU WANT");
        l1.setFont(new Font("System", Font.BOLD, 35));
        
        l2 = new JLabel("TO DEPOSIT");
        l2.setFont(new Font("System", Font.BOLD, 35));
     
        t1 = new JTextField();
        t1.setFont(new Font("Raleway", Font.BOLD, 22));
       
        b1 = new JButton("DEPOSIT");
        b1.setFont(new Font("System", Font.BOLD, 18));
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
    
        b2 = new JButton("BACK");
        b2.setFont(new Font("System", Font.BOLD, 18));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
      
    	
        setLayout(null);
       
        
       
        l1.setBounds(150,150,800,60);
        add(l1);
        
        l2.setBounds(290,210,800,60);
        add(l2);
        
        t1.setBounds(250,300,300,50);
        add(t1);
        
        b1.setBounds(260,380,125,50);
        add(b1);
        
        b2.setBounds(415,380,125,50);
        add(b2);
       
        
        b1.addActionListener(this);
        b2.addActionListener(this);
       
        
        getContentPane().setBackground(Color.WHITE);
        
    
        
        setSize(800,720);
        setLocation(10,10);
        setVisible(true);
     
    }
    
    public void actionPerformed(ActionEvent ae){
    

      	 String adr="^[0-9\\-]*$";
       	Pattern paa=Pattern.compile(adr); 
       	Matcher post= paa.matcher(t1.getText());
       	

       		
    	
    	
    	
    	
    	
    	
    	try {   
    	String a=t1.getText();
    		am=Integer.parseInt(a);
    	    	
	       
		 }catch(Exception e){
			System.out.println(e);
		 }
    	
    	
    	
    	
    	  try{
    	if((ae.getSource()==b1)&&(t1.getText().equals(""))){
    		  
            JOptionPane.showMessageDialog(null, "Please enter the Amount to you want to Deposit");
        
    	}
    	else if((ae.getSource()==b1)&&(post.matches()==false)){
  		  
            JOptionPane.showMessageDialog(null, "Please enter only numric values for amount");
            t1.setText("");
        
    	}
    	
    	
    	
    	else if ((ae.getSource()==b1)&&(am<100||am>1000000)) {
    		JOptionPane.showMessageDialog(null, "Amount should be greater than 100 and \nless than 1000000 rupees at atime which you want to Deposit");
    		  t1.setText("");
    	}
    	
              
    	else if(ae.getSource()==b2){
            
            new Transcations().setVisible(true);
            setVisible(false);
            
        }
        	
        	
        else if(ae.getSource()==b1){
        	
            String a = t1.getText();
           
            int foo = Integer.parseInt(a);
            
            
                    
                    conn c1 = new conn();
                   System.out.println(Login.pass);
                
                  
                  
                   
                  String s=  "select * from signup where cardN = '"+Login.cardN+"' and pin = '"+Login.pass+"' ";
                  ResultSet rs=c1.s.executeQuery(s);
              rs.next();
                  int i=  rs.getInt(18);
                 
                  System.out.println(i);
                 i=i+foo;
                  
                    String q1= "UPDATE `signup` SET `amount`='"+i+"'  where cardN = '"+Login.cardN+"' and pin = '"+Login.pass+"' ";
                    c1.s.executeUpdate(q1);
                    

                     
                   
                String d =   " INSERT INTO `transactions`(`cardN`, `pin`, `deposit`,`dateT`) VALUES ('"+Login.cardN+"','"+Login.pass+"','"+foo+"','"+CurrentDate.date()+"')";
                c1.s.executeUpdate(d);
                    
                    
                   JOptionPane.showMessageDialog(null, "Rs. "+a+" Deposited Successfully");
                    setVisible(false);
                    new Transcations();
                  
                    
                    
                    
                }
        }
            
        catch(Exception e){
                e.printStackTrace();
                System.out.println("error: "+e);
        }
            
    }
    
    public static void main(String[] args){
        new Deposit().setVisible(true);
    }
    
}