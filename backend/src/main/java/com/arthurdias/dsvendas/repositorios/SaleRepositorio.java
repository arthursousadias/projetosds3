package com.arthurdias.dsvendas.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.arthurdias.dsvendas.dto.SaleSucessDTO;
import com.arthurdias.dsvendas.dto.SaleSumDTO;
import com.arthurdias.dsvendas.entidades.Sale;

public interface SaleRepositorio extends JpaRepository<Sale, Long> {
	
	@Query("SELECT new com.arthurdias.dsvendas.dto.SaleSumDTO(obj.seller, SUM(obj.amount) ) "
			+ "FROM Sale AS obj GROUP BY obj.seller")
	List<SaleSumDTO> amountGroupedBySeller();
	
	@Query("SELECT new com.arthurdias.dsvendas.dto.SaleSucessDTO(obj.seller, SUM(obj.visited), SUM(obj.deals) ) "
			+ "FROM Sale AS obj GROUP BY obj.seller")
	List<SaleSucessDTO> sucessGroupedBySeller();
}
