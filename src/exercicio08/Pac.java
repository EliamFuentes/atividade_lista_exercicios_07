package exercicio08;

import java.math.BigDecimal;

public class Pac implements CalculadoraFrete {
    @Override
    public BigDecimal calcular(Pedido pedido) throws CepInvalidoException {
        validarCep(pedido.getCepDestino());
        return new BigDecimal("20.00"); // valor fixo para simplificar
    }

    private void validarCep(String cep) throws CepInvalidoException {
        if (cep == null || cep.length() != 8) {
            throw new CepInvalidoException("CEP inválido para PAC");
        }
    }
}
