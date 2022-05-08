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
import java.util.Collections;
import java.util.List;

public class CalSBFLScore {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 
		
//		  for(int a = 1;a<=40;a++)
//	        {getSBFLStatementList("Cli",a);}
//
//		  for(int a = 1;a<=18;a++)
//	        {getSBFLStatementList("Codec",a);}
//		
		  for(int a = 25;a<=28;a++)
	        {getSBFLStatementList("Collections",a);}
//		
//		  for(int a = 1;a<=47;a++)
//	        {getSBFLStatementList("Compress",a);}
//		
//		  for(int a = 1;a<=16;a++)
//	        {getSBFLStatementList("Csv",a);}    
//		
//		  for(int a = 1;a<=18;a++)
//	        {getSBFLStatementList("Gson",a);}
//		
//		  for(int a = 1;a<=22;a++)
//	        {getSBFLStatementList("JxPath",a);}
//		  
//		  for(int a = 1;a<=26;a++)
//	        {getSBFLStatementList("JacksonCore",a);}
//		  
//		  for(int a = 1;a<=112;a++)
//	        {getSBFLStatementList("JacksonDatabind",a);}
	
		  
		//Failed Project  
//		  for(int a = 1;a<=6;a++)
//	        {getSBFLStatementList("JacksonXml",a);}
		
//		  for(int a = 2;a<=93;a++)
//	        {getSBFLStatementList("Jsoup",a);}
		
		
		  
		  
//		D4jVersion1.2
//		  
//		   for(int a = 1;a<=26;a++)
//	        {getSBFLStatementList("Time",a);}		
//		
//		  for(int a = 1;a<=65;a++)
//	        {getSBFLStatementList("Lang",a);}//		
//	        
//	        for(int a = 1;a<=106;a++)
//	        {getSBFLStatementList("Math",a);}
//	        
//	
//			  for(int a = 1;a<=133;a++)//应为176
//	        {getSBFLStatementList("Closure",a);}
//		
//		    for(int a = 1;a<=38;a++)
//		    	
//            {getSBFLStatementList("Mockito",a);}    
//	        
//	        for(int a = 1;a<=26;a++)
//	        {getSBFLStatementList("Chart",a);}
	}
	public static List<statementline> getSBFLStatementList(String ProName, int bugID)
	{
		System.out.println("Project:"+ProName+"   bugID:"+bugID);
		List<String> spectra = new ArrayList<String>();
		List<String> statements = new ArrayList<String>();
		List<Double> scores = new ArrayList<Double>();
		  String originallString = "";
	    String finalString = "";
		
	//	List<statementline> statementlines = new ArrayList<statementline>();
		try{
			BufferedReader br = 
					new BufferedReader(new InputStreamReader(new FileInputStream(
						//	"/home/bitse/simfix (backup)/SimFix(1218)/d4j-info/location/ochiai/"+ProName+"/"+bugID+".txt"
					//		"/home1/lileping/GZoltarResult (copy 1)/fault-localization.cs.washington.edu/data/"+ProName+"/"+bugID+"/gzoltars/"+ProName+"/"+bugID+"/"+"matrix"							
							"/home1/lileping/tryGZoltar/"+ProName+"_"+bugID+"/"+"matrix"	
							)));		
			
			for(String line = br.readLine();line!=null;line = br.readLine())
			{
//				if(line.contains(",0.0,"))
//				{break;}
				//System.out.println(line);
		//		System.out.println(line.substring(line.length()-1,line.length()));
				
		//		statementline l = new statementline();
		//		l = initialLine(line);
				
		//		statementline.printLineInfo(l);
				
				spectra.add(line);
				
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
		
		
		try{
			BufferedReader br2 = 
					new BufferedReader(new InputStreamReader(new FileInputStream(
						//	"/home/bitse/simfix (backup)/SimFix(1218)/d4j-info/location/ochiai/"+ProName+"/"+bugID+".txt"
				//			"/home1/lileping/GZoltarResult (copy 1)/fault-localization.cs.washington.edu/data/"+ProName+"/"+bugID+"/gzoltars/"+ProName+"/"+bugID+"/"+"spectra"	
						"/home1/lileping/tryGZoltar/"+ProName+"_"+bugID+"/"+"spectra"	
					)));
		
			
			for(String line = br2.readLine();line!=null;line = br2.readLine())
			{

	//			System.out.println(line);
		//		System.out.println(line.substring(line.length()-1,line.length()));
				
		//		statementline l = new statementline();
		//		l = initialLine(line);
				
		//		statementline.printLineInfo(l);
				
				statements.add(line);
				
				//System.out.println(devideInfo(line));
				
			}
			br2.close();
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
			
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		
		System.out.println("spectrasize:"+spectra.size());
		System.out.println("statementssize:"+statements.size());
//		System.out.println(spectra.get(0).substring(0,spectra.get(0).length()-2).split(" ").length);
	
		int[] finalrank = new int[statements.size()];
		for(int i =0; i<finalrank.length;i++)
		{
			finalrank[i]=i;//注意是从0开始排的
		}
		
		String[][]metrix = new String[spectra.size()][statements.size()];
		boolean [] PassOrNot = new boolean [spectra.size()];				
		
		for(int i =0;i<spectra.size();i++)
		{
			metrix[i]=spectra.get(i).substring(0,spectra.get(i).length()-2).split(" ");
			if(spectra.get(i).substring(spectra.get(i).length()-1,spectra.get(i).length()).equals("+"))
				{PassOrNot[i]=true;}
			else
			{PassOrNot[i]=false;}
		}
		
		for(int j = 0;j<statements.size();j++)
		{
			double thisScore = calSBFLOchiai(metrix,PassOrNot,j);
			
//			if(thisScore>0)
//		  {System.out.println(thisScore);}	
			
			scores.add(thisScore);
		}		
		
		for(int i=0;i<statements.size()-1;i++)
		{
			for(int j=i;j<statements.size();j++)
			{
				double score1 = scores.get(i);
				double score2 = scores.get(j);
				if(score1<score2)
				{
					Collections.swap(scores, i, j);
					int tmp = finalrank[i];
					finalrank[i]=finalrank[j];
					finalrank[j]= tmp;					
				}
			}
		}
		
		
		for(int i =0;i<finalrank.length;i++)
		{
		//	System.out.println(finalrank[i]);
			finalString += statements.get(finalrank[i])+","+scores.get(i)+",(0,0)"+"\n";
		
		}
		finalString=finalString.trim();
	//	System.out.println(finalString);
		
		
		String filepath01 = "/home/bitse/simfix (backup)/SimFix(1218)/d4j-info/location/"+experiment.SBFLFomula+"/"+ProName;
		File newF01 = new File(filepath01);
		if(!newF01.exists())
		{newF01.mkdir();}
		
		
		
		String filepath = "/home/bitse/simfix (backup)/SimFix(1218)/d4j-info/location/"+experiment.SBFLFomula+"/"+ProName+"/"+bugID+".txt";
		 File newF = new File(filepath);
		 if(!newF.exists())
		 {
		 try {
			 newF.createNewFile();
	            BufferedWriter out = new BufferedWriter(new FileWriter(filepath ));
	            out.write(finalString);	           
	            out.close();
	            System.out.println("文件创建成功！");
	        } catch (IOException e) {
	        	e.printStackTrace();
	        }
		 }
		
		
		 System.out.println();
		return null;
	}
	
	
	public static double calSBFLOchiai(String[][]metrix, boolean[] PassOrNot,int  x)
	{
		double CP =0.0;
		double CF = 0.0;
		double UP = 0.0;
		double UF =0.0;
	
		for(int i=0;i<PassOrNot.length;i++)
		{		
			
			if(metrix[i][x].equals("1"))
			{
				if(PassOrNot[i]==true)
				{CP++;}
				else
				{CF++;}
			}
			else
			{
				if(PassOrNot[i]==true)
				{UP++;}
				else
				{UF++;}
			}
			
		}
		//if(CF>0)
		//System.out.println("Utotal+"+(UP+UF)+"   ;total:"+(CP+CF));
		
//		if(CF>0)
//	System.out.println("ID:   "+x+ "   CF: " +CF+"    UF:  "+UF+"   CP:   "+CP +"   UP:   "+UP);
	
		double sus = 0.0;
		if(CF==0)
		{sus =0.0;}
		else if(CP == 0)
		{sus = 1.0;}
		else
		{
			//	 sus = CF/Math.sqrt(((CF+UF)*(CF+CP)));//Ochiai		
			
	//		System.out.println("ID:   "+x+ "   CF: " +CF+"    UF:  "+UF+"   CP:   "+CP +"   UP:   "+UP);			
	//		 sus = (CF/(CF+UF))  /(  (CF/(CF+UF)) + (CP/(CP+UP))   );//Tarantula						
				
		//	 sus = CF/(CF+CP+UF);  //Jaccard
			
	//		 sus = (CF*CF)/(CP+UF);//DStar2
			 sus = CF/(CF+CP); //barinel
//			
		}

		
		
		
		
		sus = (double)Math.round(sus*1000000)/1000000;
		return sus;
	}
	
	

}
