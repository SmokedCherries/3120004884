package org.example.util;

import org.example.exception.CustomException;
import com.hankcs.hanlp.HanLP;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.List;

public class SimHash {
    public static String GetHash(String str){
        try{
            //使用MD5来获得字符的hash值
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            return new BigInteger(1, messageDigest.digest(str.getBytes(StandardCharsets.UTF_8))).toString(2);
        }catch(Exception e){
            e.printStackTrace();
            return str;
        }
    }
    public static String GetSimHash(String str) {
        // 文本长度太短时HanLp无法取得关键字,抛出文本过短异常
        try {
            if (str.length() < 200) {
                throw new CustomException("文本过短！");
            }
        } catch (CustomException e) {
            e.printStackTrace();
            return null;
        }
        int[] v = new int[128];
        List<String> keywordList = HanLP.extractKeyword(str, str.length());
        // hash
        int size = keywordList.size();
        //以i做外层循环
        int i = 0;
        for (String keyword : keywordList) {
            // 2、获取hash值
            StringBuilder keywordHash = new StringBuilder(GetHash(keyword));
            if (keywordHash.length() < 128) {
                // hash值可能少于128位，在低位以0补齐
                int dif = 128 - keywordHash.length();
                keywordHash.append("0".repeat(Math.max(0, dif)));
            }
            // 3、加权
            for (int j = 0; j < v.length; j++) {
                if (keywordHash.charAt(j) == '1') {
                    v[j] += (10 - (i / (size / 10)));
                } else {
                    v[j] -= (10 - (i / (size / 10)));
                }
            }
            i++;
        }
        // 4、降维
        StringBuilder simHash = new StringBuilder();
        int j = 0;
        while (j < v.length) {
            if (v[j] <= 0) {
                simHash.append("0");
            } else {
                simHash.append("1");
            }
            j++;
        }
        return simHash.toString();
    }
    public static int GetHammingDistance(String simHash1, String simHash2) {
        //定义返回的海明距离
        int hammingDistance = 0;
        if (simHash1.length() != simHash2.length()) {
            // 数据出错，返回-1
            hammingDistance = -1;
        } else {
            for (int i = 0; i < simHash1.length(); i++) {
                // 每一位进行比较
                if (simHash1.charAt(i) != simHash2.charAt(i)) {
                    hammingDistance++;
                }
            }
        }
        return hammingDistance;
    }

    public static double GetSimilarity(String simHash1, String simHash2) {
        // 通过 simHash1 和 simHash2 获得它们的海明距离
        int distance = GetHammingDistance(simHash1, simHash2);
        // 通过海明距离计算出相似度，并返回
        return 0.01 * (100 - distance * 100 / 128);
    }
}
