package interview.programs.first;

public class AliasingProblem {

    public static void main(String[] args) {

        Bar[] bars = new Bar[10];
        Foo[] foos = bars;

        foos[0] = new Foo(); // Note: comment-uncomment to see what happens.
//        foos[0] = new Bar(); // Note: comment-uncomment to see what happens.

        foos[0].methodParent();


    }

}


class Foo {
    public void methodParent() {
        System.out.println("method in Parent");
    }
}

class Bar extends Foo {
    public void methodParent() {
        System.out.println("override method in Child");
    }

    public void methodChild() {
        System.out.println("method in Child");
    }
}