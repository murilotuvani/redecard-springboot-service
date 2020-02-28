package br.com.transacao.vendas;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transacao")
public class TransacaoController {

	private static final Logger LOG = LoggerFactory.getLogger(TransacaoController.class);

	@Autowired
	private TransacaoService transacaoService;

	@GetMapping
	public ResponseEntity<List<Transacao>> list() {
		LOG.debug("list()");

		List<Transacao> list = transacaoService.list();
		if (list.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(list);
	}

	@RequestMapping("/")
	public String index() {
		return "Hello World";

	}

	@RequestMapping("/venda")
	public ResponseEntity<List<Transacao>> addFilePagamentos() {
		List<Transacao> listaTransacoesAdicionadas = transacaoService.transacoes();
		return ResponseEntity.ok(listaTransacoesAdicionadas);
	}

}
