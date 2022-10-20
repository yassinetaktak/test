package com.machinestalk.machinestalktestback.repositories;

import com.machinestalk.machinestalktestback.entities.UserMachinestalk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMachinestalkRepository extends JpaRepository <UserMachinestalk, Integer> {

}
