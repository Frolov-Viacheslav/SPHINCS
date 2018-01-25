import MerkleTree.PublicKeyGeneration;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        PublicKeyGeneration pkg = new PublicKeyGeneration();

        int s = 128;
        int w = 8;
        String Message = "Hello";
        Scanner nCount = new Scanner(System.in);
        System.out.printf("Input parametr N (power of 2):\n");
        int N = Integer.parseInt(nCount.nextLine());
        for(int i = 0; i < N; i++) {
            System.out.println(pkg.merkleKeyGeneration(s, w));
        }

    }
}
