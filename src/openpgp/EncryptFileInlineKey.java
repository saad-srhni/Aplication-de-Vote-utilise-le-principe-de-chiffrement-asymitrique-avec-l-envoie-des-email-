package openpgp;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

import com.didisoft.pgp.PGPLib;

/**
 * This example shows how to encrypt a Stream of data
 * with a public key supplied as an ASCII armored String.
 * Later the private key also available as an ASCII armored String is used to decrypt the data.
 * 
 * The purpose of the example is to show how to use keys that are available as Strings.  
 */
public class EncryptFileInlineKey {
    private static String lineSeparator = "\r";//System.getProperty("line.separator");

    static final String PublicKey = "-----BEGIN PGP PUBLIC KEY BLOCK-----" +lineSeparator+ 
    		"Version: BCPG v1.32" +lineSeparator+ 
    		lineSeparator+ 
    		"mE0ES3lSEAECALGhNV8Cz0qPpY9BlxlOqJt7lm5TWamDSmlhsum0CWBjT8cC6xbL" +lineSeparator+ 
    		"rdu+PYxoyVPm8qwtOM/FyHirgbcU8oJ4Qv0AEQEAAbQgRXhhbXBsZSBLZXkgc3Vw" +lineSeparator+ 
    		"cG9ydEBkaWRpc29mdC5jb22IXAQQAQIABgUCS3lSEAAKCRCcBmO3JruTcGpzAf0W" +lineSeparator+ 
    		"TxR9YLx70GJDnDsmd5AhAXsDWOEQy5wy6uVeBQb/r8T31EG1X8HGaPqk1L8v+F5t" +lineSeparator+ 
    		"0tAwxslU/69HrtUb7nrz" +lineSeparator+ 
    		"=lbSa" +lineSeparator+ 
    		"-----END PGP PUBLIC KEY BLOCK-----" +lineSeparator;

    static final String PrivateKey = "-----BEGIN PGP PRIVATE KEY BLOCK-----" +lineSeparator+ 
    		"Version: BCPG v1.32" +lineSeparator+ 
    		lineSeparator+ 
    		"lQEMBEt5UhABAgCxoTVfAs9Kj6WPQZcZTqibe5ZuU1mpg0ppYbLptAlgY0/HAusW" +lineSeparator+ 
    		"y63bvj2MaMlT5vKsLTjPxch4q4G3FPKCeEL9ABEBAAH/AwMCCzy66u6KYJ9gEcW1" +lineSeparator+ 
    		"A9ICOX5aUcJoOZsxPtwhby/omKthBpN1djV0on5tBdghYthIQin77r86AYGvVv34" +lineSeparator+ 
    		"ozMRv2llagXZkMf1wJtreUMoAm/LCZlp9rAmiLY3aynlpDHnr5Q6ey6s2EphXQF2" +lineSeparator+ 
    		"BbDf8ZVWMBMb8Ej8JxWq+3OEr7iTO80LHnM+/LlU1wSZC4l3aRsgL94fLnzlCsd1" +lineSeparator+ 
    		"qNjfdPb4TGoWkFh1UeMfJWXSdWSbg7qXgxmpOu5ewLQgRXhhbXBsZSBLZXkgc3Vw" +lineSeparator+ 
    		"cG9ydEBkaWRpc29mdC5jb22IXAQQAQIABgUCS3lSEAAKCRCcBmO3JruTcGpzAf0W" +lineSeparator+ 
    		"TxR9YLx70GJDnDsmd5AhAXsDWOEQy5wy6uVeBQb/r8T31EG1X8HGaPqk1L8v+F5t" +lineSeparator+ 
    		"0tAwxslU/69HrtUb7nrz" +lineSeparator+ 
    		"=oevA" +lineSeparator+ 
    		"-----END PGP PRIVATE KEY BLOCK-----";
    
	public static void main(String[] args) throws Exception {
        PGPLib pgp = new PGPLib();

        File file = new File("examples/DataFiles/INPUT.txt");
        InputStream fileContents = new FileInputStream(file);
        
        // if true the output file will be in ASCII armored format, 
        // otherwise will be in binary format
        boolean asciiArmor = true;
        // if true additional integrity check information is added
        // set to false for compatibility with older versions of PGP such as 6.5.8.
        boolean withIntegrityCheck = false;

        ByteArrayOutputStream encryptedStream = new ByteArrayOutputStream(1024*1024);
        pgp.encryptStream(fileContents,
                        file.getName(),
                        new ByteArrayInputStream(PublicKey.getBytes("ASCII")),
                        encryptedStream,
                        asciiArmor,
                        withIntegrityCheck);
        
        ByteArrayOutputStream decryptedStream = new ByteArrayOutputStream(1024*1024);
        String privateKeyPassword = "changeit";
        pgp.decryptStream(new ByteArrayInputStream(encryptedStream.toByteArray()), 
                        new ByteArrayInputStream(PrivateKey.getBytes("ASCII")), 
                        privateKeyPassword, 
                        decryptedStream);        
	}
}