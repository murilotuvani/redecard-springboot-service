package br.com.transacao.pagamento.total.receber;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.autogeral.redecar.eefi.Registro037TotalizadorCreditos;
import br.com.autogeral.redecard.RegistroRedecard;

@Service
public class PagamentoReceberTotalService {

	@Autowired
	private PagamentoReceberTotalRepository pagamentoReceberRepository;
	List<PagamentoReceberTotal> recebimentosSalvos = new ArrayList<PagamentoReceberTotal>();

	public List<PagamentoReceberTotal> list() {
		return pagamentoReceberRepository.findAll();
	}

	public void preencheObjetoReceber(List<RegistroRedecard> listComprovantes) {
		for (RegistroRedecard r : listComprovantes) {
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
			recebimentosSalvos.add(t);
		}
		pagamentoReceberRepository.saveAll(recebimentosSalvos);
	}
}
