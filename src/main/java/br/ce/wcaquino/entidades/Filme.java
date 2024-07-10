package br.ce.wcaquino.entidades;

public class Filme {
	private int estoque;
	private int aluguel;
	private int preco;

	public void setEstoque(Integer int1) {
		this.estoque = int1;

	}

	public void setAluguel(Integer int1) {
		this.aluguel = int1;
	}

	public int getAluguel() {
		return aluguel;
	}

	public int getEstoque() {
		return estoque;
	}

	public int getPreco() {
		return preco;
	}

	public void setPreco(int preco) {
		this.preco = preco;
	}

}
