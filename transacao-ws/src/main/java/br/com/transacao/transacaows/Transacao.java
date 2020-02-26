package br.com.transacao.transacaows;

import java.util.Date;

public class Transacao {

	private Integer tipoRegistro;
	private Integer numeroPontoVenda;
	private Integer numeroParcela;
	private Integer numeroResumoVenda;
	private Date dataComprovante;
	private String horaTransacao;
	private String numeroAutorizacao;
	private String statusComprovanteVenda;
	private Double valorComprovante;
	private Double valorDesconto;
	private Double valorLiquido;
	private Double valorliquidoRejeitado;
	private Double valorLiquidoPrimeiraParcela;
	private Double valorLiquidoDemaisParcelas;
	private Date dataCredito;
	private String numeroCartao;
	private String numeroTerminal;
	private String tipoCaptura;

	public Integer getTipoRegistro() {
		return tipoRegistro;
	}

	public void setTipoRegistro(Integer tipoRegistro) {
		this.tipoRegistro = tipoRegistro;
	}

	public Integer getNumeroPontoVenda() {
		return numeroPontoVenda;
	}

	public void setNumeroPontoVenda(Integer numeroPontoVenda) {
		this.numeroPontoVenda = numeroPontoVenda;
	}

	public Integer getNumeroParcela() {
		return numeroParcela;
	}

	public void setNumeroParcela(Integer numeroParcela) {
		this.numeroParcela = numeroParcela;
	}

	public Integer getNumeroResumoVenda() {
		return numeroResumoVenda;
	}

	public void setNumeroResumoVenda(Integer numeroResumoVenda) {
		this.numeroResumoVenda = numeroResumoVenda;
	}

	public Date getDataComprovante() {
		return dataComprovante;
	}

	public void setDataComprovante(Date dataComprovante) {
		this.dataComprovante = dataComprovante;
	}

	public String getHoraTransacao() {
		return horaTransacao;
	}

	public void setHoraTransacao(String horaTransacao) {
		this.horaTransacao = horaTransacao;
	}

	public String getNumeroAutorizacao() {
		return numeroAutorizacao;
	}

	public void setNumeroAutorizacao(String numeroAutorizacao) {
		this.numeroAutorizacao = numeroAutorizacao;
	}

	public String getStatusComprovanteVenda() {
		return statusComprovanteVenda;
	}

	public void setStatusComprovanteVenda(String statusComprovanteVenda) {
		this.statusComprovanteVenda = statusComprovanteVenda;
	}

	public Double getValorComprovante() {
		return valorComprovante;
	}

	public void setValorComprovante(Double valorComprovante) {
		this.valorComprovante = valorComprovante;
	}

	public Double getValorDesconto() {
		return valorDesconto;
	}

	public void setValorDesconto(Double valorDesconto) {
		this.valorDesconto = valorDesconto;
	}

	public Double getValorLiquido() {
		return valorLiquido;
	}

	public void setValorLiquido(Double valorLiquido) {
		this.valorLiquido = valorLiquido;
	}

	public Double getValorliquidoRejeitado() {
		return valorliquidoRejeitado;
	}

	public void setValorliquidoRejeitado(Double valorliquidoRejeitado) {
		this.valorliquidoRejeitado = valorliquidoRejeitado;
	}

	public Double getValorLiquidoPrimeiraParcela() {
		return valorLiquidoPrimeiraParcela;
	}

	public void setValorLiquidoPrimeiraParcela(Double valorLiquidoPrimeiraParcela) {
		this.valorLiquidoPrimeiraParcela = valorLiquidoPrimeiraParcela;
	}

	public Double getValorLiquidoDemaisParcelas() {
		return valorLiquidoDemaisParcelas;
	}

	public void setValorLiquidoDemaisParcelas(Double valorLiquidoDemaisParcelas) {
		this.valorLiquidoDemaisParcelas = valorLiquidoDemaisParcelas;
	}

	public Date getDataCredito() {
		return dataCredito;
	}

	public void setDataCredito(Date dataCredito) {
		this.dataCredito = dataCredito;
	}

	public String getNumeroCartao() {
		return numeroCartao;
	}

	public void setNumeroCartao(String numeroCartao) {
		this.numeroCartao = numeroCartao;
	}

	public String getNumeroTerminal() {
		return numeroTerminal;
	}

	public void setNumeroTerminal(String numeroTerminal) {
		this.numeroTerminal = numeroTerminal;
	}

	public String getTipoCaptura() {
		return tipoCaptura;
	}

	public void setTipoCaptura(String tipoCaptura) {
		this.tipoCaptura = tipoCaptura;
	}

	@Override
	public String toString() {
		return "TransacaoCredito [tipoRegistro=" + tipoRegistro + ", numeroPontoVenda=" + numeroPontoVenda
				+ ", numeroParcela=" + numeroParcela + ", numeroResumoVenda=" + numeroResumoVenda + ", dataComprovante="
				+ dataComprovante + ", horaTransacao=" + horaTransacao + ", numeroAutorizacao=" + numeroAutorizacao
				+ ", statusComprovanteVenda=" + statusComprovanteVenda + ", valorComprovante=" + valorComprovante
				+ ", valorDesconto=" + valorDesconto + ", valorLiquido=" + valorLiquido + ", valorliquidoRejeitado="
				+ valorliquidoRejeitado + ", valorLiquidoPrimeiraParcela=" + valorLiquidoPrimeiraParcela
				+ ", valorLiquidoDemaisParcelas=" + valorLiquidoDemaisParcelas + ", dataCredito=" + dataCredito
				+ ", numeroCartao=" + numeroCartao + ", numeroTerminal=" + numeroTerminal + ", tipoCaptura="
				+ tipoCaptura + "]";
	}

}
