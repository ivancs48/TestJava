/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.calderon.TestJava.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author ivanc
 */

public class Util {

    public boolean validaCorreo(String email) {
        boolean valida = false;
        Pattern patternCorreo = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher mather = patternCorreo.matcher(email);
        if (mather.find() == true) {
            valida = true;
            System.out.println("El email ingresado es válido.");
        } else {
            valida = false;
            System.out.println("El email ingresado es inválido.");
        }
        return valida;
    }

}
