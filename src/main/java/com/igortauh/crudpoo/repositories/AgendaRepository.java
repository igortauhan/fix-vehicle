package com.igortauh.crudpoo.repositories;

import com.igortauh.crudpoo.entities.Agenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgendaRepository extends JpaRepository<Agenda, Long> {
}
