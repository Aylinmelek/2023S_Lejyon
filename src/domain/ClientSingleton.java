package domain;

import java.util.Random;

import domain.cardService.ICardServiceAdapter;
import domain.serviceFactory.CardServiceFactory;

public class ClientSingleton {
		private ICardServiceAdapter storageService;
		
		private ClientSingleton(String serviceUsed) {
			storageService = CardServiceFactory.getInstance().getCardServiceAdapter(serviceUsed);
			
			//name of the factory + getInstance() + getService
		}
		
		public int rollDie() {
			Random random = new Random();
			int faceValue = random.nextInt(6);
			return faceValue+1;
		}
}
