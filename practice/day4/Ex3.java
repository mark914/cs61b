public class Ex3 {
    public static int[] flatten(int[][] x) {
        int totalLength = 0;
        for (int i = 0; i < x.length; i=i+1) {
            totalLength += x[i].length;
        }
        int[] res = new int[totalLength];
        int resIndex = 0;
        for (int[] a: x) {
            for (int b: a) {
                res[resIndex] = b;
                resIndex += 1;
            }
        }
        return res;
    }





    public static void main(String[] args) {
        int[][] a = {{1, 2, 3}, {}, {7, 8}};
        int[] exp = {1, 2, 3, 7, 8};
        int[] b = Ex3.flatten(a);

        System.out.print(exp == b);
        System.out.print(b);
    }
}
