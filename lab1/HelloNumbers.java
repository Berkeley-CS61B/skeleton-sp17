public class HelloNumbers {
    public static void main(String[] args) {
        int x = 0;
        int total = x;
        while (x < 10) {
            System.out.print(total + " ");
            x = x + 1;
            total = total + x;
        }
    }
}