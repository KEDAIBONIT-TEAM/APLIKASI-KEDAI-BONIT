/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugasbesar.kedaibonit.error;

/**
 *
 * @author CarakaMR
 */
public class CatatUtangException extends Exception {

    /**
     * Creates a new instance of <code>CatatUtangException</code> without detail
     * message.
     */
    public CatatUtangException() {
    }

    /**
     * Constructs an instance of <code>CatatUtangException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public CatatUtangException(String msg) {
        super(msg);
    }
}
