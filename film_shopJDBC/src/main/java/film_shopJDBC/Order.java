package film_shopJDBC;

public class Order {

	private int oID;
	private int cID;
	private float total;

	public Order() {

	}

	public Order(int oID, int cID, float total) {
		super();
		this.oID = oID;
		this.cID = cID;
		this.total = total;
	}

	public int getoID() {
		return oID;
	}

	public void setoID(int oID) {
		this.oID = oID;
	}

	public int getcID() {
		return cID;
	}

	public void setcID(int cID) {
		this.cID = cID;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return oID + " | " + cID + " |  £" + total;
	}

}
