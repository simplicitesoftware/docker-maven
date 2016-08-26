package com.simplicite.tomcat;

import java.io.File;
import java.io.FileOutputStream;

import org.apache.catalina.startup.Tomcat;

public class Launcher {
        private int port = 8080;
        private String rootPath = "webapps/ROOT";

        public Launcher() throws Exception {
        }

        public void launch() throws Exception {
                Tomcat tomcat = new Tomcat();

                File f = new File("").getAbsoluteFile();
                tomcat.setBaseDir(f.getAbsolutePath());
                tomcat.getServer().setCatalinaHome(f);
                tomcat.getServer().setCatalinaBase(f);
                System.out.println("--- Tomcat home and base dirs set to [" + tomcat.getServer().getCatalinaHome() + "]");

                tomcat.enableNaming();

                tomcat.setPort(port);
                System.out.println("--- Tomcat port set to [" + port + "]");

                File root= new File(rootPath);
                String rootAbsPath = root.getAbsolutePath();
                System.out.print("--- Looking for ROOT webapp in [" + rootAbsPath + "]... ");
                if (!root.exists()) throw new Exception("Missiing ROOT webapp");
                System.out.println("Done");

                System.out.print("--- Deploying ROOT webapp... ");
                tomcat.addWebapp("", rootAbsPath);
                System.out.println("Done");

                tomcat.start();

                Runtime.getRuntime().addShutdownHook(new Thread() {
                        @Override
                        public void run() {
                                System.out.print("--- Closing... ");
                                System.out.println("Done");
                        }
                });

                tomcat.getServer().await();
        }

        public static void main(String[] args) {
                try {
                        new Launcher().launch();
                } catch (Exception e) {
                        e.printStackTrace();
                }
        }
}
