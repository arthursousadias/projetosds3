package com.arthurdias.dsvendas.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arthurdias.dsvendas.entidades.Seller;

public interface SellerRepositorio extends JpaRepository<Seller, Long> {

}
