package productpp;

import java.util.List;

public class DataBaseClient {

	public static void main(String[] args) throws Throwable {
		

		productDao productDao=new productDao();
		
    /*    int in1=productDao.save(new Product(1,"soap",34));
		System.out.println("data inserted succes fully-----"+ in1);
		
		int in2=productDao.save(new Product(2,"mobile",2345));
		System.out.println("data inserted succesfully-----"+ in2);
		
		//int count1=productDao.createtable();
		//System.out.println("table created succesfully"+count1);*/
		
		
		/*Product pro=productDao.findById(1);
		System.out.println(pro);*/
		
		/*List<Product>pro=productDao.findAllProducts();
		
		pro.forEach(System.out::println);*/
		
	/* updatecount=productDao.updatePrice(234,122343);
		System.out.println(updatecount);
		
	/*	int deletecount=productDao.deleteById(1);
		
		if(deletecount!=0)
		{
			System.out.println("deletion done succc_______------ "+deletecount);
		}
		else
		{
			System.out.println("deletion not done----________________"+deletecount);
		}*/
		
/*int deletecount=productDao.deleteByprice(2345);
		
		if(deletecount>0)
		{
			System.out.println("deletion successs-=-=-=-"+deletecount);
		}
		else
		{
			System.out.println("deletion not done_+_+_+_+=-=+_"+ deletecount);
		}*/
		
		int in=productDao.DropTableProduct();
		
		System.out.println("Table droped"+in);
		
	}

}
