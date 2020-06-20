package openpgp.inspect;

import com.didisoft.pgp.*;
import com.didisoft.pgp.inspect.*;

/** 
 * Illustrates how to inspect the contents of an OpenPGP encrypt file 
 * 
 * Check also:
 * http://www.didisoft.com/java-openpgp/examples/inspect-the-contents-of-an-openpgp-archive/
 */
public class InspectEncryptedFile {

    public static void main(String[] args) throws Exception {

        // Encrypt a file
        PGPLib pgp = new PGPLib();        
        boolean asciiArmor = true;                
        pgp.encryptFile("examples/DataFiles/INPUT.txt", 
                        "examples/DataFiles/public.key", 
                        "examples/DataFiles/encrypted.pgp", 
                        asciiArmor);
        
        // Inspect the content of the encrypted file without decrypting
        PGPInspectLib inspectLib = new PGPInspectLib();
        
        String privateKey = "examples/DataFiles/private.key";
        String privateKeyPassword = "changeit";
        String encryptedFile = "examples/DataFiles/encrypted.pgp";
        
        ContentItem[] files = inspectLib.listOpenPGPFile(encryptedFile, privateKey, privateKeyPassword);
        for (int i=0; i < files.length; i++) {
            System.out.print(files[i].getFileName());
            System.out.print(files[i].isDirectory() ? "<DIR>" : "     ");
            System.out.println(files[i].getModificationDate());
        }
    }
}
