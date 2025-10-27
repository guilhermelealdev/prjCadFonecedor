package com.guilhermef.prjCadFonecedor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

	@GetMapping("/{id}")
	public Fornecedor BuscarPorId(@PathVariable Long id) {
		return fornecedorService.ConsultarPorId(id);
	}

	public List<Fornecedor> ListarTodosFornecedores() {
		return fornecedorService.ListarTodos();
	}

	@DeleteMapping("/{id}")
	public void DeleteFornecedor(@PathVariable Long id) {

	}

	@PutMapping("/{id}")
	public ResponseEntity<Fornecedor> atualizaFornecedor(@PathVariable Long id, @RequestBody Fornecedor fornecedor) {
		Fornecedor atualizado = fornecedorService.updateFornecedor(id, fornecedor);
		if (atualizado != null) {
			return ResponseEntity.ok(atualizado);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}
