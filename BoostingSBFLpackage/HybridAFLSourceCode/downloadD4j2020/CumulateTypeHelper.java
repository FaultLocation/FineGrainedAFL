package downloadD4j2020;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class CumulateTypeHelper {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	//	printCumuResult("Closure");
		printCumuResultUpgraded("Math",106);
	}

	
	public static void printCumuResult (String ProName)
	{
		
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
	
		
		
		for(int n=1;n<=36;n++){
		
		try{
			BufferedReader br = 
					new BufferedReader(new InputStreamReader(new FileInputStream(
							"/home1/RetryD4jType/"+ProName+"/"+n+".txt"
					)));
		
			
			
			for(String line = br.readLine();line!=null;line = br.readLine())
			{
				line = line.trim();
				if(line.indexOf(":")!=line.lastIndexOf(":")||line.contains("Project:")||line.trim().length()==0)
				{continue;}
				
				
				String[] preprocess = line.split("\\s+");
				
				System.out.println(preprocess[1]+"        "+"     长度 "+preprocess.length );
				
				if(preprocess.length!=2)
				{continue;}
				
				String thistype = preprocess[0];
				int thistypeNum = Integer.valueOf(preprocess[1]);
			
				if (thistype == null) {
				} else if (thistype.contains("AssertStatement")) {
					TotalAssertStatement+=thistypeNum;
				} else if (thistype.contains("Block")) {
					TotalBlock+=thistypeNum;
				} else if (thistype.contains("BreakStatement")) {
					TotalBreakStatement+=thistypeNum;
				} else if (thistype.contains("ConstructorInvocation")) {
					TotalConstructorInvocation+=thistypeNum;
				} else if (thistype.contains("ContinueStatement")) {
					TotalContinueStatement+=thistypeNum;
				} else if (thistype.contains("DoStatement")) {
					TotalDoStatement+=thistypeNum;
				} else if (thistype.contains("EmptyStatement")) {
					TotalEmptyStatement+=thistypeNum;
				} else if (thistype.contains("EnhancedForStatement")) {
					TotalEnhancedForStatement+=thistypeNum;
				} else if (thistype.contains("ExpressionStatement")) {
					TotalExpressionStatement+=thistypeNum;
				} else if (thistype.contains("ForStatement")) {
					TotalForStatement+=thistypeNum;
				} else if (thistype.contains("IfStatement")) {
					TotalIfStatement+=thistypeNum;
				} else if (thistype.contains("LabeledStatement")) {
					TotalLabeledStatement+=thistypeNum;
				} else if (thistype.contains("ReturnStatement")) {
					TotalReturnStatement+=thistypeNum;
				} else if (thistype.contains("SuperConstructorInvocation")) {
					TotalSuperConstructorInvocation+=thistypeNum;
				} else if (thistype.contains("SwitchCase")) {
					TotalSwitchCase+=thistypeNum;
				} else if (thistype.contains("SwitchStatement")) {
					TotalSwitchStatement+=thistypeNum;
				} else if (thistype.contains("SynchronizedStatement")) {
					TotalSynchronizedStatement+=thistypeNum;
				} else if (thistype.contains("ThrowStatement")) {
					TotalThrowStatement+=thistypeNum;
				} else if (thistype.contains("TryStatement")) {
					TotalTryStatement+=thistypeNum;
				} else if (thistype.contains("TypeDeclarationStatement")) {
					TotalTypeDeclarationStatement+=thistypeNum;
				} else if (thistype.contains("VariableDeclarationStatement")) {
					TotalVariableDeclarationStatement+=thistypeNum;
				} else if (thistype.contains("WhileStatement")) {
					TotalWhileStatement+=thistypeNum;
				} else if (thistype.contains("ImportDeclaration")) {
					TotalImportDeclaration+=thistypeNum;
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
	}
		
		String result = "";
		result += "\n" + ("Project:  " + ProName);

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
		System.out.println(result);
		
	}
	
	public static void printCumuResultUpgraded (String ProName, int TotalBug)//20211028針對Expression Statement分成MethodInvocation和Assignment處理
	{
		
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
		
		
		for(int n=1;n<=TotalBug;n++){
		
		try{
			BufferedReader br = 
					new BufferedReader(new InputStreamReader(new FileInputStream(
							"/home1/D4jTypeListUpgraded/"+ProName+"/"+n+".txt"
					)));
		
			
			
			for(String line = br.readLine();line!=null;line = br.readLine())
			{
				line = line.trim();
//				if(line.indexOf(":")!=line.lastIndexOf(":")||line.contains("Project:")||line.trim().length()==0)
//				{continue;}
				if(line.length()==0)
				{
					continue;
				}
				
				//String[] preprocess = line.split("\\s+");
				String[] preprocess = line.split("#");
				//System.out.println(preprocess[1]+"        "+"     长度 "+preprocess.length );
				
				if(preprocess.length!=3)
				{continue;}
				
				String thistype = preprocess[2];
				
			
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
	}
		
		String result = "";
		result += "\n" + ("Project:  " + ProName);

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
		
		result+= "\n" + ("MethodInvocation:  " + TotalMethodInvocation); 
		result+= "\n" + ("Assignment:  " + TotalAssignment); 
		System.out.println(result);
		
	}
	
}
