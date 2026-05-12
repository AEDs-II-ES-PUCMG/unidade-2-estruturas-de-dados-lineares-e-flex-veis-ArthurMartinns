import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Function;
import java.util.function.Predicate;

public class Lista<E> implements Iterable<E> {

    private Celula<E> primeiro;
    private Celula<E> ultimo;
    private int tamanho;

    public Lista() {
        Celula<E> sentinela = new Celula<>();
        primeiro = ultimo = sentinela;
        tamanho = 0;
    }

    public boolean vazia() {
        return primeiro == ultimo;
    }

    public int tamanho() {
        return tamanho;
    }

    public void inserirFinal(E item) {
        Celula<E> nova = new Celula<>(item);
        ultimo.setProximo(nova);
        ultimo = nova;
        tamanho++;
    }

    public void inserirInicio(E item) {
        Celula<E> nova = new Celula<>(item, primeiro.getProximo());
        if (vazia()) ultimo = nova;
        primeiro.setProximo(nova);
        tamanho++;
    }

    public E removerInicio() {
        if (vazia()) throw new NoSuchElementException("Lista vazia!");
        Celula<E> atual = primeiro.getProximo();
        primeiro.setProximo(primeiro.getProximo());
        if (atual == ultimo) ultimo = primeiro;
        primeiro.setProximo(null);
        tamanho--;
        return primeiro.getItem();
    }

    public void imprimir() {
        if (vazia()) {
            System.out.println("A lista está vazia!");
        } else {
            Celula<E> aux = primeiro.getProximo();
            while (aux != null) {
                System.out.println(aux.getItem());
                aux = aux.getProximo();
            }
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private Celula<E> atual = primeiro.getProximo();

            @Override
            public boolean hasNext() {
                return atual != null;
            }

            @Override
            public E next() {
                if (!hasNext()) throw new NoSuchElementException();
                E item = atual.getItem();
                atual = atual.getProximo();
                return item;
            }
        };
    }

    // Tarefa 1
    public E buscarPor(Comparator<E> criterioDeBusca, E item) {
        // TODO: Percorrer sequencialmente a lista e retornar o primeiro elemento
        //       equivalente a item segundo o criterioDeBusca (compare == 0).
        //       Retornar null caso nenhum elemento seja encontrado.
        

        while(!this.vazia()) {
            elemento = this.removerInicio();

            if(item.equals(elemento)) {

            }
        }

        return elemento;
    }

    // Tarefa 2
    public double somarMultiplicacoes(ItemDePedido itemDePedido) {
        // TODO: Para cada elemento, extrair o valor (extratorValor) e o fator (extratorFator),
        //       multiplicá-los e acumular no somatório final.
        //       Lançar IllegalStateException se a lista estiver vazia.

        if(this.vazia()) {
            throw new IllegalStateException("A lista está vazia! ");
        }

        Celula<E> celulaAtual = new Celula<>();

        double total, receita;
        int qtd;
        ItemDePedido aux = (ItemDePedido) celulaAtual.getItem();

        qtd = aux.getQuantidade();
        receita = aux.getPrecoVenda();
        total = qtd * receita;
        return total;

    }

    // Tarefa 3
    public Lista<E> filtrar(ItemDePedido itemDePedido) {
        // TODO: Criar e retornar uma nova lista contendo apenas os elementos
        //       para os quais condicional.test() retorna true.
        //       Lançar IllegalStateException se a lista estiver vazia.
        if(this.vazia()) {
            throw new IllegalStateException("A lista está vazia!");
        }
        
        Celula<E> atual = new Celula<>();
        ItemDePedido aux = (ItemDePedido) atual.getItem();
        
        Lista<E> listaAuxiliar = new Lista<>();

        while (!this.vazia()) {
            E item = this.removerInicio();

            if(aux.getDescricao().equals(itemDePedido.getDescricao())) {
                listaAuxiliar.inserirFinal(item);
            }
        }

        return listaAuxiliar;
    }
}
