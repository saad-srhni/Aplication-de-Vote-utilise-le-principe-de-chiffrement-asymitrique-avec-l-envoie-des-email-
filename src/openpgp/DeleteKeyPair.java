
package openpgp;
import com.didisoft.pgp.KeyStore;

/**
 * This example demonstrates how to delete a key pair from a KeyStore.
 */
public class DeleteKeyPair {
	public static void main(String[] args) throws Exception{
		// initialize the KeyStore instance
		KeyStore ks = new KeyStore("DataFiles/pgp.keystore", "changeit");

		// delete a key pair
		ks.deleteKeyPair("test@gmail.com");
		
		// delete a public key
		ks.deletePublicKey("test@gmail.com");
		
		// delete a private key
		ks.deletePrivateKey("test@gmail.com");		
	}
}
