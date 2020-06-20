package openpgp;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import com.didisoft.pgp.PGPLib;

/* Copyright 2008 DidiSoft Ltd. All Rights Reserved.*/
public class VerifyStream {

	/**
	 * This example demonstrates how to verify a signed stream with the library API.
	 * Using the stream methods we are not limited only to files.
	 */
	public static void main(String[] args) throws Exception {
		PGPLib pgp = new PGPLib();
		
		InputStream signedStream = new FileInputStream("examples/DataFiles/signed.pgp");
        InputStream senderPublicKeyStream = new FileInputStream("examples/DataFiles/public.key");
        OutputStream outputStream = new FileOutputStream("examples/DataFiles/OUTPUT.txt");
		
		boolean validSignature = pgp.verifyStream(signedStream, senderPublicKeyStream, outputStream);
		if (validSignature) {
			System.out.println("Signature is valid.");
		} else {
			System.out.println("!Signature is invalid!");
		}
		
		signedStream.close();
		senderPublicKeyStream.close();
		outputStream.close();
	}
}
