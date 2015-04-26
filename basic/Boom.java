public class Boom {
    public static void main(String[] args) {
        Bam.sayFoo();
        Boom.sayBar();
    }

    public static void sayBar() {
        System.out.println("bar");
    }
}
