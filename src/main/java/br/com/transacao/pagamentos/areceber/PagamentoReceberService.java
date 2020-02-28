package br.com.transacao.pagamentos.areceber;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.autogeral.redecar.eefi.Registro034Creditos;
import br.com.autogeral.redecard.Leitor;
import br.com.autogeral.redecard.RegistroRedecard;

@Service
public class PagamentoReceberService {

	@Autowired
	private PagamentoReceberRepository pagamentoReceberRepository;
	List<PagamentoReceber> recebimentosSalvos = new ArrayList<PagamentoReceber>();

	public List<PagamentoReceber> list() {
		return pagamentoReceberRepository.findAll();
	}

	public  List<PagamentoReceber> receber() {
		List<RegistroRedecard> listComprovantes;
		File diretorio = new File("C:\\Users\\kaique.mota\\Documents\\Tivit_05022020_211715");
		Leitor leitor = new Leitor();
		leitor.defineLeituraArquivo(diretorio);

		listComprovantes = Leitor.registros.stream().filter(c -> c.getTipoRegistro().equals(34))
				.collect(Collectors.toList());

		preencheObjetoReceber(listComprovantes);

		return recebimentosSalvos;
	}

	private void preencheObjetoReceber(List<RegistroRedecard> listComprovantes) {

		for (RegistroRedecard r : listComprovantes) {
			if (r instanceof Registro034Creditos) {
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
				pagamentoReceberRepository.save(p);
				recebimentosSalvos.add(p);
			}
		}
	}
}
