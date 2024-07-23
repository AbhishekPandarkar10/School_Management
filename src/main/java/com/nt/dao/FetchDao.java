package com.nt.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nt.entity.Fetch;

@Repository
public interface FetchDao extends CrudRepository<Fetch, Integer> {

}
