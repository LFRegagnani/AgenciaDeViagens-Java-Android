package br.com.regagnaniviagens.ui.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class FormataDatasUtil {

    public static final String DIA_E_MES = "dd/MM";

    public static String formataDatas(int dias) {
        Calendar dataIda = Calendar.getInstance();
        Calendar dataVolta = Calendar.getInstance();
        dataVolta.add(Calendar.DATE, dias);
        SimpleDateFormat formatoBrData = new SimpleDateFormat(DIA_E_MES);
        String idaFormatada = formatoBrData.format(dataIda.getTime());
        String voltaFormatada = formatoBrData.format(dataVolta.getTime());
        String dataFormatadaDaViagem = idaFormatada + " - " + voltaFormatada + " de " + dataVolta.get(Calendar.YEAR);
        return dataFormatadaDaViagem;
    }
}
