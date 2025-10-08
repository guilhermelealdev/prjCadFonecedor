package com.guilhermef.prjCadFonecedor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guilhermef.prjCadFonecedor.entities.Fornecedor;
import com.guilhermef.prjCadFonecedor.services.FornecedorService;

@RestController
@RequestMapping("/fonecedores")
public class FonecedorController {
	
	private final FornecedorService fornecedorService;
	
	@Autowired
	public FonecedorController(FornecedorService fornecedorService) {
		this.fornecedorService = fornecedorService;
	}
	
	@PostMapping
	public Fornecedor CriarFonecedor(@RequestBody Fornecedor fonecedor) {
		return fornecedorService.Salvar(fonecedor);
	}
	public Fornecedor BuscarPorId(@PathVariable Long id) {
		return fornecedorService.ConsultarPorId(id);
	}
	public List<Fornecedor> ListarTodosFornecedores() {
		return fornecedorService.ListarTodos();
	}
	
	@DeleteMapping("/${id}")
	public void DeleteFornecedor(@PathVariable Long id) {
		
	}

}
