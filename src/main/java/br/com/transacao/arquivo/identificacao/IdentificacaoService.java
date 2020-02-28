package br.com.transacao.arquivo.identificacao;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.autogeral.redecard.Leitor;
import br.com.autogeral.redecard.RegistroRedecard;

@Service
public class IdentificacaoService {

	@Autowired
	private IdentificacaoRepository pagamentoReceberRepository;

	List<Identificacao> identificados = new ArrayList<Identificacao>();

	public List<Identificacao> list() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Identificacao> receberArquivo() {
		List<RegistroRedecard> listComprovantes;
		File diretorio = new File("C:\\Users\\kaique.mota\\Documents\\Tivit_05022020_211715");
		Leitor leitor = new Leitor();
		leitor.defineLeituraArquivo(diretorio);

		listComprovantes = Leitor.registros.stream().filter(c -> c.getTipoRegistro().equals(34))
				.collect(Collectors.toList());

		preencheObjetoReceber(listComprovantes);

		return identificados;
	}

	private void preencheObjetoReceber(List<RegistroRedecard> listComprovantes) {
		// TODO Auto-generated method stub
		pagamentoReceberRepository.toString();
	}
}
