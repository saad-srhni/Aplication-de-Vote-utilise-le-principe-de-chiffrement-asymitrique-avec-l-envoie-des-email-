package openpgp.keystore;
import com.didisoft.pgp.CompressionAlgorithm;
import com.didisoft.pgp.CypherAlgorithm;
import com.didisoft.pgp.HashAlgorithm;
import com.didisoft.pgp.KeyAlgorithm;
import com.didisoft.pgp.KeyPairInformation;
import com.didisoft.pgp.KeyStore;

import java.io.IOException;
import com.didisoft.pgp.*;
import com.didisoft.pgp.exceptions.*;
/**
 * 	Demonstrates how to generate RSA OpenPGP key pair in a KeyStore file.
 * 
 *	If the KeyStore file does not exits, it is created.
 */
public class GenerateKeyPairRSA {

	public static void main(String[] args) throws Exception {
		// initialize the KeyStore where the key will be generated
		KeyStore ks = new KeyStore("/home/saad/eclipse-workspace/ApplicationVote/src/openpgp/DataFiles/pgp.keystore", "changeit");
		
		// key primary user Id
		String userId = "gl.application.de@gmail.com";
		
		// preferred hashing algorithms
		String[] hashingAlgorithms = new String[]
		                             {HashAlgorithm.SHA1,
									  HashAlgorithm.SHA256,
									  HashAlgorithm.SHA384,
									  HashAlgorithm.SHA512,
									  HashAlgorithm.MD5};
		
		// preferred compression algorithms
		String[] compressions = new String[]
		                            {CompressionAlgorithm.ZIP,
									CompressionAlgorithm.ZLIB,
									CompressionAlgorithm.UNCOMPRESSED};
		
		// preferred symmetric key algorithms
		String[] cyphers = new String[] {
		                     CypherAlgorithm.CAST5,
							  CypherAlgorithm.AES_128,
							  CypherAlgorithm.AES_192,
							  CypherAlgorithm.AES_256,
							  CypherAlgorithm.TWOFISH};
		
		String privateKeyPassword = "changeit";
		boolean asciiArmor = false;
		int keySizeInBits = 2048;
		try 
		{
		    KeyPairInformation key = 
		 ks.generateKeyPair(keySizeInBits, 
							userId, 
							KeyAlgorithm.RSA, 
							privateKeyPassword, 
							compressions, 
							hashingAlgorithms, 
							cyphers);
		    
		    KeyPairInformation.SubKey[] subKeys = key.getPrivateSubKeys();
		    System.out.println(subKeys);
		    try {
			    ks.exportPrivateKey("/home/saad/eclipse-workspace/ApplicationVote/src/openpgp/DataFiles/privatekeyde.key", "gl.application.de@gmail.com", asciiArmor);		
		      } catch (NoPrivateKeyFoundException e) {
		        System.out.println("There is no private key in the KeyStore with " +
		                           "the specified User ID");
		      } catch (IOException e) {
		        System.out.println(e.getMessage());
		      }
		} 
		catch (com.didisoft.pgp.PGPException e) 
		{
		    System.out.println(e.getMessage());
		    if (e.getUnderlyingException() != null) {
		        e.getUnderlyingException().printStackTrace();
		    }
		}
	}
}
