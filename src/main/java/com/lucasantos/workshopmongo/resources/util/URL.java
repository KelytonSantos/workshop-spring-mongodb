package com.lucasantos.workshopmongo.resources.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class URL {
    public static String decodeParam(String text){//o statico é pra n precisar instanciar um objeto url
        try {
            return URLDecoder.decode(text, "UTF-8");
        } catch (UnsupportedEncodingException e) {
           return "";
        } //text é o texto que eu quero decodificar(lembrando que quem codifica é o front) e utf 8 é o padrão de codificação;
    }
}