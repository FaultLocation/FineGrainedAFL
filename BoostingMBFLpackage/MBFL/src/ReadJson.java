import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Map;

import org.apache.commons.io.FileUtils;

import java.io.BufferedReader;

import java.io.FileOutputStream;

import java.io.PrintWriter;


public class ReadJson {
	public static int total =0;
    public static void main(String[] args) {
        Gson gson = new Gson();
        String json = "";
        try {

            json = readFile("D:\\llpjason\\release.json").toString();
            Map<String, LinkedTreeMap<String, LinkedTreeMap<String, Double>>> map = gson.fromJson(json, Map.class);

            for (Map.Entry<String, LinkedTreeMap<String, LinkedTreeMap<String, Double>>> projectEntry : map.entrySet()) {
                String projectName = projectEntry.getKey();
                System.out.println(projectName);
                String id = projectName.replace("closure", "").replace("time", "").replace("math", "").replace("lang","").replace("chart", "").trim();
                String Pro = projectName.replace(id, "");
                //"closure127"
                LinkedTreeMap<String, LinkedTreeMap<String, Double>> projectValue = projectEntry.getValue();
                
                String data="";
                for (Map.Entry<String, LinkedTreeMap<String, Double>> singleEntry : projectValue.entrySet()) {                	
                	
                    String singleName = singleEntry.getKey();
             //       System.out.println(singleName);
                    data+=singleName.replace(".", "/").replace(":", ".java#");
                    //"com.google.javascript.rhino.Node:393"
                    LinkedTreeMap<String, Double> value = singleEntry.getValue();
                    Double metallaxis = value.get("metallaxis");if(metallaxis==null) {metallaxis=0.0;}
                    Double muse = value.get("muse");if(muse==null) {muse=0.0;}
                    Double ochiai = value.get("ochiai");if(ochiai==null) {ochiai=0.0;}
                  
                    
                    Double dstar = value.get("dstar");if(dstar==null) {dstar=0.0;}
                    Double sclicing = value.get("sclicing");if(sclicing==null) {sclicing=0.0;}
                    Double sclicing_intersection = value.get("sclicing_intersection");if(sclicing_intersection==null) {sclicing_intersection=0.0;}
                    		
                    Double sclicing_count = value.get("sclicing_count");if(sclicing_count==null) {sclicing_count=0.0;}
                    Double stacktrace = value.get("stacktrace");if(stacktrace==null) {stacktrace=0.0;}
                    Double predicateswitching = value.get("predicateswitching");if(predicateswitching==null) {predicateswitching=0.0;}
                    
                    Double faulty = value.get("faulty");
                    		
//                    if(faulty>0)
//                    {
//                    	System.out.println(Pro+"  "+id+"  "+singleName+"  "+faulty);
//                    }
                    
                    //System.out.println(value.get("metallaxis"));
                  //  data+="#"+metallaxis+"#"+muse+"#"+ochiai+"#"+faulty;
                    
                    
                    //if(sclicing>0||sclicing_intersection>0||stacktrace>0||predicateswitching>0)
                    if(predicateswitching>0)
                    {
                    	System.out.println("20220124   "+singleName+"   "+predicateswitching);
                    }
                    
//                    data+="#"+metallaxis+"#"+muse+"#"+ochiai+"#"+
//                    		dstar+"#"+sclicing+"#"+sclicing_intersection+"#"+
//                    		sclicing_count+"#"+stacktrace+"#"+predicateswitching+"#"
//                    		+faulty;
             //       data+="\r\n";
                }
             //   data=data.trim();
             //   creatWriteTxtFile("D:\\llpjason\\txtfileall\\"+Pro,id,data);
                
            }

            System.out.println("mapsize"+map.size());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static StringBuffer readFile(String fileName) {
        File file = new File(fileName);
        Reader reader = null;
        try {
            reader = new InputStreamReader(new FileInputStream(file), "utf-8");
            int ch = 0;
            StringBuffer buffer = new StringBuffer();
            while ((ch = reader.read()) != -1) {
                buffer.append((char) ch);
            }
            reader.close();
            return buffer;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new StringBuffer("");
    }
    
   
    
    
    public static boolean creatWriteTxtFile(String path,String name,String data) throws IOException {
    	 boolean flag = false;
    	path +=  "\\"+name+".txt";
    	 File filename = new File(path);
    	 if (!filename.exists()) {
    	 // filename.createNewFile();
    	  flag = true;
    	  
    	  FileUtils.write(new File(path), data);
    	  
    	 }
    	 return flag;
    	 }

}
