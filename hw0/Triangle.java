public class Triangle {
   public static void main(String[] args) {

     int col = 0;
     int row = 0;
     int size = 4;

     System.out.println("Hello, java");

     while (size >= row)
     {
       row += 1;
       while (row > col)
       {
         System.out.print("*");
         col += 1;
       }
       System.out.println(" ");
       col = 0;
     }
  }
}
