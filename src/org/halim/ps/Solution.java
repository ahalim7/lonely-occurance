package org.halim.ps;

import java.io.IOException;
import java.util.*;

class Result {

    /*
     * Complete the 'findLonelyInteger' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY a as parameter.
     */

    public static int findLonelyInteger(List<Integer> a) {
        // Write your code here
        if (a.size() == 1)
            return a.get(0);

        if (a.size() % 2 != 0 && a.size() < 100) {
            Map<Integer, Integer> map = new HashMap<>();

            a.forEach(value -> {
                if (map.containsKey(value)) {
                    map.put(value, map.get(value) + 1);
                } else {
                    map.put(value, 1);
                }
            });

            Optional<Map.Entry<Integer, Integer>> rs =
                    map.entrySet().stream().filter(entry -> entry.getValue() == 1).findAny();

            if (rs.isPresent())
                return rs.get().getKey();

        }
        return 0;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        System.out.println(Result.findLonelyInteger(Arrays.asList(4, 9, 95, 93, 57, 4, 57, 93, 9)));
    }
}
