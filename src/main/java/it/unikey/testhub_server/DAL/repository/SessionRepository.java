package it.unikey.testhub_server.DAL.repository;

import it.unikey.testhub_server.DAL.entity.SessionEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SessionRepository extends JpaRepository<SessionEntity, Long> {

    Page<SessionEntity> findSessionEntitiesByStatus_descriptionOrStatus_DescriptionOrderByIdDesc(String statusActive, String statusSent, Pageable pageable);

    Long countSessionEntitiesByStatus_descriptionOrStatus_description(String statusActive, String statusSent);

    Long countSessionEntitiesByStatus_Description(String status);

}
