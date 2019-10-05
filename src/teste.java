
public class teste {

	public static void main(String[] args) {
		System.out.println("Passeio do Cavalo (Xadrez)\n");
		Cavalo cavalo = new Cavalo (8, 8); //inicia o tabuleiro 8x8
		cavalo.Inicializar();
		System.out.println();
		System.out.println("Onde 1 = Primeira posicao do cavalo");
		System.out.println("Onde 2 = Segunda posicao do cavalo");
		System.out.println("e assim por diante ate o total de 64");

	}

}
