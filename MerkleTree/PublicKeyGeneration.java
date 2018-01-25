package MerkleTree;
import Config.*;

public class PublicKeyGeneration {
    PRG prg = new PRG();

    public String privateKeyGeneration(){
        String privateKey = prg.Random128();
        String hashPrivateKey = MD5HEX.md5Custom(privateKey);
        return hashPrivateKey;
    }

    public String publicKeyGeneration(){
        String publicKey = prg.Random128();
        String hashPublicKey = MD5HEX.md5Custom(publicKey);
        return hashPublicKey;
    }

    public String [][] creationKeysArray(Integer N){
        String [][] keysArray = new String[2][N];
        for(int i = 0; i < N; i++) {
            keysArray[0][i] = privateKeyGeneration();
            keysArray[1][i] = publicKeyGeneration();
        }
        return keysArray;
    }

    public String treeBilding(String [][] keysArray, Integer N){
        int countLayer = (int)Math.ceil(Binarylog.binlog((double) N)) + 1;
        String root = "";
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
        return root;
    }
}
