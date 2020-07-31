

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Withdrawl extends Deposit {

	 JLabel l4;
	
	  String a,s;
	  int foo,i;
	  conn c1;
	  ResultSet rs;
	 

	Withdrawl(){
		 setTitle("Withdrawl");
	

	       remove(l2);
	       l4 = new JLabel("TO Withdraw");
	        l4.setFont(new Font("System", Font.BOLD, 35));
	        
	        l4.setBounds(290,210,800,60);
	        add(l4);
	        remove(b1);
	       
	        
	        b3 = new JButton("Withdraw");
	        b3.setFont(new Font("System", Font.BOLD, 18));
	        b3.setBackground(Color.BLACK);
	        b3.setForeground(Color.WHITE);
	    
	        
	        b3.setBounds(260,380,125,50);
	        add(b3);
	        
	     
	        b3.addActionListener(this);
	        
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		

     	 String adr="^[0-9\\-]*$";
      	Pattern paa=Pattern.compile(adr); 
      	Matcher post= paa.matcher(t1.getText());
      	
		

    	try {   
    	String a=t1.getText();
    		foo=Integer.parseInt(a);
    	    	
	       
		 }catch(Exception e){
			System.out.println(e);
		 }
    	
		
		
		
		
   if(ae.getSource()==b2){
            
            new Transcations();
            setVisible(false);
            
        }
  	
		
		 try {
			 
			 
			 
			 
			 

		  	   
		     c1 = new conn();
		    
		     s=  "select * from signup where cardN = '"+Login.cardN+"' and pin = '"+Login.pass+"' ";
		    
				rs=c1.s.executeQuery(s);
				rs.next();
		     i=  rs.getInt(18);
			

		
		
			   if((ae.getSource()==b3)&&(t1.getText().equals(""))){
		    		  
		            JOptionPane.showMessageDialog(null, "Please enter the Amount to you want to withdraw");
		        
		    	}
			  	else if((ae.getSource()==b3)&&(post.matches()==false)){
			  		  
		            JOptionPane.showMessageDialog(null, "Please enter only numric values for amount");
		            t1.setText("");
		        
		    	}
		
		
     
        
			   else if ((ae.getSource()==b3)&&(foo<100||foo>1000000)) {
    		JOptionPane.showMessageDialog(null, "Amount should be greater than 100  and \nless than 1000000 rupees at a time which you want to Withdraw");
    		  t1.setText("");
    	}
        
        

        


  	
    	
  

           

		
      
        else if((ae.getSource()==b3)&&(foo>i)){
        		 JOptionPane.showMessageDialog(null, "You dont have enogh money to withdraw "+foo+"  " );
                 t1.setText("");
        	 }
		
		       
        	 else if((ae.getSource()==b3)){
            	
                
                
                    if(foo<=i) {
                    
           
                       
        
                      
                       
                        
                        
                         
                 
                     i=i-foo;
                      
                        String q1= "UPDATE `signup` SET `amount`='"+i+"'  where cardN = '"+Login.cardN+"' and pin = '"+Login.pass+"' ";
                        try {
							c1.s.executeUpdate(q1);
						
                        
                        
                        
                        String d =   " INSERT INTO `transactions`(`cardN`, `pin`, `withdraw`,`dateT`) VALUES ('"+Login.cardN+"','"+Login.pass+"','"+foo+"','"+CurrentDate.date()+"')";
                        c1.s.executeUpdate(d);
                          
                        
                        
                        } catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
                        
                        
                        JOptionPane.showMessageDialog(null, "Rs. "+foo+" debited  Successfully");
                        setVisible(false);
                        new Transcations();
                      
                      }
                      
                      
        	
        	 }
        	
    	
		 }
	  	 
			catch (SQLException e1) {
			
				e1.printStackTrace();
			}
            
		
		
		
		
		
	}

    public static void main(String[] args){
        new Withdrawl().setVisible(true);
    }
}
