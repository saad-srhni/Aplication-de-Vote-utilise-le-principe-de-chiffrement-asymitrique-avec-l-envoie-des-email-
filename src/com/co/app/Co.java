package com.co.app;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.app.CoVotant;
import com.dao.app.FonctionBd;


import openpgp.DecryptVerifFile;
import openpgp.ReadFile;
import openpgp.mail.ReceiveEncryptedMail;
import openpgp.mail.SendEncryptedMail;
import openpgp.mail.SubjectType;

/**
 * Servlet implementation class Co
 */
public class Co extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Co() {
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
		try {
			rec.receiveEmail("imap.gmail.com", "gl.application.co@gmail.com", "985632co",
					"C:/Users/saad1/Desktop/project-chffrement/msgstore/co", 2);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		DecryptVerifFile dcryptfile = new DecryptVerifFile();
		try {
			if (dcryptfile.drcryptefile("privkeyco.asc", "pubkeyvotant.asc", "co/votantidenco",
					"co/votantidendcryco")==true) {

				ReadFile readfile = new ReadFile();
				String msg1 = readfile
						.readfile("C:/Users/saad1/Desktop/project-chffrement/msgstore/co/votantidendcryco");
				String msg2 = readfile.readfile("C:/Users/saad1/Desktop/project-chffrement/msgstore/co/votantresco");
				String nom = null, prenom = null, datenaissance = null, identification = null, bulltinvote = null;
				String donne[] = msg1.split(";;");
				identification = donne[1];
				prenom = donne[2];
				nom = donne[3];
				datenaissance = donne[4];
				bulltinvote = msg2;

				CoVotant covotant = new CoVotant(nom, prenom, datenaissance, identification, bulltinvote);
				System.out.println(covotant.getNom() + covotant.getPrenom() + covotant.getIdentification() + "---");
				if (bd.setCoVotant(covotant) == true) {
					System.out.println("aaa");
					SendEncryptedMail send = new SendEncryptedMail();
					send.Send(SubjectType.votantiden.toString() + "co",
							";;" + covotant.getIdentification() + ";;" + covotant.getPrenom() + ";;" + covotant.getNom()
									+ ";;" + covotant.getDatenaissance() + ";;",
							"gl.application.co@gmail.com", "985632co", "gl.application.de@gmail.com", "privkeyco.asc",
							"pubkeyde.asc");
					send.Send(SubjectType.votantres.toString() + "co", covotant.getBulltinvote(),
							"gl.application.co@gmail.com", "985632co", "gl.application.de@gmail.com", "privkeyco.asc",
							"pubkeyde.asc");
				} else {
					String err = "un votant est deja voter" + covotant.getIdentification();
					request.setAttribute("err", err);
				}

			} else
				System.out.println("signature non valide");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Collection<CoVotant> covotants = bd.getAllCo();
		request.setAttribute("covotants", covotants);
		getServletContext().getRequestDispatcher("/WEB-INF/co.jsp").forward(request, response);

	}
}
