package br.com.transacao.repository;

import br.com.transacao.layout.eevd.RegistroTipo01ResumoVendas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistroTipo01ResumoVendaRepository extends JpaRepository<RegistroTipo01ResumoVendas, Integer> {
}
