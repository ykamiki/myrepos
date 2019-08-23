package sample;

public class Goods {
	
	String goodsName;
	long price;
	
	public void setGoodsName(String goodsName) {
		if (goodsName.indexOf(" ") > -1) {
			this.goodsName = "error";
		}
		this.goodsName = goodsName;
	}

}
