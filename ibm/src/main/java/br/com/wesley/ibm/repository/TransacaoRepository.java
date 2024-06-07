package br.com.wesley.ibm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.wesley.ibm.entity.Transacao;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, Integer> {

	@Query(value = "select t.* from ibm_teste.cliente e inner join ibm_teste.conta a on a.id=e.id_conta "
			+ "inner join ibm_teste.transacao t on e.id=t.id_cliente where a.numero=:numeroConta", nativeQuery = true)
	List<Transacao> buscarTodasTransacoesDaConta(Integer numeroConta); 	
}