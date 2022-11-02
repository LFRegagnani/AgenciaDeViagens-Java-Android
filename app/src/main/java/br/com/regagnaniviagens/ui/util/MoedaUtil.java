package br.com.regagnaniviagens.ui.util;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

public class MoedaUtil {


    public static final String LINGUA = "pt";
    public static final String BRASIL = "br";

    public static String formataMoedaParaBr(BigDecimal valorEmBigDecimal) {
        String moedaBr = NumberFormat.getCurrencyInstance(new Locale(LINGUA, BRASIL))
                .format(valorEmBigDecimal);
        return moedaBr;
    }
}
