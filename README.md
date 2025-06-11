# Algorítmos de Busca e Ordenacao

### Algorítmos de Busca: <h3>
- **Desordenados:** Os dados podem estar em qualquer ordem na lista.
  * Busca Linear: Percorre a lista sequencialmente, comparando cada elemento com o valor procurado, até encontrar o item ou percorrer toda a lista.
  * Busca Linear com Sentinela: Versão aprimorada da busca linear em que o valor a ser buscado é adicionado ao final da lista (sentinela), eliminando a necessidade de verificar se chegou ao final da lista em cada iteração.
- **Ordenados:** Os dados precisam estar em ordem crescente ou decrescente.
  * Busca Binária: Divide a lista pela metade, comparando o valor procurado com o elemento do meio. Se o valor procurado for maior que o elemento do meio, a busca continua recursivamente na metade direita da lista até encontrá-lo, ou não. Caso contrário, a busca segue pela metade esquerda.

### Algorítmos de Ordenação: <h3>
- **Selection Sort:** Encontra o menor elemento da lista e o coloca na primeira posição. Repete o processo para os elementos restantes até ordenar a lista completa.
- **Bubble Sort:** Compara pares de elementos adjacentes, os trancando se estiverem na ordem errada. A cada passagem pela lista, o maior elemento estará no local correto. Repete o processo até ordernar a lista.
- **Insertion Sort:** Percorre a lista a partir do segundo elemento comparando o valor atual com os anteriores. Enquanto os valores anteriores forem maior, os elementos são deslocados para a direita. O valor atual fica na posição correta. O processo se repete até que toda a lista esteja ordenado.
- **Merge Sort:** Divide a lista em duas metades recursivamente até que cada sublista tenha apenas um elemento. Em seguida, mescla as sublistas em ordem crescente, comparando os valores das duas metades e inserindo o menor na lista final.
- **Quick Sort:** Escolhe um pivô (ultimo elemento) e passa para a esquerda dele todos os elementos menores que ele e para a direita todos os elementos maiores que ele. Assim, a posição do pivô fica correta na lista final. Faz isso recursivamente até ordernar toda a lista.
- **Heap Sort:** Verifica se os filhos são maiores que os pais recursivamente até o maior elemento ficar na raiz. Esse maior elemento é trocado com o último elemento da lista. Aplica o método recursivo novamente para que o próximo maior elemento fique na raiz. Esse processo se repete ate que toda a lista esteja ordenada
