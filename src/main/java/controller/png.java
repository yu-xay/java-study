package controller;

import com.tinify.Source;
import com.tinify.Tinify;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class png {
    public static void main(String[] args) {

        Tinify.setKey("TmTrfsnB1gt2slgbx5jngCklPnBtSNBd");
        Boolean a = Tinify.validate();
        if (!Tinify.validate()) {
            System.out.println("��֤ʧ��");
            return;
        }
        Scanner s = new Scanner(System.in);
        System.out.println("�������ļ�");

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
                        Thread t = new Thread(() -> {
                            if (!children.isDirectory()) {
                                String name = children.getName();
                                String path = line + "\\" + name;
                                Source source = null;
                                try {
                                    source = Tinify.fromFile(path);
                                    source.toFile(path);
                                    System.out.println("�ü��ɹ���" + path);
                                } catch (Exception e) {
                                    System.out.println(e.getMessage());
                                }
                            }
                        });
                        t.start();
                    }
                } else {
                    Source source = Tinify.fromFile(line);
                    source.toFile(line);
                    System.out.println("�ɹ���" + line);
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
