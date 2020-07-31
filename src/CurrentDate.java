

import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;    
public class CurrentDate{    
	
	
	
	public static  String date() {  
   DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
 
   LocalDateTime now= LocalDateTime.now();  
   
   String a=dtf.format(now);
 
 return a  ;
 }   

} 