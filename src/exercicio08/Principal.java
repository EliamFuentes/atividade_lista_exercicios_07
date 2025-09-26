package exercicio08;

import java.math.BigDecimal;

public class Principal {
    public static void main(String[] args) {
        try {
            // Pedido inicial com PAC
            Pedido pedido = new Pedido("12345678", new BigDecimal("250"), new Pac());
            System.out.println("Frete PAC: R$ " + pedido.calcularFrete());

            // Troca para Sedex
            pedido.setCalculadoraFrete(new Sedex());
            System.out.println("Frete Sedex: R$ " + pedido.calcularFrete());

            // Troca para Retirada na Loja
            pedido.setCalculadoraFrete(new RetiradaNaLoja());
            System.out.println("Frete Retirada na Loja: R$ " + pedido.calcularFrete());

            // Estratégia promocional com Lambda
            CalculadoraFrete fretePromocional = (p) -> {
                if (p.getValorPedido().compareTo(new BigDecimal("200")) > 0) {
                    return BigDecimal.ZERO;
                }
                return new BigDecimal("15.00");
            };
            pedido.setCalculadoraFrete(fretePromocional);
            System.out.println("Frete Promocional: R$ " + pedido.calcularFrete());

        } catch (CepInvalidoException e) {
            System.out.println("Erro no cálculo do frete: " + e.getMessage());
        }
    }
}
