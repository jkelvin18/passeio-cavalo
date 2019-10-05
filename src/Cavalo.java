
public class Cavalo {

	public final int n;
	public final int m;

	int[][] movimentos;
	String[][] tabuleiroNotacao;

	// dx e dy sao usados para calcular as coordenadas dos movimentos possiveis

	int[] dx = { 2, 1, -1, -2, -2, -1, 1, 2 };
	int[] dy = { 1, 2, 2, 1, -1, -2, -2, -1 };

	// construtor recebe o tamanho do tabuleiro
	public Cavalo(int N, int M) {
		this.n = N;
		this.m = M;

		this.movimentos = new int[n][m];

		// inicia o tabuleiro, que contem a notacao algebrica
		this.tabuleiroNotacao = new String[n][m];
	}

	// metodo que realiza o inicio do algoritmo
	public void Inicializar() {
		int x = 3, y = 2; // <x, y> e a posicao atual, 3 ,2 representa a celula c5 do tabuleiro

		movimentos[x][y] = 1; // onde 1 representa o valor do movimento inicial do cavalo

		Movimentar(2, x, y); // inicia a tentativa de movimentos, onde 2 e o segundo movimento

		String[][] notacao = montarTabuleiroNotacao(this.tabuleiroNotacao, this.movimentos);
		imprimeConsole(notacao);
	}

	/**
	 * Algoritmo que realiza a movimentacao do cavalo no tabuleiro 
	 * @param numMovimento - Numero do movimento
	 * @param linha        - Linha inicial
	 * @return
	 */
	public int Movimentar(int numMovimento, int linha, int coluna) {
		int u = 0, v = 0, k = 0, q;

		// executa movimentos
		if (numMovimento <= (n * m)) {
			for (k = 0; k < 8; k++) {
				u = linha + dx[k];
				v = coluna + dy[k];

				// testa limites do tabuleiro
				if ((u >= 0 && u < n) && (v >= 0 && v < m)) {
					if (movimentos[u][v] == 0) { // posicao livre continua
						movimentos[u][v] = numMovimento; // registre o movimento
						q = Movimentar(numMovimento + 1, u, v); // recursividade
						if (q == 0)
							movimentos[u][v] = 0;

						else
							return 1;
					}
				}
			}
		} else
			return 1;
		return 0;
	}

	/**
	 * Imprime no console o resultado do algoritmo
	 * 
	 * @param tabuleiroNotacao
	 */
	public void imprimeConsole(String tabuleiro[][]) {
		int i, j;
		for (i = 0; i < n; i++) {
			for (j = 0; j < m; j++) {
				System.out.printf("\t" + tabuleiroNotacao[i][j]);
			}
			System.out.println();
		}
	}

	/**
	 * Esse metodo cria as notacoes algebricas e popula com os movimentos
	 * encontrados pelo algoritmo
	 * 
	 * @return
	 */
	public String[][] montarTabuleiroNotacao(String[][] tabuleiroN, int[][] tabuleiroMovimento) {
		int i, j;
		char letra = 97; // inicia com 'a' (97 = 'a' na tabela ascii)
		int numDaCelula = 8;

		// popula tabuleiroN (Tabuleiro de notacoes com os movimentos e a notacao
		// algebrica)
		for (i = 0; i < n; i++) {
			for (j = 0; j < m; j++) {
				tabuleiroN[i][j] = String.valueOf(letra) + numDaCelula + "=" + tabuleiroMovimento[i][j];
				letra++;
			}
			letra = 97;
			numDaCelula--;
		}

		return tabuleiroN;

	}

}
