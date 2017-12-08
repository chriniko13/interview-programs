package interview.programs.first;

public class PassByValue {

    public static void main(String[] args) {
        Apple apple = new Apple();
        System.out.println(apple.color);

        changeApple(apple);
        System.out.println(apple.color);


        System.out.println();

        int lucky = 17;
        System.out.println("lucky = " + lucky);
        change(lucky);
        System.out.println("lucky = " + lucky);

    }

    private static void change(int i) {
        i = 11;
    }

    static void changeApple(Apple apple) {
        apple.color = "green";
    }
}

class Apple {
    public String color = "red";
}
