import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Date;

public class DateClient {

//	local proxy
	protected static RemoteDate netConnection = null;
	
	public static void main(String[] args) {
		Registry registry = null;
		try {
			registry = LocateRegistry.getRegistry(RemoteDate.PORT_NUMBER);
			netConnection = (RemoteDate) registry.lookup(RemoteDate.LOOKUPNAME);
			Date today = netConnection.getRemoteDate();
			System.out.println(today.toString());
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Client Exception: " + e);
		}
		
		
		
		
	}
}
