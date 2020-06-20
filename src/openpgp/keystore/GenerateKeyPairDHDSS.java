package openpgp.keystore;
import com.didisoft.pgp.*;


/**
 * 	This example demonstrates how to generate a 2048/1024 DH/DSS OpenPGP key pair.
 *	The generated key is stored in the KeyStore backing file from where it can be exported.
 *  
 *	If the KeyStore file does not exits, it is created.
 */
public class GenerateKeyPairDHDSS {

	public static void main(String[] args) throws Exception {
		// initialize the KeyStore where the key will be generated
		KeyStore ks = new KeyStore("examples/DataFiles/pgp.keystore", "changeit");
		
		// key primary user Id
		String userId = "demo@didisoft.com";
		
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
		String[] cyphers = new String[] 
		                     {CypherAlgorithm.CAST5,
							  CypherAlgorithm.AES_128,
							  CypherAlgorithm.AES_192,
							  CypherAlgorithm.AES_256,
							  CypherAlgorithm.TWOFISH};
		
		String privateKeyPassword = "changeit";

		int keySizeInBits = 4096;
		ks.setFastElGamalGeneration(true);
		KeyPairInformation key = ks.generateKeyPair(keySizeInBits, 
							userId, 
							KeyAlgorithm.ELGAMAL, 
							privateKeyPassword, 
							compressions, 
							hashingAlgorithms, 
							cyphers);
		
		System.out.println("Generated a " + key.getKeySize() + "/" + key.getEncryptionKeySize() + " bit " + key.getAlgorithm() + " OpenPGP key");
	}
}
