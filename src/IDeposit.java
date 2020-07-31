

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class IDeposit extends Deposit{
	JButton b4;
	  int foo;
	IDeposit(){
		System.out.println("Hi iam in chid class");
	   
		
		setTitle("Deposit");
		   remove(b2);
		
		
		  b4 = new JButton("CANCEL");
	       
		  
		  b4.setFont(new Font("System", Font.BOLD, 18));
	        b4.setBackground(Color.BLACK);
	        b4.setForeground(Color.WHITE);
	      
	        
			  b4.setBounds(400,380,130,50);
		        add(b4);
		        
		        
		        b4.addActionListener(this);
			  
	        
	        
	}

	@Override
    public void actionPerformed(ActionEvent ae) {
	
		
		 String adr="^[0-9\\-]*$";
	       	Pattern paa=Pattern.compile(adr); 
	       	Matcher post= paa.matcher(t1.getText());
	       	

	       		
		
		
		try {
		 String aaa = t1.getText();
		foo = Integer.parseInt(aaa);
		}catch(Exception e) {
			System.out.println(e);
		}
		
	
		  try{  
			  if(ae.getSource()==b1&&t1.getText().equals("")){
	    		  
		            JOptionPane.showMessageDialog(null, "Please enter the Amount that you want to Deposit");
		        
		    	}
			  	else if((ae.getSource()==b1)&&(post.matches()==false)){
			  		  
		            JOptionPane.showMessageDialog(null, "Please enter only numric values for amount");
		            t1.setText("");
		        
		    	}
		    	
			  else  if(ae.getSource()==b4){
		          new Login();
		          setVisible(false);
		          mail.send("ubl.pak123@gmail.com","ubl.pk321",""+Signup.e+"",  "Hey!   "+Signup.a+" Congratulations... ","Your account is successfully created. \nYour Card number is:  "+Signup3.first8+" \npin is: "+Signup3.first4+" \nBalance: "+foo+"");
			      
		                
		            }

		        
			   else if ((ae.getSource()==b1)&&(foo<100||foo>1000000)) {
   		JOptionPane.showMessageDialog(null, "Amount should be greater than 100  and \nless than 1000000 rupees at a time which you want to Withdraw");
   		t1.setText(""); 
   	}
       
	            
			     else   if  (ae.getSource()==b1){
	               
	                	 String a = t1.getText();
	       	          
	     	         foo = Integer.parseInt(a);
	                    conn c1 = new conn();
	                   
	                  
	                    String q1= "UPDATE `signup` SET `amount`='"+foo+"' WHERE cardN='"+Signup3.first8+"' and pin='"+Signup3.first4+"'  ";
	                    c1.s.executeUpdate(q1);
	                    
	                    
	                    JOptionPane.showMessageDialog(null, "Rs. "+a+" Deposited Successfully");
	                    
	                    new Login();
	                    setVisible(false);
	                    
	                    
	                    mail.send("ubl.pak123@gmail.com","ubl.pk321",""+Signup.e+"",  "Hey!   "+Signup.a+" Congratulations... ","Your account is successfully created. \nYour Card number is:  "+Signup3.first8+" \npin is: "+Signup3.first4+" \nBalance: "+foo+"");
	          	      
	                    
	                }
	                
	            
	             
	       
	        }catch(Exception e){
	                e.printStackTrace();
	         
	                
	                
	                
	                System.out.println("error: "+e);
	        }
	            
		   
	        
		
	}
	public static void main(String[] args){
        new IDeposit().setVisible(true);
    }
	
}
