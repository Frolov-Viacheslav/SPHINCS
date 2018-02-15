package MerkleTree;
import Config.*;
import WOTS_CR.*;

public class SignatureGeneration {

    WOTS_CR.SignatureGeneration sg = new WOTS_CR.SignatureGeneration();
   // public static String SIGNATURE = "";

    public String authPathCalculate(String key, String [][] tree, Integer N, Integer countLayer){
        int keyIndex = 0;
        String authPath = "";
        for(int i = 0; i < N; i++) {
            if(tree[0][i] == key)
                keyIndex = i;
        }
        for(int i = 0; i < countLayer - 1; i++) {
            if(keyIndex % 2 == 0){
                keyIndex ++;
            }
            else {
                keyIndex --;
            }
            authPath += tree[i][keyIndex];
            keyIndex /= 2;
        }
        return authPath;
    }

    public String oneTimeSignatureGeneration(String Message, Integer s, Integer w) {
        sg.generateSignature(Message, s, w);
        return sg.SIGNATURE;
    }

    public String SignatureGeneration(String key, String Message, Integer s, Integer w, String [][] tree, Integer N, Integer countLayer, String root){
        MD5HEX md5H = new MD5HEX();
        String SIGNATURE = key + md5H.md5Custom(oneTimeSignatureGeneration(Message, s, w)) + authPathCalculate(key, tree, N, countLayer) + root;
        return SIGNATURE;// oneTimeY + oneTimeSig + authPath + root
    }
}
