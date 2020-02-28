package br.com.transacao.arquivo.identificacao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.transacao.pagamento.total.receber.PagamentoReceberTotalController;

@RestController
@RequestMapping("/upload")
public class IdentificacaoController {

	private static final Logger LOG = LoggerFactory.getLogger(PagamentoReceberTotalController.class);

	@Autowired
	private IdentificacaoService identificacaoService;

	@GetMapping
	public ResponseEntity<List<Identificacao>> list() {
		LOG.debug("list()");

		List<Identificacao> list = identificacaoService.list();
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
	public ResponseEntity<List<Identificacao>> addFileReceber() {
		List<Identificacao> listPagamentoReceber = identificacaoService.receberArquivo();
		return ResponseEntity.ok(listPagamentoReceber);
	}

}
