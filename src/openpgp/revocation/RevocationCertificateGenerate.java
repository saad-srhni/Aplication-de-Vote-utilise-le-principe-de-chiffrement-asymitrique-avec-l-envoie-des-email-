package openpgp.revocation;

import com.didisoft.pgp.KeyStore;
import com.didisoft.pgp.RevocationLib;

/**
 * This example shows how to create a revocation certificate file for a
 * given OpenPGP key.
 */
public class RevocationCertificateGenerate {
    public static void main(String args[]) throws Exception {        
        String separator = System.getProperty("file.separator");
        String path = "DataFiles" + separator + "revocation" + separator;

        // create an instance of the library
        RevocationLib lib = new RevocationLib();
        
        // private key corresponding to the public key we want 
        // to create the revocation certificate for
        String targetPrivateKey = path + "key1_private.asc";
        String targetPrivateKeyPassword = ""; // empty password 
        
        // reason and description
        byte revocationCode = RevocationLib.REASON_KEY_NO_LONGER_USED;
        String revocationDescription = "This key is no longer used";
        
        // where will be stored the certificate
        String certificateOutputFile = path + "revocation_certificate_key1.txt";
        
        // create the revocation certificate
        lib.createRevocationCertificateInFile(targetPrivateKey, 
                                            targetPrivateKeyPassword, 
                                            revocationCode, 
                                            revocationDescription, 
                                            certificateOutputFile);        
    }
}
