
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
import com.ancientprogramming.fixedformat4j.annotation.Record;

/**
 * 11/02/2020 18:16:26
 *
 * @author kaique.mota
 */
@Record
public class Registro017AVS implements ArquivoEEVC {

    private Integer tipoRegistro;
    private Integer numeroPV;
    private Integer quantidadeConsultasRealizadas;
    private Integer dataConsulta;

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
    @Field(offset = 13, length = 5)
    public Integer getQuantidadeConsultasRealizadas() {
        return quantidadeConsultasRealizadas;
    }

    public void setQuantidadeConsultasRealizadas(Integer quantidadeConsultasRealizadas) {
        this.quantidadeConsultasRealizadas = quantidadeConsultasRealizadas;
    }
    @Field(offset = 18, length = 8)
    public Integer getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(Integer dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

}


