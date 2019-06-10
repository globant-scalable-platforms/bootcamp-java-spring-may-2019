package com.dinamik.app.dinamikprintservice.controller;

import com.dinamik.app.dinamikprintservice.domain.Order;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Controller
public class PrintController {


    @GetMapping
    public String uploadFile(){
        return "uploadForm.html";
    }

    @RequestMapping(value="/upload", method= RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String readExternalFile(@RequestParam("file") MultipartFile file, Model model) throws IOException {

        List<Order> orderList = new ArrayList<>();

        Scanner scanner = new Scanner(file.getInputStream());

        while(scanner.hasNextLine()){

            String number = scanner.nextLine();
            String link = "http://instalaciones.alkosto.com/ie/impresionop2.asp?OP=" + number + "&US=7";

            Order order = new Order(number, link);

            orderList.add(order);
        }

        System.out.println(orderList);

        scanner.close();

        model.addAttribute("orderList", orderList);
        return "uploadForm";
    }//End of readExternalFile
}
