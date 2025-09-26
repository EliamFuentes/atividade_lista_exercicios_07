package exercicio01e02;

class DescontoInvalidoException extends IllegalArgumentException {
    public DescontoInvalidoException(String mensagem) {
        super(mensagem);
    }
}

public class Produto {
    private String nome;
    private double preco;
    private int quantidadeEmEstoque;

    public Produto(String nome, double preco, int quantidadeEmEstoque) {
        setNome(nome);
        setPreco(preco);
        this.preco = preco;
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.isEmpty()) {
            throw new IllegalArgumentException("O nome não pode ser nulo ou vazio");
        }
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        if (preco < 0) {
            throw new IllegalArgumentException("O preço deve ser maior ou igual a zero");
        }
        this.preco = preco;
    }

    public int getQuantidadeEmEstoque() {
        return quantidadeEmEstoque;
    }

    public void setQuantidadeEmEstoque(int quantidadeEmEstoque) {
        if (quantidadeEmEstoque < 0) {
            throw new IllegalArgumentException("A quantidade em estoque deve ser maior ou igual a zero");
        }
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }

    public void aplicarDesconto(double porcentagem) {
        if (porcentagem < 0 || porcentagem > 50 ) {
            throw new DescontoInvalidoException("A porcentagem do desconto é inválida");
        }

        double valorDesconto = preco + (porcentagem / 100);
        this.preco -= valorDesconto;
    }

    public void exibirInformacoes() {
        System.out.println("Nome: " + this.nome);
        System.out.println("Preço: " + this.preco);
        System.out.println("Quantidade em estoque: " + this.quantidadeEmEstoque);
    }

    public static void main(String[] args) {
        try {
            Produto produto = new Produto("Creme de rosto", 120.00, 3);
            produto.exibirInformacoes();
        } catch (IllegalArgumentException ex) {
            ex.printStackTrace();
        }

        try {
            Produto produtoInvalido = new Produto("", 30.20, 10);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }

        try {
            Produto produto2 = new Produto("Skate", 12.99, 30);
            System.out.println("Antes do desconto: ");
            produto2.exibirInformacoes();

            produto2.aplicarDesconto(50);
            System.out.println("Quantidade após o desconto: ");
            produto2.exibirInformacoes();
        } catch (DescontoInvalidoException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
