package ni.org.jug.subtiava.validation;

import java.math.BigDecimal;
import java.util.function.BiPredicate;

/**
 * @author aalaniz
 * @version 1.0
 */
public final class Inputs {
    public static final String INPUT_OPTION_REQUIRED = "You must provide at least one option";

    private Inputs() {
    }

    public static boolean lessThan(BigDecimal left, BigDecimal right) {
        return !(left == null || right == null) ? left.compareTo(right) < 0 : false;
    }

    public static boolean greaterThan(BigDecimal left, BigDecimal right) {
        return !(left == null || right == null) ? left.compareTo(right) > 0 : false;
    }

    public static boolean equals(BigDecimal left, BigDecimal right) {
        return !(left == null || right == null) ? left.compareTo(right) == 0 : false;
    }

    public static boolean isEmpty(Object[] values) {
        return values == null || values.length == 0;
    }

    public static boolean isEmpty(long[] values) {
        return values == null || values.length == 0;
    }

    public static boolean isNotEmpty(Object[] values) {
        return !isEmpty(values);
    }

    public static boolean isNotEmpty(long[] values) {
        return !isEmpty(values);
    }

    public static void copyArgs(Object first, Object second, Object[] moreOptions, Object[] dest) {
        int i = 0;
        if (first != null) {
            dest[i++] = first;
        }
        if (second != null) {
            dest[i++] = second;
        }
        if (isNotEmpty(moreOptions)) {
            System.arraycopy(moreOptions, 0, dest, i, moreOptions.length);
        }
    }

    public static int arraySize(Object first, Object second, Object[] moreOptions) {
        if (first == null && second == null && isEmpty(moreOptions)) {
            throw new IllegalArgumentException(INPUT_OPTION_REQUIRED);
        }
        return (first != null ? 1 : 0) + (second != null ? 1 : 0) + (isEmpty(moreOptions) ? 0 : moreOptions.length);
    }

    public static <T> boolean searchKey(BiPredicate<T, T> condition, T searched, T[] values) {
        boolean found = false;
        for (int i = 0; i < values.length; i++) {
            if (condition.test(searched, values[i])) {
                found = true;
                break;
            }
        }
        return found;
    }

    public static <T> boolean searchKey(T searched, T[] values) {
        boolean found = false;
        for (int i = 0; i < values.length; i++) {
            if (searched.equals(values[i])) {
                found = true;
                break;
            }
        }
        return found;
    }

    public static boolean searchKey(long searched, long[] values) {
        boolean found = false;
        for (int i = 0; i < values.length; i++) {
            if (searched == values[i]) {
                found = true;
                break;
            }
        }
        return found;
    }
}