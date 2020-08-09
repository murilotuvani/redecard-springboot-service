package br.com.transacao.test;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import br.com.transacao.layout.Leitor;
import br.com.transacao.layout.eevc.*;
import br.com.transacao.layout.interfaces.ArquivoEEVC;
import br.com.transacao.repository.*;
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
public class ProcessamentoArquivoTestEEVC {
    private static List<?> lista = new ArrayList<>();
    @Autowired
    private Registro002HeaderEevcRepository repositoryHeader;
    @Autowired
    private Registro004HeaderMatrizRepository repositoryHeaderMatriz;
    @Autowired
    private Registro010ResumoEEVCRepository registro010ResumoEEVCRepository;
    @Autowired
    private Registro012ComprovanteEEVCrepository registro012ComprovanteEEVCrepository;
    @Autowired
    private Registro014ParcelasRepository registro014ParcelasRepository;
    @Autowired
    private Registro026TotalMatrizEEVCrepository registro026TotalMatrizEEVCrepository;
    @Autowired
    private Registro008ComprovanteEEVCRepository registro008ComprovanteEEVCRepository;
    @Autowired
    private Registro006ResumoRotativoEEVCrepository registro006ResumoRotativoEEVCrepository;
    @Autowired
    private Registro028TrailerEEVCrepository registro028TrailerEEVCrepository;

    @Test
    public void testeArquivo() {

        File file = new File("C:\\Users\\Kaique\\Documents\\Trabalho\\R97470EEVC23.cmp");
        assertTrue(file.exists());
        System.out.println("PATH = " + file.getAbsolutePath());
    }

    @Test
    public void testLeitura() {
        Leitor l = new Leitor();
        File f = new File("C:\\Users\\Kaique\\Documents\\Trabalho\\R97470EEVC23.cmp");
        lista = l.defineLeitura(f);
        List<ArquivoEEVC> listEEVC = (List<ArquivoEEVC>) lista;
        List<Registro006RVrotativo> resumos = new ArrayList<>();
        List<Registro010RVparceladosemJuros> resumosVenda = new ArrayList<>();
        List<Registro014ParcelosemJuros> parcelas = new ArrayList<>();
        List<Registro026TotalizadorMatriz> totalizadorMatrizs = new ArrayList<>();

        Registro028TrailerArquivo trailer = new Registro028TrailerArquivo();
        Registro010RVparceladosemJuros resumoVenda = null;
        Registro006RVrotativo resumoRotativo = null;
        for (ArquivoEEVC a : listEEVC) {
            if (a instanceof Registro002HeaderArquivo) {
                repositoryHeader.save((Registro002HeaderArquivo) a);
            } else if (a instanceof Registro004HeaderMatriz) {
                repositoryHeaderMatriz.save((Registro004HeaderMatriz) a);
            } else if (a instanceof Registro010RVparceladosemJuros) {
                resumoVenda = new Registro010RVparceladosemJuros();
                resumoVenda = (Registro010RVparceladosemJuros) a;
                resumosVenda.add(resumoVenda);
            } else if (a instanceof Registro12CVnsuparceladosemJuros) {
                resumoVenda.addComprovante((Registro12CVnsuparceladosemJuros) a);
            } else if (a instanceof Registro014ParcelosemJuros) {
                resumoVenda.addComprovanteParcela((Registro014ParcelosemJuros) a);
            } else if (a instanceof Registro006RVrotativo) {
                resumoRotativo = new Registro006RVrotativo();
                resumoRotativo = (Registro006RVrotativo) a;
                resumos.add(resumoRotativo);
            } else if (a instanceof Registro008CVnsuRotativo) {
                resumoRotativo.addComprovante((Registro008CVnsuRotativo) a);
            } else if (a instanceof Registro026TotalizadorMatriz) {
                totalizadorMatrizs.add((Registro026TotalizadorMatriz) a);
            } else if (a instanceof Registro028TrailerArquivo) {
                trailer = (Registro028TrailerArquivo) a;
            }
        }
        resumosVenda.forEach(a -> {
            registro012ComprovanteEEVCrepository.saveAll(a.getComprovantesVendaSemJuros());
            registro014ParcelasRepository.saveAll(a.getParcelasSemJuros());
        });
        registro010ResumoEEVCRepository.saveAll(resumosVenda);
        resumos.forEach(a -> {
            registro008ComprovanteEEVCRepository.saveAll(a.getComprovantes());
        });
        registro006ResumoRotativoEEVCrepository.saveAll(resumos);
        registro026TotalMatrizEEVCrepository.saveAll(totalizadorMatrizs);
        registro028TrailerEEVCrepository.save(trailer);
    }
}
