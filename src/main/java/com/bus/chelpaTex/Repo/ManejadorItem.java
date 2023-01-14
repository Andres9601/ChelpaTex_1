package com.bus.chelpaTex.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bus.chelpaTex.Entity.Item;

@Repository
public interface ManejadorItem extends JpaRepository<Item, Long> {

}
