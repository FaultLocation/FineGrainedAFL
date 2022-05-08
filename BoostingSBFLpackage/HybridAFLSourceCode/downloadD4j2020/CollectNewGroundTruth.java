package downloadD4j2020;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CollectNewGroundTruth {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 List<statementline> try1 = getGroundTruth("Jsoup",73);
//		 for(int i = 0;i<try1.size();i++)
//		{
//			 System.out.println(try1.get(i).Path);
//			 System.out.println(try1.get(i).lineNum);
//			 System.out.println();
//		
//		}
		
	}

	
	public static List<statementline> getGroundTruth(String ProName, int bugID)
	{
		String tmpline = "";
		List<statementline> ret = new ArrayList<statementline>();
		try{
			BufferedReader br = 
					new BufferedReader(new InputStreamReader(new FileInputStream(
			//				"/home/bitse/simfix (backup)/SimFix(1218)/d4j-info/location/ochiai/"+ProName+"/"+bugID+".txt"
					"/home1/lileping/groundtruth/"+ProName+"/"+bugID+".txt"
					
					
					)));
			List<statementline> statements = new ArrayList<statementline>();
			
			for(String line = br.readLine();line!=null;line = br.readLine())
			{
				if(line.equals(tmpline))
				{continue;}//说明重复了				
		//		System.out.println(line);
				statementline l = new statementline();
				String[] thisline = line.split("#");
				l.Path = thisline[0];
				l.lineNum = Integer.valueOf(thisline[1]);
		//		statementline.printLineInfo(l);
				ret.add(l);
				//System.out.println(devideInfo(line));
				tmpline = line;
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
	
}
