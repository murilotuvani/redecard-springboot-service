package br.com.transacao.arquivo.identificacao;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.transacao.util.Response;

@RestController
@RequestMapping("/upload")
public class IdentificacaoController {

	private static final Logger LOG = LoggerFactory.getLogger(IdentificacaoFile.class);

	@Autowired
	private IdentificacaoService identificacaoService;

	@RequestMapping("/")
	public String index() {

		return "Hello World";
	}

	@RequestMapping("/all")
	public ResponseEntity<Response<IdentificacaoFile>> addFileReceber() {
		Response<IdentificacaoFile> response = new Response<>();
		List<IdentificacaoFile> id = new ArrayList<IdentificacaoFile>();

		if (identificacaoService.receberArquivo()) {
			LOG.debug("Salvando Headers");
			try {
				// Adicionando Headers
				id = identificacaoService.salvaHeaderArquivos();
				response.setDatas(id);
				LOG.info("Headers Salvos com sucesso!");

				if (!id.isEmpty()) {
					// Adicionando Registros
					LOG.debug("Salvando Registros!");
					identificacaoService.definindoLeituraArquivos();
				}
				return ResponseEntity.ok(response);

			} catch (Exception e) {
				response.getErrors().add("Erro,Em nossa base de dados já contém esse Arquivo");
				StringBuilder errosBuilder = new StringBuilder();
				response.getErrors().stream().forEach(s -> {
					errosBuilder.append("Erros: ").append(s).append(" ");
				});
				LOG.info(errosBuilder.toString());
				return ResponseEntity.badRequest().body(response);
			}

		} else {
			response.getErrors().add("Sem arquivos para ser recebido.");
			StringBuilder errosBuilder = new StringBuilder();
			response.getErrors().stream().forEach(s -> {
				errosBuilder.append("Erros: ").append(s).append(" ");
			});
			LOG.info(errosBuilder.toString());
			return ResponseEntity.badRequest().body(response);
		}
	}
}
