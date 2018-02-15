package MerkleTree;
import Config.*;
import WOTS_CR.*;

public class PublicKeyGeneration {
    PRG prg = new PRG();
    KeyPairGeneration kpg = new KeyPairGeneration();
    
    public String privateKeyGeneration(){
        String hashPrivateKey = MD5HEX.md5Custom(kpg.X);
        return hashPrivateKey;
    }

    public String publicKeyGeneration(){
        String hashPublicKey = MD5HEX.md5Custom(kpg.Y);
        return hashPublicKey;
    }

    public String [][] creationKeysArray(Integer s, Integer w, Integer N){
        String [][] keysArray = new String[2][N];
        for(int i = 0; i < N; i++) {
            kpg.generatePairKey(s, w);
            keysArray[0][i] = privateKeyGeneration();
            keysArray[1][i] = publicKeyGeneration();
        }
        return keysArray;
    }

    public static String root;

    public String treeBilding(String [][] keysArray, Integer N){
        int countLayer = (int)Math.ceil(Binarylog.binlog((double) N)) + 1;
        String[][] tree = new String[countLayer][N];
        for(int i = 0; i < N; i++) {
            tree[0][i] = keysArray[1][i];
        }
        int k = 0;
        for (int i = 1; i < countLayer; i++) {
            for (int j = 0; j < N/(Math.pow(2, i-1)); j+=2) {
                tree[i][k] =  MD5HEX.md5Custom(tree[i-1][j] + tree[i-1][j+1]);
                k++;
            }
            k = 0;
        }

        for (int i = 0; i < countLayer; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(tree[i][j] + "\t");
            }
            System.out.println();
        }
        root = tree[countLayer-1][0];
        return root;
    }
}
