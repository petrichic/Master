import java.io.PrintWriter;
import java.util.Scanner;

public class Inserts {

	public static void main(String[] args) {
		 Scanner scanner = new Scanner(System.in);
         PrintWriter printWriter = new PrintWriter(System.out);
         int size = scanner.nextInt();
         int[] a = new int[size];
         for (int i = 0; i < size; i++) {
             a[i] = scanner.nextInt();
         }
         for (int i = 0; i < size; i++)
         {
           int temp = a[i];
           int j =i-1;
           while(j >= 0 && a[j] > temp)
           {
             a[j + 1] = a[j];
             j--;
           }
           a[j + 1] = temp;
         }    
         for (int i = 0; i < size; i++) {
             printWriter.print(a[i] + " ");
         }
         scanner.close();
         printWriter.close();
     }

}
