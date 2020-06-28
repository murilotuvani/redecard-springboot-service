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
package br.com.transacao.layout.eevd;

import br.com.transacao.layout.interfaces.ArquivoEEVD;
import com.ancientprogramming.fixedformat4j.annotation.Align;
import com.ancientprogramming.fixedformat4j.annotation.Field;
import com.ancientprogramming.fixedformat4j.annotation.FixedFormatPattern;
import com.ancientprogramming.fixedformat4j.annotation.Record;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 18/02/2020 08:00:25
 *
 * @see https://www.userede.com.br/novo/documentos
 * @author kaique.mota
 */
@Record
@Entity
@Table(name = "resumo_venda")
public class RegistroTipo01ResumoVendas implements ArquivoEEVD {

    private Integer tipoRegistro;
    private Integer numeroFiliacaopontoVenda;
    private Date dataCredito;
    private Date dataResumoVendas;
    @Id
    private Integer numeroResumoVenda;
    private Integer quantidadeComprovantesVendas;
    private Double valorBruto;
    private Double valorDesconto;
    private Double valorLiquido;
    private String tipoResumo;
    private Integer banco;
    private Integer agencia;
    private Integer contaCorrente;
    private String bandeira;
    @ManyToOne
    @JoinColumn(name = "filial_id")
    private RegistroTipo02TotalpontoVenda filial;
    @OneToMany(mappedBy = "resumoVenda")
    private List<RegistroTipo05DetalhamentoComprovantes> comprovantes = new ArrayList<>();

    @Field(offset = 1, length = 2 , paddingChar = 0, align=Align.RIGHT)
    public Integer getTipoRegistro() {
        return tipoRegistro;
    }

    public void setTipoRegistro(Integer tipoRegistro) {
        this.tipoRegistro = tipoRegistro;
    }

    @Field(offset = 3, length = 9)
    public Integer getNumeroFiliacaopontoVenda() {
        return numeroFiliacaopontoVenda;
    }


    @Field(offset = 12, length = 8)
    @FixedFormatPattern("ddMMyyyy")
    public Date getDataCredito() {
        return dataCredito;
    }

    public void setDataCredito(Date dataCredito) {
        this.dataCredito = dataCredito;
    }

    @Field(offset = 20, length = 8)
    @FixedFormatPattern("ddMMyyyy")
    public Date getDataResumoVendas() {
        return dataResumoVendas;
    }

    public void setDataResumoVendas(Date dataResumoVendas) {
        this.dataResumoVendas = dataResumoVendas;
    }

    @Field(offset = 28, length = 9)
    public Integer getNumeroResumoVenda() {
        return numeroResumoVenda;
    }

    public void setNumeroResumoVenda(Integer numeroResumoVenda) {
        this.numeroResumoVenda = numeroResumoVenda;
    }

    @Field(offset = 37, length = 6)
    public Integer getQuantidadeComprovantesVendas() {
        return quantidadeComprovantesVendas;
    }

    public void setQuantidadeComprovantesVendas(Integer quantidadeComprovantesVendas) {
        this.quantidadeComprovantesVendas = quantidadeComprovantesVendas;
    }

    @Field(offset = 43, length = 15)
    public Double getValorBruto() {
        return valorBruto;
    }

    public void setValorBruto(Double valorBruto) {
        this.valorBruto = valorBruto;
    }

    @Field(offset = 58, length = 15)
    public Double getValorDesconto() {
        return valorDesconto;
    }

    public void setValorDesconto(Double valorDesconto) {
        this.valorDesconto = valorDesconto;
    }

    @Field(offset = 73, length = 15)
    public Double getValorLiquido() {
        return valorLiquido;
    }

    public void setValorLiquido(Double valorLiquido) {
        this.valorLiquido = valorLiquido;
    }

    @Field(offset = 88, length = 1)
    public String getTipoResumo() {
        return tipoResumo;
    }

    public void setTipoResumo(String tipoResumo) {
        this.tipoResumo = tipoResumo;
    }

    @Field(offset = 89, length = 3)
    public Integer getBanco() {
        return banco;
    }

    public void setBanco(Integer banco) {
        this.banco = banco;
    }

    @Field(offset = 92, length = 6)
    public Integer getAgencia() {
        return agencia;
    }

    public void setAgencia(Integer agencia) {
        this.agencia = agencia;
    }

    @Field(offset = 98, length = 11)
    public Integer getContaCorrente() {
        return contaCorrente;
    }

    public void setContaCorrente(Integer contaCorrente) {
        this.contaCorrente = contaCorrente;
    }

    @Field(offset = 109, length = 1)
    public String getBandeira() {
        return bandeira;
    }

    public void setBandeira(String bandeira) {
        this.bandeira = bandeira;
    }

    public void setNumeroFiliacaopontoVenda(Integer numeroFiliacaopontoVenda) {
        this.numeroFiliacaopontoVenda = numeroFiliacaopontoVenda;
    }

    public RegistroTipo02TotalpontoVenda getFilial() {
        return filial;
    }

    public void setFilial(RegistroTipo02TotalpontoVenda filial) {
        this.filial = filial;
    }

    public List<RegistroTipo05DetalhamentoComprovantes> getComprovantes() {
        return comprovantes;
    }

    public void setComprovantes(List<RegistroTipo05DetalhamentoComprovantes> comprovantes) {
        this.comprovantes = comprovantes;
    }

    public void addComprovante(RegistroTipo05DetalhamentoComprovantes a) {
        comprovantes.add(a);
        a.setResumoVenda(this);
    }


    @Override
    public String toString() {
        return "RegistroTipo01ResumoVendas{" + "tipoRegistro=" + tipoRegistro + ", numeroFiliacaopontoVenda=" + numeroFiliacaopontoVenda + ", dataCredito=" + dataCredito + ", dataResumoVendas=" + dataResumoVendas + ", numeroResumoVendas=" + numeroResumoVenda + ", quantidadeComprovantesVendas=" + quantidadeComprovantesVendas + ", valorBruto=" + valorBruto + ", valorDesconto=" + valorDesconto + ", valorLiquido=" + valorLiquido + ", tipoResumo=" + tipoResumo + ", banco=" + banco + ", agencia=" + agencia + ", contaCorrente=" + contaCorrente + ", bandeira=" + bandeira + '}';
    }

	@Override
	public Integer getRegistro() {
		return tipoRegistro;
	}

}
