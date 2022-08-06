package controller;


import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class netfilter {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入文件");
        String file = scanner.nextLine();
        file = "new".equals(file) ? "ja-netfilter.v3" : file;
        System.out.println(file);
        int limit = 0;
        while (true) {
            int random = (int) Math.floor(Math.random() * 1000000);
            String path_url = file + "&code=" + random;
            HttpURLConnection httpURLConnection;
            InputStream[] InputStream;
            try {
                URL url = new URL(path_url);
                httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.connect();
                InputStream = inputClone(httpURLConnection);
            } catch (Exception e) {
                System.out.println("连接错误" + e.getMessage());
                break;
            }
            int len = -1;
            byte[] buffer = new byte[1024 * 10];

            ByteArrayOutputStream swapStream = new ByteArrayOutputStream();
            while ((len = InputStream[0].read(buffer)) != -1) {
                swapStream.write(buffer, 0, len);
            }
            String end = new String(swapStream.toByteArray(), StandardCharsets.UTF_8);
            try {
                limit++;
                JSONObject json = JSONObject.parseObject(end);
                if (json.get("code").equals(-2)) {
                    System.out.println("验证失败次数" + limit);
                } else {
                    System.out.println("接口更新");
                    break;
                }
            } catch (JSONException e) {
                String down = "C:\\Users\\yu\\Desktop\\33.zip";
                FileOutputStream fos = new FileOutputStream(down, true);
                buffer = new byte[1024 * 10];
                while ((len = InputStream[1].read(buffer)) != -1) {
                    fos.write(buffer, 0, len);
                }
                fos.close();
                System.out.println("写出完毕!" + down);
                break;
            }
        }
    }

    public static InputStream[] inputClone(HttpURLConnection httpURLConnection) throws IOException {
        InputStream is = httpURLConnection.getInputStream();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024 * 10];
        int len;
        while ((len = is.read(buffer)) > -1) {
            baos.write(buffer, 0, len);
        }
        baos.flush();
        int num = 2;
        InputStream[] arr = new InputStream[num];
        for (int i = 0; i < num; i++) {
            arr[i] = new ByteArrayInputStream(baos.toByteArray());
        }
        return arr;
    }
}
