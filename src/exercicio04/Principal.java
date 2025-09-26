package exercicio04;

import java.util.ArrayList;
import java.util.List;

public class Principal {
    public static void main(String[] args) {
        List<MeioTransporte> meiosTransporte = new ArrayList<>();
        meiosTransporte.add(new Carro());
        meiosTransporte.add(new Bicicleta());
        meiosTransporte.add(new Trem());

        for (MeioTransporte meio : meiosTransporte) {
            try {
                meio.acelerar();
                meio.acelerar();
                meio.frear();
            } catch (IllegalStateException ex) {
                System.out.println("Erro: " + ex.getMessage());
            }
        }
    }
}
