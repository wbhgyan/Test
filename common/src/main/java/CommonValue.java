public class CommonValue {

    public static void main(String[] args) {
        Integer a = new Integer(8);

        Integer b = Integer.valueOf(8);

        Integer c = 8;

        System.out.println(a.equals(b));

        System.out.println(a.equals(c));

        System.out.println(b.equals(c));

        System.out.println(a == b);

        System.out.println(a == c);

        System.out.println(b == c);

    }

}
