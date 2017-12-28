
package Data;

import java.util.*;
import java.io.*;

public class ExpTransactionTemplateDAO 
{
	private ArrayList<ExpTransactionTemplate> transactionTemplates;
	private boolean templatesExist;
	
	public ExpTransactionTemplateDAO ()
	{
		transactionTemplates = new ArrayList();
		templatesExist = false;
		loadtemplates();
	}
	
	public void loadtemplates()
	{
		File templateFile = new File("TransactionTemplates.dat");
		
		try 
		{
			if (!templateFile.exists())
				templateFile.createNewFile();
			else
			{
				if (templateFile.length() > 0)
				{
					ObjectInputStream inStream = new ObjectInputStream(new FileInputStream("TransactionTemplates.dat"));
					transactionTemplates = (ArrayList<ExpTransactionTemplate> ) inStream.readObject();
					templatesExist = true;
				}
				
			}
		} 
		catch (IOException e) 
		{
			System.out.println("Template load Error: " + e.getMessage());
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void saveTemplates()
	{	
		try 
		{
			ObjectOutputStream outStream = new ObjectOutputStream(new FileOutputStream("TransactionTemplates.dat"));
			outStream.writeObject(transactionTemplates);
			outStream.close();
		} 
		catch (IOException e) 
		{
			System.out.println("Template load Error: " + e.getMessage());
		}
	}
	
	public void addToTemplates(String i, String amt, String cat)
	{
		ExpTransactionTemplate t = new ExpTransactionTemplate
										(transactionTemplates.size() + 1,
										i,amt,cat);
		transactionTemplates.add(t);
		sortdata();
		templatesExist = true;
	}
	
	public void updateTemplates(int templateid, String i, String amt, String cat)
	{
		
		transactionTemplates.get(templateid).setTemplate(i, amt, cat);
		sortdata();
		templatesExist = true;
	}
	
	public ArrayList<ExpTransactionTemplate> getTemplates()
	{
		return transactionTemplates;
	}
	
	public boolean checkTemplatesExist()
	{
		return templatesExist;
	}
	
	public void sortdata()
    {
        ExpTransactionTemplate [] trans = new ExpTransactionTemplate[transactionTemplates.size()];
        boolean posFound = false;
        int position = 0;

        for (int x = 0; x < transactionTemplates.size();x++)
        {
        		ExpTransactionTemplate o = transactionTemplates.get(x);

            if (x == 0)
                trans[x] = o;
            else
            {
                //Put logic to compare objects and replace spaces.
                for (int y = 0; y < x; y++)
                {
                    if (!o.isGreaterThan(trans[y]))
                    {
                        for(int z = x ; z >= y ;z--)
                        {
                            if (z > 0)
                                trans[z] = trans[z-1];
                        }

                        trans[y] = o;
                        posFound = true;
                        break;
                    }
                    position = y + 1;

                }

                if (!posFound)
                    trans[position] = o;

                posFound = false;

            }

        }
        transactionTemplates.clear();
        for (int i = 0; i < trans.length; i++)
        		transactionTemplates.add(trans[i]);
    }
}
