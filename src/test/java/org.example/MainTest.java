package org.example;

import org.example.util.SimHash;
import org.example.util.FileUtil;
import org.junit.Test;

public class MainTest {
    @Test
    public void origAndAdd(){
        String str0 = FileUtil.readFile("D:/res/orig.txt");
        String str1 = FileUtil.readFile("D:/res/orig_0.8_add.txt");
        String resFileName = "D:/res/origAndAddTest.txt";
        double ans = SimHash.GetSimilarity(SimHash.GetSimHash(str0), SimHash.GetSimHash(str1));
        FileUtil.writeFile(ans, resFileName);
    }

    @Test
    public void origAndDel(){
        String str0 = FileUtil.readFile("D:/res/orig.txt");
        String str1 = FileUtil.readFile("D:/res/orig_0.8_del.txt");
        String resFileName = "D:/res/origAndDelTest.txt";
        double ans = SimHash.GetSimilarity(SimHash.GetSimHash(str0), SimHash.GetSimHash(str1));
        FileUtil.writeFile(ans, resFileName);
    }

    @Test
    public void origAndDis1(){
        String str0 = FileUtil.readFile("D:/res/orig.txt");
        String str1 = FileUtil.readFile("D:/res/orig_0.8_dis_1.txt");
        String resFileName = "D:/res/origAndDis1Test.txt";
        double ans = SimHash.GetSimilarity(SimHash.GetSimHash(str0), SimHash.GetSimHash(str1));
        FileUtil.writeFile(ans, resFileName);
    }

    @Test
    public void origAndDis10(){
        String str0 = FileUtil.readFile("D:/res/orig.txt");
        String str1 = FileUtil.readFile("D:/res/orig_0.8_dis_10.txt");
        String resFileName = "D:/res/origAndDis10Test.txt";
        double ans = SimHash.GetSimilarity(SimHash.GetSimHash(str0), SimHash.GetSimHash(str1));
        FileUtil.writeFile(ans, resFileName);
    }

    @Test
    public void origAndDis15(){
        String str0 = FileUtil.readFile("D:/res/orig.txt");
        String str1 = FileUtil.readFile("D:/res/orig_0.8_dis_15.txt");
        String resFileName = "D:/res/origAndDis15Test.txt";
        double ans = SimHash.GetSimilarity(SimHash.GetSimHash(str0), SimHash.GetSimHash(str1));
        FileUtil.writeFile(ans, resFileName);
    }

    @Test
    public void origAndOrig(){
        String str0 = FileUtil.readFile("D:/res/orig.txt");
        String str1 = FileUtil.readFile("D:/res/orig.txt");
        String resFileName = "D:/res/origAndOrigTest.txt";
        double ans = SimHash.GetSimilarity(SimHash.GetSimHash(str0), SimHash.GetSimHash(str1));
        FileUtil.writeFile(ans, resFileName);
    }
}
