package br.com.transacao.repository;

import br.com.transacao.layout.eevc.Registro014ParcelosemJuros;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Registro014ParcelasRepository extends JpaRepository<Registro014ParcelosemJuros,Integer> {
}
