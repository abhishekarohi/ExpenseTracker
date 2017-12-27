
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
	
	public void addToTemplates(ExpTransactionTemplate t)
	{
		transactionTemplates.add(t);
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
}
