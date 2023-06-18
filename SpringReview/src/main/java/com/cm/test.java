package com.cm;

import java.io.*;
import java.util.*;

public class test {


    public static void main(String[] args) throws IOException {
        File file = new File("F:\\workplace(Java)\\JavaReview\\SpringReview\\src\\main\\java\\com\\cm\\a.txt");
        List<String> list1 = new ArrayList();
        FileInputStream fileInputStream = new FileInputStream(file);
        BufferedReader br = new BufferedReader(new InputStreamReader(fileInputStream));
        byte[] bytes = new byte[1024];
        String str;
        StringBuilder sb = new StringBuilder();
        while ((str = br.readLine()) != null) {
//            list1.add(str);
            sb.append(str).append("\r\n");
        }
        String res = sb.toString();
        Map<String, String> map = new HashMap<>();
        map.put("1", "a");
        map.put("2", "b");
        map.put("3", "c");
        map.put("4", "d");

        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (res.contains(entry.getKey())) {
                res = res.replace(entry.getKey(), entry.getValue());
            }
        }
        FileOutputStream fos = new FileOutputStream(new File("F:\\workplace(Java)\\JavaReview\\SpringReview\\src\\main\\java\\com\\cm\\b.txt"));
        PrintStream ps = new PrintStream(fos);
        ps.println(res);



    /*    Iterator<String> iterator = list1.iterator();
        while (iterator.hasNext()) {

            iterator.next();
        }*/


/*        for (int i1 = 0; i1 < list1.size(); i1++) {
            String s = list1.get(i1);
            if (s.contains("1")) {
                s = s.replaceAll("1", "a");
            }
            if (s.contains("2")) {
                s = s.replaceAll("2", "b");
            }
            if (s.contains("3")) {
                s = s.replaceAll("3", "c");
            }
            if (s.contains("4")) {
                s = s.replaceAll("4", "d");
            }
            list1.remove(i1);
            list1.add(i1, s);
        }
        FileOutputStream fos = new FileOutputStream(new File("F:\\workplace(Java)\\JavaReview\\SpringReview\\src\\main\\java\\com\\cm\\b.txt"));
        PrintStream ps = new PrintStream(fos);
        for (String l : list1) {
//            fos.write(o.toString().getBytes());
            ps.write(l.getBytes());
        }*/
    }
}
