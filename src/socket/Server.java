package socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collection;

/**
 * 聊天室服务端
 * @author ta
 *
 */
public class Server {
	/*
	 * 运行在服务端的ServerSocket
	 * 有两个作用
	 * 1:向系统申请服务端口，客户端就是通过
	 *   这个端口与服务端程序建立连接的。
	 *   
	 * 2:监听该端口，当客户端通过该端口与服务端
	 *   建立连接时会自动创建一个Socket。通过
	 *   这个Socket与客户端进行数据交互。  
	 */
	private ServerSocket server;
	/*
	 * 该数组用于保存所有ClientHandler内部
	 * 对应客户端的输出流，以便广播消息。
	 * 
	 * 由于内部类可以访问其对应外部类的属性，
	 * 对此我们在Server中定义该数组，所有的
	 * 内部类ClientHandler都可以看到它。这样
	 * 将这些ClientHandler需要共享的数据存入
	 * 这个数组即可。
	 */
//	private PrintWriter[] allOut = {};
	private Collection<PrintWriter> allOut
				= new ArrayList<PrintWriter>();
	
	public Server() {
		try {
			/*
			 * 实例化ServerSocket的同时向系统
			 * 申请服务端口，该端口不能与系统
			 * 运行的其他应用程序相同，否则会
			 * 抛出地址被占用的异常
			 */
			System.out.println("正在启动服务端...");
			server = new ServerSocket(8088);
			System.out.println("服务端启动完毕!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void start() {
		try {
			/*
			 * ServerSocket有一个重要的方法:
			 * Socket accept()
			 * 该方法是一个阻塞方法，调用后程序就在
			 * 这里"卡住了"，这时开始监听服务端口等
			 * 待客户端的连接。那么当客户端通过端口
			 * 尝试连接时，accept会返回一个Socket，
			 * 通过该Socket就可以与刚建立连接的客户
			 * 端进行交互了
			 */
			while(true) {
				System.out.println("等待客户端连接...");
				Socket socket = server.accept();
				System.out.println("一个客户端连接了!");
				//启动一个线程来处理该客户端
				ClientHandler handler 
					= new ClientHandler(socket);
				Thread t = new Thread(handler);
				t.start();
			}	
				
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		Server server = new Server();
		server.start();
	}
	/**
	 * 该线程任务是与指定的Socket对应的客户端
	 * 进行数据交互
	 * @author ta
	 *
	 */
	private class ClientHandler 
						implements Runnable{
		private Socket socket;
		
		//记录当前客户端的地址信息
		private String host;
		
		public ClientHandler(Socket socket) {
			this.socket = socket;
			/*
			 * 通过Socket获取远端计算机地址
			 * 信息(对于服务端而言，远端就是
			 * 客户端了)
			 */
			InetAddress address = socket.getInetAddress();
			host = address.getHostAddress();
		}
		
		public void run() {
			System.out.println("启动了一个线程处理客户端信息!");
			PrintWriter pw = null;
			try {
				/*
				 * 通过Socket获取输入流，读取客户端发送
				 * 过来的数据
				 */
				InputStream in 
					= socket.getInputStream();
				InputStreamReader isr
					= new InputStreamReader(in,"UTF-8");
				BufferedReader br
					= new BufferedReader(isr);
				/*
				 * 通过Socket获取输出流，给该客户端
				 * 发送消息
				 */
				OutputStream out 
					= socket.getOutputStream();
				OutputStreamWriter osw
					= new OutputStreamWriter(out,"UTF-8");
				BufferedWriter bw
					= new BufferedWriter(osw);
				
				pw	= new PrintWriter(bw,true);
				/*
				 * 将当前ClientHandler对应客户端的
				 * 输出流存入到allOut数组中。以便其
				 * 他ClientHandler在接收消息后可以
				 * 将消息发送给当前客户端。
				 */
				synchronized (allOut) {
//					//1先对allOut数组扩容
//					allOut = Arrays.copyOf(allOut, allOut.length+1);
//					//2将当前的pw存入到数组最后一个位置上
//					allOut[allOut.length-1] = pw;
					
					allOut.add(pw);
				}
				
				String message = null;
				while((message = br.readLine())!=null) {
					System.out.println(host+"说:"+message);
					//将消息发送给当前客户端
//					pw.println("客户端说:"+message);
					/*
					 * 遍历allOut操作要和其他线程对该数组
					 * 的增删互斥。
					 */
					synchronized (allOut) {
						//遍历allOut，将消息发送给所有客户端
						for(PrintWriter o : allOut) {
							o.println(host+"说:"+message);
						}
					}
					
					
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				//处理客户端断开连接后的操作
				synchronized (allOut) {
					//将当前客户端的输出流pw从allOut数组中删除
//					for(int i=0;i<allOut.length;i++) {
//						if(allOut[i]==pw) {
//							//将最后一个元素放在这里
//							allOut[i] = allOut[allOut.length-1];
//							//缩容
//							allOut = Arrays.copyOf(allOut, allOut.length-1);
//							break;
//						}
//					}
					allOut.remove(pw);
				}
				
				
				//将socket关闭
				try {
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
}








