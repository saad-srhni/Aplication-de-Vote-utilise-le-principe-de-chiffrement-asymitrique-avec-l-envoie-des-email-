package com.de.app;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.dao.app.DeVotant;
import com.dao.app.FonctionBd;

import openpgp.DecryptVerifFile;
import openpgp.ReadFile;
import openpgp.mail.ReceiveEncryptedMail;

/**
 * Servlet implementation class De
 */
public class De extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public De() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ReceiveEncryptedMail rec = new ReceiveEncryptedMail();
		FonctionBd bd = new FonctionBd();

		try { // il faut active imap f gmail
			rec.receiveEmail("imap.gmail.com", "gl.application.de@gmail.com", "985632de",
					"C:/Users/saad1/Desktop/project-chffrement/msgstore/de", 4);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println("hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh");
		DecryptVerifFile dcryptfile = new DecryptVerifFile();
		try {
			if (dcryptfile.drcryptefile("privkeyde.asc", "pubkeyvotant.asc", "de/votantidende", "de/votantidendcryde")
					
					&& dcryptfile.drcryptefile("privkeyde.asc", "pubkeyvotant.asc", "de/votantresde",
							"de/votantresdcryde")
					
					&& dcryptfile.drcryptefile("privkeyde.asc", "pubkeyco.asc", "de/votantidenco",
							"de/votantidendcryco")
					
					&& dcryptfile.drcryptefile("privkeyde.asc", "pubkeyco.asc", "de/votantresco", "de/votantresdcryco1")
					
					&& dcryptfile.drcryptefile("privkeyde.asc", "pubkeyvotant.asc", "de/votantresdcryco1",
							"de/votantresdcryco2")) {

				System.out.println("hhaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaah");
				ReadFile readfile = new ReadFile();
				String msg1 = readfile
						.readfile("C:/Users/saad1/Desktop/project-chffrement/msgstore/de/votantidendcryde");
				String msg2 = readfile
						.readfile("C:/Users/saad1/Desktop/project-chffrement/msgstore/de/votantresdcryde");
				String msg3 = readfile
						.readfile("C:/Users/saad1/Desktop/project-chffrement/msgstore/de/votantidendcryco");
				String msg4 = readfile
						.readfile("C:/Users/saad1/Desktop/project-chffrement/msgstore/de/votantresdcryco2");
				String donne1[] = msg1.split(";;");
				String donne2[] = msg2.split(";;");
				String donne3[] = msg3.split(";;");
				String donne4[] = msg4.split(";;");
				if (donne1[1].compareTo(donne3[1]) == 0 && donne2[1].compareTo(donne4[1]) == 0) {
					DeVotant devotant = new DeVotant(donne1[3], donne1[2], donne1[4], donne1[1], donne2[2]);
					bd.setDeVotant(devotant);
				}
			} else
				System.out.println("signature non valide");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Collection<DeVotant> devotants = bd.getAllDe();
		request.setAttribute("devotants", devotants);
		getServletContext().getRequestDispatcher("/WEB-INF/de.jsp").forward(request, response);

	}

}
