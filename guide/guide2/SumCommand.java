public class SumCommand{
   public static void main(String[] args){
   int N = args.length;
   int sum = 0;
   int i = 0;
   while ( i < N) {
   sum = sum + Integer.parseInt(args[i]);
   i = i+1;
   }
   
   System.out.println(sum);
  }



}