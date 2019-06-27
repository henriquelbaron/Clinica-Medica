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

    private static SimpleDateFormat sdf;
    private static DecimalFormat df;

    public static Date stringToDate(String data, String hora) {
        try {
            return new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(data + hora);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static Date stringToDate(String data) {
        try {
            return new SimpleDateFormat("dd/MM/yyyy").parse(data);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static Double stringToDouble(String str) {
        return null;
    }

    public static String formatNumber(Double d) {
        return null;
    }

    public static LocalDate formatDate(String data) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.parse(data, formatter);
    }

    public static Date getDateNow() {
        return null;
    }

    public static boolean dateBeforeToday(Date date) {
        return false;
    }
}
