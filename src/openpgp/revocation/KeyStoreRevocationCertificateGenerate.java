package openpgp.revocation;


import com.didisoft.pgp.KeyStore;
import com.didisoft.pgp.RevocationLib;

/**
 * This example shows how to create a revocation certificate file for a
 * given OpenPGP key which is located in a KeyStore file.
 */
public class KeyStoreRevocationCertificateGenerate {

    public static void main(String[] args) throws Exception {
        String separator = System.getProperty("file.separator");
        String path = "DataFiles" + separator + "revocation" + separator;

        // initialize the KeyStore
        KeyStore keyStore = new KeyStore(path + "revocation.keystore", "changeit");
        // private key corresponding to the public key we want 
        // to create the revocation certificate for
        keyStore.importKeyRing(path + "key1_private.asc");
        
        String targetPrivateKeyPassword = ""; // empty password
        String targetKeyUserId = "RSA_1";
        
        // create an instance of the library
        RevocationLib lib = new RevocationLib();
        
        // reason and description
        byte revocationCode = RevocationLib.REASON_KEY_NO_LONGER_USED;
        String revocationDescription = "This key is no longer used";
        
        // where will be stored the certificate
        String certificateOutputFile = path + "revocation_certificate_key1.txt";
        
        // create the revocation certificate
        lib.createRevocationCertificateInFile(keyStore, 
                                            targetKeyUserId,
                                            targetPrivateKeyPassword, 
                                            revocationCode, 
                                            revocationDescription, 
                                            certificateOutputFile);        
    }
}
