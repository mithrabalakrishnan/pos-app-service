package com.pos.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pos.app.model.Voucher;

@Repository
public interface VoucherRepository extends JpaRepository<Voucher, Integer>{
	
		public void deleteByVoucherId(Integer voucherId);
		
		public Voucher findByVoucherId(Integer voucherId);

}
