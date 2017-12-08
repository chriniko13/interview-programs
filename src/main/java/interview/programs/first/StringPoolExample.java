package interview.programs.first;

public class StringPoolExample {

    public static void main(String[] args) {


        String s1 = "chriniko";
        String s2 = "chriniko";
        System.out.println("result = " + (s1 == s2));


        String s3 = new String("sample");
        String s4 = new String("sample");
        System.out.println("result = " + (s3 == s4));


    }
}
