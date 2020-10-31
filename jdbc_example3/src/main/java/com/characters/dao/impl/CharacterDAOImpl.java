package com.characters.dao.impl;

import com.characters.dao.CharacterDAO;
import com.characters.exception.BusinessException;

public class CharacterDAOImpl implements CharacterDAO{

	@Override
	public int createCharacter(Character character) throws BusinessException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteCharacter(int id) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int updateCharacterAlias(int id, String newAlias) throws BusinessException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateCharacterName(int id, String newName) throws BusinessException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Character findCharacterByID(int id) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Character findCharacterByName(String name) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

}
