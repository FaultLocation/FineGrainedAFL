package downloadD4j2020;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class searchsource {

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		statementline l0 = new statementline();
		//"org.apache.commons.math3.util.ArithmeticUtils#276,0.04856429311786321,(479,534)
		l0.Path =  "org/apache/commons/math3/util/ArithmeticUtils.java";
		l0.lineNum=  276;
		l0.possibility=  48;
		l0.rank1=  479;
		l0.rank2=  534;
		
		
		getStatementText("Math",1,l0,experiment.MathRoot);

	}
	public static String getStatementText(String ProName, int bugID, statementline l,String rootpath)
	{
//		System.out.println("kaishishiyan");
//		System.out.println("/home1/tmp/"+ProName+"_"+bugID+"_buggy"+ rootpath+l.Path);
		
		
		try{
			BufferedReader br = 
					new BufferedReader(new InputStreamReader(new FileInputStream(
							"/home1/tmp/"+ProName+"_"+bugID+"_buggy"+rootpath+l.Path
					)));
		//	List<statementline> statements = new ArrayList<statementline>();
			
			int i = 0;
			for(String line = br.readLine();line!=null;line = br.readLine())
			{
				i++;
				if(i == l.lineNum)
				{
					br.close();
					return line;
					//System.out.println(line);
				}
				
				
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
		return "";
	}

}
