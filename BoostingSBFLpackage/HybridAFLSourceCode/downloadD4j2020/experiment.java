package downloadD4j2020;


import  java.io.BufferedReader;
import java.io.BufferedWriter;
import  java.io.Closeable;
import  java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import  java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.jdt.core.dom.CompilationUnit;

import TestCaseUtile.ASTUtil;




public class experiment {
	public static double changeXpercent = 0.6;

//	public static String SBFLFomula = "ochiaiW";
//	public static String SBFLFomula = "jaccard";
//	public static String SBFLFomula = "dstar";
	public static String SBFLFomula = "barinel";
	
	public static String improList = "";

    public static int CumuEXAMIf = 0;
    public static int CumuEXAMExp = 0;
    public static int CumuEXAMFor = 0;
    public static int CumuEXAMEnhFor = 0;
    public static int CumuEXAMVarDe = 0;
    public static int CumuEXAMRet = 0;
    public static int CumuEXAMXXX = 0;
    public static int CumuEXAMXXXNew = 0;
	public static String specialString = ".EnhancedForStatement";
	
	static String MathRoot = "/src/main/java/";
	// 例如  "/home1/lileping/tmp/Math_1_buggy/src/main/java/org/apache/commons/mat1cjoxh3/fraction"
			
			
	
	public static void runExperiment(D4jProgram Pro)
	{
//		//20210327老師讓計算百分百的明細
//		String EXAMPerListSBFL ="";
//		String EXAMPerListNew ="";
		
		improList +=  "Project:  "+ Pro.ProName + "\n";
		System.out.println("Project: "+Pro.ProName);
		System.out.println("本次调参:   If:  "+Pro.ifsus+"    For:   "+Pro.forsus +   "try:   "+Pro.trysus+ "     Exp:    "+    Pro.expsus +"     ConstructorInvocation/DO =0"); 
		System.out.println();
		// TODO Auto-generated method stub
		//		System.out.println("Project:  "+Pro.ProName +"     SBFL formula:"+ experiment.SBFLFomula);
			
				int impro = 0;
				int lower =0;
				int Top10Old =0;
				int Top30Old =0;
				int Top50Old =0;
				int Top10New =0;
				int Top30New =0;
				int Top50New =0;
				
			//	int totalstatement =0;
				int NumOfBug = 0;
				
				String result = "";
				String resulttmp = "";
		 try{			    	  
	    	  //加循環條參數
	    	//  for(int a=5;a<=25;a=a+5)
			 for(int a=10;a<=10;a=a+2)
	    	  {	    	
	    			int CumuEXAMold = 0;
	    			int CumuEXAMnew = 0; 	    			
	    //			for(int x =49; x<=49;x++)
	    			List<Integer> EXAMListOld = new ArrayList<>(); 
	    			List<Integer> EXAMListNew = new ArrayList<>(); 
	    			List<Double> EXAMRateListOld = new ArrayList<>(); 
	    			List<Double> EXAMRateListNew = new ArrayList<>(); 
	    			
	    	  for(int x =1; x<=Pro.TotalBug;x++)
	    	  {   
	    		//  System.out.print("  BugID: "+x+"   ");
	    		  if(Pro.deprecatedBug.contains(x)||Pro.AddStatementBug.contains(x))
	    		  {
	    			 // System.out.print("跳過"+x);
	    			  continue;
	    		  }
	    		  
	    		  if(x>=Pro.SpecialRoot2Begin)
	    		  {
	    			  Pro.SpecialRoot = Pro.SpecialRoot2;
	    		  }
	    		  else
	    		  {
	    			  Pro.SpecialRoot = Pro.SpecialRoot1;
	    		  }
	    		  NumOfBug++;		    		
	    		  
//		    	  String[] buggyclass = getBugInfo(x,Pro).split("\n");
//	     	  List<statementline> buggystatements = new ArrayList<statementline>();//所有的错误语句
	    		  //20210111改为人工标注
	    		  List<statementline> buggystatements = CollectNewGroundTruth.getGroundTruth(Pro.ProName,x);
		    	  
//		    	  System.out.println("shiyankaishi2");   
//		    	  System.out.println("buggyclass0  "+buggyclass[0]);
		    	  
		    	  
//		    	  if(buggyclass.length==0)
//		    	  {
//		    		  System.out.println("Pro:  "+Pro.ProName+"   BugID:  "+x+"    no buggy class! "  +getBugInfo(x,Pro));
//		    		  
//		    	  }
//		    	  
//		    		//20210110
//		      	boolean modordel=false;
//		      
//		    	  for(int i = 0; i<buggyclass.length;i++)
//		    	  {
//		    		  buggyclass[i] = buggyclass[i].substring(3,buggyclass[i].length());
//		    		  buggyclass[i] = buggyclass[i].replace(".", "/");
//		    		//  System.out.println("错误类数：   "+buggyclass.length);    	
//		    		  
//		    		  //接下來用diff尋找backgroundtruth
//			    	  String DiffInfo = getDiffInfo(x,Pro.ProName,buggyclass[i],Pro.SpecialRoot);
//			    	  
//		//	    	      	 System.out.println("BugID:  "+x  +"    DiffInfo:   "+DiffInfo);
//			    	 
//			    	
//			    	  buggystatements =  getbuggyline(Pro,x,buggystatements,DiffInfo,buggyclass[i]);	//20210110	
//			    	  
//			    	  if(DiffInfo.contains("c")||DiffInfo.contains("d"))
//			    	  {modordel=true;}
//		    	  }
//		    		if(!modordel)
//			      	{
//		    			System.out.println("AddCases!This should be excluded");
//		    			System.exit(0);
//			      	}
//		    		    	  
////		    	  for(int n = 0; n <buggystatements.size();n++)
////		    	  {
////		    		  System.out.println(buggystatements.get(n).Path);
////		    		  System.out.println(buggystatements.get(n).lineNum);
////		    	  System.out.println(buggystatements.get(n).possibility);
////		    		  System.out.println();
////		    	  }
//		    	  
	    		
		    	 List<statementline> statements = new ArrayList<statementline>();
		  		statements = readtxt.getstatementlist(Pro.lowerProName,x);
		  		
//		  		 List<statementline> statementstmp = new ArrayList<statementline>();//20210116统计语句数量,一次性使用
//			  		statementstmp = readtxt.getallstatementlist(Pro.lowerProName,x);
//			  		totalstatement += statementstmp.size();
//			  		if(totalstatement>0)
//			  		{ continue;}
		  		
		  		 List<statementline> s = CumulateType.getstatementtypeNew(Pro, x);
		  		 statements = CumulateType.addTypeInfo(statements, s);
		  		buggystatements = CumulateType.addTypeInfo(buggystatements, s);
		  		
		  	 
		 		//20210123补充实验，暂时写这段代码，以后得删掉
//		  		if(buggystatements.size()>1)
//		  		{
//		  			continue;
//		  		}
//		  		else if (buggystatements.get(0).type.contains(".IfStatement")
//		  				||buggystatements.get(0).type.contains(".ForStatement")
//		  				||buggystatements.get(0).type.contains(".ExpressionStatement")
//		  				||buggystatements.get(0).type.contains(".ReturnStatement")
//		  				||buggystatements.get(0).type.contains(".VariableDeclarationStatement")
//		  				)
//		  		{continue;}
//		  		 for(int i=0;i<buggystatements.size();i++)
//		  		 {
//		  			 for(int j=0;j<statements.size();j++)
//			  		 {
//			  			 if(buggystatements.get(i).Path.equals(statements.get(j).Path)&&buggystatements.get(i).lineNum.equals(statements.get(j).lineNum))
//			  			 {
//			  				buggystatements.get(i).possibility = statements.get(j).possibility;
//			  			 }
//			  		 }
//		  		 }		  		 
//		  		  List<statementline> Newbuggystatements = new  ArrayList<>(); 
//			  		boolean isthistype = false;
//			  		int bugstatenum = buggystatements.size();
//			  		for(int i =0;i<buggystatements.size();i++)
//			  		{
//			  		//	System.out.println(i+"    "+buggystatements.size()+"   "+bugstatenum);
//			  			if(buggystatements.get(i).type.contains(specialString)&&buggystatements.get(i).possibility>0.0)
//			  				{
//			  				isthistype = true;  
//			  				//System.out.println("hahahahaha");
//			  				statementline oneline = buggystatements.get(i);
//			  				Newbuggystatements.add(oneline);
//			  				}
//			  			else
//			  			{			  			
//			  			}
//			  		}
//			  		if(!isthistype)
//			  		{
//			  		//	System.out.println("heiheihei");
//			  			continue;
//			  		}		  		
//			  		buggystatements = Newbuggystatements;
			  		
			  		
//		  		System.out.println("ceshi");
//		  		System.out.println();
//		  		System.out.println("Number of BuggyStatements:  "+buggystatements.size());
//		  		System.out.println("Number of SuspiciousStatements:  "+statements.size());
		  		
		  		
//		  		for(int i = 0 ; i <buggystatements.size();i++ )
//		  		{statementline.printLineInfo(buggystatements.get(i));}
		  		
//		  		
//		  		System.out.println("cesh2");
//		  		
//		  		for(int i = 0 ; i <statements.size()&&i<2;i++ )
//		  		{statementline.printLineInfo(statements.get(i));}
		  		
//		  		System.out.println("Program:  "+"Math-"+ x +"； Traditional SBFL:"+ 
//		  		"  Top-100?  "+ evaluation.top100Bingo(buggystatements, statements) +
//		  		"  Top-300?  "+ evaluation.top300Bingo(buggystatements, statements) +
//		  		"  EXAM?  "+ evaluation.calEXAM(buggystatements, statements) 
//		  				);		  		
//		  		System.out.println("ceshi2:  "+x);	 
		  		
		  		if(buggystatements.size()==0)
		  		{//System.out.println("没有错误语句");
		  		}	
		  		int  EXAMold = evaluation.calEXAM(buggystatements, statements);// 0;//evaluation.calEXAM(buggystatements, statements);
		  		
//		  		for(int i=0;i<statements.size();i++)
//		  		{
//		  			System.out.println();
//		  			System.out.print("    "+statements.get(i).Text);
//		  			System.out.println("    "+statements.get(i).possibility);
//		  			System.out.println("    "+statements.get(i).type);
//		  		}
		  		
		  		
		  		
		  	  double EXAMRateold = evaluation.calEXAMRate(buggystatements, statements);//0;//evaluation.calEXAMRate(buggystatements, statements);
		  	
		  	  
		  	  if(EXAMold<=1)
	    	  {
	    		  Top10Old++;
			  		Top30Old++;
			  		Top50Old++;
	    	  }else if(EXAMold<=3)
	    	  {
	    		  Top30Old++;
			  		Top50Old++;
	    	  }else if(EXAMold<=5)
	    	  {
	    		  Top50Old++;
	    	  }
		  	  
//		  	  if(evaluation.top10Bingo(buggystatements,statements))
//		  	  {
//		  		Top10Old++;
//		  		Top30Old++;
//		  		Top50Old++;
//		  		
//		  	  }		  	  
//		  	  else if(evaluation.top30Bingo(buggystatements,statements))
//		  	  {
//		  		Top30Old++;
//		  		Top50Old++;		  		
//		  	  }
//		  	 
//		  	  else if(evaluation.top50Bingo(buggystatements,statements))
//		  	  {
//		  		Top50Old++;		  		
//		  	  }
		  	  
		  	  CumuEXAMold += EXAMold;		  
		  	  EXAMListOld.add(EXAMold);
		
		  	  //截至此处
		  	EXAMRateListOld.add(EXAMRateold);
			  	  
		  	  
		  	for(int i = 0 ; i<statements.size();i++)
	  		{
	  			String source = searchsource.getStatementText(Pro.ProName,x,statements.get(i),Pro.SpecialRoot);
	  			statements.get(i).Text = source;
	  			

	  		}

			  		
		  
		  	  
		  		for(int i = 0 ; i<statements.size();i++)
		  		{
		  		
		  			String source = statements.get(i).Text;
		  			String sourcetype = statements.get(i).type.trim();
		  			
		  			
		  		
		  			if(sourcetype.contains("IfStatement"))
		  			{	  				
		  	
		  				statements.get(i).possibility = (int)(statements.get(i).possibility*  ((double)(1+(Pro.ifsus-1)*a*0.1))   );//20210126原來是這樣，現在我們改一下變成固定，然後改回來
		  		
		  			}
		  	
		  			else 	if(sourcetype.contains("ReturnStatement"))//RQ7
		  			{
		  			statements.get(i).possibility = (int)(statements.get(i).possibility*  ((double)(1+(Pro.retsus-1)*a*0.1))   );
		
		  			}
		  			
		  			else 	if(sourcetype.contains("ExpressionStatement"))
		  			{
		  		 	  statements.get(i).possibility = (int)(statements.get(i).possibility*  ((double)(1+(Pro.expsus-1)*a*0.1))   );
		  		
		  	
		  			}

		  			else if(sourcetype.contains("ConstructorInvocation"))
			  			{
			  				
		  				statements.get(i).possibility = (int)(statements.get(i).possibility*  0.1  );
			  			}
		  			
		  			else if(sourcetype.contains("VariableDeclarationStatement"))//RQ7
			  			{
		  				statements.get(i).possibility = (int)(statements.get(i).possibility*  ((double)(1+(Pro.vardsus-1)*a*0.1))   );

					  		
			  			}
		  			else if(sourcetype.contains("EnhancedForStatement"))
		  			{
	  				statements.get(i).possibility = (int)(statements.get(i).possibility*  ((double)(1+(Pro.enforsus-1)*a*0.1))   );

				  		
		  			}
		  			
		  			else 	if(sourcetype.contains("ForStatement")&&(!sourcetype.contains("Enhanced")))
		  			//else if(source.contains("for"))//普通for		  				
		  			{
		  				statements.get(i).possibility = (int)(statements.get(i).possibility*  ((double)(1+(Pro.forsus-1)*a*0.1)) );//20220126  臨時注釋掉，要加回來  				
		  	
						  
		  			}
		  		
		  			
		  			
		  			

		  		}
		  		
		  		

		  		
		  	    

		    	  statements  = Rerank(statements);
		    	  

		    		 
		    	  int EXAMnew = evaluation.calEXAM(buggystatements, statements);//0;//evaluation.calEXAM(buggystatements, statements);
		    	  double EXAMRateNew = evaluation.calEXAMRate(buggystatements, statements);// 0;//evaluation.calEXAMRate(buggystatements, statements);
		    	  CumuEXAMnew += EXAMnew;
		    	  EXAMListNew.add(EXAMnew);
		    	  EXAMRateListNew.add(EXAMRateNew);
		    
		    	  
		    	  if(EXAMnew<=1)
		    	  {
		    		  Top10New++;
				  		Top30New++;
				  		Top50New++;
		    	  }else if(EXAMnew<=3)
		    	  {
		    		  Top30New++;
				  		Top50New++;
		    	  }else if(EXAMnew<=5)
		    	  {
		    		  Top50New++;
		    	  }
		    	  
			  	  
//			  	  if(evaluation.top10Bingo(buggystatements,statements))
//			  	  {
//			  		Top10New++;
//			  		Top30New++;
//			  		Top50New++;
//			  		
//			  	  }		  	  
//			  	  else if(evaluation.top30Bingo(buggystatements,statements))
//			  	  {
//			  		Top30New++;
//			  		Top50New++;		  		
//			  	  }
//			  	 
//			  	  else if(evaluation.top50Bingo(buggystatements,statements))
//			  	  {
//			  		Top50New++;		  		
//			  	  }
		    	  
//			  	CumuEXAMXXX += EXAMold;
//				CumuEXAMXXXNew += EXAMnew;
	//			System.out.println("20211017ceshi  EXAM  "+EXAMold +"  "+EXAMnew+"      "+statements.size() +  "   ");
		    	//  System.out.println("ID:  "+ x +"   EXAM:  "+EXAMold);
		    	  	    	  
		    	  if(EXAMnew<EXAMold)//20200121RQ3
		    	  {
		    		  impro++;
		    	//	  System.out.println("Impro-   "+Pro.ProName+ x+ "EXAMnew:" + EXAMnew +"   EXAMold:"+EXAMold);
//		    		  if(buggystatements.size()<=1)
//		    		
//		    		  improList +="  "+ x + buggystatements.get(0).type + "\n";
//		    		  if(buggystatements.size()<=2)
//		    		  for(int i=0;i<buggystatements.size();i++){
//		    		  System.out.println(CumulateType.getstatementtype("/home1/lilectping/tmp/"+Pro.ProName+"_"+x+"_buggy/"+Pro.SpecialRoot +buggystatements.get(i).Path,buggystatements.get(i).lineNum));
//		    	
//		    		  }
		    	  }
		    	  
		    	  if(EXAMnew>EXAMold)
		    	  {
		    		  lower++;
		    	//	  System.out.println("lower-   "+Pro.ProName+ x+ "EXAMnew:" + EXAMnew +"   EXAMold:"+EXAMold);
//		    		  if(buggystatements.size()<=1)				    		
//			    		  improList +="  "+ x + buggystatements.get(0).type + "\n";//这里应该重新定义一个lowerList我懒着改了
		    	  }
		    	
		    	  
//		    	  if(EXAMnew==EXAMold)
//		    	  {
//		    		  if(buggystatements.size()<=1)				    		
//			    		  improList +="  "+ x + buggystatements.get(0).type + "\n";//这里应该重新定义一个equalList我懒着改了 
//		    	  }
		    	  
		    	  
	    	  }
	    	  System.out.println("impro:"+impro+"    lower:"+lower);
	    	  
	    	  double Rimp = 0.0;
	    	  Rimp = ((double)CumuEXAMnew)/((double)CumuEXAMold);
	    	  
//	    	  for(int x=0;x<EXAMRateListOld.size();x++)
//	    	  {
//	    		  System.out.println("OldEXAM:"+EXAMRateListOld.get(x)+"    NewEXAM:"+EXAMRateListNew.get(x));
//	    	  }
	//    	  String EXAMRateList = "EXAM Info！ Project:   " + Pro.ProName +"\n"+ evaluation.ShowEXAMRateChange(EXAMRateListOld,EXAMRateListNew);
	        //  System.out.println(EXAMRateList);
	    	//  System.exit(0);
	    	  
	    	  
	    	  result += ("a="+a   +";   "
	    	  		+ "impro:"+impro+"    lower:"+lower+"     CumuEXAMold:"+CumuEXAMold+"     cumuEXAMnew"+CumuEXAMnew
	    	  		+"      Rimp:"+ Rimp + "\n" );
	    	  result += ("   Top10 Old:  "+Top1Old+ "   Top30 Old:  "+Top3Old + "   Top50 Old:  "+Top5Old +"\n");
	    	  result += ("   Top10 New:  "+Top1New+ "   Top30 New:  "+Top3New + "   Top50 New:  "+Top5New +"\n");
	    	  
	   // 	  result += ("Mean1stRankOld:  "+ calMFR(EXAMListOld)+"     Mean1stRankNew:   "+ calMFR(EXAMListNew)+"\n");
	    	  
	   // 	  result += EXAMRateList;
	    	//  System.exit(0);
	    	  System.out.println("Project:  "+ Pro.ProName + "     bug总数:"+ NumOfBug);
	    	  impro=0;
	    	  lower=0;
	    	  Top10Old =0;
	    	  Top30Old =0;
	    	  Top50Old = 0;
	    	  Top10New= 0;
	    	  Top30New=0;
	    	  Top50New=0;
	    	  NumOfBug =0;
	    	//	System.out.println("Project:  "+ Pro.ProName + "     语句总数:"+ totalstatement);
	    	 
//	    	  System.out.println("EXAMListOld:");
//	    	  for(int i=0;i<EXAMListOld.size();i++){
//	    		  System.out.print("   "+EXAMListOld.get(i));
//	    	  }
//	    	  
//	    	  System.out.println("EXAMListNew:");
//	    	  for(int i=0;i<EXAMListNew.size();i++){
//	    		  System.out.print("   "+EXAMListNew.get(i));
//	    	  }
	    	  
	    	  
	    	  //20210327统计用
//	    	  System.out.println("EXAMRateListOld:");
//	    	  for(int i=0;i<EXAMRateListOld.size();i++){
//	    		  System.out.print("   "+EXAMRateListOld.get(i));
//	    	  }
//	    	  
//	    	  System.out.println("EXAMRateListNew:");
//	    	  for(int i=0;i<EXAMRateListNew.size();i++){
//	    		  System.out.print("   "+EXAMRateListNew.get(i));
//	    	  }
	    	  
	      	}
	    	  
	    	  System.out.println(result);
	    	  
	    
	    	  
	    	  
	      }
			catch(Exception e){e.printStackTrace();}
	}
	
	
	public static void main(String[] args) {
		D4jProgram Math = new D4jProgram();
		Math.ProName = "Math";
		Math.lowerProName = "math";
		Math.TotalBug = 106;
		Math.SpecialRoot1 = "/src/main/java/";
		Math.SpecialRoot2 = "/src/java/";
		Math.MainFile ="- org.";
		Math.SpecialRoot2Begin = 85;
		int[] MathExcludeID = {1,10,102,103,104,106,12,13,17,18,19,20,25,28,3,36,39,4,45,48,5,51,53,71,73,78,
				84,89,90,95,99};//12,104 修改处不被trigger test覆盖，舍弃//95不明原因Gzoltar覆盖bug block但不记录bug statement
		Math = D4jProgram.ExcludeAddSituation(Math, MathExcludeID);
		
		
		
		D4jProgram Time = new D4jProgram();
		Time.ProName = "Time";
		Time.lowerProName = "time";
		Time.TotalBug = 27;
		Time.SpecialRoot1 = "/src/main/java/";
		Time.deprecatedBug.add(21);
		Time.MainFile ="- org.";
		int[] TimeExcludeID = {14,15,18,24,25,27,3,20,6};//20211017 加上20; 6號bug找不到groundtruth
		Time = D4jProgram.ExcludeAddSituation(Time, TimeExcludeID);
		
		
		D4jProgram Lang = new D4jProgram();
		Lang.ProName = "Lang";
		Lang.lowerProName = "lang";
		Lang.TotalBug = 65;
		Lang.SpecialRoot1 = "/src/main/java/";
		Lang.SpecialRoot2 = "/src/java/";
		Lang.deprecatedBug.add(2);
		Lang.SpecialRoot2Begin = 36;		
		Lang.MainFile ="- org.";
		int[] LangExcludeID = {3,5,11,12,13,14,18,2,23,28,29,31,37,38,39,43,44,45,47,48,49,51,52,53,54,55,56,62,64,65,9};//29,56modified state不被trigger test覆盖，舍弃
		Lang = D4jProgram.ExcludeAddSituation(Lang, LangExcludeID);
		
		
		D4jProgram Closure = new D4jProgram();
		Closure.ProName = "Closure";
		Closure.lowerProName = "closure";
		Closure.TotalBug = 133;
		Closure.SpecialRoot1 = "/src/";
		//Closure.SpecialRoot2 = "/src/java/";
		Closure.deprecatedBug.add(63);
		Closure.deprecatedBug.add(93);
		//Closure.SpecialRoot2Begin = 63;	
		Closure.MainFile ="- com.";
		int[] ClosureExcludeID = {1,103,107,114,116,117,118,119,12,120,123,124,125,129,133,15,19,2,26,28,29,33,36,41,42,43,44,5,
				53,56,58,60,61,66,68,69,72,77,8,80,81,84,88,9,91,94,95,98};//9 ,68,72,117trigger test不覆盖modified element,舍弃
		Closure = D4jProgram.ExcludeAddSituation(Closure, ClosureExcludeID);
		
		
		D4jProgram Chart = new D4jProgram();
		Chart.ProName = "Chart";
		Chart.lowerProName = "chart";
		Chart.TotalBug = 26;
		Chart.SpecialRoot1 = "/source/";
		//Chart.SpecialRoot2 = "/src/java/";
		
		//Chart.SpecialRoot2Begin = 63;	
		Chart.MainFile ="- org.";
		int[] ChartExcludeID = {3,4,14,15,19,21,23,26,2};//20211017 9號是沒問題的，新加2
		Chart = D4jProgram.ExcludeAddSituation(Chart, ChartExcludeID);
		
		D4jProgram Mockito = new D4jProgram();
		Mockito.ProName = "Mockito";
		Mockito.lowerProName = "mockito";
		Mockito.TotalBug = 38;
		Mockito.SpecialRoot1 = "/src/";
		//Mockito.SpecialRoot2 = "/src/java/";
		
		//Mockito.SpecialRoot2Begin = 63;	
		Mockito.MainFile ="- org.";
		int[] MockitoExcludeID = {12,15,18,2,36,37,7,9,8,4,5,11,30,38};//20211017 mockito 8 也是增加語句//4,5,11,30,38找不到groundtruth
		Mockito = D4jProgram.ExcludeAddSituation(Mockito, MockitoExcludeID);
		
		
		//the following projects are D4j new version
		
		D4jProgram Cli = new D4jProgram();
		Cli.ProName = "Cli";
		Cli.lowerProName = "cli";
		Cli.TotalBug = 40;
		Cli.SpecialRoot1 = "/src/java/";
		Cli.SpecialRoot2 = "/src/main/java/";
		
		Cli.SpecialRoot2Begin = 30;	
		Cli.MainFile ="- org.";
		int[] CliExcludeID = {6,16,17,18,19,21,35,5};//18,19 trigger test不覆盖modified、deleted 语句，舍弃
		Cli = D4jProgram.ExcludeAddSituation(Cli, CliExcludeID);
		
		D4jProgram Compress = new D4jProgram();
		Compress.ProName = "Compress";
		Compress.lowerProName = "compress";
		Compress.TotalBug = 47;
		Compress.SpecialRoot1 = "/src/main/java/";
		Compress.SpecialRoot2 = "/src/main/java/";
		
		Compress.SpecialRoot2Begin = 100;	
		Compress.MainFile ="- org.";
		int[] CompressExcludeID = {1,3,11,13,18,25,26,29,30,33,36,44};
		Compress = D4jProgram.ExcludeAddSituation(Compress, CompressExcludeID);
		
		D4jProgram Codec = new D4jProgram();
		Codec.ProName = "Codec";
		Codec.lowerProName = "codec";
		Codec.TotalBug = 18;
		Codec.SpecialRoot1 = "/src/java/";
		Codec.SpecialRoot2 = "/src/main/java/";
		
		Codec.SpecialRoot2Begin = 11;	
		Codec.MainFile ="- org.";
		int[] CodecExcludeID = {5,12,13,16};//13 cannot be used,16groundtruth空
		Codec = D4jProgram.ExcludeAddSituation(Codec, CodecExcludeID);
		
		D4jProgram Collections = new D4jProgram();
		Collections.ProName = "Collections";
		Collections.lowerProName = "collections";
		Collections.TotalBug = 28;
		Collections.SpecialRoot1 = "/src/main/java/";
		Collections.SpecialRoot2 = "/src/main/java/";
		
		Collections.SpecialRoot2Begin = 25;	
		Collections.MainFile ="- org.";
		int[] CollectionsExcludeID = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,26,27,28};
		//1-24已經失效，26groundtruth空,27-28是增加操作
		Collections = D4jProgram.ExcludeAddSituation(Collections, CollectionsExcludeID);
		
		D4jProgram Csv = new D4jProgram();
		Csv.ProName = "Csv";
		Csv.lowerProName = "csv";
		Csv.TotalBug = 16;
		Csv.SpecialRoot1 = "/src/main/java/";
		Csv.SpecialRoot2 = "/src/main/java/";
		
		Csv.SpecialRoot2Begin = 100;	
		Csv.MainFile ="- org.";
		int[] CsvExcludeID = {10,2,3,5,6,7,9,12};//12groundtruth 空
		Csv = D4jProgram.ExcludeAddSituation(Csv, CsvExcludeID);
		
		D4jProgram Gson = new D4jProgram();
		Gson.ProName = "Gson";
		Gson.lowerProName = "gson";
		Gson.TotalBug = 18;
		Gson.SpecialRoot1 = "/gson/src/main/java/";
		Gson.SpecialRoot2 = "/gson/src/main/java/";
		
		Gson.SpecialRoot2Begin = 100;	
		Gson.MainFile ="- com.";
		int[] GsonExcludeID = {1,11,12,14,16,18,5,6,8,9};//9號 groundtruth空
		Gson = D4jProgram.ExcludeAddSituation(Gson, GsonExcludeID);
		
		D4jProgram JacksonCore = new D4jProgram();
		JacksonCore.ProName = "JacksonCore";
		JacksonCore.lowerProName = "jacksonCore";
		JacksonCore.TotalBug = 26;
		JacksonCore.SpecialRoot1 = "/src/main/java/";
		JacksonCore.SpecialRoot2 = "/src/main/java/";
		
		JacksonCore.SpecialRoot2Begin = 100;	
		JacksonCore.MainFile ="- com.";
		int[] JacksonCoreExcludeID = {11,13,15,19,21,23,26,3,7,9,1};//1號 groundtruth空
		JacksonCore = D4jProgram.ExcludeAddSituation(JacksonCore, JacksonCoreExcludeID);
		
		D4jProgram JacksonXml = new D4jProgram();
		JacksonXml.ProName = "JacksonXml";
		JacksonXml.lowerProName = "jacksonXml";
		JacksonXml.TotalBug = 26;
		JacksonXml.SpecialRoot1 = "/src/main/java/";
		JacksonXml.SpecialRoot2 = "/src/main/java/";
		
		JacksonXml.SpecialRoot2Begin = 1;	
		JacksonXml.MainFile ="- com.";
		int[] JacksonXmlExcludeID = {};
		JacksonXml = D4jProgram.ExcludeAddSituation(JacksonXml, JacksonXmlExcludeID);
		
		D4jProgram JacksonDatabind = new D4jProgram();
		JacksonDatabind.ProName = "JacksonDatabind";
		JacksonDatabind.lowerProName = "jacksonDatabind";
		JacksonDatabind.TotalBug = 112;
		JacksonDatabind.SpecialRoot1 = "/src/main/java/";
		JacksonDatabind.SpecialRoot2 = "/src/main/java/";
		
		JacksonDatabind.SpecialRoot2Begin = 200;	
		JacksonDatabind.MainFile ="- com.";
		int[] JacksonDatabindExcludeID = {1,104,105,106,109,13,19,2,20,21,23,26,29,30,31,32,36,39,
				4,40,42,44,47,48,49,5,50,51,52,58,59,61,62,7,72,74,76,77,78,80,81,84,86,88,89,92,94,99};
		//81,105 trigger test 不覆盖 bug state
		JacksonDatabind = D4jProgram.ExcludeAddSituation(JacksonDatabind, JacksonDatabindExcludeID);
		
		
		D4jProgram JxPath = new D4jProgram();
		JxPath.ProName = "JxPath";
		JxPath.lowerProName = "jxPath";
		JxPath.TotalBug = 22;
		JxPath.SpecialRoot1 = "/src/java/";
		JxPath.SpecialRoot2 = "/src/java/";
		
		JxPath.SpecialRoot2Begin = 200;	
		JxPath.MainFile ="- org.";
		int[] JxPathExcludeID = {14,2,3,8,11,12,13,15,16,17,18,22};//	int[] JxPathExcludeID = {13,15,2,3};
		//11,12,13,15,16,17,18,22groundtruth空
		
		JxPath = D4jProgram.ExcludeAddSituation(JxPath, JxPathExcludeID);
		
		D4jProgram Jsoup = new D4jProgram();
		Jsoup.ProName = "Jsoup";
		Jsoup.lowerProName = "jsoup";
		Jsoup.TotalBug = 93;
		Jsoup.SpecialRoot1 = "/src/main/java/";
		Jsoup.SpecialRoot2 = "/src/main/java/";
		
		Jsoup.SpecialRoot2Begin = 200;	
		Jsoup.MainFile ="- org.";
		int[] JsoupExcludeID = {10,11,13,14,17,19,2,20,25,26,31,33,35,36,38,39,4,44,53,54,55,56,59,60,67,69,7,71,72,74,76,78,80,81,82,9,90,91,93};
		//4,9 ,17,25 trigger test 不覆盖 bug state
		Jsoup.deprecatedBug.add(1);
		Jsoup = D4jProgram.ExcludeAddSituation(Jsoup, JsoupExcludeID);
	
	
		
		Closure.ifsus = 2.51;	
		Compress.ifsus = 2.93;
		Math.ifsus = 2.58;
		Cli.ifsus = 2.53;
		Jsoup.ifsus = 2.82;		
		Lang.ifsus = 2.51;
		JacksonDatabind.ifsus = 2.73;
		Chart.ifsus=2.66;
		Codec.ifsus=2.66;
		Csv.ifsus=2.66;
		Gson.ifsus=2.66;
		JacksonCore.ifsus=2.66;
		Mockito.ifsus=2.66;
		Time.ifsus=2.66;
		JxPath.ifsus=2.66;
		Collections.ifsus=2.66;	
				
		Closure.vardsus = 0.79;	
		Compress.vardsus = 0.81;
		Math.vardsus = 0.80;
		Cli.vardsus = 0.85;
		Jsoup.vardsus = 0.87;		
		Lang.vardsus = 0.76;
		JacksonDatabind.vardsus = 0.83;
		Chart.vardsus=0.81;
		Codec.vardsus=0.81;
		Csv.vardsus=0.81;
		Gson.vardsus=0.81;
		JacksonCore.vardsus=0.81;
		Mockito.vardsus=0.81;
		Time.vardsus=0.81;
		JxPath.vardsus=0.81;
		Collections.vardsus=0.81;	

		Closure.expsus = 0.61;	
		Compress.expsus = 0.58;
		Math.expsus = 0.56;
		Cli.expsus = 0.56;
		Jsoup.expsus = 0.59;		
		Lang.expsus = 0.58;
		JacksonDatabind.expsus = 0.56;
		Chart.expsus=0.58;
		Codec.expsus=0.58;
		Csv.expsus=0.58;
		Gson.expsus=0.58;
		JacksonCore.expsus=0.58;
		Mockito.expsus=0.58;
		Time.expsus=0.58;
		JxPath.expsus=0.58;
		Collections.expsus=0.58;	
		
		Closure.enforsus = 0.30;	
		Compress.enforsus = 0.50;
		Math.enforsus = 0.33;
		Cli.enforsus = 0.50;
		Jsoup.enforsus = 0.44;		
		Lang.enforsus = 0.28;
		JacksonDatabind.enforsus = 0.50;
		Chart.enforsus=0.40;
		Codec.enforsus=0.40;
		Csv.enforsus=0.40;
		Gson.enforsus=0.40;
		JacksonCore.enforsus=0.40;
		Mockito.enforsus=0.40;
		Time.enforsus=0.40;
		JxPath.enforsus=0.40;
		Collections.enforsus=0.40;
		
		Closure.forsus = 0.41;	
		Compress.forsus = 0.44;
		Math.forsus = 0.54;
		Cli.forsus = 0.67;
		Jsoup.forsus = 0.67;		
		Lang.forsus = 0.46;
		JacksonDatabind.forsus = 0.45;
		Chart.forsus=0.51;
		Codec.forsus=0.51;
		Csv.forsus=0.51;
		Gson.forsus=0.51;
		JacksonCore.forsus=0.51;
		Mockito.forsus=0.51;
		Time.forsus=0.51;
		JxPath.forsus=0.51;
		Collections.forsus=0.51;
		
		Closure.retsus = 1.27;	
		Compress.retsus = 1.17;
		Math.retsus = 1.19;
		Cli.retsus = 1.21;
		Jsoup.retsus = 1.47;		
		Lang.retsus = 1.17;
		JacksonDatabind.retsus = 1.21;
		Chart.retsus=1.24;
		Codec.retsus=1.24;
		Csv.retsus=1.24;
		Gson.retsus=1.24;
		JacksonCore.retsus=1.24;
		Mockito.retsus=1.24;
		Time.retsus=1.24;
		JxPath.retsus=1.24;
		Collections.retsus=1.24;

		
		runExperiment(Math);
		runExperiment(Lang);
		runExperiment(Closure);
		runExperiment(Cli);
		runExperiment(Compress);
		runExperiment(JacksonDatabind);
		runExperiment(Jsoup);

	    runExperiment(Time);

		runExperiment(Chart);
		runExperiment(Mockito);

		runExperiment(Codec);
		runExperiment(Csv);		
		runExperiment(Collections);
		runExperiment(Gson);
		runExperiment(JacksonCore);

		runExperiment(JxPath);
		



     
	}
	
    public static List<statementline> getbuggyline(D4jProgram Pro, int BugID,List<statementline> pre,String dinfo,String Path) throws Exception
    {
    
    	
    	List<statementline> ret = pre;
    	
    	String[] raw = dinfo.split("\n");
    	for(int i = 0 ; i < raw.length;i++)
    	{
    		String[] qiege = new String[2];
    		if(raw[i].contains("c"))
    		{
    			 qiege = raw[i].split("c");
    		
    		}
    		else if(raw[i].contains("d"))
    		{
    			qiege = raw[i].split("d");  			
    		
    		}
    		else if(raw[i].contains("a"))
    		{
    			//20201211老师让去掉Add语句的情况,因而这样的修改处不算错
    			 //qiege = raw[i].split("a");    	
    			continue;
    		}
    		
    		
			if(qiege[0].contains(","))
			{
				String[] qiege2 = qiege[0].split(",");    			
				
				int begin = Integer.valueOf(qiege2[0]);
				int end = Integer.valueOf(qiege2[1]);
				for(int k = begin;k<=end;k++)
				{
					statementline l = new statementline();
					l.Path = Path+".java";
					l.lineNum = k;					
					if(shouldSkip(Pro,BugID,l))
					{
						continue;
					}
					
					
					
					//此处为了确认有的占有多行的语句，其sbfl标注的是首行x，但diff命令检测的是x+1行被修改的情况		
					
					if((!evaluation.StatementExist(Pro.lowerProName, BugID, Path,l.lineNum)))
					{l.lineNum = l.lineNum-1;}
				
					
					
					if((!evaluation.StatementExist(Pro.lowerProName, BugID, Path,l.lineNum)))
					{
		//				System.out.println("参数如下："  + Pro.lowerProName + "    " + BugID + "    " +Path+ "     "+ l.lineNum   );
						
						l.lineNum = getstatementbegin(
								"/home1/lileping/tmp/"+Pro.ProName+"_"+BugID+"_buggy/"+
												 Pro.SpecialRoot +	l.Path,
										l.lineNum );
						
	//							System.out.println("处理生效1，处理后行号：   "+l.lineNum);
	//							System.out.println(l.lineNum);
					}			
					if((!evaluation.StatementExist(Pro.lowerProName, BugID, Path,l.lineNum)))
					{
		//				System.out.println("处理生效异常1");
		//				System.out.println(l.lineNum);
					//	System.exit(0);
					}
					else
					{
						ret.add(l);
					}
				}    				
			
			}
			else
			{
				
				
    			statementline l = new statementline();
    			l.lineNum = Integer.valueOf(qiege[0]);
    			l.Path = Path+".java";
    		
    			if(shouldSkip(Pro,BugID,l))//20210110注意这里虽然只有一个，但也是continue，继续外圈循环
				{
					continue;
				}
    			
    			if((!evaluation.StatementExist(Pro.lowerProName, BugID, Path,l.lineNum)))
				{l.lineNum = l.lineNum-1;}
    			
    			if(!evaluation.StatementExist(Pro.lowerProName, BugID, Path,l.lineNum))
				{
	//				System.out.println("参数如下："  + Pro.lowerProName + "    " + BugID + "    " +Path+ "     "+ l.lineNum   );
					
					l.Path = Path+".java";
					//l.lineNum = k;					
					l.lineNum = getstatementbegin(
					"/home1/lileping/tmp/"+Pro.ProName+"_"+BugID+"_buggy/"+
									 Pro.SpecialRoot +	l.Path,
							l.lineNum );
			
	//				System.out.println("处理生效2，处理后行号：   "+l.lineNum);
	//				System.out.println(l.lineNum);
				
				}			
    			if(!evaluation.StatementExist(Pro.lowerProName, BugID, Path,l.lineNum))
    			{
    //				System.out.println("处理生效异常2");
	//				System.out.println(l.lineNum);
				//	System.exit(0);
    			}
    			else
    			{
    				ret.add(l);
    			}
    			
    		
			}
    		
    	}
    	
    
    	
    	return ret;
    }

    public static void runCmd() throws Exception {
    	//chart1-26;closure1-5,7-40;lang 1,3-65;math1-106;time 1-20,22-27
    	
//    	for(int i = 1; i<=106;i++)
//    	{
//    		 getOriginalRepoBug(i, "Math","math");
//    	}
//    	for(int i = 1; i<=65;i++)
//    	{
//    		 getOriginalRepoBug(i, "Lang","lang");
//    	}
//    	for(int i = 1; i<=26;i++)
//    	{
//    		getOriginalRepoBug(i, "Chart","chart");
//    	}
//    	for(int i = 1; i<=133;i++)
//    	{
//    		 getOriginalRepoBug(i, "Closure","closure");
//    	}
//
    	for(int i = 1; i<=27;i++)
    	{
    		getOriginalRepoBug(i, "Time","time");
    	}
//      
//    	for(int i = 1; i<=38;i++)
//    	{
//    		 getOriginalRepo(i, "Mockito");
//    	}
 //   	
//    	for(int i = 1; i<=93;i++)
//    	{
//    		 getOriginalRepo(i, "Jsoup");
//    	}
    	
//     	for(int i = 1; i<=47;i++)
//    	{
//    		 getOriginalRepoBug(i, "Compress");
//    		 getOriginalRepoFix(i, "Compress");
//    	}  	
    	
//     	for(int i = 1; i<=47;i++)
//    	{
//    		 getOriginalRepoBug(i, "Cli");
//    		 getOriginalRepoFix(i, "Cli");
//    	}    	
       	
//     	for(int i = 1; i<=18;i++)
//    	{
//    		 getOriginalRepoBug(i, "Codec");
//    		 getOriginalRepoFix(i, "Codec");
//    	}
   
//    	for(int i = 1; i<=16;i++)
//    	{
//    		 getOriginalRepoBug(i, "Csv");
//    		 getOriginalRepoFix(i, "Csv");
//    	}
    	
//      	for(int i = 1; i<=18;i++)
//    	{
//    		 getOriginalRepoBug(i, "Gson");
//    		 getOriginalRepoFix(i, "Gson");
//    	}
      	
//    	for(int i = 1; i<=26;i++)
//    	{
//    		 getOriginalRepoBug(i, "JacksonCore");
//    		 getOriginalRepoFix(i, "JacksonCore");
//    	}
    	
//    	for(int i = 1; i<=112;i++)
//    	{
//    		 getOriginalRepoBug(i, "JacksonDatabind");
//    		 getOriginalRepoFix(i, "JacksonDatabind");
//    	}
    	
//     	for(int i = 1; i<=93;i++)
//    	{
//    		 getOriginalRepoBug(i, "Jsoup");
//    		 getOriginalRepoFix(i, "Jsoup");
//    	}
    	
//      	for(int i = 1; i<=22;i++)
//    	{
//    		 getOriginalRepoBug(i, "JxPath");
//    		 getOriginalRepoFix(i, "JxPath");
//    	}
    	
//      	for(int i = 25; i<=28;i++)
//    	{
//    		 getOriginalRepoBug(i, "Collections");
//    		 getOriginalRepoFix(i, "Collections");
//    	}
    	
//       	for(int i = 1; i<=6;i++)
//    	{
//    		 getOriginalRepoBug(i, "JacksonXml");
//    		 getOriginalRepoFix(i, "JacksonXml");
//    	}
    	
     //   String cmd1= "git checkout c8afaa3e869cc8c25577641553e0d0b5bdac78b5";

    }

    public static void getOriginalRepoBug(int i, String repo,String repolow) throws Exception {

        //Step1 clone original repo

//            String cmd1 ="/users/yanjiejiang/defects4j/framework/bin/defects4j checkout -p "+repo+" -v "+i+"f -w /Users/yanjiejiang/Downloads/checkout/"+repo+"_"+i+"_fix";
//            String r1 =execCmd(cmd1,null);
//            String cmd2 ="/users/yanjiejiang/defects4j/framework/bin/defects4j checkout -p "+repo+" -v "+i+"b -w /Users/yanjiejiang/Downloads/checkout/"+repo+"_"+i+"_buggy";
//            String r2 = execCmd(cmd2,null);
    
 //   	   String cmd1 = "defects4j checkout -p " + repo+" -v "+i+"f -w /home1/lileping/tmp2/"+repo+"_"+i+"_fix";
    	  // String cmd1 = "defects4j checkout -p " + repo+" -v "+i+"b -w /home1/lileping/tmp/"+repo+"_"+i+"_buggy";
 	   String cmd1 = "defects4j checkout -p " + repo+" -v "+i+"b -w /home1/lileping/experimentbugs/"+repolow+"/"+repolow+"_"+i+"_buggy";
       	
    	   System.out.println(cmd1);
    	   String r1 =execCmd(cmd1,null);
      //     String cmd2 ="/users/yanjiejiang/defects4j/framework/bin/defects4j checkout -p "+repo+" -v "+i+"b -w /Users/yanjiejiang/Downloads/checkout/"+repo+"_"+i+"_buggy";
      //     String r2 = execCmd(cmd2,null);
    
    	   System.out.println(r1);
    }
    
    public static void getOriginalRepoFix(int i, String repo) throws Exception {

        //Step1 clone original repo

//            String cmd1 ="/users/yanjiejiang/defects4j/framework/bin/defects4j checkout -p "+repo+" -v "+i+"f -w /Users/yanjiejiang/Downloads/checkout/"+repo+"_"+i+"_fix";
//            String r1 =execCmd(cmd1,null);
//            String cmd2 ="/users/yanjiejiang/defects4j/framework/bin/defects4j checkout -p "+repo+" -v "+i+"b -w /Users/yanjiejiang/Downloads/checkout/"+repo+"_"+i+"_buggy";
//            String r2 = execCmd(cmd2,null);
    
    	   String cmd1 = "defects4j checkout -p " + repo+" -v "+i+"f -w /home1/lileping/tmp2/"+repo+"_"+i+"_fix";
//    	   String cmd1 = "defects4j checkout -p " + repo+" -v "+i+"b -w /home1/lileping/tmp/"+repo+"_"+i+"_buggy";
       	
    	   System.out.println(cmd1);
    	   String r1 =execCmd(cmd1,null);
      //     String cmd2 ="/users/yanjiejiang/defects4j/framework/bin/defects4j checkout -p "+repo+" -v "+i+"b -w /Users/yanjiejiang/Downloads/checkout/"+repo+"_"+i+"_buggy";
      //     String r2 = execCmd(cmd2,null);
    
    	   System.out.println(r1);
    }
    
//    public static String[] getBugPath(int i, String repo) throws Exception 
//    {
//    	
//    }
    
    
    public static String getBugInfo(int i, D4jProgram Program) throws Exception 
    {   	
    	String repo = Program.ProName;
    	String cmd = "defects4j info -p "+repo+ " -b "+i;
   // 	System.out.println(cmd);
   //    System.out.println(execCmd(cmd,null));	
    	StringBuilder result = new StringBuilder();

          Process process = null;
          BufferedReader bufrIn = null;
          BufferedReader bufrError = null;

          try {
              // 执行命令, 返回一个子进程对象（命令在子进程中执行）
              process = Runtime.getRuntime().exec(cmd, null, null);

              // 方法阻塞, 等待命令执行完成（成功会返回0）
              process.waitFor();

              // 获取命令执行结果, 有两个结果: 正常的输出 和 错误的输出（PS: 子进程的输出就是主进程的输入）
              bufrIn = new BufferedReader(new InputStreamReader(process.getInputStream(), "UTF-8"));
              bufrError = new BufferedReader(new InputStreamReader(process.getErrorStream(), "UTF-8"));

              // 读取输出
          
              String line = null;
              while ((line = bufrIn.readLine()) != null) {
                  if(line.contains(Program.MainFile.trim())&&(!line.contains("::")))
                  {
                	//  System.out.println(line);
                	  result.append(line).append('\n');
                  }
              }              
              
              
              while ((line = bufrError.readLine()) != null) {
                 // result.append(line).append('\n');
 //          	  System.out.println(line);//此处本应保留,但避免文本过多,暂时注释掉
              }

          } finally {
              closeStream(bufrIn);
              closeStream(bufrError);

              // 销毁子进程
              if (process != null) {
                  process.destroy();
              }
          }

     
          // 返回执行结果
          
       
          return result.toString();
    }
    
    public static String getDiffInfo(int i, String repo,String path,String root) throws Exception 
    {   	
    	String cmd1 = "diff /home1/lileping/tmp/"+repo+"_"+i+"_buggy/"+ root + path + ".java "
    			+ "/home1/lileping/tmp2/"+repo+"_"+i+"_fix/" + root +path + ".java";
    	//   例如 /home1/lileping/tmp/Math_1_buggy/src/main/java/org/apache/commons/math3/fraction
//     cmd1 = cmd1.replace("//", "/");//20201207针对Lang项目路径不同一问题暂时遏制
    	
    //	System.out.println(cmd1);
    	StringBuilder result = new StringBuilder();

        Process process = null;
        BufferedReader bufrIn = null;
        BufferedReader bufrError = null;

        try {
            // 执行命令, 返回一个子进程对象（命令在子进程中执行）
            process = Runtime.getRuntime().exec(cmd1, null, null);

            // 方法阻塞, 等待命令执行完成（成功会返回0）
            process.waitFor();

            // 获取命令执行结果, 有两个结果: 正常的输出 和 错误的输出（PS: 子进程的输出就是主进程的输入）
            bufrIn = new BufferedReader(new InputStreamReader(process.getInputStream(), "UTF-8"));
            bufrError = new BufferedReader(new InputStreamReader(process.getErrorStream(), "UTF-8"));

            // 读取输出
        
            String line = null;
            while ((line = bufrIn.readLine()) != null) {
                if(!line.contains(">")&&!line.contains("<")&&!line.contains("--"))
                {
                	if(!(line.contains("newline")))
                	result.append(line).append('\n');
                }
            }              
            
            
            while ((line = bufrError.readLine()) != null) {
               // result.append(line).append('\n');
         	  System.out.println("discover error:"+line);//此处本应保留,为避免输出文本过多,暂时注释掉
            }

        } finally {
            closeStream(bufrIn);
            closeStream(bufrError);

            // 销毁子进程
            if (process != null) {
                process.destroy();
            }
        }

    
        
        // 返回执行结果
        return result.toString();
    }
    
    /**
     * 执行系统命令, 返回执行结果
     *
     * @param cmd 需要执行的命令
     * @param dir 执行命令的子进程的工作目录, null 表示和当前主进程工作目录相同
     */
    public static String execCmd(String cmd, File dir) throws Exception {
        StringBuilder result = new StringBuilder();

        Process process = null;
        BufferedReader bufrIn = null;
        BufferedReader bufrError = null;

        try {
            // 执行命令, 返回一个子进程对象（命令在子进程中执行）
            process = Runtime.getRuntime().exec(cmd, null, dir);

            // 方法阻塞, 等待命令执行完成（成功会返回0）
            process.waitFor();

            // 获取命令执行结果, 有两个结果: 正常的输出 和 错误的输出（PS: 子进程的输出就是主进程的输入）
            bufrIn = new BufferedReader(new InputStreamReader(process.getInputStream(), "UTF-8"));
            bufrError = new BufferedReader(new InputStreamReader(process.getErrorStream(), "UTF-8"));

            // 读取输出
            String line = null;
            while ((line = bufrIn.readLine()) != null) {
                result.append(line).append('\n');
            }
            while ((line = bufrError.readLine()) != null) {
                result.append(line).append('\n');
            }

        } finally {
            closeStream(bufrIn);
            closeStream(bufrError);

            // 销毁子进程
            if (process != null) {
                process.destroy();
            }
        }
        // 返回执行结果
        return result.toString();
    }

    private static void closeStream(Closeable stream) {
        if (stream != null) {
            try {
                stream.close();
            } catch (Exception e) {
                // nothing
            }
        }
    }

    public static List<statementline> Rerank(List<statementline> statements)
    {
    	for(int i = 0 ; i < statements.size()-1;i++)
    	{
    		for(int j = i+1; j<statements.size();j++)
    		{
    			if(statements.get(i).possibility<statements.get(j).possibility)
    			{
    				//statementline st1 = statements.get(i);
    				//statementline st2 = statements.get(j);    				
    				Collections.swap(statements, i, j);
    			}
    		}
    	}    	
    	return statements;
    }    
    
    public static List<statementline> Rerank2(List<statementline> statements)//20210127尝试在可疑度相同的语句中内部按照语句类型排序。
    {
    	for(int i = 0 ; i < statements.size()-1;i++)
    	{
    		for(int j = i+1; j<statements.size();j++)
    		{
    			if      ( (statements.get(i).possibility==statements.get(j).possibility)
    					&&(evaluation.TypeLevel( statements.get(i))<evaluation.TypeLevel( statements.get(j))))
    			{
    				//statementline st1 = statements.get(i);
    				//statementline st2 = statements.get(j);    				
    				Collections.swap(statements, i, j);
    			}
    		}
    	}    	
    	return statements;
    }    
    
    
    public static int getstatementbegin(String path,int x) throws Exception
    {
    	int result =-1;    	
  	  File candidate = new File(path);
  	 
  			Map<Integer, DataNode> candidateNodes = new HashMap<>();
  			String absolutePath = candidate.getAbsolutePath();
  			
  		//	System.out.println("測試"+absolutePath);
  			String dirPah = absolutePath.substring(0, absolutePath.lastIndexOf('/'));
  			try {
  				CompilationUnit unit = ASTUtil.getCompilationUnit2(absolutePath, candidate.getName(), dirPah, true);
  				test.ID = 0;
  				test.getDirectChildren(unit, 0, candidateNodes);  		
              
              for(int i =0;i<candidateNodes.size();i++)
              {
              	DataNode nd = candidateNodes.get(i);
              	int begin = 0;
              	int end = 0;
                            	 
              	 if(nd.nodeType.toString().contains("ForStatement")
              			||nd.nodeType.toString().contains("IfStatement")
              			||nd.nodeType.toString().contains("EnhancedForStatement")
              			||nd.nodeType.toString().contains("DoStatement")
              			||nd.nodeType.toString().contains("SwitchCase")
              			||nd.nodeType.toString().contains("WhileStatement")            			
              			||nd.nodeType.toString().contains("TryStatement")
              			)
              	{
              		 begin = unit.getLineNumber(nd.node.getStartPosition());  
              		 
              		 for(int tmp=0;tmp< nd.childrenLables.size();tmp++)
              		 {
              			 DataNode ndc = candidateNodes.get(nd.childrenLables.get(tmp));
              			 if(ndc.nodeType.contains("Block")||
              				ndc.nodeType.contains("Statement")||
              				ndc.nodeType.contains("ConstructorInvocation")||
              				ndc.nodeType.contains("SuperConstructorInvocation")||
              				ndc.nodeType.contains("SwitchCase")
              				              				
              					 )
              			 {
              			end = Math.max(unit.getLineNumber(ndc.node.getStartPosition())-1,
              					unit.getLineNumber(	candidateNodes.get(ndc.label-1).node.getStartPosition()+candidateNodes.get(ndc.label-1).node.getLength())
              					);
              			end = Math.max(begin, end);
              			//20200110这个begin有漏洞！不能直接用begin
//              			System.out.println();
//              			System.out.println("end:  "+end);
//              			System.out.println("ndctype:   "+ndc.nodeType);
//              			System.out.println("下一个-1： "+(unit.getLineNumber(ndc.node.getStartPosition())-1));
//              			System.out.println("begin： "+begin);
              				 break;
              			 }
              		 }          		 
              		 
              	
              		
              	}
              	 else if(nd.nodeType.toString().contains("Statement")||
              			 nd.nodeType.toString().contains("ImportDeclaration")||             			
              			 nd.nodeType.contains("ConstructorInvocation")||
           				nd.nodeType.contains("SuperConstructorInvocation")||
           				nd.nodeType.contains("SwitchCase")   ||         			 
           				nd.nodeType.contains("FieldDeclaration")||
           				nd.nodeType.contains("MethodDeclaration")
              			 )
              	 {
              			begin = unit.getLineNumber(nd.node.getStartPosition());
                  		end = unit.getLineNumber(nd.node.getStartPosition()+nd.node.getLength());//�˴�������Ҫ-1            		 
              	 }   
             // 		System.out.println(nd.node+"    "+nd.node.getStartPosition()); 
              
              	if(begin <=x &&end >=x)
              	{
              		//return begin;//20200110
              		result = begin;
              	}
              }
              
  		
  			} catch (IOException e) {
  				// TODO Auto-generated catch block
  				e.printStackTrace();
  			}
  			//return 0;
  		
  			return result;
    }
    
    public static boolean shouldSkip(D4jProgram Pro,int BugID, statementline l)
	{
    	String thisline = searchsource.getStatementText(Pro.ProName,BugID,l,Pro.SpecialRoot).trim();
		if(thisline.length()<=1||thisline.equals("{")||thisline.equals("}")||thisline.equals(";"))
		{
	//	System.out.println("实验成功！1001");
			return true;
		
		}
		else
		{return false;}
	}
    
    
    public static int calMFR ( List<Integer>  EXAMList)
    {
    	String tryprint ="";
    	
    	
    	
    	int[] Descend = new int[EXAMList.size()];
    	for(int i = 0;i<EXAMList.size()-1;i++)
    	{
    		Descend[i] = EXAMList.get(i);    
    		 tryprint += Descend[i]+ " ";
    	}
    	for(int i=0;i<Descend.length-1;i++)
    	{
    		for(int j=i;j<Descend.length;j++)
    		{
    			if(Descend[i]<Descend[j])
    			{
    				int tmp = Descend[i];
    				Descend[i] = Descend[j];
    				Descend[j] = tmp;
    			}
    		}
    	}
    	tryprint +="\n";
    	
    	for(int i = 0;i<EXAMList.size()-1;i++)
    	{    	   
    		 tryprint += Descend[i]+ " ";
    	}
    //	System.out.println(tryprint);
    	if(EXAMList.size()%2==0)
    	{
    		return (Descend[Descend.length/2-1]+Descend[Descend.length/2])/2;
    	}
    	else
    	{
    		return Descend[Descend.length/2-1];
    	}
    	
    }
    
    
}
