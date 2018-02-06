package my.learn.book.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.mysql.jdbc.Statement;

import my.learn.book.dao.BookDb;
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
			JdbcUtils.close(conn, ps, null);
		}
		return result;
	}

}
