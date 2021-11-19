package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pessoa;

public class Programa {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("cat-jpa");
		EntityManager em = emf.createEntityManager();

		Pessoa p = em.find(Pessoa.class, 2); //Busca um objeto no banco de dados utilizando o Id
		System.out.println(p);
		
		em.getTransaction().begin(); //Inicia a transação com 
		em.remove(p); 
		em.getTransaction().commit();
		
		System.out.println("Pronto");
		em.close();
		emf.close();
	}

}
