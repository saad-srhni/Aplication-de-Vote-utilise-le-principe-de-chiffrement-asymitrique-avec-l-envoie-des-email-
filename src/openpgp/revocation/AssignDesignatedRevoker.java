package openpgp.revocation;

import com.didisoft.pgp.*;

/**
 * This example demonstrates how to assign a designated revoker for a given OpenPGP key.
 */
public class AssignDesignatedRevoker {

    /**
     * @param args
     */
    public static void main(String[] args) throws Exception {        
        String separator = System.getProperty("file.separator");
        String path = "DataFiles" + separator + "revocation" + separator;

        // create an instance of the library
        RevocationLib lib = new RevocationLib();
        
        String targetPublicKey = path + "key1_public.asc";
        String targetPrivateKey = path + "key1_private.asc";
        String targetPrivateKeyPassword = ""; // empty password 
        String designatedRevokerFile = path + "key2_public.asc";
        
        // assign designated revoker
        lib.assignDesignatedRevoker(targetPublicKey,
                                    targetPrivateKey, 
                                    targetPrivateKeyPassword,  
                                    designatedRevokerFile);
    }
}
