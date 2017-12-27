package Data;

import java.util.*;
import java.io.*;



public class ExpTransactionTemplate 
{
	private ArrayList<Temptransaction> templateTransactions;
	
	public ExpTransactionTemplate ()
	{
		templateTransactions = new ArrayList();
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
					templateTransactions = (ArrayList<Temptransaction> ) inStream.readObject();
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
			outStream.writeObject(templateTransactions);
			outStream.close();
		} 
		catch (IOException e) 
		{
			System.out.println("Template load Error: " + e.getMessage());
		}
	}
	
	public void addToTemplates(Temptransaction t)
	{
		templateTransactions.add(t);
	}
	
	public ArrayList<Temptransaction> getTemplates()
	{
		return templateTransactions;
	}
	
}
