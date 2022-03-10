package br.com.letscode.controller;

import br.com.letscode.entity.PedidoEntidade;
import br.com.letscode.repository.PedidoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/pedidos")
public class PedidoController {
    @GetMapping("/listar")
    public String listar(Model model) {
        PedidoRepository pedidoRepository = new PedidoRepository();
        List<PedidoEntidade> todosPedidos = pedidoRepository.getAll();

        model.addAttribute("pedidos", todosPedidos);

        return "listar-pedidos";
    }
}
