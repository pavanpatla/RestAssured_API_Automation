package com.api.dummy.utilities;

import org.apache.commons.lang3.RandomStringUtils;

public class RestUtils {
    public static String empName() {
        String generatedString = RandomStringUtils.randomAlphabetic(2);
        return generatedString;
    }

    public static String empSal() {
        String generatedSalary = RandomStringUtils.randomNumeric(5);
        return generatedSalary;
    }

    public static String empAge() {
        String generatedAge = RandomStringUtils.randomNumeric(2);
        return generatedAge;
    }
}
