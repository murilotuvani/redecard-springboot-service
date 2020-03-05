package br.com.transacao.arquivo.identificacao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IdentificaoFileRepository extends JpaRepository<IdentificacaoFile, Long> {
//
//	 @Query(value = "SELECT * FROM base b WHERE b.nome_base  = ?",nativeQuery = true)
//	    Optional<Base> findByName(String nome);
}
