package downloadD4j2020;

public class statementline {
	public String Path="";
	public String Text="";
	public Integer lineNum=0;
	public Integer possibility=0;
	public Integer rank1=0;
	public Integer rank2=0;
	public String type = "unknown";
	public String ParentMethod = "unknown";
	public static void printLineInfo(statementline l)
	{
		System.out.println("Path:  "+l.Path);
		System.out.println("lineNum:  "+l.lineNum);
		System.out.println("type:  "+l.type);
		System.out.println("possibility:  "+l.possibility);
//		System.out.println("rank1:  "+l.rank1);
//		System.out.println("rank2:  "+l.rank2);
	}
	
}
