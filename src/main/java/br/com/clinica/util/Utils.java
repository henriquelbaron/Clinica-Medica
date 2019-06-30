/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.clinica.util;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 *
 * @author henrique
 */
public class Utils {

    private static final String dataFormat = "dd/MM/yyyy";
    private static final String dataHoraFormat = "dd/MM/yyyy HH:mm";
    private static final String horaFormat = "HH:mm";
    private static SimpleDateFormat sdf;

    public static Date stringToDate(Date data, String hora) {
        try {
            sdf = new SimpleDateFormat(dataHoraFormat);
            sdf.setLenient(false);
            String dataString = new SimpleDateFormat(dataFormat).format(data);
            return sdf.parse(dataString + " " + hora);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static String dateToString(Date data) {
        sdf = new SimpleDateFormat(dataFormat);
        return sdf.format(data);

    }

    public static Date stringToDate(String data) {
        try {
            return new SimpleDateFormat(dataFormat).parse(data);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static String horaAtual() {
        return new SimpleDateFormat(horaFormat).format(new Date().getTime());
    }

    public static String dataAutal() {
        return new SimpleDateFormat(dataFormat).format(new Date().getTime());
    }

    public static boolean dateBeforeToday(Date date) {
        return false;
    }
}
