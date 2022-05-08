package downloadD4j2020;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LabelGroundTruth {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
		
		
		String ex = "";
		
//		ex+=labelGroundTruth(Math);
//		ex+=labelGroundTruth(Closure);
//		ex+=labelGroundTruth(Compress);
//		ex+=labelGroundTruth(Lang);
//		ex+=labelGroundTruth(Cli);
//		ex+=labelGroundTruth(JacksonDatabind);
//		ex+=labelGroundTruth(Jsoup);
//		ex+=labelGroundTruth(Mockito);
//		ex+=labelGroundTruth(Time);
//		ex+=labelGroundTruth(Chart);
//		ex+=labelGroundTruth(Codec);
//		ex+=labelGroundTruth(Collections);
//		ex+=labelGroundTruth(Csv);
//		ex+=labelGroundTruth(JacksonCore);
//		ex+=labelGroundTruth(JxPath);
//		ex+=labelGroundTruth(Gson);
		System.out.println(ex);
		if(ex.trim().length()==0)
		{System.out.println("没有空文件");}
		
	}
	
	
	public static String labelGroundTruth(D4jProgram Pro)
	{
		String failed = "";
		int jiezhi = 0;
		try {

			// for(int x =1; x<=Pro.TotalBug;x++)
			
			 //for(int x =1; x<=Pro.TotalBug;x++)
		for (int x = 1; x <=Pro.TotalBug; x++)// JYJ 改 Pro.TotalBug number
											// Pro.TotalBug
		//	for (int x = 1; x <=8; x++)
			{
				String result = "";
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

				String[] buggyclass = experiment.getBugInfo(x, Pro).split("\n");
				List<statementline> buggystatements = new ArrayList<statementline>();// 所有的错误语句

//				 System.out.println("shiyankaishi2");
//				 System.out.println("buggyclass0 "+buggyclass[0]);

							 
				for (int i = 0; i < buggyclass.length; i++) {
					buggyclass[i] = buggyclass[i].substring(3, buggyclass[i].length());
					buggyclass[i] = buggyclass[i].replace(".", "/");
					// System.out.println(buggyclass[i]);

					// 接下來用diff尋找backgroundtruth
					String DiffInfo = experiment.getDiffInfo(x, Pro.ProName, buggyclass[i], Pro.SpecialRoot);

					System.out.println(DiffInfo);

					buggystatements = experiment.getbuggyline(Pro,x, buggystatements, DiffInfo, buggyclass[i]);
					
				}

			
				
//				 for(int n = 0; n <buggystatements.size();n++)
//				 {
//				 System.out.println(buggystatements.get(n).Path);
//				 System.out.println(buggystatements.get(n).lineNum);
//				 System.out.println();
//				 }
//

				 


				// 20201230统计语句类型从此处开始，分别统计statements和buggystatements

				
								
				 for(int i = 0;
				 i<buggystatements.size();i++)//20201231这一行用于统计错误的语句类型
			//	for (int i = 0; i < statements.size(); i++)// 20201231这一行用与统计总体的语句类型
				{
					
					// 20201231这里的两行用于统计错误的语句类型
//					 String path =
//					 "/home1/tmp/"+Pro.ProName+"_"+x+"_buggy/"+
//					 Pro.SpecialRoot + buggystatements.get(i).Path;
//					 int lineNum = buggystatements.get(i).lineNum;					 
					 
					 result +=  buggystatements.get(i).Path+"#"+ buggystatements.get(i).lineNum+"\n";
				}
				 if(buggystatements.size()>=2)
				 result +=  buggystatements.get(buggystatements.size()-1).Path+"#"+ buggystatements.get(buggystatements.size()-1).lineNum;

			
				jiezhi = x;

					String filepath01 = "/home1/groundtruth/"+Pro.ProName;
					File newF01 = new File(filepath01);
					if (!newF01.exists()) {
						newF01.mkdir();
					}

					String filepath = "/home1/groundtruth/" + Pro.ProName + "/" +x + ".txt";// JYJ
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
					
					if(result.trim().length()==0)
					{
						failed+="Program:  "+Pro.ProName+"   BugID: "+x+"  "+"\n";
					}
					
				// 截至此括号为一个bug version的循环
				 
			}
			System.out.println(jiezhi+"号bug完成");

		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println();
		//System.out.println(failed);
		return failed;
	}
	

}
