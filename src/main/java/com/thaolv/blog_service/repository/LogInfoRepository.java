package com.thaolv.blog_service.repository;

import com.thaolv.blog_service.entity.LogInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogInfoRepository extends JpaRepository<LogInfo, Integer> {
}
