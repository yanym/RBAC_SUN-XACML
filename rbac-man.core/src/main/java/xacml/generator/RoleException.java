package xacml.generator;

public class RoleException extends XacmlEntityException{

	public RoleException(){
		super();
	}
	
	public RoleException(String message){
		super(message);
	}
	
	public RoleException(Throwable t){
		super(t);
	}
}
