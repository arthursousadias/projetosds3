package com.arthurdias.dsvendas.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arthurdias.dsvendas.dto.SellerDTO;
import com.arthurdias.dsvendas.servico.SellerServico;

@RestController
@RequestMapping(value = "/sellers")
public class SellerControlador {

	@Autowired
	private SellerServico servico;
	
	@GetMapping
	public ResponseEntity< List<SellerDTO> > findAll() {
		List<SellerDTO> list = servico.findAll();
		return ResponseEntity.ok(list);
	}
}
