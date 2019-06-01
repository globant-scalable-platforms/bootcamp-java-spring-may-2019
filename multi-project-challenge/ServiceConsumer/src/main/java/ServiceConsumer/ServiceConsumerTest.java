package ServiceConsumer;

import com.messagelibrary.utils.MessageProvider;

public class ServiceConsumerTest {

	public static void main(String[] args) {
		
		MessageProvider messageProvider = new MessageProvider();
		
		System.out.println("Message from provider: " + messageProvider.getMessage());

	}

}
