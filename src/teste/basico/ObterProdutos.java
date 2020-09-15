package teste.basico;

import java.util.List;

import javax.swing.JOptionPane;

import infra.ProdutoDAO;
import modelo.basico.Produto;

public class ObterProdutos {

	public static void main(String[] args) {
		
		ProdutoDAO dao = new ProdutoDAO();
		List<Produto> produtos = dao.obterTodos();
		
		String prods = "";
		for(Produto produto : produtos) {
			System.out.println("ID: " + produto.getId() + ", Nome: " + produto.getNome());
			prods += "ID: " + produto.getId() + ", Nome: " + produto.getNome() + " Preço: R$ " + produto.getPreco() + "\n";
		}
		JOptionPane.showMessageDialog(null, prods, "Lista de produtos", 2);
		
		double precoTotal = produtos.stream().map(p -> p.getPreco()).reduce(0.0, (t, p) -> t + p).doubleValue();
		System.out.println("O valor total é: R$ " + precoTotal);
		
		dao.fechar();
	}
}
