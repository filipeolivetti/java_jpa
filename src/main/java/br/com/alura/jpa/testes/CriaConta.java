package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;

public class CriaConta {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();
		
		Conta conta = new Conta();
		
		conta.setTitular("filipe");
		conta.setAgencia(8020);
		conta.setNumero(1234);
		
		em.getTransaction().begin();
		em.persist(conta);
		em.getTransaction().commit();		

	}

}
