package xacml.generator;

public class SubjectIdException extends XacmlEntityException{

	public SubjectIdException(){
		super();
	}
	
	public SubjectIdException(String message){
		super(message);
	}
	
	public SubjectIdException(Throwable t){
		super(t);
	}
}
