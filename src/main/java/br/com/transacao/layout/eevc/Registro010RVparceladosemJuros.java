
package br.com.transacao.layout.eevc;

import br.com.transacao.layout.eevd.RegistroTipo05DetalhamentoComprovantes;
import br.com.transacao.layout.interfaces.ArquivoEEVC;
import com.ancientprogramming.fixedformat4j.annotation.Field;
import com.ancientprogramming.fixedformat4j.annotation.FixedFormatPattern;
import com.ancientprogramming.fixedformat4j.annotation.Record;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 11/02/2020 16:30:33
 *
 * @author kaique.mota
 */
@Record
@Entity
@Table(name = "eevc_resumo_parcelado_sem_juros")
public class Registro010RVparceladosemJuros implements ArquivoEEVC {

    @Id
    private Integer numeroRV;
    @OneToMany
    @JoinColumn(name = "resumo_venda_id")
    private List<Registro12CVnsuparceladosemJuros> comprovantesVendaSemJuros = new ArrayList<>();
    @OneToMany
    @JoinColumn(name = "resumo_venda_id")
    private List<Registro014ParcelosemJuros> parcelasSemJuros = new ArrayList<>();
    private Integer tipoRegistro;
    private Integer numeroPV;
    private Integer numeroBanco;
    private Integer numeroAgencia;
    private Integer numeroContaCorrente;
    private Date dataRV;
    private Integer quantiadeCVnsu;
    private Double valorBruto;
    private Double valorGorjeta;
    private Double valorRejeitado;
    private Double valorDesconto;
    private Double valorLiquido;
    private Date dataCredido1parcelaCredito;
    private String bandeira;

    @Field(offset = 1, length = 3)
    public Integer getTipoRegistro() {
        return tipoRegistro;
    }

    public void setTipoRegistro(Integer tipoRegistro) {
        this.tipoRegistro = tipoRegistro;
    }

    @Field(offset = 4, length = 9)
    public Integer getNumeroPV() {
        return numeroPV;
    }

    public void setNumeroPV(Integer numeroPV) {
        this.numeroPV = numeroPV;
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
    public Integer getNumeroContaCorrente() {
        return numeroContaCorrente;
    }

    public void setNumeroContaCorrente(Integer numeroContaCorrente) {
        this.numeroContaCorrente = numeroContaCorrente;
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
    public Integer getQuantiadeCVnsu() {
        return quantiadeCVnsu;
    }

    public void setQuantiadeCVnsu(Integer quantiadeCVnsu) {
        this.quantiadeCVnsu = quantiadeCVnsu;
    }

    @Field(offset = 54, length = 15)
    public Double getValorBruto() {
        return valorBruto;
    }

    public void setValorBruto(Double valorBruto) {
        this.valorBruto = valorBruto;
    }

    @Field(offset = 69, length = 15)
    public Double getValorGorjeta() {
        return valorGorjeta;
    }

    public void setValorGorjeta(Double valorGorjeta) {
        this.valorGorjeta = valorGorjeta;
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
    public Date getDataCredido1parcelaCredito() {
        return dataCredido1parcelaCredito;
    }

    public void setDataCredido1parcelaCredito(Date dataCredido1parcelaCredito) {
        this.dataCredido1parcelaCredito = dataCredido1parcelaCredito;
    }

    @Field(offset = 137, length = 1)
    public String getBandeira() {
        return bandeira;
    }

    public void setBandeira(String bandeira) {
        this.bandeira = bandeira;
    }

    public List<Registro12CVnsuparceladosemJuros> getComprovantesVendaSemJuros() {
        return comprovantesVendaSemJuros;
    }

    public void setComprovantesVendaSemJuros(List<Registro12CVnsuparceladosemJuros> comprovantesVendaSemJuros) {
        this.comprovantesVendaSemJuros = comprovantesVendaSemJuros;
    }

    public List<Registro014ParcelosemJuros> getParcelasSemJuros() {
        return parcelasSemJuros;
    }

    public void setParcelasSemJuros(List<Registro014ParcelosemJuros> parcelasSemJuros) {
        this.parcelasSemJuros = parcelasSemJuros;
    }

    public void addComprovante(Registro12CVnsuparceladosemJuros a) {
        comprovantesVendaSemJuros.add(a);
    }

    public void addComprovanteParcela(Registro014ParcelosemJuros a) {
        parcelasSemJuros.add(a);
    }

    @Override
    public String toString() {
        return "Registro010RVparceladosemJuros{" + "tipoRegistro=" + tipoRegistro + ", numeroPV=" + numeroPV + ", numeroRV=" + numeroRV + ", numeroBanco=" + numeroBanco + ", numeroAgencia=" + numeroAgencia + ", numeroContaCorrente=" + numeroContaCorrente + ", dataRV=" + dataRV + ", quantiadeCVnsu=" + quantiadeCVnsu + ", valorBruto=" + valorBruto + ", valorGorjeta=" + valorGorjeta + ", valorRejeitado=" + valorRejeitado + ", valorDesconto=" + valorDesconto + ", valorLiquido=" + valorLiquido + ", dataCredido1parcelaCredito=" + dataCredido1parcelaCredito + ", bandeira=" + bandeira + '}';
    }

}
