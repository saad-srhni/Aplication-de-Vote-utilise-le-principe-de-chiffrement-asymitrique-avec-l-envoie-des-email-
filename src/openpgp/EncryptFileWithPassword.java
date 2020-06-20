package openpgp;
import com.didisoft.pgp.PGPLib;

/** 
 * This example demonstrates how to encrypt a file with both
 * the public key of the recipient and an additional password.
 * 
 * The additional password can be used lately to decrypt the file
 * (for example if the private decryption key has been lost) 
 */
public class EncryptFileWithPassword {
	public static void main(String[] args) throws Exception{
		// create instance of the library
		PGPLib pgp = new PGPLib();
		
		// if true the output file will be in ascii armored format, 
		// otherwise will be in binary format
        boolean asciiArmor = true;
        // if true additional integrity check information is added
        // set to false for compatibility with older versions of PGP such as 6.5.8.
        boolean withIntegrityCheck = true;
                
        // Additional password that can be used if the recipient has lost the decryption (private) key
        String additionalPassword = "extra password";
        
        pgp.encryptFilePBE("examples/DataFiles/INPUT.txt", 
        				"examples/DataFiles/public.key",
        				additionalPassword,
        				"examples/DataFiles/encrypted.pgp",         				
        				asciiArmor, 
        				withIntegrityCheck);
	}
}
