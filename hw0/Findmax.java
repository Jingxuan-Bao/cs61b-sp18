public class Findmax {
    /** Returns the maximum value from m. */
    public static int max(int[] m) {
        int i = 0;
        int max_number = 0;
        while (i < m.length) {
          if (m[i] >= max_number) {
            max_number = m[i];
          }
          i += 1;
        }
        return max_number;
    }
    public static void main(String[] args) {
       int[] numbers = new int[]{9, 2,87,6,5,79};
       System.out.println(max(numbers));
    }
}
