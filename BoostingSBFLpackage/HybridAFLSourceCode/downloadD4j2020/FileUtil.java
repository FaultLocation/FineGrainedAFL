package downloadD4j2020;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.AbstractTypeDeclaration;
import org.eclipse.jdt.core.dom.Block;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.ExpressionStatement;
import org.eclipse.jdt.core.dom.ForStatement;
import org.eclipse.jdt.core.dom.IfStatement;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.MethodInvocation;
import org.eclipse.jdt.core.dom.QualifiedName;
import org.eclipse.jdt.core.dom.Statement;
import org.eclipse.jdt.core.dom.StringLiteral;
import org.eclipse.jdt.core.dom.TypeDeclaration;
import org.eclipse.jdt.core.dom.WhileStatement;
import org.eclipse.jdt.core.dom.rewrite.ASTRewrite;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.Document;
import org.eclipse.text.edits.MalformedTreeException;
import org.eclipse.text.edits.TextEdit;
import org.omg.CORBA.PUBLIC_MEMBER;


public class FileUtil {
	public static File dirFrom;
	public static File dirTo;
	public static List<String> simpleNameOfSelectedFiles = new ArrayList<>(); 
	public static int statementID = 0; // �����������
	
	public static void main(String[] args) throws IOException{

		//InsertStatementsForOriginalFile("D:\\LLP\\916A");
	}
	
	public static ExpressionStatement createInsertStatement(AST ast){
		//ExpressionStatement myExpressionStatement = ast.newE
		QualifiedName qualifiedName = ast.newQualifiedName(ast.newName("System"), ast.newSimpleName("out"));
		MethodInvocation methodInvocation = ast.newMethodInvocation();
		methodInvocation.setExpression(qualifiedName);
		methodInvocation.setName(ast.newSimpleName("println"));
		StringLiteral literal = ast.newStringLiteral();
		String value = "bitse207 "+ (++statementID);
		literal.setLiteralValue(value);
		methodInvocation.arguments().add(literal);
		ExpressionStatement myExpressionStatement = ast.newExpressionStatement(methodInvocation);
		return myExpressionStatement;
		
	}
	
	public static boolean isInsertStatement(ASTNode node){
		if((node instanceof ExpressionStatement) && (node.toString().startsWith("System.out.println(\"bitse207"))){
			return true;
		}
		return false;
	}
	
	//e.g. D:\LLP\916A
	public static void InsertStatementsForOriginalFile(String path, File sourceFile) throws IOException{

				File originalFile = sourceFile;
				//  start--------------------------------------------------
				String  source = FileUtils.readFileToString(originalFile);
		        Document document = new Document(source);
		        System.out.println("document-------------\n"+document.get());
		        
				Map<String, String> options = JavaCore.getOptions(); 
		        options.put(JavaCore.COMPILER_COMPLIANCE, JavaCore.VERSION_1_8); 
		        options.put(JavaCore.COMPILER_CODEGEN_TARGET_PLATFORM, 
		        		JavaCore.VERSION_1_8); 
		        options.put(JavaCore.COMPILER_SOURCE, JavaCore.VERSION_1_8); 
		        
		        ASTParser astParser = ASTParser.newParser(AST.JLS4);
		        
		        
		        astParser.setSource(document.get().toCharArray());
		        astParser.setKind(ASTParser.K_COMPILATION_UNIT);
		        astParser.setEnvironment( // apply classpath
		                new String[] { "D:\\Program Files\\Java\\jdk1.8.0_181\\src.zip" }, //
		                new String[]{path+"\\originalFile"}, new String[] { "UTF-8" }, true);
		        
		        astParser.setBindingsRecovery(true); 
		        astParser.setResolveBindings(true); 
		        astParser.setStatementsRecovery(true); 
		        astParser.setBindingsRecovery(true); 
		        astParser.setUnitName(originalFile.getName()); 
		        astParser.setCompilerOptions(options); 
		        CompilationUnit compilationUnit = (CompilationUnit) (astParser.createAST(null));  
		        compilationUnit.recordModifications();
		        
		        System.out.println("SSSSSSSSSSSSSSSSSSSS");
		        System.out.println(compilationUnit);
		        //�����޸�
		        MethodDeclaration mainMethodDeclaration = null;
		        List<AbstractTypeDeclaration > absTyeps = compilationUnit.types();
		        for(AbstractTypeDeclaration ty: absTyeps){
		        	if(ty instanceof TypeDeclaration){
		        		TypeDeclaration typeDeclaration = (TypeDeclaration)ty;
		        		for(MethodDeclaration md: typeDeclaration.getMethods()){
		        			//if(md.getName().toString().equals("main")){
		        				mainMethodDeclaration = md;
		        				md.accept(new ASTVisitor() {
		        					//�����޸�
		        					
		        					
		        					//���� for
		        					public boolean visit(ForStatement node){
		        						if(!(node.getBody() instanceof Block)){
		        							Block  block = compilationUnit.getAST().newBlock();
		        							ASTNode newNode = block.copySubtree(compilationUnit.getAST(), node.getBody());
		        							block.statements().add(newNode);
		        							//node.getBody().delete();
		        							node.setBody(block);
		        						}
		        						return true;
		        					}
		        					
		        					
		        					//����if
		        					public boolean visit(IfStatement node){
		        						if(node.getElseStatement() != null && !(node.getElseStatement() instanceof Block)){
		        							Block block = compilationUnit.getAST().newBlock();
		        							ASTNode newNode = node.copySubtree(compilationUnit.getAST(), node.getElseStatement());
		        							block.statements().add(newNode);
		        							node.setElseStatement(block);
		        						}
		        						if(node.getThenStatement() != null && !(node.getThenStatement() instanceof Block)){
		        							Block block = compilationUnit.getAST().newBlock();
		        							ASTNode newNode = node.copySubtree(compilationUnit.getAST(), node.getThenStatement());
		        							block.statements().add(newNode);
		        							node.setThenStatement(block);
		        						}
		        						return true;
		        					}
		        					
		        					public boolean visit(WhileStatement node){
		        						if(!(node.getBody() instanceof Block)){
		        							Block  block = compilationUnit.getAST().newBlock();
		        							ASTNode newNode = block.copySubtree(compilationUnit.getAST(), node.getBody());
		        							block.statements().add(newNode);
		        							//node.getBody().delete();
		        							node.setBody(block);
		        						}
		        						return true;
		        					}
		        					
		        					
								});
		        			//}
		        		}
		        	}
		        }
		        
		        // ����Ϊֹ������������
		        // ���濪ʼ�������
		        statementID = 0;
		        System.out.println("TTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT1");
		        System.out.println(compilationUnit);
		       // if(mainMethodDeclaration != null){
		        compilationUnit.accept(new ASTVisitor() {
		        		
		        		//�ȴ���main����
		        		public boolean visit(MethodDeclaration node){
		        			Block block = node.getBody();
		        			if(block != null){
		        				block.statements().add(0, createInsertStatement(compilationUnit.getAST()));
		        			}
		        			return true;
		        		}
		        		
		        		public boolean visit(ForStatement node){
		        			Block block = (Block) node.getBody();
		        			if(block != null){
		        				block.statements().add(0, createInsertStatement(compilationUnit.getAST()));
		        			}
		        			return true;
		        			
		        		}
		        		
		        		public boolean visit(IfStatement node){
		        			if(node.getThenStatement() != null){
		        				Block block = (Block) node.getThenStatement();
		        				if(block != null){
		            				block.statements().add(0, createInsertStatement(compilationUnit.getAST()));
		            			}
		        			}
		        			if(node.getElseStatement() != null){
		        				Block block = (Block) node.getElseStatement();
		        				if(block != null){
		            				block.statements().add(0, createInsertStatement(compilationUnit.getAST()));
		            			}
		        			}
		        			return true;
		        		}
		        		
		        		public boolean visit(WhileStatement node){
		        			Block block = (Block) node.getBody();
		        			if(block != null){
		        				block.statements().add(0, createInsertStatement(compilationUnit.getAST()));
		        			}
		        			return true;
		        		}
		        		
					});
		       // }
		        System.out.println("TTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT2");
		        System.out.println(compilationUnit);

		        FileUtils.write(new File(path + "//originalInsertFile//"+ originalFile.getName()), compilationUnit.toString());
		        System.out.println("����������------" + originalFile.getName());
		        //  end--------------------------------------------------

	}
	
	
	static void getrandProblem() throws FileNotFoundException{
		FileInputStream fis = null;
		  InputStreamReader isr = null;
		  BufferedReader br = null;
		  List<String> problems = new ArrayList<>(); 

			   String str = "";
			   String str1 = "";
			   fis = new FileInputStream("D:\\test\\problems.txt");// FileInputStream
			   // ���ļ�ϵͳ�е�ĳ���ļ��л�ȡ�ֽ�
			    isr = new InputStreamReader(fis);// InputStreamReader ���ֽ���ͨ���ַ���������,
			    br = new BufferedReader(isr);// ���ַ��������ж�ȡ�ļ��е�����,��װ��һ��new InputStreamReader�Ķ���
			   try {
				while ((str = br.readLine()) != null) {
//				   if(index == 7)
//				   System.out.println(str);
				    str = str.trim();
				    if(!str.equals("") && !problems.contains(str)){
				    	problems.add(str);
				    }
				   }
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			   
		int len = problems.size();
//		for(String strr:  problems){
//			System.out.println(strr);
//		}
//		System.out.println(len);
		
		List<String> finalProblemList  = new ArrayList<>();
		
		for(int i = 0; i < 2000; i++){
			Random random = new Random();
			int index = random.nextInt();
			if(!finalProblemList.contains(problems.get(index))){
				System.out.println(problems.get(index));
				finalProblemList.add(problems.get(index));
				
				FileWriter fw;
				try {
					fw = new FileWriter("D:\\test\\problems.txt", true);
					BufferedWriter bw = new BufferedWriter(fw);

						bw.append(problems.get(index));
			           bw.append("\r\n");
			       
			            bw.close();
			            fw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}   
			}
		}
		System.out.println(finalProblemList.size());
		
	}
	
	static void getRandom() throws IOException{
		File file = new File("D:\\test\\javaSelected6");
		File[] problems = file.listFiles();
		int len = problems.length;
		List<String> titles = new ArrayList<>();
		for(File f: problems){
			titles.add(f.getName());
		}
		
		for(String  s: titles)
			System.out.println(s);
		
		System.out.println(titles.size());
	}
	
	
	public static void getTotalTestCase(String path){
		File[] allFiles = new File(path).listFiles();
		List<String> allTestCases = new ArrayList<>(); 
		for(File file : allFiles){
			if(!file.getName().endsWith("edit"))
				continue;
			File[] innerFiles = file.listFiles();
			for(File inner: innerFiles){
				if(!inner.getName().equals("testCase"))
					continue;
				File[] cases = inner.listFiles();
				for(File c: cases){
					String str = "";
					String content = "";
					// read
					FileInputStream fis = null;
					  InputStreamReader isr = null;
					  BufferedReader br = null;
					
						   try {
							   System.out.println(c.getAbsolutePath());
							fis = new FileInputStream(c.getAbsolutePath());
							 isr = new InputStreamReader(fis);// InputStreamReader ���ֽ���ͨ���ַ���������,
							    br = new BufferedReader(isr);// ���ַ��������ж�ȡ�ļ��е�����,��װ��һ��new InputStreamReader�Ķ���
							   while ((str = br.readLine()) != null) {
								   content += str;
							   }
							   System.out.println(content);
						} catch (FileNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}// FileInputStream
						   // ���ļ�ϵͳ�е�ĳ���ļ��л�ȡ�ֽ�
						   catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						  finally {
							   try {
							     br.close();
							     isr.close();
							     fis.close();
							    // �رյ�ʱ����ð����Ⱥ�˳��ر���󿪵��ȹر������ȹ�s,�ٹ�n,����m
							   } catch (IOException e) {
							    e.printStackTrace();
							   }
						  }
						   
			
					if(!allTestCases.contains(content)){
						allTestCases.add(content);
					}
				}
			}
		}
		
		//д
		int cnt = -1;
		for(String c: allTestCases){
			cnt++;
		 FileWriter fw;
			try {
				fw = new FileWriter(path + "\\totalTestCase\\"+cnt+".txt", true);
				BufferedWriter bw = new BufferedWriter(fw);
				bw.append(c);
		            bw.close();
		            fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}   
		}
		
	}
	
	public static void analyzeContentOfFiles2(String path){
		String resultPath = path + "\\result2";
		//�ڼ��������������Լ���Ӧ������ļ�
		Map<Integer, List<File> > mapOfIndexAndFiles = new HashMap<Integer, List<File> >();
		Set<Integer> indexs = new HashSet<>();
		
		File resultDir = new File(resultPath);
		File[] resultFiles = resultDir.listFiles();
		
		for(File file: resultFiles){ // ÿ������ļ�
			String name = file.getName();
			//System.out.println("name  "+name +"   "+name.indexOf("_"));
			int index = Integer.parseInt(name.substring(0, name.indexOf("_")));
			//System.out.println("index s "+index);
			if(mapOfIndexAndFiles.get(index) == null){
				List<File> files = new ArrayList<File>();
				files.add(file);
				mapOfIndexAndFiles.put(index, files);
			}
			else{
				List<File> files = mapOfIndexAndFiles.get(index); 
				files.add(file);
				mapOfIndexAndFiles.put(index, files);
			}
			indexs.add(index);
		}
		Map<String, Integer> mapOfContentAndTimes = new HashMap<>();
		System.out.println(indexs.size());
		for(Integer index: indexs){// ����ÿһ����
			//System.out.println("index  "+index);
			mapOfContentAndTimes.clear();
			for(File file: mapOfIndexAndFiles.get(index)){
//				if(index == 7){
//					System.out.println("file --- "+file.getName());
//				}
				FileInputStream fis = null;
				  InputStreamReader isr = null;
				  BufferedReader br = null;
				try {
					   String str = "";
					   String str1 = "";
					   fis = new FileInputStream(file.getAbsolutePath());// FileInputStream
					   // ���ļ�ϵͳ�е�ĳ���ļ��л�ȡ�ֽ�
					    isr = new InputStreamReader(fis);// InputStreamReader ���ֽ���ͨ���ַ���������,
					    br = new BufferedReader(isr);// ���ַ��������ж�ȡ�ļ��е�����,��װ��һ��new InputStreamReader�Ķ���
					   while ((str = br.readLine()) != null) {
//						   if(index == 15)
//						   System.out.println(str);
					    str1 += str.trim() + "\n";
					   }
					  
					   
					   
					   // ����ȡ��һ�в�Ϊ��ʱ,�Ѷ�����str��ֵ����str1
					  // System.out.println(str1);// ��ӡ��str1
//					   if(index == 7){
//						   System.out.println("file name  "+file.getAbsolutePath());
//						   System.out.println(str1+str1.length());
//					   }
					   if(mapOfContentAndTimes.get(str1) == null){
						   mapOfContentAndTimes.put(str1, 1);
					   }
					   else{
						   mapOfContentAndTimes.put(str1, mapOfContentAndTimes.get(str1) + 1);
					   }
					   
					  } catch (FileNotFoundException e) {
					   System.out.println("�Ҳ���ָ���ļ�");
					  } catch (IOException e) {
					   System.out.println("��ȡ�ļ�ʧ��");
					  } finally {
					   try {
					     br.close();
					     isr.close();
					     fis.close();
					    // �رյ�ʱ����ð����Ⱥ�˳��ر���󿪵��ȹر������ȹ�s,�ٹ�n,����m
					   } catch (IOException e) {
					    e.printStackTrace();
					   }
					  
				}
				
			}
		    //System.out.println(index +"  " +   mapOfContentAndTimes.size());
	        if(mapOfContentAndTimes.size() > 1){
	        	System.out.println("ERRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRR   " +index);
	        	for(String str: mapOfContentAndTimes.keySet()){
	        		System.out.println(str+"  "+mapOfContentAndTimes.get(str));
	        	}
	        	//return;
	        }
		}
		System.out.println("analyze --- complete   the output are all same");
			
	}
	
	
	// ����������������Ľ��  D:\test\tp\5D�� �ҳ������һ�µ�ĳ����������
	public static void analyzeContentOfFiles(String path){
		String resultPath = path + "\\result";
		//�ڼ��������������Լ���Ӧ������ļ�
		Map<Integer, List<File> > mapOfIndexAndFiles = new HashMap<Integer, List<File> >();
		Set<Integer> indexs = new HashSet<>();
		
		File resultDir = new File(resultPath);
		File[] resultFiles = resultDir.listFiles();
		
		for(File file: resultFiles){ // ÿ������ļ�
			String name = file.getName();
			//System.out.println("name  "+name +"   "+name.indexOf("_"));
			int index = Integer.parseInt(name.substring(0, name.indexOf("_")));
			if(mapOfIndexAndFiles.get(index) == null){
				List<File> files = new ArrayList<File>();
				files.add(file);
				mapOfIndexAndFiles.put(index, files);
			}
			else{
				List<File> files = mapOfIndexAndFiles.get(index); 
				files.add(file);
				mapOfIndexAndFiles.put(index, files);
			}
			indexs.add(index);
		}
		Map<String, Integer> mapOfContentAndTimes = new HashMap<>();
		
		for(Integer index: indexs){// ����ÿһ����
			mapOfContentAndTimes.clear();
			for(File file: mapOfIndexAndFiles.get(index)){
//				if(index == 7){
//					System.out.println("file --- "+file.getName());
//				}
				FileInputStream fis = null;
				  InputStreamReader isr = null;
				  BufferedReader br = null;
				try {
					   String str = "";
					   String str1 = "";
					   fis = new FileInputStream(file.getAbsolutePath());// FileInputStream
					   // ���ļ�ϵͳ�е�ĳ���ļ��л�ȡ�ֽ�
					    isr = new InputStreamReader(fis);// InputStreamReader ���ֽ���ͨ���ַ���������,
					    br = new BufferedReader(isr);// ���ַ��������ж�ȡ�ļ��е�����,��װ��һ��new InputStreamReader�Ķ���
					   while ((str = br.readLine()) != null) {
//						   if(index == 7)
//						   System.out.println(str);
					    str1 += str.trim() + "\n";
					   }
					  
					   
					   
					   // ����ȡ��һ�в�Ϊ��ʱ,�Ѷ�����str��ֵ����str1
					  // System.out.println(str1);// ��ӡ��str1
//					   if(index == 7){
//						   System.out.println("file name  "+file.getAbsolutePath());
//						   System.out.println(str1+str1.length());
//					   }
					   if(mapOfContentAndTimes.get(str1) == null){
						   mapOfContentAndTimes.put(str1, 1);
					   }
					   else{
						   mapOfContentAndTimes.put(str1, mapOfContentAndTimes.get(str1) + 1);
					   }
					   
					  } catch (FileNotFoundException e) {
					   System.out.println("�Ҳ���ָ���ļ�");
					  } catch (IOException e) {
					   System.out.println("��ȡ�ļ�ʧ��");
					  } finally {
					   try {
					     br.close();
					     isr.close();
					     fis.close();
					    // �رյ�ʱ����ð����Ⱥ�˳��ر���󿪵��ȹر������ȹ�s,�ٹ�n,����m
					   } catch (IOException e) {
					    e.printStackTrace();
					   }
					  
				}
				
			}
		    //System.out.println(index +"  " +   mapOfContentAndTimes.size());
	        if(mapOfContentAndTimes.size() > 1){
	        	System.out.println("ERRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRR   " +index);
	        	for(String str: mapOfContentAndTimes.keySet()){
	        		System.out.println(str+"  "+mapOfContentAndTimes.get(str));
	        	}
	        	//return;
	        }
		}
		System.out.println("analyze --- complete   the output are all same");
			
	}
	
	public static void analyzeContentOfFilesForSingleAnswer(String path){
		String resultPath = path + "\\result";
		//�ڼ��������������Լ���Ӧ������ļ�
		Map<Integer, List<File> > mapOfIndexAndFiles = new HashMap<Integer, List<File> >();
		Set<Integer> indexs = new HashSet<>();
		
		File resultDir = new File(resultPath);
		File[] resultFiles = resultDir.listFiles();
		
		for(File file: resultFiles){ // ÿ������ļ�
			String name = file.getName();
			//System.out.println("name  "+name +"   "+name.indexOf("_"));
			int index = Integer.parseInt(name.substring(0, name.indexOf("_")));
			if(mapOfIndexAndFiles.get(index) == null){
				List<File> files = new ArrayList<File>();
				files.add(file);
				mapOfIndexAndFiles.put(index, files);
			}
			else{
				List<File> files = mapOfIndexAndFiles.get(index); 
				files.add(file);
				mapOfIndexAndFiles.put(index, files);
			}
			indexs.add(index);
		}
		Map<String, Integer> mapOfContentAndTimes = new HashMap<>();
		
		for(Integer index: indexs){// ����ÿһ����
			mapOfContentAndTimes.clear();
			for(File file: mapOfIndexAndFiles.get(index)){
//				if(index == 7){
//					System.out.println("file --- "+file.getName());
//				}
				FileInputStream fis = null;
				  InputStreamReader isr = null;
				  BufferedReader br = null;
				try {
					   String str = "";
					   String str1 = "";
					   fis = new FileInputStream(file.getAbsolutePath());// FileInputStream
					   // ���ļ�ϵͳ�е�ĳ���ļ��л�ȡ�ֽ�
					    isr = new InputStreamReader(fis);// InputStreamReader ���ֽ���ͨ���ַ���������,
					    br = new BufferedReader(isr);// ���ַ��������ж�ȡ�ļ��е�����,��װ��һ��new InputStreamReader�Ķ���
					   while ((str = br.readLine()) != null) {
//						   if(index == 7)
//						   System.out.println(str);
					    str1 += str.trim() + "\n";
					   }
					   
					   
					   // ����ȡ��һ�в�Ϊ��ʱ,�Ѷ�����str��ֵ����str1
					  // System.out.println(str1);// ��ӡ��str1
//					   if(index == 7){
//						   System.out.println("file name  "+file.getAbsolutePath());
//						   System.out.println(str1+str1.length());
//					   }
					   if(mapOfContentAndTimes.get(str1) == null){
						   mapOfContentAndTimes.put(str1, 1);
					   }
					   else{
						   mapOfContentAndTimes.put(str1, mapOfContentAndTimes.get(str1) + 1);
					   }
					   
					  } catch (FileNotFoundException e) {
					   System.out.println("�Ҳ���ָ���ļ�");
					  } catch (IOException e) {
					   System.out.println("��ȡ�ļ�ʧ��");
					  } finally {
					   try {
					     br.close();
					     isr.close();
					     fis.close();
					    // �رյ�ʱ����ð����Ⱥ�˳��ر���󿪵��ȹر������ȹ�s,�ٹ�n,����m
					   } catch (IOException e) {
					    e.printStackTrace();
					   }
					  
				}
				
			}
		    //System.out.println(index +"  " +   mapOfContentAndTimes.size());
	        if(mapOfContentAndTimes.size() > 1){
	        	System.out.println("ERRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRR   " +index);
	        	for(String str: mapOfContentAndTimes.keySet()){
	        		System.out.println(str+"  "+str.length());
	        	}
	        }
		}
		System.out.println("analyze --- complete   the output are all same");
			
	}

	
	// ��Ӧ��Ŀ�������̵ĵ������͵��Ĳ�
	public static void collectOriginalAndEditCode(String path){
		File problem = new File(path);
		File[] allFiles = problem.listFiles();
		for(File dir: allFiles){
			if(dir.getName().endsWith("edit")){
				FileUtil.dirFrom = dir;
				FileUtil.dirTo = new File(problem.getAbsolutePath() + "\\editCode");
				listFileInDir2(FileUtil.dirFrom);
			}
			else if(!dir.getName().equals("editCode") && !dir.getName().equals("originalCode")
					&& !dir.getName().equals("testCase") && !dir.getName().equals("parameters.json")
					&& !dir.getName().equals("result") && !dir.getName().endsWith("txt")
					&& !dir.getName().equals("WrongAnswer")){
				FileUtil.dirFrom = dir;
				FileUtil.dirTo = new File(problem.getAbsolutePath() + "\\originalCode");
				listFileInDir2(FileUtil.dirFrom);
			}
		}
	}
	
	
	//Ϊÿ����Ŀ������ͳ�����ı�Ҫ���ļ��У� paht�ĸ�ʽΪ  D:\test\tp\5D\9912327edit
	public static void createFoldersForTraditionalExperiment(String path){
		File file1 = new File(path + "\\result");
		File file2 = new File(path + "\\testCase");
		
		if(!file1.exists())
			file1.mkdir();
		if(!file2.exists())
			file2.mkdir();
	}
	
	
	//Ϊÿ����Ŀ�����ļ��� ������Ϊ�˱������ǸĽ���ʵ���D:\test\tp\5E,
	public static void createFoldersForOurExperiment (String path){
		
		File file1 = new File(path+"\\editCode");
		File file2 = new File(path+"\\originalCode");
		File file3 = new File(path+"\\testCase");
		File file4 = new File(path+"\\result");
		if(!file1.exists())
			file1.mkdir();
		if(!file2.exists())
			file2.mkdir();
		if(!file3.exists())
			file3.mkdir();
		if(!file4.exists())
			file4.mkdir();
		//D:\test\tp\5D\9912327edit ��������Ŀ¼�����ɱ�Ҫ���ļ��У�Ϊ�˴�ͳ������
		File[] files = new File(path).listFiles();
		for(File f: files){
			if(f.getName().endsWith("edit")){
				createFoldersForTraditionalExperiment(f.getAbsolutePath());
			}
		}
		System.out.println("complelte ");
	}
	
	public static void cooopy(String path){
		File outest = new File(path);// javatp
		File[] files = outest.listFiles();
		for(File answersDir : files){//javatp//1A
			File[] answerSingleDir = answersDir.listFiles();//javatp//1A//10010
			for(File answerFile: answerSingleDir){
				System.out.println(answerFile.getAbsolutePath());
				if(!answerFile.getName().endsWith("edit")){
					FileUtil.dirFrom = answerFile;
					FileUtil.dirTo = new File(answerFile.getAbsolutePath()+"edit");
					listFileInDir2(FileUtil.dirFrom);
				}
			}
		}
	}
	
	//�����ļ����������Դ�ļ��У� dirFromҲ��Դ�ļ���Ŀ¼�� dirTo��Ŀ���ļ��У���Դ�ļ��е������ļ�������Ŀ���ļ���
	public static void listFileInDir2(File file) {
		System.out.println("----file  "+file.getAbsolutePath());
        File[] files = file.listFiles();   
       for (File f : files) {
            String tempfrom = f.getAbsolutePath();   
            String tempto = tempfrom.replace(dirFrom.getAbsolutePath(),   
                    dirTo.getAbsolutePath()); // �����·�� �滻ǰ���·����   
           if (f.isDirectory()) {   
                File tempFile = new File(tempto);   
                tempFile.mkdirs();   
                listFileInDir2(f);   
            } else {   
                System.out.println("Դ�ļ�:" + f.getAbsolutePath());   
               //   
               int endindex = tempto.lastIndexOf("\\");// �ҵ�"/"���ڵ�λ��   
                String mkdirPath = tempto.substring(0, endindex);   
                File tempFile = new File(mkdirPath);   
                tempFile.mkdirs();// �������ļ���   
                System.out.println("Ŀ���:" + tempto);   
                copy(tempfrom, tempto);   
            }   
        }   
    }   
	//ԴĿ���ļ���
	public static void listFileInDir(File file, int cnt) {   
        File[] files = file.listFiles();   
       for (File f : files) {
    	    if(f.isDirectory() && cnt == 0  && !simpleNameOfSelectedFiles.contains(f.getName())){
    	    	continue;
    	    }
            String tempfrom = f.getAbsolutePath();   
            String tempto = tempfrom.replace(dirFrom.getAbsolutePath(),   
                    dirTo.getAbsolutePath()); // �����·�� �滻ǰ���·����   
           if (f.isDirectory()) {   
                File tempFile = new File(tempto);   
                tempFile.mkdirs();   
                listFileInDir(f, cnt + 1);   
            } else {   
                System.out.println("Դ�ļ�:" + f.getAbsolutePath());   
               //   
               int endindex = tempto.lastIndexOf("\\");// �ҵ�"/"���ڵ�λ��   
                String mkdirPath = tempto.substring(0, endindex);   
                File tempFile = new File(mkdirPath);   
                tempFile.mkdirs();// �������ļ���   
                System.out.println("Ŀ���:" + tempto);   
                copy(tempfrom, tempto);   
            }   
        }   
    }   
	
	public static  void copy(String from, String to) {   
        try {   
             InputStream in = new FileInputStream(from);   
             OutputStream out = new FileOutputStream(to);   
   
            byte[] buff = new byte[1024];   
            int len = 0;   
            while ((len = in.read(buff)) != -1) {   
                 out.write(buff, 0, len);   
             }   
             in.close();   
             out.close();   
         } catch (FileNotFoundException e) {   
             e.printStackTrace();   
         } catch (IOException e) {   
             e.printStackTrace();   
         }   
     }   
	
	
	
	
	public static void readFileDir(String path){
		LinkedList<File> dirList = new LinkedList<>();
		LinkedList<String> fileList = new LinkedList<>();
		File dir = new File(path); //ָ��·��
		File[] files = dir.listFiles(); //�����ļ�
		int problemsCnt = 0;
		int javaFileCnt = 0;
		for(File file: files){//ÿ����Ŀ
			//��Ƴ��������ÿ��file����diretory, 
			problemsCnt++;
			System.out.println(file.getAbsolutePath());
			File[] singleAnswerDirs = file.listFiles(); //ÿ�����java�ļ�����һ���̶����ļ���,ÿ���ļ�������һ��java�ļ�
			for(File singleAnswerDir : singleAnswerDirs){
				
				File[] finalFiles = singleAnswerDir.listFiles(); // ���ڲ��ÿ���ļ�

				for(File finalFile: finalFiles){
					javaFileCnt++;
					System.out.println(finalFile.getAbsolutePath()+"    "+finalFile.getName());
				}
				
			}
		}
		
		//ͳ��������Ϣ
		System.out.println("��Ŀ�ܸ��� :   "+ problemsCnt);
		System.out.println("�ļ��ܸ���:   "+javaFileCnt);
	}
}
