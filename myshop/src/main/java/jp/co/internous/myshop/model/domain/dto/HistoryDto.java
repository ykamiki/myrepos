package jp.co.internous.myshop.model.domain.dto;

import java.sql.Timestamp;

import jp.co.internous.myshop.model.domain.Goods;
import jp.co.internous.myshop.model.domain.Purchase;
import lombok.Data;

/**
 * DTO from tables below
 *  purchase
 *  goods
 *  
 * @author 20190801_kamiki
 *
 */
@Data
public class HistoryDto {

	/** Purchase.id -Primary key */
	private long id;
	/** Purchase.user_id */
	private long userId;
	/** Purchase.goods_id */
	private long goodsId;
	/** Goods.goods_name */
	private String goodsName;
	/** Purchase.item_count */
	private long itemCount;
	/** Purchase.total */
	private long total;
	/** Purchase.created_at */
	private Timestamp createdAt;
	
	public HistoryDto() {}
	
	public HistoryDto(Goods goods) {
		Purchase p = goods.getPurchaseList().get(0);
		this.setId(p.getId());
		this.setUserId(p.getUserId());
		this.setGoodsId(p.getGoodsId());
		this.setGoodsName(goods.getGoodsName());
		this.setItemCount(p.getItemCount());
		this.setTotal(p.getTotal());
		this.setCreatedAt(p.getCreatedAt());
	}
	
}
