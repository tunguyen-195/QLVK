package com.qlvk.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qlvk.entity.Gpsd;

public interface IGpsdRepository extends JpaRepository<Gpsd, Integer> {

}