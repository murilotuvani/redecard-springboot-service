package br.com.transacao.transacaows;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.autogeral.redecard.Leitor;
import br.com.autogeral.redecard.RegistroRedecard;
import br.com.autogeral.redecard.eevc.Registro12CVnsuparceladosemJuros;

@RestController
@RequestMapping("/transacao")
public class TransacaoController {

	@Autowired
	private TransacaoService serviceTransacao;

	@RequestMapping("/")
	public String index() {
		return "Hello World";

	}

	@RequestMapping("/venda")
	public String headerArquivo() {
		
		serviceTransacao.transacoes();

		


		return null;

	}

}
