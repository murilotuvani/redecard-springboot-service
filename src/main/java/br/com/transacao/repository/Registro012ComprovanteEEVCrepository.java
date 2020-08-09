package br.com.transacao.repository;

import br.com.transacao.layout.eevc.Registro12CVnsuparceladosemJuros;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Registro012ComprovanteEEVCrepository extends JpaRepository<Registro12CVnsuparceladosemJuros,Integer> {
}
