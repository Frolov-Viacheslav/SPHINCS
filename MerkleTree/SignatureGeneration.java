package MerkleTree;
import Config.*;
import WOTS_CR.*;

public class SignatureGeneration {

    WOTS_CR.SignatureGeneration sg = new WOTS_CR.SignatureGeneration();

    String[] oneTimeSignature;
    public void authPathCalculate(){
        oneTimeSignature[1] = "1";
    }
    public String oneTimeSignatureGeneration(String Message, Integer s, Integer w) {
        sg.generateSignature(Message, s, w);
        return sg.SIGNATURE;
    }


}
