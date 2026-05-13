public class Main {
    public static void main(String[] args) {
        ArvoreAVL arvore = new ArvoreAVL();
        int[] valores = {50, 30, 70, 20, 40, 60, 80};

        for (int v : valores) {
            arvore.inserir(v);
        }

        arvore.posOrdem(arvore.raiz);
    }
}