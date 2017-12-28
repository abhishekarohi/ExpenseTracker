package Data;

import java.io.*;;

public class ExpTransactionTemplate implements Serializable
{
		private static final long serialVersionUID = 1L;
		private int templateId;
		private String templateItem;
	    private String templatepAmount;
	    private String templateCategory;
	    
	    public ExpTransactionTemplate(int id, String i, String p, String c)
	    {
		    	templateId = id;
		    	templateItem = i;
		    	templatepAmount = p;
		    	templateCategory = c;			
	    }
	    
	    public String toString()
	    {
	    		return "Template ID: " + new Integer(templateId).toString() + 
	    						"	Item Description: " + templateItem + 
	    						"	Projected Amount: " + templatepAmount + 
	    						"	Category: " + templateCategory;
	    		
	    }
	    
	    public int getTemplateID()
	    {
	    		return this.templateId;
	    }
	    
	    public String getTemplateItem()
	    {
	    		return this.templateItem;
	    }
	    
	    public String getTemplateAmount()
	    {
	    		return this.templatepAmount;
	    }
	    
	    public String getTemplateCategory()
	    {
	    		return this.templateCategory;
	    }
	    
	    public boolean isGreaterThan(ExpTransactionTemplate t)
	    {
	    		
	    		if (this.templateItem.compareToIgnoreCase(t.templateItem) > 0)
	    			return true;
	    		else
	    			return false;
	    }
	    
	    public void setTemplate(String i, String a, String c)
	    {
	    		templateItem = i;
	    		templatepAmount = a;
	    		templateCategory = c;
	    }
}
