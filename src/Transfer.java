



import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Transfer extends JFrame implements ActionListener{
    
    JTextField t1,t2;
    JButton b1,b2,b3;
    JLabel l1,l2,l3;
    
    String w ;
    ResultSet rss;

   
    Transfer(){
 
        setTitle("TRANSFER");
        
        
        l1 = new JLabel("ENTER A/C NO. IN WHICH YOU TRANSFER");
        l1.setFont(new Font("System", Font.BOLD, 35));
        
        l2 = new JLabel("ENTER AMOUNT YOU WANT SHARE");
        l2.setFont(new Font("System", Font.BOLD, 35));
     
        t1 = new JTextField();
        t1.setFont(new Font("Raleway", Font.BOLD, 22));
       
        
        t2 = new JTextField();
        t2.setFont(new Font("Raleway", Font.BOLD, 22));
       
        
        
        
        
        b1 = new JButton("TRANSFER");
        b1.setFont(new Font("System", Font.BOLD, 18));
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
    
        b2 = new JButton("BACK");
        b2.setFont(new Font("System", Font.BOLD, 18));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
      
    	
        setLayout(null);
       
        
       
        l1.setBounds(50,150,800,60);
        add(l1);
        
        l2.setBounds(100,270,800,60);
        add(l2);
        
        t1.setBounds(250,210,300,50);
        add(t1);
        t2.setBounds(250,330,300,50);
        add(t2);
        
        b1.setBounds(260,410,125,50);
        add(b1);
        
        b2.setBounds(415,410,125,50);
        add(b2);
       
        
        b1.addActionListener(this);
        b2.addActionListener(this);
       
        
        getContentPane().setBackground(Color.WHITE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        
        setSize(800,720);
        setLocation(10,10);
        
        setVisible(true);
     
    }
    
    public void actionPerformed(ActionEvent ae){
       
    	

     	 String adr="^[0-9\\-]*$";
      	Pattern paa=Pattern.compile(adr); 
      	Matcher post= paa.matcher(t2.getText());
      	
      	Pattern paaa=Pattern.compile(adr); 
      	Matcher ac= paaa.matcher(t1.getText());
      	
    	
    	
    	  try{
    		  
    		  
    		  
    		  if(ae.getSource()==b2){
    	            
    	            new Transcations().setVisible(true);
    	            setVisible(false);
    	            
    	        }
    		  
    		  
    	else if((ae.getSource()==b1)&&(t1.getText().equals(""))){
    		  
            JOptionPane.showMessageDialog(null, "Please enter card number in which you transfer");
        
    	}
    	else if((ae.getSource()==b1)&&(t2.getText().equals(""))){
  		  
            JOptionPane.showMessageDialog(null, "Please enter amount ");
        
    	}
    	
    	else if((ae.getSource()==b1)&&(ac.matches()==false)){
    		  
            JOptionPane.showMessageDialog(null, "Please enter only numric values for card");
            t2.setText("");
        
    	}
    	      
	
	   
    	else if((ae.getSource()==b1)&&(post.matches()==false)){
    		  
            JOptionPane.showMessageDialog(null, "Please enter only numric values for amount");
            t2.setText("");
        
    	}
    	
    	
    	
    	
    	
              
   
        	
    	
    	
    	
    	String b = t2.getText();
        System.out.println("acount: "+b);
        int foo = Integer.parseInt(b);
   
        String to =  t1.getText();
        
                
                conn c1 = new conn();
               
              
              
               
              String s=  "select * from signup where cardN = '"+Login.cardN+"' and pin = '"+Login.pass+"' ";
              ResultSet rs=c1.s.executeQuery(s);
          rs.next();
          
          
          
          
              int i=  rs.getInt("amount");
             System.out.println(i);
             
             
             w=  "select * from signup where cardN = '"+t1.getText()+"' ";
              rss=c1.s.executeQuery(w);
             
          	 if ((ae.getSource()==b1)&&(foo<100||foo>1000000)) {
        		JOptionPane.showMessageDialog(null, "Amount should be greater than 100 and \nless than 1000000 rupees at atime which you want to transfer");
        		 t2.setText("");
        	}
              
              
              
          	else  if(ae.getSource()==b1){
            	  System.out.println(t1.getText().equals(Login.cardN));
          		if(t1.getText().equals(Login.cardN)) {
          		  	JOptionPane.showMessageDialog(null, "Don't enter your acount ");
          		  t1.setText("");
          		}
          		
          		
          		else	if( rss.next()==false) {
                   	JOptionPane.showMessageDialog(null, "card number is incorrect ");
                    t1.setText("");
          		} 
             	      
                 
                   
            	   else	 if(i<foo) {
               		JOptionPane.showMessageDialog(null, "You dont have enogh money to transfer "+t2.getText()+" ");
               	 t2.setText("");
               	}
              	  
            	 
            	   else if( rss.last()) {
        	     
                
                String w=  "select * from signup where cardN = '"+t1.getText()+"' ";
                ResultSet rss=c1.s.executeQuery(w);
            rss.next();
               
            
            int p=  rss.getInt(18);
 
        	
            
            String ra=t2.getText();
              int n=Integer.parseInt(ra);
                p=p+n;
                
                i=i-n;
                
                
                String q1= "UPDATE `signup` SET `amount`='"+p+"'  where cardN =  '"+t1.getText()+"'    ";
                c1.s.executeUpdate(q1);
                
                String q2= "UPDATE `signup` SET `amount`='"+i+"'  where cardN = '"+Login.cardN+"' and pin = '"+Login.pass+"'  ";
                c1.s.executeUpdate(q2);
                
                

                String d1 =   " INSERT INTO `transactions`(`cardN`, `pin`, `transfer`, `towards`, `datet`) VALUES ('"+Login.cardN+"','"+Login.pass+"','"+n+"','"+to+"','"+CurrentDate.date()+"')";
                c1.s.executeUpdate(d1);
                  
                
                
                
               
                
                  JOptionPane.showMessageDialog(null, "Rs. "+t2.getText()+" Transfered Successfully");
                  setVisible(false);
                  new Transcations();
                
                  
                  
        	}
            	   
        	
        	
            	   
            	   
            	   
        	
        	
        }}
            
        catch(Exception e){
                e.printStackTrace();
                System.out.println("error: "+e);
        }
            
    }
    
    public static void main(String[] args){
        new Transfer().setVisible(true);
    }
    
}