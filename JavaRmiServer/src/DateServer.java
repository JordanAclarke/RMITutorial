import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class DateServer {

	public static void main(String[] args) {
		
//		System.setSecurityManager(new SecurityManager());
		
		try {
			RemoteDateImpl im = new RemoteDateImpl();
			System.out.println("Date Server Starting");
			
			Registry registry = LocateRegistry.createRegistry(RemoteDate.PORT_NUMBER);
			registry.rebind(RemoteDate.LOOKUPNAME, im);
			
			System.out.println("Date Server is ready");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Server Exception: " + e);
		}
		
		
	}
}
