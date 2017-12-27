package Data;

import java.io.*;;

public class Temptransaction implements Serializable
{
		/**
	 * 
	 */
		private static final long serialVersionUID = 1L;
		private int tempId;
		private String item;
	    private String pAmount;
	    private String category;
	    
	    public Temptransaction(int id, String i, String p, String c)
	    {
	    		tempId = id;
	    		item = i;
	    		pAmount = p;
	    		category = c;			
	    }
	    
	    public String toString()
	    {
	    		return "Template ID: " + new Integer(tempId).toString() + 
	    						"	Item Description: " + item + 
	    						"	Projected Amount: " + pAmount + 
	    						"	Category: " + category;
	    		
	    }
	    
	    
	    
}
