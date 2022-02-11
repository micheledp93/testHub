package it.unikey.testhub_server.DAL.repository;

import it.unikey.testhub_server.DAL.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserEntityRepository extends JpaRepository<UserEntity, Long> {
}
