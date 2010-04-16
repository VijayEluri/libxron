// Author: Ben Page [ug73bxp] 
package org.xron.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 *
 * @author Ben Page [ug73bxp@cs.bham.ac.uk]
 */
public class GetLine {

    BufferedReader in;

    public GetLine() {
        this(new InputStreamReader(System.in));
    }

    public GetLine(Reader r) {
        in = new BufferedReader(r);
    }

    public void pause() {
        pause("[PRESS ENTER TO CONTINUE]");
    }

    public void pause(String msg) {
        try {
            System.out.println(msg);
            in.readLine();
        } catch (IOException ex) {
            System.out.println("INFO: libxron GetLine.pause Ignored exception: " + ex);
        }
    }
}
