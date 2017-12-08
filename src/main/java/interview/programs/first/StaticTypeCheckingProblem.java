package interview.programs.first;

public class StaticTypeCheckingProblem {

    public static void main(String[] args) {

        //1st example...
        new Son().me().doA(); //legal
        // new Son().me().doB(); //illegal

        //2nd example...
        ((Son) new Son().me()).doB(); //legal

        //3rd example...
        Father fakeFather = new Son().me();
        if (fakeFather instanceof Son) {
            System.out.println("fakeFather is actually son!");
        } else if (fakeFather instanceof Father) {
            System.out.println("fakeFather is also a father!");
        } else {
            throw new IllegalArgumentException("ooooops!");
        }

        //4th example...
        ((BadSon) new Son().me()).doBad(); //illegal, ClassCastException problem...


    }

}


class Father {

    Father me() {
        return this;
    }

    public void doA() {
        System.out.println("Do A");
    }
}

class Son extends Father {
    public void doB() {
        System.out.println("Do B");
    }
}

class BadSon extends Father {
    public void doBad() {
        System.out.println("bad son");
    }
}