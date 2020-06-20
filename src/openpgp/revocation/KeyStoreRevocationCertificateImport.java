package openpgp.revocation;


import com.didisoft.pgp.KeyStore;
import com.didisoft.pgp.RevocationLib;

/**
 * This example demonstrates how to revoke an OpenPGP public key
 * which is located in a KeyStore file with a revocation certificate file.
 */
public class KeyStoreRevocationCertificateImport {
    public static void main(String args[]) throws Exception {
        
        String separator = System.getProperty("file.separator");
        String path = "DataFiles" + separator + "revocation" + separator;

        // initialize the KeyStore
        KeyStore keyStore = new KeyStore(path + "revocation.keystore", "changeit");
        // public key the revocation certificate is for
        keyStore.importKeyRing(path + "key1_public.asc");
        
        // create an instance of the library
        RevocationLib lib = new RevocationLib();
        
        String certificateFile = path + "revocation_certificate_key1.txt";
        
        // revoke key with revocation certificate
        lib.revokeKeyWithRevocationCertificateFile(keyStore, certificateFile);
        
        String targetKeyUserId = "RSA_1";
        
        // should the exported public key be in ASCII or binary format 
        boolean asciiArmored = true;
        
        // the exported public key is revoked and can be distributed  
        // to our partners in order to prevent its future usage
        keyStore.exportPublicKey(path + "key1_public_revoked.asc", 
                                targetKeyUserId, 
                                asciiArmored);
    }
}
