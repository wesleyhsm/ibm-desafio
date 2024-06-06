package br.com.wesley.ibm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.wesley.ibm.entity.Conta;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Integer>{

}