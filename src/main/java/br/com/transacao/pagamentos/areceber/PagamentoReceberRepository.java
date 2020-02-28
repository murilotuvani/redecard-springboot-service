package br.com.transacao.pagamentos.areceber;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagamentoReceberRepository extends JpaRepository<PagamentoReceber, Long> {

}