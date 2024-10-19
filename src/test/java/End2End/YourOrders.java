package End2End;

public class YourOrders {
	
	private Data data;
	private String message;
	
	public Data getData() {
		return data;
	}
	public void setData(Data data) {
		this.data = data;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	


}

/*
{
    "data": {
        "_id": "66c27f6dae2afd4c0b5114fa",
        "orderById": "66c0e423ae2afd4c0b4fbb36",
        "orderBy": "nishith@gmail.com",
        "productOrderedId": "66c27f57ae2afd4c0b5114f6",
        "productName": "qwerty",
        "country": "United States",
        "productDescription": "Addias Originals",
        "productImage": "https://rahulshettyacademy.com/api/ecom/uploads/productImage_1724022613998.png",
        "orderPrice": "11500",
        "__v": 0
    },
    "message": "Orders fetched for customer Successfully"
}
*/