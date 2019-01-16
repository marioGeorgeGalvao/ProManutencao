package com.promanutencao.Repository;

import javax.transaction.Transactional;
import com.promanutencao.Model.Veiculo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface VeiculoRepository extends JpaRepository<Veiculo, Long>{

}
