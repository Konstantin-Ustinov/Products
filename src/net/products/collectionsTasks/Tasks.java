package net.products.collectionsTasks;

import java.util.*;

public class Tasks {
    public static void task3_2() {
        Random random = new Random();
        Set<String> set = new HashSet<>();

        String str;

        for (int i = 0; i < 15; i++) {
            str = random.nextInt(10) + "*" + random.nextInt(10);
            if (!set.contains(str) && !set.contains(reverseStr(str))) {
                set.add(str);
            }
        }

        int count = 1;
        for (String s : set) {
            System.out.println(count+ ": " + s);
            count++;
        }
    }

    private static String reverseStr(String str) {
        StringBuilder sb = new StringBuilder(str);
        return sb.reverse().toString();
    }

    public static void telephoneDirectory() {
        HashMap<String, Integer> telephoneDirectory = new HashMap<>();

        var random = new Random();
        for (int i = 0; i < 20; i++) {
            telephoneDirectory.put("Имя " + i, random.nextInt(1000000000));
        }

        System.out.println(telephoneDirectory);
    }
}
