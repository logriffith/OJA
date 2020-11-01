package com.characters.dao.impl;

public class CharacterQueries {

	public static final String INSERT_CHARACTER = "insert into test.characters_table (id,name,alias) values (?,?,?)";
	
	public static final String DELETE_CHARACTER = "delete from test.characters_table where id = ?";
	
	public static final String UPDATE_CHARACTER_ALIAS = "update test.characters_table set alias = ? where id = ?";
	
	public static final String UPDATE_CHARACTER_NAME = "update test.characters_table set name = ? where id = ?";
	
	public static final String FIND_CHARACTER_BY_ID = "select name,alias from test.characters_table where id = ?";
	
	public static final String FIND_CHARACTER_BY_NAME = "select id,alias from test.characters_table where name = ?";
}
