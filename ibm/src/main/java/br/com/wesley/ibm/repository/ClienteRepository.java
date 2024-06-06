package br.com.wesley.ibm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.wesley.ibm.entity.Cliente;


@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
	
	@Query(value = "select e.* from ibm_teste.cliente e inner join ibm_teste.conta a on a.id=e.id_conta where a.numero=:numeroConta", nativeQuery = true)
	Cliente buscarClientePorNumeroConta(Integer numeroConta);
}