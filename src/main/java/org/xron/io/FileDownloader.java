package org.xron.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;

/**
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
    downloadURLByNIO(new URL("http://en40.tribalwars.net/map/village.txt"), new File("villages2.txt"));
  }

  /**
   * @param source
   * @param dest
   * @return
   * @deprecated Works, but with no status that it is working on hugeass files
   */
  public static boolean downloadURLByNIO(URL source, File dest) {
    System.out.println("Begin Download: " + source);


    try {
      ReadableByteChannel rbc = Channels.newChannel(source.openStream());
      FileOutputStream fos = new FileOutputStream(dest);
      FileChannel outputChannel = fos.getChannel();

      long transferred;
//            do {
      System.out.println("callingTransferFrom");
      transferred = outputChannel.transferFrom(rbc, 0, 1 << 24); // ~.8 gig files or larger will kill me
      System.out.println("Transferred " + transferred);
//            } while (transferred != 0);

    } catch (IOException ex) {
      ex.printStackTrace();
      return false;
    }
    return true;
  }

  public static boolean downloadURLByStream(URL source, File dest) throws IOException {
    System.out.println("Begin Download: " + source);

    URLConnection con;
//        UID uid = new UID(); //wha?

    con = source.openConnection();
    con.connect();

    String type = con.getContentType();
    int lenght = con.getContentLength();
    System.out.println(type);

    if (type != null) {
      byte[] buffer = new byte[4 * 1024];
      int read;

//            String[] split = type.split("\"");
//            String theFile = Integer.toHexString(uid.hashCode()) + "_" + split[split.length - 1];

      FileOutputStream os = new FileOutputStream(dest);
      InputStream in = con.getInputStream();

      int readSoFar = 0;
      while ((read = in.read(buffer)) > 0) {
        os.write(buffer, 0, read);
        readSoFar += read;
        System.out.println(readSoFar + "/" + lenght);
      }

      os.close();
      in.close();

      return true;
    } else {
      return false;
    }

  }
}
