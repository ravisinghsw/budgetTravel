package com.ravi.travel.budget_travel.poc;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class DataPreparation {

    private static Gson GSON = new Gson();


    public static void main(String[] args) throws IOException {

        String dirPath= "D:\\project\\test_files";

        File fileDir = new File(dirPath);

        Map<String,String> headerMap = null;

        boolean startOfheader = false;
        boolean startOfData = false;

        for(File file : fileDir.listFiles()){
           /* if(file.getName().contains("test1.txt") || file.getName().contains("test2.txt")){
                continue;
            }*/
            headerMap = new LinkedHashMap<>();
            BufferedReader br=new BufferedReader(new FileReader(file));

            String line = br.readLine();
            while(Objects.nonNull(line = br.readLine())){
                //System.out.println(line);
                if(line==null || line.length()==0 || line.startsWith("#")){
                    continue;
                }
                if("START-OF-FIELDS".equalsIgnoreCase(line) || "END-OF-FIELDS".equalsIgnoreCase(line) ){
                    startOfheader = !startOfheader;
                    continue;

                }
                if("START-OF-DATA".equalsIgnoreCase(line) || "END-OF-DATA".equalsIgnoreCase(line) ){
                    startOfData = !startOfData;
                    continue;
                }

                if(startOfheader){
                    headerMap.put(line.trim(),null);
                }
                if(startOfData){
                    //System.out.println(headerMap);
                    String[] data= line.split("\\|");
                    //System.out.println(Arrays.toString(data));
                    Map<String,String> dataMap = new LinkedHashMap<>(headerMap);
                    int i = 0;
                    for(String dataKey : dataMap.keySet()){
                        dataMap.put(dataKey,data[i]);
                        i++;
                    }

                    System.out.println(file.getName()+"----------->"+GSON.toJson(dataMap));
                }
            }
            br.close();
        }

        System.out.println("hello world !");
    }


}
