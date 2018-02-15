package MerkleTree;

public class SignatureVerification {

WOTS_CR.SignatureVerification sv = new WOTS_CR.SignatureVerification();

    public boolean oneTimeSignatureVerify(String SIGNATURE, String Message, Integer s, Integer w){
        boolean equalSignature = false;
        equalSignature = sv.verifySignature(SIGNATURE, Message, s, w);
        return  equalSignature;
    }

    public boolean merkleKeyVerify(){
        boolean equalSignature = false;
        return  equalSignature;
    }
    
    public String getAuthPath(String SIGNATURE, Integer s, Integer countLayer){
        String authPath;
        authPath = SIGNATURE.substring(s/4 * 2, (s/4 * 2) + (s/4 * (countLayer - 1)));
        return authPath;
    }
}
