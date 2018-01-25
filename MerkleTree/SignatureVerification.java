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
}
