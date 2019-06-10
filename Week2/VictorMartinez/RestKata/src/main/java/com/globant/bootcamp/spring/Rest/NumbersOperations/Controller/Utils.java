package com.globant.bootcamp.spring.Rest.NumbersOperations.Controller;

import com.globant.bootcamp.spring.Rest.NumbersOperations.Exception.NonValidInputFormat;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

public class Utils {


    public static String convert(InputStream inputStream) throws IOException {
        Charset charset = StandardCharsets.UTF_8;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream, charset))) {
            return br.lines().collect(Collectors.joining(System.lineSeparator()));
        }catch(IOException ex){
            throw new NonValidInputFormat(ex.getMessage());
        }
    }

    public static String convertInputStream2String(MultipartFile input){
        String incomingMessage="";
        try {
            incomingMessage = Utils.convert(input.getInputStream());
        } catch(IOException ex){
            ex.printStackTrace();
        }

        return incomingMessage;

    }

    public static int[] converStringArr2DoubleArr(String [] input){
        int[] intArr = new int[input.length];
        for(int i =0; i<input.length;i++){
            intArr[i] = Integer.parseInt(input[i]);
        }
        return intArr;
    }
}