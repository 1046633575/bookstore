package cn.itcast.bookstore.cart.domain;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 购物车类
 * @author Administrator
 *
 */
public class Cart {
	private Map<String,CartItem> map = new LinkedHashMap<String,CartItem>();
	
	/**
	 * 计算合计
	 * @return
	 */
	public double getTotal() {
		//合计=所有条目的小计之和
		BigDecimal total = new BigDecimal("0");//BigDecimal为了防止二进制计算误差
		for(CartItem cartItem : map.values()) {
			BigDecimal subtotal = new BigDecimal("" + cartItem.getSubtotal());
			total = total.add(subtotal);
		}
		return total.doubleValue();
	}
	
	/**
	 * 添加条目
	 * @param cartItem
	 */
	public void add(CartItem cartItem) {
		if(map.containsKey(cartItem.getBook().getBid())) {//判断原来车中是否存在该条目
			CartItem _cartItem = map.get(cartItem.getBook().getBid());//返回原条目
			_cartItem.setCount(_cartItem.getCount() + cartItem.getCount());//设置老条目的数量为，其原数量+新条目的数量
			map.put(cartItem.getBook().getBid(), _cartItem);
		} else {
			map.put(cartItem.getBook().getBid(), cartItem);
		}
	}
	
	/**
	 * 清空所有条目
	 */
	public void clear() {
		map.clear();
	}
	
	/**
	 * 删除制定条目
	 * @param bid
	 */
	public void delete(String bid) {
		map.remove(bid);
	}
	
	/**
	 * 获取所有条目
	 * @return
	 */
	public Collection<CartItem> getCartItems(){
		return map.values();
	}
}
