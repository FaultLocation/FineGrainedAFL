package downloadD4j2020;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Common {

	public static List<String> outputList = new ArrayList<String>();
	public static List<String> inputList = new ArrayList<String>();

	public static void initOutputList(String pathName) {
		String outputDirPath = pathName + "//Output//";
		File outputDir = new File(outputDirPath);
		File[] outputsFiles = outputDir.listFiles();

		int num = outputsFiles.length;
		for (int i = 1; i <= num; i++) {
			File oneFile = new File(outputDirPath + i + ".txt");

			FileInputStream fis1 = null;
			InputStreamReader isr1 = null;
			BufferedReader br1 = null;

			String str1 = "-1";
			try {
				fis1 = new FileInputStream(oneFile);
				// ���ļ�ϵͳ�е�ĳ���ļ��л�ȡ�ֽ�
				isr1 = new InputStreamReader(fis1);// InputStreamReader ���ֽ���ͨ���ַ���������,
				br1 = new BufferedReader(isr1);// ���ַ��������ж�ȡ�ļ��е�����,��װ��һ��new InputStreamReader�Ķ���
				// System.out.println((br1.readLine() != null) + " "+(br2.readLine() != null));
				String contentFile1 = "";
				while ((str1 = br1.readLine()) != null) {
					// if(!str1.equals("")){
					contentFile1 += str1;
					// }
				}
				outputList.add(contentFile1);
			} catch (Exception e) {
				e.printStackTrace();
			} // FileInputStream
		}
	}

	public static void initInputList(String pathName) {
		String outputDirPath = pathName + "//Input//";
		File outputDir = new File(outputDirPath);
		File[] outputsFiles = outputDir.listFiles();

		int num = outputsFiles.length;
		for (int i = 1; i <= num; i++) {
			File oneFile = new File(outputDirPath + i + ".txt");

			FileInputStream fis1 = null;
			InputStreamReader isr1 = null;
			BufferedReader br1 = null;

			String str1 = "-1";
			try {
				fis1 = new FileInputStream(oneFile);
				// ���ļ�ϵͳ�е�ĳ���ļ��л�ȡ�ֽ�
				isr1 = new InputStreamReader(fis1);// InputStreamReader ���ֽ���ͨ���ַ���������,
				br1 = new BufferedReader(isr1);// ���ַ��������ж�ȡ�ļ��е�����,��װ��һ��new InputStreamReader�Ķ���
				// System.out.println((br1.readLine() != null) + " "+(br2.readLine() != null));
				String contentFile1 = "";
				while ((str1 = br1.readLine()) != null) {
					// if(!str1.equals("")){
					contentFile1 += str1;
					// }
				}
				inputList.add(contentFile1);
			} catch (Exception e) {
				e.printStackTrace();
			} // FileInputStream
		}
	}
	
	
	public static void main(String[] args) {
		initOutputList("E://workfile//4A");

		for (int i = 0; i < outputList.size(); i++) {
			System.out.println(outputList.get(i));
		}

	}

}
