package org.example.util;

import org.junit.Test;

public class SimHashTest {
    @Test
    public void GetHashTest(){
        String[] strings ={"据","小樱","说","上","星期二","她","同学","家","养的","狗","不见了","大家","都说","这是","宠物","诱拐犯","干"};
        for (String string:strings){
            String stringHash = SimHash.GetHash(string);
            System.out.println(stringHash);
        }
    }

    @Test
    public void GetSimHashTest(){
        String str1 = FileUtil.readFile("D:\\res\\orig.txt");
        String str2 = FileUtil.readFile("D:\\res\\orig_0.8_add.txt");
        System.out.println(SimHash.GetSimHash(str1));
        System.out.println(SimHash.GetSimHash(str2));
    }

    @Test
    public void GetHammingDistance(){
        String str1 = FileUtil.readFile("D:\\res\\orig.txt");
        String str2 = FileUtil.readFile("D:\\res\\orig_0.8_add.txt");
        int distance = SimHash.GetHammingDistance(str1,str2);
        System.out.println(distance);
    }

    @Test
    public void GetSimilarityTest(){
        String str1 = FileUtil.readFile("D:\\res\\orig.txt");
        String str2 = FileUtil.readFile("D:\\res\\orig_0.8_add.txt");
        double similarity = SimHash.GetSimilarity(SimHash.GetSimHash(str1),SimHash.GetSimHash(str2));
        System.out.println(similarity);
    }
}
