






import java.awt.*;

import java.awt.event.*;

import java.sql.*;

import java.util.Vector;

import javax.swing.*;

import javax.swing.table.DefaultTableModel;

 

public class Mini extends JFrame implements ActionListener{

 

    JFrame frame1;

    JLabel l0, l1, l2;

    JComboBox c1;

    JButton b1,b2;



    ResultSet rs, rs1;

    

    PreparedStatement pst;

    String ids;

    static JTable table;

    String[] columnNames = {"DEPOSIT","WITHDRAW","TRANSFER","TOWARDS" ,"DATE AND TIME" };
    
 

 

  public Mini() {

	   
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       

        frame1 = new JFrame("YOUR TRANSCATIONS");


        frame1.setLayout(new BorderLayout());
//
//        b1 = new JButton("PRINT");
//        b1.setFont(new Font("System", Font.BOLD, 18));
//        b1.setBackground(Color.BLACK);
//        b1.setForeground(Color.WHITE);
    
        b2 = new JButton("BACK");
        b2.setFont(new Font("System", Font.BOLD, 18));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
    


       // b1.setBounds(250, 630, 140, 25);
        b2.setBounds(310, 630, 150, 30);
        
              //  frame1.add(b1);
                frame1.add(b2);

            //   b1.addActionListener(this); 
              b2.addActionListener(this); 
//TableModel tm = new TableModel();

        DefaultTableModel model = new DefaultTableModel();

        model.setColumnIdentifiers(columnNames);
      
        
       
//DefaultTableModel model = new DefaultTableModel(tm.getData1(), tm.getColumnNames());

//table = new JTable(model);

        table = new JTable();

        table.setModel(model);

        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

        table.setFillsViewportHeight(true);

        JScrollPane scroll = new JScrollPane(table);

        scroll.setHorizontalScrollBarPolicy(

                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        scroll.setVerticalScrollBarPolicy(

                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

       

//String textvalue = textbox.getText();
     String DEPOSIT="",WITHDRAW="",TRANSFER="",to="",DaT="";
     

        try {
        	
        	 conn c1 = new conn();
         
            pst = c1.c.prepareStatement("select * from transactions where cardN = '"+Login.cardN+"' and pin = '"+Login.pass+"' limit 37");

            ResultSet rs = pst.executeQuery();

          

            while (rs.next()) {

               

			
			DEPOSIT = rs.getString("deposit");
			
			WITHDRAW=rs.getString("withdraw");
			
			TRANSFER=rs.getString("transfer");
			
			to=rs.getString("towards");
			
			DaT=rs.getString("datet");
			
                model.addRow(new Object[]{DEPOSIT,WITHDRAW,TRANSFER,to,DaT });


            }
        

           
        } catch (Exception ex) {
System.out.println(ex);
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

        }

        frame1.add(scroll);

        frame1.setVisible(true);

        frame1.setSize(800, 720);
        frame1.setLocation(10,10);

    }


  	public static void main(String[] args) {
  		new Mini();
  	}


	@Override
	public void actionPerformed(ActionEvent e) {
			
			    frame1.setVisible(false);
            new Transcations().setVisible(true);
        
            
   
	}
  
  				 }

