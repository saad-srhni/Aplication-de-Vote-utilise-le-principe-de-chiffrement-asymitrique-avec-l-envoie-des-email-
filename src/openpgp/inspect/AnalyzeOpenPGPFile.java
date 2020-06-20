/*
 * Copyright 2012 DidiSoft Ltd. All Rights Reserved.
 */
package openpgp.inspect;

import java.io.IOException;

import com.didisoft.pgp.KeyPairInformation;
import com.didisoft.pgp.PGPException;
import com.didisoft.pgp.PGPLib;
import com.didisoft.pgp.inspect.PGPInspectLib;

/**
 * Illustrates how to analyze an OpenPGP encrypt file
 * 
 * Check also:
 * http://www.didisoft.com/java-openpgp/examples/inspect-the-contents-of-an-openpgp-archive/
 */
public class AnalyzeOpenPGPFile {

    public static void main(String[] args) throws IOException, PGPException {
        
        String openpgpFile = "examples/DataFiles/encrypted.pgp";

        // create an instance of the main library which we shall use for data extraction
        PGPLib pgp = new PGPLib();        
        boolean asciiArmor = true;                
        pgp.encryptFile("examples/DataFiles/INPUT.txt", 
                        "examples/DataFiles/public.key", 
                        openpgpFile, 
                        asciiArmor);
                
        // create an instance of the inspection library 
        PGPInspectLib inspect = new PGPInspectLib();
        
        // check is this a signed only archive
        if (inspect.isSignedOnly(openpgpFile)) {
            // inspect the which key ID's have signed it
            long[] signingKeyIds = inspect.listSigningKeyIds(openpgpFile);            
            for (int i=0; i<signingKeyIds.length; i++) {
                System.out.println("Signed with Key ID : " + KeyPairInformation.keyId2Hex(signingKeyIds[i]));
            }
            
            // We can now call one of the pgp.verify methods to extract the data            
        } // check is this a key encrypted archive 
        else if (inspect.isPublicKeyEncrypted(openpgpFile)) {
            // inspect the which key ID's have encrypted it
            long[] encryptionKeyIds = inspect.listEncryptionKeyIds(openpgpFile);
            for (int i=0; i<encryptionKeyIds.length; i++) {
                System.out.println("Encrypted with Key ID : " + KeyPairInformation.keyId2Hex(encryptionKeyIds[i]));
            }
            
            String privateKeyFileName = "examples/DataFiles/private.key";
            String privateKeyPassword = "changeit";
            
            // inspect the which key ID's have signed it
            long[] signingKeyIds = inspect.listSigningKeyIds(openpgpFile, privateKeyFileName, privateKeyPassword);
            if (signingKeyIds.length > 0) {
                // this is a signed and encrypted archive
                for (int i=0; i<signingKeyIds.length; i++) {
                    System.out.println("Signed with Key ID : " + KeyPairInformation.keyId2Hex(signingKeyIds[i]));
                }                
                // We can call one of the pgp.decryptAndVerify methods to extract the data 
            } else {
             // this is an encrypted only archive
             // We can call one of the pgp.decrypt methods to extract the data
            }
        } // check is this a password encrypted (PBE) archive
        else if (inspect.isPBEEncrypted(openpgpFile)) {
            // We can call pgp.decryptFilePBE to extract the data
        } else {
            // other unknown OpenPGP archive
            // we must probably log an error 
        }        
    }
}
