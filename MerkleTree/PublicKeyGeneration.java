package MerkleTree;
import Config.*;
import WOTS_CR.*;

public class PublicKeyGeneration {
    PRG prg = new PRG();
    KeyPairGeneration kpg = new KeyPairGeneration();

    public String merkleKeyGeneration(Integer s, Integer w){
        kpg.generatePairKey(s, w);
        String hashPublicKey = "";
        hashPublicKey = MD5HEX.md5Custom(kpg.Y);
        return hashPublicKey;
    }

}
