package interview.programs.first;

public class StaticExtendProblem {

    public static void main(String[] args) {
        A a = new B();
        a.foo();
    }

}

class A {

    public static void foo() {
        System.out.println("A");
    }
}

class B extends A {

    public static void foo() {
        System.out.println("B");
    }

}
