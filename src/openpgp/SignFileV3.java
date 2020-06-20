package openpgp;
import com.didisoft.pgp.PGPLib;

/**
 * Demonstrates OpenPGP signing with no encryption.
 * The signature format is in OpenPGP version 3 (supported by PGP 2.x and older systems).
 */
public class SignFileV3 {

	public static void main(String[] args) throws Exception {
		PGPLib pgp = new PGPLib();
		
        boolean armor = false;
		pgp.signFileVersion3("examples/DataFiles/INPUT.txt", 
		                    "examples/DataFiles/private.key", 
		                    "changeit", 
		                    "examples/DataFiles/signed.pgp", armor);
	}

}
