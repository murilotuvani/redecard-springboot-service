/*
 * The MIT License
 *
 * Copyright 2020 murilotuvani.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package br.com.transacao.layout.eevd;

import br.com.transacao.layout.interfaces.ArquivoEEVD;
import com.ancientprogramming.fixedformat4j.annotation.Field;
import com.ancientprogramming.fixedformat4j.annotation.FixedFormatPattern;
import com.ancientprogramming.fixedformat4j.annotation.Record;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 06/02/2020 21:54:57
 *
 * @author murilotuvani
 */
@Record
@Entity
@Table(name = "eevd_cabecalho")
public class Registro00CabecalhoArquivo implements ArquivoEEVD {
    @Id
    private Long sequencia;
    private Integer tipoRegistro;
    private Integer numeroFiliacao;
    private Date dataEmissao;
    private Date dataMovimento;
    private String movimentacaoDiaria;
    private String adquirente;
    private String nomeEstabelecimento;
    private String tipoProcessamento;
    private String versaoArquivo;
    @OneToMany(mappedBy = "cabecalhoArquivo")
    @Transient
    private List<RegistroTipo02TotalpontoVenda> filiais = new ArrayList<>();


    @Field(offset = 1, length = 2)
    public Integer getTipoRegistro() {
        return tipoRegistro;
    }

    public void setTipoRegistro(Integer tipoRegistro) {
        this.tipoRegistro = tipoRegistro;
    }

    @Field(offset = 3, length = 9)
    public Integer getNumeroFiliacao() {
        return numeroFiliacao;
    }

    public void setNumeroFiliacao(Integer numeroFiliacao) {
        this.numeroFiliacao = numeroFiliacao;
    }

    @Field(offset = 12, length = 8)
    @FixedFormatPattern("ddMMyyyy")
    public Date getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(Date dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    @Field(offset = 20, length = 8)
    @FixedFormatPattern("ddMMyyyy")
    public Date getDataMovimento() {
        return dataMovimento;
    }

    public void setDataMovimento(Date dataMovimento) {
        this.dataMovimento = dataMovimento;
    }

    @Field(offset = 28, length = 39)
    public String getMovimentacaoDiaria() {
        return movimentacaoDiaria;
    }

    public void setMovimentacaoDiaria(String movimentacaoDiaria) {
        this.movimentacaoDiaria = movimentacaoDiaria;
    }

    @Field(offset = 67, length = 8)
    public String getAdquirente() {
        return adquirente;
    }

    public void setAdquirente(String adquirente) {
        this.adquirente = adquirente;
    }

    @Field(offset = 75, length = 26)
    public String getNomeEstabelecimento() {
        return nomeEstabelecimento;
    }

    public void setNomeEstabelecimento(String nomeEstabelecimento) {
        this.nomeEstabelecimento = nomeEstabelecimento;
    }

    @Field(offset = 101, length = 6)
    public Long getSequencia() {
        return sequencia;
    }

    public void setSequencia(Long sequencia) {
        this.sequencia = sequencia;
    }

    @Field(offset = 107, length = 15)
    public String getTipoProcessamento() {
        return tipoProcessamento;
    }

    public void setTipoProcessamento(String tipoProcessamento) {
        this.tipoProcessamento = tipoProcessamento;
    }

    @Field(offset = 122, length = 20)
    public String getVersaoArquivo() {
        return versaoArquivo;
    }

    public void setVersaoArquivo(String versaoArquivo) {
        this.versaoArquivo = versaoArquivo;
    }

    public List<RegistroTipo02TotalpontoVenda> getFiliais() {
        return filiais;
    }

    public void setFiliais(List<RegistroTipo02TotalpontoVenda> filiais) {
        this.filiais = filiais;
    }

    public void addFilial(RegistroTipo02TotalpontoVenda filial) {
        filiais.add(filial);
        filial.setCabecalhoArquivo(this);
    }

    @Override
    public String toString() {
        return "Registro00CabecalhoArquivo{" + "tipoRegistro=" + tipoRegistro + ", numeroFiliacao=" + numeroFiliacao + ", dataEmissao=" + dataEmissao + ", dataMovimento=" + dataMovimento + ", movimentacaoDiaria=" + movimentacaoDiaria + ", adquirente=" + adquirente + ", nomeEstabelecimento=" + nomeEstabelecimento + ", sequencia=" + sequencia + ", tipoProcessamento=" + tipoProcessamento + ", versaoArquivo=" + versaoArquivo + '}';
    }

    @Override
    public Integer getRegistro() {
        return tipoRegistro;
    }

}
