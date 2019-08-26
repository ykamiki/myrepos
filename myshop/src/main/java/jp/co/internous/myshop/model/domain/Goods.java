package jp.co.internous.myshop.model.domain;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class Goods {
	
	private long id;

	private String goodsName;
	
	private long price;
	
	private Timestamp updatedAt;
	
}
