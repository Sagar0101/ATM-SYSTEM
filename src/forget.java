



	import java.awt.*;
	import java.awt.event.*;
	import javax.swing.*;
	
	import java.sql.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

	public class forget extends JFrame implements ActionListener{
	    JLabel l1,l2,l3;
	    JTextField tf1,tf2;
	    
	    JButton b1,b2,b3,b4;
	
		forget(){
	         
	setTitle("FORGET PIN");
	        
	       
	       
	        
	        
	        
	        l1 = new JLabel("Enter Your Card Num & Email");
	        l1.setFont(new Font("Osward", Font.BOLD, 38));
	        
	        l2 = new JLabel("Card No:");
	        l2.setFont(new Font("Raleway", Font.BOLD, 28));
	        
	        l3 = new JLabel("email:");
	        l3.setFont(new Font("Raleway", Font.BOLD, 28));
	        
	        tf1 = new JTextField(15);
	        tf2 = new JTextField(15);
	        

	        b1 = new JButton("BACK");
	        b1.setBackground(Color.BLACK);
	        b1.setForeground(Color.WHITE);
	        
	        
	        b4 = new JButton("SEND PIN");
	        b4.setBackground(Color.BLACK);
	        b4.setForeground(Color.WHITE);
	        
	        
	        
	        setLayout(null);
	        
	        l1.setBounds(100,50,1000,200);
	        add(l1);
	        
	        l2.setBounds(125,150,375,200);
	        add(l2);
	   
	        l3.setBounds(125,225,375,200);
	        add(l3);
	        
	        tf1.setFont(new Font("Arial", Font.BOLD, 14));
	        tf1.setBounds(300,235,230,30);
	        add(tf1);
	        
	        tf2.setFont(new Font("Arial", Font.BOLD, 14));
	        tf2.setBounds(300,310,230,30);
	        add(tf2);
	        
	      
	        
	        
	        b4.setFont(new Font("Arial", Font.BOLD, 14));
	        b4.setBounds(300,450,230,30);
	        add(b4);
	        b1.setFont(new Font("Arial", Font.BOLD, 14));
	        b1.setBounds(300,500,230,30);
	        add(b1);
	        
	        
	      
	        b4.addActionListener(this);

	        b1.addActionListener(this);
	        
	        getContentPane().setBackground(Color.WHITE);
	        

	        setSize(750,720);
	        setLocation(10,10);
	        
	        setVisible(true);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	        
	    }
	  
	    public void actionPerformed(ActionEvent ae){
	       
	        try{        
	            conn c1 = new conn();
	           String cardN = tf1.getText();
	         String email  = tf2.getText();
	            String q  = "select * from signup where cardN = '"+cardN+"' and email = '"+email+"'";
	            ResultSet rs = c1.s.executeQuery(q);
	            
	            String em="^[A-Za-z0-9+_.-]+@(.+)$";
	         	Pattern pa=Pattern.compile(em); 
	         	

	        	Matcher ema= pa.matcher(tf2.getText());
	        	
	        	if((ae.getSource()==b4)&&(tf1.getText().equals(""))){
	      		  
	                JOptionPane.showMessageDialog(null, "Please enter the card number ");
	            
	        	}
	            
	        	else	if((ae.getSource()==b4)&&(tf2.getText().equals(""))){
	      		  
	                JOptionPane.showMessageDialog(null, "Please enter the email");
	            
	        	}
	        	
	        	else	if((ae.getSource()==b4)&&(ema.matches()==false)){
		      		  
	                JOptionPane.showMessageDialog(null, "email format is incorrect");
	            
	        	}
	            
	        	else  if(ae.getSource()==b4){
	                if(rs.next()){
	                	String pin=rs.getString(17);
	                	JOptionPane.showMessageDialog(null, "pin sent to your email");
	                    new Login();
	                    setVisible(false);
	                    
	                    mail.send("ubl.pak123@gmail.com","ubl.pk321",""+email+"","your pin is here"," your pin is: "+pin+" ");
	                   
	              
	                }
	                else{
	                  
	                	JOptionPane.showMessageDialog(null, "Incorrect Card Number or email");
	                	 tf1.setText("");
	                     tf2.setText("");
	                }
	               
	               
	                }
	        
	            
	            else if(ae.getSource()==b1) {
	            	
		                	new Login();
		                	setVisible(false);
	            	
	            }
	        }
	 
	        catch(Exception e){
	                   
	                    System.out.println("error: "+e);
	        }
	            
	   
	    
	    
	    
	    }
	    
	    
	   

	    
	}

	
