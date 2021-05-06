package com.arthurdias.dsvendas.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arthurdias.dsvendas.dto.SaleDTO;
import com.arthurdias.dsvendas.dto.SaleSucessDTO;
import com.arthurdias.dsvendas.dto.SaleSumDTO;
import com.arthurdias.dsvendas.servico.SaleServico;

/* BUsca paginada --> 
 * get --> http://localhost:8080/sales?page=1--> retorna
 * a segunda página
 * "totalPages": 9,
    "totalElements": 170,
    "size": 20,
    "number": 1,
 * 
 */
@RestController
@RequestMapping(value = "/sales")
public class SaleControlador {

	@Autowired
	private SaleServico servico;
	
	@GetMapping
	public ResponseEntity< Page<SaleDTO> > findAll(Pageable pageable) {
		Page<SaleDTO> list = servico.findAll(pageable);
		return ResponseEntity.ok(list);
	}
	
	@GetMapping(value = "/amount-by-seller")
	public ResponseEntity< List<SaleSumDTO> > amountGroupedBySeller() {
		List<SaleSumDTO> list = servico.amountGroupedBySeller();
		return ResponseEntity.ok(list);
	}
	
	@GetMapping(value = "/success-by-seller")
	public ResponseEntity< List<SaleSucessDTO> > sucessGroupedBySeller() {
		List<SaleSucessDTO> list = servico.sucessGroupedBySeller();
		return ResponseEntity.ok(list);
	}
}
