package edBusca;

import java.util.ArrayList;
import java.util.Scanner;

public class Busca {

	private static Scanner ler = new Scanner(System.in);
	private static ArrayList<Integer> lista = new ArrayList<>();

	// Método principal (MENU)
	public static void main(String[] args) {
		int op;
		do {
			System.out.println("\n--- MENU ---");
			System.out.println("1. Informar lista");
			System.out.println("2. Limpar lista");
			System.out.println("3. Exibir lista");
			System.out.println("4. Busca Linear");
			System.out.println("5. Busca Linear com Sentinela");
			System.out.println("6. Busca Binaria");
			System.out.println("0. Sair");
			System.out.print("Escolha uma opção: ");
			op = ler.nextInt();

			switch (op) {
			case 1:
				informarVetor();
				break;
			case 2:
				limparVetor();
				break;
			case 3:
				System.out.println("Lista: " + exibirVetor());
				break;
			case 4:
				buscaLinear();
				break;
			case 5:
				buscaLinearSentinela();
				break;
			case 6:
				buscaBinaria();
				break;
			case 0:
				break;
			default:
				System.out.println("Opção Inválida. Tente novamente");
			}

		} while (op != 0);
	}

	// Método para inserir números no ArrayList
	public static void informarVetor() {
		int numero = 0;
		while (numero != -999) {
			System.out.println("Informe os números do Vetor ('-999' para parar)");
			numero = ler.nextInt();

			if (numero == -999) {
				break;
			}

			lista.add(numero);
		}
	}

	// Método para limpar o ArrayList
	public static void limparVetor() {
		lista.clear();
		System.out.println("Lista limpa");
		System.out.println("Lista: " + lista);
	}

	// Método para exibir a lista (ArrayList)
	public static ArrayList<Integer> exibirVetor() {
		return lista;
	}

	// Método para Busca Linear na lista
	public static void buscaLinear() {

		if (lista.isEmpty()) {
			System.out.println("A lista está vazia. Nada para buscar.");
			return;
		}

		System.out.print("\nDigite o valor a ser buscado: ");
		int numero = ler.nextInt();

		boolean achou = false;

		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i) == numero) {
				System.out.println("Valor ('" + numero + "') encontrado no índice " + i);
				achou = true;
				break;
			}
		}

		if (!achou) {
			System.out.println("Valor ('" + numero + "') não foi encontrado");
		}

	}

	// Método para Busca Linear com Sentinela
	public static void buscaLinearSentinela() {
		
		if (lista.isEmpty()) {
			System.out.println("A lista está vazia. Nada para buscar.");
			return;
		}

		System.out.print("\nDigite o valor a ser buscado: ");
		int numero = ler.nextInt();
		
		lista.add(numero); // add sentinela na ultima posição da lista. ex.: em uma lista de 8 elementos (indexados de 0-7), o indice da sentinela seria 8
		
		int i = 0;
		while (lista.get(i) != numero) { // so sai do while quando encontrar o valor da sentinela (valor que desejo encontrar)
			i++;
		}
		
		lista.remove(lista.size()-1); // remove a sentinela -> lista volta a ser do tamanho original
		
		if (i == lista.size()) { // se o indice do numero que desejo encontrar for do tamanho da lista (ou seja: igual ao indice que a sentinela estava) -> elemento nao encontrado
			System.out.println("Valor ('" + numero + "') não foi encontrado");
		} else { // significa que o indice do numero que desejo encontrar está dentro da lista original -> elemento foi encontrado
			System.out.println("Valor ('" + numero + "') encontrado no índice " + i);
		}
		
	}


	// Método para Busca Binária na lista
	public static void buscaBinaria() {

		if (lista.isEmpty()) {
			System.out.println("A lista está vazia. Nada para buscar.");
			return;
		}

		System.out.print("\nDigite o valor a ser buscado: ");
		int numero = ler.nextInt();

		boolean achou = false;
		int inicio = 0;
		int fim = lista.size() - 1;
		int meio;

		while (inicio <= fim) {
			meio = (inicio + fim) / 2;
			if (lista.get(meio) == numero) {
				System.out.println("Valor ('" + numero + "') encontrado no índice " + meio);
				achou = true;
				break;
			} else if (lista.get(meio) < numero) { // numero so pode estar a direita do meio
				inicio = meio + 1;
			} else { // numero so pode estar a esquerda do meio
				fim = meio - 1;
			}
		}

		// fim e inicio invertem de posição quando um número não existe no vetor
		if (!achou) {
			System.out.println("Valor ('" + numero + "') não foi encontrado");
		}

	}

}
