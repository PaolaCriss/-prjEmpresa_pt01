package com.paolacristine.prjEmpresa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.paolacristine.prjEmpresa.entities.Departamento;
import com.paolacristine.prjEmpresa.repositorios.DepartamentoRepositorio;


@Service
public class DepartamentoService {

	private final DepartamentoRepositorio departamentoRepositorio;
	
	 @Autowired
	    public DepartamentoService(DepartamentoRepositorio departamentoRepositorio) {
	        this.departamentoRepositorio = departamentoRepositorio;
	    }

	 public Departamento saveDepartamento(Departamento departamento) {
	        return departamentoRepositorio.save(departamento);
	    }

	//preparando a busca getsl
	  	public List<Departamento> getAllDepartamento(){
	  		return departamentoRepositorio.findAll();
	  	}
	  	
	  	public Departamento getDepartamentoById (Long depcodigo) {
			return departamentoRepositorio.findById(depcodigo).orElse(null);
		}
	  	
	  //deletando
	  	public void deleteDepartamento(Long depcodigo) {
	  		departamentoRepositorio.deleteById(depcodigo);
	  	}
	  	
	 // fazendo o update do jogo com o optional
	  		public Departamento updateDepartamento(Long depcodigo, Departamento novoDepartamento) {
	  	        Optional<Departamento>departamentoOptional = departamentoRepositorio.findById(depcodigo);
	  	        if (departamentoOptional.isPresent()) {
	  	        	Departamento departamentoExistente = departamentoOptional.get();	
	  	        	departamentoExistente.setDepnome(novoDepartamento.getDepnome());          
	  	            return departamentoRepositorio.save(departamentoExistente); 
	  	        } else {
	  	            return null; 
	  	        }
	  	    }

	
}
