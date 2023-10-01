package task5;

public class MyTestTask5 {

    public static void main(String[] args) {
        assertConditionA();
        assertConditionB();
        sum(10, 2);
//        sum(Integer.MAX_VALUE, Integer.MAX_VALUE);

    }

    public static void assertConditionA() {
        String[] weekends = {"Суббота", "Воскресенье"};
        assert weekends.length == 2;
        System.out.println("В неделе " + weekends.length + " дня выходных");
    }

    public static void assertConditionB() {
        int x = -1;
        assert x <= 0;
    }

    public static void assertConditionC() {
        int x = sum(Integer.MAX_VALUE, Integer.MAX_VALUE);
        assert x <= Integer.MAX_VALUE;
    }

    public static int sum(int a, int b) {
        long c = (long)a + (long)b;
        long d = Integer.MAX_VALUE;
        Boolean isIt = d > c;
        assert isIt : "Переполнение переменной";
        return  a + b;
    }
}
