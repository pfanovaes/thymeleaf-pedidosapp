package br.com.letscode.controller;

import br.com.letscode.entity.PedidoEntidade;
import br.com.letscode.repository.PedidoRepository;
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
    @GetMapping("/listar")
    public String listar(Model model) {
        PedidoRepository pedidoRepository = new PedidoRepository();
        List<PedidoEntidade> todosPedidos = pedidoRepository.getAll();

        model.addAttribute("pedidos", todosPedidos);

        return "listar-pedidos";
    }

    @GetMapping("cadastrar-pedido-form")
    public String cadastratPedidoForm() {
        return "cadastrar-pedido-form";
    }

    @PostMapping("/cadastrar-pedido")
        public RedirectView cadastrarPedido(PedidoEntidade entidade) {
            PedidoRepository repository = new PedidoRepository();

        LocalDate dataEntrega = LocalDate.now().plusDays(10);
        entidade.setDataEntrega(dataEntrega);

        repository.salvar(entidade);

        final RedirectView view = new RedirectView("pedido/listar", true);
        return view;
    }

}
