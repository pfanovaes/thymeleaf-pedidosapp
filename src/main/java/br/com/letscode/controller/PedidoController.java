package br.com.letscode.controller;

import br.com.letscode.dto.CadastrarPedidoDTO;
import br.com.letscode.dto.RetornoPedidoDTO;
import br.com.letscode.entity.PedidoEntidade;
import br.com.letscode.repository.PedidoRepository;
import br.com.letscode.service.EmailService;
import br.com.letscode.service.PedidoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/pedidos")
public class PedidoController {

    private PedidoService service;

    private PedidoController(PedidoService service) {

        this.service = service;
    }

    @GetMapping("/listar")
    public String listar(Model model) {

        List<RetornoPedidoDTO> todosOsPedidosDTO = service.listarTodosOsPedidos();

        model.addAttribute("pedidos", todosOsPedidosDTO);

        return "listar-pedidos";
    }

    @GetMapping("cadastrar-pedido-form")
    public String cadastratPedidoForm() {
        return "cadastrar-pedido-form";
    }

    @PostMapping("/cadastrar-pedido")
        public RedirectView cadastrarPedido(CadastrarPedidoDTO cadastrarPedidoDTO) {

            service.cadastrarPedido(cadastrarPedidoDTO);

            final RedirectView view = new RedirectView("/pedidos/listar", true);
        return view;
    }

}
