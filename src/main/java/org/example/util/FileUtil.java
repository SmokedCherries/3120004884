package org.example.util;

import java.io.*;

public class FileUtil {

    public static String readFile(String path) throws IOException {
        File file = new File(path);
        FileReader fileReader = new FileReader(file);
        BufferedReader br = new BufferedReader(fileReader);
        StringBuilder sb = new StringBuilder();
        String temp = "";
        while ((temp = br.readLine()) != null) {
            sb.append(temp + "\n");
        }
        br.close();
        String text = sb.toString();
        return sb.toString();
    }

    public static void writeFile(String path,double similarity){
        try {
            File file;
            file = new File(path);
            if (!file.exists()){
                file.createNewFile();
                file = new File(path);
            }
            FileWriter fw = new FileWriter(file,true);
            BufferedWriter writer = new BufferedWriter(fw);
            writer.write(String.format("%.2f",similarity));
            writer.flush();
            writer.newLine();
            writer.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}