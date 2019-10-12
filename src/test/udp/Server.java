package test.udp;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;


public class Server {
	
	public static StringBuilder data(byte[] a) {
		// TODO Auto-generated method stub
		if(a == null)
			return null;
		StringBuilder ret = new StringBuilder();
		int i = 0;
		
		while(a[i] != 0) {
			ret.append((char) a[i]);
			i++;
		}
		return ret;
	}

	public static void main(String [] args) throws IOException {
		DatagramSocket ds = new DatagramSocket(1234);
		byte[] receive = new byte[65535];
		DatagramPacket DpReceive = null;
		
		while(true) {
			DpReceive = new DatagramPacket(receive, receive.length);
			ds.receive(DpReceive);
			
			System.out.println("Client: " + data(receive));
			
			if(data(receive).toString().equals("REQUEST")) {
				System.out.println("A Request is made");
				
				//THIS PART
				
//				ByteArrayInputStream in = new ByteArrayInputStream(receive);
//				ObjectInputStream is = new ObjectInputStream(in);
//				try {
//					RBMS booking = (RBMS) is.readObject();
//					System.out.println("Student object received = "+booking);
//					} catch (ClassNotFoundException e) {
//					e.printStackTrace();
//					}
				
				
				// Create object to store request
//				ObjectInputStream iStream = new ObjectInputStream(new ByteArrayInputStream(receive));
//				Message messageClass = (Message) iStream.readObject();
//				iStream.close();
			}
			
			if(data(receive).toString().equals("bye")) {
				System.out.println("Client sent bye... exiting");
				break;
			}
			receive = new byte[65535];
		}
	}

	
}
