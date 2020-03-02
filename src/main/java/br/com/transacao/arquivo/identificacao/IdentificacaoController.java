package br.com.transacao.arquivo.identificacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/upload")
public class IdentificacaoController {

	//private static final Logger LOG = LoggerFactory.getLogger(PagamentoReceberTotalController.class);

	@Autowired
	private IdentificacaoService identificacaoService;

	@RequestMapping("/")
	public String index() {

		return "Hello World";
	}

	@RequestMapping("/all")
	public String addFileReceber() {
		identificacaoService.receberArquivo();
		return "Arquivos Recebidos";
	}

}
