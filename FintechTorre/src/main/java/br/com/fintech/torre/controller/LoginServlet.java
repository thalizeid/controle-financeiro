package br.com.fintech.torre.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.fintech.torre.bean.Pessoa;
import br.com.fintech.torre.bo.EmailBO;
import br.com.fintech.torre.dao.PessoaDAO;
import br.com.fintech.torre.exception.EmailException;
import br.com.fintech.torre.factory.DAOFactory;
import br.com.fintech.torre.util.CriptografiaUtils;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private PessoaDAO dao;
	private EmailBO bo;
	
	public LoginServlet() {
		dao = DAOFactory.getPessoaDAO();
		bo = new EmailBO();
	} 
       


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.invalidate();
		request.getRequestDispatcher("home.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String email = request.getParameter("email");
			String senha = "";
			
//			System.out.println("Login: " + email + " / senha:" + request.getParameter("senha"));
			
			try
			{
			 senha = CriptografiaUtils.criptografar( request.getParameter("senha"));
			}
			catch(Exception ex)
			{
				System.out.println("Erro so criptogrsfsr senha");
			}
			
//			System.out.println("After Login: " + email + " / senha: " + senha);
		
			Pessoa pessoa = new Pessoa(email, senha);
			
			if (dao.validarPessoa(pessoa)) {
				HttpSession session = request.getSession();
				session.setAttribute("user", email);
					String mensagem = "Login Realizado";
				try {
					bo.enviarEmail(email, "Login Realizado!!", mensagem);
				} catch (EmailException e) {
					e.printStackTrace();
				}
			}else {
				request.setAttribute("erro", "Usuário e/ou senha inválidos");
			}
			request.getRequestDispatcher("home.jsp").forward(request, response);
		}
	}


