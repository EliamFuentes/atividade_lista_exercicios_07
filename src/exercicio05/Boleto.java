package exercicio05;

import java.math.BigDecimal;

public class Boleto extends FormaPagamento {
    private String codigoBoleto;

    public Boleto(String codigoBoleto) {
        this.codigoBoleto = codigoBoleto;
    }

    @Override
    public void validarPagamento() throws PagamentoInvalidoException {
        if (codigoBoleto == null || codigoBoleto.length() != 48) {
            throw new PagamentoInvalidoException("Código do boleto inválido! Deve ter 48 dígitos.");
        }
    }

    @Override
    public void processarPagamento(BigDecimal valor) throws PagamentoInvalidoException {
        validarPagamento();
        System.out.println("Pagamento de R$ " + valor + " processado via Boleto.");
    }
}
