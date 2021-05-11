package com.laboon.repository;

import com.laboon.entity.Lostlist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LostRepository extends JpaRepository<Lostlist,Integer> {
}
