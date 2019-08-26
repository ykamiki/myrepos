package jp.co.internous.myshop.model.form;

import java.io.Serializable;

import lombok.Data;

@Data
public class PurchaseForm implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private long userId;
	private long goodsId;
	private long itemCount;
	private long total;
	
}
