package br.com.transacao.repository;

import br.com.transacao.layout.eevc.Registro002HeaderArquivo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Registro002HeaderEevcRepository extends JpaRepository<Registro002HeaderArquivo, Integer> {
}
