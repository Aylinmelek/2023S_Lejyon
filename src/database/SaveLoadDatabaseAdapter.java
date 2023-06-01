package database;

import domain.controller.ConKUerorHandler;

public class SaveLoadDatabaseAdapter implements ISaveLoadAdapter {

	private SaveLoadDatabaseService save_service;

	public SaveLoadDatabaseAdapter() {
		save_service = new SaveLoadDatabaseService();
	}

	@Override
	public void save(ConKUerorHandler cont) {
		// TODO Auto-generated method stub
		save_service.saveGameDB(cont);
	}

	@Override
	public ConKUerorHandler load(String username) {
		// TODO Auto-generated method stub
		return save_service.loadGameDB(username);
	}

//	@Override
//	public void load(Controller cont) {
//		// TODO Auto-generated method stub
//
//	}

}
