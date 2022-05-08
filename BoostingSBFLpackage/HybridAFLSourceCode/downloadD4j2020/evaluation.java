package downloadD4j2020;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class evaluation {

	public static void main(String[] args) {
		

	}

	public static boolean top1Bingo (List<statementline> truth,List<statementline> susstatements)
	{
		if(isIncorrect(truth,susstatements.get(0)))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public static boolean top50Bingo (List<statementline> truth,List<statementline> susstatements)
	{
		for(int i = 0 ; i < 50&&i<susstatements.size(); i++)
		{
			if(isIncorrect(truth,susstatements.get(i)))
			{
				return true;
			}
			else
			{				
			}
			
		}
		return false;		
	}
	
	public static boolean top10Bingo (List<statementline> truth,List<statementline> susstatements)
	{
		for(int i = 0 ; i < 10&&i<susstatements.size(); i++)
		{
			if(isIncorrect(truth,susstatements.get(i)))
			{
				return true;
			}
			else
			{				
			}
			
		}
		return false;		
	}
	
	public static boolean top30Bingo (List<statementline> truth,List<statementline> susstatements)
	{
		for(int i = 0 ; i < 30&&i<susstatements.size(); i++)
		{
			if(isIncorrect(truth,susstatements.get(i)))
			{
				return true;
			}
			else
			{				
			}
			
		}
		return false;		
	}
	
	public static boolean top100Bingo (List<statementline> truth,List<statementline> susstatements)
	{
		for(int i = 0 ; i < 100&&i<susstatements.size(); i++)
		{
			if(isIncorrect(truth,susstatements.get(i)))
			{
				return true;
			}
			else
			{				
			}
			
		}
		return false;		
	}
	
	public static boolean top200Bingo (List<statementline> truth,List<statementline> susstatements)
	{
		for(int i = 0 ; i < 200&&i<susstatements.size(); i++)
		{
			if(isIncorrect(truth,susstatements.get(i)))
			{
				return true;
			}
			else
			{				
			}
			
		}
		return false;		
	}
	
	public static boolean top500Bingo (List<statementline> truth,List<statementline> susstatements)
	{
		for(int i = 0 ; i < 500&&i<susstatements.size(); i++)
		{
			if(isIncorrect(truth,susstatements.get(i)))
			{
				return true;
			}
			else
			{				
			}
			
		}
		return false;		
	}
	
	public static boolean isIncorrect(List<statementline> truth,statementline l)
	{
		for(int i= 0;i<truth.size();i++)
		{
			statementline l0 = truth.get(i);
//			System.out.println("路径测试："+l.Path+"     "+l0.Path);
//			System.exit(0);
			if(l0.Path.equals(l.Path)&&l0.lineNum.equals(l.lineNum))
			{
				return true;
			}
		}
		return false;
	}
	
	public static String ShowEXAMRateChange(List<Double>EXAMRateListOld, List<Double>EXAMRateListNew)
	{
		if(EXAMRateListOld.size()!=EXAMRateListNew.size()){	
		System.out.println("实验数据错误！");
		System.exit(0);
		}
		String ret = "";
		int[] perOld = {0,0,0,0,0,0,0,0,0,0};		
		int[] perNew = {0,0,0,0,0,0,0,0,0,0};	
		
//		int perOld10 = 0;
//		int perOld20 = 0;
//		int perOld30 = 0;
//		int perOld40 = 0;
//		int perOld50 = 0;
//		int perOld60 = 0;
//		int perOld70 = 0;
//		int perOld80 = 0;
//		int perOld90 = 0;
//		int perOld100 = 0;
//		int perNew10 = 0;
//		int perNew20 = 0;
//		int perNew30 = 0;
//		int perNew40 = 0;
//		int perNew50 = 0;
//		int perNew60 = 0;
//		int perNew70 = 0;
//		int perNew80 = 0;
//		int perNew90 = 0;
//		int perNew100 = 0;
		
	for(int i=0;i<EXAMRateListOld.size();i++)
	{
		double thisvalue = EXAMRateListOld.get(i);
		int thisvalueint =  (int)(thisvalue*10);			
		for(int a=9;a>=thisvalueint;a--)
		{
			//System.out.println(a);
			perOld[a] ++;
		}
	}
	
	for(int i=0;i<EXAMRateListNew.size();i++)
	{
		double thisvalue = EXAMRateListNew.get(i);
		int thisvalueint =  (int)(thisvalue*10);			
		for(int a=9;a>=thisvalueint;a--)
		{
		//	System.out.println(a);
			perNew[a] ++;
		}
	}
		
		for(int z=0;z<10;z++)
		{
			ret +=  (z+1)+"0%EXAM  Old :  "+perOld[z] +"      New :  "+perNew[z] + "\n";
		}
		
		
		return ret;
	}
	
	
	
	public static int calEXAMSpecial(List<statementline> truth,List<statementline> susstatements)
	{
		int before =0;
		int equal = 0;
		int bugpos = 0;
		for(int i=0;i<susstatements.size();i++)
		{
			
			if(isIncorrect(truth,susstatements.get(i)))
			{
				bugpos = susstatements.get(i).possibility;
				break;
			}
		}
		for(int i =0;i<susstatements.size();i++)
		{
		//	System.out.println(susstatements.get(i).Text);
			if(!(susstatements.get(i).Text.contains(" if")||susstatements.get(i).Text.contains("return")))
			{
				//continue;
			}			
			else if(bugpos<susstatements.get(i).possibility)
			{
				before++;
			}
			else if(bugpos==susstatements.get(i).possibility)
			{
				equal++;
			}
			else if(bugpos>susstatements.get(i).possibility)
			{
				break;
			}
		}
		return before+equal/2 +1;
		
	}
	
	
	public static int calEXAM(List<statementline> truth,List<statementline> susstatements)
	{
		int before =0;
		int equal = 0;
		int bugpostmp = 0;
		
		String bugpath="";
		int buglineNum = 0;
		
		
		
		int bugpos =0;
		//20210123
			//int bugpos = 1000000000;
			for(int i=0;i<susstatements.size();i++)
			{
				
				if(isIncorrect(truth,susstatements.get(i)))
	//			if(isIncorrect(truth,susstatements.get(i))&&susstatements.get(i).type.contains(experiment.specialString))
					//20210123注意这个地方我今天为了计算所有语句对应的EXAM而不是第一个错误语句，所以注释掉了，一定记得得改回来
				{
					
					bugpostmp = susstatements.get(i).possibility;
					if(bugpos<=bugpostmp)//20210123注意这个地方我今天为了计算所有语句对应的EXAM而不是第一个错误语句，所以注释掉了，一定记得得改回来
				//	if(bugpos>bugpostmp&&bugpostmp>0.0)
					{
						
						bugpath = susstatements.get(i).Path;
						buglineNum = susstatements.get(i).lineNum;
						bugpos = bugpostmp;
					}
				}
			}
		
			
			
		//if (bugpos <= 0.0||bugpos==1000000000)//20210109
			if (bugpos <= 0.0)
			{
				
				System.out.print("pos:   "+bugpos);
				System.out.print("bugpath:   "+bugpath);
				System.out.print("buglineNum:   "+buglineNum);
				System.exit(0);
				//return 0;//20210123
			}
			
			
		
	//	System.out.println(bugpos);
		
		for(int i =0;i<susstatements.size();i++)
		{
			if(bugpos<susstatements.get(i).possibility)
			{
				before++;
			}
			else if(bugpos==susstatements.get(i).possibility)
			{
				equal++;
			}
			else if(bugpos>susstatements.get(i).possibility)
			{
				break;
			}
		}
		return before+equal/2 +1;
		
	}
	
	public static int TypeLevel(statementline s)
	{
		if(s.type.contains("IfStatement"))
		{
			return 4;
		}
		else if(s.type.contains("ExpressionStatement"))
		{
			return 2;
		}
		else if(s.type.contains(".ForStatement"))
		{
			return 1;
		}
		else if(s.type.contains("ConstructorInvocation"))
		{
			return 0;
		}	
		return 3;
	}
	
//	public static boolean TypeAMoreThanB(statementline Sa, statementline Sb)
//	{
//		
//	}
	
	
	public static double calEXAMRate(List<statementline> truth,List<statementline> susstatements)
	{
		int before =0;
		int equal = 0;
		int bugpostmp = 0;
		
		String bugpath="";
		int buglineNum = 0;
		
		
		
		int bugpos =0;
			
			for(int i=0;i<susstatements.size();i++)
			{
				
				if(isIncorrect(truth,susstatements.get(i)))
				{
					bugpostmp = susstatements.get(i).possibility;
					if(bugpos<=bugpostmp)
					{
						bugpath = susstatements.get(i).Path;
						buglineNum = susstatements.get(i).lineNum;
						bugpos = bugpostmp;
					}
				}
			}
		
			
			
			if (bugpos <= 0.0)//20210109
			{
				
				System.out.print("pos:   "+bugpos);
				System.out.print("bugpath:   "+bugpath);
				System.out.print("buglineNum:   "+buglineNum);
				System.exit(0);
			}
			
			
		
	//	System.out.println(bugpos);
		
		for(int i =0;i<susstatements.size();i++)
		{
			if(bugpos<susstatements.get(i).possibility)
			{
				before++;
			}
			else if(bugpos==susstatements.get(i).possibility)
			{
				equal++;
			}
			else if(bugpos>susstatements.get(i).possibility)
			{
				break;
			}
		}
		double ret =(double)(before+equal/2 +1);
		return (0.000+(int)(1000*ret/susstatements.size()))/1000;
	}
	
	   public static boolean StatementExist(String ProName, int bugID,String path,int lineNum)
		{
		   if(!path.contains(".java"))
		   {path+=".java";}
		   
	    	boolean result = false;
			List<statementline> ret = new ArrayList<statementline>();
			try{
				BufferedReader br = 
						new BufferedReader(new InputStreamReader(new FileInputStream(
				//				"/home/bitse/simfix (backup)/SimFix(1218)/d4j-info/location/ochiai/"+ProName+"/"+bugID+".txt"
						"/home/bitse/simfix (backup)/SimFix(1218)/d4j-info/location/"+experiment.SBFLFomula+"/"+ProName+"/"+bugID+".txt"
						
						
						)));
				List<statementline> statements = new ArrayList<statementline>();
				
				for(String line = br.readLine();line!=null;line = br.readLine())
				{
					if(line.contains(",0.0,"))//这一行意味着只在suspicious statement中确认有无此
					{break;}
//					System.out.println(line);
					statementline l = new statementline();
					l = readtxt.initialLine(line);
					
					
					
					if(l.lineNum.equals(lineNum)&&l.Path.equals(path))
					{
						result = true;
	//					System.out.println("搜索成功！  "+"lineNum: "+lineNum+"   path:  "+path);
					}
					else
					{
//						System.out.println("l.lineNum: "+l.lineNum+"   l.Path:  "+l.Path);
//						System.out.println("lineNum: "+lineNum+"   path:  "+path);
					}
					
				}
				br.close();
			}
			catch(FileNotFoundException e)
			{
				e.printStackTrace();
				
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
			return result;
		}
	
}
