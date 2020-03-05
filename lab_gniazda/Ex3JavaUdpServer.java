import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Arrays;
import java.net.InetAddress;
import java.nio.ByteBuffer;


public class Ex3JavaUdpServer {

    public static void main(String args[])
    {
        System.out.println("JAVA UDP SERVER");
        DatagramSocket socket = null;
        int portNumber = 9008;
        int clientPort = 9009;

        try{
            socket = new DatagramSocket(portNumber);
            byte[] receiveBuffer = new byte[1024];

            while(true) {
                Arrays.fill(receiveBuffer, (byte)0);java
                DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
                socket.receive(receivePacket);
                int reveivedNum = ByteBuffer.wrap(receiveBuffer).getInt();
                int num = Integer.reverseBytes(reveivedNum);
                System.out.println("received num: ");
                System.out.println(num);

                InetAddress address = InetAddress.getByName("localhost");
                byte[] buff = ByteBuffer.allocate(4).putInt(num + 1).array();
                DatagramPacket sendPacket = new DatagramPacket(buff, buff.length, address, clientPort);
                socket.send(sendPacket);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally {
            if (socket != null) {
                socket.close();
            }
        }
    }
}
