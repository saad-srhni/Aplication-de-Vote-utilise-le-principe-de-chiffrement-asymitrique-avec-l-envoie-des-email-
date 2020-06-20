package openpgp;
import com.didisoft.pgp.PGPLib;

/**
 * Demonstrates OpenPGP signing and encryption in one pass.
 */
public class SignAndEncryptFile {
	public static void main(String[] args) throws Exception{
		// create an instance of the library
		PGPLib pgp = new PGPLib();
		
		// should output be ASCII or binary
        boolean asciiArmor = false;
        // should integrity check information be added
        // set to false for compatibility with older versions of PGP such as 6.5.8.
        boolean withIntegrityCheck = false;
        
        // sign and encrypt
		pgp.signAndEncryptFile("E:/Master GENIE LOGICIEL POUR LE CLOUD/JEE/tp/VOTE ELECTRONIQUE/src/openpgp/DataFiles/INPUT.txt", 
								"E:/Master GENIE LOGICIEL POUR LE CLOUD/JEE/tp/VOTE ELECTRONIQUE/src/openpgp/DataFiles/private.key", 
								"changeit",
								"E:/Master GENIE LOGICIEL POUR LE CLOUD/JEE/tp/VOTE ELECTRONIQUE/src/openpgp/DataFiles/public.key",
								"E:/Master GENIE LOGICIEL POUR LE CLOUD/JEE/tp/VOTE ELECTRONIQUE/src/openpgp/DataFiles/encrypted.pgp", 
								asciiArmor,
								withIntegrityCheck);
	}
}
