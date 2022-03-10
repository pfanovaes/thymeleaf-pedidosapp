package br.com.letscode.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/hello")

public class HelloWorldController {

    @GetMapping
    public String hello(Model model) {
        model.addAttribute("nome", "patricia" );
        return "hello";
    }

    @PostMapping("/cadastrar-pedidos")
    public RedirectView cadastrarPedido() {
        return null;
    }
}
