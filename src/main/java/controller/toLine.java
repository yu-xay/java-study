package controller;

import com.tinify.Source;
import com.tinify.Tinify;

import java.io.File;
import java.util.Scanner;

public class toLine {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("������ת���ļ�Ŀ¼");
        while (true) {
            try {
                String line = s.nextLine();
                File bath = new File(line);
                if (!bath.exists()) {
                    System.out.println("Ŀ¼/�ļ�������");
                    continue;
                }
                if (bath.isDirectory()) {
                    File[] lists = bath.listFiles();
                    for (File children : lists) {
                        String name = children.getName();
                        String newName = name.replace("-", "_");
                        newName = newName.substring(0, newName.indexOf("."));
                        //'t_new_share' => $imageBaseUrl . '/app/t-new-share.png',
                        String ss = "'" + newName + "'" + "=> $imageBaseUrl . '/" + name + "',";
                        System.out.println(ss);
                    }
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
