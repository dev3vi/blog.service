package com.thaolv.blog_service.repository;

import com.thaolv.blog_service.entity.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolesRepository extends JpaRepository<Roles, Integer> {
}
