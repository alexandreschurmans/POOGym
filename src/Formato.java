/**
 * Classe utilitária para apresentar valores em euros com duas casas decimais.
 */
public class Formato {

    /**
     * Converte um valor numérico para texto em euros, com duas casas decimais.
     * @param valor Valor em euros
     * @return Texto no formato "12,50 euros"
     */
    public static String euros(double valor) {
        long centimos = Math.round(valor * 100);
        long inteiros = centimos / 100;
        long resto = centimos % 100;
        String zero = "";
        if (resto < 10) {
            zero = "0";
        }
        return inteiros + "," + zero + resto + " euros";
    }
}