package com.paolacristine.prjEmpresa.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.paolacristine.prjEmpresa.entities.Funcionario;


public interface FuncionarioRepositorio extends JpaRepository<Funcionario, Long>{

}

