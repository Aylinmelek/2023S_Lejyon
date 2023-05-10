package domain;

public class DieObserver extends Observer{
	
	public DieObserver(Subject subject){
	      this.subject = subject;
	      this.subject.attach(this);
	   }

	@Override
	public void update() {
		// TODO Auto-generated method stub
		System.out.println( "Die Value" + subject.getState() );
	}
	
}
