package it.unikey.testhub_server.DAL.repository;

import it.unikey.testhub_server.DAL.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends JpaRepository <Tag, Long>{
}
