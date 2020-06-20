package openpgp.revocation;

import com.didisoft.pgp.RevocationLib;

/**
 * This example demonstrates how to revoke an OpenPGP public key
 * with a revocation certificate file.
 */
public class RevocationCertificateImport {
    public static void main(String args[]) throws Exception {
        
        String separator = System.getProperty("file.separator");
        String path = "DataFiles" + separator + "revocation" + separator;

        // create an instance of the library
        RevocationLib lib = new RevocationLib();
        
        String targetPublicKey = path + "key1_public.asc";            
        String certificateFile = path + "revocation_certificate_key1.txt";
        
        // revoke key with revocation certificate
        lib.revokeKeyWithRevocationCertificateFile(targetPublicKey, certificateFile);        
    }
}
