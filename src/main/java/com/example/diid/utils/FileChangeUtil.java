package com.example.diid.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class FileChangeUtil {
    public static void main(String[] args) throws Exception {
        System.out.println(ArticleUtil.readArticleFromtxt("H:\\素材\\articles\\文.txt"));
        // 看看io流
        int i=0;
        File file=new File("H:\\素材\\articles\\文.txt");
        if(!file.exists()){
            System.out.println("不存在");
        }else {
            BufferedReader reader=new BufferedReader(new FileReader(file));
            String tem="";
            while ((tem = reader.readLine()) != null){
                System.out.println(tem+"---"+i);
                i++;
            }
        }


    }
}
