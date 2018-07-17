package cn.ben.test.clazz;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @TIME 2018/6/25 9:51
 * @User yangkun
 * @DESCRIPTION
 */
@Setter
@Getter
@ToString
public class AbstractClass implements Serializable {
    private static final long serialVersionUID = 1857566798042715971L;
    private String code;
}
