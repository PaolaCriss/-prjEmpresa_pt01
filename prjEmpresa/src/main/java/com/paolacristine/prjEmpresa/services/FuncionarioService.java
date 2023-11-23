package com.paolacristine.prjEmpresa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paolacristine.prjEmpresa.entities.Departamento;
import com.paolacristine.prjEmpresa.entities.Funcionario;
import com.paolacristine.prjEmpresa.repositorios.FuncionarioRepositorio;

@Service
public class FuncionarioService {

	private final FuncionarioRepositorio funcionarioRepositorio;
	
	 @Autowired
	    public FuncionarioService(FuncionarioRepositorio funcionarioRepositorio) {
	        this.funcionarioRepositorio = funcionarioRepositorio;
	    }
	 
	 public Funcionario saveFuncionario(Funcionario funcionario) {
	        return funcionarioRepositorio.save(funcionario);
	    }
	
	//preparando a busca getsl
	  	public List<Funcionario> getAllFuncionario(){
	  		return funcionarioRepositorio.findAll();
	  	}
	  	
	  	public Funcionario getFuncionarioById (Long funcodigo) {
			return funcionarioRepositorio.findById(funcodigo).orElse(null);
		}
	  	
	  //deletando
	  	public void deleteFuncionario(Long funcodigo) {
	  		funcionarioRepositorio.deleteById(funcodigo);
	  	}
	  	
	  	 // fazendo o update do jogo com o optional
  		public Funcionario updateFuncionario(Long funcodigo, Funcionario novoFuncionario) {
  	        Optional<Funcionario>funcionarioOptional = funcionarioRepositorio.findById(funcodigo);
  	        if (funcionarioOptional.isPresent()) {
  	        	Funcionario funcionarioExistente = funcionarioOptional.get();	
  	        	funcionarioExistente.setFunnome(novoFuncionario.getFunnome());
  	        	funcionarioExistente.setFunsalario(novoFuncionario.getFunsalario()); 
  	        	funcionarioExistente.setFunnascimento(novoFuncionario.getFunnascimento());     
  	            return funcionarioRepositorio.save(funcionarioExistente); 
  	        } else {
  	            return null; 
  	        }
  	    }

}
