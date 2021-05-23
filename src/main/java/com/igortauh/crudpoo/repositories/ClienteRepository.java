package com.igortauh.crudpoo.repositories;

import com.igortauh.crudpoo.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
