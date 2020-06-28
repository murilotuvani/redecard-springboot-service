package br.com.transacao.repository;

import br.com.transacao.layout.eevd.Registro00CabecalhoArquivo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Registro00Repository extends JpaRepository<Registro00CabecalhoArquivo,Long> {
}
