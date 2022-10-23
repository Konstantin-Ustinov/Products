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

    public static void task3_2_1() {
        Map<String, List<Integer>> firstMap = new HashMap<>();

        var random = new Random();
        for (int i = 1; i <= 5; i++) {
            firstMap.put("String" + i, new ArrayList<>(List.of(random.nextInt(1000), random.nextInt(1000), random.nextInt(1000))));
        }

        System.out.println("firstMap = " + firstMap);

        Map<String, Integer> secondMap = new HashMap<>();

        for (var element : firstMap.entrySet()) {
            String key = element.getKey();
            Integer value = element.getValue().get(0) + element.getValue().get(1) + element.getValue().get(2);
            secondMap.put(key, value);
        }

        System.out.println("secondMap = " + secondMap);
    }

    public static void task3_2_2() {
        var linkedMap = new LinkedHashMap<String, Integer>();

        var random = new Random();
        for (int i = 1; i <= 10; i++) {
            linkedMap.put("String" + i, random.nextInt(1000));
        }

        linkedMap.forEach((k, v) -> {
            System.out.println(k + ":" + v);
        });
    }
}
