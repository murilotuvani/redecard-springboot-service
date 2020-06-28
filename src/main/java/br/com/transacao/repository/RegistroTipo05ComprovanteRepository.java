package br.com.transacao.repository;

import br.com.transacao.layout.eevd.RegistroTipo05DetalhamentoComprovantes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistroTipo05ComprovanteRepository extends JpaRepository<RegistroTipo05DetalhamentoComprovantes,Integer> {
}
