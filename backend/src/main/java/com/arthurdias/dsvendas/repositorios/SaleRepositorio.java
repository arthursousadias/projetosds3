package com.arthurdias.dsvendas.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arthurdias.dsvendas.entidades.Sale;

public interface SaleRepositorio extends JpaRepository<Sale, Long> {

}
