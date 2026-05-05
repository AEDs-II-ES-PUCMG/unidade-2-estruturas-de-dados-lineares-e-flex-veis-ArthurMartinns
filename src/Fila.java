import java.util.NoSuchElementException;

public class Fila<E> {

	private Celula<E> frente;
	private Celula<E> tras;

	Fila() {

		Celula<E> sentinela = new Celula<E>();
		frente = tras = sentinela;
	}

	public boolean vazia() {

		return (frente == tras);
	}

	public void enfileirar(E item) {

		Celula<E> novaCelula = new Celula<E>(item);

		tras.setProximo(novaCelula);
		tras = tras.getProximo();
	}

	public E desenfileirar() {

		E item = null;
		Celula<E> primeiro;

		item = consultarPrimeiro();

		primeiro = frente.getProximo();
		frente.setProximo(primeiro.getProximo());

		primeiro.setProximo(null);

		// Caso o item desenfileirado seja também o último da fila.
		if (primeiro == tras)
			tras = frente;

		return item;
	}

	public E consultarPrimeiro() {

		if (vazia()) {
			throw new NoSuchElementException("Nao há nenhum item na fila!");
		}

		return frente.getProximo().getItem();

	}

	public void imprimir() {

		Celula<E> aux;

		if (vazia())
			System.out.println("A fila está vazia!");
		else {
			aux = this.frente.getProximo();
			while (aux != null) {
				System.out.println(aux.getItem());
				aux = aux.getProximo();
			}
		}
	}

	public void testeGenerico(char elemento) {
		int count = 0;
		Fila<E> auxiliar = new Fila<E>();

		while(!this.vazia()) {
			E item = this.desenfileirar();

			if(item.equals(elemento)) {
				count++;
			}

			auxiliar.enfileirar(item);
		}

		while(!auxiliar.vazia()) {
			this.enfileirar(auxiliar.desenfileirar());
		}

		System.out.println("O elemento se repete " + count + " vezes.");
	}

	public Fila<E> extrairLote(int numItens) {
		if (numItens <= 0) {
			throw new IllegalArgumentException("O número de itens deve ser maior que 0!");
		}

		int count = 0;
		Fila<E> loteExtraido = new Fila<>();

		while (!this.vazia() && count < numItens) {
			E item = this.desenfileirar();
			loteExtraido.enfileirar(item);
			count++;
		}

		return loteExtraido;
	}
}