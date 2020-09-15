package teste.basico;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.swing.JOptionPane;

import modelo.basico.Usuario;

public class ObterUsuarios {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicios-jpa");
		EntityManager em = emf.createEntityManager();
		
		String jpql = "select u from Usuario u";
		TypedQuery<Usuario> query = em.createQuery(jpql, Usuario.class);
		query.setMaxResults(5);
		
		List<Usuario> usuarios = query.getResultList();
		
		
		String user = "";
		String id = "";
		for(Usuario usuario: usuarios) {
			System.out.println("ID: " + usuario.getId() + " E-mail: " + usuario.getEmail());
			//JOptionPane.showMessageDialog(null, "ID " + usuario.getId() + " E-mail " + usuario.getEmail(), "Usuários", 2);
			user += "ID: " + usuario.getId() + " E-mail: " + usuario.getEmail() + "\n";
			
		}
		JOptionPane.showMessageDialog(null, id + user);
		
		em.close();
		emf.close();
	}
}
