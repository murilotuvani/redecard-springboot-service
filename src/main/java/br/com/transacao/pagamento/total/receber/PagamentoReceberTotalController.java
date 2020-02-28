package br.com.transacao.pagamento.total.receber;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/recebimento")
public class PagamentoReceberTotalController {

	private static final Logger LOG = LoggerFactory.getLogger(PagamentoReceberTotalController.class);

	@Autowired
	private PagamentoReceberTotalService pagamentoReceberTotalService;

	@GetMapping
	public ResponseEntity<List<PagamentoReceberTotal>> list() {
		LOG.debug("list()");

		List<PagamentoReceberTotal> list = pagamentoReceberTotalService.list();
		if (list.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(list);
	}

	@RequestMapping("/")
	public String index() {

		return "Hello World";
	}
	
	@RequestMapping("/total")
	public ResponseEntity<List<PagamentoReceberTotal>> addFileReceber() {
		List<PagamentoReceberTotal> listPagamentoReceber = pagamentoReceberTotalService.receberTotal();
		return ResponseEntity.ok(listPagamentoReceber);
	}

}
