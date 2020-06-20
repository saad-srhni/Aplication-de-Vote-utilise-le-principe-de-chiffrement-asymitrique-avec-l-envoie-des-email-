package openpgp;

import com.didisoft.pgp.HashAlgorithm;
import com.didisoft.pgp.PGPLib;

/*


 * Copyright 2009 DidiSoft Ltd. All Rights Reserved.
 */

/**
 * This example demonstrates how to clear sign a file. 
 */
public class ClearSignFile {
	public static void main(String[] args) throws Exception{
		// create an instance of the library
		PGPLib pgp = new PGPLib();		
		
		// clear sign
		String privateKeyPassword = "changeit";
		pgp.clearSignFile("examples/DataFiles/INPUT.txt", 
		                    "examples/DataFiles/private.key", 
		                    privateKeyPassword, 
		                    HashAlgorithm.SHA256, 
		                    "examples/DataFiles/OUTPUT.sig.txt");
	}

}
