package com.sist.class_;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.sist.jdbc.*;

public class ClassDAO {
	private DAOManager dm = new DAOManager();
	private Connection conn;
	private PreparedStatement ps;
}
