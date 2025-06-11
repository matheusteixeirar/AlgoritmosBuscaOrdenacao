package edOrdenacao;

import java.util.ArrayList;
import java.util.Scanner;

public class Ordenacao {

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
			System.out.println("4. Selection Sort");
			System.out.println("5. Bubble Sort");
			System.out.println("6. Insertion Sort");
			System.out.println("7. Merge Sort");
			System.out.println("8. Quick Sort");
			System.out.println("9. Heap Sort");
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
				selectionSort();
				break;
			case 5:
				bubbleSort();
				break;
			case 6:
				insertionSort();
				break;
			case 7:
				MergeSort.mergeSort(lista);
				System.out.println("Lista ordenada: " + lista);
				break;
			case 8:
				QuickSort.quickSort(lista, 0, lista.size() - 1);
				System.out.println("Lista ordenada: " + lista);
				break;
			case 9:
				HeapSort.heapSort(lista);
				System.out.println("Lista ordenada: " + lista);
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

	// Método para ordenar a lista usando Selection Sort
	public static void selectionSort() {

		if (lista.isEmpty()) {
			System.out.println("A lista está vazia. Nada para ordenar.");
			return;
		}

		for (int j = 0; j < lista.size() - 1; j++) {
			int indexMenorValor = j;
			for (int i = j + 1; i < lista.size(); i++) {
				if (lista.get(indexMenorValor) > lista.get(i)) {
					indexMenorValor = i;
				}
			}
			int aux = lista.get(j); // atual

			lista.set(j, lista.get(indexMenorValor));
			lista.set(indexMenorValor, aux);
		}
		System.out.println("Lista ordenada: " + lista);
	}

	// Método para ordenar a lista usando Bubble Sort
	public static void bubbleSort() {

		if (lista.isEmpty()) {
			System.out.println("A lista está vazia. Nada para ordenar.");
			return;
		}

		for (int i = 0; i < lista.size() - 1; i++) {
			for (int j = 0; j < lista.size() - 1 - i; j++) {
				if (lista.get(j) > lista.get(j + 1)) {
					int aux = lista.get(j); // maior valor
					lista.set(j, lista.get(j + 1));
					lista.set(j + 1, aux);
				}
			}
		}
		System.out.println("Lista ordenada: " + lista);
	}

	// Método para ordenar a lista usando Insertion Sort
	public static void insertionSort() {

		if (lista.isEmpty()) {
			System.out.println("A lista está vazia. Nada para ordenar.");
			return;
		}

		for (int i = 1; i < lista.size(); i++) {
			int aux = lista.get(i); // atual
			int j = i - 1; // verificar todos os elementos anteriores ao aux (até o incio da lista, onde j=0)
			while (j >= 0 && lista.get(j) > aux) {
				lista.set(j + 1, lista.get(j));
				j--;
			}
			lista.set(j + 1, aux);
		}
		System.out.println("Lista ordenada: " + lista);
	}

	// Método para ordenar a lista usando Merge Sort
	public class MergeSort {

		public static void mergeSort(ArrayList<Integer> lista) {

			if (lista.isEmpty()) {
				System.out.println("A lista está vazia. Nada para ordenar.");
				return;
			}

			// divide a lista em esquerda e direita e faz uma chamada recursiva do método, sendo assim, irá dividir ambas as listas até cada restar apenas um elemento
			if (lista.size() > 1) {
				int meio = lista.size() / 2;
				ArrayList<Integer> esquerda = new ArrayList<>(lista.subList(0, meio));
				ArrayList<Integer> direita = new ArrayList<>(lista.subList(meio, lista.size()));
				mergeSort(esquerda);
				mergeSort(direita);

				merge(lista, esquerda, direita);
			}
		}

		// método auxiliar do MergeSort -> serve para juntar as listas (esquerda e direita) na lista principal (lista) em ordem crescente
		private static void merge(ArrayList<Integer> lista, ArrayList<Integer> esquerda, ArrayList<Integer> direita) {

			int i = 0, j = 0; // i -> representa os elementos da lista da esquerda (a partir do índice 0) e o j, a mesma coisa, so que da lista da direita. k representa a lista principal
			for (int k = 0; k < lista.size(); k++) {
				if (i >= esquerda.size()) { // verificação caso a lista da esquerda tenha todos os números menores que a lista da direita
					lista.set(k, direita.get(j));
					j++;
				} else if (j >= direita.size()) { // verificação caso a lista da direita tenha todos os números menores que a lista da esquerda
					lista.set(k, esquerda.get(i));
					i++;
				} else if (esquerda.get(i) < direita.get(j)) {
					lista.set(k, esquerda.get(i));
					i++;
				} else {
					lista.set(k, direita.get(j));
					j++;
				}
			}
		}
	}

	// Método para ordenar a lista usando Quick Sort
	public class QuickSort {

		// na chamada do método no MENU, passa os valores de inicio (0) e fim (lista.size()-1)
		// esses valores indicam os índices dos elementos na lista. Indice 0 = inicio e indice 'tamanho da lista - 1' = fim
		
		public static void quickSort(ArrayList<Integer> lista, int inicio, int fim) {

			if (lista.isEmpty()) {
				System.out.println("A lista está vazia. Nada para ordenar.");
				return;
			}

			if (inicio < fim) {
				int p = particao(lista, inicio, fim); // p = pivo
				quickSort(lista, inicio, p - 1); // chamada recursiva para ordenar a lista a esquerda (elementos menores que o pivo)
				quickSort(lista, p + 1, fim); // chamada recursiva para ordenar a lista a direita (elementos maiores que o pivo)
			}
		}

		private static int particao(ArrayList<Integer> lista, int inicio, int fim) {
			int pivo = lista.get(fim); // ultimo elemento é o pivo
			int i = inicio;
			for (int j = inicio; j < fim; j++) {
				if (lista.get(j) <= pivo) { // vai ordenar a lista, colocando para a esquerda os elementos que forem menor que o pivo -> troca a posição do elemento menor para o inicio da fila (que vai incrementando assim que tiver outros elementos menores que o pivo)
					int aux = lista.get(i);
					lista.set(i, lista.get(j));
					lista.set(j, aux);
					i++;
				}
			}
			
			// troca o pivo com o primeiro maior elemento que ele (lista.get(i))
			// tudo a esquerda de lista.get(i) é menor ou igual ao pivo e tudo a direita, maior que o pivo
			int aux = lista.get(i);
			lista.set(i, lista.get(fim));
			lista.set(fim, aux);
			return i;
		}
	}

	// Método para ordenar a lista usando Heap Sort
		public class HeapSort {

			public static void heapSort(ArrayList<Integer> lista) {

				if (lista.isEmpty()) {
					System.out.println("A lista está vazia. Nada para ordenar.");
					return;
				}

				int n = lista.size();
				
				// apos toda a iteração, faz com que: indice 0 = maior elemento / indices 0 até n/2-1 = pais / resto = filhos
				for (int i = n / 2 - 1; i >= 0; i--) { // começa pelo ultimo nó pai. So é necessário "aplicarHeap" nos nós pais, pois com os pais, sabe-se os filhos e os filhos serão ordenados recursivamentes
					aplicarHeap(lista, n, i);
				}
				
				// o maior elemento sempre esta na raiz do heap (indice 0) e devemos organiza-los em uma lista ordenada:
				// linhas 264-267: vai pegar o maior elemento (raiz do heap: lista.get(0)) e move para o fim da lista nao ordenada (j)
				// a cada iteração, j é decrementado, reduzindo a parte não ordenada e fazendo com que o final da lista se torne a parte ordenada
				for (int j = n - 1; j > 0; j--) { 
					int aux = lista.get(0); // aux recebe o maior elemento
					lista.set(0, lista.get(j));
					lista.set(j, aux);
					
					// serve para colocar, dentre os elementos que sobraram (nao ordenados), o maior elemento na raiz do heap (indice 0)
					aplicarHeap(lista, j, 0);
				}
				 
			}

			// garante que o maior elemento de uma subarvore esteja na raiz dessa subarvore e que, nessa subarvore, os pais sejam maiores que os filhos
			private static void aplicarHeap(ArrayList<Integer> lista, int n, int i) {
				int raiz = i;
				int esquerda = 2 * i + 1; // filho esquerdo
				int direita = 2 * i + 2; // filho direito
				
				// linhas 282-288: compara a raiz com seus filhos e caso algum filho seja maior que o pai, atualiza o valor da raiz (maior filho se torna a raiz)
				if (esquerda < n && lista.get(esquerda) > lista.get(raiz)) {
					raiz = esquerda;
				}
				
				if (direita < n && lista.get(direita) > lista.get(raiz)) {
					raiz = direita;
				}
				
				// se algum filho (que era maior que o pai) se tornou a raiz -> troca de posição o filho com o pai
				if (raiz != i) {
					int aux = lista.get(i); // aux recebe o antigo pai 
					lista.set(i, lista.get(raiz)); // indice i (indice do pai) recebe o novo pai (filho maior que o pai)
					lista.set(raiz, aux); // indice raiz (indice do filho) recebe o antigo pai
					
					aplicarHeap(lista, n, raiz); // aplica o heap recursivamente no antigo pai, pois podem haver filhos maiores que ele. Sendo assim, vai descendo a árvore até chegar a uma folha. Garantindo que a subarvore do antigo pai obedeça ao heap
				}
			}
		}

}
