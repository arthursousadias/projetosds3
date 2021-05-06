package com.arthurdias.dsvendas.servico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.arthurdias.dsvendas.dto.SaleDTO;
import com.arthurdias.dsvendas.dto.SaleSucessDTO;
import com.arthurdias.dsvendas.dto.SaleSumDTO;
import com.arthurdias.dsvendas.entidades.Sale;
import com.arthurdias.dsvendas.repositorios.SaleRepositorio;

@Service
public class SaleServico {
	
	@Autowired
	private SaleRepositorio repositorio;
	
	@Transactional(readOnly = true)
	public Page<SaleDTO> findAll(Pageable pageable) {		
		Page<Sale> result = repositorio.findAll(pageable);
		return result.map(x -> new SaleDTO(x));
	}
	
	@Transactional(readOnly = true)
	public List<SaleSumDTO> amountGroupedBySeller(){
		return repositorio.amountGroupedBySeller();		
	}
	
	@Transactional(readOnly = true)
	public List<SaleSucessDTO> sucessGroupedBySeller(){
		return repositorio.sucessGroupedBySeller();		
	}

}
