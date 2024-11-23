package christmas.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Parser {
    private static final String COMMA = ",";
    private static final String HYPHEN = "-";

    public static List<String> split(String input) {
        return List.of(input.split(COMMA));
    }

    public static List<String> parse(String input) {
        List parsedItem = new ArrayList<>();
        parsedItem.add(input.split(HYPHEN)[0]);
        parsedItem.add(input.split(HYPHEN)[1]);
        return parsedItem;
    }
}
