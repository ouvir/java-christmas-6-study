package christmas.utils;

import christmas.exception.InputException;

import static christmas.exception.InputExceptionType.*;

public class Validator {
    public static void validateDate(String date) throws InputException {
        checkNullOrEmpty(date);
        checkNumberFormat(date);
        int value = Integer.parseInt(date);
        checkDateRange(value);
    }


    private static void checkNullOrEmpty(String date) {
        if (date == null || date.isEmpty()) {
            throw new InputException(DATE_FORMAT_ERROR);
        }
    }

    private static void checkDateRange(int value) {
        if (value < 1 || value > 31) {
            throw new InputException(DATE_FORMAT_ERROR);
        }
    }

    private static void checkNumberFormat(String date) {
        try {
            int test = Integer.parseInt(date);
        } catch (NumberFormatException e) {
            throw new InputException(DATE_FORMAT_ERROR);
        }
    }

    public static void validateOrder(String order) {
        checkNullOrEmpty(order);
        checkOrderFormat(order);
    }

    private static void checkOrderFormat(String order) {
        // 시저샐러드-1, 티본스테이크-1 와 같은 형식만 확인하고 에러 발생 시키기
    }
}
