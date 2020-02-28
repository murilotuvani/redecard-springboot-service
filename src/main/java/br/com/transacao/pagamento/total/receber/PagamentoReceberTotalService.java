package br.com.transacao.pagamento.total.receber;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.autogeral.redecar.eefi.Registro037TotalizadorCreditos;
import br.com.autogeral.redecard.Leitor;
import br.com.autogeral.redecard.RegistroRedecard;

@Service
public class PagamentoReceberTotalService {

	@Autowired
	private PagamentoReceberTotalRepository pagamentoReceberRepository;
	List<PagamentoReceberTotal> recebimentosSalvos = new ArrayList<PagamentoReceberTotal>();

	public List<PagamentoReceberTotal> list() {
		return pagamentoReceberRepository.findAll();
	}

	public List<PagamentoReceberTotal> receberTotal() {
		List<RegistroRedecard> listComprovantes;
		File diretorio = new File("C:\\Users\\kaique.mota\\Documents\\Tivit_05022020_211715");
		Leitor leitor = new Leitor();
		leitor.defineLeituraArquivo(diretorio);

		listComprovantes = Leitor.registros.stream().filter(c -> c.getTipoRegistro().equals(37))
				.collect(Collectors.toList());

		preencheObjetoReceber(listComprovantes);

		return recebimentosSalvos;
	}

	private void preencheObjetoReceber(List<RegistroRedecard> listComprovantes) {
		for (RegistroRedecard r : listComprovantes) {
			if (r instanceof Registro037TotalizadorCreditos) {

				Registro037TotalizadorCreditos r037 = (Registro037TotalizadorCreditos) r;
				PagamentoReceberTotal t = new PagamentoReceberTotal();

				t.setTipoRegistro(r037.getTipoRegistro());
				t.setNumeroPV(r037.getNumeroPV());
				t.setDataCredito(r037.getDataCredito());
				t.setValorTotalCredito(r037.getValorTotalCredito());
				t.setNumeroBanco(r037.getNumeroBanco());
				t.setNumeroAgencia(r037.getNumeroAgencia());
				t.setBrancos(r037.getBrancos());
				t.setBrancos2(r037.getBrancos2());
				t.setNumeroContaCorrente(r037.getNumeroContaCorrente());
				t.setDataGeracaoArquivo(r037.getDataGeracaoArquivo());
				t.setDataCreditoAntecipado(t.converteData(r037.getDataCreditoAntecipado()));
				t.setValorTotalCreditos(r037.getValorTotalCreditos());
				pagamentoReceberRepository.save(t);
				recebimentosSalvos.add(t);
			}
		}
	}
}
