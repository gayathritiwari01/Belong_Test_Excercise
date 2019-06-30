package project.dataobjects;

import java.util.Map;

public class Item {

	private String productname = null;
	private String productcolor = null;
	private Integer productqty = null;

	public String getproductname() {
		return productname;
	}

	public void setproductname(String productname) {
		this.productname = productname;
	}

	public String getproductcolor() {
		return productcolor;
	}

	public void setproductcolor(String productcolor) {
		this.productcolor = productcolor;
	}

	public int getproductqty() {
		return productqty;
	}

	public void setproductqty(int productqty) {
		this.productqty = productqty;
	}


	public static Item getInstance(Map<String, String> entry) {
		Item item = new Item();
		item.setproductname(entry.get("productname"));
		item.setproductcolor(entry.get("productcolor"));
		item.setproductqty(Integer.parseInt(entry.get("productqty")));
		return item;
	}

//	@Override
//	public String toString() {
//		StringBuilder builder = new StringBuilder();
//		builder.append("Transaction [name=");
//		builder.append(name);
//		builder.append(", amount=");
//		builder.append(amount);
//		builder.append(", frequency=");
//		builder.append(frequency);
//		builder.append(", month=");
//		builder.append(month);
//		builder.append("]");
//		return builder.toString();
//	}

}
