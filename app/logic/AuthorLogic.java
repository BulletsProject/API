package logic;

import java.util.List;

import models.Author;

public class AuthorLogic {

	public List<Author> getAuthors() {
		return Author.find.all();
	}
	
}
