package teste.basico;

import javax.swing.JOptionPane;

import infra.DAO;
import modelo.basico.Produto;

public class NovoProduto {

	public static void main(String[] args) {
		
		String prod = JOptionPane.showInputDialog("Informe o nome do produto: ");
		String precoUser = JOptionPane.showInputDialog("Informe o preço do produto");
		Double preco = Double.parseDouble(precoUser);
		
		Produto produto = new Produto(prod, preco);
		
//		DAO<Produto> dao = new DAO<>(Produto.class);
//		dao.abrirT().incluir(produto).fecharT().fechar();
		
		DAO<Produto> dao = new DAO<>(Produto.class);
		dao.incluirAtomico(produto).fechar();
		
		
		System.out.println("Id do produto: " + produto.getId());
	}
}
