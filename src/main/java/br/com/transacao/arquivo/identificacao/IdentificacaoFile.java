package br.com.transacao.arquivo.identificacao;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "identificacao_arquivos_lidos")
public class IdentificacaoFile {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idIdentificaoFile;
	private Integer tipoRegistro;
    private Date dataEmissao;
    private String adquirente;
    private String extratoMovimentacaoFinanceira;
    private Integer sequenciaMovimento;
    private Integer numGrupoOuMatriz;
    private String tipoProcessamento;
    private String versaoArquivo;
    
   
    
	public Integer getIdIdentificaoFile() {
		return idIdentificaoFile;
	}
	public void setIdIdentificaoFile(Integer idIdentificaoFile) {
		this.idIdentificaoFile = idIdentificaoFile;
	}
	public Integer getTipoRegistro() {
		return tipoRegistro;
	}
	public void setTipoRegistro(Integer tipoRegistro) {
		this.tipoRegistro = tipoRegistro;
	}
	public Date getDataEmissao() {
		return dataEmissao;
	}
	public void setDataEmissao(Date dataEmissao) {
		this.dataEmissao = dataEmissao;
	}
	public String getAdquirente() {
		return adquirente;
	}
	public void setAdquirente(String adquirente) {
		this.adquirente = adquirente;
	}
	public String getExtratoMovimentacaoFinanceira() {
		return extratoMovimentacaoFinanceira;
	}
	public void setExtratoMovimentacaoFinanceira(String extratoMovimentacaoFinanceira) {
		this.extratoMovimentacaoFinanceira = extratoMovimentacaoFinanceira;
	}
	public Integer getSequenciaMovimento() {
		return sequenciaMovimento;
	}
	public void setSequenciaMovimento(Integer sequenciaMovimento) {
		this.sequenciaMovimento = sequenciaMovimento;
	}
	public Integer getNumGrupoOuMatriz() {
		return numGrupoOuMatriz;
	}
	public void setNumGrupoOuMatriz(Integer numGrupoOuMatriz) {
		this.numGrupoOuMatriz = numGrupoOuMatriz;
	}
	public String getTipoProcessamento() {
		return tipoProcessamento;
	}
	public void setTipoProcessamento(String tipoProcessamento) {
		this.tipoProcessamento = tipoProcessamento;
	}
	public String getVersaoArquivo() {
		return versaoArquivo;
	}
	public void setVersaoArquivo(String versaoArquivo) {
		this.versaoArquivo = versaoArquivo;
	} 
	
    
    
}
