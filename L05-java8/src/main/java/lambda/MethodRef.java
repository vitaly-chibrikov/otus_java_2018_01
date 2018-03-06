package lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 *
 */
public class MethodRef {

    static void foo(Integer v) {
        System.out.println("foo: " + v);
    }

    public static void main(String[] args) {


        Consumer<Integer> consumer = new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println("accept: " + integer);
            }
        };

        consumer = MethodRef::foo;

    }

    static class Bar {

        long compute(int v) {
            return v * v;
        }

        void doMap() {
            List<Integer> list = Arrays.asList(1, 2, 3);
            List<Long> collect = list.stream()
                    .map(new Function<Integer, Long>() {
                        @Override
                        public Long apply(Integer val) {
                            return (long) (val + 1);
                        }
                    })
                    .collect(Collectors.toList());
            System.out.println(collect);


        }

        public static void main(String[] args) {
            new Bar().doMap();
        }
    }
}
