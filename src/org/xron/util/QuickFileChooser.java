/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.xron.util;

import java.io.File;
import javax.swing.JFileChooser;

/**
 *
 * @author ben
 */
public class QuickFileChooser {

    /**
     * Todo: Error checking
     * @returns a file if the user picks one, unknown behavior if they dont
     */
    public static File getFile() {
        JFileChooser jfc = new JFileChooser();
        jfc.showOpenDialog(null);
        File selFile = jfc.getSelectedFile();
        return selFile;
    }
}
