package openpgp.keystore;
import com.didisoft.pgp.*;

/**
 * This example shows how to generate an OpenPGP key pair
 * in a PGPKeyPair object that can be exported afterwards in a file.
 * <br>
 * 
 * This example is similar to the one with the KeyStore except here we do not use a KeyStore. 
 */
public class GenerateKeyPairInFile {

    public static void main(String[] args) throws Exception {
        // key primary user Id
        String userId = "demo2@didisoft.com";
            
        // preferred hashing algorithms
        String[] hashingAlgorithms = new String[]
                                  {HashAlgorithm.SHA1,
                                   HashAlgorithm.SHA256,
                                   HashAlgorithm.SHA384,
                                   HashAlgorithm.SHA512,
                                   HashAlgorithm.MD5};
     
        // preferred compression algorithms
        String[] compressions = new String[]
                                 {CompressionAlgorithm.ZIP,
                                 CompressionAlgorithm.ZLIB,
                                 CompressionAlgorithm.UNCOMPRESSED};
     
        // preferred symmetric key algorithms
        String[] cyphers = new String[]
                                      {CypherAlgorithm.CAST5,
                           CypherAlgorithm.AES_128,
                           CypherAlgorithm.AES_192,
                           CypherAlgorithm.AES_256,
                           CypherAlgorithm.TWOFISH};
     
        String privateKeyPassword = "changeit";
     
        // the key will be valid for 1 year
        long keyExpiresAfter = 365; 
     
        int keySizeInBits = 2048;
        KeyPairInformation key = PGPKeyPair.generateKeyPair(keySizeInBits, 
                                                  userId, 
                                                  KeyAlgorithm.RSA, 
                                                  privateKeyPassword, 
                                                  compressions, 
                                                  hashingAlgorithms, 
                                                  cyphers,
                                                  keyExpiresAfter);
                                                  
        // we can call key.export ... in order to save the generated key in a file                                                 
        key.exportPublicKey("examples/DataFiles/key.asc",true);
    }

}
