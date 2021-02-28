package openpgp;

import com.didisoft.pgp.PGPLib;

public class DecryptVerifFile {
	public Boolean drcryptefile(String privkey,String pubkey,String filedcry,String output) throws Exception{
		// initialize the library instance
		PGPLib pgp = new PGPLib();
		//bdlo had les lien
		String privateKeyFile = "C:/Users/saad1/Desktop/project-chffrement/src/openpgp/DataFiles/"+privkey;
		String privateKeyPass = "985632";

		@SuppressWarnings("deprecation")
		boolean validSignature = 
			pgp.decryptAndVerifyFile("C:/Users/saad1/Desktop/project-chffrement/msgstore/"+filedcry, 
									privateKeyFile, 
									privateKeyPass, 
									"C:/Users/saad1/Desktop/project-chffrement/src/openpgp/DataFiles/"+pubkey, 
									"C:/Users/saad1/Desktop/project-chffrement/msgstore/"+output);
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
