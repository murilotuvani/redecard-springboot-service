package br.com.transacao.repository;

import br.com.transacao.layout.eevd.RegistroTipo02TotalpontoVenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistroTipo02Repository extends JpaRepository<RegistroTipo02TotalpontoVenda,Integer> {
}
