package com.laboon.repository;

import com.laboon.entity.Cmtchild;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CmtchildRepository extends JpaRepository<Cmtchild,Integer> {

    List<Cmtchild> findAllByCmtId(int cmtid);
}
