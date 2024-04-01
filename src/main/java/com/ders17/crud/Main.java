package com.ders17.crud;

public class Main {
	public static void main(String[] args) {

		Insert insert = new Insert();
		insert.run();

		Select select = new Select();
		select.run();

		Update update = new Update();
		update.run();

		select.run();

		Delete deletemethod = new Delete();
		deletemethod.run();
		
		select.run();

	}

}
