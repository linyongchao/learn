package my.learn.book.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.mysql.jdbc.Statement;

import my.learn.book.dao.BookDb;
import my.learn.book.modal.Book;
import my.learn.jdbc.JdbcUtils;

public class BookDbImpl implements BookDb {

	@Override
	public long insertName(String name) {
		Map<String, Object> map = new HashMap<>();
		map.put("name", name);
		return insert("tb_book_name", map);
	}

	@Override
	public long insertTitle(long bookId, String title) {
		Map<String, Object> map = new HashMap<>();
		map.put("name_id", bookId);
		map.put("title", title);
		return insert("tb_book_title", map);
	}

	@Override
	public long insertContext(long titleId, String context) {
		Map<String, Object> map = new HashMap<>();
		map.put("title_id", titleId);
		map.put("context", context);
		return insert("tb_book_context", map);
	}

	@Override
	public long existName(String name) {
		String sql = "select id from tb_book_name where name = '" + name + "'";
		return exist(sql);
	}

	@Override
	public long existTitle(long bookId, String title) {
		String sql = "select id from tb_book_title where name_id = " + bookId + " and title = '" + title + "'";
		return exist(sql);
	}

	@Override
	public long existContext(long titleId) {
		String sql = "select id from tb_book_context where title_id = " + titleId + " and context is not null";
		return exist(sql);
	}

	@Override
	public List<Book> getBook(Long bookId) {
		String sql = "select name,title,context from tb_book_name b, tb_book_title t,tb_book_context c where b.id = t.name_id and t.id = c.title_id and b.id = ?";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Book> list = new ArrayList<>();
		try {
			conn = JdbcUtils.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setLong(1, bookId);
			rs = ps.executeQuery();
			while (rs.next()) {
				Book book = new Book();
				book.setName(rs.getString(1));
				book.setTitle(rs.getString(2));
				book.setContext(rs.getString(3));
				list.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(conn, ps, rs);
		}
		return list;
	}

	private long insert(String dbname, Map<String, Object> map) {
		StringBuffer keys = new StringBuffer();
		StringBuffer vals = new StringBuffer();
		for (Entry<String, Object> entry : map.entrySet()) {
			keys.append(entry.getKey()).append(",");
			vals.append("'").append(entry.getValue()).append("',");
		}
		keys.deleteCharAt(keys.length() - 1);
		vals.deleteCharAt(vals.length() - 1);
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		long result = 0;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "insert into " + dbname + " (" + keys.toString() + ") values (" + vals.toString() + ")";
			ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.executeUpdate();
			rs = ps.getGeneratedKeys();
			if (rs.next()) {
				result = rs.getLong(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(conn, ps, rs);
		}
		return result;
	}

	private long exist(String sql) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		long id = 0;
		try {
			conn = JdbcUtils.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			if (rs.next()) {
				id = rs.getLong(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(conn, ps, rs);
		}
		return id;
	}

}
