import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;




public class ShowResultAllLinux {

	 
	 public static int beforewin =0;
	 public static int afterwin =0;
	 public static int unchange =0;
	 
	 public static String[] label = {"path","line","Metallaxis","Muse","Ochiai","DStar","Slicing",
			 "Slicing_intersection","Slicing_count","Stacktrace","PredicateSwitching","faulty"};
	 
//	 public static int[] langset  = {1,4,6,7,8,10,15,16,17,19,20,21,22,24,25,26,27,30,
//			 32,33,34,35,36,40,41,42,46,50,57,58,59,60,61,63};
//	 
//	 public static int[] mathset = {2,6,7,8,9,11,14,15,16,21,22,23,24,26,27,29,30,31,
//			 32,33,34,35,37,38,40,41,42,43,44,46,47,49,50,52,54,55,56,57,58,59,60,61,62,63,64,65,66,
//			 67,68,69,70,72,74,75,76,77,79,80,81,82,83,85,86,87,88,91,92,93,94,96,97,98,100,101,105};
//	 
//	 public static int[] closureset = {3,4,6,7,10,11,13,14,16,17,18,20,21,22,23,24,25,27,30,31,32,34,35,37,38,39,40,
//			                          45,46,47,48,49,50,51,52,54,55,57,59,62,64,65,67,70,71,73,74,75,76,78,79,82,83,85,
//			                          86,87,89,90,92,96,97,99,100,101,102,104,105,106,108,109,110,111,112,113,115,121,122,
//			                          126,127,128,130,131,132};
	 
	 
	 
	 
	
	 public static void main(String[] args) throws IOException {
		 Project lang = new Project();
		 lang.lowerName="lang";
		 lang.upperName="Lang";
		 lang.endid=63;
		 lang.rest = new int[]{1,4,6,7,8,10,15,16,17,19,20,21,22,24,25,26,27,30,
				 32,33,34,35,36,40,41,42,46,50,57,58,59,60,61,63};
		 
		 
		 
		 
		 Project math = new Project();
		 math.lowerName="math";
		 math.upperName="Math";
		 math.endid=106;
		 math.rest = new int[]{2,6,7,8,9,11,14,15,16,21,22,23,24,26,27,29,30,31,
				 32,33,34,35,37,38,40,41,42,43,44,46,47,49,50,52,54,55,56,57,58,59,60,61,62,63,64,65,66,
				 67,68,69,70,72,74,75,76,77,79,80,81,82,83,85,86,87,88,91,92,93,94,96,97,98,100,101,105};
		 
		 Project closure = new Project();
		 closure.lowerName="closure";
		 closure.upperName="Closure";
		 closure.endid=133;
		 closure.rest = new int[] {3,4,6,7,10,11,13,14,16,17,18,20,21,22,23,24,25,27,30,31,32,34,35,37,38,39,40,
               45,46,47,48,49,50,51,52,54,55,57,59,62,64,65,67,70,71,73,74,75,76,78,79,82,83,85,
               86,87,89,90,92,96,97,99,100,101,102,104,105,106,108,109,110,111,112,113,115,121,122,
               126,127,128,130,131,132};
		 
		 Project chart = new Project();
		 chart.lowerName="chart";
		 chart.upperName="Chart";
		 chart.endid=25;
		 chart.rest = new int[] {1,2,5,6,7,8,9,10,11,12,13,16,17,18,20,22,24,25};
		 
		 Project time = new Project();
		 time.lowerName="time";
		 time.upperName="Time";
		 time.endid=26;
		 time.rest = new int[] {1,2,4,5,6,7,8,9,10,11,12,13,16,17,19,20,22,23,26};
		 
		 chart.ifsus = 2.66;
		 time.ifsus = 2.66;
		 lang.ifsus = 2.66;
		 math.ifsus = 2.58;
		 closure.ifsus = 2.51;
		 
//		 chart.forsus = 0.51;
//		 time.forsus = 0.51;
//		 lang.forsus = 0.51;
//		 math.forsus = 0.54;
//		 closure.forsus = 0.41;
		
//		 chart.expsus = 0.58;
//		 time.expsus = 0.58;
//		 lang.expsus = 0.58;
//		 math.expsus = 0.56;
//		 closure.expsus = 0.61;
		 
//		 chart.enforsus = 0.4;
//		 time.enforsus = 0.4;
//		 lang.enforsus = 0.4;
//		 math.enforsus = 0.33;
//		 closure.enforsus = 0.3;
//		 
//		 chart.varsus = 0.81;
//		 time.varsus = 0.81;
//		 lang.varsus = 0.81;
//		 math.varsus = 0.8;
//		 closure.varsus = 0.79;
//		 
//		 chart.retsus = 1.24;
//		 time.retsus = 1.24;
//		 lang.retsus = 1.24;
//		 math.retsus = 1.19;
//		 closure.retsus = 1.27;
		 
//		 for(int i=0;i<chart.rest.length;i++)
//		 {
//			 creatTypeList("chart", chart.rest[i]);			 
//		 }
//		 for(int i=0;i<time.rest.length;i++)
//		 {
//			 creatTypeList("time", time.rest[i]);			 
//		 }
		 
//		 runExperiment(lang);
//		 runExperiment(math);
		 runExperiment(closure);		
//		 runExperiment(chart);
//		 runExperiment(time);
		 
//		 ArrayList<Integer> restlang = new ArrayList<Integer>();
//		 for(int i=0;i<langset.length;i++)
//		 {
//			 restlang.add(langset[i]);
//		 }
//		 
//		 
//		 for(int i=1;i<=63;i++)
//		 {
//			 if(!restlang.contains(i))
//			 {continue;}
//			// creatTypeList("lang", i);
//			 
//			 int before = calculateOneMeta("lang",i);
//			 int after = calculateOneModifiedMeta("lang",i);
//			 if(before>after)
//			 {
//				 afterwin++;
//			 }else if(before<after)
//			 {
//				 beforewin++;
//			 }
//			 else {
//				 unchange++;
//			}
//			if(before!=after) {System.out.println (before+"   "+after+"    "+(before-after));}
//			
//		 }
//		 System.out.println ("项目：lang      劣势：   "+beforewin+"   优势："+ afterwin+"    其他："+ unchange);
//		
//		 
//		 
//		 
//		 ArrayList<Integer> restmath = new ArrayList<Integer>();
//		 for(int i=0;i<mathset.length;i++)
//		 {
//			 restmath.add(mathset[i]);
//		 }
//		 
//		 
//		 for(int i=1;i<=106;i++)
//		 {
//			 if(!restmath.contains(i))
//			 {continue;}
//			 
////			 creatTypeList("math", i);
//			 
//			 int before = calculateOneMeta("math",i);
//			 int after = calculateOneModifiedMeta("math",i);
//			 if(before>after)
//			 {
//				 afterwin++;
//			 }else if(before<after)
//			 {
//				 beforewin++;
//			 }
//			 else {
//				 unchange++;
//			}
//				if(before!=after) {System.out.println (before+"   "+after+"    "+(before-after));}
//			
//		 }
//		 
//		 System.out.println ("项目：math      劣势：   "+beforewin+"   优势："+ afterwin+"    其他："+ unchange);
//		 
//		 ArrayList<Integer> restclosure = new ArrayList<Integer>();
//		 for(int i=0;i<closureset.length;i++)
//		 {
//			 restclosure.add(closureset[i]);
//		 }
//		 
//		 
//		 for(int i=1;i<=133;i++)
//		 {
//			 if(!restclosure.contains(i))
//			 {continue;}
//			 
////			 creatTypeList("closure", i);
//			 
//			 int before = calculateOneMeta("closure",i);
//			 int after = calculateOneModifiedMeta("closure",i);
//			 if(before>after)
//			 {
//				 afterwin++;
//			 }else if(before<after)
//			 {
//				 beforewin++;
//			 }
//			 else {
//				 unchange++;
//			}
//				if(before!=after) {System.out.println (before+"   "+after+"    "+(before-after));}
////			
//		 }
//		 
//		 System.out.println ("项目：closure      劣势：   "+beforewin+"   优势："+ afterwin+"    其他："+ unchange);
		 
	 
	 }
	 
	 
	 public static void runExperiment(Project Pro) throws IOException
	 {
		 String ret ="Project: "+Pro.lowerName;
		 ArrayList<Integer> rest = new ArrayList<Integer>();
		 for(int i=0;i<Pro.rest.length;i++)
		 {
			 rest.add(Pro.rest[i]);
		 }
	
//		 ArrayList<Integer> ExamListMetaOld = new ArrayList<Integer>();
//		 ArrayList<Integer> ExamListMetaNew = new ArrayList<Integer>();
//		 
//		 ArrayList<Integer> ExamListMuseOld = new ArrayList<Integer>();
//		 ArrayList<Integer> ExamListMuseNew = new ArrayList<Integer>();
//		 
//		 ArrayList<Integer> ExamListOchiaiOld = new ArrayList<Integer>();
//		 ArrayList<Integer> ExamListOchiaiNew = new ArrayList<Integer>();
//		 
//		 ArrayList<Integer> ExamListDstarOld = new ArrayList<Integer>();
//		 ArrayList<Integer> ExamListDstariNew = new ArrayList<Integer>();
//		 
//		 ArrayList<Integer> ExamListSlicingOld = new ArrayList<Integer>();
//		 ArrayList<Integer> ExamListSlicingNew = new ArrayList<Integer>();
//		 
//		 ArrayList<Integer> ExamListSlicingInterOld = new ArrayList<Integer>();
//		 ArrayList<Integer> ExamListSlicingInterNew = new ArrayList<Integer>();
//		 
//		 ArrayList<Integer> ExamListSlicingCountOld = new ArrayList<Integer>();
//		 ArrayList<Integer> ExamListSlicingCountNew = new ArrayList<Integer>();
//		 
//		 ArrayList<Integer> ExamListStacktraceOld = new ArrayList<Integer>();
//		 ArrayList<Integer> ExamListStacktraceNew = new ArrayList<Integer>();
//		 
//		 ArrayList<Integer> ExamListPredicateswitchingOld = new ArrayList<Integer>();
//		 ArrayList<Integer> ExamListPredicateswitchingNew = new ArrayList<Integer>();
		 
		
		 
		 
		 for(int x=2;x<=5;x++) {
			 ArrayList<Integer> ExamListTongyongOld = new ArrayList<Integer>();
			 ArrayList<Integer> ExamListTongyongNew = new ArrayList<Integer>();
			 for(int i=1;i<=Pro.endid;i++)
			 {
				 System.out.println(label[x]+"  "+Pro.lowerName+"-"+i);
				 if(!rest.contains(i))
				 {continue;}
				 
				 
				 int beforeTongyong = calculateOneTongyong(Pro.lowerName,i,x);
				 int afterTongyong = calculateOneModifiedTongyong(Pro,i,x);
				 ExamListTongyongOld.add(beforeTongyong);
				 ExamListTongyongNew.add(afterTongyong);
	
			 }
			 
			 ret+="\r\n"+" top-k "+label[x]+"(old/new) "+"\r\n";
			 ret+=  topkInfor(ExamListTongyongOld)+"\r\n";
			 ret+=  topkInfor(ExamListTongyongNew)+"\r\n";
		 }

		ReadJson.creatWriteTxtFile("D:\\llpjason\\autoresult",Pro.lowerName,ret);
		 System.out.println(ret);
		// System.out.println ("项目：closure      劣势：   "+beforewin+"   优势："+ afterwin+"    其他："+ unchange);
	 }
	 
	 public static String topkInfor(ArrayList<Integer> examlist)
	 {
		 int top1 = 0;
		 int top3 = 0;
		 int top5 = 0;
		 int top10= 0;
		 int top20= 0;
		 int top30= 0;
		 int top50= 0;
		 int totalcost =0;
		 for(int i=0;i<examlist.size();i++)
		 {
			 int exam = examlist.get(i);
			 totalcost+=exam;
			 if(exam==1)
			 {
				 top1++;top3++;top5++;top10++;top20++; top30++;top50++;
			 }else if(exam<=3)
			 {
				 top3++;top5++;top10++;top20++; top30++;top50++;
			 }else if(exam<=5)
			 {
				 top5++;top10++;top20++; top30++;top50++;
			 }else if(exam<=10)
			 {
				 top10++;top20++; top30++;top50++;
			 }else if(exam<=20)
			 {
				 top20++; top30++;top50++;
			 }else if(exam<=30)
			 {
				 top30++;top50++;
			 }else if(exam<=50)			 
			 {
				 top50++;
			 }
		 }
		 return ("top1:  "+top1+"   top3:  "+top3+"   top5:  "+top5+"   top10:  "+top10+
				 "   top20:  "+top20+"   top30:  "+top30+"   top50:  "+top50+"       totalcost:"+totalcost);
	 }
	 
	 public static void ShowStatementType(String Pro,int id)
	 {
		 ArrayList<String> thisbug = readTxtFile("D:\\llpjason\\txtfile\\"+Pro+"\\"+id+".txt");
		 int n = thisbug.size();
		 String[][] statements=new String[n][6];
		 for (int i=0;i<n;i++)
		 {
			 statements[i]= thisbug.get(i).split("#");
		 }
		 for(int i=0;i<n;i++)
		 {
			 System.out.println(statements[i][0]+"  "+statements[i][1]+"   "+getStatementType(Pro, id, statements[i][0], statements[i][1]) );
		 }
		 
	 }
	 
	 public static ArrayList<String> getStatementtypelist(String Pro,int id)
	 {
		return  readTxtFile("D:\\llpjason\\typelist\\"+Pro+"\\"+id+".txt");
	 }
	 
	 public static void  creatTypeList(String Pro, int id) throws IOException
	    {
	    	String path = "D:\\llpjason\\typelist\\"+Pro;
	    	String data = "";
	    	 ArrayList<String> thisbug = readTxtFile("D:\\llpjason\\txtfile\\"+Pro+"\\"+id+".txt");
			 int n = thisbug.size();
			 String[][] statements=new String[n][6];
			 for (int i=0;i<n;i++)
			 {
				 statements[i]= thisbug.get(i).split("#");
			 }
			 for(int i=0;i<n;i++)
			 {
				 data += getStatementType(Pro, id, statements[i][0], statements[i][1])+"\r\n";
			 }
	    	ReadJson.creatWriteTxtFile(path, id+"", data.trim());
	    }
	 
	 
	 public static int calculateOneTongyong(String Pro, int id,int tongyong)//文件路径
	 {
		 String bugPath = "D:\\llpjason\\txtfileall\\"+Pro+"\\"+id+".txt";
		 ArrayList<String> thisbug = readTxtFile(bugPath);
		 int n = thisbug.size();
		 String[][] statements=new String[n][12];
		 for (int i=0;i<n;i++)
		 {
			 statements[i]= thisbug.get(i).split("#");
		 }
		 
		 for(int i=0;i<n;i++)
		 {
			 for(int j=i+1;j<n;j++)
			 {
				 double s1 = Double.valueOf(statements[i][tongyong]);
				 double s2 = Double.valueOf(statements[j][tongyong]);
				 if(s1<s2)
				 {
					 String[] onestatement = new String[12];
					 onestatement = statements[i];
					 statements[i]=statements[j];
					 statements[j]=onestatement;
				 }
			 }
		 }
		 int front = 0;
		 int equal=0;
		 double sus = 0;
		 for(int i=0;i<n;i++)
		 {
			 if(Double.valueOf(statements[i][11])>0)
			 {
				 sus=Double.valueOf(statements[i][tongyong]);
				 break;
			 }
		 }
		 if(sus==0)
		 {
	//		 System.out.println("缺陷"+bugPath+"不可变异");
			 return 100000;
		 }
		 
		 for(int i=0;i<n;i++)
		 {
			 if(Double.valueOf(statements[i][tongyong])>sus)
			 {
				 front++;
			 }else if(Double.valueOf(statements[i][tongyong])==sus)
			 {
				 equal++;
			 }else {
				 break;
			}
		 }
		 

		 return (front+(equal+1)/2);
		 
		 
	 }
	 
	 public static int calculateOneModifiedTongyong(Project P,int id,int tongyong)//文件路径
	 {
		
		 String Pro = P.lowerName;
		 String bugPath = "D:\\llpjason\\txtfileall\\"+Pro+"\\"+id+".txt";
		 ArrayList<String> thisbug = readTxtFile(bugPath);
		 int n = thisbug.size();
		 String[][] statements=new String[n][12];
		 ArrayList<String> typelist = getStatementtypelist(Pro, id);
		 for (int i=0;i<n;i++)
		 {
			 statements[i]= thisbug.get(i).split("#");
			 double score = Double.valueOf(statements[i][tongyong]);
			//String type = getStatementType(Pro, id, statements[i][0], statements[i][1]);
			 String type = typelist.get(i);			 
			 
//			if(type.contains("IfStatement"))
//			{
//				score=score*1.37;
//				statements[i][tongyong]=score+"";
//			}else if(type.contains("ForStatement")&&(!type.contains("Enhance")))
//			{
//				score=score*0.4;
//				statements[i][tongyong]=score+"";
//			}else {
//				
//			}
			 
			 if(type.contains("IfStatement"))
				{
					score=score*P.ifsus;
					statements[i][tongyong]=score+"";
					
				}else if(type.contains("ForStatement")&&(!type.contains("Enhance")))
				{
					score=score*P.forsus;
					statements[i][tongyong]=score+"";
				}else if (type.contains("EnhancedForStatement")){
					score=score*P.enforsus;
					statements[i][tongyong]=score+"";
				
				}else if (type.contains("ReturnStatement")){
					score=score*P.retsus;
					statements[i][tongyong]=score+"";
					
				}
				else if (type.contains("VariableDeclaration")){
					score=score*P.varsus;
					statements[i][tongyong]=score+"";
					
				}else if (type.contains("Constructor")){
					score=score*0.1;
					statements[i][tongyong]=score+"";
					
				}else if (type.contains("ExpressionStatement")){
					score=score*P.expsus;
					statements[i][tongyong]=score+"";
				
				}
			
			
			
			 
		 }
		 
		
		 
		 for(int i=0;i<n;i++)
		 {
			 for(int j=i+1;j<n;j++)
			 {
				 double s1 = Double.valueOf(statements[i][tongyong]);
				 double s2 = Double.valueOf(statements[j][tongyong]);
				 if(s1<s2)
				 {
					 String[] onestatement = new String[12];
					 onestatement = statements[i];
					 statements[i]=statements[j];
					 statements[j]=onestatement;
				 }
			 }
		 }
		 int front = 0;
		 int equal=0;
		 double sus = 0;
		 for(int i=0;i<n;i++)
		 {
			 if(Double.valueOf(statements[i][11])>0)
			 {
				 sus=Double.valueOf(statements[i][tongyong]);
				 break;
			 }
		 }
		 if(sus==0)
		 {
//			 System.out.println("缺陷"+bugPath+"不可变异");
			 return 100000;
		 }
		 
		 for(int i=0;i<n;i++)
		 {
			 if(Double.valueOf(statements[i][tongyong])>sus)
			 {
				 front++;
			 }else if(Double.valueOf(statements[i][tongyong])==sus)
			 {
				 equal++;
			 }else {
				 break;
			}
		 }


		 return (front+(equal+1)/2);
		 
		 
	 }
	 
	 public static int calculateOneMeta(String Pro, int id)//文件路径
	 {
		 String bugPath = "D:\\llpjason\\txtfileall\\"+Pro+"\\"+id+".txt";
		 ArrayList<String> thisbug = readTxtFile(bugPath);
		 int n = thisbug.size();
		 String[][] statements=new String[n][12];
		 for (int i=0;i<n;i++)
		 {
			 statements[i]= thisbug.get(i).split("#");
		 }
		 
		 for(int i=0;i<n;i++)
		 {
			 for(int j=i+1;j<n;j++)
			 {
				 double s1 = Double.valueOf(statements[i][2]);
				 double s2 = Double.valueOf(statements[j][2]);
				 if(s1<s2)
				 {
					 String[] onestatement = new String[12];
					 onestatement = statements[i];
					 statements[i]=statements[j];
					 statements[j]=onestatement;
				 }
			 }
		 }
		 int front = 0;
		 int equal=0;
		 double sus = 0;
		 for(int i=0;i<n;i++)
		 {
			 if(Double.valueOf(statements[i][11])>0)
			 {
				 sus=Double.valueOf(statements[i][2]);
				 break;
			 }
		 }
		 if(sus==0)
		 {
	//		 System.out.println("缺陷"+bugPath+"不可变异");
			 return 100000;
		 }
		 
		 for(int i=0;i<n;i++)
		 {
			 if(Double.valueOf(statements[i][2])>sus)
			 {
				 front++;
			 }else if(Double.valueOf(statements[i][2])==sus)
			 {
				 equal++;
			 }else {
				 break;
			}
		 }
		 
//		 for(int i=0;i<n;i++)
//		 {
//			 System.out.println(statements[i][0]+"  "+statements[i][1]+"  "+statements[i][2]);
//		 }
		 
		 //System.out.println("front:"+front+"equal"+equal);
		 return (front+(equal+1)/2);
		 
		 
	 }
	 
	 public static int calculateOneModifiedMeta(String Pro,int id)//文件路径
	 {
		 String bugPath = "D:\\llpjason\\txtfileall\\"+Pro+"\\"+id+".txt";
		 ArrayList<String> thisbug = readTxtFile(bugPath);
		 int n = thisbug.size();
		 String[][] statements=new String[n][12];
		 ArrayList<String> typelist = getStatementtypelist(Pro, id);
		 for (int i=0;i<n;i++)
		 {
			 statements[i]= thisbug.get(i).split("#");
			 double metallaxis = Double.valueOf(statements[i][2]);
			//String type = getStatementType(Pro, id, statements[i][0], statements[i][1]);
			 String type = typelist.get(i);
			if(type.contains("IfStatement"))
			{
				metallaxis=metallaxis*1.37;
				statements[i][2]=metallaxis+"";
			}else if(type.contains("ForStatement")&&(!type.contains("Enhance")))
			{
				metallaxis=metallaxis*0.4;
				statements[i][2]=metallaxis+"";
			}else {
				
			}
			 
		 }
		 
		
		 
		 for(int i=0;i<n;i++)
		 {
			 for(int j=i+1;j<n;j++)
			 {
				 double s1 = Double.valueOf(statements[i][2]);
				 double s2 = Double.valueOf(statements[j][2]);
				 if(s1<s2)
				 {
					 String[] onestatement = new String[12];
					 onestatement = statements[i];
					 statements[i]=statements[j];
					 statements[j]=onestatement;
				 }
			 }
		 }
		 int front = 0;
		 int equal=0;
		 double sus = 0;
		 for(int i=0;i<n;i++)
		 {
			 if(Double.valueOf(statements[i][11])>0)
			 {
				 sus=Double.valueOf(statements[i][2]);
				 break;
			 }
		 }
		 if(sus==0)
		 {
//			 System.out.println("缺陷"+bugPath+"不可变异");
			 return 100000;
		 }
		 
		 for(int i=0;i<n;i++)
		 {
			 if(Double.valueOf(statements[i][2])>sus)
			 {
				 front++;
			 }else if(Double.valueOf(statements[i][2])==sus)
			 {
				 equal++;
			 }else {
				 break;
			}
		 }
		 
//		 for(int i=0;i<n;i++)
//		 {
//			 System.out.println(statements[i][0]+"  "+statements[i][1]+"  "+statements[i][2]);
//		 }
		 
		// System.out.println("front:"+front+"equal"+equal);
		 return (front+(equal+1)/2);
		 
		 
	 }
	 
	 public static int calculateOneMuse(String Pro, int id)//文件路径
	 {
		 String bugPath = "D:\\llpjason\\txtfileall\\"+Pro+"\\"+id+".txt";
		 ArrayList<String> thisbug = readTxtFile(bugPath);
		 int n = thisbug.size();
		 String[][] statements=new String[n][12];
		 for (int i=0;i<n;i++)
		 {
			 statements[i]= thisbug.get(i).split("#");
		 }
		 
		 for(int i=0;i<n;i++)
		 {
			 for(int j=i+1;j<n;j++)
			 {
				 double s1 = Double.valueOf(statements[i][3]);
				 double s2 = Double.valueOf(statements[j][3]);
				 if(s1<s2)
				 {
					 String[] onestatement = new String[12];
					 onestatement = statements[i];
					 statements[i]=statements[j];
					 statements[j]=onestatement;
				 }
			 }
		 }
		 int front = 0;
		 int equal=0;
		 double sus = 0;
		 for(int i=0;i<n;i++)
		 {
			 if(Double.valueOf(statements[i][11])>0)
			 {
				 sus=Double.valueOf(statements[i][3]);
				 break;
			 }
		 }
		 if(sus==0)
		 {
	//		 System.out.println("缺陷"+bugPath+"不可变异");
			 return 100000;
		 }
		 
		 for(int i=0;i<n;i++)
		 {
			 if(Double.valueOf(statements[i][3])>sus)
			 {
				 front++;
			 }else if(Double.valueOf(statements[i][3])==sus)
			 {
				 equal++;
			 }else {
				 break;
			}
		 }
		 
//		 for(int i=0;i<n;i++)
//		 {
//			 System.out.println(statements[i][0]+"  "+statements[i][1]+"  "+statements[i][2]);
//		 }
		 
		 //System.out.println("front:"+front+"equal"+equal);
		 return (front+(equal+1)/2);
		 
		 
	 }
	 
	 public static int calculateOneModifiedMuse(String Pro,int id)//文件路径
	 {
		 String bugPath = "D:\\llpjason\\txtfileall\\"+Pro+"\\"+id+".txt";
		 ArrayList<String> thisbug = readTxtFile(bugPath);
		 int n = thisbug.size();
		 String[][] statements=new String[n][12];
		 ArrayList<String> typelist = getStatementtypelist(Pro, id);
		 for (int i=0;i<n;i++)
		 {
			 statements[i]= thisbug.get(i).split("#");
			 double Muse = Double.valueOf(statements[i][2]);
			//String type = getStatementType(Pro, id, statements[i][0], statements[i][1]);
			 String type = typelist.get(i);
			if(type.contains("IfStatement"))
			{
				Muse=Muse*1.37;
				statements[i][3]=Muse+"";
			}else if(type.contains("ForStatement")&&(!type.contains("Enhance")))
			{
				Muse=Muse*0.4;
				statements[i][3]=Muse+"";
			}else {
				
			}
			 
		 }
		 
		
		 
		 for(int i=0;i<n;i++)
		 {
			 for(int j=i+1;j<n;j++)
			 {
				 double s1 = Double.valueOf(statements[i][3]);
				 double s2 = Double.valueOf(statements[j][3]);
				 if(s1<s2)
				 {
					 String[] onestatement = new String[12];
					 onestatement = statements[i];
					 statements[i]=statements[j];
					 statements[j]=onestatement;
				 }
			 }
		 }
		 int front = 0;
		 int equal=0;
		 double sus = 0;
		 for(int i=0;i<n;i++)
		 {
			 if(Double.valueOf(statements[i][11])>0)
			 {
				 sus=Double.valueOf(statements[i][3]);
				 break;
			 }
		 }
		 if(sus==0)
		 {
//			 System.out.println("缺陷"+bugPath+"不可变异");
			 return 100000;
		 }
		 
		 for(int i=0;i<n;i++)
		 {
			 if(Double.valueOf(statements[i][3])>sus)
			 {
				 front++;
			 }else if(Double.valueOf(statements[i][3])==sus)
			 {
				 equal++;
			 }else {
				 break;
			}
		 }
		 
//		 for(int i=0;i<n;i++)
//		 {
//			 System.out.println(statements[i][0]+"  "+statements[i][1]+"  "+statements[i][2]);
//		 }
		 
		// System.out.println("front:"+front+"equal"+equal);
		 return (front+(equal+1)/2);
		 
		 
	 }
	 
	 public static int calculateOneOchiai(String Pro, int id)//文件路径
	 {
		 String bugPath = "D:\\llpjason\\txtfileall\\"+Pro+"\\"+id+".txt";
		 ArrayList<String> thisbug = readTxtFile(bugPath);
		 int n = thisbug.size();
		 String[][] statements=new String[n][12];
		 for (int i=0;i<n;i++)
		 {
			 statements[i]= thisbug.get(i).split("#");
		 }
		 
		 for(int i=0;i<n;i++)
		 {
			 for(int j=i+1;j<n;j++)
			 {
				 double s1 = Double.valueOf(statements[i][4]);
				 double s2 = Double.valueOf(statements[j][4]);
				 if(s1<s2)
				 {
					 String[] onestatement = new String[12];
					 onestatement = statements[i];
					 statements[i]=statements[j];
					 statements[j]=onestatement;
				 }
			 }
		 }
		 int front = 0;
		 int equal=0;
		 double sus = 0;
		 for(int i=0;i<n;i++)
		 {
			 if(Double.valueOf(statements[i][11])>0)
			 {
				 sus=Double.valueOf(statements[i][4]);
				 break;
			 }
		 }
		 if(sus==0)
		 {
	//		 System.out.println("缺陷"+bugPath+"不可变异");
			 return 100000;
		 }
		 
		 for(int i=0;i<n;i++)
		 {
			 if(Double.valueOf(statements[i][4])>sus)
			 {
				 front++;
			 }else if(Double.valueOf(statements[i][4])==sus)
			 {
				 equal++;
			 }else {
				 break;
			}
		 }
		 
//		 for(int i=0;i<n;i++)
//		 {
//			 System.out.println(statements[i][0]+"  "+statements[i][1]+"  "+statements[i][2]);
//		 }
		 
		 //System.out.println("front:"+front+"equal"+equal);
		 return (front+(equal+1)/2);
		 
		 
	 }
	 
	 public static int calculateOneModifiedOchiai(String Pro,int id)//文件路径
	 {
		 String bugPath = "D:\\llpjason\\txtfileall\\"+Pro+"\\"+id+".txt";
		 ArrayList<String> thisbug = readTxtFile(bugPath);
		 int n = thisbug.size();
		 String[][] statements=new String[n][12];
		 ArrayList<String> typelist = getStatementtypelist(Pro, id);
		 for (int i=0;i<n;i++)
		 {
			 statements[i]= thisbug.get(i).split("#");
			 double Ochiai = Double.valueOf(statements[i][4]);
			//String type = getStatementType(Pro, id, statements[i][0], statements[i][1]);
			 String type = typelist.get(i);
			if(type.contains("IfStatement"))
			{
				Ochiai=Ochiai*1.37;
				statements[i][4]=Ochiai+"";
			}else if(type.contains("ForStatement")&&(!type.contains("Enhance")))
			{
				Ochiai=Ochiai*0.4;
				statements[i][4]=Ochiai+"";
			}else {
				
			}
			 
		 }
		 
		
		 
		 for(int i=0;i<n;i++)
		 {
			 for(int j=i+1;j<n;j++)
			 {
				 double s1 = Double.valueOf(statements[i][4]);
				 double s2 = Double.valueOf(statements[j][4]);
				 if(s1<s2)
				 {
					 String[] onestatement = new String[12];
					 onestatement = statements[i];
					 statements[i]=statements[j];
					 statements[j]=onestatement;
				 }
			 }
		 }
		 int front = 0;
		 int equal=0;
		 double sus = 0;
		 for(int i=0;i<n;i++)
		 {
			 if(Double.valueOf(statements[i][11])>0)
			 {
				 sus=Double.valueOf(statements[i][4]);
				 break;
			 }
		 }
		 if(sus==0)
		 {
//			 System.out.println("缺陷"+bugPath+"不可变异");
			 return 100000;
		 }
		 
		 for(int i=0;i<n;i++)
		 {
			 if(Double.valueOf(statements[i][4])>sus)
			 {
				 front++;
			 }else if(Double.valueOf(statements[i][4])==sus)
			 {
				 equal++;
			 }else {
				 break;
			}
		 }
		 
//		 for(int i=0;i<n;i++)
//		 {
//			 System.out.println(statements[i][0]+"  "+statements[i][1]+"  "+statements[i][2]);
//		 }
		 
		// System.out.println("front:"+front+"equal"+equal);
		 return (front+(equal+1)/2);
		 
		 
	 }
	 
	 public static int calculateOneDstar(String Pro, int id)//文件路径
	 {
		 String bugPath = "D:\\llpjason\\txtfileall\\"+Pro+"\\"+id+".txt";
		 ArrayList<String> thisbug = readTxtFile(bugPath);
		 int n = thisbug.size();
		 String[][] statements=new String[n][12];
		 for (int i=0;i<n;i++)
		 {
			 statements[i]= thisbug.get(i).split("#");
		 }
		 
		 for(int i=0;i<n;i++)
		 {
			 for(int j=i+1;j<n;j++)
			 {
				 double s1 = Double.valueOf(statements[i][5]);
				 double s2 = Double.valueOf(statements[j][5]);
				 if(s1<s2)
				 {
					 String[] onestatement = new String[12];
					 onestatement = statements[i];
					 statements[i]=statements[j];
					 statements[j]=onestatement;
				 }
			 }
		 }
		 int front = 0;
		 int equal=0;
		 double sus = 0;
		 for(int i=0;i<n;i++)
		 {
			 if(Double.valueOf(statements[i][11])>0)
			 {
				 sus=Double.valueOf(statements[i][5]);
				 break;
			 }
		 }
		 if(sus==0)
		 {
	//		 System.out.println("缺陷"+bugPath+"不可变异");
			 return 100000;
		 }
		 
		 for(int i=0;i<n;i++)
		 {
			 if(Double.valueOf(statements[i][5])>sus)
			 {
				 front++;
			 }else if(Double.valueOf(statements[i][5])==sus)
			 {
				 equal++;
			 }else {
				 break;
			}
		 }
		 
//		 for(int i=0;i<n;i++)
//		 {
//			 System.out.println(statements[i][0]+"  "+statements[i][1]+"  "+statements[i][2]);
//		 }
		 
		 //System.out.println("front:"+front+"equal"+equal);
		 return (front+(equal+1)/2);
		 
		 
	 }
	 
	 public static int calculateOneModifiedDstar(String Pro,int id)//文件路径
	 {
		 String bugPath = "D:\\llpjason\\txtfileall\\"+Pro+"\\"+id+".txt";
		 ArrayList<String> thisbug = readTxtFile(bugPath);
		 int n = thisbug.size();
		 String[][] statements=new String[n][12];
		 ArrayList<String> typelist = getStatementtypelist(Pro, id);
		 for (int i=0;i<n;i++)
		 {
			 statements[i]= thisbug.get(i).split("#");
			 double Dstar = Double.valueOf(statements[i][5]);
			//String type = getStatementType(Pro, id, statements[i][0], statements[i][1]);
			 String type = typelist.get(i);
			if(type.contains("IfStatement"))
			{
				Dstar=Dstar*1.37;
				statements[i][5]=Dstar+"";
			}else if(type.contains("ForStatement")&&(!type.contains("Enhance")))
			{
				Dstar=Dstar*0.4;
				statements[i][5]=Dstar+"";
			}else {
				
			}
			 
		 }
		 
		
		 
		 for(int i=0;i<n;i++)
		 {
			 for(int j=i+1;j<n;j++)
			 {
				 double s1 = Double.valueOf(statements[i][5]);
				 double s2 = Double.valueOf(statements[j][5]);
				 if(s1<s2)
				 {
					 String[] onestatement = new String[12];
					 onestatement = statements[i];
					 statements[i]=statements[j];
					 statements[j]=onestatement;
				 }
			 }
		 }
		 int front = 0;
		 int equal=0;
		 double sus = 0;
		 for(int i=0;i<n;i++)
		 {
			 if(Double.valueOf(statements[i][11])>0)
			 {
				 sus=Double.valueOf(statements[i][5]);
				 break;
			 }
		 }
		 if(sus==0)
		 {
//			 System.out.println("缺陷"+bugPath+"不可变异");
			 return 100000;
		 }
		 
		 for(int i=0;i<n;i++)
		 {
			 if(Double.valueOf(statements[i][5])>sus)
			 {
				 front++;
			 }else if(Double.valueOf(statements[i][5])==sus)
			 {
				 equal++;
			 }else {
				 break;
			}
		 }
		 
//		 for(int i=0;i<n;i++)
//		 {
//			 System.out.println(statements[i][0]+"  "+statements[i][1]+"  "+statements[i][2]);
//		 }
		 
		// System.out.println("front:"+front+"equal"+equal);
		 return (front+(equal+1)/2);
		 
		 
	 }
	 
	 public static String getStatementType(String Pro, int id,String filename, String line)
	 {
		 ArrayList<String> thisbug = readTxtFile2("D:\\llpjason\\data\\"+Pro+"\\"+id+".txt");
		// "D:\\llpjason\\data\\math\\2.txt"
		 int n = thisbug.size();
		 String[][] statements=new String[n][3];
		 for (int i=0;i<n;i++)
		 {
			 statements[i]= thisbug.get(i).split("#");
		 }
		 String ret = "NoneType";
		 for(int i=0;i<n;i++)
		 {
			 if(statements[i][0].trim().equals(filename.trim())&&statements[i][1].equals(line))
			 {
				 ret = statements[i][2];
				 break;
			 }
		 }
		 return ret;
	 }
	 
	 
	  public static ArrayList<String> readTxtFile(String filePath){
		  ArrayList<String> ret = new ArrayList<String>();
	        try {
	        		
	                String encoding="GBK";

	                File file=new File(filePath);

	                if(file.isFile() && file.exists()){ //判断文件是否存在

	                    InputStreamReader read = new InputStreamReader(

	                    new FileInputStream(file),encoding);//考虑到编码格式

	                    BufferedReader bufferedReader = new BufferedReader(read);

	                    String lineTxt = null;

	                    while((lineTxt = bufferedReader.readLine()) != null){
	                    	ret.add(lineTxt);
	                   //     System.out.println(lineTxt);
	                    }
	                    read.close();
	                    return ret;

	        }else{
	            System.out.println("找不到指定的文件："+filePath);
	            return ret;
	        }

	        } catch (Exception e) {
	            System.out.println("读取文件内容出错");
	            e.printStackTrace();
	            return ret;
	        }	     

	    }
	  
	  
	  public static ArrayList<String> readTxtFile2(String filePath){
		  ArrayList<String> ret = new ArrayList<String>();
		  try {
			     
	            InputStreamReader isr = new InputStreamReader(new FileInputStream(filePath),"GBK");
	            BufferedReader br = new BufferedReader(isr);
	            String temp = null;
	            while((temp = br.readLine()) != null){
	            	ret.add(temp);
	                //System.out.println(temp);
	            }
	            br.close();
	        } catch (FileNotFoundException e) {
	     
	            // TODO Auto-generated catch block
	            e.printStackTrace();

	        }catch (IOException e) {
	     
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
		  return ret;

	  }

}
