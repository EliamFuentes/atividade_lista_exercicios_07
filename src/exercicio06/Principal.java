package exercicio06;

import java.math.BigDecimal;
import java.util.List;

public class Principal {
    public static void main(String[] args) {
        Produto p1 = new Produto("Notebook", new Dinheiro(new BigDecimal("3500.00"), Moeda.BRL));
        Produto p2 = new Produto("Mouse", new Dinheiro(new BigDecimal("150.00"), Moeda.BRL));

        Carrinho carrinho = new Carrinho(List.of())
                .adicionarItem(new ItemCarrinho(p1, 1))
                .adicionarItem(new ItemCarrinho(p2, 2));

        System.out.println("Total sem desconto: " + carrinho.calcularTotal());

        Carrinho carrinhoComDesconto = carrinho.aplicarCupom(new BigDecimal("0.1")); // 10%
        System.out.println("Total com desconto: " + carrinhoComDesconto.calcularTotal());
    }
}
