package io.github.t45k.trials.lombok;

import lombok.experimental.UtilityClass;

import java.util.Arrays;
import java.util.stream.IntStream;

@UtilityClass
public class Utility {
    public IntStream intStream(final int[] array) {
        return Arrays.stream(array);
    }
}
