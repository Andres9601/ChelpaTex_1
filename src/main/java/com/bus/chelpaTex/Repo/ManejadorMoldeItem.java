package com.bus.chelpaTex.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bus.chelpaTex.Entity.MoldeItem;
import com.bus.chelpaTex.Entity.MoldeItemPK;

@Repository
public interface ManejadorMoldeItem extends JpaRepository<MoldeItem, MoldeItemPK> {

}
