package exercicio05;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Principal {
    public static void main(String[] args) {
        List<FormaPagamento> pagamentos = new ArrayList<>();
        pagamentos.add(new CartaoCredito("1234567812345678")); // válido
        pagamentos.add(new Boleto("123456789012345678901234567890123456789012345678")); // válido
        pagamentos.add(new Pix("minhaChavePix")); // válido
        pagamentos.add(new CartaoCredito("123")); // inválido para testar exceção

        for (FormaPagamento pagamento : pagamentos) {
            try {
                pagamento.processarPagamento(new BigDecimal("150.00"));
            } catch (PagamentoInvalidoException e) {
                System.out.println("Erro no pagamento: " + e.getMessage());
            }
        }
    }
}