package br.com.transacao.vendas;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.autogeral.redecard.RegistroRedecard;
import br.com.autogeral.redecard.eevc.Registro008CVnsuRotativo;
import br.com.autogeral.redecard.eevc.Registro12CVnsuparceladosemJuros;
import br.com.autogeral.redecard.eevd.RegistroTipo05DetalhamentoComprovantes;

@Service
public class TransacaoService {

	Logger LOGGER = Logger.getLogger(TransacaoService.class.getName());
	List<Transacao> transacoesSalvas = new ArrayList<Transacao>();

	@Autowired
	private TransacaoRepository transacaoRepository;

	public List<Transacao> list() {
		return transacaoRepository.findAll();
	}

	public void preencheObjetoTransacao(List<RegistroRedecard> list) {
		for (RegistroRedecard r : list) {
			if (r instanceof Registro12CVnsuparceladosemJuros) {
				Registro12CVnsuparceladosemJuros r12 = (Registro12CVnsuparceladosemJuros) r;

				Transacao t = new Transacao();
				t.setTipoRegistro(r12.getTipoRegistro());
				t.setNumeroPontoVenda(r12.getNumeroPV());
				t.setNumeroParcela(r12.getNumeroParcelas());
				t.setNumeroResumoVenda(r12.getNumeroRV());
				t.setDataComprovante(r12.getDataCVnsu());
				t.setHoraTransacao(t.convertTime(r12.getHoraTransacao()));
				t.setNumeroAutorizacao(r12.getNumeroAutorizacao());
				t.setStatusComprovanteVenda(Integer.toString(r12.getNumeroCVnsu()));
				t.setValorComprovante(r12.getValorCVnsu());
				t.setValorDesconto(r12.getValorDesconto());
				t.setValorLiquido(r12.getValorLiquido());
				t.setValorLiquidoPrimeiraParcela(r12.getValorLiquido1parcela());
				t.setValorLiquidoDemaisParcelas(r12.getValorLiquidoDemaisParcelas());
				t.setNumeroCartao(r12.getNumeroCartao());
				t.setNumeroTerminal(r12.getNumeroTerminal());
				t.setTipoCaptura(r12.getTipoCaptura());
				transacoesSalvas.add(t);

			} else if (r instanceof Registro008CVnsuRotativo) {
				Registro008CVnsuRotativo r8 = (Registro008CVnsuRotativo) r;

				Transacao t = new Transacao();
				t.setTipoRegistro(r8.getTipoRegistro());
				t.setNumeroPontoVenda(r8.getNumeroPV());
				t.setNumeroResumoVenda(r8.getNumeroRV());
				t.setDataComprovante(r8.getDataCVnsu());
				t.setHoraTransacao(t.convertTime(r8.getHoraTransacao()));
				t.setNumeroAutorizacao(r8.getNumAutorizacao());
				t.setStatusComprovanteVenda(Integer.toString(r8.getNumeroCVnsu()));
				t.setValorComprovante(r8.getValorCVnsu());
				t.setValorDesconto(r8.getValorDesconto());
				t.setValorLiquido(r8.getValorLiquido());
				t.setNumeroCartao(r8.getNumeroCartao());
				t.setNumeroTerminal(r8.getNumeroTerminal());
				t.setTipoCaptura(r8.getTipoCaptura());
				transacoesSalvas.add(t);
			} else if (r instanceof RegistroTipo05DetalhamentoComprovantes) {
				RegistroTipo05DetalhamentoComprovantes r5 = (RegistroTipo05DetalhamentoComprovantes) r;

				Transacao t = new Transacao();
				t.setTipoRegistro(r5.getTipoRegistro());
				t.setNumeroPontoVenda(r5.getNumeroFiliacaoPontovenda());
				t.setNumeroResumoVenda(r5.getNumeroResumoVendas());
				t.setDataComprovante(r5.getDataCV());
				t.setHoraTransacao(t.convertTime(r5.getHoraTransacao()));
				t.setNumeroAutorizacao(Integer.toString(r5.getNumeroCV()));
				t.setStatusComprovanteVenda(Integer.toString(r5.getStatusTransacao()));
				t.setValorComprovante(r5.getValorBruto());
				t.setValorDesconto(r5.getValorDesconto());
				t.setValorLiquido(r5.getValorLiquido());
				t.setNumeroCartao(r5.getNumeroCartao());
				t.setNumeroTerminal(r5.getNumeroTerminal());
				t.setTipoCaptura(Integer.toString(r5.getTipoCaptura()));
				t.setDataCredito(r5.getDataCredito());
				transacoesSalvas.add(t);
			}
		}
		transacaoRepository.saveAll(transacoesSalvas);
	}

}
