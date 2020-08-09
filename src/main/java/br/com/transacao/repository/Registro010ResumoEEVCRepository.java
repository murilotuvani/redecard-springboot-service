package br.com.transacao.repository;

import br.com.transacao.layout.eevc.Registro010RVparceladosemJuros;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Registro010ResumoEEVCRepository extends JpaRepository<Registro010RVparceladosemJuros,Integer> {
}
