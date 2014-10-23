package com.fieldschina.marketing.service;

import java.util.List;

import com.fieldschina.marketing.dao.UserDao;
import com.fieldschina.marketing.dao.impl.UserDaoImpl;
import com.fieldschina.marketing.entity.User;
/**
 * 获取用户信息逻辑处理类
 * 
 * @author  LAVEN  E-mail:lavenwl@gmail.com
 * @company FieldsChina.IT.BI
 * @version 创建时间：2014-9-26 下午5:01:07
 */
public class UserService {
	private UserDao userDao = null;
	private UserDao getUserDao(){
		if(userDao == null){
			userDao = new UserDaoImpl();
		}
		return userDao;
	}
	/**
	 * 测试方法（实现为空方法，返回null）
	 * 
	 * @return
	 */
	public List<User> getUser(){
		return null;
	}
	/**
	 * 获取注册时间大于14天的用户
	 * 
	 * @return
	 */
	public List<User> getRegD14Days() {
		return getUserDao().getRegD14Days();
	}
	/**
	 * 分页查询注册时间大于14天的用户
	 * 
	 * @param page
	 * @param perRows
	 * @return
	 */
	public List<User> getRegD14Days(int page, int perRows) {
		return getUserDao().getRegD14Days(page, perRows);
	}
	/**
	 * 获取注册时间大于7天小于14天的用户
	 * 
	 * @return
	 */
	public List<User> getRegD7L14Days() {
		return getUserDao().getRegD7L14Days();
	}
	/**
	 * 分页查询注册时间大于7天小于14天的用户数据
	 * 
	 * @param page
	 * @param perRows
	 * @return
	 */
	public List<User> getRegD7L14Days(int page, int perRows) {
		return getUserDao().getRegD7L14Days(page, perRows);
	}
	/**
	 * 分页查询订单为2且十天未下单的用户
	 * 
	 * @param page
	 * @param perRows
	 * @return
	 */
	public List<User> getOrder2No10Days(int page, int perRows) {
		return getUserDao().getOrder2No10Days(page, perRows);
	}
	/**
	 * 获取目前订单为2且十天内未下单的用户
	 * 
	 * @return
	 */
	public List<User> getOrder2No10Days() {
		return getUserDao().getOrder2No10Days();
	}
	/**
	 * 分页查询订单为4的用户的数据
	 * 
	 * @param page
	 * @param perRows
	 * @return
	 */
	public List<User> get4Orders(int page, int perRows) {
		return getUserDao().get4Orders(page, perRows);
	}
	/**
	 * 获取用户订单数量为4的用户的成数据
	 * 
	 * @return
	 */
	public List<User> get4Orders() {
		return getUserDao().get4Orders();
	}
	/**
	 * 分页查询根据用户注册时间用户自定义查询数据
	 * 
	 * @param day1
	 * @param day2
	 * @param page
	 * @param i
	 * @return
	 */
	public List<User> getRegUserDefined(int day1, int day2, int page, int i) {
		return getUserDao().getRegUserDefined(day1, day2, page, i);
	}
	/**
	 * 获取根据用户注册时间用户自定义查询的数据
	 * 
	 * @param day1
	 * @param day2
	 * @return
	 */
	public List<User> getRegUserDefined(int day1, int day2) {
		return getUserDao().getRegUserDefined(day1, day2);
	}
	/**
	 * 分页查询根据订单数量用户自定义查询数据
	 * 
	 * @param num
	 * @param day
	 * @param page
	 * @param i
	 * @return
	 */
	public List<User> getOrderUserDefined(int num, int day, int page, int i) {
		return getUserDao().getOrderUserDefined(num, day, page, i);
	}
	/**
	 * 获取根据用户订单数量自定义查询的数据
	 * 
	 * @param num
	 * @param day
	 * @return
	 */
	public List<User> getOrderUserDefined(int num, int day) {
		return getUserDao().getOrderUserDefined(num, day);
	}
	/**
	 * 分页查询根据订单数量（大于）用户自定义查询数据
	 * 
	 * @param num
	 * @param day
	 * @param page
	 * @param i
	 * @return
	 */
	public List<User> getOrderBiggerUserDefined(int num, int page, int i) {
		return getUserDao().getOrderBiggerUserDefined(num, page, i);
	}
	/**
	 * 获取根据用户订单数量（大于）自定义查询的数据
	 * 
	 * @param num
	 * @param day
	 * @return
	 */
	public List<User> getOrderBiggerUserDefined(int num) {
		return getUserDao().getOrderBiggerUserDefined(num);
	}
	/**
	 * 获取注册日期大于14天的用户的总数
	 * 
	 * @return
	 */
	public int getRegD14DaysNum() {
		return getUserDao().getRegD14DaysNum();
	}
	/**
	 * 获取根据订单数量（大于）用户自定义查询的数据的总数
	 * 
	 * @param num
	 * @param day
	 * @return
	 */
	public int getOrderBiggerUserDefinedNum(int day1) {
		return getUserDao().getOrderBiggerUserDefinedNum(day1);
	}
	/**
	 * 获取订单数为2且十天内未下单的用户的总数
	 * 
	 * @return
	 */
	public int getOrder2No10DaysNum() {
		return getUserDao().getOrder2No10DaysNum();
	}
	/**
	 * 获取用户订单数量为4的用户总数
	 * 
	 * @return
	 */
	public int get4OrdersNum() {
		return getUserDao().get4OrdersNum();
	}
	/**
	 * 获取根据订单数量用户自定义查询的数据的总数
	 * 
	 * @param num
	 * @param day
	 * @return
	 */
	public int getOrderUserDefinedNum(int day1, int day2) {
		return getUserDao().getOrderUserDefinedNum(day1, day2);
	}
	/**
	 * 获取根据注册时间用户自定义查询的用户的总数
	 * 
	 * @param day1
	 * @param day2
	 * @return
	 */
	public int getRegUserDefinedNum(int day1, int day2) {
		return getUserDao().getRegUserDefinedNum(day1, day2);
	}
	/**
	 * 获取注册日期大于7天小于14天的用户总数
	 * 
	 * @return
	 */
	public int getRegD7L14DaysNum() {
		return getUserDao().getRegD7L14DaysNum();
	}
}
