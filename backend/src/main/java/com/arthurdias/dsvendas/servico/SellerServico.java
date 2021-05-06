package com.arthurdias.dsvendas.servico;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.arthurdias.dsvendas.dto.SellerDTO;
import com.arthurdias.dsvendas.entidades.Seller;
import com.arthurdias.dsvendas.repositorios.SellerRepositorio;

@Service
public class SellerServico {
	
	@Autowired
	private SellerRepositorio repositorio;
	
	public List<SellerDTO> findAll() {		
		List<Seller> result = repositorio.findAll();
		return result.stream().map(x -> new SellerDTO(x)).collect(Collectors.toList());
	}
}
