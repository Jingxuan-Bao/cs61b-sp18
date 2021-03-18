public class BreakContinue {
  public static void windowPosSum(int[] a, int n) {
    /** your code here */
    int sum = 0;
    for (int i = 0; i < a.length; i++){
      if (a[i] < 0) {
        continue;
      }
      for (int j = 0; j < n; j++) {
        int k = i + j;
        if (k >= a.length) {
          break;
        }
        sum = sum + a[k];
      }
      a[i] = sum;
      sum = 0;
    }
  }

  public static void main(String[] args) {
    int[] a = {1, 2, -3, 4, 5, 4};
    int n = 3;
    windowPosSum(a, n);

    // Should print 4, 8, -3, 13, 9, 4
    System.out.println(java.util.Arrays.toString(a));
  }
}
