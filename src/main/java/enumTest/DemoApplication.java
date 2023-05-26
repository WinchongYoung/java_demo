package enumTest;

import java.util.function.BiFunction;

/**
 * Enum结合Lambda表达式，实现两个整数的四则运算
 */
public class DemoApplication {

    public static void main(final String[] args) throws Exception {
        int result = Operation.ADD.apply(2, 3);
        System.out.println(result);
    }

    enum Operation {
        ADD((x, y) -> x + y), SUBTRACT((x, y) -> x - y), MULTIPLY((x, y) -> x * y);

        Operation(BiFunction<Integer, Integer, Integer> operation) {
            this.operation = operation;
        }

        private final BiFunction<Integer, Integer, Integer> operation;

        public int apply(int x, int y) {
            return operation.apply(x, y);
        }
    }
}