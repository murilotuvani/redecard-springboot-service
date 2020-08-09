package br.com.transacao.repository;

import br.com.transacao.layout.eevc.Registro028TrailerArquivo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Registro028TrailerEEVCrepository extends JpaRepository<Registro028TrailerArquivo,Integer> {
}
