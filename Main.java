import MerkleTree.PublicKeyGeneration;
import MerkleTree.SignatureGeneration;
import Config.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        PublicKeyGeneration pkg = new PublicKeyGeneration();
        SignatureGeneration sg = new SignatureGeneration();
        MD5Binary md5b = new MD5Binary();
        int s = 128;
        int w = 4;
        String Message = "Hello world";
        Message = md5b.md5Custom(Message);
        Scanner nCount = new Scanner(System.in);
        System.out.printf("Input parametr N (power of 2):\n");
        int N = Integer.parseInt(nCount.nextLine());
        pkg.treeBilding(pkg.creationKeysArray(s, w, N), N);

        String key = pkg.keysArray[1][0];

        System.out.println(sg.SignatureGeneration(key, Message, s, w, pkg.tree, N, pkg.countLayer, pkg.root));
    }
}
