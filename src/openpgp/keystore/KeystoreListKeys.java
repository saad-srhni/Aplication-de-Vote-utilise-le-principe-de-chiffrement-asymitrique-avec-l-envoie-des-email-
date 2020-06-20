package openpgp.keystore;
/*
 * Copyright 2008 DidiSoft Ltd. All Rights Reserved.
 */
import java.text.SimpleDateFormat;

import com.didisoft.pgp.KeyPairInformation;
import com.didisoft.pgp.KeyStore;

/**
 * Demonstrates how to observe the keys contained in an OpenPGP key store.
 */
public class KeystoreListKeys {
	public static void main(String[] args) throws Exception{
		
		KeyStore keyStore = new KeyStore("examples/DataFiles/pgp.keystore", "changeit");		

        System.out.print(padRight("Type", 8));
        System.out.print(padRight("Bits", 10));
        System.out.print(padRight("Key ID", 9));
        System.out.print(padRight("Date", 11));
        System.out.println("User ID");
		
		KeyPairInformation[] keys = keyStore.getKeys();
		for (int i=0; i < keys.length; i++) {
            KeyPairInformation pair = keys[i];            
            System.out.print(padRight(pair.getAlgorithm(), 8));
            System.out.print(padRight(String.valueOf(pair.getKeySize()), 10));
            System.out.print(padRight(pair.getKeyIDHex(), 9));
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            System.out.print(padRight(dateFormat.format(pair.getCreationTime()), 11));

	            for (int j=0; j < pair.getUserIDs().length; j++) {
	                System.out.print(pair.getUserIDs()[j]);
	            }           
	            
	            System.out.println();
			if (pair.isEncryptionKey()) {
			  System.out.print(" (Encryption Key)");
			}
			if (pair.isRevoked()) {			
				System.out.print(" (Revoked)");
			}
			
			System.out.println();
		}		
	}
	
    private static String padRight(String s, int n) {
        StringBuffer sb = new StringBuffer();
        sb.append(s);
        if (s.length() < n) {
            for (int i=0; i < (n-s.length()); i++)  {
                sb.append(' ');
            }
        }
        
        return sb.toString();
    }
}
