package tut6;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

public class Tut6Sender {
	@RabbitListener(queues= "tut.rpc.request")
	
	//@SendTo(:tut.rpc.replies") ued when the cleint 
	//doesn't set replyTo
	
	public 
	int fibonacci(int n) {
		System.out.println("[X] Received request for " +n);
		int result = fib(n);
		System.out.println( " [.] Returned " + result);
		return result;
	}
	
	public
	int fib(int n)
	{
		return n == 0 ? 0 : n == 1? 1: (fib(n-1) + fib(n-2));
	}
}
