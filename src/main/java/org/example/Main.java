package org.example;

import org.example.util.SimHash;
import org.example.util.FileUtil;

import java.io.IOException;
public class Main {
    public static void main(String[] args) {
        String origFile = null;
        String inFile = null;
        try {
            origFile = FileUtil.readFile(args[0]);
            inFile = FileUtil.readFile(args[1]);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        double result = SimHash.GetSimilarity(origFile,inFile);
        FileUtil.writeFile(args[2],result);
    }
}
