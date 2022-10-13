public class runtime {
    public static int do_double(operation x, int k) {
        return x.apply(x.apply(k));
    }

    public static void main(String[] args) {
        twoX function = new twoX();
        System.out.println(do_double(function, 10));
    }

}
