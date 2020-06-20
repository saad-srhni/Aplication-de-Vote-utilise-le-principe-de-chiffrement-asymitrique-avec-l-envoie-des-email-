package openpgp;
import java.io.FileInputStream;
import java.io.InputStream;

import com.didisoft.pgp.PGPLib;

/* Copyright 2012 DidiSoft Ltd. All Rights Reserved.*/
public class DetachedVerifyStream {

	/**
	 * This example demonstrates how to verify a detached OpenPGP signature available as an input Stream.
	 * Using the stream methods we are not limited only to files.
	 */
	public static void main(String[] args) throws Exception {
		PGPLib pgp = new PGPLib();
		
		InputStream dataStream = new FileInputStream("examples/DataFiles/INPUT.txt");
        InputStream senderPublicKeyStream = new FileInputStream("examples/DataFiles/public.key");
        InputStream detachedSignatureStream = new FileInputStream("examples/DataFiles/INPUT.txt.sig");
		
		boolean validSignature = pgp.detachedVerifyStream(dataStream, detachedSignatureStream, senderPublicKeyStream);
		if (validSignature) {
			System.out.println("Signature is valid.");
		} else {
			System.out.println("!Signature is invalid!");
		}
		
		dataStream.close();
		senderPublicKeyStream.close();
		detachedSignatureStream.close();
	}
}
