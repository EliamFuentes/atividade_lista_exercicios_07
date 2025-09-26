package exercicio01e02;

public class DescontoInvalidoException extends IllegalArgumentException {
    public DescontoInvalidoException(String mensagem) {
        super(mensagem);
    }
}