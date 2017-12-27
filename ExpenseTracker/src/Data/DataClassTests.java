package Data;

import java.util.*;

public class DataClassTests {

	public static void main(String[] args) 
	{
		ExpTransactionTemplate temp = new ExpTransactionTemplate();
		Temptransaction t;
		
		
		
		//temp.loadtemplates();
		for (int i = 11; i <=20; i++)
		{
			Integer id = new Integer(i);
			t = new Temptransaction(i,new String("item"+id.toString()), new String("amount"+id.toString()), new String("category"+id.toString()));
			temp.addToTemplates(t);
		}
		temp.saveTemplates();
		temp.loadtemplates();
		
		ArrayList<Temptransaction> tempList = temp.getTemplates();
		
		for (Temptransaction tran : tempList)
		{
			System.out.println(tran.toString());
		}
	}

}
