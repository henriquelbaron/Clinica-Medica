/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.clinica.util;

import java.awt.Color;
import java.awt.Dimension;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JTextField;

/**
 *
 * @author henrique
 */
public class DataUtils {

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

    public static Date stringToDate(String data, String hora) {
        try {
            sdf = new SimpleDateFormat(dataHoraFormat);
            sdf.setLenient(false);
            return sdf.parse(data + " " + hora);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static Date addDiaData(Date data, int dias) {
        Calendar c = Calendar.getInstance();
        c.setTime(data);
        c.add(Calendar.DATE, dias);
        return c.getTime();
    }

    public static Date addHorasData(Date data, int hora) {
        Calendar c = Calendar.getInstance();
        c.setTime(data);
        c.add(Calendar.HOUR, hora);
        return c.getTime();
    }

    public static Date addMinutosData(Date data, int minutos) {
        Calendar c = Calendar.getInstance();
        c.setTime(data);
        c.add(Calendar.MINUTE, minutos);
        return c.getTime();
    }

    public static Date addMinutoHoraData(Date data, int horas, int minutos) {
        data = addHorasData(data, horas);
        return addMinutosData(data, minutos);
    }

    public static String dateHoraToString(Date data) {
        return new SimpleDateFormat(dataHoraFormat).format(data);
    }

    public static String dateToString(Date data) {
        sdf = new SimpleDateFormat(dataFormat);
        return sdf.format(data);
    }

    public static String formatDateToHQL(Date data) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm").format(data);
    }

    public static Date stringToDate(String data) {
        try {
            return new SimpleDateFormat(dataFormat).parse(data);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static String horaAtualString() {
        return new SimpleDateFormat(horaFormat).format(new Date().getTime());
    }

    public static String dataAtualString() {
        return new SimpleDateFormat(dataFormat).format(new Date().getTime());
    }

    public static Date dataAtual() {
        return new Date(System.currentTimeMillis());
    }

    public static boolean dateAfterToday(Date date) {
        return date.after(new Date(System.currentTimeMillis()));
    }

    public static boolean dateAfterTomorrow(Date date) {
        return date.after(addDiaData(date, 1));
    }
}
