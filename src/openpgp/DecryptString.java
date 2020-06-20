package openpgp;
import com.didisoft.pgp.PGPLib;

public class DecryptString {
	public static void main(String[] args) throws Exception{
		// initialize the library instance
		PGPLib pgp = new PGPLib();
		
		String publicKeyFile = "DataFiles/public.key";
		
		String encryptedString = pgp.encryptString("Hello World", publicKeyFile);
		
		String privateKeyFile = "DataFiles/private.key";
		String privateKeyPass = "changeit";		
		
		String decryptedString = pgp.decryptString(encryptedString, 
		                                        privateKeyFile, 
												privateKeyPass);
	}
}
