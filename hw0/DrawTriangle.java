public class DrawTriangle{

    public static void Angle(int N) {
      int col = 0;
      int row = 0;
      N -= 1;

      while (row <= N) {
        row += 1;
        while (col < row) {
          System.out.print("*");
          col += 1;
        }
        System.out.println(" ");
        col = 0;
      }
    }

   public static void main(String[] args) {
     Angle(5);
   }
}
