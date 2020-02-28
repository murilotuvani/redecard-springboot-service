package br.com.transacao.pagamentos.areceber;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pagamento")
public class PagamentoReceberController {

	private static final Logger LOG = LoggerFactory.getLogger(PagamentoReceberController.class);

	@Autowired
	private PagamentoReceberService pagamentoReceberService;

	@GetMapping
	public ResponseEntity<List<PagamentoReceber>> list() {
		LOG.debug("list()");

		List<PagamentoReceber> list = pagamentoReceberService.list();
		if (list.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(list);
	}

	@RequestMapping("/")
	public String index() {

		return "Hello world";
	}

	@RequestMapping("/receber")
	public ResponseEntity<List<PagamentoReceber>> addFileReceber() {
		List<PagamentoReceber>listPagamentoReceber = pagamentoReceberService.receber();
		return ResponseEntity.ok(listPagamentoReceber);
	}

}
