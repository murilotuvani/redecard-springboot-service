package br.com.transacao.pagamentos.areceber;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.autogeral.redecar.eefi.Registro034Creditos;
import br.com.autogeral.redecard.RegistroRedecard;

@Service
public class PagamentoReceberService {

	@Autowired
	private PagamentoReceberRepository pagamentoReceberRepository;
	List<PagamentoReceber> recebimentosSalvos = new ArrayList<PagamentoReceber>();

	public List<PagamentoReceber> list() {
		return pagamentoReceberRepository.findAll();
	}

	public void preencheObjetoReceber(List<RegistroRedecard> listComprovantes) {

		for (RegistroRedecard r : listComprovantes) {

			Registro034Creditos r34 = (Registro034Creditos) r;
			PagamentoReceber p = new PagamentoReceber();

			p.setTipoRegistro(r34.getTipoRegistro());
			p.setNumeroPVcentralizador(r34.getNumeroPVcentralizador());
			p.setNumeroDocumento(r34.getNumeroDocumento());
			p.setDataLancamento(r34.getDataLancamento());
			p.setValorLancamento(r34.getValorLancamento());
			p.setCreditoC(r34.getCreditoC());
			p.setBanco(r34.getBanco());
			p.setAgencia(r34.getAgencia());
			p.setContaCorrente(r34.getContaCorrente());
			p.setDataMovimento(r34.getDataMovimento());
			p.setNumeroRV(r34.getNumeroRV());
			p.setDataRV(r34.getDataRV());
			p.setBandeira(r34.getBandeira());
			p.setTipoTransacao(r34.getTipoTransacao());
			p.setValorBrutoRV(r34.getValorBrutoRV());
			p.setValorTaxaDesconto(r34.getValorTaxaDesconto());
			p.setNumeroParcelaTotal(r34.getNumeroParcelaTotal());
			p.setStatusCredito(r34.getStatusCredito());
			p.setNumeroPVoriginal(r34.getNumeroPVoriginal());
			recebimentosSalvos.add(p);
		}
		pagamentoReceberRepository.saveAll(recebimentosSalvos);
	}
}
