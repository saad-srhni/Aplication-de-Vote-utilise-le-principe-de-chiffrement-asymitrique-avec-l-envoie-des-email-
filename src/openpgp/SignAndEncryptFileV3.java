package openpgp;
import com.didisoft.pgp.PGPLib;

/**
 * Demonstrates OpenPGP signing and encryption in one pass.
 * The signature format is in OpenPGP version 3 (supported by PGP 2.x and older systems).
 */
public class SignAndEncryptFileV3 {

	public static void main(String[] args) throws Exception {
	    // create an instance of the library
		PGPLib pgp = new PGPLib();

		// should output be ASCII or binary
        boolean asciiArmor = false;
        // should integrity check information be added
        // set to false for compatibility with older versions of PGP such as 6.5.8.
        boolean withIntegrityCheck = false;
        
	/*	pgp.signAndEncryptFileVersion3("/home/saad/eclipse-workspace/ApplicationVote/src/openpgp/DataFiles/INPUT.txt", 
		                                "/home/saad/eclipse-workspace/ApplicationVote/src/openpgp/DataFiles/private.key", 
		                                "changeit", 
		                                "/home/saad/eclipse-workspace/ApplicationVote/src/openpgp/DataFiles/public.key", 
		                                "/home/saad/eclipse-workspace/ApplicationVote/msgstore/encrypted.pgp", 
		                                asciiArmor, 
		                                withIntegrityCheck);*/
		
		String prv="privkeyco.asc";
		String pub="pubkeyvotant.asc";
		String f="co/votantidenco";
		String d="OUTPUT.txt";
		DecryptVerifFile v=new DecryptVerifFile();
		if(v.drcryptefile(prv, pub, f, d))System.out.println("hhhh");
		else System.out.println("hohoho");
	}

}
