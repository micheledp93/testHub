package it.unikey.testhub_server.DAL.repository;

import it.unikey.testhub_server.DAL.entity.Dispense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface DispenseRepository extends JpaRepository<Dispense, Long> {
}
