package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;

public class CriaContaComSaldo {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();
		
		Conta conta = new Conta();
		
		conta.setTitular("Roberto");
		conta.setAgencia(82021);
		conta.setNumero(11235);
		conta.setSaldo(560.0);
		
		em.getTransaction().begin();
		em.persist(conta);
		em.getTransaction().commit();

	}

}
