/*
 * The MIT License
 *
 * Copyright 2020 kaique.mota.
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
package br.com.transacao.layout.eevc;

import br.com.transacao.layout.interfaces.ArquivoEEVC;
import com.ancientprogramming.fixedformat4j.annotation.Field;
import com.ancientprogramming.fixedformat4j.annotation.FixedFormatPattern;
import com.ancientprogramming.fixedformat4j.annotation.Record;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 11/02/2020 15:33:57
 *
 * @author kaique.mota
 */
@Record
@Entity
@Table(name = "eevc_resumo_rotativo")
public class Registro006RVrotativo implements ArquivoEEVC {

    private Integer tipoRegistro;
    private Integer numeroPV;
    @Id
    private Integer numeroRV;
    @OneToMany
    @JoinColumn(name = "resumo_venda_rotativo")
    private List<Registro008CVnsuRotativo> comprovantes = new ArrayList<>();
    private Integer numeroBanco;
    private Integer numeroAgencia;
    private Integer numContaCorrente;
    private Date dataRV;
    private Integer quantidadeCVeNUSacatados;
    private Double valorBruto;
    private Double valorGorgeta;
    private Double valorRejeitado;
    private Double valorDesconto;
    private Double valorLiquido;
    private Date dataCredito;
    private String bandeira;

    @Field(offset = 1, length = 3)
    public Integer getTipoRegistro() {
        return tipoRegistro;
    }

    public void setTipoRegistro(Integer tipoRegistro) {
        this.tipoRegistro = tipoRegistro;
    }

    @Field(offset = 4, length = 9)
    public Integer getNumeroPv() {
        return numeroPV;
    }

    public void setNumeroPv(Integer numeroPv) {
        this.numeroPV = numeroPv;
    }

    @Field(offset = 13, length = 9)
    public Integer getNumeroRV() {
        return numeroRV;
    }

    public void setNumeroRV(Integer numeroRV) {
        this.numeroRV = numeroRV;
    }

    @Field(offset = 22, length = 3)
    public Integer getNumeroBanco() {
        return numeroBanco;
    }

    public void setNumeroBanco(Integer numeroBanco) {
        this.numeroBanco = numeroBanco;
    }

    @Field(offset = 25, length = 5)
    public Integer getNumeroAgencia() {
        return numeroAgencia;
    }

    public void setNumeroAgencia(Integer numeroAgencia) {
        this.numeroAgencia = numeroAgencia;
    }

    @Field(offset = 30, length = 11)
    public Integer getNumContaCorrente() {
        return numContaCorrente;
    }

    public void setNumContaCorrente(Integer numContaCorrente) {
        this.numContaCorrente = numContaCorrente;
    }

    @Field(offset = 41, length = 8)
    @FixedFormatPattern("ddMMyyyy")
    public Date getDataRV() {
        return dataRV;
    }

    public void setDataRV(Date dataRV) {
        this.dataRV = dataRV;
    }

    @Field(offset = 49, length = 5)
    public Integer getQuantidadeCVeNUSacatados() {
        return quantidadeCVeNUSacatados;
    }

    public void setQuantidadeCVeNUSacatados(Integer quantidadeCVeNUSacatados) {
        this.quantidadeCVeNUSacatados = quantidadeCVeNUSacatados;
    }

    @Field(offset = 54, length = 15)
    public Double getValorBruto() {
        return valorBruto;
    }

    public void setValorBruto(Double valorBruto) {
        this.valorBruto = valorBruto;
    }

    @Field(offset = 69, length = 15)
    public Double getValorGorgeta() {
        return valorGorgeta;
    }

    public void setValorGorgeta(Double valorGorgeta) {
        this.valorGorgeta = valorGorgeta;
    }

    @Field(offset = 84, length = 15)
    public Double getValorRejeitado() {
        return valorRejeitado;
    }

    public void setValorRejeitado(Double valorRejeitado) {
        this.valorRejeitado = valorRejeitado;
    }

    @Field(offset = 99, length = 15)
    public Double getValorDesconto() {
        return valorDesconto;
    }

    public void setValorDesconto(Double valorDesconto) {
        this.valorDesconto = valorDesconto;
    }

    @Field(offset = 114, length = 15)
    public Double getValorLiquido() {
        return valorLiquido;
    }

    public void setValorLiquido(Double valorLiquido) {
        this.valorLiquido = valorLiquido;
    }

    @Field(offset = 129, length = 8)
    @FixedFormatPattern("ddMMyyyy")
    public Date getDataCredito() {
        return dataCredito;
    }

    public void setDataCredito(Date dataCredito) {
        this.dataCredito = dataCredito;
    }

    @Field(offset = 137, length = 1)
    public String getBandeira() {
        return bandeira;
    }

    public void setBandeira(String bandeira) {
        this.bandeira = bandeira;
    }

    public void addComprovante(Registro008CVnsuRotativo a) {
        comprovantes.add(a);
    }

    public Integer getNumeroPV() {
        return numeroPV;
    }

    public void setNumeroPV(Integer numeroPV) {
        this.numeroPV = numeroPV;
    }

    public List<Registro008CVnsuRotativo> getComprovantes() {
        return comprovantes;
    }

    public void setComprovantes(List<Registro008CVnsuRotativo> comprovantes) {
        this.comprovantes = comprovantes;
    }

    @Override
    public String toString() {
        return "Registro006RVrotativo{" + "tipoRegistro=" + tipoRegistro + ", numeroPV=" + numeroPV + ", numeroRV=" + numeroRV + ", numeroBanco=" + numeroBanco + ", numeroAgencia=" + numeroAgencia + ", numContaCorrente=" + numContaCorrente + ", dataRV=" + dataRV + ", quantidadeCVeNUSacatados=" + quantidadeCVeNUSacatados + ", valorBruto=" + valorBruto + ", valorGorgeta=" + valorGorgeta + ", valorRejeitado=" + valorRejeitado + ", valorDesconto=" + valorDesconto + ", valorLiquido=" + valorLiquido + ", dataCredito=" + dataCredito + ", bandeira=" + bandeira + '}';
    }

}
