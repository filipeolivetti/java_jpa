package br.com.alura.jpa.testes;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;
import br.com.alura.jpa.modelo.Movimentacao;
import br.com.alura.jpa.modelo.TipoMovimentacao;

public class TestaRelacionamento {

	public static void main(String[] args) {
		
		//Cria Conta
		Conta conta = new Conta();
		conta.setAgencia(12341);
		conta.setNumero(545454);
		conta.setSaldo(500.0);
		conta.setTitular("Leonardo");
		
		//Criar movimentação
		Movimentacao movimentacao = new Movimentacao();
		movimentacao.setData(LocalDateTime.now());
		movimentacao.setDescricao("Churrascaria");
		movimentacao.setValor(new BigDecimal(200.0));
		movimentacao.setTipoMovimentacao(TipoMovimentacao.ENTRADA);
		movimentacao.setConta(conta);
		
		
		//Criar o EntityManager
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();
		
		
		//Realiza a transação
		em.getTransaction().begin();
		em.persist(conta);
		em.persist(movimentacao);		
		em.getTransaction().commit();
		em.close();
		
		
	}

}
