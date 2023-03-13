package com.zetcode;

import java.util.List;
import java.util.ArrayList;

public class Main {


    public class Kata {
                 
        public static List<Object> filterList(List<Object> list) {
            List<Object> result = new ArrayList<>();
            for (Object item : list) {
                if (item instanceof Integer || item instanceof Double) {
                    result.add(item);
                }
            }
            return result;
        }
    }
}
