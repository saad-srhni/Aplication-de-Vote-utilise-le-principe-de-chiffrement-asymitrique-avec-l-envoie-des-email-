package openpgp;

import com.didisoft.pgp.PGPLib;

public class DecryptVerifFile {
	public Boolean drcryptefile(String privkey,String pubkey,String filedcry,String output) throws Exception{
		// initialize the library instance
		PGPLib pgp = new PGPLib();
		//bdlo had les lien
		String privateKeyFile = "C:/Users/SAAD/Desktop/ApplicationVote/src/openpgp/DataFiles/"+privkey;
		String privateKeyPass = "985632";

		@SuppressWarnings("deprecation")
		boolean validSignature = 
			pgp.decryptAndVerifyFile("C:/Users/SAAD/Desktop/ApplicationVote/msgstore/"+filedcry, 
									privateKeyFile, 
									privateKeyPass, 
									"C:/Users/SAAD/Desktop/ApplicationVote/src/openpgp/DataFiles/"+pubkey, 
									"C:/Users/SAAD/Desktop/ApplicationVote/msgstore/"+output);
		if (validSignature) {
			return true;
		} else {
			return false;
		}
		
		
		
	}
	
	// had les lien kolhom bdlouhm 3la 7assab votre pc 
	

	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}*/
}
