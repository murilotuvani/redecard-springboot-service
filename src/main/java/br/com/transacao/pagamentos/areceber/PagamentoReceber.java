package br.com.transacao.pagamentos.areceber;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "recebimento_processados")
public class PagamentoReceber {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long pagamentoReceberId;
	private Integer tipoRegistro;
	private Integer numeroPVcentralizador;
	private Long numeroDocumento;
	private Date dataLancamento;
	private Double valorLancamento;
	private String creditoC;
	private Integer banco;
	private Integer agencia;
	private Integer contaCorrente;
	private Date dataMovimento;
	private Integer numeroRV;
	private Date dataRV;
	private String bandeira;
	private Integer tipoTransacao;
	private Double valorBrutoRV;
	private Double valorTaxaDesconto;
	private String numeroParcelaTotal;
	private String statusCredito;
	private Integer numeroPVoriginal;

	public Long getPagamentoReceberId() {
		return pagamentoReceberId;
	}

	public void setPagamentoReceberId(Long pagamentoReceberId) {
		this.pagamentoReceberId = pagamentoReceberId;
	}

	public Integer getTipoRegistro() {
		return tipoRegistro;
	}

	public void setTipoRegistro(Integer tipoRegistro) {
		this.tipoRegistro = tipoRegistro;
	}

	public Integer getNumeroPVcentralizador() {
		return numeroPVcentralizador;
	}

	public void setNumeroPVcentralizador(Integer numeroPVcentralizador) {
		this.numeroPVcentralizador = numeroPVcentralizador;
	}

	public Long getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(Long numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public Date getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(Date dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	public Double getValorLancamento() {
		return valorLancamento;
	}

	public void setValorLancamento(Double valorLancamento) {
		this.valorLancamento = valorLancamento;
	}

	public String getCreditoC() {
		return creditoC;
	}

	public void setCreditoC(String creditoC) {
		this.creditoC = creditoC;
	}

	public Integer getBanco() {
		return banco;
	}

	public void setBanco(Integer banco) {
		this.banco = banco;
	}

	public Integer getAgencia() {
		return agencia;
	}

	public void setAgencia(Integer agencia) {
		this.agencia = agencia;
	}

	public Integer getContaCorrente() {
		return contaCorrente;
	}

	public void setContaCorrente(Integer contaCorrente) {
		this.contaCorrente = contaCorrente;
	}

	public Date getDataMovimento() {
		return dataMovimento;
	}

	public void setDataMovimento(Date dataMovimento) {
		this.dataMovimento = dataMovimento;
	}

	public Integer getNumeroRV() {
		return numeroRV;
	}

	public void setNumeroRV(Integer numeroRV) {
		this.numeroRV = numeroRV;
	}

	public Date getDataRV() {
		return dataRV;
	}

	public void setDataRV(Date dataRV) {
		this.dataRV = dataRV;
	}

	public String getBandeira() {
		return bandeira;
	}

	public void setBandeira(String bandeira) {
		this.bandeira = bandeira;
	}

	public Integer getTipoTransacao() {
		return tipoTransacao;
	}

	public void setTipoTransacao(Integer tipoTransacao) {
		this.tipoTransacao = tipoTransacao;
	}

	public Double getValorBrutoRV() {
		return valorBrutoRV;
	}

	public void setValorBrutoRV(Double valorBrutoRV) {
		this.valorBrutoRV = valorBrutoRV;
	}

	public Double getValorTaxaDesconto() {
		return valorTaxaDesconto;
	}

	public void setValorTaxaDesconto(Double valorTaxaDesconto) {
		this.valorTaxaDesconto = valorTaxaDesconto;
	}

	public String getNumeroParcelaTotal() {
		return numeroParcelaTotal;
	}

	public void setNumeroParcelaTotal(String numeroParcelaTotal) {
		this.numeroParcelaTotal = numeroParcelaTotal;
	}

	public String getStatusCredito() {
		return statusCredito;
	}

	public void setStatusCredito(String statusCredito) {
		this.statusCredito = statusCredito;
	}

	public Integer getNumeroPVoriginal() {
		return numeroPVoriginal;
	}

	public void setNumeroPVoriginal(Integer numeroPVoriginal) {
		this.numeroPVoriginal = numeroPVoriginal;
	}

}
