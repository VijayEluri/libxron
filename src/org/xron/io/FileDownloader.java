
package org.xron.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;

/**
 *
 * @author ben
 */
public class FileDownloader {

    public static void main(String[] args) throws MalformedURLException, IOException, FileNotFoundException {
        System.out.println("Starting FileDownloader test 1");
//        URL google = new URL("http://www.google.it");
//
//        ReadableByteChannel rbc = Channels.newChannel(google.openStream());
//        FileOutputStream fos = new FileOutputStream("google.html");
//
//        fos.getChannel().transferFrom(rbc, 0, 1 << 24);
        downloadURLByStream(new URL("http://en40.tribalwars.net/map/village.txt"), new File("villages.txt"));
    }


    /**
     *
     * @param source
     * @param dest
     * @deprecated Doesn't actually work right now...
     * @return
     */
    public static boolean downloadURLByNIO(URL source, File dest) {
        System.out.println("Begin Download: "+source);


        try {
            ReadableByteChannel rbc = Channels.newChannel(source.openStream());
            FileOutputStream fos = new FileOutputStream(dest);
            FileChannel outputChannel = fos.getChannel();

            long transferred;
            do {
                System.out.println("callingTransferFrom");
                transferred = outputChannel.transferFrom(rbc, 0, 1 << 24);
                System.out.println("Transferred " + transferred);
            } while (transferred != 0);

        } catch (IOException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

        public static boolean downloadURLByStream(URL source, File dest) {
        System.out.println("Begin Download: "+source);

        try {
            ReadableByteChannel rbc = Channels.newChannel(source.openStream());
            FileOutputStream fos = new FileOutputStream(dest);
            FileChannel outputChannel = fos.getChannel();

            long transferred;
            do {
                System.out.println("callingTransferFrom");
                transferred = outputChannel.transferFrom(rbc, 0, 1 << 24);
                System.out.println("Transferred " + transferred);
            } while (transferred != 0);

        } catch (IOException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }
}
