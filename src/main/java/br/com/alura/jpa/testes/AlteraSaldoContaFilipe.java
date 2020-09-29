package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;

public class AlteraSaldoContaFilipe {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();
		
		Conta contaFilipe = em.find(Conta.class, 1L);
		System.out.println("Conta do : "+ contaFilipe.getTitular());
		
		em.getTransaction().begin();
		
		contaFilipe.setSaldo(300.0);
		em.getTransaction().commit();

	}

}
