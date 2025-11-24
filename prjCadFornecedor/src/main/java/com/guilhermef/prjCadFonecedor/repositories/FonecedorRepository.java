package com.guilhermef.prjCadFonecedor.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.guilhermef.prjCadFonecedor.entities.Fornecedor;

public interface FonecedorRepository extends JpaRepository<Fornecedor, Long>{
	
	List<Fornecedor> encontrarPorRazaoSocial(String razaoSocial);
	List<Fornecedor> encontrarPorNomeFantasia(String nomeFantasia);
	List<Fornecedor> encontrarPorCnpj(String cnpj);
	List<Fornecedor> encontrarPorEndereco(String endereco);
	List<Fornecedor> encontrarPorTelefone(String telefone);
	List<Fornecedor> encontrarPorInscricaoEstadual(String inscricaoEstadual);
	
}
