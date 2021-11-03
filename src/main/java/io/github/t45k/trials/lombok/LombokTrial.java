package io.github.t45k.trials.lombok;

import lombok.experimental.ExtensionMethod;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@ExtensionMethod(Utility.class)
public class LombokTrial {

    public static void main(final String[] args) {
        final int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        final String s = array.intStream() // 同じクラスにメソッドを宣言すると実行できないっぽい
            .mapToObj(Integer::toString)
            .collect(Collectors.joining(" "));
        System.out.println(s);
    }
    // 予測に出てこないのが難点

    // 何この書き方
    private static void alt() {
        final List<Integer> list = new ArrayList<Integer>() {
            public List<Integer> sorted() {
                return this.stream().sorted().collect(Collectors.toList());
            }
        }.sorted();
    }
}
