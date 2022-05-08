package downloadD4j2020;

import java.util.ArrayList;

public class D4jProgram {

	public  String ProName = "";
	public  String lowerProName = "";
	public  String MainFile = "";
	
	public  Integer TotalBug = 0;
	
	public  String SpecialRoot = "";	
	public  String SpecialRoot1 = "";	
	public String SpecialRoot2 = "";
	public Integer SpecialRoot2Begin = 200;
	public String StatementType = "unknown";
	
	
	public double ifsus = 1.0;
	public double forsus = 1.0;
	public double expsus = 1.0;
	public double dosus = 1.0;
	public double trysus = 1.0;
	
	
	public double vardsus = 1.0;
	public double enforsus = 1.0;
	public double retsus = 1.0;
	
	
	public ArrayList<Integer> AddStatementBug = new ArrayList(); 
	
	//public Integer deprecatedBug =0;
	
	public ArrayList<Integer> deprecatedBug = new ArrayList();
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
		experiment.runCmd();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		

	}
	
	public static D4jProgram ExcludeAddSituation(D4jProgram Pro,int[] BugIDList)
	{
		for(int i =0;i<BugIDList.length;i++)		
		{
			Pro.AddStatementBug.add(BugIDList[i]);
		}
		return Pro;
	}
	public static String getSpecialRoot(D4jProgram Pro,int BugID)
	{
		if(BugID>=Pro.SpecialRoot2Begin)
		{return Pro.SpecialRoot2;}
		else
		{
			return Pro.SpecialRoot1;
		}
	}
	

}
