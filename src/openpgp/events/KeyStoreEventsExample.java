package openpgp.events;

import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import com.didisoft.pgp.KeyStore;
import com.didisoft.pgp.events.IKeyStoreSaveListener;
import com.didisoft.pgp.events.IKeyStoreSearchListener;

/**
 * Example class that demonstrates how to attach event listeners to the com.didisoft.pgp.KeyStore class 
 */
public class KeyStoreEventsExample {

	public static void main(String[] args) throws Exception {
    	KeyStore ks = new KeyStore();
    	//
    	// Save event listener
    	//
    	ks.addSaveListener(new IKeyStoreSaveListener() {		    		
    		private int backupCounter = 0;
    		
			public void onSave(KeyStore keyStore) {				
				try {
					System.out.println("On save event");
					FileOutputStream fOut = new FileOutputStream("mybackup"+ backupCounter +".keystore");
					backupCounter++;
					keyStore.saveToStream(fOut);
					if (fOut != null) fOut.close();					
				} catch (java.io.IOException e) {}
			}
		});
    	ks.generateRsaKeyPair(1024, "sample user id", "sample password");
    	
    	//
    	// Key search operation
    	//
    	ks.addSearchListener(new IKeyStoreSearchListener() {			
			public void onKeyNotFound(KeyStore keyStore, boolean isPublic, long keyId,
					String keyIdHex, String userId) {
				
				if (isPublic) {
					System.out.println("Searching for a non existent public key ");
				} else {
					System.out.println("Searching for a non existent private key ");
				}
				
				// Here we'll try to find the key in a public HTTP based OpenPGP key server
				try {
					byte[] keyBytes = {};
					com.didisoft.pgp.net.HKPClient hkp = new com.didisoft.pgp.net.HKPClient("pgp.mit.edu");
					if (userId != null && userId.length() > 0) {
						keyBytes = hkp.getKeyByUserId(userId);
					} else {
						System.out.println("Searching Key Id (hex) " + keyIdHex);					
						keyBytes = hkp.getKeyByKeyIdHex(keyIdHex);
					}
					
					// if a key was found try to recover by importing it into the KeyStore
					if (keyBytes.length > 0) {
						keyStore.importKeyRing(new ByteArrayInputStream(keyBytes));
					}
				} catch (IOException e) {
					// log
				} catch (com.didisoft.pgp.PGPException e) {
					// error importing the key 					
				}
			}
		});
    	
    	ks.exportKeyRing("tempfile.txt", "non existent user id");
	}
}
