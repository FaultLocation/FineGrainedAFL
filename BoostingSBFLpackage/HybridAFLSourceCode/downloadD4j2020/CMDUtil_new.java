package downloadD4j2020;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;

public class CMDUtil_new {

	// ִ�������У�����Ϊ�������ַ���
	public static String runCMDWithoutPass(String cmd) {
		String result = "";
		try {
			// process = rt.exec("cmd.exe /c javac d:\\test\\tp\\a.java && javac
			// d:\\test\\tp\\tpp\\b.java");
			Process process = Runtime.getRuntime().exec(cmd);

			boolean exitStatus = false;
			try {
				exitStatus = process.waitFor(2, TimeUnit.SECONDS);
//						exitStatus = process.waitFor();

				if (!exitStatus) {
					System.out.println("cmd execute failed!");
				} else {
					BufferedReader br = new BufferedReader(
							new InputStreamReader(process.getInputStream(), Charset.forName("GBK")));
					String line = null;
					while ((line = br.readLine()) != null) {
						result += line + "\n";
					}

					br.close();
					process.waitFor();
					return result;
				}

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			process.destroy(); // �����ӽ���
			process = null;
			String command = "taskkill /f /im java.exe";
			Process process2 = Runtime.getRuntime().exec(command);
			try {
				process2.waitFor();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public static Boolean runAllForExperimentWithoutPass(String problemPath, String sourcePath) {
		String originalCodePath = sourcePath;
		String outPutPath = sourcePath + "\\Output";

		File originalCodeFile = new File(originalCodePath);
		File[] originalFiles = originalCodeFile.listFiles();

		System.out.println("* running testcase --- ");
		// ��ÿһ��ԭʼ��java�ļ�,��ʵ��1��
		for (File file : originalFiles) {
			if (file.getAbsolutePath().endsWith("java")) {
				String fileName = file.getName();
				fileName = fileName.substring(0, fileName.lastIndexOf("."));
				
				for (int i = 0; i < Common.inputList.size(); i++) {// ÿһ�������ļ�

					String str = Common.inputList.get(i);

					String cmd = "cmd.exe /c d: && cd " + originalCodePath + " && echo " + str + "| java " + fileName;

					// System.out.println(cmd);
					String resultString = runCMDWithoutPass(cmd).trim();
					
					
					
					if (!resultString.equals(Common.outputList.get(i))) {
						System.out.println("* can not pass " + i + "th  test case");
						return false;
					}

				}

			}
		}
		System.out.println("* running complete --- ");
		return true;
	}

	// ִ�������У�����Ϊ�������ַ���
	public static void runCMD(String cmd) {
//		Runtime rt = Runtime.getRuntime();
//		Process process;
//		try {
//			//process = rt.exec("cmd.exe /c javac d:\\test\\tp\\a.java && javac d:\\test\\tp\\tpp\\b.java");
//			process = rt.exec(cmd);
//			System.out.println(process.toString());
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		Runtime rt = Runtime.getRuntime();
		Process process;
		try {
			// process = rt.exec("cmd.exe /c javac d:\\test\\tp\\a.java && javac
			// d:\\test\\tp\\tpp\\b.java");
			process = rt.exec(cmd);
			System.out.println(process.toString());

			boolean exitStatus = false;
			try {
				exitStatus = process.waitFor(2, TimeUnit.SECONDS);
//				exitStatus = process.waitFor();
				if (!exitStatus) {
					System.out.println("cmd execute failed!");
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			process.destroy(); // �����ӽ���
			process = null;
			String command = "taskkill /f /im java.exe";
			Process process2 = Runtime.getRuntime().exec(command);
			try {
				process2.waitFor();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// �������е��ļ��� ����ΪԴ�ļ����ڵ��ļ��У� ���� D:\LLP\915A\originalFile
	public static boolean complileAll(String path, File currentFile) {
		// �ȶ������originalCode���б���
		File originalCodeFile = new File(path);
		File[] originalFiles = originalCodeFile.listFiles();

		List<String> originalCodePaths = new ArrayList<String>();
		for (File file : originalFiles) {
			if (file.getName().equals(currentFile.getName()))
				originalCodePaths.add(file.getAbsolutePath());
		}

		String cmd = "cmd.exe /c javac " + originalCodePaths.get(0);
		for (int i = 1; i < originalCodePaths.size(); i++) {
			cmd = cmd + " && javac " + originalCodePaths.get(i);
		}
		System.out.println("* compling -----");
		runCMD(cmd);

//		try {
//			Thread.sleep(4000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		// System.out.println("compling all source code-----complete");

		originalFiles = originalCodeFile.listFiles();
		for (File file : originalFiles) {
			String name1 = file.getName().substring(0, file.getName().indexOf('.'));
			String name2 = currentFile.getName().substring(0, currentFile.getName().indexOf('.'));
			if (file.getName().endsWith(".class") && name1.equals(name2)) {

				System.out.println("* compling succeed!");
				return true;
			}
		}

		System.out.println("* compling failed!");
		for (File file2 : originalCodeFile.listFiles()) {
			file2.delete();
		}
		originalCodeFile.delete();
		return false;
	}

	// �������еĲ��������� ����Ϊ��Ŀ��ַ�� ���� // D:\LLP\915A
	public static void runAllForExperiment(String problemPath, String sourcePath) {
		String originalCodePath = sourcePath;
		String testCasePath = problemPath + "\\Input";
		String outPutPath = sourcePath + "\\Output";

		File originalCodeFile = new File(originalCodePath);
		File[] originalFiles = originalCodeFile.listFiles();

		File testCaseFile = new File(testCasePath);
		File[] testCaseFiles = testCaseFile.listFiles();
		System.out.println("* running testcase --- ");
		// ��ÿһ��ԭʼ��java�ļ�,��ʵ��1��
		for (File file : originalFiles) {
			if (file.getAbsolutePath().endsWith("java")) {
				String fileName = file.getName();
				fileName = fileName.substring(0, fileName.lastIndexOf("."));
				for (File testCase : testCaseFiles) {// ÿһ�������ļ�
					String testCaseName = testCase.getName();
					testCaseName = testCaseName.substring(0, testCaseName.lastIndexOf("."));
					String cmd = "cmd.exe /c d: && cd " + originalCodePath + " && java " + fileName + " < "
							+ testCase.getAbsolutePath() + " > " + outPutPath + "\\" + testCaseName + ".txt";
					// System.out.println(cmd);
					runCMD(cmd);

				}
			}
		}
//		try {
//			Thread.sleep(4000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		System.out.println("* running complete --- ");
	}

	// �ж��Ƿ���ͨ�����еĲ��������� ����Ϊ��Ŀ���ļ���·�������� D:\LLP\915A
	public static boolean passAllTestCase(String path, String OutputDir) throws IOException {
		String outputDirPath = path + "//Output//";
		String newOutputDirPath = OutputDir + "//";
		File outputDir = new File(outputDirPath);
		File newOutputDir = new File(newOutputDirPath);
		File[] outputsFiles = outputDir.listFiles();
		File[] newOutputsFiles = newOutputDir.listFiles();

		int num = outputsFiles.length;
		for (int i = 1; i <= num; i++) {
			File oneFile = new File(outputDirPath + i + ".txt");
			// String file1Content = FileUtils.readFileToString(oneFile).trim();
			// String file1Content = readFileExcludeSomething(oneFile);
			// System.out.println("one "+file1Content);

			File twoFile = new File(newOutputDirPath + i + ".txt");
//			String file2Content = FileUtils.readFileToString(twoFile).trim();
			// String file2Content = readFileExcludeSomething(twoFile);
			// System.out.println("two "+ file2Content);
//			if(!file1Content.equals(file2Content)){
//				System.out.println("* can not pass "+ i+"th  test case");
//				return false;
//			}
			if (!twoFilesAreSame(oneFile, twoFile)) {
				System.out.println("* can not pass " + i + "th  test case");
				return false;
			}

		}
		return true;
	}

	public static boolean twoFilesAreSame(File oneFile, File twoFile) {
		FileInputStream fis1 = null;
		FileInputStream fis2 = null;
		InputStreamReader isr1 = null;
		InputStreamReader isr2 = null;
		BufferedReader br1 = null;
		BufferedReader br2 = null;

		try {
			String str1 = "-1";
			String str2 = "-1";
			fis1 = new FileInputStream(oneFile.getAbsolutePath());// FileInputStream
			fis2 = new FileInputStream(twoFile.getAbsolutePath());// FileInputStream
			// ���ļ�ϵͳ�е�ĳ���ļ��л�ȡ�ֽ�
			isr1 = new InputStreamReader(fis1);// InputStreamReader ���ֽ���ͨ���ַ���������,
			isr2 = new InputStreamReader(fis2);// InputStreamReader ���ֽ���ͨ���ַ���������,
			br1 = new BufferedReader(isr1);// ���ַ��������ж�ȡ�ļ��е�����,��װ��һ��new InputStreamReader�Ķ���
			br2 = new BufferedReader(isr2);// ���ַ��������ж�ȡ�ļ��е�����,��װ��һ��new InputStreamReader�Ķ���
			// System.out.println((br1.readLine() != null) + " "+(br2.readLine() != null));
			
			String str2TotalString = "";
			while((str2 = br2.readLine())!=null) {
				str2TotalString += str2;
			}
			
			String str1TotalString = "";
			while((str1 = br1.readLine())!=null) {
				str1TotalString += str1;
			}
			
			if(str1TotalString.equals(str2TotalString)) {
				return true;
			} else {
				return false;
			}

		} catch (FileNotFoundException e) {
			System.out.println("�Ҳ���ָ���ļ�");
		} catch (IOException e) {
			System.out.println("��ȡ�ļ�ʧ��");
		} finally {
			try {
				br1.close();
				isr1.close();
				fis1.close();
				// �رյ�ʱ����ð����Ⱥ�˳��ر���󿪵��ȹر������ȹ�s,�ٹ�n,����m
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return true;
	}

	public static String readFileExcludeSomething(File oneFile) {
		FileInputStream fis = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		String str1 = "";
		try {
			String str = "";
			fis = new FileInputStream(oneFile.getAbsolutePath());// FileInputStream
			// ���ļ�ϵͳ�е�ĳ���ļ��л�ȡ�ֽ�
			isr = new InputStreamReader(fis);// InputStreamReader ���ֽ���ͨ���ַ���������,
			br = new BufferedReader(isr);// ���ַ��������ж�ȡ�ļ��е�����,��װ��һ��new InputStreamReader�Ķ���
			while ((str = br.readLine()) != null) {
				str = str.trim();
				if (str.startsWith("bitse207")) {
					continue;
				}

				str1 += str + "\n";
//			    System.out.println(str);
//			    for(int i = 0; i < str.length(); i++){
//			    	System.out.println(i+" "+str.charAt(i)+" "+Integer.valueOf(str.charAt(i)));
//			    }
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
		return str1;
	}

	// �ڼ������������Ƿ�ͨ��
	public static boolean passOneTestCase(File oneFile, File anotherFile, Integer index) {
		FileInputStream fis = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		String str1 = "";
		String str2 = "";
		try {
			String str = "";
			fis = new FileInputStream(oneFile.getAbsolutePath());// FileInputStream
			// ���ļ�ϵͳ�е�ĳ���ļ��л�ȡ�ֽ�
			isr = new InputStreamReader(fis);// InputStreamReader ���ֽ���ͨ���ַ���������,
			br = new BufferedReader(isr);// ���ַ��������ж�ȡ�ļ��е�����,��װ��һ��new InputStreamReader�Ķ���
			while ((str = br.readLine()) != null) {
				str = str.trim();
				if (str.startsWith("bitse207")) {
					int indexInserStatement = Integer.valueOf(str.split(" ")[1].trim());
					DataNode insertStatement = Experiment.mapOfIndexAndInsertStatements.get(indexInserStatement);
					if (Experiment.mapOfTestCaseAndInsertStatements.get(indexInserStatement) == null) {
						List<DataNode> statements = new ArrayList<>();
						statements.add(insertStatement);
					} else {
						if (!Experiment.mapOfTestCaseAndInsertStatements.get(indexInserStatement)
								.contains(insertStatement)) {
							Experiment.mapOfTestCaseAndInsertStatements.get(indexInserStatement).add(insertStatement);
						}
					}
					continue;
				}

				str1 += str + "\n";
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

		try {
			String str = "";
			fis = new FileInputStream(anotherFile.getAbsolutePath());// FileInputStream
			// ���ļ�ϵͳ�е�ĳ���ļ��л�ȡ�ֽ�
			isr = new InputStreamReader(fis);// InputStreamReader ���ֽ���ͨ���ַ���������,
			br = new BufferedReader(isr);// ���ַ��������ж�ȡ�ļ��е�����,��װ��һ��new InputStreamReader�Ķ���
			while ((str = br.readLine()) != null) {
				str = str.trim();
				if (str.startsWith("bitse207")) {
					int indexInserStatement = Integer.valueOf(str.split(" ")[1].trim());
//					   for(String ss: str.split(" ")){
//						   System.out.println(ss+ " "+ss.length());
//					   }
					DataNode insertStatement = Experiment.mapOfIndexAndInsertStatements.get(indexInserStatement);
					if (Experiment.mapOfTestCaseAndInsertStatements.get(index) == null) {
						List<DataNode> statements = new ArrayList<>();
						statements.add(insertStatement);
						Experiment.mapOfTestCaseAndInsertStatements.put(index, statements);
					} else {
						if (!Experiment.mapOfTestCaseAndInsertStatements.get(index).contains(insertStatement)) {
							Experiment.mapOfTestCaseAndInsertStatements.get(index).add(insertStatement);
						}
					}
					continue;
				}

				str2 += str + "\n";
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
//		  System.out.println("��ȷ�Ĵ���   \n"+str1);
//		  System.out.println("��ǰ���еĴ���  \n"+ str2);
		System.out.println("���������漰���Ĳ��������  \n");

		for (DataNode node : Experiment.mapOfTestCaseAndInsertStatements.get(index)) {
			System.out.println(node == null);
			System.out.println(node.node.toString());
		}
		if (str1.equals(str2)) {
			return true;
		}

		return false;

	}

	public static String readMy(File oneFile) {
		FileInputStream fis = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		String str1 = "";
		try {
			String str = "";
			fis = new FileInputStream(oneFile.getAbsolutePath());// FileInputStream
			// ���ļ�ϵͳ�е�ĳ���ļ��л�ȡ�ֽ�
			isr = new InputStreamReader(fis);// InputStreamReader ���ֽ���ͨ���ַ���������,
			br = new BufferedReader(isr);// ���ַ��������ж�ȡ�ļ��е�����,��װ��һ��new InputStreamReader�Ķ���
			while ((str = br.readLine()) != null) {
				if (str.startsWith("Main.main")) {
					str = str.substring(10);
					String newString = "";
					for (int i = 0; i < str.length(); i++) {
						if (str.charAt(i) == ')') {
							break;
						}
						newString = newString + str.charAt(i);
					}
					String s1 = newString.split(",")[0].trim();
					String s2 = newString.split(",")[1].trim();
					if (s1.equals(s2)) {
						System.out.println(newString);
						break;
					}
				}
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
		System.out.println("done !!!!!!");
		return str1;
	}

	public static void main(String[] args) {
		File file1 = new File("D:\\LLP\\266A\\newFiles\\CF266A4.java\\1\\Output\\1.txt");
		File file2 = new File("D:\\LLP\\266A\\newFiles\\CF266A4.java\\1\\Output\\2.txt");
		System.out.println(twoFilesAreSame(file1, file2));
	}

}
