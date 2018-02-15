import MerkleTree.PublicKeyGeneration;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        PublicKeyGeneration pkg = new PublicKeyGeneration();

        int s = 128;
        int w = 8;
        Scanner nCount = new Scanner(System.in);
        System.out.printf("Input parametr N (power of 2):\n");
        int N = Integer.parseInt(nCount.nextLine());
        pkg.treeBilding(pkg.creationKeysArray(s, w, N), N);
        System.out.println("countLayer is " + pkg.countLayer);
        System.out.println("root is " + pkg.root);
        System.out.println("tree is " + pkg.tree);
    }
}
