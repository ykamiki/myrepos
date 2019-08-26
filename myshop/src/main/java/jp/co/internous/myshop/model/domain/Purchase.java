package jp.co.internous.myshop.model.domain;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class Purchase {

	private long id;
	
	private long userId;
	
	private long goodsId;
		
	private long itemCount;
	
	private long total;
	
	private Timestamp createdAt;
	
}
