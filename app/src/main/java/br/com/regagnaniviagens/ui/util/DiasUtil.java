package br.com.regagnaniviagens.ui.util;

public class DiasUtil {

    public static final String PLURAL = " dias";
    public static final String SINGULAR = " dia";

    public static String formataDiasEmTexto(int dias) {

        if (dias >= 2) {
            return  dias + PLURAL;
        }
            return  dias + SINGULAR;
    }
}
