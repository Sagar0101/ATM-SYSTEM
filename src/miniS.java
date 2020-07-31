



import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class miniS extends JFrame  implements ActionListener{
    
    JLabel l1,l2,l3,l4,l5,l6,l7,l8;
    String b1,b2;
    JButton b;
    miniS(){

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		try {
			conn c=new conn();
			
			
			String q="Select * from transactions where cardN='"+Login.cardN+"' ORDER BY id DESC LIMIT 5 ";
			
		
			ResultSet rs=c.s.executeQuery(q);
			
	
		
			if(rs.next()){ 
				
				for(int i=1;i<=5;i++) {
					

				if(rs.getString(7)==null) {
					b1="                       ";
					b2="                 ";
				}
				else {
					b1="            ";
					b2="    ";
				
				}
        setTitle("MINI STATEMENT");
        
     
        l1 = new JLabel("YOUR TRANSACTIONS RECORD");
        l1.setFont(new Font("System", Font.CENTER_BASELINE, 35));
        
        
        l2 = new JLabel("DEPOSIT   WITHDRAW   TRANSFER                TO                   DATE AND TIME");
        l2.setFont(new Font("System", Font.BOLD, 20));
      if(i==1) {
         
        l3 = new JLabel("      "+rs.getString(4)+"             "+rs.getString(5)+"                "+rs.getString(6)+""+b1+""+rs.getString(7)+""+b2+""+rs.getString(8));
        l3.setFont(new Font("System", Font.PLAIN, 20));
        l3.setBounds(10,250,800,60);
        add(l3);
        
      }
      else if(i==2){
        l4 = new JLabel("      "+rs.getString(4)+"             "+rs.getString(5)+"                "+rs.getString(6)+""+b1+""+rs.getString(7)+""+b2+""+rs.getString(8));
        l4.setFont(new Font("System", Font.PLAIN, 20));
        l4.setBounds(10,300,800,60);
        add(l4);
     
        
      }
      else if(i==3){
        l5= new JLabel("      "+rs.getString(4)+"             "+rs.getString(5)+"                "+rs.getString(6)+""+b1+""+rs.getString(7)+""+b2+""+rs.getString(8));
        l5.setFont(new Font("System", Font.PLAIN, 20));

        l5.setBounds(10,350,800,60);
        add(l5);
        
      }
      else if(i==4){
        l6 = new JLabel("      "+rs.getString(4)+"             "+rs.getString(5)+"                "+rs.getString(6)+""+b1+""+rs.getString(7)+""+b2+""+rs.getString(8));
        l6.setFont(new Font("System", Font.PLAIN, 20));
        
        l6.setBounds(10,400,800,60);
        add(l6);
      }
       
      else if(i==5){
      l7 = new JLabel("      "+rs.getString(4)+"             "+rs.getString(5)+"                "+rs.getString(6)+""+b1+""+rs.getString(7)+""+b2+""+rs.getString(8));
        l7.setFont(new Font("System", Font.PLAIN, 20));
        l7.setBounds(10,450,800,60);
        add(l7);
       
      }
      rs.next();
			}
				
			}
			else{
				 JOptionPane.showMessageDialog(null, "Record not found");
			        
				
		
			}
			
		}
		catch(Exception e){
			System.out.println(e);
		}
		   setLayout(null);

        b = new JButton("BACK");
        b.setFont(new Font("System", Font.BOLD, 18));
        b.setBackground(Color.BLACK);
        b.setForeground(Color.WHITE);
      
    	
     
       
    	
        setLayout(null);
      
     
        l1.setBounds(130,100,800,60);
        add(l1);
        
        l2.setBounds(10,210,800,60);
        add(l2);
     
        
        
        b.setBounds(300,550,125,50);
        add(b);
       
        
        b.addActionListener(this);
      
        
      
        
        getContentPane().setBackground(Color.WHITE);
    
        setSize(800,720);
        setLocation(10,10);
        setVisible(true);
     
    }
    
    public void actionPerformed(ActionEvent ae){
        
    	  new Transcations().setVisible(true);
          setVisible(false);
          
    }
    public static void main(String[] args){
        new miniS().setVisible(true);
    }
    
}