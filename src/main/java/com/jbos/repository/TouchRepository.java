package com.jbos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jbos.beans.Touch;
@Repository
public interface TouchRepository extends JpaRepository<Touch, Long> {

}
