package com.paolacristine.prjEmpresa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.paolacristine.prjEmpresa.entities.Funcionario;
import com.paolacristine.prjEmpresa.services.FuncionarioService;

import io.swagger.v3.oas.annotations.tags.Tag; 

@Tag( name="Funcionarios", description ="Central de funcionarios")
@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {

	private final FuncionarioService funcionarioService;
	
	@Autowired
	public FuncionarioController(FuncionarioService funcionarioService) {
		this.funcionarioService = funcionarioService;
	}
	
	@PostMapping
	public Funcionario createProduct(@RequestBody Funcionario  funcionario) {
		return funcionarioService.saveFuncionario(funcionario);
	}

	//Utilizando o ResponseEntity e RequestEntity
	@GetMapping
	public ResponseEntity<List<Funcionario>> getAllFuncionario(RequestEntity<Void> requestEntity) {
		String method = requestEntity.getMethod().name();
		String contentType = requestEntity.getHeaders().getContentType().toString();
		List<Funcionario> funcionario = funcionarioService.getAllFuncionario();
		return ResponseEntity.status(HttpStatus.OK).header("Method", method).header("Content-Type", contentType)
				.body(funcionario);
	}

	@PutMapping("/{id}")
	public Funcionario updateFuncionario(@PathVariable Long funcodigo, @RequestBody Funcionario funcionario) {
	    return funcionarioService.updateFuncionario(funcodigo, funcionario);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Funcionario> getFuncionario (@PathVariable Long funcodigo) { 
		Funcionario funcionario = funcionarioService.getFuncionarioById(funcodigo);
	if(funcionario  != null) {
	return ResponseEntity.ok (funcionario);
	} else {
	return ResponseEntity.notFound ().build();
	  }
	}
	
	@GetMapping ("/home")
	public String paginaInicial () {
	 return "index"; // Nome do seu arquivo HTML (sem a extensão)
	}
	
	@DeleteMapping("/{id}")
	public void deleteFuncionario(@PathVariable Long funcodigo) {
		funcionarioService.deleteFuncionario(funcodigo);
	}
	
	
	
	
}
