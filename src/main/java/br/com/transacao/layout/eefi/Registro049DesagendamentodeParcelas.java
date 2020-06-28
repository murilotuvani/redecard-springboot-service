/*
 * The MIT License
 *
 * Copyright 2020 Kaique.
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
package br.com.transacao.layout.eefi;

import br.com.transacao.layout.interfaces.ArquivoEEFI;
import com.ancientprogramming.fixedformat4j.annotation.Field;
import com.ancientprogramming.fixedformat4j.annotation.FixedFormatPattern;
import com.ancientprogramming.fixedformat4j.annotation.Record;

import java.util.Date;

/**
 * @author Kaique
 * @see https://www.userede.com.br/pt-BR/produtosservicos/Documents/Extrato_Eletronico/0208_EEFI_Rede_0263_ExtratosOnlineFinanciamento(portugues).pdf
 */
@Record
public class Registro049DesagendamentodeParcelas implements ArquivoEEFI {

    private Integer tipoRegistro;
    private Long numeroPVoriginal;
    private Long numeroRVoriginal;
    private String numeroReferencia;
    private Date dataCredito;
    private Double novoValorParcela;
    private Double valorOriginalParcelaAlterada;
    private Double valorAjuste;
    private Date dataCancelamento;
    private Double valorRVoriginal;
    private Double valorCancelamentoSolicitado;
    private String numeroCartao;
    private Date dataTransacao;
    private Long NSU;
    private Integer tipoDebito;
    private Integer numeroParcela;
    private String bandeiraRVorigem;

    @Field(offset = 1, length = 3)
    public Integer getTipoRegistro() {
        return tipoRegistro;
    }

    public void setTipoRegistro(Integer tipoRegistro) {
        this.tipoRegistro = tipoRegistro;
    }

    @Field(offset = 4, length = 9)
    public Long getNumerpoPVoriginal() {
        return numeroPVoriginal;
    }

    public void setNumerpoPVoriginal(Long numerpoPVoriginal) {
        this.numeroPVoriginal = numerpoPVoriginal;
    }

    @Field(offset = 13, length = 9)
    public Long getNumeroRVoriginal() {
        return numeroRVoriginal;
    }

    public void setNumeroRVoriginal(Long numeroRVoriginal) {
        this.numeroRVoriginal = numeroRVoriginal;
    }

    @Field(offset = 22, length = 15)
    public String getNumeroReferencia() {
        return numeroReferencia;
    }

    public void setNumeroReferencia(String numeroReferencia) {
        this.numeroReferencia = numeroReferencia;
    }

    @Field(offset = 37, length = 8)
    @FixedFormatPattern("ddMMyyyy")
    public Date getDataCredito() {
        return dataCredito;
    }

    public void setDataCredito(Date dataCredito) {
        this.dataCredito = dataCredito;
    }

    @Field(offset = 45, length = 15)
    public Double getNovoValorParcela() {
        return novoValorParcela;
    }

    public void setNovoValorParcela(Double novoValorParcela) {
        this.novoValorParcela = novoValorParcela;
    }

    @Field(offset = 60, length = 15)
    public Double getValorOriginalParcelaAlterada() {
        return valorOriginalParcelaAlterada;
    }

    public void setValorOriginalParcelaAlterada(Double valorOriginalParcelaAlterada) {
        this.valorOriginalParcelaAlterada = valorOriginalParcelaAlterada;
    }

    @Field(offset = 75, length = 15)
    public Double getValorAjuste() {
        return valorAjuste;
    }

    public void setValorAjuste(Double valorAjuste) {
        this.valorAjuste = valorAjuste;
    }

    @Field(offset = 90, length = 8)
    @FixedFormatPattern("ddMMyyyy")
    public Date getDataCancelamento() {
        return dataCancelamento;
    }

    public void setDataCancelamento(Date dataCancelamento) {
        this.dataCancelamento = dataCancelamento;
    }

    @Field(offset = 98, length = 15)
    public Double getValorRVoriginal() {
        return valorRVoriginal;
    }

    public void setValorRVoriginal(Double valorRVoriginal) {
        this.valorRVoriginal = valorRVoriginal;
    }

    @Field(offset = 113, length = 15)
    public Double getValorCancelamentoSolicitado() {
        return valorCancelamentoSolicitado;
    }

    public void setValorCancelamentoSolicitado(Double valorCancelamentoSolicitado) {
        this.valorCancelamentoSolicitado = valorCancelamentoSolicitado;
    }

    @Field(offset = 128, length = 16)
    public String getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    @Field(offset = 144, length = 8)
    @FixedFormatPattern("ddMMyyyy")
    public Date getDataTransacao() {
        return dataTransacao;
    }

    public void setDataTransacao(Date dataTransacao) {
        this.dataTransacao = dataTransacao;
    }

    @Field(offset = 152, length = 12)
    public Long getNSU() {
        return NSU;
    }

    public void setNSU(Long NSU) {
        this.NSU = NSU;
    }

    @Field(offset = 164, length = 1)
    public Integer getTipoDebito() {
        return tipoDebito;
    }

    public void setTipoDebito(Integer tipoDebito) {
        this.tipoDebito = tipoDebito;
    }

    @Field(offset = 165, length = 2)
    public Integer getNumeroParcela() {
        return numeroParcela;
    }

    public void setNumeroParcela(Integer numeroParcela) {
        this.numeroParcela = numeroParcela;
    }

    @Field(offset = 167, length = 1)
    public String getBandeiraRVorigem() {
        return bandeiraRVorigem;
    }

    public void setBandeiraRVorigem(String bandeiraRVorigem) {
        this.bandeiraRVorigem = bandeiraRVorigem;
    }

    @Override
    public String toString() {
        return "Registro049DesagendamentodeParcelas{" + "tipoRegistro=" + tipoRegistro + ", numerpoPVoriginal=" + numeroPVoriginal + ", numeroRVoriginal=" + numeroRVoriginal + ", numeroReferencia=" + numeroReferencia + ", dataCredito=" + dataCredito + ", novoValorParcela=" + novoValorParcela + ", valorOriginalParcelaAlterada=" + valorOriginalParcelaAlterada + ", valorAjuste=" + valorAjuste + ", dataCancelamento=" + dataCancelamento + ", valorRVoriginal=" + valorRVoriginal + ", valorCancelamentoSolicitado=" + valorCancelamentoSolicitado + ", numeroCartao=" + numeroCartao + ", dataTransacao=" + dataTransacao + ", NSU=" + NSU + ", tipoDebito=" + tipoDebito + ", numeroParcela=" + numeroParcela + ", bandeiraRVorigem=" + bandeiraRVorigem + '}';
    }

}
