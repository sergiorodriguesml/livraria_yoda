package livraria.livro;

public class Livro implements java.io.Serializable {
	private int Id;
	private String nome;
	private double valor;
	private int quantidade;
	private String categoria;
	
	public enum Tipo{
		AVENTURA,COMEDIA,DRAMA;
	}
	

	public Integer getID() {
		return Id;
	}

	public void setID(int iD) {
		Id = iD;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(Tipo categoria) {
		if(categoria == Tipo.AVENTURA){
			this.categoria = "Aventura";
		}else if(categoria == Tipo.COMEDIA){
			this.categoria = "Comedia";
		}else{
			this.categoria = "Drama";
		}
	}

	@Override
	public String toString() {
		return "Livro [Id=" + Id + ", nome=" + nome + ", valor=" + valor + ", quantidade=" + quantidade + ", categoria="
				+ categoria + "]\n";
	}

	
}
