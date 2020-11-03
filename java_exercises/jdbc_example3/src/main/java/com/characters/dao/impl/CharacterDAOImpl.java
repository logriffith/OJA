package com.characters.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.characters.dao.CharacterDAO;
import com.characters.dbutil.PostgresSqlConnection;
import com.characters.exception.BusinessException;
import com.characters.model.FictionalCharacter;

public class CharacterDAOImpl implements CharacterDAO{

	@Override
	public int createCharacter(FictionalCharacter fictionalCharacter) throws BusinessException {
		int c = 0;
		try (Connection connection = PostgresSqlConnection.getConnection()){
			String sql = CharacterQueries.INSERT_CHARACTER;
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, fictionalCharacter.getId());
			preparedStatement.setString(2, fictionalCharacter.getName());
			preparedStatement.setString(3, fictionalCharacter.getAlias());
			c = preparedStatement.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);//remove when ready for production
			throw new BusinessException("Internal error has occurred. Please contact the system administrator");
		}
		return c;
	}

	@Override
	public void deleteCharacter(int id) throws BusinessException {
		try(Connection connection = PostgresSqlConnection.getConnection()){
			String sql = CharacterQueries.DELETE_CHARACTER;
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);
			throw new BusinessException("Internal error has occurred. Please contact the system administrator");
		}
	}

	@Override
	public int updateCharacterAlias(int id, String newAlias) throws BusinessException {
		int c = 0;
		try (Connection connection = PostgresSqlConnection.getConnection()){
			String sql = CharacterQueries.UPDATE_CHARACTER_ALIAS;
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, newAlias);
			preparedStatement.setInt(2, id);
			c = preparedStatement.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);
			throw new BusinessException("Internal error has occurred. Please contact the system administrator");
		}
		return c;
	}

	@Override
	public int updateCharacterName(int id, String newName) throws BusinessException {
		int c = 0;
		try (Connection connection = PostgresSqlConnection.getConnection()){
			String sql = CharacterQueries.UPDATE_CHARACTER_NAME;
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, newName);
			preparedStatement.setInt(2, id);
			c = preparedStatement.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);
			throw new BusinessException("Internal error has occurred. Please contact the system administrator");
		}
		return c;
	}

	@Override
	public FictionalCharacter findCharacterByID(int id) throws BusinessException {
		FictionalCharacter fictionalCharacter = null;
		try(Connection connection = PostgresSqlConnection.getConnection()){
			String sql = CharacterQueries.FIND_CHARACTER_BY_ID;
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				fictionalCharacter = new FictionalCharacter(id, resultSet.getString("name"), resultSet.getString("alias"));
			}else {
				throw new BusinessException("There is no character by the ID = "+ id);
			}
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);
			throw new BusinessException("Internal error has occurred. Please contact the system administrator");
		}
		return fictionalCharacter;
	}

	@Override
	public FictionalCharacter findCharacterByName(String name) throws BusinessException {
		FictionalCharacter fictionalCharacter = null;
		try(Connection connection = PostgresSqlConnection.getConnection()){
			String sql = CharacterQueries.FIND_CHARACTER_BY_NAME;
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, name);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				fictionalCharacter = new FictionalCharacter(resultSet.getInt("id"), name, resultSet.getString("alias"));
			}else {
				throw new BusinessException("There is no character by the name "+ name);
			}
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);
			throw new BusinessException("Internal error has occurred. Please contact the system administrator");
		}
		return fictionalCharacter;
	}

	

}
