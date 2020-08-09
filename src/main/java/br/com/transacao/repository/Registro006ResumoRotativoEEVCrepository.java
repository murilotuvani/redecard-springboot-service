package br.com.transacao.repository;

import br.com.transacao.layout.eevc.Registro006RVrotativo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Registro006ResumoRotativoEEVCrepository extends JpaRepository<Registro006RVrotativo,Integer> {
}
