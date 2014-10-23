package com.fieldschina.marketing.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.fieldschina.marketing.dbconn.DBConnectionManager;
import com.fieldschina.marketing.util.Util;
import com.fieldschina.marketing.dao.UserDao;
import com.fieldschina.marketing.entity.User;
/**
 * 获取用户数据的成数据库操作类
 * 
 * @author  LAVEN  E-mail:lavenwl@gmail.com
 * @company FieldsChina.IT.BI
 * @version 创建时间：2014-9-26 下午2:28:27
 */
public class UserDaoImpl implements UserDao{
	Logger log = Logger.getLogger(UserDaoImpl.class);
	@Override
	public List<User> getUsers() {
		return null;
	}

	@Override
	public List<User> getRegD14Days() {
		List<User> list = new ArrayList<User>();
		DBConnectionManager dbm = null;
		Connection conn = null;
		User r = null;
		try {
			dbm = DBConnectionManager.getInstance();
			conn = dbm.getConnection("biwebserver");
			PreparedStatement ps = conn.prepareStatement("select customer_id, email, firstname, lastname, telephone, phone, date_added from oc_customer where date_added > ? and date_added < ?");
			ps.setString(1, Util.getMonth());
			ps.setString(2, Util.get14DaysAgo());
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				r = new User();
				r.setId(rs.getInt("customer_id"));
				r.setEmail(rs.getString("email"));
				r.setFirstName(rs.getString("firstname"));
				r.setLastName(rs.getString("lastname"));
				r.setTelephone(rs.getString("telephone"));
				r.setPhone(rs.getString("phone"));
				r.setDateAdded(rs.getTimestamp("date_added") == null ? Util.paraseStringToTime("1900-01-01 12:00:00") : new Date(rs.getTimestamp("date_added").getTime()));
				list.add(r);
			}
			dbm.freeConnection("biwebserver", conn);
			ps.close();
			rs.close();
		} catch (Exception e) {
			log.error(Util.getTrace(e));
			if(dbm != null && conn != null){
				dbm.freeConnection("biwebserver", conn);
			}
		}
		return list;
	}

	@Override
	public List<User> getRegD14Days(int page, int perRows) {
		List<User> list = new ArrayList<User>();
		DBConnectionManager dbm = null;
		Connection conn = null;
		User r = null;
		try {
			dbm = DBConnectionManager.getInstance();
			conn = dbm.getConnection("biwebserver");
			PreparedStatement ps = conn.prepareStatement("select customer_id, email, firstname, lastname, telephone, phone, date_added from oc_customer where date_added > ? and date_added < ? limit ?,?");
			ps.setString(1, Util.getMonth());
			ps.setString(2, Util.get14DaysAgo());
			ps.setInt(3, (page - 1) * perRows);
			ps.setInt(4, perRows);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				r = new User();
				r.setId(rs.getInt("customer_id"));
				r.setEmail(rs.getString("email"));
				r.setFirstName(rs.getString("firstname"));
				r.setLastName(rs.getString("lastname"));
				r.setTelephone(rs.getString("telephone"));
				r.setPhone(rs.getString("phone"));
				r.setDateAdded(rs.getTimestamp("date_added") == null ? Util.paraseStringToTime("1900-01-01 12:00:00") : new Date(rs.getTimestamp("date_added").getTime()));
				list.add(r);
			}
			dbm.freeConnection("biwebserver", conn);
			ps.close();
			rs.close();
		} catch (Exception e) {
			log.error(Util.getTrace(e));
			if(dbm != null && conn != null){
				dbm.freeConnection("biwebserver", conn);
			}
		}
		return list;
	}

	@Override
	public List<User> getRegD7L14Days() {
		List<User> list = new ArrayList<User>();
		DBConnectionManager dbm = null;
		Connection conn = null;
		User r = null;
		try {
			dbm = DBConnectionManager.getInstance();
			conn = dbm.getConnection("biwebserver");
			PreparedStatement ps = conn.prepareStatement("select customer_id, email, firstname, lastname, telephone, phone, date_added from oc_customer where date_added > ? and date_added < ? and date_added > ?");
			ps.setString(1, Util.getMonth());
			ps.setString(2, Util.get7DaysAgo());
			ps.setString(3, Util.get14DaysAgo());
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				r = new User();
				r.setId(rs.getInt("customer_id"));
				r.setEmail(rs.getString("email"));
				r.setFirstName(rs.getString("firstname"));
				r.setLastName(rs.getString("lastname"));
				r.setTelephone(rs.getString("telephone"));
				r.setPhone(rs.getString("phone"));
				r.setDateAdded(rs.getTimestamp("date_added") == null ? Util.paraseStringToTime("1900-01-01 12:00:00") : new Date(rs.getTimestamp("date_added").getTime()));
				list.add(r);
			}
			dbm.freeConnection("biwebserver", conn);
			ps.close();
			rs.close();
		} catch (Exception e) {
			log.error(Util.getTrace(e));
			if(dbm != null && conn != null){
				dbm.freeConnection("biwebserver", conn);
			}
		}
		return list;
	}

	@Override
	public List<User> getRegD7L14Days(int page, int perRows) {
		List<User> list = new ArrayList<User>();
		DBConnectionManager dbm = null;
		Connection conn = null;
		User r = null;
		try {
			dbm = DBConnectionManager.getInstance();
			conn = dbm.getConnection("biwebserver");
			PreparedStatement ps = conn.prepareStatement("select customer_id, email, firstname, lastname, telephone, phone, date_added from oc_customer where date_added > ? and date_added < ? and date_added > ? limit ?,?");
			ps.setString(1, Util.getMonth());
			ps.setString(2, Util.get7DaysAgo());
			ps.setString(3, Util.get14DaysAgo());
			ps.setInt(4, (page - 1) * perRows);
			ps.setInt(5, perRows);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				r = new User();
				r.setId(rs.getInt("customer_id"));
				r.setEmail(rs.getString("email"));
				r.setFirstName(rs.getString("firstname"));
				r.setLastName(rs.getString("lastname"));
				r.setTelephone(rs.getString("telephone"));
				r.setPhone(rs.getString("phone"));
				r.setDateAdded(rs.getTimestamp("date_added") == null ? Util.paraseStringToTime("1900-01-01 12:00:00") : new Date(rs.getTimestamp("date_added").getTime()));
				list.add(r);
			}
			dbm.freeConnection("biwebserver", conn);
			ps.close();
			rs.close();
		} catch (Exception e) {
			log.error(Util.getTrace(e));
			if(dbm != null && conn != null){
				dbm.freeConnection("biwebserver", conn);
			}
		}
		return list;
	}
	
	@Override
	public List<User> getRegUserDefined(int day1, int day2, int page, int perRows) {
		List<User> list = new ArrayList<User>();
		DBConnectionManager dbm = null;
		Connection conn = null;
		User r = null;
		try {
			dbm = DBConnectionManager.getInstance();
			conn = dbm.getConnection("biwebserver");
			PreparedStatement ps = conn.prepareStatement("select customer_id, email, firstname, lastname, telephone, phone, date_added from oc_customer where date_added > ? and date_added < ? and date_added > ? limit ?,?");
			ps.setString(1, Util.getMonth());
			ps.setString(2, Util.getSomeDaysAgo(day1));
			ps.setString(3, Util.getSomeDaysAgo(day2));
			ps.setInt(4, (page - 1) * perRows);
			ps.setInt(5, perRows);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				r = new User();
				r.setId(rs.getInt("customer_id"));
				r.setEmail(rs.getString("email"));
				r.setFirstName(rs.getString("firstname"));
				r.setLastName(rs.getString("lastname"));
				r.setTelephone(rs.getString("telephone"));
				r.setPhone(rs.getString("phone"));
				r.setDateAdded(rs.getTimestamp("date_added") == null ? Util.paraseStringToTime("1900-01-01 12:00:00") : new Date(rs.getTimestamp("date_added").getTime()));
				list.add(r);
			}
			dbm.freeConnection("biwebserver", conn);
			ps.close();
			rs.close();
		} catch (Exception e) {
			log.error(Util.getTrace(e));
			if(dbm != null && conn != null){
				dbm.freeConnection("biwebserver", conn);
			}
		}
		return list;
	}

	@Override
	public List<User> getRegUserDefined(int day1, int day2) {
		List<User> list = new ArrayList<User>();
		DBConnectionManager dbm = null;
		Connection conn = null;
		User r = null;
		try {
			dbm = DBConnectionManager.getInstance();
			conn = dbm.getConnection("biwebserver");
			PreparedStatement ps = conn.prepareStatement("select customer_id, email, firstname, lastname, telephone, phone, date_added from oc_customer where date_added > ? and date_added < ? and date_added > ?");
			ps.setString(1, Util.getMonth());
			ps.setString(2, Util.getSomeDaysAgo(day1));
			ps.setString(3, Util.getSomeDaysAgo(day2));
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				r = new User();
				r.setId(rs.getInt("customer_id"));
				r.setEmail(rs.getString("email"));
				r.setFirstName(rs.getString("firstname"));
				r.setLastName(rs.getString("lastname"));
				r.setTelephone(rs.getString("telephone"));
				r.setPhone(rs.getString("phone"));
				r.setDateAdded(rs.getTimestamp("date_added") == null ? Util.paraseStringToTime("1900-01-01 12:00:00") : new Date(rs.getTimestamp("date_added").getTime()));
				list.add(r);
			}
			dbm.freeConnection("biwebserver", conn);
			ps.close();
			rs.close();
		} catch (Exception e) {
			log.error(Util.getTrace(e));
			if(dbm != null && conn != null){
				dbm.freeConnection("biwebserver", conn);
			}
		}
		return list;
	}

	@Override
	public List<User> getOrder2No10Days(int page, int perRows) {
		List<User> list = new ArrayList<User>();
		DBConnectionManager dbm = null;
		Connection conn = null;
		User r = null;
		try {
			dbm = DBConnectionManager.getInstance();
			conn = dbm.getConnection("biwebserver");
			PreparedStatement ps = conn.prepareStatement("SELECT c.customer_id, c.email, c.firstname, c.lastname, c.telephone, c.phone, c.date_added, x.shipping_phone,x.shipping_time	FROM oc_customer c INNER JOIN (	" +							
															"SELECT customer_id,shipping_phone,shipping_time	FROM oc_order t	WHERE t.date_added > date(DATE_ADD(now(), INTERVAL - 365 DAY))	" +								
																"AND t.order_status_id NOT IN (7, 11) and t.customer_id NOT IN (	" +										
																	"SELECT customer_id FROM	oc_order t1	WHERE t1.date_added > date(DATE_ADD(now(), INTERVAL - 10 DAY)))		" +					
																"GROUP BY customer_id HAVING count(*) = 2 ) x on c.customer_id=x.customer_id	where c.nationality_status = 1 " +														
														"union ALL " +									
														"SELECT c.customer_id, c.email, c.firstname, c.lastname, c.telephone, c.phone, c.date_added, x.shipping_phone, x.shipping_time FROM	oc_customer c INNER JOIN (		" +									
															"SELECT customer_id, shipping_phone,shipping_time FROM	oc_order t WHERE t.date_added > date(DATE_ADD(now(), INTERVAL - 365 DAY))	" +								
																"AND t.order_status_id NOT IN (7, 11) and t.customer_id NOT IN (	" +										
																	"SELECT customer_id FROM oc_order t1 WHERE t1.date_added > date(DATE_ADD(now(), INTERVAL - 10 DAY)))	" +						
																"GROUP BY customer_id HAVING count(*) = 3 ) x on c.customer_id=x.customer_id where c.nationality_status = 1 limit ?, ?");
			ps.setInt(1, (page - 1) * perRows);
			ps.setInt(2, perRows);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				r = new User();
				r.setId(rs.getInt("customer_id"));
				r.setEmail(rs.getString("email"));
				r.setFirstName(rs.getString("firstname"));
				r.setLastName(rs.getString("lastname"));
				r.setTelephone(rs.getString("telephone"));
				r.setPhone(rs.getString("phone"));
				r.setDateAdded(rs.getTimestamp("date_added") == null ? Util.paraseStringToTime("1900-01-01 12:00:00") : new Date(rs.getTimestamp("date_added").getTime()));
				list.add(r);
			}
			dbm.freeConnection("biwebserver", conn);
			ps.close();
			rs.close();
		} catch (Exception e) {
			log.error(Util.getTrace(e));
			if(dbm != null && conn != null){
				dbm.freeConnection("biwebserver", conn);
			}
		}
		return list;
	}

	@Override
	public List<User> getOrder2No10Days() {
		List<User> list = new ArrayList<User>();
		DBConnectionManager dbm = null;
		Connection conn = null;
		User r = null;
		try {
			dbm = DBConnectionManager.getInstance();
			conn = dbm.getConnection("biwebserver");
			PreparedStatement ps = conn.prepareStatement("SELECT c.customer_id, c.email, c.firstname, c.lastname, c.telephone, c.phone, c.date_added, x.shipping_phone,x.shipping_time	FROM oc_customer c INNER JOIN (	" +							
															"SELECT customer_id,shipping_phone,shipping_time	FROM oc_order t	WHERE t.date_added > date(DATE_ADD(now(), INTERVAL - 365 DAY))	" +								
																"AND t.order_status_id NOT IN (7, 11) and t.customer_id NOT IN (	" +										
																	"SELECT customer_id FROM	oc_order t1	WHERE t1.date_added > date(DATE_ADD(now(), INTERVAL - 10 DAY)))		" +					
																"GROUP BY customer_id HAVING count(*) = 2 ) x on c.customer_id=x.customer_id	where c.nationality_status = 1 " +														
														"union ALL		" +									
														"SELECT c.customer_id, c.email, c.firstname, c.lastname, c.telephone, c.phone, c.date_added, x.shipping_phone, x.shipping_time FROM	oc_customer c INNER JOIN (		" +									
															"SELECT customer_id, shipping_phone,shipping_time FROM	oc_order t WHERE t.date_added > date(DATE_ADD(now(), INTERVAL - 365 DAY))	" +								
																"AND t.order_status_id NOT IN (7, 11) and t.customer_id NOT IN (	" +										
																	"SELECT customer_id FROM oc_order t1 WHERE t1.date_added > date(DATE_ADD(now(), INTERVAL - 10 DAY)))	" +						
																"GROUP BY customer_id HAVING count(*) = 3 ) x on c.customer_id=x.customer_id	where c.nationality_status = 1	");
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				r = new User();
				r.setId(rs.getInt("customer_id"));
				r.setEmail(rs.getString("email"));
				r.setFirstName(rs.getString("firstname"));
				r.setLastName(rs.getString("lastname"));
				r.setTelephone(rs.getString("telephone"));
				r.setPhone(rs.getString("phone"));
				r.setDateAdded(rs.getTimestamp("date_added") == null ? Util.paraseStringToTime("1900-01-01 12:00:00") : new Date(rs.getTimestamp("date_added").getTime()));
				list.add(r);
			}
			dbm.freeConnection("biwebserver", conn);
			ps.close();
			rs.close();
		} catch (Exception e) {
			log.error(Util.getTrace(e));
			if(dbm != null && conn != null){
				dbm.freeConnection("biwebserver", conn);
			}
		}
		return list;
	}

	@Override
	public List<User> get4Orders(int page, int perRows) {
		List<User> list = new ArrayList<User>();
		DBConnectionManager dbm = null;
		Connection conn = null;
		User r = null;
		try {
			dbm = DBConnectionManager.getInstance();
			conn = dbm.getConnection("biwebserver");
			PreparedStatement ps = conn.prepareStatement("SELECT c.customer_id, c.email, c.firstname, c.lastname, c.telephone, c.phone, c.date_added, x.shipping_phone, x.shipping_time FROM	oc_customer c INNER JOIN ( " +									
															"SELECT customer_id, shipping_phone,shipping_time FROM	oc_order t WHERE t.date_added > date(DATE_ADD(now(), INTERVAL - 365 DAY))	" +								
															"AND t.order_status_id NOT IN (7, 11) " +															
															"GROUP BY customer_id HAVING count(*) > 3 ) x on c.customer_id=x.customer_id where c.nationality_status = 1 limit ?,?");
			ps.setInt(1, (page - 1) * perRows);
			ps.setInt(2, perRows);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				r = new User();
				r.setId(rs.getInt("customer_id"));
				r.setEmail(rs.getString("email"));
				r.setFirstName(rs.getString("firstname"));
				r.setLastName(rs.getString("lastname"));
				r.setTelephone(rs.getString("telephone"));
				r.setPhone(rs.getString("phone"));
				r.setDateAdded(rs.getTimestamp("date_added") == null ? Util.paraseStringToTime("1900-01-01 12:00:00") : new Date(rs.getTimestamp("date_added").getTime()));
				list.add(r);
			}
			dbm.freeConnection("biwebserver", conn);
			ps.close();
			rs.close();
		} catch (Exception e) {
			log.error(Util.getTrace(e));
			if(dbm != null && conn != null){
				dbm.freeConnection("biwebserver", conn);
			}
		}
		return list;
	}

	@Override
	public List<User> get4Orders() {
		List<User> list = new ArrayList<User>();
		DBConnectionManager dbm = null;
		Connection conn = null;
		User r = null;
		try {
			dbm = DBConnectionManager.getInstance();
			conn = dbm.getConnection("biwebserver");
			PreparedStatement ps = conn.prepareStatement("SELECT c.customer_id, c.email, c.firstname, c.lastname, c.telephone, c.phone, c.date_added, x.shipping_phone, x.shipping_time FROM	oc_customer c INNER JOIN (		" +									
															"SELECT customer_id, shipping_phone,shipping_time FROM	oc_order t WHERE t.date_added > date(DATE_ADD(now(), INTERVAL - 365 DAY))	" +								
																"AND t.order_status_id NOT IN (7, 11) " +															
																"GROUP BY customer_id HAVING count(*) > 3 ) x on c.customer_id=x.customer_id where c.nationality_status = 1");
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				r = new User();
				r.setId(rs.getInt("customer_id"));
				r.setEmail(rs.getString("email"));
				r.setFirstName(rs.getString("firstname"));
				r.setLastName(rs.getString("lastname"));
				r.setTelephone(rs.getString("telephone"));
				r.setPhone(rs.getString("phone"));
				r.setDateAdded(rs.getTimestamp("date_added") == null ? Util.paraseStringToTime("1900-01-01 12:00:00") : new Date(rs.getTimestamp("date_added").getTime()));
				list.add(r);
			}
			dbm.freeConnection("biwebserver", conn);
			ps.close();
			rs.close();
		} catch (Exception e) {
			log.error(Util.getTrace(e));
			if(dbm != null && conn != null){
				dbm.freeConnection("biwebserver", conn);
			}
		}
		return list;
	}

	@Override
	public List<User> getOrderUserDefined(int num, int day, int page, int perRows) {
		List<User> list = new ArrayList<User>();
		DBConnectionManager dbm = null;
		Connection conn = null;
		User r = null;
		try {
			dbm = DBConnectionManager.getInstance();
			conn = dbm.getConnection("biwebserver");
			PreparedStatement ps = conn.prepareStatement("SELECT c.customer_id, c.email, c.firstname, c.lastname, c.telephone, c.phone, c.date_added, x.shipping_phone, x.shipping_time FROM	oc_customer c INNER JOIN (		" +									
															"SELECT customer_id, shipping_phone,shipping_time FROM	oc_order t WHERE t.date_added > date(DATE_ADD(now(), INTERVAL - 365 DAY))	" +								
																"AND t.order_status_id NOT IN (7, 11) and t.customer_id NOT IN (	" +										
																	"SELECT customer_id FROM oc_order t1 WHERE t1.date_added > date(DATE_ADD(now(), INTERVAL - ? DAY)))	" +						
																"GROUP BY customer_id HAVING count(*) = ? ) x on c.customer_id=x.customer_id where c.nationality_status = 1 limit ?, ?");
			ps.setInt(1, day);
			ps.setInt(2, num);
			ps.setInt(3, (page - 1) * perRows);
			ps.setInt(4, perRows);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				r = new User();
				r.setId(rs.getInt("customer_id"));
				r.setEmail(rs.getString("email"));
				r.setFirstName(rs.getString("firstname"));
				r.setLastName(rs.getString("lastname"));
				r.setTelephone(rs.getString("telephone"));
				r.setPhone(rs.getString("phone"));
				r.setDateAdded(rs.getTimestamp("date_added") == null ? Util.paraseStringToTime("1900-01-01 12:00:00") : new Date(rs.getTimestamp("date_added").getTime()));
				list.add(r);
			}
			dbm.freeConnection("biwebserver", conn);
			ps.close();
			rs.close();
		} catch (Exception e) {
			log.error(Util.getTrace(e));
			if(dbm != null && conn != null){
				dbm.freeConnection("biwebserver", conn);
			}
		}
		return list;
	}

	@Override
	public List<User> getOrderUserDefined(int num, int day) {
		List<User> list = new ArrayList<User>();
		DBConnectionManager dbm = null;
		Connection conn = null;
		User r = null;
		try {
			dbm = DBConnectionManager.getInstance();
			conn = dbm.getConnection("biwebserver");
			PreparedStatement ps = conn.prepareStatement("SELECT c.customer_id, c.email, c.firstname, c.lastname, c.telephone, c.phone, c.date_added, x.shipping_phone, x.shipping_time FROM	oc_customer c INNER JOIN (		" +									
															"SELECT customer_id, shipping_phone,shipping_time FROM	oc_order t WHERE t.date_added > date(DATE_ADD(now(), INTERVAL - 365 DAY))	" +								
																"AND t.order_status_id NOT IN (7, 11) and t.customer_id NOT IN (	" +										
																	"SELECT customer_id FROM oc_order t1 WHERE t1.date_added > date(DATE_ADD(now(), INTERVAL - ? DAY)))	" +						
																"GROUP BY customer_id HAVING count(*) = ? ) x on c.customer_id=x.customer_id where c.nationality_status = 1");
			ps.setInt(1, day);
			ps.setInt(2, num);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				r = new User();
				r.setId(rs.getInt("customer_id"));
				r.setEmail(rs.getString("email"));
				r.setFirstName(rs.getString("firstname"));
				r.setLastName(rs.getString("lastname"));
				r.setTelephone(rs.getString("telephone"));
				r.setPhone(rs.getString("phone"));
				r.setDateAdded(rs.getTimestamp("date_added") == null ? Util.paraseStringToTime("1900-01-01 12:00:00") : new Date(rs.getTimestamp("date_added").getTime()));
				list.add(r);
			}
			dbm.freeConnection("biwebserver", conn);
			ps.close();
			rs.close();
		} catch (Exception e) {
			log.error(Util.getTrace(e));
			if(dbm != null && conn != null){
				dbm.freeConnection("biwebserver", conn);
			}
		}
		return list;
	}

	@Override
	public List<User> getOrderBiggerUserDefined(int num, int page, int perRows) {
		List<User> list = new ArrayList<User>();
		DBConnectionManager dbm = null;
		Connection conn = null;
		User r = null;
		try {
			dbm = DBConnectionManager.getInstance();
			conn = dbm.getConnection("biwebserver");
			PreparedStatement ps = conn.prepareStatement("SELECT c.customer_id, c.email, c.firstname, c.lastname, c.telephone, c.phone, c.date_added, x.shipping_phone, x.shipping_time FROM	oc_customer c INNER JOIN (		" +									
															"SELECT customer_id, shipping_phone,shipping_time FROM	oc_order t WHERE t.date_added > date(DATE_ADD(now(), INTERVAL - 365 DAY))	" +								
															"AND t.order_status_id NOT IN (7, 11) " +															
															"GROUP BY customer_id HAVING count(*) > ? ) x on c.customer_id=x.customer_id where c.nationality_status = 1 limit ?,?");
			ps.setInt(1, num);
			ps.setInt(2, (page - 1) * perRows);
			ps.setInt(3, perRows);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				r = new User();
				r.setId(rs.getInt("customer_id"));
				r.setEmail(rs.getString("email"));
				r.setFirstName(rs.getString("firstname"));
				r.setLastName(rs.getString("lastname"));
				r.setTelephone(rs.getString("telephone"));
				r.setPhone(rs.getString("phone"));
				r.setDateAdded(rs.getTimestamp("date_added") == null ? Util.paraseStringToTime("1900-01-01 12:00:00") : new Date(rs.getTimestamp("date_added").getTime()));
				list.add(r);
			}
			dbm.freeConnection("biwebserver", conn);
			ps.close();
			rs.close();
		} catch (Exception e) {
			log.error(Util.getTrace(e));
			if(dbm != null && conn != null){
				dbm.freeConnection("biwebserver", conn);
			}
		}
		return list;
	}

	@Override
	public List<User> getOrderBiggerUserDefined(int num) {
		List<User> list = new ArrayList<User>();
		DBConnectionManager dbm = null;
		Connection conn = null;
		User r = null;
		try {
			dbm = DBConnectionManager.getInstance();
			conn = dbm.getConnection("biwebserver");
			PreparedStatement ps = conn.prepareStatement("SELECT c.customer_id, c.email, c.firstname, c.lastname, c.telephone, c.phone, c.date_added, x.shipping_phone, x.shipping_time FROM	oc_customer c INNER JOIN (		" +									
															"SELECT customer_id, shipping_phone,shipping_time FROM	oc_order t WHERE t.date_added > date(DATE_ADD(now(), INTERVAL - 365 DAY))	" +								
															"AND t.order_status_id NOT IN (7, 11) " +															
															"GROUP BY customer_id HAVING count(*) > ? ) x on c.customer_id=x.customer_id where c.nationality_status = 1");
			ps.setInt(1, num);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				r = new User();
				r.setId(rs.getInt("customer_id"));
				r.setEmail(rs.getString("email"));
				r.setFirstName(rs.getString("firstname"));
				r.setLastName(rs.getString("lastname"));
				r.setTelephone(rs.getString("telephone"));
				r.setPhone(rs.getString("phone"));
				r.setDateAdded(rs.getTimestamp("date_added") == null ? Util.paraseStringToTime("1900-01-01 12:00:00") : new Date(rs.getTimestamp("date_added").getTime()));
				list.add(r);
			}
			dbm.freeConnection("biwebserver", conn);
			ps.close();
			rs.close();
		} catch (Exception e) {
			log.error(Util.getTrace(e));
			if(dbm != null && conn != null){
				dbm.freeConnection("biwebserver", conn);
			}
		}
		return list;
	}

	

	@Override
	public List<User> getUsersNum() {
		return null;
	}

	@Override
	public int getRegD14DaysNum() {
		int res = 0;
		DBConnectionManager dbm = null;
		Connection conn = null;
		User r = null;
		try {
			dbm = DBConnectionManager.getInstance();
			conn = dbm.getConnection("biwebserver");
			PreparedStatement ps = conn.prepareStatement("select count(*) num from oc_customer where date_added > ? and date_added < ?");
			ps.setString(1, Util.getMonth());
			ps.setString(2, Util.get14DaysAgo());
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				res = rs.getInt("num");
			}
			dbm.freeConnection("biwebserver", conn);
			ps.close();
			rs.close();
		} catch (Exception e) {
			log.error(Util.getTrace(e));
			if(dbm != null && conn != null){
				dbm.freeConnection("biwebserver", conn);
			}
		}
		return res;
	}

	@Override
	public int getRegD7L14DaysNum() {
		int res = 0;
		DBConnectionManager dbm = null;
		Connection conn = null;
		User r = null;
		try {
			dbm = DBConnectionManager.getInstance();
			conn = dbm.getConnection("biwebserver");
			PreparedStatement ps = conn.prepareStatement("select count(*) num from oc_customer where date_added > ? and date_added < ? and date_added > ?");
			ps.setString(1, Util.getMonth());
			ps.setString(2, Util.get7DaysAgo());
			ps.setString(3, Util.get14DaysAgo());
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				res = rs.getInt("num");
			}
			dbm.freeConnection("biwebserver", conn);
			ps.close();
			rs.close();
		} catch (Exception e) {
			log.error(Util.getTrace(e));
			if(dbm != null && conn != null){
				dbm.freeConnection("biwebserver", conn);
			}
		}
		return res;
	}
	

	@Override
	public int getRegUserDefinedNum(int day1, int day2) {
		int res = 0;
		DBConnectionManager dbm = null;
		Connection conn = null;
		User r = null;
		try {
			dbm = DBConnectionManager.getInstance();
			conn = dbm.getConnection("biwebserver");
			PreparedStatement ps = conn.prepareStatement("select count(*) num from oc_customer where date_added > ? and date_added < ? and date_added > ?");
			ps.setString(1, Util.getMonth());
			ps.setString(2, Util.getSomeDaysAgo(day1));
			ps.setString(3, Util.getSomeDaysAgo(day2));
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				res = rs.getInt("num");
			}
			dbm.freeConnection("biwebserver", conn);
			ps.close();
			rs.close();
		} catch (Exception e) {
			log.error(Util.getTrace(e));
			if(dbm != null && conn != null){
				dbm.freeConnection("biwebserver", conn);
			}
		}
		return res;
	}

	@Override
	public int getOrder2No10DaysNum() {
		int res = 0;
		DBConnectionManager dbm = null;
		Connection conn = null;
		User r = null;
		try {
			dbm = DBConnectionManager.getInstance();
			conn = dbm.getConnection("biwebserver");
			PreparedStatement ps = conn.prepareStatement("SELECT count(*) num FROM oc_customer c INNER JOIN (	" +							
															"SELECT customer_id,shipping_phone,shipping_time	FROM oc_order t	WHERE t.date_added > date(DATE_ADD(now(), INTERVAL - 365 DAY))	" +								
																"AND t.order_status_id NOT IN (7, 11) and t.customer_id NOT IN (	" +										
																	"SELECT customer_id FROM	oc_order t1	WHERE t1.date_added > date(DATE_ADD(now(), INTERVAL - 10 DAY)))		" +					
																"GROUP BY customer_id HAVING count(*) = 2 ) x on c.customer_id=x.customer_id	" +														
														"union ALL		" +									
														"SELECT  count(*) num  FROM	oc_customer c INNER JOIN (		" +									
															"SELECT customer_id, shipping_phone,shipping_time FROM	oc_order t WHERE t.date_added > date(DATE_ADD(now(), INTERVAL - 365 DAY))	" +								
																"AND t.order_status_id NOT IN (7, 11) and t.customer_id NOT IN (	" +										
																	"SELECT customer_id FROM oc_order t1 WHERE t1.date_added > date(DATE_ADD(now(), INTERVAL - 10 DAY)))	" +						
																"GROUP BY customer_id HAVING count(*) = 3 ) x on c.customer_id=x.customer_id	where c.nationality_status = 1	");
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				res = res + rs.getInt("num");
			}
			dbm.freeConnection("biwebserver", conn);
			ps.close();
			rs.close();
		} catch (Exception e) {
			log.error(Util.getTrace(e));
			if(dbm != null && conn != null){
				dbm.freeConnection("biwebserver", conn);
			}
		}
		return res;
	}

	@Override
	public int get4OrdersNum() {
		int res = 0;
		DBConnectionManager dbm = null;
		Connection conn = null;
		User r = null;
		try {
			dbm = DBConnectionManager.getInstance();
			conn = dbm.getConnection("biwebserver");
			PreparedStatement ps = conn.prepareStatement("SELECT  count(*) num  FROM	oc_customer c INNER JOIN (		" +									
															"SELECT customer_id, shipping_phone,shipping_time FROM	oc_order t WHERE t.date_added > date(DATE_ADD(now(), INTERVAL - 365 DAY))	" +								
																"AND t.order_status_id NOT IN (7, 11) " +															
																"GROUP BY customer_id HAVING count(*) > 3 ) x on c.customer_id=x.customer_id where c.nationality_status = 1");
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				res = rs.getInt("num");
			}
			dbm.freeConnection("biwebserver", conn);
			ps.close();
			rs.close();
		} catch (Exception e) {
			log.error(Util.getTrace(e));
			if(dbm != null && conn != null){
				dbm.freeConnection("biwebserver", conn);
			}
		}
		return res;
	}
	
	@Override
	public int getOrderUserDefinedNum(int num, int day) {
		int res = 0;
		DBConnectionManager dbm = null;
		Connection conn = null;
		User r = null;
		try {
			dbm = DBConnectionManager.getInstance();
			conn = dbm.getConnection("biwebserver");
			PreparedStatement ps = conn.prepareStatement("SELECT  count(*) num FROM	oc_customer c INNER JOIN (		" +									
															"SELECT customer_id, shipping_phone,shipping_time FROM	oc_order t WHERE t.date_added > date(DATE_ADD(now(), INTERVAL - 365 DAY))	" +								
																"AND t.order_status_id NOT IN (7, 11) and t.customer_id NOT IN (	" +										
																	"SELECT customer_id FROM oc_order t1 WHERE t1.date_added > date(DATE_ADD(now(), INTERVAL - ? DAY)))	" +						
																"GROUP BY customer_id HAVING count(*) = ? ) x on c.customer_id=x.customer_id where c.nationality_status = 1");
			ps.setInt(1, day);
			ps.setInt(2, num);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				res = rs.getInt("num");
			}
			dbm.freeConnection("biwebserver", conn);
			ps.close();
			rs.close();
		} catch (Exception e) {
			log.error(Util.getTrace(e));
			if(dbm != null && conn != null){
				dbm.freeConnection("biwebserver", conn);
			}
		}
		return res;
	}

	@Override
	public int getOrderBiggerUserDefinedNum(int num) {
		int res = 0;
		DBConnectionManager dbm = null;
		Connection conn = null;
		User r = null;
		try {
			dbm = DBConnectionManager.getInstance();
			conn = dbm.getConnection("biwebserver");
			PreparedStatement ps = conn.prepareStatement("SELECT  count(*) num FROM	oc_customer c INNER JOIN (		" +									
															"SELECT customer_id, shipping_phone,shipping_time FROM	oc_order t WHERE t.date_added > date(DATE_ADD(now(), INTERVAL - 365 DAY))	" +								
															"AND t.order_status_id NOT IN (7, 11) " +															
															"GROUP BY customer_id HAVING count(*) > ? ) x on c.customer_id=x.customer_id where c.nationality_status = 1");
			ps.setInt(1, num);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				res = rs.getInt("num");
			}
			dbm.freeConnection("biwebserver", conn);
			ps.close();
			rs.close();
		} catch (Exception e) {
			log.error(Util.getTrace(e));
			if(dbm != null && conn != null){
				dbm.freeConnection("biwebserver", conn);
			}
		}
		return res;
	}



	


}
