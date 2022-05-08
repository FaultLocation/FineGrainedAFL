package downloadD4j2020;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class readtxt {

	public static void main(String[] args) {
		System.out.println("begin");
		// TODO Auto-generated method stub
		List<statementline> statements = new ArrayList<statementline>();
		statements = getstatementlist("mockito",1);
		for(int i=0;i<statements.size();i++)
		{
			statementline.printLineInfo(statements.get(i));
		}
		
	}
	public static List<statementline> getstatementlist(String ProName, int bugID)
	{
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
				if(line.contains(",0.0,"))
				{break;}
//				System.out.println(line);
				statementline l = new statementline();
				l = initialLine(line);
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
	
	public static List<statementline> getallstatementlist(String ProName, int bugID)
	{
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
				
				statementline l = new statementline();
				l = initialLine(line);
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
	
	public static String toPath(String root,String className)
	{
		String path = root + className.replace(".", "/")+".java";
		return path;
	}
	
	public static statementline initialLine(String line)
	{
		statementline ret = new statementline();
		
		String[] split = line.split(",",3);
		String[] split0 = split[0].split("#");
		
		
		String  path = "";
		if(split0[0].contains("$"))
		{
			path = split0[0].substring(0,split0[0].indexOf("$"));

//			System.out.println(path);
//			System.exit(0);
		}
		else
		{path = split0[0];}
		
		
		
		String lineNum = split0[1];
		String possibility = split[1];
		String rank = split[2];
		rank = rank.substring(1, rank.length()-1);
		String[] rank0 = rank.split(",");
		int rank1 = Integer.valueOf(rank0[0]);
	//	System.out.println(rank0[0]+"   "+rank0[1]);
		int rank2 = Integer.valueOf(rank0[1]);
		
		ret.Path = path.replace(".", "/")+".java";
		ret.lineNum = Integer.valueOf(lineNum);
		ret.possibility = (int) (Float.valueOf(possibility)*1000000);
		ret.rank1 = rank1;
		ret.rank2 = rank2;
		return ret;
	}
	
	
	public static String[] devideInfo(String line)
	{
		String[] split = line.split(",");
		String[] split0 = split[0].split("#");
		
		String path = split0[0];
		String lineNum = split0[1];
		String possibility = split[1];
		String rank = split[2];
		String[] info = {path,lineNum,possibility,rank};
		return info;
	}
	
	

}
