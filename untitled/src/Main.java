public class Main {

    public static void main(String[] args) {
        int[] tablica = {1,4,-1,3,2};
        int a = 55;
        int b = 777;
        System.out.println(sollution2(a,b));
        System.out.println(sollution3(a,b));


    }
    static int sollution(int[] A) {
        int lubiePlacki = A[0];
        int pojemnoscWalca = 1;
        while (lubiePlacki!=-1){
            lubiePlacki = A[lubiePlacki];
            pojemnoscWalca++;
        }
        return pojemnoscWalca;
    }

    static int sollution2(int a, int b) {
        int c = 1;
        int count =0;
        while (c*c<=b) {
            if (c*c>=a) {
               count++;
            }
            c++;
        }
        return count;

    }
    static int sollution3(int a, int b) {

        int xa = (int) Math.sqrt(a);
        int xb = (int) Math.sqrt(b);
//        System.out.println(xa);
//        System.out.println(xb);
        int xs = xb-xa+1;
        return xs;

    }
}
