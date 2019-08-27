package jp.co.internous.practice.model.domain;

import java.sql.Timestamp;
import java.util.List;

import lombok.Data;

@Data
public class Goods {
	
	private long id;

	private String goodsName;
	
	private long price;
	
	private Timestamp updatedAt;
	
	private List<Purchase> purchaseList;
	
}
