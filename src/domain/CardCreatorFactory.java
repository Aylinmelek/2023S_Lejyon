package domain;

public class CardCreatorFactory {
	public Object CardCreate(int i)
	{
		if(i == 0)
		{
			
			DiplomaticImmunityCard diplomaticImmunity =  new DiplomaticImmunityCard();
			return (Object) diplomaticImmunity;
		}
		else if(i == 1)
		{
			sabotageCard sabotage = new sabotageCard();
			return (Object) sabotage;
		}
		else if(i == 2)
		{
			SpyCard spyCard = new SpyCard();
			return (Object) spyCard;
		}
		else if(i == 3)
		{
			ReinforcementCard reinforcementCard = new ReinforcementCard();
			return (Object) reinforcementCard;
		}
		else if(i == 4)
		{
			WorldEventCard worldEventCard = new WorldEventCard();
			return (Object) worldEventCard;
		}
		else
		{
			DisasterCard disasterCard= new DisasterCard();
			return (Object) disasterCard;
		}
		
	}
}
