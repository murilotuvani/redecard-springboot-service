package br.com.transacao.test;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import br.com.transacao.layout.Leitor;
import br.com.transacao.layout.eevd.Registro00CabecalhoArquivo;
import br.com.transacao.layout.eevd.RegistroTipo01ResumoVendas;
import br.com.transacao.layout.eevd.RegistroTipo02TotalpontoVenda;
import br.com.transacao.layout.eevd.RegistroTipo05DetalhamentoComprovantes;
import br.com.transacao.layout.interfaces.ArquivoEEVD;
import br.com.transacao.repository.Registro00Repository;
import br.com.transacao.repository.RegistroTipo01ResumoVendaRepository;
import br.com.transacao.repository.RegistroTipo02Repository;
import br.com.transacao.repository.RegistroTipo05ComprovanteRepository;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@ActiveProfiles("dev")
@SpringBootTest
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProcessamentoArquivoTestEEVD {
    private static List<?> lista = new ArrayList<>();

    @Autowired
    private Registro00Repository registro00Repository;
    @Autowired
    private RegistroTipo02Repository registroTipo002Repository;
    @Autowired
    private RegistroTipo01ResumoVendaRepository registroTipo01ResumoVendaRepository;
    @Autowired
    private RegistroTipo05ComprovanteRepository registroTipo05ComprovanteRepository;

    @Test
    public void testVerificacaoExistenciaArquivo_01() {
        File f = new File("C:\\Users\\Kaique\\Documents\\Trabalho\\redecard-springboot-service\\src\\test\\ArquivosTest\\R97470EEVD17.cmp");
        assertTrue(f.exists());
        System.out.println("PATH = " + f.getAbsolutePath());
    }

    @Test
    public void testProcessamento_02() {
        Leitor l = new Leitor();
        File f = new File("C:\\Users\\Kaique\\Documents\\Trabalho\\redecard-springboot-service\\src\\test\\ArquivosTest\\R97470EEVD17.cmp");
        lista = l.defineLeitura(f);
        System.out.println("");
        List<ArquivoEEVD> listEEVD = (List<ArquivoEEVD>) lista;


        List<RegistroTipo02TotalpontoVenda> filial = new ArrayList<>();
        List<RegistroTipo05DetalhamentoComprovantes> comprovantes = new ArrayList<>();
        List<RegistroTipo01ResumoVendas> resumoVendas = new ArrayList<>();
        Registro00CabecalhoArquivo arquivo = new Registro00CabecalhoArquivo();
        int i = 0;
        int j = 0;


        for (ArquivoEEVD a : listEEVD) {
            listEEVD.stream().forEach(ab -> {
            });
            if (a instanceof Registro00CabecalhoArquivo) {
                arquivo = (Registro00CabecalhoArquivo) a;
            } else if (a instanceof RegistroTipo01ResumoVendas) {
                resumoVendas.add((RegistroTipo01ResumoVendas) a);
                j++;
            } else if (a instanceof RegistroTipo05DetalhamentoComprovantes) {
                resumoVendas.get(j - 1).addComprovante((RegistroTipo05DetalhamentoComprovantes) a);
            } else if (a instanceof RegistroTipo02TotalpontoVenda) {
                arquivo.addFilial((RegistroTipo02TotalpontoVenda) a);
                arquivo.getFiliais().get(i).setResumoVendas(resumoVendas);
                resumoVendas = new ArrayList<>();
                j = 0;
                i++;
            }
        }
        registro00Repository.save(arquivo);
        for (RegistroTipo02TotalpontoVenda fa : arquivo.getFiliais()) {
            registroTipo002Repository.save(fa);
        }
        for (RegistroTipo02TotalpontoVenda asda : arquivo.getFiliais()) {
            registroTipo01ResumoVendaRepository.saveAll(asda.getResumoVendas());
        }
        for (int k = 0; k < arquivo.getFiliais().size(); k++) {
            for (RegistroTipo01ResumoVendas resumoVenda : arquivo.getFiliais().get(k).getResumoVendas()) {
                registroTipo05ComprovanteRepository.saveAll(resumoVenda.getComprovantes());
            }
        }
    }
}
