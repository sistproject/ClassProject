package com.sist.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import com.sist.jdbc.*;

public class memberDAO {
	private DAOManager dm = new DAOManager();
	private Connection conn;
	private PreparedStatement ps;
}
