package br.com.transacao.pagamento.total.receber;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "total_recebimento_matriz")
public class PagamentoReceberTotal {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long pagamentoTotalId;
	private Integer tipoRegistro;
	private Integer codigoPontoVenda;
	private Date dataCredito;
	private Double valorTotalCredito;
	private Integer numeroBanco;
	private Integer numeroAgencia;
	private Integer numeroContaCorrente;
	private Date dataGeracaoArquivo;
	private Date dataCreditoAntecipado;

	public Long getPagamentoTotalId() {
		return pagamentoTotalId;
	}

	public void setPagamentoTotalId(Long pagamentoTotalId) {
		this.pagamentoTotalId = pagamentoTotalId;
	}

	public Integer getTipoRegistro() {
		return tipoRegistro;
	}

	public void setTipoRegistro(Integer tipoRegistro) {
		this.tipoRegistro = tipoRegistro;
	}



	public Integer getCodigoPontoVenda() {
		return codigoPontoVenda;
	}

	public void setCodigoPontoVenda(Integer codigoPontoVenda) {
		this.codigoPontoVenda = codigoPontoVenda;
	}


	public Date getDataCredito() {
		return dataCredito;
	}

	public void setDataCredito(Date dataCredito) {
		this.dataCredito = dataCredito;
	}

	public Double getValorTotalCredito() {
		return valorTotalCredito;
	}

	public void setValorTotalCredito(Double valorTotalCredito) {
		this.valorTotalCredito = valorTotalCredito;
	}

	

	public Integer getNumeroBanco() {
		return numeroBanco;
	}

	public void setNumeroBanco(Integer numeroBanco) {
		this.numeroBanco = numeroBanco;
	}

	public Integer getNumeroAgencia() {
		return numeroAgencia;
	}

	public void setNumeroAgencia(Integer numeroAgencia) {
		this.numeroAgencia = numeroAgencia;
	}

	public Integer getNumeroContaCorrente() {
		return numeroContaCorrente;
	}

	public void setNumeroContaCorrente(Integer numeroContaCorrente) {
		this.numeroContaCorrente = numeroContaCorrente;
	}

	public Date getDataGeracaoArquivo() {
		return dataGeracaoArquivo;
	}

	public void setDataGeracaoArquivo(Date dataGeracaoArquivo) {
		this.dataGeracaoArquivo = dataGeracaoArquivo;
	}

	public Date getDataCreditoAntecipado() {
		return dataCreditoAntecipado;
	}

	public void setDataCreditoAntecipado(Date dataCreditoAntecipado) {
		this.dataCreditoAntecipado = dataCreditoAntecipado;
	}

	public Date converteData(String s) {
		Date data = null;
		if (!s.equals("00000000")) {
			data = java.sql.Date.valueOf(LocalDate.parse(s, DateTimeFormatter.ofPattern("ddMMyyyy")));
		}
		return data;
	}
}
