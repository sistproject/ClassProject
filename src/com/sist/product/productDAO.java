package com.sist.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import com.sist.jdbc.*;

public class productDAO {
	private DAOManager dm = new DAOManager();
	private Connection conn;
	private PreparedStatement ps;
}
