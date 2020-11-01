package com.characters.main;

import com.characters.dao.CharacterDAO;
import com.characters.dao.impl.CharacterDAOImpl;
import com.characters.exception.BusinessException;
import com.characters.model.FictionalCharacter;

public class CharacterMain {

	public static void main(String[] args) {
//		FictionalCharacter fictionalCharacter = new FictionalCharacter(151, "Billy", "SpongeBob");
		CharacterDAO characterDAO = new CharacterDAOImpl();
//		try {
//			characterDAO.createCharacter(fictionalCharacter);
//			System.out.println("Character has been created");
//		} catch (BusinessException e) {
//			System.out.println(e.getMessage());
//		}
		int id = 150;
		String name = "Clark Kent";
//		try {
//			characterDAO.deleteCharacter(id);
//			System.out.println("Character with the ID = "+ id+" was deleted");
//		} catch (BusinessException e) {
//			System.out.println(e.getMessage());
//		}
//		
//		try {
//			characterDAO.updateCharacterName(150, "Biden");
//			System.out.println("update was successfull");
//		} catch (BusinessException e) {
//			System.out.println(e.getMessage());
//		}
//		try {
//			FictionalCharacter fictionalCharacter = characterDAO.findCharacterByID(id);
//			System.out.println("Here is the character's details...");
//			System.out.println(fictionalCharacter);
//		} catch (BusinessException e) {
//			System.out.println(e.getMessage());
//		}
		try {
			FictionalCharacter fictionalCharacter = characterDAO.findCharacterByName(name);
			System.out.println("Here is the character's details...");
			System.out.println(fictionalCharacter);
		} catch (BusinessException e) {
			System.out.println(e.getMessage());
		}
	}

}
