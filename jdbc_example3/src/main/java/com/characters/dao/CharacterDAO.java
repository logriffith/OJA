package com.characters.dao;

import com.characters.exception.BusinessException;
import com.characters.model.FictionalCharacter;

//DAO - Data Access Object
//A DAO represents that all the code which is related  to your DB or persistence or
//storage will be written inside this.
public interface CharacterDAO {

	public int createCharacter(FictionalCharacter fictionalCharacter) throws BusinessException;
	
	public void deleteCharacter(int id) throws BusinessException;
	
	public int updateCharacterAlias(int id, String newAlias) throws BusinessException;
	
	public int updateCharacterName(int id, String newName) throws BusinessException;
	
	public FictionalCharacter findCharacterByID(int id) throws BusinessException;
	
	public FictionalCharacter findCharacterByName(String name) throws BusinessException;
	
}
