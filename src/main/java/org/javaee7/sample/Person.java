package org.javaee7.sample;

import lombok.Data;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author arungupta
 */

@Data
@XmlRootElement
public class Person {
    private String name;
    public Person(String name) {
        this.name = name;
    }
}