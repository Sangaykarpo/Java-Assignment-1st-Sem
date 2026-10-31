public class EvenSum {
    public static void main(String[] args) {
        int num = 2;
        int sum = 0;

        while (num <= 50) {
            sum = sum + num;
            num = num + 2;
        }

        System.out.println("Sum of even numbers from 1 to 50 = " + sum);
    }
}