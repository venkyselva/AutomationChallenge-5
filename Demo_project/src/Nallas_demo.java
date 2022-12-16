import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Comparator;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import org.apache.commons.collections4.map.MultiValueMap;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;


import io.netty.util.internal.ThreadLocalRandom;

public class Nallas_demo {

	public static String Set1 = "Yet to start";
	public static String Set2 = "Yet to start";
	public static JLabel Set_list1;
	public static JLabel Set_list2;
	public static JLabel Status;
	public static String user_status ="Yet to start";
	public static  String  Verification="";
	public static  int Guess_count=0;
	public static JTextField userEnt;
	public static JTextField userEnt1;
	public static  String  finalstring="";
	public static  String  finalstring1="";
	public static int length;
	public static  int count;  
	public static Integer [] int_array;
	public static JButton number;
	public static JButton reset;
	public static String finalvalue="empty";
	public static JPanel mainPanel, subPanel1, subPanel2;
	public static ArrayList<Integer> value = new ArrayList<Integer>();
	public static int a[][];
	public static void main(String[] args) 
	{
					
     try
     {

    	 final JFrame frame = new JFrame();
 		frame.setTitle("-----Welcome to NALLAS-----");
 		JPanel pane1 = new JPanel();

 		//---to identify system resolution----
 		int[] scrn_resln = system_resolution();
 		 int width = scrn_resln[0];
 		 int height = scrn_resln[1];
 		 frame.setSize(width/2,height/2);
 		//---Element initialization----
 		 JLabel list_label = new JLabel("Enter your text");
 		JLabel list_label1 = new JLabel("Enter compare text");
          userEnt = new JTextField("", 10);
          userEnt1 = new JTextField("", 10);
          number = new JButton("Text Comparison");
          reset = new JButton("Reset");
          Set1 ="Yet to Start";
          Set_list1  = new JLabel("<html><br>"+"Longest Shared sub-string is: **"+Set1+" --**</html>");
          pane1.add(list_label);
          pane1.add(userEnt);
          pane1.add(list_label1);
          pane1.add(userEnt1);
          pane1.add(number);
          pane1.add(reset);
          pane1.add(Set_list1);
          frame.add(pane1);
           frame.setVisible(true);
    	 
           number.addActionListener(new ActionListener(){  
 			  public void actionPerformed(ActionEvent e){
 				  reset.setEnabled(true);
 				  userEnt.setEditable(false);
 				 userEnt1.setEditable(false);
 				  number.setEnabled(false);
 				 finalstring = userEnt.getText();
 				 finalstring1 = userEnt1.getText();
 				 Verification ="";
 				 System.out.println("print" + finalstring +finalstring1 );
 				 if(!finalstring.equals("") && !finalstring1.equals("") )
 				 {
 					stringcomparison(finalstring,finalstring1);
 					Set_list1.setText("<html><br>"+"Longest Shared sub-string is: length("+length+ ") :"+ Verification+" --**</html>");
 					
 				 }
 				 else
 				 {
 					Set2 = " Expected Text cannot be blank";
 					Set_list1.setText("<html><br>"+"Longest Shared sub-string is:"+ Set2+" --**</html>");
 				 }
 				   
 		}});  

           
          reset.addActionListener(new ActionListener(){  
 			  public void actionPerformed(ActionEvent e){
 				  number.setEnabled(true);
 				  userEnt.setEditable(true);
 				  userEnt.setText("");
 				 userEnt1.setEditable(true);
				  userEnt1.setText("");
 				  reset.setEnabled(false);
 				 Set1 = "Reset Completed";
					Set_list1.setText("<html><br>"+"Longest Shared sub-string is:"+ Set1+" --**</html>");
 				  
 			  }});
          
          
	}
	catch(Exception g)
	{
		System.out.println(g.toString());
	}
	}
 	
     public static void stringcomparison(String value, String value1)
     {
    	 String[] strary = value.split(" ");
    	 String[] strary1 = value1.split(" ");
    	 List<String> matchingstring = new ArrayList<String>();
    	 ArrayList<Integer> matchingstrLength = new ArrayList<Integer>();
    	 
    	 Map<String, Integer> map=new HashMap<String,Integer>(); 
    	 Boolean status = false;
    	 for(String valstr : strary)
    	 {
    		 for(String valstr1 : strary1)
    		 {
    			 if(valstr.equalsIgnoreCase(valstr1))
    			 {
    				 matchingstring.add(valstr);
    				 matchingstrLength.add(valstr.length());
    				 map.put(valstr1,valstr.length());
    				 status = true;
    			 }
    			 else
    			 {
    				 continue;
    			 }
    		 }
    	 }
    	 if(status ==true)
    	 {
    	 length = Collections.max(matchingstrLength);
    	
    	System.out.println("test"+length +"map size"+map.size());
    	@SuppressWarnings("rawtypes")
		Set set=map.entrySet(); 
        @SuppressWarnings("rawtypes")
		Iterator itr=set.iterator();
        
        while(itr.hasNext())
        {  
            @SuppressWarnings("rawtypes")
			Map.Entry entry=(Map.Entry)itr.next();  
            int mapint = (Integer) entry.getValue();
            
            if(length == mapint)
            {
            	Verification += entry.getKey()+" ";
            }
           
        } 
        String[] valstr = Verification.split(" ");
        int val = valstr.length;
        if(val>1)
        {
        	 JOptionPane.showMessageDialog(null, "Multiple matching words found with same length ("+length+")");
        }

    	 }
    	 else
    	 {
    		 length =0;
    		 Verification = "no matching found";
    		 
    	 }
     }
	
    
    
	
public static int[] system_resolution()
{
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int)screenSize.getWidth();
		
		int height = (int)screenSize.getHeight();
		int[] val = {width,height};
		return val;
		
}
	
	
	

}
