package com.pos.app.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.pos.app.dto.FoodUpdateOrderDTO;



@Mapper
public interface FoodOrderMapper {
	
	
	@Results({
		@Result(property = "id", column = "id"),
		@Result(property = "userId", column = "user_id"),
		@Result(property = "foodId", column = "food_id"),
		@Result(property = "tableId", column = "table_id"),
		@Result(property = "totalPrice", column = "total_price"),
		@Result(property = "date", column = "date"),
		@Result(property = "time", column = "time"),
		@Result(property = "day", column = "day"),
		@Result(property = "month", column = "month"),
		@Result(property = "year", column = "year"),
		@Result(property = "foodName", column = "name"),
		@Result(property = "username", column = "username"),
	})
	
	@Select("select select fo.id, fo.user_id, fo.food_id, fo.quanty, fo.table_id, fo.total_price, fo.date, fo.time, fo.day, fo.month, fo.year, fd.name, ur.username from food_order as fo "
			+ "join food as fd on fo.food_d = fd.food_id"
			+ "join user as ur on fo.user_id = ur.id")
	public List<FoodUpdateOrderDTO> getFoodOrderList();

}
