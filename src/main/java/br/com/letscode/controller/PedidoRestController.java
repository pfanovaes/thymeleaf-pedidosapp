package br.com.letscode.controller;

import br.com.letscode.dto.RetornoPedidoDTO;
import br.com.letscode.service.PedidoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Controller
public class PedidoRestController {

    public PedidoRestController(PedidoService pedidoService) {

    }

    @RequestMapping("/teste")
    @ResponseBody
    public RetornoPedidoDTO getRetorno() {
        RetornoPedidoDTO dto = new RetornoPedidoDTO();
        dto.setProduto("Computador");
        dto.setDescricao("All in one");
        dto.setDataEntrega(LocalDate.now());
        dto.setValor(BigDecimal.valueOf(1200));

        return dto;
    }

    public List<RetornoPedidoDTO> getListaRetornoPedidoDTO() {
        return null;
    }
}
