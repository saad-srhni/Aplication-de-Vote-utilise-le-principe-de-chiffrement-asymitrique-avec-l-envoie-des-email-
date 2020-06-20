package openpgp.keystore;


import com.didisoft.pgp.KeyStore;

/**
 * This example demonstrates how to change a private key password.
 */
public class ChangePrivateKeyPassword {
	public static void main(String[] args) throws Exception{
		// initialize the KeyStore instance
		KeyStore ks = new KeyStore("examples/DataFiles/pgp.keystore", "changeit");
		
		// change secret key password
		String keyUserId = "demo@didisoft.com";
		String oldPassword = "changeit";
		String newPassword = "new_private_key_password";
		ks.changePrivateKeyPassword(keyUserId, oldPassword, newPassword);
	}
}
