package org.example.util;

public class SimHash {
    public static double GetSimilarity(String str1,String str2){
        double i = (double) HammingDistance(str1,str2);
        return 1-i/64;
    }
}
