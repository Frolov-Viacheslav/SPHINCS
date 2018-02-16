package MerkleTree;
import Config.*;
public class SignatureVerification {

WOTS_CR.SignatureVerification sv = new WOTS_CR.SignatureVerification();
    MD5HEX md5H = new MD5HEX();

    public boolean oneTimeSignatureVerify(String SIGNATURE, String Message, Integer s, Integer w){
        boolean equalSignature = false;
        equalSignature = sv.verifySignature(SIGNATURE, Message, s, w);
        return  equalSignature;
    }

    public void merkleKeyVerify(String key, Integer countLayer, String authPath, Integer s){
        //boolean equalSignature = false;
        String root = key;
        for(int i = 0; i < countLayer - 1; i++) {
            String temp = authPath;
            temp = temp.substring(i * s/4, i * s/4 + s/4); // нахождение подстроки с длиной в s символ
            root += temp;
            root = md5H.md5Custom(root);
        }
        System.out.println("root = " + root);
        //return  equalSignature;
    }

    public String getAuthPath(String SIGNATURE, Integer s, Integer countLayer){
        String authPath;
        authPath = SIGNATURE.substring(s/4 * 2, (s/4 * 2) + (s/4 * (countLayer - 1)));
        return authPath;
    }
}
