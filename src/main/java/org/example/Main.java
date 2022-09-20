package org.example;

import org.example.util.SimHash;
import org.example.util.FileUtil;

import java.io.IOException;
public class Main {
    public static void main(String[] args) {
        String origFile = FileUtil.readFile(args[0]);
        String inFile = FileUtil.readFile(args[1]);
        String simhash1 = SimHash.GetSimHash(origFile);
        String simhash2 = SimHash.GetSimHash(inFile);
        double result = SimHash.GetSimilarity(simhash1,simhash2);
        FileUtil.writeFile(result,args[2]);
        System.exit(0);
    }
}
