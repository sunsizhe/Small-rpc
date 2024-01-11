package com.sun.remoting.message;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RpcRequest  implements Serializable {
    //接口名字
    private String interfaceName;
    //方法名字
    private String methodName;
    //方法的所有参数的真实值
    private Object[] parameters;
    //方法的所有参数类型
    private Class<?>[] paramTypes;
}
