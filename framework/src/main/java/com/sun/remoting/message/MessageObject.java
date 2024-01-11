package com.sun.remoting.message;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class MessageObject implements Serializable {
    private Integer id;
    private String message;

}
