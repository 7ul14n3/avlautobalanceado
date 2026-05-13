public class ArvoreAVL {
    TreeNode raiz;

    int getAltura(TreeNode n) {
        return (n == null) ? 0 : n.h;
    }

    int getBalance(TreeNode n) {
        return (n == null) ? 0 : getAltura(n.esquerda) - getAltura(n.direita);
    }

    TreeNode rotarDireita(TreeNode y) {
        TreeNode x = y.esquerda;
        TreeNode T2 = x.direita;

        x.direita = y;
        y.esquerda = T2;

        y.h = Math.max(getAltura(y.esquerda), getAltura(y.direita)) + 1;
        x.h = Math.max(getAltura(x.esquerda), getAltura(x.direita)) + 1;

        return x;
    }

    TreeNode rotarEsquerda(TreeNode x) {
        TreeNode y = x.direita;
        TreeNode T2 = y.esquerda;

        y.esquerda = x;
        x.direita = T2;

        x.h = Math.max(getAltura(x.esquerda), getAltura(x.direita)) + 1;
        y.h = Math.max(getAltura(y.esquerda), getAltura(y.direita)) + 1;

        return y;
    }

    public void inserir(int valor) {
        raiz = inserirRecursivo(raiz, valor);
    }

    private TreeNode inserirRecursivo(TreeNode no, int valor) {
        if (no == null) return new TreeNode(valor);

        if (valor < no.valor) {
            no.esquerda = inserirRecursivo(no.esquerda, valor);
        } else if (valor > no.valor) {
            no.direita = inserirRecursivo(no.direita, valor);
        } else {
            return no;
        }

        no.h = 1 + Math.max(getAltura(no.esquerda), getAltura(no.direita));

        int balance = getBalance(no);

        if (balance > 1 && valor < no.esquerda.valor) {
            return rotarDireita(no);
        }

        if (balance < -1 && valor > no.direita.valor) {
            return rotarEsquerda(no);
        }

        if (balance > 1 && valor > no.esquerda.valor) {
            no.esquerda = rotarEsquerda(no.esquerda);
            return rotarDireita(no);
        }

        if (balance < -1 && valor < no.direita.valor) {
            no.direita = rotarDireita(no.direita);
            return rotarEsquerda(no);
        }

        return no;
    }

    public void posOrdem(TreeNode no) {
        if (no != null) {
            posOrdem(no.esquerda);
            posOrdem(no.direita);
            System.out.print(no.valor + " ");
        }
    }
}