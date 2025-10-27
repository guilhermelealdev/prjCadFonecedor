package com.guilhermef.prjCadFonecedor.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guilhermef.prjCadFonecedor.entities.Fornecedor;
import com.guilhermef.prjCadFonecedor.repositories.FonecedorRepository;

@Service
public class FornecedorService {

	private final FonecedorRepository fonecedorRepository;

	@Autowired
	public FornecedorService(FonecedorRepository fonecedorRepository) {
		this.fonecedorRepository = fonecedorRepository;
	}

	public Fornecedor Salvar(Fornecedor fonecedor) {
		return fonecedorRepository.save(fonecedor);
	}

	public void Deletar(Long id) {
		fonecedorRepository.deleteById(id);
	}

	public List<Fornecedor> ListarTodos() {
		return fonecedorRepository.findAll();
	}

	public Fornecedor ConsultarPorId(Long id) {
		return fonecedorRepository.findById(id).orElse(null);
	}

	public Fornecedor updateFornecedor(Long id, Fornecedor fornecedorAtualizado) {
		// produto a ser procurado pelo id
		Optional<Fornecedor> fornecedorOptional = fonecedorRepository.findById(id);
		if (fornecedorOptional.isPresent()) {
			// se exisite -> atualiza
			Fornecedor fornecedor = fornecedorOptional.get();
			fornecedor.setRazaoSocial(fornecedorAtualizado.getRazaoSocial());
			fornecedor.setNomeFantasia(fornecedorAtualizado.getNomeFantasia());
			fornecedor.setInscricaoEstadual(fornecedorAtualizado.getInscricaoEstadual());
			fornecedor.setFone(fornecedorAtualizado.getFone());
			fornecedor.setEndereco(fornecedorAtualizado.getEndereco());
			fornecedor.setEmail(fornecedorAtualizado.getEmail());
			fornecedor.setCnpj(fornecedorAtualizado.getCnpj());

			return fonecedorRepository.save(fornecedor);
		} else {
			return null;
		}
	}
}
