import com.sun.bean.HelloService;
import com.sun.bean.HelloServiceImpl;
import com.sun.remoting.transport.proxy.RpcClientProxy;
import org.junit.Test;

public class ApiTest {

    @Test
    public void test1(){
        //HelloService helloService = new HelloServiceImpl();
        RpcClientProxy rpcClientProxy = new RpcClientProxy("127.0.0.01", 7397);
        HelloService proxy = rpcClientProxy.getProxy(HelloService.class);//代理目标类-> 触发远程调用
        proxy.hello("this is client \r\n");
    }
}
