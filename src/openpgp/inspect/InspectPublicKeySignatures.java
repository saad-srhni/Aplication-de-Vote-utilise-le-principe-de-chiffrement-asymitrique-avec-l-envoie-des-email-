package openpgp.inspect;

import com.didisoft.pgp.PGPKeyPair;
import com.didisoft.pgp.exceptions.NoPublicKeyFoundException;

/**
 * This sample illustrates how to list the signatures in an OpenPGP key
 * created by other keys (users) 
 */
public class InspectPublicKeySignatures {

	public static void main(String[] args) throws NoPublicKeyFoundException {
		PGPKeyPair key = new PGPKeyPair("examples/DataFiles/public.key");
		
		long[] signatureIds = key.getSignedWithKeyIds();
		for (int i=0; i < signatureIds.length; i++)
		{
			System.out.println("Signed with key Id: " + signatureIds[i]);
		}

	}

}
