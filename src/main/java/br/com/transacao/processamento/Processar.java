package br.com.transacao.processamento;

import br.com.transacao.layout.Leitor;
import br.com.transacao.layout.eevd.Registro00CabecalhoArquivo;
import br.com.transacao.layout.eevd.RegistroTipo01ResumoVendas;
import br.com.transacao.layout.eevd.RegistroTipo02TotalpontoVenda;
import br.com.transacao.layout.eevd.RegistroTipo05DetalhamentoComprovantes;
import br.com.transacao.layout.interfaces.ArquivoEEVD;
import br.com.transacao.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication

public class Processar implements CommandLineRunner {

    private static List<?> lista = new ArrayList<>();

    @Autowired
    private Registro00Repository registro00Repository;
    @Autowired
    private RegistroTipo02Repository registroTipo002Repository;
    @Autowired
    private RegistroTipo01ResumoVendaRepository registroTipo01ResumoVendaRepository;
    @Autowired
    private RegistroTipo05ComprovanteRepository registroTipo05ComprovanteRepository;


    @Override
    public void run(String... args) throws Exception {

        Leitor l = new Leitor();
        File f = new File("C:\\Users\\Kaique\\Documents\\Trabalho\\R97470EEVD17.cmp");
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
            if (a instanceof Registro00CabecalhoArquivo) {
                arquivo = (Registro00CabecalhoArquivo) a;
                registro00Repository.save(arquivo);
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
                registroTipo002Repository.save(arquivo.getFiliais().get(i));
                i++;

                registroTipo01ResumoVendaRepository.saveAll(resumoVendas);

            }
        }
//        Registro00CabecalhoArquivo arquivo2 = new Registro00CabecalhoArquivo();
//        registroTipo05ComprovanteRepository.saveAll(arquivo.getFiliais().get(0).getResumoVendas().get(0).getComprovantes());
//
////        for (int k = 0; k < arquivo.getFiliais().size(); k++) {
////            for (int m = 0; m < arquivo.getFiliais().get(k).getResumoVendas().size(); m++) {
////                registroTipo05ComprovanteRepository.saveAll(arquivo.getFiliais().get(k).getResumoVendas().get(m).getComprovantes());
////            }
////            registroTipo01ResumoVendaRepository.saveAll(arquivo.getFiliais().get(k).getResumoVendas());
////        }
//        registroTipo002Repository.saveAll(arquivo.getFiliais());
//        System.out.println();
//
//
//        registro00Repository.save(arquivo);
//
//        System.out.println();
    }
}
