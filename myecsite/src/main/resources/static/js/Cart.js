class Cart {
	constructor(id, productName, price, count) {
		this.id = id;
		this.productName = productName;
		this.price = price;
		this.count = count;
	}
	
	set id(id) {
		this._id = id;
	}
	set productName(productName) {
		this._productName = productName;
	}
	set price(price) {
		this._price = price;
	}
	set count(count) {
		this._count = count;
	}
	
	get id() {
		return this._id;
	}
	get productName() {
		return this._productName;
	}
	get price() {
		return this._price;
	}
	get count() {
		return this._count;
	}
}