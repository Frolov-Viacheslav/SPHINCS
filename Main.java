import MerkleTree.PublicKeyGeneration;
import MerkleTree.SignatureGeneration;
import Config.*;
import MerkleTree.SignatureVerification;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        PublicKeyGeneration pkg = new PublicKeyGeneration();
        //Parametr w
        Scanner inW = new Scanner(System.in);
        System.out.printf("Input parametr w for WOTS:\n");
        int w = Integer.parseInt(inW.nextLine());
        //Parametr N
        Scanner nCount = new Scanner(System.in);
        System.out.printf("Input parametr N (power of 2):\n");
        int N = Integer.parseInt(nCount.nextLine());
        int s = 128; // Length of hash function
        //Building tree
        pkg.treeBilding(pkg.creationKeysArray(s, w, N), N);
        //Signinig
        int keyIndex = 0;
        signing(w, N, args, keyIndex);
    }

    public static void signing(Integer w, Integer N, String[] args, Integer keyIndex){
        PublicKeyGeneration pkg = new PublicKeyGeneration();
        SignatureGeneration sg = new SignatureGeneration();
        SignatureVerification sv = new SignatureVerification();
        MD5Binary md5b = new MD5Binary();
        //Parametr s and message
        Scanner inMessage = new Scanner(System.in);
        System.out.printf("Input your message:\n");
        String Message = inMessage.nextLine();
        Message = md5b.md5Custom(Message);
        int s = Message.length();
        //OTS key selection
        int keysResidue;
        keysResidue = N - (keyIndex + 1);
        String key = chooseOTS(pkg.keysArray, keyIndex);
        keyIndex++;
        System.out.println("Current index: " + (keyIndex - 1) + " Remainder of keys: " + keysResidue);
        //Merkle
        System.out.println(sg.SignatureGeneration(key, Message, s, w, pkg.tree, N, pkg.countLayer, pkg.root));
        System.out.println(sg.authPathCalculate(key, pkg.tree, N, pkg.countLayer));
        System.out.println(sv.getAuthPath(sg.SignatureGeneration(key, Message, s, w, pkg.tree, N, pkg.countLayer, pkg.root), s, pkg.countLayer));
        //Exit
        if(keysResidue == 0){
            System.out.println("Key limit is reached");
            System.out.println("Exit or create new tree? (0 - Exit, 1 - Create new tree):\n");
            Scanner inExit = new Scanner(System.in);
            int exitOrNot = Integer.parseInt(inExit.nextLine());
            if(exitOrNot == 1){
                //Reboot();
                main(args);
            }
            else System.exit(0);
        }
        Scanner inExit = new Scanner(System.in);
        System.out.println("Exit or not? (0 - Exit, 1 - Start):\n");
        int exitOrNot = Integer.parseInt(inExit.nextLine());
        if(exitOrNot == 1){
            //Reboot();
            signing(w, N, args, keyIndex);
        }
    }

    public static String chooseOTS(String [][] keysArray, Integer keyIndex){
        String OTSKey = keysArray[1][keyIndex];
        return OTSKey;
    }
}
