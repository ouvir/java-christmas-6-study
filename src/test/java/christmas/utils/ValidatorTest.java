package christmas.utils;

import christmas.exception.InputException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {

    @ParameterizedTest
    @DisplayName("날짜 검증 - null, empty")
    @NullAndEmptySource
    void validateDateNullOrEmpty(String nullOrEmptyDate) {
        assertThrows(InputException.class, () -> Validator.validateDate(nullOrEmptyDate));
    }

    @Test
    @DisplayName("날짜 검증 - Nan")
    void validateDateNotANumber() {
        assertThrows(InputException.class, () -> Validator.validateDate("A"));
    }

    @ParameterizedTest
    @DisplayName("날짜 검증 - range")
    @ValueSource(strings = {"0", "32", "-5"})
    void validateDateOutOfRange(String outOfRangeDate) {
        assertThrows(InputException.class, () -> Validator.validateDate(outOfRangeDate));
    }



}