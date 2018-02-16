package project1;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.zip.GZIPInputStream;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Giulia
 */
public class Phase1 {
   
//    public Phase1(){}
    
    public static void read_file(String path){
        try{
            FileInputStream fstream = new FileInputStream(path);
            GZIPInputStream gzStream = new GZIPInputStream(fstream);
            InputStreamReader isr = new InputStreamReader(gzStream);
            BufferedReader br = new BufferedReader(isr );
            String line;
    //Read File Line By Line
            int c = 0;
            while ((line = br.readLine()) != null) {
     // Print the content on the console
                System.out.println(line);
                if(c == 10){
                    break;
                }
                c++;
            }
     //Close the input stream
            br.close();
        }catch(Exception e){
            System.out.println("Error: Impossible to find the file");
        }
    }
    
    
    public static void main(String[] args) {
        
        String path = "C:/Users/Giulia/Uni/SBN/DATA/Official_SBN-ITA-2016-Net.gz";
        read_file(path);
        
        File folder = new File("C:/Users/Giulia/Uni/SBN/DATA/stream");
        File[] listOfFiles = folder.listFiles();
        for(int i = 0; i < listOfFiles.length; i ++){
            File f = new File(listOfFiles[i].getPath());
            File[] listOfF = f.listFiles();
            for(int j = 0; j < listOfF.length; i ++){
                read_file(listOfF[j].getPath());
            }
        }              

    }
}


