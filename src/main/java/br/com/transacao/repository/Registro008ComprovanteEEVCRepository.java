package br.com.transacao.repository;

import br.com.transacao.layout.eevc.Registro008CVnsuRotativo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Registro008ComprovanteEEVCRepository extends JpaRepository<Registro008CVnsuRotativo, Integer> {
}
