package database;

import domain.controller.ConKUerorHandler;

public interface ISaveLoadAdapter {
	void save(ConKUerorHandler conKUerorhandler);

	ConKUerorHandler load(String username);
}
