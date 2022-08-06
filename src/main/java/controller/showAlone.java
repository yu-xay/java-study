package controller;

import com.alibaba.fastjson.JSON;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class showAlone {
    public static void main(String[] args) throws Exception {

     //   System.out.println(System.getProperty("user.home"));
           ///     return;
       createThread();
    }

    public static void createThread() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                Integer a = 1;
                while (true) {
                    String port = "";
                    try {
                        a++;
                        //String[] portss = {"005454","20000","001532","40000","002943","20000"};001168
                        String[] portss = {"002943"};
                        //         239391113

                        Iterator<String> ii = Arrays.stream(portss).iterator();
                        double ss = 0D;
                        while (ii.hasNext()) {
                            port = ii.next();
                            URL url = new URL("http://fundgz.1234567.com.cn/js/" + port + ".js");
                            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                            httpURLConnection.connect();
                            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream(), StandardCharsets.UTF_8));

                            StringBuffer stringBuffer = new StringBuffer();
                            String line = null;
                            while ((line = bufferedReader.readLine()) != null) {
                                stringBuffer.append(line);
                            }
                            String s = stringBuffer.substring(8);
                            s = s.substring(0, s.length() - 2);
                            Map<String, String> map = (Map) JSON.parse(s);

                            DateFormat dateFormat = DateFormat.getDateInstance();
                            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-dd HH:mm");
                            Date date = simpleDateFormat.parse(map.get("gztime"));

                            Calendar calendar = Calendar.getInstance();
                            calendar.setTime(date);
                            Integer r = calendar.get(Calendar.HOUR_OF_DAY);
                            Integer m = calendar.get(Calendar.MINUTE);
                            BigDecimal b1 = new BigDecimal(map.get("gszzl"));
                            BigDecimal b3 = new BigDecimal(100);
                            System.out.println(b1);
                        }
                        Thread.sleep(50);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

            }
        };
        Thread t1 = new Thread(runnable);
        t1.start();

    }

}
