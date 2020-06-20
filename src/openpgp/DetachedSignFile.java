package openpgp;
import com.didisoft.pgp.PGPLib;

/**
 * This example demonstrates OpenPGP detached signing.
 * 
 * We use our private key for creating the detached signature and our partners
 * will use our public key to verify it.  
 */
public class DetachedSignFile {
    public static void main(String[] args) throws Exception{
        // initialize the library 
        PGPLib pgp = new PGPLib();
        
        // specify should the output be ASCII (true) or binary (false)
        boolean asciiArmor = false;
        pgp.detachedSignFile("DataFiles/INPUT.txt", 
                            "DataFiles/private.key", 
                            "changeit", 
                            "DataFiles/INPUT.txt.sig", 
                            asciiArmor);
    }
}
