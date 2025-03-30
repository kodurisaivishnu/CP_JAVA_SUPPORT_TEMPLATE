import java.util.*;

public class Sol {
  
  public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t-- > 0) {
      // code here
        
    }
    sc.close();
  }

  public static void swap(int arr[], int a, int b) {
    int temp = arr[a];
    arr[a] = arr[b];
    arr[b] = temp;
  }
}
