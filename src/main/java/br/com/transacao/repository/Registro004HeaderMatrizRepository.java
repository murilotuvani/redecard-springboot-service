package br.com.transacao.repository;

import br.com.transacao.layout.eevc.Registro004HeaderMatriz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Registro004HeaderMatrizRepository extends JpaRepository<Registro004HeaderMatriz, Integer> {
}
