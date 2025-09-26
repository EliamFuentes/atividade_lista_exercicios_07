package exercicio01e02;

public class Principal {
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
            System.out.println("Após o desconto: ");
            produto2.exibirInformacoes();
        } catch (DescontoInvalidoException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
