


	import java.awt.*;
	import java.awt.event.*;
	import javax.swing.*;
	import java.sql.*;
	import java.util.*;


	public class FastCash extends JFrame implements ActionListener{

	    JLabel l1,l2;
	    JButton b1,b2,b3,b4,b5,b6,b7,b8;
	
	    
	    FastCash(){
	        
	
	        setTitle("FAST CASH");
	    
	        
	        
	        
	        l1 = new JLabel("SELECT WITHDRAWL AMOUNT");
	        l1.setFont(new Font("System", Font.BOLD, 38));
	       
	        
	       
	        b1 = new JButton("Rs 100");
	        b1.setFont(new Font("System", Font.BOLD, 18));
	        b1.setBackground(Color.BLACK);
	        b1.setForeground(Color.WHITE);
	    
	        b2 = new JButton("Rs 500");
	        b2.setFont(new Font("System", Font.BOLD, 18));
	        b2.setBackground(Color.BLACK);
	        b2.setForeground(Color.WHITE);
	        
	        b3 = new JButton("Rs 1000");
	        b3.setFont(new Font("System", Font.BOLD, 18));
	        b3.setBackground(Color.BLACK);
	        b3.setForeground(Color.WHITE);
	        
	        b4 = new JButton("Rs 2000");
	        b4.setFont(new Font("System", Font.BOLD, 18));
	        b4.setBackground(Color.BLACK);
	        b4.setForeground(Color.WHITE);
	        
	        b5 = new JButton("Rs 5000");
	        b5.setFont(new Font("System", Font.BOLD, 18));
	        b5.setBackground(Color.BLACK);
	        b5.setForeground(Color.WHITE);
	        
	        b6 = new JButton("Rs 10000");
	        b6.setFont(new Font("System", Font.BOLD, 18));
	        b6.setBackground(Color.BLACK);
	        b6.setForeground(Color.WHITE);
	        
	        b7 = new JButton("BACK");
	        b7.setFont(new Font("System", Font.BOLD, 18));
	        b7.setBackground(Color.BLACK);
	        b7.setForeground(Color.WHITE);
	      
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setLayout(null);
	        
	     
	        
	        
	        l1.setBounds(100,100,700,40);
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
	        
	        b7.setBounds(240,600,300,60);
	        add(b7);
	        
	        
	        b1.addActionListener(this);
	        b2.addActionListener(this);
	        b3.addActionListener(this);
	        b4.addActionListener(this);
	        b5.addActionListener(this);
	        b6.addActionListener(this);
	        b7.addActionListener(this);
	        
	        
	        
	        getContentPane().setBackground(Color.WHITE);
	        
	        setSize(800,800);
	        setLocation(500,90);
	        setVisible(true);
	        
	        
	        
	    }
	    
	    public void actionPerformed(ActionEvent ae){
	       
	            try{        
	           
	          
	            double balance = 0;
	            
	            conn c1 = new conn();
                
                ResultSet rs = c1.s.executeQuery(" select * from signup where cardN = '"+Login.cardN+"' and pin = '"+Login.pass+"' ");
                
                
                rs.next();
                   
                    balance = rs.getDouble(18);
	            
	            
	            
	            if(ae.getSource()==b1){
	                
	               if(balance>=100) {
	                     
	                        balance-=100;
	                        String q1= "UPDATE `signup` SET `amount`='"+balance+"'  where cardN = '"+Login.cardN+"' and pin = '"+Login.pass+"' ";
	                    
	                        c1.s.executeUpdate(q1);
	                    
	                        
	                        String d =   " INSERT INTO `transactions`(`cardN`, `pin`, `withdraw`,`dateT`) VALUES ('"+Login.cardN+"','"+Login.pass+"','100','"+CurrentDate.date()+"')";
	                        c1.s.executeUpdate(d);
	                          
	                        
	                    
	                    
	                    JOptionPane.showMessageDialog(null, "Rs. "+100+" Debited Successfully");
	                    
	                    new Transcations().setVisible(true);
	                    setVisible(false);
	                    
	               }else {
	            	   JOptionPane.showMessageDialog(null, "You don't have enogh money to withdraw 100 ");
	                   
	               }
	                    
	            }
	                
	            
	            else if(ae.getSource()==b2){
	                
	            	if(balance>=500) {
	 	               
	                        balance-=500;
	                        String q1= "UPDATE `signup` SET `amount`='"+balance+"'  where cardN = '"+Login.cardN+"' and pin = '"+Login.pass+"'";
	                    
	                        c1.s.executeUpdate(q1);
	                    
	                        String d =   " INSERT INTO `transactions`(`cardN`, `pin`, `withdraw`,`dateT`) VALUES ('"+Login.cardN+"','"+Login.pass+"','500','"+CurrentDate.date()+"')";
	                        c1.s.executeUpdate(d);
	                          
	                        
	                    
	                    
	                    JOptionPane.showMessageDialog(null, "Rs. "+500+" Debited Successfully");
	                    
	                    new Transcations().setVisible(true);
	                    setVisible(false);
	                    
	            	}else {
	            		JOptionPane.showMessageDialog(null, "You don't have enogh money to withdraw 500 ");
		                   
	            	}
	                    
	                }
	            else if(ae.getSource()==b3){
	            	if(balance>=1000) {
		 	             
	                  
	                        balance-=1000;
	                        String q1=" UPDATE `signup` SET `amount`='"+balance+"'  where cardN = '"+Login.cardN+"' and pin = '"+Login.pass+"'";
	                        c1.s.executeUpdate(q1);
	                    
	                        String d =   " INSERT INTO `transactions`(`cardN`, `pin`, `withdraw`,`dateT`) VALUES ('"+Login.cardN+"','"+Login.pass+"','1000','"+CurrentDate.date()+"')";
	                        c1.s.executeUpdate(d);
	                          
	                        
	                    
	                    
	                    JOptionPane.showMessageDialog(null, "Rs. "+1000+" Debited Successfully");
	                    
	                    new Transcations().setVisible(true);
	                    setVisible(false);
	            	}else {
	                    	JOptionPane.showMessageDialog(null, "You don't have enogh money to withdraw 1000 ");
	 	                   
	                    }
	            
	                    
	                }
	            else if(ae.getSource()==b4){
	            	if(balance>=2000) {
		 	             
	                  
	                        balance-=2000;
	                       String q1=" UPDATE `signup` SET `amount`='"+balance+"'  where cardN = '"+Login.cardN+"' and pin = '"+Login.pass+"'";
		                       
	                        c1.s.executeUpdate(q1);
	                    
	                        String d =   " INSERT INTO `transactions`(`cardN`, `pin`, `withdraw`,`dateT`) VALUES ('"+Login.cardN+"','"+Login.pass+"','2000','"+CurrentDate.date()+"')";
	                        c1.s.executeUpdate(d);
	                          
	                        
	                    
	                    
	                    JOptionPane.showMessageDialog(null, "Rs. "+2000+" Debited Successfully");
	                    
	                    new Transcations().setVisible(true);
	                    setVisible(false);
	            	}
	            	else {
	            		JOptionPane.showMessageDialog(null, "You don't have enogh money to withdraw 2000 ");
	 	                   
	            	}
	                    
	                }
	            else if(ae.getSource()==b5){
	                
	            	if(balance>=5000) {
			 	        
	                        balance-=5000;
	                        String q1=" UPDATE `signup` SET `amount`='"+balance+"'  where cardN = '"+Login.cardN+"' and pin = '"+Login.pass+"'";
		                       
	                        c1.s.executeUpdate(q1);
	                        String d =   " INSERT INTO `transactions`(`cardN`, `pin`, `withdraw`,`dateT`) VALUES ('"+Login.cardN+"','"+Login.pass+"','5000','"+CurrentDate.date()+"')";
	                        c1.s.executeUpdate(d);
	                          
	                        
	                    
	                    
	                    
	                    JOptionPane.showMessageDialog(null, "Rs. "+5000+" Debited Successfully");
	                    
	                    new Transcations().setVisible(true);
	                    setVisible(false);
	            	} else {
	                    	JOptionPane.showMessageDialog(null, "You don't have enogh money to withdraw 5000 ");
		 	                   
	                    }
	                    
	                    
	                }
	            else if(ae.getSource()==b6){
	                
	            	if(balance>=10000) {
			 	         
	                        balance-=10000;
	         String q1=" UPDATE `signup` SET `amount`='"+balance+"'  where cardN = '"+Login.cardN+"' and pin = '"+Login.pass+"'";
		                       
	                        c1.s.executeUpdate(q1);
	                    
	                        String d =   " INSERT INTO `transactions`(`cardN`, `pin`, `withdraw`,`dateT`) VALUES ('"+Login.cardN+"','"+Login.pass+"','10000','"+CurrentDate.date()+"')";
	                        c1.s.executeUpdate(d);
	                          
	                        
	                    
	                    
	                    JOptionPane.showMessageDialog(null, "Rs. "+10000+" Debited Successfully");
	                    
	                    new Transcations().setVisible(true);
	                    setVisible(false);
	                    
	                    
	                    
	                
	            }else {
	            	JOptionPane.showMessageDialog(null, "You don't have enogh money to withdraw 10000 ");
	 	               
	            }
	            }
	            else if(ae.getSource()==b7){
	                
	             new Transcations();
	             setVisible(false);
	                
	            }
	        }catch(Exception e){
	                e.printStackTrace();
	                System.out.println("error: "+e);
	        }
	            
	    }

	    
	    public static void main(String[] args){
	        new FastCash().setVisible(true);
	    }
	}

