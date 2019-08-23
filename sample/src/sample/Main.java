package sample;

public class Main {

	public static void main(String[] args) {
		new Main().test();
	}
	
	public void test() {
		Goods goods = new Goods();
		goods.goodsName = "aaa   aa";
		
		goods.setGoodsName("aaa   aa");
		System.out.println(Person.GENER_MALE);
		
	}

}
