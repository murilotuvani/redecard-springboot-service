package br.com.transacao.repository;

import br.com.transacao.layout.eevc.Registro026TotalizadorMatriz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Registro026TotalMatrizEEVCrepository extends JpaRepository<Registro026TotalizadorMatriz, Integer> {
}
