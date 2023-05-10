package domain;

public class PlayerObserver extends Observer{
	public PlayerObserver(Subject subject){
	      this.subject = subject;
	      this.subject.attach(this);
	   }

	@Override
	public void update() {
		// TODO Auto-generated method stub
		System.out.println( "Player Number" + subject.getState() );
	}
}
