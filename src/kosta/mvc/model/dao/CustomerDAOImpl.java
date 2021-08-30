package kosta.mvc.model.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import kosta.mvc.model.dto.Customer;

import util.DBUtil;

public class CustomerDAOImpl implements CustomerDAO {
	private Properties proFile = DBUtil.getProFile();

/////////////////////TEST////////////////////////
/*public static void main(String[] args) {
	CustomerDAOImpl cd = new CustomerDAOImpl();
	Customer c = null;

	try {
	
		c = new Customer("m", "tiger","����ũ","00-03-04","masklover@naver.com","��⵵ �Ǳ�","010-3333-3333"); 
		System.out.println(cd.insertCustomer(c));
	
		//customerLogin(String customerId, String customerpwd)
		c = cd.customerLogin("hong", "111");
		System.out.println(c);
		
		//updateCustomerEmail(String customerId, String email)
		System.out.println(cd.updateCustomerEmail("JANG", "JANG@naver.com"));
		
		//updateCustomerPwd(String customerId, String pwd)
		System.out.println(cd.updateCustomerPwd("YOO", "1234"));
	
		//updateCustomerAddr(String customerId, String addr)
		System.out.println(cd.updateCustomerAddr("JANG", "����� ���ʱ�"));
		
		//deleteCustomer(String customerId)
		System.out.pritnln(cd.deleteCustomer());
		
		System.out.println(cd.findCustomerId("AAA111@naver.com"));
		
		System.out.println(cd.findCustomerPwd("CHOI1", "AAA111@naver.com"));
		
		System.out.println(cd.findCustomerName("CHOI1"));
		

		List<Customer> list = cd.selectCustomerListAll();
			for(Customer ct : list) 
			System.out.print(ct);
	
	
		}catch (Exception e) {
		e.printStackTrace();
	}
}*/
/////////////////////TEST////////////////////////


	@Override
	public int insertCustomer(Customer customer) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = proFile.getProperty("customer.insertCustomer");
		
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			//insert into customer(customer_id, pwd, customer_name, birth, email, addr, contact, sign_date ) 
			//values( ?, ?, ?, ?, ?, ?, ?, sysdate)
			ps.setString(1, customer.getCustomerId());
			ps.setString(2, customer.getPwd());
			ps.setString(3, customer.getCustomerName());
			ps.setString(4, customer.getBirth());
			ps.setString(5, customer.getEmail());
			ps.setString(6, customer.getAddr());
			ps.setString(7, customer.getContact());
			
			
			result = ps.executeUpdate();
			
		} finally {
			DBUtil.dbClose(con, ps);
		}
		
		return result;
	}
////////////////////////////////////////////////
	// ���̵� �ߺ� üũ 
	@Override
	public String customerIdDuplicationCheck(String customerId) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String Id = null;
		
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(proFile.getProperty("customer.customerIdDuplicationCheck")) ;
			
			ps.setString(1, customerId);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				Id = rs.getString(1);
			}
			
		}finally {
			DBUtil.dbClose(con, ps ,rs);
		}
		return Id;
	}

	
/////////////////////////////////////////////////
	//�α����ϱ�
	
	@Override
	public Customer customerLogin(String customerId, String customerpwd) throws SQLException {
		
		  Connection con=null;
		  PreparedStatement ps=null;
		  ResultSet rs=null;
		  Customer customer=null;
		 try {
		   con = DBUtil.getConnection();
		   //customer.sellerCheck = select seller from customer where customer_id = ?
		   ps = con.prepareStatement(proFile.getProperty("customer.customerLogin"));
		   ps.setString(1, customerId);
		   ps.setString(2, customerpwd);
		   
	        rs = ps.executeQuery(); 
	        
	        if(rs.next()) {
	        	customer = new Customer(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9));
	        }
      }finally {
      	DBUtil.dbClose(con, ps, rs);
      }
		return customer;
	}


	//email��  idã��
	
	
	@Override
	public String findCustomerId(String email) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String id = null;
		
		try {
			con = DBUtil.getConnection();
			//SELECT CUSTOMER_ID FROM CUSTOMER WHERE EMAIL = ?
			ps = con.prepareStatement(proFile.getProperty("customer.findCustomerId")) ;
			
			ps.setString(1, email);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				id = rs.getString(1);
			}
			
		}finally {
			DBUtil.dbClose(con, ps ,rs);
		}
		return id;
	}
		
	
// pwd ã��  -���̵��Է� + �̸��� 
	@Override
	public String findCustomerPwd(String customerId, String email) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String pwd = null;
		
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(proFile.getProperty("customer.findCustomerPwd")) ;
			
			//SELECT PWD FROM CUSTOMER WHERE EMAIL = ? AND CUSTOMER_ID = ?
			ps.setString(1, email);
			ps.setString(2, customerId);

			rs = ps.executeQuery();
			
			if(rs.next()) {
				pwd = rs.getString(1);
			}
			
		}finally {
			DBUtil.dbClose(con, ps ,rs);
		}
		
		return pwd;
	}
	
	@Override
	public String findCustomerName(String customerId) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String name = null;
		
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(proFile.getProperty("customer.findCustomerName")) ;
			
			ps.setString(1, customerId);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				name = rs.getString(1);
			}
			
		}finally {
			DBUtil.dbClose(con, ps ,rs);
		}
		
		return name;
	}
/////////////////////////////////////////////////////////////////
	//ȸ���������� (�̸��� ����)
	
	@Override
	public int updateCustomerEmail(String customerId, String email) throws SQLException {
		int result = 0;
		Connection con = null;
		PreparedStatement ps = null;
		String sql = proFile.getProperty("customer.updateCustomerEmail");
		
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql) ;
			
			//update customer set email = ? where customer_id = ?
			ps.setString(1, email);
			ps.setString(2, customerId);

			result = ps.executeUpdate();

		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			DBUtil.dbClose(con, ps);
		}
		return result;
	}
	
//////////////////////////////////////////////////////////
// ȸ���������� (��й�ȣ)
	
	@Override
	public int updateCustomerPwd(String customerId, String pwd) throws SQLException {
		int result = 0;
		Connection con = null;
		PreparedStatement ps = null;
		String sql = proFile.getProperty("customer.updateCustomerPwd");
		
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql) ;
			
			//update customer set pwd = ? where customer_id = ? 
			ps.setString(1, pwd);
			ps.setString(2, customerId);

			result = ps.executeUpdate();

		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			DBUtil.dbClose(con, ps);
		}
		return result;
	}

///////////////////////////////////////////////////
//	 ȸ���������� (�ּҺ���)	

	@Override
	public int updateCustomerAddr(String customerId, String addr) throws SQLException {
		int result = 0;
		Connection con = null;
		PreparedStatement ps = null;
		String sql = proFile.getProperty("customer.updateCustomerAddr");
		
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql) ;
			
			//update customer set addr = ? where customer_id= ?
			ps.setString(1, addr);
			ps.setString(2, customerId);
			
			result = ps.executeUpdate();

		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			DBUtil.dbClose(con, ps);
		}
		return result;
	}

	
//////////////////////////////////////////////
// ȸ��Ż��	
	
	@Override
	public int deleteCustomer(String customerId) throws SQLException {
		int result = 0;
		Connection con = null;
		PreparedStatement ps = null;
		String sql = proFile.getProperty("customer.deleteCustomer");
		
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql) ;
			
			ps.setString(1, customerId);
			result = ps.executeUpdate();

		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			DBUtil.dbClose(con, ps);
		}
		return result;
	}	
	
	/**
	 * ȸ�� ���� Ȯ��
	 * (���̵� ������ -> Customer ��ü(DTO)�� �����ִ� �޼ҵ�!)
	 * */
	public Customer selectCustomerByCustomerId(String customerId) throws SQLException{
		//�ϴ� ������ Ŀ���͸�DTO ������� �ϳ� �����...
		Customer customer = null;
		
		//Ŀ�ؼ�, ����������Ʈ��Ʈ(���� ����), ����Ʈ ��(����� ���ð�) �غ��ص�.
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		//������� ������Ʈ��Ʈ�� ������ �� ������ �ϳ� �غ��ص�.
		String sql = "SELECT CUSTOMER_ID, PWD, CUSTOMER_NAME, BIRTH, EMAIL, ADDR, CONTACT, SIGN_DATE, SELLER FROM CUSTOMER WHERE CUSTOMER_ID=?";
		
		try {
			//con�� DBUtil�� �ִ� �� Ŀ�ؼ� �޼ҵ�� Ŀ�ؼ� �����ϱ�
			con = DBUtil.getConnection();
			//con���ٰ� ������� ������Ʈ��Ʈ �޼ҵ� ȣ���ؼ� ������ ���� sql ��, ���� �־���.
			//�׸��� �̰� ������� ������Ʈ��Ʈ ��ü�� �ٽ� �־���.
			ps = con.prepareStatement(sql);
			//������ �������� ����ǥ(?)�ϳ� �ִ� �����ٰ� �޼ҵ忡�� �޾ƿ� customerId�� �־���.
			ps.setString(1, customerId);
			//�̷����ϸ� ��������...
			//SELECT CUSTOMER_ID...(����) FROM CUSTOMER WHERE CUSTOMER_ID=ȸ����ȣ�� ��.
			//��, ȸ����ȣ�� ��ġ�ϴ� ���ڵ��� ���̵�, ���, ����� ��������� ������ �ϼ���.
			
			//������ �ϼ��Ǿ����ϱ� ����ťƮ(����) ����.
			//executeQuery�޼ҵ��� ����Ÿ���� ����Ʈ ���̴ϱ�...
			//�̰� ������ ������ rs �������ٰ� �־���.
			rs = ps.executeQuery();
			
			if(rs.next()) { //���࿡ rs.next()�� true���...
							//��, ������� ������ �ִٸ�...
				//������ �Է��� ������ select�� �÷��� ��,
				//CUSTOMER_ID, PWD, CUSTOMER_NAME, BIRTH, EMAIL, ADDR, CONTACT, SIGN_DATE, SELLER 
				// 1		   2    3              4      5      6     7        8          9 
				//��͵��� ���ʴ�� ���� ������.
				String id = rs.getString(1); //ù��°=CUSTOMER_ID
				String pwd = rs.getString(2); //�ι�°=PWD
				String customerName = rs.getString(3); //����°=CUSTOMER_NAME
				String birth = rs.getString(4); //�׹�°=BIRTH
				String email = rs.getString(5); //�ټ���°=EMAIL
				String addr = rs.getString(6); //������°=ADDR
				String contact = rs.getString(7); //�ϰ���°=CONTACT
				String signDate = rs.getString(8); //������°=SIGN_DATE
				String seller = rs.getString(9); //��ȩ��°=SELLER
				
				//���� �޾ƿ� ������ �Ʊ� ������ ���� ���Ͽ� Ŀ���͸� ��ü(DTO)���ٰ� �����ڷ� �־���.
				customer= new Customer(customerId, pwd, customerName, birth, email, addr,contact, signDate, seller);
				//�̷��� �ϼ��� Ŀ���͸� ��ü�� ���� ���ϸ� ���ָ� ��.
			}
			
			
		}finally {
			//�޼ҵ� ������ ���� ������ con, ps, rs�� �ݾ���.
			DBUtil.dbClose(con, ps, rs);
		}
		
		//������ ó���� customer�� ���鶧 �⺻������ null���� �����ϱ�...
		//������ �������� �� ������� ������ �갡 ��� null �ϰ��̰�...
		//������� �־��ٸ� �����ڷ� ���� ���ִ� Customer ��ü(DTO)�� ���ϵɰ���. 
		return customer;
	}
	
	/**
	 * ȸ������ �Ǹ��� Ȯ��  
	 * @return seller�� ��� "SELLER"(�빮�� ����!) �� ����. �ƴ� ��� null�� ����  
	 **/
	public String sellerCheck (String customerId) throws SQLException{
		String seller = null;
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = proFile.getProperty("customer.sellerCheck");
		
		try {
			con = DBUtil.getConnection();
			
			//select seller(default null�� �����) from customer where customer_id = ?
			ps = con.prepareStatement(sql) ;
			ps.setString(1, customerId);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				seller = rs.getString(1);
			}			
		} finally {
			DBUtil.dbClose(con, ps, rs);
		}
		
		return seller;
		//seller == null -> ȸ��
		//seller == SELLER -> �Ǹ��� 
	}

	
	/**
	 *  ������ - ��ü ȸ�� ����Ʈ ���� 
	 **/

	@Override
	public List<Customer> selectCustomerListAll() throws SQLException {
		Connection con = null;
		PreparedStatement ps = null; 
		ResultSet rs = null;
		List<Customer>customerList = new ArrayList<Customer>();
		String sql = proFile.getProperty("customer.selectCustomerListAll" );
		//select customer_id, pwd, customer_name, birth, email, addr, contact, sign_date, seller from customer 

		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
	
			while(rs.next()) {
				
				String customerId = rs.getString(1);
				String pwd = rs.getString(2);
				String customerName = rs.getString(3);
				String birth = rs.getString(4);
				String email = rs.getString(5);
				String addr = rs.getString(6);
				String contact = rs.getString(7);
				String signDate = rs.getString(8);
				String seller = rs.getString(9);
				
				Customer customerDto= new Customer(customerId, pwd, customerName, birth, email, addr, contact, signDate, seller);
								
				//Customer customerDto= new Customer(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
				customerList.add(customerDto);
			}
		}catch(Exception e ) {
			e.printStackTrace();
		
		}finally {
			DBUtil.dbClose(con, ps,rs);
		}
		return customerList;
	}

	
	/**
	 * ������ - ȸ������ 
	 **/
}
