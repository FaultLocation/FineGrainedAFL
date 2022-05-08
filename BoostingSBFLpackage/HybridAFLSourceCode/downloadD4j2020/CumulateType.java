package downloadD4j2020;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.jdt.core.dom.CompilationUnit;

import TestCaseUtile.ASTUtil;



import java.io.File;
import java.util.ArrayList;



public class CumulateType {

	
	public static int[] ImproListMath = {  8,  11 , 15 , 16 , 23 , 24 , 32 , 33 , 42 , 52 , 54 , 58 , 67 , 68  ,80 , 81  ,82,  85  ,86 , 94 , 100 , 101,  105};
	public static int[] ImproListLang = { 16 , 22  ,25 , 27  ,36,  57 , 58,  61};
	public static int[] ImproListClosure = {  3 , 4  ,10  ,17 , 18,  20 , 31,  38 , 50 , 51 , 52,  55,  57,  59 , 62 , 67  ,73 , 75 , 89 , 90  ,92  ,96 , 99,  104 , 106,  108  ,112 , 113  ,121 , 122 ,127  ,128 , 130 , 131 , 132};
	public static int[] ImproListCli = { 3,  7,  9  ,11 , 13,  26 , 38};
	public static int[] ImproListCompress = { 5,  17 , 19  ,37 , 38 , 40};
	public static int[] ImproListJacksonDatabind = {   8,  9  ,16 , 27 , 33 , 43 , 66  ,71  ,83 , 90,  95  ,110};
	public static int[] ImproListJsoup = {  15 , 18  ,23,  29  ,34,  40  ,42 , 43,  45 , 47,  48,  50  ,51,  75 , 84,  86,  89};
	
	
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
		
		
//		try {
//			List<statementline> statements = getstatementtypeNew(Cli,1);
//			for(int i=0;i<statements.size();i=i+10)
//			{
//				System.out.println(i);
//				System.out.println(statements.get(i).Path);
//				System.out.println(statements.get(i).lineNum);
//				System.out.println(statements.get(i).type);
//			}
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		

		
		
		
		Math = D4jProgram.ExcludeAddSituation(Math, ImproListMath);
		Closure = D4jProgram.ExcludeAddSituation(Closure, ImproListClosure);
		Lang = D4jProgram.ExcludeAddSituation(Lang, ImproListLang);
		Compress = D4jProgram.ExcludeAddSituation(Compress, ImproListCompress);
		Cli = D4jProgram.ExcludeAddSituation(Closure, ImproListCli);
		JacksonDatabind = D4jProgram.ExcludeAddSituation(JacksonDatabind, ImproListJacksonDatabind);
		Jsoup = D4jProgram.ExcludeAddSituation(Jsoup, ImproListJsoup);
//		
		
//		RecordStatementTypeToTxt(JacksonDatabind); //done2
//		RecordStatementTypeToTxt(Compress);//done 2 
//		RecordStatementTypeToTxt(Math);//	//done2
//		RecordStatementTypeToTxt(Lang);//done2
//		RecordStatementTypeToTxt(Closure);//需要时间dong2	
//		RecordStatementTypeToTxt(Cli);//done2
//		
//		RecordStatementTypeToTxt(Jsoup);  //done2
//		
//		RecordStatementTypeToTxt(Time);//20210126
//		RecordStatementTypeToTxt(Chart);//20210126
		
//		RecordStatementTypeToTxt(Codec);//20211024
//		RecordStatementTypeToTxt(Collections);//20211024
//		RecordStatementTypeToTxt(Csv);//20211024
//		RecordStatementTypeToTxt(JacksonCore);//20211024
//		RecordStatementTypeToTxt(Gson);//20211024
	//	RecordStatementTypeToTxt(Mockito);//20211017
//		RecordStatementTypeToTxt(JxPath);//20211024
		
		//20211028改造以後，ExpreesionStatement被拆分成Assignmment和MethodInvocation
	//	RecordStatementTypeToTxtUpgraded(Lang);
//		RecordStatementTypeToTxtUpgraded(JacksonDatabind); //
//		RecordStatementTypeToTxtUpgraded(Compress);// 
//		RecordStatementTypeToTxtUpgraded(Math);//	//
//		RecordStatementTypeToTxtUpgraded(Jsoup);//
//		RecordStatementTypeToTxtUpgraded(Closure);//	
//		RecordStatementTypeToTxtUpgraded(Cli);//
		
//		 runCumulateExperimentUpgraded(Math);地罵熱土
//		 runCumulateExperimentUpgraded(Lang);
//		 runCumulateExperimentUpgraded(Closure);
//		 runCumulateExperimentUpgraded(Cli);
//		 runCumulateExperimentUpgraded(Compress);
//		 runCumulateExperimentUpgraded(Jsoup);  
//		 runCumulateExperimentUpgraded(JacksonDatabind); 
		runCumulateExperimentUpgraded(Chart);
		runCumulateExperimentUpgraded(Codec);
		runCumulateExperimentUpgraded(Csv);
		runCumulateExperimentUpgraded(Gson);
		runCumulateExperimentUpgraded(JacksonCore);
		runCumulateExperimentUpgraded(Mockito);
		runCumulateExperimentUpgraded(Time);
		runCumulateExperimentUpgraded(JxPath);
			
			//	runCumulateExperimentStatic(Cli);
//				runCumulateExperimentStatic(Math);
//				runCumulateExperimentStatic(Closure);
//				runCumulateExperimentStatic(Lang);
//				runCumulateExperimentStatic(Compress);
//				runCumulateExperimentStatic(JacksonDatabind);
//				runCumulateExperimentStatic(Jsoup);
//		runCumulateExperimentStatic(Chart);
//		runCumulateExperimentStatic(Codec);
//		runCumulateExperimentStatic(Csv);
//		runCumulateExperimentStatic(Gson);
//		runCumulateExperimentStatic(JacksonCore);
//		runCumulateExperimentStatic(Mockito);
//		runCumulateExperimentStatic(Time);
//		runCumulateExperimentStatic(JxPath);
	//	runCumulateExperimentStatic(Collections);
		
			//	System.exit(0);
		 
		 
//20210829为了empirical study增加方法粒度信息		
//		RecordStatementParentMethodToTxt(JacksonDatabind);
//		RecordStatementParentMethodToTxt(Compress);
//		RecordStatementParentMethodToTxt(Math);
//		RecordStatementParentMethodToTxt(Lang);
//		RecordStatementParentMethodToTxt(Jsoup);  
//   	RecordStatementParentMethodToTxt(Closure);
//		RecordStatementParentMethodToTxt(Cli);//已完成20210829
//		

		
		
		
//		
//		RecordStatementParentMethodToTxt(Time);
//		RecordStatementParentMethodToTxt(Chart);
		
//		 runCumulateExperiment(Math);//20200111	
//		 runCumulateExperiment(Lang);//20210111
//		 runCumulateExperiment(Closure);//已完成//20200111
//		 runCumulateExperiment(Cli);//20200111
//		   runCumulateExperiment(Compress);//20200111
//			runCumulateExperiment(Jsoup);  //20210111
//		 runCumulateExperiment(JacksonDatabind); 

//		
//		// runCumulateExperiment(Chart);
//		// runCumulateExperiment(Mockito);
//		// runCumulateExperiment(Time);
//		
//		// D4j1.4version

		
		// runCumulateExperiment(Codec);
		// runCumulateExperiment(Csv);
		// runCumulateExperiment(Gson);
//		runCumulateExperiment(JacksonCore);
		//
	
	//	 runCumulateExperiment(JxPath);//7失败
	
		

		// 1 AssertStatement,
		// 2 Block,
		// 3 BreakStatement,
		// 4 ConstructorInvocation,
		// 5 ContinueStatement,
		// 6 DoStatement,
		// 7 EmptyStatement,
		// 8 EnhancedForStatement
		// 9 ExpressionStatement,
		// 10 ForStatement,
		// 11 IfStatement,
		// 12 LabeledStatement,
		// 13 ReturnStatement,
		// 14 SuperConstructorInvocation,
		// 15 SwitchCase,
		// 16 SwitchStatement,
		// 17 SynchronizedStatement,
		// 18 ThrowStatement,
		// 19 TryStatement,
		// 20 TypeDeclarationStatement,
		// 21 VariableDeclarationStatement,
		// 22 WhileStatement
		// 23 ImportDeclaration

	}
	
	public static List<statementline> addTypeInfo(List<statementline> statements, List<statementline> s )
	{ 
		for(int i=0; i<statements.size();i++)
		{
			 int thisLine = statements.get(i).lineNum;
			 String thisPath = statements.get(i).Path;
			 for(int j=0;j<s.size();j++)
			 {
				 int thatLine = s.get(j).lineNum;
				 String thatPath = s.get(j).Path;
				 if(thisLine==thatLine && thisPath.equals(thatPath))
				 {
					 statements.get(i).type = s.get(j).type;
					 break;
				 }
			 }
		}
		return statements;
	}
	
	

	public static void runCumulateExperiment(D4jProgram Pro) {
		
		int TotalAssertStatement = 0;

		int TotalBlock = 0;
		int TotalBreakStatement = 0;
		int TotalConstructorInvocation = 0;
		int TotalContinueStatement = 0, TotalDoStatement = 0, TotalEmptyStatement = 0, TotalEnhancedForStatement = 0,
				TotalExpressionStatement = 0, TotalForStatement = 0, TotalIfStatement = 0, TotalLabeledStatement = 0,
				TotalReturnStatement = 0, TotalSuperConstructorInvocation = 0, TotalSwitchCase = 0,
				TotalSwitchStatement = 0, TotalSynchronizedStatement = 0, TotalThrowStatement = 0,
				TotalTryStatement = 0, TotalTypeDeclarationStatement = 0, TotalVariableDeclarationStatement = 0,
				TotalWhileStatement = 0, TotalImportDeclaration = 0;

		// TODO Auto-generated method stub

		String result = "";
		int jiezhi = 0;
		try {

			// for(int x =1; x<=Pro.TotalBug;x++)
			
			 //for(int x =1; x<=Pro.TotalBug;x++)
	//	for (int x = 1; x <=Pro.TotalBug; x++)// JYJ 改 Pro.TotalBug number
											// Pro.TotalBug
			for (int x =1; x <=Pro.TotalBug; x++)
			{

				if (Pro.deprecatedBug.contains(x) || Pro.AddStatementBug.contains(x)) {
					System.out.println("Project:  " + Pro.ProName + "    BugID:  " + x + "   废弃");
					// System.out.print("跳過"+x);
					continue;
				}
				
				
				
				
				System.out.println("Project:  " + Pro.ProName + "    BugID:  " + x);

				if (x >= Pro.SpecialRoot2Begin) {
					Pro.SpecialRoot = Pro.SpecialRoot2;
				} else {
					Pro.SpecialRoot = Pro.SpecialRoot1;
				}

				//20210111最新改版：人工标注groundtruth的bug statement
				List<statementline> buggystatements = CollectNewGroundTruth.getGroundTruth(Pro.ProName, x);
				
//				String[] buggyclass = experiment.getBugInfo(x, Pro).split("\n");
//				List<statementline> buggystatements = new ArrayList<statementline>();// 所有的错误语句
//
//				// System.out.println("shiyankaishi2");
//				// System.out.println("buggyclass0 "+buggyclass[0]);
//
//				for (int i = 0; i < buggyclass.length; i++) {
//					buggyclass[i] = buggyclass[i].substring(3, buggyclass[i].length());
//					buggyclass[i] = buggyclass[i].replace(".", "/");
//					// System.out.println(buggyclass[i]);
//
//					// 接下來用diff尋找backgroundtruth
//					String DiffInfo = experiment.getDiffInfo(x, Pro.ProName, buggyclass[i], Pro.SpecialRoot);
//
//					// System.out.println(DiffInfo);
//
//					buggystatements = experiment.getbuggyline(Pro,x, buggystatements, DiffInfo, buggyclass[i]);
//					
//				}

//				 for(int n = 0; n <buggystatements.size();n++)
//				 {
//				 System.out.println(buggystatements.get(n).Path);
//				 System.out.println(buggystatements.get(n).lineNum);
//				 System.out.println();
//				 }

//				List<statementline> statements = new ArrayList<statementline>();
//				statements = readtxt.getstatementlist(Pro.lowerProName, x);

				// System.out.println();
				// System.out.println("測試結束");
				// System.exit(0);
				 

				// System.out.println("ceshi");
				// System.out.println();
				// System.out.println("Number of BuggyStatements:
				// "+buggystatements.size());
	//			 System.out.println("Project:  "+Pro.ProName+"      Number of SuspiciousStatements:"+statements.size());

				// for(int i = 0 ; i <buggystatements.size();i++ )
				// {statementline.printLineInfo(buggystatements.get(i));}
				//

//				for (int i = 0; i < statements.size(); i++) {
//					String source = searchsource.getStatementText(Pro.ProName, x, statements.get(i), Pro.SpecialRoot);
//					statements.get(i).Text = source;
//				}

				// 20201230统计语句类型从此处开始，分别统计statements和buggystatements

				 for(int i = 0;
				 i<buggystatements.size();i++)//20201231这一行用于统计错误的语句类型
		//		for (int i = 0; i < statements.size(); i++)// 20201231这一行用与统计总体的语句类型
				{
					if(i % 100 ==0 ) {
						System.out.println(i);
					}
					// 20201231这里的两行用于统计错误的语句类型
					 String path =
					 "/home1/tmp/"+Pro.ProName+"_"+x+"_buggy/"+
					 Pro.SpecialRoot + buggystatements.get(i).Path;
					 int lineNum = buggystatements.get(i).lineNum;
					
					
					
					

					// 20201231这里的两行用于统计总体的语句类型
//					String path = "/home1/tmp/" + Pro.ProName + "_" + x + "_buggy/" + Pro.SpecialRoot
//							+ statements.get(i).Path;
//					int lineNum = statements.get(i).lineNum;

					// System.out.println(path+" "+lineNum);
					// System.exit(0);
					// System.out.println(B6.getstatementtype(path,lineNum));

					// 1 AssertStatement,
					// 2 Block,
					// 3 BreakStatement,
					// 4 ConstructorInvocation,
					// 5 ContinueStatement,
					// 6 DoStatement,
					// 7 EmptyStatement,
					// 8 EnhancedForStatement
					// 9 ExpressionStatement,
					// 10 ForStatement,
					// 11 IfStatement,
					// 12 LabeledStatement,
					// 13 ReturnStatement,
					// 14 SuperConstructorInvocation,
					// 15 SwitchCase,
					// 16 SwitchStatement,
					// 17 SynchronizedStatement,
					// 18 ThrowStatement,
					// 19 TryStatement,
					// 20 TypeDeclarationStatement,
					// 21 VariableDeclarationStatement,
					// 22 WhileStatement
					// 23 ImportDeclaration

					String thistype = getstatementtype(path, lineNum);
					if (thistype == null) {
					} else if (thistype.contains("AssertStatement")) {
						TotalAssertStatement++;
					} else if (thistype.contains("Block")) {
						TotalBlock++;
					} else if (thistype.contains("BreakStatement")) {
						TotalBreakStatement++;
					} else if (thistype.contains("ConstructorInvocation")) {
						TotalConstructorInvocation++;
					} else if (thistype.contains("ContinueStatement")) {
						TotalContinueStatement++;
					} else if (thistype.contains("DoStatement")) {
						TotalDoStatement++;
					} else if (thistype.contains("EmptyStatement")) {
						TotalEmptyStatement++;
					} else if (thistype.contains("EnhancedForStatement")) {
						TotalEnhancedForStatement++;
					} else if (thistype.contains("ExpressionStatement")) {
						TotalExpressionStatement++;
					} else if (thistype.contains("ForStatement")) {
						TotalForStatement++;
					} else if (thistype.contains("IfStatement")) {
						TotalIfStatement++;
					} else if (thistype.contains("LabeledStatement")) {
						TotalLabeledStatement++;
					} else if (thistype.contains("ReturnStatement")) {
						TotalReturnStatement++;
					} else if (thistype.contains("SuperConstructorInvocation")) {
						TotalSuperConstructorInvocation++;
					} else if (thistype.contains("SwitchCase")) {
						TotalSwitchCase++;
					} else if (thistype.contains("SwitchStatement")) {
						TotalSwitchStatement++;
					} else if (thistype.contains("SynchronizedStatement")) {
						TotalSynchronizedStatement++;
					} else if (thistype.contains("ThrowStatement")) {
						TotalThrowStatement++;
					} else if (thistype.contains("TryStatement")) {
						TotalTryStatement++;
					} else if (thistype.contains("TypeDeclarationStatement")) {
						TotalTypeDeclarationStatement++;
					} else if (thistype.contains("VariableDeclarationStatement")) {
						TotalVariableDeclarationStatement++;
					} else if (thistype.contains("WhileStatement")) {
						TotalWhileStatement++;
					} else if (thistype.contains("ImportDeclaration")) {
						TotalImportDeclaration++;
					}

				}

				// if(specialbug){
				// System.out.println("Project: "+Pro.ProName+" ID: "+x+"
				// SpecialEXAM: "+ EXAMSpecialold+" EXAM: "+ EXAMold);
				// }

				// for(int i = 0 ; i<statements.size();i++)
				// {
				// //String source =
				// searchsource.getStatementText(Pro.ProName,x,statements.get(i),Pro.SpecialRoot);
				// //statements.get(i).Text = source;
				// String source = statements.get(i).Text;
				// if(source.contains(" if") )
				// {
				//
				//
				// }
				// }

				// for(int i = 0 ; i<statements.size();i++)
				// {
				// System.out.println("score: "+statements.get(i).possibility+ "
				// text: "+statements.get(i).Text);
				// System.out.println("Path: "+ statements.get(i).Path+ "
				// 行:"+statements.get(i).lineNum);
				// }

				jiezhi = x;

				// 截至此括号为一个bug version的循环
			}

			if (false) {// 这里单纯为了调程序的时候省事
				System.out.println("Project:  " + Pro.ProName);
				// 1 AssertStatement,
				// 2 Block,
				// 3 BreakStatement,
				// 4 ConstructorInvocation,
				// 5 ContinueStatement,
				System.out.println("AssertStatement:  " + TotalAssertStatement);
				System.out.println("Block:  " + TotalBlock);
				System.out.println("BreakStatement:  " + TotalBreakStatement);
				System.out.println("ConstructorInvocation:  " + TotalConstructorInvocation);
				System.out.println("ContinueStatement:  " + TotalContinueStatement);
				// 6 DoStatement,
				// 7 EmptyStatement,
				// 8 EnhancedForStatement
				// 9 ExpressionStatement,
				// 10 ForStatement,
				System.out.println("DoStatement:  " + TotalDoStatement);
				System.out.println("EmptyStatement:  " + TotalEmptyStatement);
				System.out.println("EnhancedForStatement:  " + TotalEnhancedForStatement);
				System.out.println("ExpressionStatement:  " + TotalExpressionStatement);
				System.out.println("ForStatement:  " + TotalForStatement);
				// 11 IfStatement,
				// 12 LabeledStatement,
				// 13 ReturnStatement,
				// 14 SuperConstructorInvocation,
				// 15 SwitchCase,
				System.out.println("IfStatement:  " + TotalIfStatement);
				System.out.println("LabeledStatement:  " + TotalLabeledStatement);
				System.out.println("ReturnStatement:  " + TotalReturnStatement);
				System.out.println("SuperConstructorInvocation:  " + TotalSuperConstructorInvocation);
				System.out.println("SwitchCase:  " + TotalSwitchCase);
				// 16 SwitchStatement,
				// 17 SynchronizedStatement,
				// 18 ThrowStatement,
				// 19 TryStatement,
				// 20 TypeDeclarationStatement,
				// 21 VariableDeclarationStatement,
				// 22 WhileStatement
				// 23 ImportDeclaration
				System.out.println("SwitchStatement:  " + TotalSwitchStatement);
				System.out.println("SynchronizedStatement:  " + TotalSynchronizedStatement);
				System.out.println("ThrowStatement:  " + TotalThrowStatement);
				System.out.println("TryStatement:  " + TotalTryStatement);
				System.out.println("TypeDeclarationStatement:  " + TotalTypeDeclarationStatement);

				System.out.println("VariableDeclarationStatement:  " + TotalVariableDeclarationStatement);
				System.out.println("WhileStatement:  " + TotalWhileStatement);
				System.out.println("ImportDeclaration:  " + TotalImportDeclaration);
			}

			result += "\n" + ("Project:  " + Pro.ProName);

			result += "\n" + ("AssertStatement:  " + TotalAssertStatement);
			result += "\n" + ("Block:  " + TotalBlock);
			result += "\n" + ("BreakStatement:  " + TotalBreakStatement);
			result += "\n" + ("ConstructorInvocation:  " + TotalConstructorInvocation);
			result += "\n" + ("ContinueStatement:  " + TotalContinueStatement);

			result += "\n" + ("DoStatement:  " + TotalDoStatement);
			result += "\n" + ("EmptyStatement:  " + TotalEmptyStatement);
			result += "\n" + ("EnhancedForStatement:  " + TotalEnhancedForStatement);
			result += "\n" + ("ExpressionStatement:  " + TotalExpressionStatement);
			result += "\n" + ("ForStatement:  " + TotalForStatement);

			result += "\n" + ("IfStatement:  " + TotalIfStatement);
			result += "\n" + ("LabeledStatement:  " + TotalLabeledStatement);
			result += "\n" + ("ReturnStatement:  " + TotalReturnStatement);
			result += "\n" + ("SuperConstructorInvocation:  " + TotalSuperConstructorInvocation);
			result += "\n" + ("SwitchCase:  " + TotalSwitchCase);

			result += "\n" + ("SwitchStatement:  " + TotalSwitchStatement);
			result += "\n" + ("SynchronizedStatement:  " + TotalSynchronizedStatement);
			result += "\n" + ("ThrowStatement:  " + TotalThrowStatement);
			result += "\n" + ("TryStatement:  " + TotalTryStatement);
			result += "\n" + ("TypeDeclarationStatement:  " + TotalTypeDeclarationStatement);

			result += "\n" + ("VariableDeclarationStatement:  " + TotalVariableDeclarationStatement);
			result += "\n" + ("WhileStatement:  " + TotalWhileStatement);
			result += "\n" + ("ImportDeclaration:  " + TotalImportDeclaration);

			result += "\n" + "\n" + "项目：     " + Pro.ProName + "     编号截至：" + jiezhi;

			String filepath01 = "/home1/D4jTypeBugImpro/" + Pro.ProName;
			File newF01 = new File(filepath01);
			if (!newF01.exists()) {
				newF01.mkdir();
			}

			String filepath = "/home1/D4jTypeBugImpro/" + Pro.ProName + "/" +1 + ".txt";// JYJ
																								// 改
																					
			// 1.txt
																								// 2.txt
																								// 3.txt...
			File newF = new File(filepath);
			if (!newF.exists()) {
				try {
					newF.createNewFile();
					BufferedWriter out = new BufferedWriter(new FileWriter(filepath));
					out.write(result);
					out.close();
					System.out.println("文件创建成功！");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			System.out.println();

			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
public static void runCumulateExperimentUpgraded(D4jProgram Pro) {
		
		int TotalAssertStatement = 0;

		int TotalBlock = 0;
		int TotalBreakStatement = 0;
		int TotalConstructorInvocation = 0;
		int TotalContinueStatement = 0, TotalDoStatement = 0, TotalEmptyStatement = 0, TotalEnhancedForStatement = 0,
				TotalExpressionStatement = 0, TotalForStatement = 0, TotalIfStatement = 0, TotalLabeledStatement = 0,
				TotalReturnStatement = 0, TotalSuperConstructorInvocation = 0, TotalSwitchCase = 0,
				TotalSwitchStatement = 0, TotalSynchronizedStatement = 0, TotalThrowStatement = 0,
				TotalTryStatement = 0, TotalTypeDeclarationStatement = 0, TotalVariableDeclarationStatement = 0,
				TotalWhileStatement = 0, TotalImportDeclaration = 0;
		int TotalMethodInvocation=0;
		int TotalAssignment =0;
		// TODO Auto-generated method stub

		String result = "";
		int jiezhi = 0;
		try {

			// for(int x =1; x<=Pro.TotalBug;x++)
			
			 //for(int x =1; x<=Pro.TotalBug;x++)
	//	for (int x = 1; x <=Pro.TotalBug; x++)// JYJ 改 Pro.TotalBug number
											// Pro.TotalBug
			for (int x =1; x <=Pro.TotalBug; x++)
			{

				if (Pro.deprecatedBug.contains(x) || Pro.AddStatementBug.contains(x)) {
					System.out.println("Project:  " + Pro.ProName + "    BugID:  " + x + "   废弃");
					// System.out.print("跳過"+x);
					continue;
				}
				
				
				
				
				System.out.println("Project:  " + Pro.ProName + "    BugID:  " + x);

				if (x >= Pro.SpecialRoot2Begin) {
					Pro.SpecialRoot = Pro.SpecialRoot2;
				} else {
					Pro.SpecialRoot = Pro.SpecialRoot1;
				}

				//20210111最新改版：人工标注groundtruth的bug statement
//				List<statementline> buggystatements = CollectNewGroundTruth.getGroundTruth(Pro.ProName, x);
				
//				String[] buggyclass = experiment.getBugInfo(x, Pro).split("\n");
//				List<statementline> buggystatements = new ArrayList<statementline>();// 所有的错误语句
//
//				// System.out.println("shiyankaishi2");
//				// System.out.println("buggyclass0 "+buggyclass[0]);
//
//				for (int i = 0; i < buggyclass.length; i++) {
//					buggyclass[i] = buggyclass[i].substring(3, buggyclass[i].length());
//					buggyclass[i] = buggyclass[i].replace(".", "/");
//					// System.out.println(buggyclass[i]);
//
//					// 接下來用diff尋找backgroundtruth
//					String DiffInfo = experiment.getDiffInfo(x, Pro.ProName, buggyclass[i], Pro.SpecialRoot);
//
//					// System.out.println(DiffInfo);
//
//					buggystatements = experiment.getbuggyline(Pro,x, buggystatements, DiffInfo, buggyclass[i]);
//					
//				}

//				 for(int n = 0; n <buggystatements.size();n++)
//				 {
//				 System.out.println(buggystatements.get(n).Path);
//				 System.out.println(buggystatements.get(n).lineNum);
//				 System.out.println();
//				 }

				List<statementline> statements = new ArrayList<statementline>();
				statements = readtxt.getstatementlist(Pro.lowerProName, x);

				// System.out.println();
				// System.out.println("測試結束");
				// System.exit(0);
				 

				// System.out.println("ceshi");
				// System.out.println();
				// System.out.println("Number of BuggyStatements:
				// "+buggystatements.size());
	//			 System.out.println("Project:  "+Pro.ProName+"      Number of SuspiciousStatements:"+statements.size());

				// for(int i = 0 ; i <buggystatements.size();i++ )
				// {statementline.printLineInfo(buggystatements.get(i));}
				//

//				for (int i = 0; i < statements.size(); i++) {
//					String source = searchsource.getStatementText(Pro.ProName, x, statements.get(i), Pro.SpecialRoot);
//					statements.get(i).Text = source;
//				}

				// 20201230统计语句类型从此处开始，分别统计statements和buggystatements

//				 for(int i = 0;
//				 i<buggystatements.size();i++)//20201231这一行用于统计错误的语句类型
				for (int i = 0; i < statements.size(); i++)// 20201231这一行用与统计总体的语句类型
				{
					if(i % 100 ==0 ) {
						System.out.println(i);
					}
//					// 20201231这里的两行用于统计错误的语句类型
//					 String path =
//					 "/home1/tmp/"+Pro.ProName+"_"+x+"_buggy/"+
//					 Pro.SpecialRoot + buggystatements.get(i).Path;
//					 int lineNum = buggystatements.get(i).lineNum;
					
					
					
					

					// 20201231这里的两行用于统计总体的语句类型
					String path = "/home1/tmp/" + Pro.ProName + "_" + x + "_buggy/" + Pro.SpecialRoot
							+ statements.get(i).Path;
					int lineNum = statements.get(i).lineNum;

					// System.out.println(path+" "+lineNum);
					// System.exit(0);
					// System.out.println(B6.getstatementtype(path,lineNum));

					// 1 AssertStatement,
					// 2 Block,
					// 3 BreakStatement,
					// 4 ConstructorInvocation,
					// 5 ContinueStatement,
					// 6 DoStatement,
					// 7 EmptyStatement,
					// 8 EnhancedForStatement
					// 9 ExpressionStatement,
					// 10 ForStatement,
					// 11 IfStatement,
					// 12 LabeledStatement,
					// 13 ReturnStatement,
					// 14 SuperConstructorInvocation,
					// 15 SwitchCase,
					// 16 SwitchStatement,
					// 17 SynchronizedStatement,
					// 18 ThrowStatement,
					// 19 TryStatement,
					// 20 TypeDeclarationStatement,
					// 21 VariableDeclarationStatement,
					// 22 WhileStatement
					// 23 ImportDeclaration

					String thistype = getstatementtypeUpgraded(path, lineNum);
					if (thistype == null) {
					} else if (thistype.contains("AssertStatement")) {
						TotalAssertStatement++;
					} else if (thistype.contains("Block")) {
						TotalBlock++;
					} else if (thistype.contains("BreakStatement")) {
						TotalBreakStatement++;
					} else if (thistype.contains("ConstructorInvocation")) {
						TotalConstructorInvocation++;
					} else if (thistype.contains("ContinueStatement")) {
						TotalContinueStatement++;
					} else if (thistype.contains("DoStatement")) {
						TotalDoStatement++;
					} else if (thistype.contains("EmptyStatement")) {
						TotalEmptyStatement++;
					} else if (thistype.contains("EnhancedForStatement")) {
						TotalEnhancedForStatement++;
					} else if (thistype.contains("ExpressionStatement")) {
						TotalExpressionStatement++;
					} else if (thistype.contains("ForStatement")) {
						TotalForStatement++;
					} else if (thistype.contains("IfStatement")) {
						TotalIfStatement++;
					} else if (thistype.contains("LabeledStatement")) {
						TotalLabeledStatement++;
					} else if (thistype.contains("ReturnStatement")) {
						TotalReturnStatement++;
					} else if (thistype.contains("SuperConstructorInvocation")) {
						TotalSuperConstructorInvocation++;
					} else if (thistype.contains("SwitchCase")) {
						TotalSwitchCase++;
					} else if (thistype.contains("SwitchStatement")) {
						TotalSwitchStatement++;
					} else if (thistype.contains("SynchronizedStatement")) {
						TotalSynchronizedStatement++;
					} else if (thistype.contains("ThrowStatement")) {
						TotalThrowStatement++;
					} else if (thistype.contains("TryStatement")) {
						TotalTryStatement++;
					} else if (thistype.contains("TypeDeclarationStatement")) {
						TotalTypeDeclarationStatement++;
					} else if (thistype.contains("VariableDeclarationStatement")) {
						TotalVariableDeclarationStatement++;
					} else if (thistype.contains("WhileStatement")) {
						TotalWhileStatement++;
					} else if (thistype.contains("ImportDeclaration")) {
						TotalImportDeclaration++;
					}else if(thistype.contains("MethodInvocation"))
					{
						TotalMethodInvocation++;
					} else if(thistype.contains("Assignment"))
					{
						TotalAssignment++;
					}

				}

				// if(specialbug){
				// System.out.println("Project: "+Pro.ProName+" ID: "+x+"
				// SpecialEXAM: "+ EXAMSpecialold+" EXAM: "+ EXAMold);
				// }

				// for(int i = 0 ; i<statements.size();i++)
				// {
				// //String source =
				// searchsource.getStatementText(Pro.ProName,x,statements.get(i),Pro.SpecialRoot);
				// //statements.get(i).Text = source;
				// String source = statements.get(i).Text;
				// if(source.contains(" if") )
				// {
				//
				//
				// }
				// }

				// for(int i = 0 ; i<statements.size();i++)
				// {
				// System.out.println("score: "+statements.get(i).possibility+ "
				// text: "+statements.get(i).Text);
				// System.out.println("Path: "+ statements.get(i).Path+ "
				// 行:"+statements.get(i).lineNum);
				// }

				jiezhi = x;

				// 截至此括号为一个bug version的循环
			}

			if (false) {// 这里单纯为了调程序的时候省事
				System.out.println("Project:  " + Pro.ProName);
				// 1 AssertStatement,
				// 2 Block,
				// 3 BreakStatement,
				// 4 ConstructorInvocation,
				// 5 ContinueStatement,
				System.out.println("AssertStatement:  " + TotalAssertStatement);
				System.out.println("Block:  " + TotalBlock);
				System.out.println("BreakStatement:  " + TotalBreakStatement);
				System.out.println("ConstructorInvocation:  " + TotalConstructorInvocation);
				System.out.println("ContinueStatement:  " + TotalContinueStatement);
				// 6 DoStatement,
				// 7 EmptyStatement,
				// 8 EnhancedForStatement
				// 9 ExpressionStatement,
				// 10 ForStatement,
				System.out.println("DoStatement:  " + TotalDoStatement);
				System.out.println("EmptyStatement:  " + TotalEmptyStatement);
				System.out.println("EnhancedForStatement:  " + TotalEnhancedForStatement);
				System.out.println("ExpressionStatement:  " + TotalExpressionStatement);
				System.out.println("ForStatement:  " + TotalForStatement);
				// 11 IfStatement,
				// 12 LabeledStatement,
				// 13 ReturnStatement,
				// 14 SuperConstructorInvocation,
				// 15 SwitchCase,
				System.out.println("IfStatement:  " + TotalIfStatement);
				System.out.println("LabeledStatement:  " + TotalLabeledStatement);
				System.out.println("ReturnStatement:  " + TotalReturnStatement);
				System.out.println("SuperConstructorInvocation:  " + TotalSuperConstructorInvocation);
				System.out.println("SwitchCase:  " + TotalSwitchCase);
				// 16 SwitchStatement,
				// 17 SynchronizedStatement,
				// 18 ThrowStatement,
				// 19 TryStatement,
				// 20 TypeDeclarationStatement,
				// 21 VariableDeclarationStatement,
				// 22 WhileStatement
				// 23 ImportDeclaration
				System.out.println("SwitchStatement:  " + TotalSwitchStatement);
				System.out.println("SynchronizedStatement:  " + TotalSynchronizedStatement);
				System.out.println("ThrowStatement:  " + TotalThrowStatement);
				System.out.println("TryStatement:  " + TotalTryStatement);
				System.out.println("TypeDeclarationStatement:  " + TotalTypeDeclarationStatement);

				System.out.println("VariableDeclarationStatement:  " + TotalVariableDeclarationStatement);
				System.out.println("WhileStatement:  " + TotalWhileStatement);
				System.out.println("ImportDeclaration:  " + TotalImportDeclaration);
				System.out.println("MethodInvocation:  " + TotalMethodInvocation);
				System.out.println("Assignment:  " + TotalAssignment);
				
			}

			result += "\n" + ("Project:  " + Pro.ProName);

			result += "\n" + ("AssertStatement:  " + TotalAssertStatement);
			result += "\n" + ("Block:  " + TotalBlock);
			result += "\n" + ("BreakStatement:  " + TotalBreakStatement);
			result += "\n" + ("ConstructorInvocation:  " + TotalConstructorInvocation);
			result += "\n" + ("ContinueStatement:  " + TotalContinueStatement);

			result += "\n" + ("DoStatement:  " + TotalDoStatement);
			result += "\n" + ("EmptyStatement:  " + TotalEmptyStatement);
			result += "\n" + ("EnhancedForStatement:  " + TotalEnhancedForStatement);
			result += "\n" + ("ExpressionStatement:  " + TotalExpressionStatement);
			result += "\n" + ("ForStatement:  " + TotalForStatement);

			result += "\n" + ("IfStatement:  " + TotalIfStatement);
			result += "\n" + ("LabeledStatement:  " + TotalLabeledStatement);
			result += "\n" + ("ReturnStatement:  " + TotalReturnStatement);
			result += "\n" + ("SuperConstructorInvocation:  " + TotalSuperConstructorInvocation);
			result += "\n" + ("SwitchCase:  " + TotalSwitchCase);

			result += "\n" + ("SwitchStatement:  " + TotalSwitchStatement);
			result += "\n" + ("SynchronizedStatement:  " + TotalSynchronizedStatement);
			result += "\n" + ("ThrowStatement:  " + TotalThrowStatement);
			result += "\n" + ("TryStatement:  " + TotalTryStatement);
			result += "\n" + ("TypeDeclarationStatement:  " + TotalTypeDeclarationStatement);

			result += "\n" + ("VariableDeclarationStatement:  " + TotalVariableDeclarationStatement);
			result += "\n" + ("WhileStatement:  " + TotalWhileStatement);
			result += "\n" + ("ImportDeclaration:  " + TotalImportDeclaration);
			
			result += "\n" + ("MethodInvocation:  " + TotalMethodInvocation);
			result += "\n" + ("Assignment:  " + TotalAssignment);

			result += "\n" + "\n" + "项目：     " + Pro.ProName + "     编号截至：" + jiezhi;

		//	String filepath01 = "/home1/D4jTypeBugImproUpgraded/" + Pro.ProName;//這個是錯誤語句的統計
			String filepath01 = "/home1/D4jTypeTotalUpgraded/" + Pro.ProName;//這個是總體的統計
			File newF01 = new File(filepath01);
			if (!newF01.exists()) {
				newF01.mkdir();
			}

			//String filepath = "/home1/D4jTypeBugImproUpgraded/" + Pro.ProName + "/" +1 + ".txt";// JYJ
			String filepath = "/home1/D4jTypeTotalUpgraded/" + Pro.ProName + "/" +1 + ".txt";// JYJ //這個是總體的統計
																								// 改
																					
			// 1.txt
																								// 2.txt
																								// 3.txt...
			File newF = new File(filepath);
			if (!newF.exists()) {
				try {
					newF.createNewFile();
					BufferedWriter out = new BufferedWriter(new FileWriter(filepath));
					out.write(result);
					out.close();
					System.out.println("文件创建成功！");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			System.out.println();

			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void runCumulateExperimentStatic(D4jProgram Pro) {
		int TotalAssertStatement = 0;

		int TotalBlock = 0;
		int TotalBreakStatement = 0;
		int TotalConstructorInvocation = 0;
		int TotalContinueStatement = 0, TotalDoStatement = 0, TotalEmptyStatement = 0, TotalEnhancedForStatement = 0,
				TotalExpressionStatement = 0, TotalForStatement = 0, TotalIfStatement = 0, TotalLabeledStatement = 0,
				TotalReturnStatement = 0, TotalSuperConstructorInvocation = 0, TotalSwitchCase = 0,
				TotalSwitchStatement = 0, TotalSynchronizedStatement = 0, TotalThrowStatement = 0,
				TotalTryStatement = 0, TotalTypeDeclarationStatement = 0, TotalVariableDeclarationStatement = 0,
				TotalWhileStatement = 0, TotalImportDeclaration = 0;

		// TODO Auto-generated method stub

		String result = "";
		int jiezhi = 0;
		String[] FileList = CollectStaticStatementType(Pro);
		try {
		for(int x=0;x<FileList.length;x++)
		{
			
					Pro.SpecialRoot = Pro.SpecialRoot1;
					
					 File candidate = new File(FileList[x]);
					Map<Integer, DataNode> candidateNodes = new HashMap<>();
					String absolutePath = candidate.getAbsolutePath();
					
				//	System.out.println("測試"+absolutePath);
					String dirPah = absolutePath.substring(0, absolutePath.lastIndexOf('/'));
				
						CompilationUnit unit = ASTUtil.getCompilationUnit2(absolutePath, candidate.getName(), dirPah, true);
						test.ID = 0;
						test.getDirectChildren(unit, 0, candidateNodes);


				// 此处开始统计各语句类型

				 for(int i = 0;
				 i<candidateNodes.size();i++)//20201231这一行用于统计错误的语句类型
		//		for (int i = 0; i < statements.size(); i++)// 20201231这一行用与统计总体的语句类型
				{
					// 20201231这里的两行用于统计错误的语句类型
					

					String thistype = candidateNodes.get(i).nodeType.trim();
					if (thistype == null) {
					} else if (thistype.contains("AssertStatement")) {
						TotalAssertStatement++;
					} else if (thistype.contains("Block")) {
						TotalBlock++;
					} else if (thistype.contains("BreakStatement")) {
						TotalBreakStatement++;
					} else if (thistype.contains("ConstructorInvocation")) {
						TotalConstructorInvocation++;
					} else if (thistype.contains("ContinueStatement")) {
						TotalContinueStatement++;
					} else if (thistype.contains("DoStatement")) {
						TotalDoStatement++;
					} else if (thistype.contains("EmptyStatement")) {
						TotalEmptyStatement++;
					} else if (thistype.contains("EnhancedForStatement")) {
						TotalEnhancedForStatement++;
					} else if (thistype.contains("ExpressionStatement")) {
						TotalExpressionStatement++;
					} else if (thistype.contains("ForStatement")) {
						TotalForStatement++;
					} else if (thistype.contains("IfStatement")) {
						TotalIfStatement++;
					} else if (thistype.contains("LabeledStatement")) {
						TotalLabeledStatement++;
					} else if (thistype.contains("ReturnStatement")) {
						TotalReturnStatement++;
					} else if (thistype.contains("SuperConstructorInvocation")) {
						TotalSuperConstructorInvocation++;
					} else if (thistype.contains("SwitchCase")) {
						TotalSwitchCase++;
					} else if (thistype.contains("SwitchStatement")) {
						TotalSwitchStatement++;
					} else if (thistype.contains("SynchronizedStatement")) {
						TotalSynchronizedStatement++;
					} else if (thistype.contains("ThrowStatement")) {
						TotalThrowStatement++;
					} else if (thistype.contains("TryStatement")) {
						TotalTryStatement++;
					} else if (thistype.contains("TypeDeclarationStatement")) {
						TotalTypeDeclarationStatement++;
					} else if (thistype.contains("VariableDeclarationStatement")) {
						TotalVariableDeclarationStatement++;
					} else if (thistype.contains("WhileStatement")) {
						TotalWhileStatement++;
					} else if (thistype.contains("ImportDeclaration")) {
						TotalImportDeclaration++;
					}

				}

				// if(specialbug){
				// System.out.println("Project: "+Pro.ProName+" ID: "+x+"
				// SpecialEXAM: "+ EXAMSpecialold+" EXAM: "+ EXAMold);
				// }

				// for(int i = 0 ; i<statements.size();i++)
				// {
				// //String source =
				// searchsource.getStatementText(Pro.ProName,x,statements.get(i),Pro.SpecialRoot);
				// //statements.get(i).Text = source;
				// String source = statements.get(i).Text;
				// if(source.contains(" if") )
				// {
				//
				//
				// }
				// }

				// for(int i = 0 ; i<statements.size();i++)
				// {
				// System.out.println("score: "+statements.get(i).possibility+ "
				// text: "+statements.get(i).Text);
				// System.out.println("Path: "+ statements.get(i).Path+ "
				// 行:"+statements.get(i).lineNum);
				// }

				jiezhi = x;

				// 截至此括号为一个bug version的循环		
		
		}
			if (false) {// 这里单纯为了调程序的时候省事
				System.out.println("Project:  " + Pro.ProName);
				// 1 AssertStatement,
				// 2 Block,
				// 3 BreakStatement,
				// 4 ConstructorInvocation,
				// 5 ContinueStatement,
				System.out.println("AssertStatement:  " + TotalAssertStatement);
				System.out.println("Block:  " + TotalBlock);
				System.out.println("BreakStatement:  " + TotalBreakStatement);
				System.out.println("ConstructorInvocation:  " + TotalConstructorInvocation);
				System.out.println("ContinueStatement:  " + TotalContinueStatement);
				// 6 DoStatement,
				// 7 EmptyStatement,
				// 8 EnhancedForStatement
				// 9 ExpressionStatement,
				// 10 ForStatement,
				System.out.println("DoStatement:  " + TotalDoStatement);
				System.out.println("EmptyStatement:  " + TotalEmptyStatement);
				System.out.println("EnhancedForStatement:  " + TotalEnhancedForStatement);
				System.out.println("ExpressionStatement:  " + TotalExpressionStatement);
				System.out.println("ForStatement:  " + TotalForStatement);
				// 11 IfStatement,
				// 12 LabeledStatement,
				// 13 ReturnStatement,
				// 14 SuperConstructorInvocation,
				// 15 SwitchCase,
				System.out.println("IfStatement:  " + TotalIfStatement);
				System.out.println("LabeledStatement:  " + TotalLabeledStatement);
				System.out.println("ReturnStatement:  " + TotalReturnStatement);
				System.out.println("SuperConstructorInvocation:  " + TotalSuperConstructorInvocation);
				System.out.println("SwitchCase:  " + TotalSwitchCase);
				// 16 SwitchStatement,
				// 17 SynchronizedStatement,
				// 18 ThrowStatement,
				// 19 TryStatement,
				// 20 TypeDeclarationStatement,
				// 21 VariableDeclarationStatement,
				// 22 WhileStatement
				// 23 ImportDeclaration
				System.out.println("SwitchStatement:  " + TotalSwitchStatement);
				System.out.println("SynchronizedStatement:  " + TotalSynchronizedStatement);
				System.out.println("ThrowStatement:  " + TotalThrowStatement);
				System.out.println("TryStatement:  " + TotalTryStatement);
				System.out.println("TypeDeclarationStatement:  " + TotalTypeDeclarationStatement);

				System.out.println("VariableDeclarationStatement:  " + TotalVariableDeclarationStatement);
				System.out.println("WhileStatement:  " + TotalWhileStatement);
				System.out.println("ImportDeclaration:  " + TotalImportDeclaration);
			}

			result += "\n" + ("Project:  " + Pro.ProName);

			result += "\n" + ("AssertStatement:  " + TotalAssertStatement);
			result += "\n" + ("Block:  " + TotalBlock);
			result += "\n" + ("BreakStatement:  " + TotalBreakStatement);
			result += "\n" + ("ConstructorInvocation:  " + TotalConstructorInvocation);
			result += "\n" + ("ContinueStatement:  " + TotalContinueStatement);

			result += "\n" + ("DoStatement:  " + TotalDoStatement);
			result += "\n" + ("EmptyStatement:  " + TotalEmptyStatement);
			result += "\n" + ("EnhancedForStatement:  " + TotalEnhancedForStatement);
			result += "\n" + ("ExpressionStatement:  " + TotalExpressionStatement);
			result += "\n" + ("ForStatement:  " + TotalForStatement);

			result += "\n" + ("IfStatement:  " + TotalIfStatement);
			result += "\n" + ("LabeledStatement:  " + TotalLabeledStatement);
			result += "\n" + ("ReturnStatement:  " + TotalReturnStatement);
			result += "\n" + ("SuperConstructorInvocation:  " + TotalSuperConstructorInvocation);
			result += "\n" + ("SwitchCase:  " + TotalSwitchCase);

			result += "\n" + ("SwitchStatement:  " + TotalSwitchStatement);
			result += "\n" + ("SynchronizedStatement:  " + TotalSynchronizedStatement);
			result += "\n" + ("ThrowStatement:  " + TotalThrowStatement);
			result += "\n" + ("TryStatement:  " + TotalTryStatement);
			result += "\n" + ("TypeDeclarationStatement:  " + TotalTypeDeclarationStatement);

			result += "\n" + ("VariableDeclarationStatement:  " + TotalVariableDeclarationStatement);
			result += "\n" + ("WhileStatement:  " + TotalWhileStatement);
			result += "\n" + ("ImportDeclaration:  " + TotalImportDeclaration);

			result += "\n" + "\n" + "项目：     " + Pro.ProName + "     编号截至：" + jiezhi;

			String filepath01 = "/home1/D4jTypeStatic/" + Pro.ProName;
			File newF01 = new File(filepath01);
			if (!newF01.exists()) {
				newF01.mkdir();
			}

			String filepath = "/home1/D4jTypeStatic/" + Pro.ProName + "/" +1 + ".txt";// JYJ
																								// 改
																					
			// 1.txt
																								// 2.txt
																								// 3.txt...
			File newF = new File(filepath);
			if (!newF.exists()) {
				try {
					newF.createNewFile();
					BufferedWriter out = new BufferedWriter(new FileWriter(filepath));
					out.write(result);
					out.close();
					System.out.println("文件创建成功！");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			System.out.println();

			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void runCumulateLOCStatic(D4jProgram Pro) {

		int i = 0;

		// TODO Auto-generated method stub

		String result = "";
		int jiezhi = 0;
		String[] FileList = CollectStaticStatementType(Pro);
		try {
		for(int x=0;x<FileList.length;x++)
		{
			System.out.println(FileList[x] );
					Pro.SpecialRoot = Pro.SpecialRoot1;
					
				//	 File candidate = new File(FileList[x]);
					//Map<Integer, DataNode> candidateNodes = new HashMap<>();
			//		String absolutePath = candidate.getAbsolutePath();
					
				//	System.out.println("測試"+absolutePath);
				//	String dirPah = absolutePath.substring(0, absolutePath.lastIndexOf('/'));
				
						//CompilationUnit unit = ASTUtil.getCompilationUnit2(absolutePath, candidate.getName(), dirPah, true);
						
						BufferedReader br = 
								new BufferedReader(new InputStreamReader(new FileInputStream(
								//		"/home1/tmp/"+"Compress"+"_"+1+"_buggy"+"/src/main/java/"+
								FileList[x]
								)));
					//	List<statementline> statements = new ArrayList<statementline>();
						
						int j = 0;
						for(String line = br.readLine();line!=null;line = br.readLine())
						{
							if(line.trim().length()>0)
							{
								i++;
								j++;
							}
							
						}
						br.close();
System.out.print("    此文件行数"+j);

				
		
		}
		


		System.out.println();
			System.out.println(i);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void RecordStatementTypeToTxt(D4jProgram Pro) {
		// TODO Auto-generated method stub
		System.out.println("Project:  "+Pro.ProName +"     SBFL formula:"+ experiment.SBFLFomula);	
		
 try{			    	  	 		  
//			for(int x =49; x<=49;x++)
	  for(int x =1; x<=Pro.TotalBug;x++)//jyj2
	  {   
		  String result = "";
		  System.out.println("   BugID:  "+x);
		  if(Pro.deprecatedBug.contains(x)||Pro.AddStatementBug.contains(x))
		  {
			  System.out.print("跳過");
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
    	 List<statementline> statements = new ArrayList<statementline>();
  		statements = readtxt.getstatementlist(Pro.lowerProName,x);
  	for(int i = 0 ; i<statements.size();i++)
		{
			String source = searchsource.getStatementText(Pro.ProName,x,statements.get(i),Pro.SpecialRoot);
			statements.get(i).Text = source;
			
			statements.get(i).type = CumulateType.getstatementtype( "/home1/tmp/"+Pro.ProName+"_"+x+"_buggy/"+
				 Pro.SpecialRoot + statements.get(i).Path, statements.get(i).lineNum);
//			System.out.println("Text:"+source);
//			System.out.println("type:"+statements.get(i).type);			
		}
  		for(int i = 0 ; i<statements.size()-1;i++)
  		{
  			//String source = searchsource.getStatementText(Pro.ProName,x,statements.get(i),Pro.SpecialRoot);
  			//statements.get(i).Text = source;
  			String source = statements.get(i).Text;
  			String sourcetype = statements.get(i).type.trim();
  			result +=  statements.get(i).Path+"#"+ statements.get(i).lineNum+"#"+ statements.get(i).type+"\n";
  			System.out.println(statements.get(i).Path+"#"+ statements.get(i).lineNum+"#"+ statements.get(i).type);
  		}
  		result +=  statements.get(statements.size()-1).Path+"#"+ statements.get(statements.size()-1).lineNum+"#"+ statements.get(statements.size()-1).type;
  		
  		
  		String filepath01 = "/home1/D4jTypeList/" + Pro.ProName;//20211017改D4jTypeListAll爲D4jTypeList
		File newF01 = new File(filepath01);
		if (!newF01.exists()) {
			newF01.mkdir();
		}

		String filepath = "/home1/D4jTypeList/"+Pro.ProName + "/" +x + ".txt";//20211017改D4jTypeListAll爲D4jTypeList
		File newF = new File(filepath);
		if (!newF.exists()) {
			try {
				newF.createNewFile();
				BufferedWriter out = new BufferedWriter(new FileWriter(filepath));
				out.write(result);
				out.close();
				System.out.println("文件创建成功！");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		System.out.println();
  		
	  }
  	
	}	
	catch(Exception e){}
		
	}
	
	public static void RecordStatementTypeToTxtUpgraded(D4jProgram Pro) {
		// TODO Auto-generated method stub
		System.out.println("Project:  "+Pro.ProName +"     SBFL formula:"+ experiment.SBFLFomula);	
		
 try{			    	  	 		  
//			for(int x =49; x<=49;x++)
	  for(int x =1; x<=Pro.TotalBug;x++)//jyj2
	  {   
		  String result = "";
		  System.out.println("   BugID:  "+x);
		  if(Pro.deprecatedBug.contains(x)||Pro.AddStatementBug.contains(x))
		  {
			  System.out.print("跳過");
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
    	 List<statementline> statements = new ArrayList<statementline>();
  		statements = readtxt.getstatementlist(Pro.lowerProName,x);
  	for(int i = 0 ; i<statements.size();i++)
		{
			String source = searchsource.getStatementText(Pro.ProName,x,statements.get(i),Pro.SpecialRoot);
			statements.get(i).Text = source;
			
			statements.get(i).type = CumulateType.getstatementtypeUpgraded( "/home1/tmp/"+Pro.ProName+"_"+x+"_buggy/"+
				 Pro.SpecialRoot + statements.get(i).Path, statements.get(i).lineNum);
//			System.out.println("Text:"+source);
//			System.out.println("type:"+statements.get(i).type);			
		}
  		for(int i = 0 ; i<statements.size()-1;i++)
  		{
  			//String source = searchsource.getStatementText(Pro.ProName,x,statements.get(i),Pro.SpecialRoot);
  			//statements.get(i).Text = source;
  			String source = statements.get(i).Text;
  			String sourcetype = statements.get(i).type.trim();
  			result +=  statements.get(i).Path+"#"+ statements.get(i).lineNum+"#"+ statements.get(i).type+"\n";
  			System.out.println(statements.get(i).Path+"#"+ statements.get(i).lineNum+"#"+ statements.get(i).type);
  		}
  		result +=  statements.get(statements.size()-1).Path+"#"+ statements.get(statements.size()-1).lineNum+"#"+ statements.get(statements.size()-1).type;
  		
  		
  		String filepath01 = "/home1/D4jTypeListUpgraded/" + Pro.ProName;//20211017改D4jTypeListAll爲D4jTypeList
		File newF01 = new File(filepath01);
		if (!newF01.exists()) {
			newF01.mkdir();
		}

		String filepath = "/home1/D4jTypeListUpgraded/"+Pro.ProName + "/" +x + ".txt";//20211017改D4jTypeListAll爲D4jTypeList
		File newF = new File(filepath);
		if (!newF.exists()) {
			try {
				newF.createNewFile();
				BufferedWriter out = new BufferedWriter(new FileWriter(filepath));
				out.write(result);
				out.close();
				System.out.println("文件创建成功！");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		System.out.println();
  		
	  }
  	
	}	
	catch(Exception e){}
		
	}
	
	
	public static void RecordStatementParentMethodToTxt(D4jProgram Pro) {
		// TODO Auto-generated method stub
		System.out.println("Project:  "+Pro.ProName +"     SBFL formula:"+ experiment.SBFLFomula);	
		
 try{			    	  	 		  
//			for(int x =49; x<=49;x++)
	  for(int x =1; x<=Pro.TotalBug;x++)//jyj2
	  {   
		  String result = "";
		  System.out.println("   BugID:  "+x);
		  if(Pro.deprecatedBug.contains(x)||Pro.AddStatementBug.contains(x))
		  {
			  System.out.print("跳過");
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
    	 List<statementline> statements = new ArrayList<statementline>();
  		statements = readtxt.getstatementlist(Pro.lowerProName,x);
  		//System.out.println("20210829ceshi");
  	for(int i = 0 ; i<statements.size();i++)
		{
			String source = searchsource.getStatementText(Pro.ProName,x,statements.get(i),Pro.SpecialRoot);
			statements.get(i).Text = source;
			
			statements.get(i).ParentMethod = statements.get(i).Path+"LineOf"+CumulateType.getstatementParentMethodNew( "/home1/tmp/"+Pro.ProName+"_"+x+"_buggy/"+
				 Pro.SpecialRoot + statements.get(i).Path, statements.get(i).lineNum);
//			System.out.println("Text:"+source);
//			System.out.println("type:"+statements.get(i).type);			
		}
  	
  	System.out.println("20210829ceshi2:"+statements.size());
  		for(int i = 0 ; i<statements.size()-1;i++)
  		{
  
  			//String source = searchsource.getStatementText(Pro.ProName,x,statements.get(i),Pro.SpecialRoot);
  			//statements.get(i).Text = source;
  			String source = statements.get(i).Text;
  			String sourceParent = statements.get(i).type.trim();
  			result +=  statements.get(i).Path+"#"+ statements.get(i).lineNum+"#"+ statements.get(i).ParentMethod+"\n";
 // 			System.out.println(statements.get(i).Path+"#"+ statements.get(i).lineNum+"#"+ statements.get(i).ParentMethod);
  		}
  		result +=  statements.get(statements.size()-1).Path+"#"+ statements.get(statements.size()-1).lineNum+"#"+ statements.get(statements.size()-1).ParentMethod;
  		
  
  		String filepath01 = "/home1/D4jParentmethodListAll/" + Pro.ProName;
		File newF01 = new File(filepath01);
		if (!newF01.exists()) {
			newF01.mkdir();
		}

		String filepath = "/home1/D4jParentmethodListAll/"+Pro.ProName + "/" +x + ".txt";
		File newF = new File(filepath);
		if (!newF.exists()) {
			try {
				newF.createNewFile();
				BufferedWriter out = new BufferedWriter(new FileWriter(filepath));
				out.write(result);
				out.close();
				System.out.println("文件创建成功！");
			} catch (IOException e) {
				System.out.println("没有此路径："+filepath);
				e.printStackTrace();
			}
		}
	
		System.out.println();
  		
	  }
  	
	}	
	catch(Exception e){}
		
	}
	
	 public static List<statementline> getstatementtypeNew(D4jProgram Pro, int BugID) throws Exception
	  {
		 
			List<statementline> ret = new ArrayList<statementline>();
			try{
				BufferedReader br = 
						new BufferedReader(new InputStreamReader(new FileInputStream(
				//				"/home/bitse/simfix (backup)/SimFix(1218)/d4j-info/location/ochiai/"+ProName+"/"+bugID+".txt"
						"/home1/D4jTypeList/"+Pro.ProName+"/"+BugID+".txt"					
						
						)));
				List<statementline> statements = new ArrayList<statementline>();
				
				for(String line = br.readLine();line!=null;line = br.readLine())
				{							
		
					statementline l = new statementline();
					String[] thisline = line.split("#");
					l.Path = thisline[0];
					l.lineNum = Integer.valueOf(thisline[1]);
					l.type = thisline[2];
			//		statementline.printLineInfo(l);
					ret.add(l);
					//System.out.println(devideInfo(line));
				
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
			return ret;
	  }
	
	 public static String getstatementtype(String path,int x) throws Exception
	  {
		 String result = "unknown";
		 String thistext ="undefine";
		  File candidate = new File(path);
		 
				Map<Integer, DataNode> candidateNodes = new HashMap<>();
				String absolutePath = candidate.getAbsolutePath();
				
			//	System.out.println("測試"+absolutePath);
				String dirPah = absolutePath.substring(0, absolutePath.lastIndexOf('/'));

				try {
					CompilationUnit unit = ASTUtil.getCompilationUnit2(absolutePath, candidate.getName(), dirPah, true);
					test.ID = 0;
					test.getDirectChildren(unit, 0, candidateNodes);
			
			
//				 FileInputStream fileInputStream = new FileInputStream(candidate);
//	             InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
//			  
//			    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
//	            
//			    String txt ="";
//	            StringBuffer sb = new StringBuffer();
//	            String text = null;
//	            while((text =  bufferedReader.readLine()) != null){
//	                sb.append(text);
//	                txt += "\n"+text;
//	            }
	            
	    //        System.out.println();
	    //        System.out.println(sb.toString());
			
		//	test.output(candidateNodes);
	            System.out.println("******"+candidateNodes.size());
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
	            				ndc.nodeType.contains("inr")||
	            				ndc.nodeType.contains("SuperConstructorInvocation")||
	            				ndc.nodeType.contains("SwitchCase")
	            					 )
	            			 {
	            		//	end = Math.max(unit.getLineNumber(ndc.node.getStartPosition())-1,begin); 
	            				 end = Math.max(unit.getLineNumber(ndc.node.getStartPosition())-1,
	                   					unit.getLineNumber(	candidateNodes.get(ndc.label-1).node.getStartPosition()+candidateNodes.get(ndc.label-1).node.getLength())
	                   					);
	            				 end = Math.max(begin, end);
	            				 //20200110这个begin有漏洞！不能直接用begin
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
	            		result = nd.nodeType;
	            		thistext = nd.node.toString().trim();
	            	}
	            }
	            
			
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
//				System.out.println("20210111   Path:"+path+"  行"+   x+"    类型："+result);
//				System.out.println("nodeTXT:    "+thistext);
				return result;
	  }
	 
	 public static String getstatementtypeUpgraded(String path,int x) throws Exception //这里弄一个升级版，对ExpressionStatement加以区分，有可能是赋值语句或者函数调用
	  {
		 String result = "unknown";
		 String thistext ="undefine";
		  File candidate = new File(path);
		 
				Map<Integer, DataNode> candidateNodes = new HashMap<>();
				String absolutePath = candidate.getAbsolutePath();
				
			//	System.out.println("測試"+absolutePath);
				String dirPah = absolutePath.substring(0, absolutePath.lastIndexOf('/'));

				try {
					CompilationUnit unit = ASTUtil.getCompilationUnit2(absolutePath, candidate.getName(), dirPah, true);
					test.ID = 0;
					test.getDirectChildren(unit, 0, candidateNodes);
			
			
//				 FileInputStream fileInputStream = new FileInputStream(candidate);
//	             InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
//			  
//			    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
//	            
//			    String txt ="";
//	            StringBuffer sb = new StringBuffer();
//	            String text = null;
//	            while((text =  bufferedReader.readLine()) != null){
//	                sb.append(text);
//	                txt += "\n"+text;
//	            }
	            
	    //        System.out.println();
	    //        System.out.println(sb.toString());
			
		//	test.output(candidateNodes);
	            System.out.println("******"+candidateNodes.size());
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
	            				ndc.nodeType.contains("inr")||
	            				ndc.nodeType.contains("SuperConstructorInvocation")||
	            				ndc.nodeType.contains("SwitchCase")
	            					 )
	            			 {
	            		//	end = Math.max(unit.getLineNumber(ndc.node.getStartPosition())-1,begin); 
	            				 end = Math.max(unit.getLineNumber(ndc.node.getStartPosition())-1,
	                   					unit.getLineNumber(	candidateNodes.get(ndc.label-1).node.getStartPosition()+candidateNodes.get(ndc.label-1).node.getLength())
	                   					);
	            				 end = Math.max(begin, end);
	            				 //20200110这个begin有漏洞！不能直接用begin
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
	            		result = nd.nodeType;
	            		thistext = nd.node.toString().trim();
	            		//20211028这里对ExpressionStatement进一步处理
	            		if(result.contains("ExpressionStatement"))
	            		{
	            			int childlabel = nd.childrenLables.get(0);
	            			DataNode c = candidateNodes.get(childlabel);
	            			if(c.nodeType.contains("MethodInvocation"))
	            			{
	            				result = result.replace("ExpressionStatement", "MethodInvocation");
	            			}else 	if(c.nodeType.contains("Assignment"))
	            			{
	            				result = result.replace("ExpressionStatement", "Assignment");
	            			}
	            			
	            		}
	            	}
	            }
	            
			
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
//				System.out.println("20210111   Path:"+path+"  行"+   x+"    类型："+result);
//				System.out.println("nodeTXT:    "+thistext);
				return result;
	  }
	 
	 public static int getstatementParentMethodNew(String path,int x) throws Exception//20210905这个有漏洞，有些内部类的方法并不是根部的子节点
	  {
		 int result = -2;
		// String thistext ="undefine";
		  File candidate = new File(path);
		 
				Map<Integer, DataNode> candidateNodes = new HashMap<>();
				String absolutePath = candidate.getAbsolutePath();
				
			//	System.out.println("測試"+absolutePath);
				String dirPah = absolutePath.substring(0, absolutePath.lastIndexOf('/'));

				try {
					CompilationUnit unit = ASTUtil.getCompilationUnit2(absolutePath, candidate.getName(), dirPah, true);
					test.ID = 0;
					test.getDirectChildren(unit, 0, candidateNodes);
			

	            
	            ArrayList<int[]> classMethods = new ArrayList<int[]>();
	        
	            
	            for(int k=0;k<candidateNodes.size();k++)
	            {
	            	
	            	DataNode nd = candidateNodes.get(k);
	         //   	System.out.println(rootChild.nodeType);
	            	if(nd.nodeType.equals("class org.eclipse.jdt.core.dom.MethodDeclaration"))
	            	{
	            		int[] oneMethod = new int[2];
	            		oneMethod[0]=  unit.getLineNumber(nd.node.getStartPosition());           	
	            
	            		oneMethod[1]=  unit.getLineNumber(nd.node.getStartPosition()+nd.node.getLength());
	            	        		
	            		
	            		classMethods.add(oneMethod);
	          //  		System.out.println("oneMethod : "+oneMethod[0]+"  "+oneMethod[1]);
	            	}
	            }
	            
	            if(classMethods.size()==0)//如果根本没有声明method，返回-1,
	            {
	            	return -1;
	            }
	           
	            for(int i =0;i<classMethods.size();i++)
	            {
	            	int[] m = classMethods.get(i);
	            	if(m[0] <=x && m[1] >=x)
	            	{
	            		result = m[0];
	            	
	            		
	            	}
	            }
	            
	        	
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
//				System.out.println("20210111   Path:"+path+"  行"+   x+"    类型："+result);

				return result;
	  }
	 
	 public static int getstatementParentMethod(String path,int x) throws Exception//20210905这个有漏洞，有些内部类的方法并不是根部的子节点
	  {
		 int result = -1;
		 String thistext ="undefine";
		  File candidate = new File(path);
		 
				Map<Integer, DataNode> candidateNodes = new HashMap<>();
				String absolutePath = candidate.getAbsolutePath();
				
			//	System.out.println("測試"+absolutePath);
				String dirPah = absolutePath.substring(0, absolutePath.lastIndexOf('/'));

				try {
					CompilationUnit unit = ASTUtil.getCompilationUnit2(absolutePath, candidate.getName(), dirPah, true);
					test.ID = 0;
					test.getDirectChildren(unit, 0, candidateNodes);
			
			
//				 FileInputStream fileInputStream = new FileInputStream(candidate);
//	             InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
//			  
//			    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
//	            
//			    String txt ="";
//	            StringBuffer sb = new StringBuffer();
//	            String text = null;
//	            while((text =  bufferedReader.readLine()) != null){
//	                sb.append(text);
//	                txt += "\n"+text;
//	            }
	            
	    //        System.out.println();
	    //        System.out.println(sb.toString());
			
		//	test.output(candidateNodes);
	      //      System.out.println(path+"******"+candidateNodes.size());
	            
	            ArrayList<int[]> classMethods = new ArrayList<int[]>();
	            int rootIndex = -1;
	            for(int i=0;i<candidateNodes.size();i++)
	            {
	            	if(candidateNodes.get(i).nodeType.equals("class org.eclipse.jdt.core.dom.TypeDeclaration"))
	            	{
	            		rootIndex = i;
	            	}
	            }
	            if(rootIndex==-1)//如果根本没有声明TypeDeclaration，就不会声明方法
	            {
	            	return 0;
	            }
	           
	            DataNode root = candidateNodes.get(rootIndex);
	            
	            for(int k=0;k<root.childrenLables.size();k++)
	            {
	            	int index = root.childrenLables.get(k);
	            	DataNode rootChild = candidateNodes.get(index);
	         //   	System.out.println(rootChild.nodeType);
	            	if(rootChild.nodeType.equals("class org.eclipse.jdt.core.dom.MethodDeclaration"))
	            	{
	            		int[] oneMethod = new int[2];
	            		oneMethod[0]= rootChild.label;
	            		if(k==root.childrenLables.size()-1)
	            		{
	            			oneMethod[1]= candidateNodes.size()-1;
	            		}else
	            		{
	            			oneMethod[1]= root.childrenLables.get(k+1)-1;
	            		}           		
	            		
	            		classMethods.add(oneMethod);
	          //  		System.out.println("oneMethod : "+oneMethod[0]+"  "+oneMethod[1]);
	            	}
	            }
	            
	          //  System.exit(0);
	            
	         
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
	            				ndc.nodeType.contains("inr")||
	            				ndc.nodeType.contains("SuperConstructorInvocation")||
	            				ndc.nodeType.contains("SwitchCase")
	            					 )
	            			 {
	            		//	end = Math.max(unit.getLineNumber(ndc.node.getStartPosition())-1,begin); 
	            				 end = Math.max(unit.getLineNumber(ndc.node.getStartPosition())-1,
	                   					unit.getLineNumber(	candidateNodes.get(ndc.label-1).node.getStartPosition()+candidateNodes.get(ndc.label-1).node.getLength())
	                   					);
	            				 end = Math.max(begin, end);
	            				 //20200110这个begin有漏洞！不能直接用begin
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
	            		result = getParrentMethod(classMethods,nd.label);
	            		thistext = nd.node.toString().trim()+"  "+result;
	            		
	            	}
	            }
	            
			
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
//				System.out.println("20210111   Path:"+path+"  行"+   x+"    类型："+result);
	//			System.out.println("nodeTXT:    "+thistext);
				return result;
	  }

    private static int getParrentMethod(ArrayList<int[]> Methods, int index)
    {
    	
    	for(int i=0;i<Methods.size();i++)
    	{
    		if(Methods.get(i)[0]<=index&&Methods.get(i)[1]>=index)
    		{
    			return Methods.get(i)[0];
    		}
    	}
    	return 0;
    }
    private static String[] CollectStaticStatementType(D4jProgram Pro)
    {
    	String javaFileListRaw = parseFiles(  "/home1/tmp2/"+Pro.ProName+"_"+1+"_fix/"+
				 Pro.SpecialRoot  );//上面的編號得參照可復現的bug編號
    	String[] javaFileList = javaFileListRaw.split("\n");
    	
//    	for(int i=0;i<javaFileList.length;i++)
//    	{
//    		System.out.println(javaFileList[i]);
//    	}  
    	return javaFileList;
    }

    private static String parseFiles(String path) {
    	String result = "";
        File file = new File(path);
        if (file.isDirectory()) {
            for (File oneFile :
                    file.listFiles()) {
                if (oneFile.isDirectory()) {
                  result +=  parseFiles(oneFile.getPath());
                } else {
                    if (oneFile.getPath().endsWith(".java")) {
                        try {
                           //System.out.println(oneFile.getPath());
                        	result += oneFile.getPath().trim() +"\n";
                        } catch (Exception e) {
                            System.err.println(oneFile.getPath());
                        }
                    }
                }
            }
        } else {
            if (file.getPath().endsWith(".java")) {
                try {
                  // System.out.println(file.getPath());
                	result += file.getPath().trim() +"\n";
                } catch (Exception e) {
                    System.err.println(file.getPath());
                }
            }
        }
		return result;
    }


   


	 
	 

}
