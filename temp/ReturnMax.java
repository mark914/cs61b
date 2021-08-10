public class ReturnMax {
    /** Returns the maximum value from m using a for loop. */
    public static int forMax(int[] m) {
        int max_num  = m[0];
        int i = 0;
        while (i < m.length){
        if (m[i]>max_num){
        max_num = m[i];
        }
        i = i + 1;
        }
    return max_num;
    }
    public static void main(String[] args) {
       int[] numbers = new int[]{9, 2, 15, 2, 22, 10, 6};   
      System.out.print(forMax(numbers));
    }

}