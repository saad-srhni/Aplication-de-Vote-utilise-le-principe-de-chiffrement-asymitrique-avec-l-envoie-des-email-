package com.votant.app;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import openpgp.mail.SendEncryptedMail;
import openpgp.mail.SubjectType;

/**
 * Servlet implementation class Votant
 */
public class Votant extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Votant() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/WEB-INF/votant.jsp").forward(request, response);

	}
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String datenaissance = request.getParameter("datenaissance");
		String iden = request.getParameter("identification");
		String bulltinvote = request.getParameter("bulltinvote");
		if (nom != null && prenom != null && datenaissance != null && iden != null && bulltinvote != null) {
			try {

				SendEncryptedMail send = new SendEncryptedMail();
				if (send.Send(SubjectType.votantiden.toString() + "co",             // hnaya ktbo email votant  co de et pass
						";;" + iden + ";;" + prenom + ";;" + nom + ";;" + datenaissance+";;", "gl.vontant@gmail.com",
						
						"985632votant", "gl.application.co@gmail.com", "privkeyvotant.asc", "pubkeyco.asc")
						
						&& send.Send(SubjectType.votantres.toString() + "co", ";;"+iden+";;" + bulltinvote + ";;",
								
								"gl.vontant@gmail.com", "985632votant", "gl.application.co@gmail.com",
								
								"privkeyvotant.asc", "pubkeyde.asc")
						
						&& send.Send(SubjectType.votantiden.toString() + "de",
								
								";;" + iden + ";;" + prenom + ";;" + nom + ";;" + datenaissance+";;", "gl.vontant@gmail.com",
								
								"985632votant", "gl.application.de@gmail.com", "privkeyvotant.asc", "pubkeyde.asc")
						
						&& send.Send(SubjectType.votantres.toString() + "de",";;"+iden+ ";;" + bulltinvote + ";;",
								
								"gl.vontant@gmail.com", "985632votant", "gl.application.de@gmail.com",
								
								"privkeyvotant.asc", "pubkeyde.asc")

				)
					System.out.println("send success");

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			getServletContext().getRequestDispatcher("/WEB-INF/votant.jsp").forward(request, response);
		} else {
			String err = "verifier les champs";
			request.setAttribute("err", err);
			getServletContext().getRequestDispatcher("/WEB-INF/votant.jsp").forward(request, response);
		}

	}

}
