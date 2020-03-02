package br.com.transacao.arquivo.identificacao;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.autogeral.redecar.eefi.Registro030HeaderArquivo;
import br.com.autogeral.redecar.eefi.Registro034Creditos;
import br.com.autogeral.redecar.eefi.Registro037TotalizadorCreditos;
import br.com.autogeral.redecar.eesa.Registro062CabecalhoArquivo;
import br.com.autogeral.redecard.Leitor;
import br.com.autogeral.redecard.RegistroRedecard;
import br.com.autogeral.redecard.eevc.Registro002HeaderArquivo;
import br.com.autogeral.redecard.eevc.Registro008CVnsuRotativo;
import br.com.autogeral.redecard.eevc.Registro12CVnsuparceladosemJuros;
import br.com.autogeral.redecard.eevd.Registro00CabecalhoArquivo;
import br.com.autogeral.redecard.eevd.RegistroTipo05DetalhamentoComprovantes;
import br.com.transacao.pagamento.total.receber.PagamentoReceberTotalService;
import br.com.transacao.pagamentos.areceber.PagamentoReceberService;
import br.com.transacao.vendas.TransacaoService;

@Service
public class IdentificacaoService {

	@Autowired
	private PagamentoReceberTotalService pagamentoReceberTotalService;
	@Autowired
	private PagamentoReceberService pagamentoReceberService;
	@Autowired
	private TransacaoService transacaoService;
	@Autowired
	private IdentificaoRepository identificacaoRepository;

	private List<RegistroRedecard> recebimentoPagamentoTotal = new ArrayList<RegistroRedecard>();
	private List<RegistroRedecard> pagamentosProcessados = new ArrayList<RegistroRedecard>();
	private List<RegistroRedecard> recimentoPagamento = new ArrayList<RegistroRedecard>();
	private Leitor leitor = new Leitor();
	 List<RegistroRedecard> listComprovantes = new ArrayList<RegistroRedecard>();
	 List<IdentificacaoFile> identificaoArquivo = new ArrayList<IdentificacaoFile>();

	public void receberArquivo() {

		File diretorio = new File("C:\\Users\\kaique.mota\\Documents\\Tivit_05022020_211715");
		leitor.defineLeituraArquivo(diretorio);
		listComprovantes = Leitor.registros.stream().collect(Collectors.toList());
		vefificaExistencia(listComprovantes);
		definindoLeituraArquivos(listComprovantes);

	}

	private void vefificaExistencia(List<RegistroRedecard> listComprovantes2) {
		List<RegistroRedecard> rd = new ArrayList<RegistroRedecard>();

		rd = Leitor.registros.stream()
				.filter(rs -> rs instanceof Registro002HeaderArquivo || rs instanceof Registro062CabecalhoArquivo
						|| rs instanceof Registro030HeaderArquivo || rs instanceof Registro00CabecalhoArquivo)
				.collect(Collectors.toList());

		if (!rd.isEmpty() && rd != null) {
			for (RegistroRedecard r : rd) {
				IdentificacaoFile id = new IdentificacaoFile();
				if (r instanceof Registro002HeaderArquivo) {
					Registro002HeaderArquivo rr = (Registro002HeaderArquivo) r;
					id.setTipoRegistro(rr.getTipoRegistro());
					id.setDataEmissao(rr.getDataEmissao());
					id.setAdquirente(rr.getAdquirente());
					id.setExtratoMovimentacaoFinanceira(rr.getExtratoEletronicoVendas());
					id.setSequenciaMovimento(rr.getSequenciaMovimento());
					id.setTipoProcessamento(rr.getTipoMovimento());
					id.setVersaoArquivo(rr.getVersaoArquivo());
					id.setNumGrupoOuMatriz(rr.getnPVgrupoMatriz());
					identificaoArquivo.add(id);

				} else if (r instanceof Registro030HeaderArquivo) {
					Registro030HeaderArquivo rr = (Registro030HeaderArquivo) r;
					id.setTipoRegistro(rr.getTipoRegistro());
					id.setDataEmissao(rr.getDataEmissao());
					id.setAdquirente(rr.getAdquirente());
					id.setExtratoMovimentacaoFinanceira(rr.getExtratoMovimentacaoFinanceira());
					id.setSequenciaMovimento(rr.getSequenciaMovimento());
					id.setTipoProcessamento(rr.getExtratoMovimentacaoFinanceira());
					id.setVersaoArquivo(rr.getVersaoArquivo());
					id.setNumGrupoOuMatriz(rr.getNumGrupoOuMatriz());
					identificaoArquivo.add(id);

				} else if (r instanceof Registro00CabecalhoArquivo) {
					Registro00CabecalhoArquivo rr = (Registro00CabecalhoArquivo) r;
					id.setTipoRegistro(0);
					id.setDataEmissao(rr.getDataEmissao());
					id.setAdquirente(rr.getAdquirente());
					id.setExtratoMovimentacaoFinanceira(rr.getMovimentacaoDiaria());
					id.setSequenciaMovimento(rr.getSequencia());
					id.setTipoProcessamento(rr.getTipoProcessamento());
					id.setVersaoArquivo(rr.getVersaoArquivo());
					id.setNumGrupoOuMatriz(rr.getNumeroFiliacao());
					identificaoArquivo.add(id);
				}
			}
			identificacaoRepository.saveAll(identificaoArquivo);
		}
	}

	private void definindoLeituraArquivos(List<RegistroRedecard> listComprovantes) {
		for (RegistroRedecard r : listComprovantes) {
			if (r instanceof Registro037TotalizadorCreditos) {
				recebimentoPagamentoTotal.add(r);
			}
			if (r instanceof Registro034Creditos) {
				recimentoPagamento.add(r);
			}
			if (r instanceof Registro12CVnsuparceladosemJuros) {
				pagamentosProcessados.add(r);
			}
			if (r instanceof Registro008CVnsuRotativo) {
				pagamentosProcessados.add(r);
			}
			if (r instanceof RegistroTipo05DetalhamentoComprovantes) {
				pagamentosProcessados.add(r);
			}
		}
		transacaoService.preencheObjetoTransacao(pagamentosProcessados);
		pagamentoReceberTotalService.preencheObjetoReceber(recebimentoPagamentoTotal);
		pagamentoReceberService.preencheObjetoReceber(recimentoPagamento);
	}
}
