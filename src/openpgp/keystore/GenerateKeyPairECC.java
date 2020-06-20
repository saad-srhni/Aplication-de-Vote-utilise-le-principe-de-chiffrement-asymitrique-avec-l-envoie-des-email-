package openpgp.keystore;
import com.didisoft.pgp.*;


/**
 * 	This example demonstrates how to generate an Elliptic Curve (ECC) OpenPGP key pair.
 *	The generated key is stored in the KeyStore backing file from where it can be exported.
 *  
 *	If the KeyStore file does not exits, it will be created.
 */
public class GenerateKeyPairECC {

	public static void main(String[] args) throws Exception {
		// initialize the KeyStore where the key will be generated
		KeyStore ks = new KeyStore("examples/DataFiles/pgp.keystore", "changeit");
		
		// key primary user Id
		String userId = "<demo@didisoft.com>";
		
		// preferred hashing algorithms
		HashAlgorithm.Enum[] hashingAlgorithms = new HashAlgorithm.Enum[]
		                             {HashAlgorithm.Enum.SHA256,
									HashAlgorithm.Enum.SHA384,
									HashAlgorithm.Enum.SHA512};
		
		// preferred compression algorithms
		CompressionAlgorithm.Enum[] compressions = new CompressionAlgorithm.Enum[] 
		                            {CompressionAlgorithm.Enum.ZIP,
									CompressionAlgorithm.Enum.UNCOMPRESSED};
		
		// preferred symmetric key algorithms
		CypherAlgorithm.Enum[] cyphers = new CypherAlgorithm.Enum[] 
		                     {CypherAlgorithm.Enum.AES_128,
							CypherAlgorithm.Enum.AES_192,
							CypherAlgorithm.Enum.AES_256};
		
		String privateKeyPassword = "changeit";

		EcCurve.Enum masterEcCurve = EcCurve.Enum.NIST_P_521;
		EcCurve.Enum encryptionEcCurve = EcCurve.Enum.NIST_P_521;
		
		int expiresAfterDays = 0; // never expires
		
		KeyPairInformation key = ks.generateEccKeyPair(masterEcCurve,
							encryptionEcCurve,
							userId, 
							privateKeyPassword, 
							compressions, 
							hashingAlgorithms, 
							cyphers,
							expiresAfterDays);
		
		System.out.println("Generated a " + masterEcCurve.toString() + "/" + encryptionEcCurve.toString() + " ECC OpenPGP key");
	}
}
